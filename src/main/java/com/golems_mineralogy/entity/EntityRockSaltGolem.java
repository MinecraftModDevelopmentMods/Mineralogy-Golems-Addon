package com.golems_mineralogy.entity;

import java.util.List;
import java.util.function.BiPredicate;

import com.golems.blocks.BlockUtilityGlow;
import com.golems.entity.EntityFurnaceGolem;
import com.golems.entity.GolemBase;
import com.golems.entity.ai.EntityAIUtilityBlock;
import com.golems.main.GolemItems;
import com.golems.util.GolemConfigSet;
import com.golems_mineralogy.init.MGolemNames;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class EntityRockSaltGolem extends MineralGolemBase {
	
	private static final DataParameter<Integer> CHARGE = EntityDataManager.createKey(EntityRockSaltGolem.class,
			DataSerializers.VARINT);
	private static final String KEY_CHARGE = "ChargeRemaining";
	private static final int MAX_CHARGE = 1000;
	
	public static final String ALLOW_SPECIAL = "Allow Special: Emit Light";
	public static final String FREQUENCY = "Light Frequency";
	
	public static final BiPredicate<GolemBase, IBlockState> LIT_PRED = 
			(golem, toReplace) -> golem.isProvidingLight();
			
	private boolean allowSpecial;

	public EntityRockSaltGolem(World world) {
		super(world, MGolemNames.ROCK_SALT);
		final GolemConfigSet cfg = getConfig(this);
		allowSpecial = cfg.getBoolean(ALLOW_SPECIAL);
		final IBlockState state = GolemItems.blockLightSource.getDefaultState()
				.withProperty(BlockUtilityGlow.LIGHT_LEVEL, 8);
		this.tasks.addTask(9, new EntityAIFadingGlow(this, state, cfg.getInt(FREQUENCY), 
				allowSpecial, EntityAIUtilityBlock.getDefaultBiPred(state).and(LIT_PRED)));
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		this.getDataManager().register(CHARGE, Integer.valueOf(0));
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if(this.isServerWorld()) {
			final int addCharge = (world.isDaytime() && world.canBlockSeeSky(this.getPosition().up())) ? 1 : -1;
			this.addCharge(addCharge);
		}
	}
	
	@Override
	public void readEntityFromNBT(final NBTTagCompound tag) {
		super.readEntityFromNBT(tag);
		this.setCharge(tag.getInteger(KEY_CHARGE));
	}
	
	@Override
	public void writeEntityToNBT(final NBTTagCompound tag) {
		super.writeEntityToNBT(tag);
		tag.setInteger(KEY_CHARGE, getCharge());
	}

	@Override
	public boolean isProvidingLight() {
		return allowSpecial && getCharge() > 0;
	}
	
	@Override
	public float getBrightness() {
		final float brightness = super.getBrightness();
		return isProvidingLight() ? Math.max(brightness, 0.5F) : brightness;
	}

	/** @return the current charge level as a number **/
	public int getCharge() {
		return this.getDataManager().get(CHARGE).intValue();
	}

	/** Set the current charge level **/
	public void setCharge(final int charge) {
		if (getCharge() != charge) {
			this.getDataManager().set(CHARGE, Integer.valueOf(charge));
		}
	}

	/** Add to the charge level. Checks lower and upper bounds first **/
	public void addCharge(final int toAdd) {
		int newCharge = getCharge() + toAdd;
		if (toAdd != 0 && newCharge >= 0 && newCharge <= MAX_CHARGE) {
			this.getDataManager().set(CHARGE, newCharge);
		}
	}
	
	@Override
	public List<String> addSpecialDesc(final List<String> list) {
		if (allowSpecial) {
			list.add(TextFormatting.GOLD + trans("entitytip.lights_area"));
		}
		return list;
	}
	
	class EntityAIFadingGlow extends EntityAIUtilityBlock {
		private final EntityRockSaltGolem rocksaltGolem;
		
		public EntityAIFadingGlow(EntityRockSaltGolem golemIn, IBlockState stateIn, int interval, 
				boolean configAllows, final BiPredicate<GolemBase, IBlockState> biPredicate) {
			super(golemIn, stateIn, interval, configAllows, biPredicate);
			rocksaltGolem = golemIn;
		}

		@Override
		protected  IBlockState getStateToPlace(final IBlockState toReplace) {
			float percentCharge = (float)rocksaltGolem.getCharge() / (float)MAX_CHARGE;
			int lightLevel = Math.min((int)Math.ceil(15.0F * percentCharge), 15);
			
			// DEBUG
			System.out.println("Golem charge=" + rocksaltGolem.getCharge() 
				+ "; percent=" + percentCharge + "; lightLevel=" + lightLevel);
			
			return GolemItems.blockLightSource.getDefaultState()
					.withProperty(BlockUtilityGlow.LIGHT_LEVEL, lightLevel);
		}
	}
}
