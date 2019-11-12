package com.golems_mineralogy.entity;

import com.golems.entity.GolemBase;
import com.golems.util.GolemNames;
import com.golems_mineralogy.init.MGolemNames;
import com.golems_mineralogy.init.MineralogyGolems;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class MineralGolemBase extends GolemBase {
	
	protected final int particleDelay = 18;
	private String golemName = GolemNames.CLAY_GOLEM;

	public MineralGolemBase(final World world, final String name) {
		super(world);
		golemName = name;
		this.setTextureType(applyTexture());
		this.setLootTableLoc(MineralogyGolems.MODID, golemName);
		this.setKnockback(0.6D);
		this.setCanSwim(false);
	}

	@Override
	protected ResourceLocation applyTexture() {
		return makeTexture(MineralogyGolems.MODID, golemName);
	}

	@Override
	public SoundEvent getGolemSound() {
		return SoundEvents.BLOCK_STONE_STEP;
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (world.isRemote && getParticle() != null && this.getRNG().nextInt(Math.max(1, particleDelay)) == 0) {
			final double x = this.rand.nextDouble() - 0.5D * (double) this.width * 0.6D;
			final double y = this.rand.nextDouble() * (this.height - 0.5D) + 0.5D;
			final double z = this.rand.nextDouble() - 0.5D * (double) this.width * 0.6D;
			final double speedX = (this.rand.nextDouble() - 0.5D) * 0.4D;
			final double speedY = (this.rand.nextDouble() - 0.5D) * 0.4D;
			final double speedZ = (this.rand.nextDouble() - 0.5D) * 0.4D;
			this.world.spawnParticle(getParticle(), this.posX + x, this.posY + y, this.posZ + z,
				speedX, speedY, speedZ);
		}
	}
	
	protected EnumParticleTypes getParticle() {
		return null;
	}
	
	protected void setKnockback(final double knockbackResist) {
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(knockbackResist);
	}

	public static class EntityAmphiboliteGolem extends MineralGolemBase {
		public EntityAmphiboliteGolem(World world) {
			super(world, MGolemNames.AMPHIBOLITE);
		}
	}
	
	public static class EntityAndesiteGolem extends MineralGolemBase {
		public EntityAndesiteGolem(World world) {
			super(world, MGolemNames.ANDESITE);
		}
	}
	
	public static class EntityBasaltGolem extends MineralGolemBase {
		public EntityBasaltGolem(World world) {
			super(world, MGolemNames.BASALT);
			this.setImmuneToFire(true);
			this.setKnockback(0.85D);
		}
	}
	
	public static class EntityBasalticGlassGolem extends MineralGolemBase {
		public EntityBasalticGlassGolem(World world) {
			super(world, MGolemNames.BASALTIC_GLASS);
			this.setImmuneToFire(true);
		}
	}
	
	public static class EntityConglomerateGolem extends MineralGolemBase {
		public EntityConglomerateGolem(World world) {
			super(world, MGolemNames.CONGLOMERATE);
		}
	}
	
	public static class EntityDiabaseGolem extends MineralGolemBase {
		public EntityDiabaseGolem(World world) {
			super(world, MGolemNames.DIABASE);
			this.setImmuneToFire(true);
			this.setKnockback(0.8D);
		}
	}
	
	public static class EntityDioriteGolem extends MineralGolemBase {
		public EntityDioriteGolem(World world) {
			super(world, MGolemNames.DIORITE);
		}
	}
	
	public static class EntityDolomiteGolem extends MineralGolemBase {
		public EntityDolomiteGolem(World world) {
			super(world, MGolemNames.DOLOMITE);
		}
	}
	
	public static class EntityGabbroGolem extends MineralGolemBase {
		public EntityGabbroGolem(World world) {
			super(world, MGolemNames.GABBRO);
			this.setImmuneToFire(true);
			this.setKnockback(0.8D);
		}
	}
	
	public static class EntityGneissGolem extends MineralGolemBase {
		public EntityGneissGolem(World world) {
			super(world, MGolemNames.GNEISS);
			this.setImmuneToFire(true);
		}
	}
	
	public static class EntityGraniteGolem extends MineralGolemBase {
		public EntityGraniteGolem(World world) {
			super(world, MGolemNames.GRANITE);
		}
	}
	
	public static class EntityHornfelsGolem extends MineralGolemBase {
		public EntityHornfelsGolem(World world) {
			super(world, MGolemNames.HORNFELS);
		}
	}
	
	public static class EntityLimestoneGolem extends MineralGolemBase {
		public EntityLimestoneGolem(World world) {
			super(world, MGolemNames.LIMESTONE);
		}
	}
	
	public static class EntityMarbleGolem extends MineralGolemBase {
		public EntityMarbleGolem(World world) {
			super(world, MGolemNames.MARBLE);
		}
	}
	
	public static class EntityNovaculiteGolem extends MineralGolemBase {
		public EntityNovaculiteGolem(World world) {
			super(world, MGolemNames.NOVACULITE);
		}
	}
	
	public static class EntityPegmatiteGolem extends MineralGolemBase {
		public EntityPegmatiteGolem(World world) {
			super(world, MGolemNames.PEGMATITE);
			this.setImmuneToFire(true);
		}
	}
	
	public static class EntityPeridotiteGolem extends MineralGolemBase {
		public EntityPeridotiteGolem(World world) {
			super(world, MGolemNames.PERIDOTITE);
		}
	}
	
	public static class EntityPhylliteGolem extends MineralGolemBase {
		public EntityPhylliteGolem(World world) {
			super(world, MGolemNames.PHYLLITE);
		}
	}
	
	public static class EntityRhyoliteGolem extends MineralGolemBase {
		public EntityRhyoliteGolem(World world) {
			super(world, MGolemNames.RHYOLITE);
		}
	}
		
	public static class EntitySchistGolem extends MineralGolemBase {
		public EntitySchistGolem(World world) {
			super(world, MGolemNames.SCHIST);
		}
	}
	
	public static class EntityScoriaGolem extends MineralGolemBase {
		public EntityScoriaGolem(World world) {
			super(world, MGolemNames.SCORIA);
			this.setCanSwim(true);
		}
	}
	
	public static class EntityShaleGolem extends MineralGolemBase {
		public EntityShaleGolem(World world) {
			super(world, MGolemNames.SHALE);
		}
	}
	
	public static class EntitySiltstoneGolem extends MineralGolemBase {
		public EntitySiltstoneGolem(World world) {
			super(world, MGolemNames.SILTSTONE);
		}
	}
	
	public static class EntitySlateGolem extends MineralGolemBase {
		public EntitySlateGolem(World world) {
			super(world, MGolemNames.SLATE);
		}
	}
	
	public static class EntitySulfurGolem extends MineralGolemBase {
		public EntitySulfurGolem(World world) {
			super(world, MGolemNames.SULFUR);
		}
		
		@Override
		protected EnumParticleTypes getParticle() {
			return EnumParticleTypes.LAVA;
		}
	}
	
	public static class EntityTuffGolem extends MineralGolemBase {
		public EntityTuffGolem(World world) {
			super(world, MGolemNames.TUFF);
		}
	}
}
