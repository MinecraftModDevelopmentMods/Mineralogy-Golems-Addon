package com.golems_mineralogy.entity;

import java.util.List;

import com.golems_mineralogy.init.MGolemNames;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class EntityQuartziteGolem extends MineralGolemBase {

	public EntityQuartziteGolem(World world) {
		super(world, MGolemNames.QUARTZITE);
		
	}

	@Override
	protected void damageEntity(final DamageSource source, final float amount) {
		if (!this.isEntityInvulnerable(source)) {
			super.damageEntity(source, amount);
		}
		// similar to thorns enchantment
		if (source.getImmediateSource() instanceof EntityLivingBase) {
			source.getImmediateSource().attackEntityFrom(DamageSource.causeThornsDamage(this), 1.2F + rand.nextFloat());
		}
	}
	
	@Override
	public List<String> addSpecialDesc(final List<String> list) {
		list.add(TextFormatting.AQUA + trans("enchantment.minecraft.thorns") + " " + trans("enchantment.level.1"));
		return list;
	}
}
