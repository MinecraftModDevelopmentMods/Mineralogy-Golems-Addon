package com.golems_mineralogy.entity;

import java.util.List;

import com.golems_mineralogy.init.MGolemNames;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityPhosphorousGolem extends MineralGolemBase {

public static final String ALLOW_SPECIAL = "Allow Special: Fire";
	
	private static final int FIRE_CHANCE = 510;
	
	private boolean allowBurn;
	
	public EntityPhosphorousGolem(World world) {
		super(world, MGolemNames.PHOSPHOROUS);
		this.allowBurn = getConfig(this).getBoolean(ALLOW_SPECIAL);
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		// randomly ignite
		if(allowBurn && !this.isBurning() && this.getRNG().nextInt(FIRE_CHANCE) == 0) {
			this.setFire(this.getRNG().nextInt(10) + 8);
		}
		// gradually lose health from burning, but not as fire damage
		if(this.isServerWorld() && this.isBurning() && this.getRNG().nextInt(100) == 0) {
			this.attackEntityFrom(DamageSource.GENERIC, 0.5F);
		}
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		// fire-resistant but still allows to render on fire
		return !source.isFireDamage() && super.attackEntityFrom(source, amount);
	}
	
	@Override
	public boolean attackEntityAsMob(final Entity entity) {
		if(super.attackEntityAsMob(entity)) {
			// sometimes light enemy on fire
			if(allowBurn && (this.isBurning() || this.getRNG().nextInt(4) == 0)) {
				entity.setFire(1 + rand.nextInt(4));
			}
			return true;
		}
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender() {
		return (int) (15728880F);
	}

	/**
	 * Gets how bright this entity is.
	 */
	@Override
	public float getBrightness() {
		return 1.0F;
	}
	
	@Override
	public List<String> addSpecialDesc(final List<String> list) {
		if(allowBurn) {
			list.add(TextFormatting.RED + trans("entitytip.combust_randomly"));
			list.add(TextFormatting.GOLD + trans("entitytip.lights_mobs_on_fire"));
		}
		return list;
	}
}
