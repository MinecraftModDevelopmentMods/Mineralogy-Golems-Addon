package com.golems_mineralogy.entity;

import com.golems.entity.GolemBase;
import com.golems_mineralogy.init.InterModComm;
import com.golems_mineralogy.init.MGolemNames;
import com.golems_mineralogy.init.MineralogyGolems;

import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityRockSaltGolem extends GolemBase {

	public EntityRockSaltGolem(World world) {
		super(world);
	}

	@Override
	protected ResourceLocation applyTexture() {
		return makeTexture(MineralogyGolems.MODID, MGolemNames.ROCK_SALT);
	}

	@Override
	public SoundEvent getGolemSound() {
		return SoundEvents.BLOCK_STONE_STEP;
	}

}
