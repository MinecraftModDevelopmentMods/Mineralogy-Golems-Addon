package com.golems_mineralogy.init;

import com.golems.util.GolemConfigSet;
import com.golems.util.GolemLookup;
import com.golems_mineralogy.entity.*;
import com.golems_mineralogy.entity.MineralGolemBase.*;

import net.minecraftforge.common.config.Configuration;

public class MineralConfig {
	
	// hardness How hard (time duration) the block is to pick. 
	// For reference, dirt is 0.5, stone is 1.5, ores are 3, and obsidian is 50
	// blastResistance how resistant the block is to explosions. 
	// For reference, dirt is0, stone is 10, and blast-proof materials are 2000
	// toolHardnessLevel 0 for wood tools, 1 for stone, 2 for iron, 3 for diamond
	
	// ANDESITE: 1.5, 10, 0
	// BASALT: 5, 100, 2
	// DIORITE: 1.5, 10, 0
	// GRANITE: 3, 15, 1
	// RHYOLITE: 1.5, 10, 0
	// PEGMATITE:1.5, 10, 0
	// DIABASE: 5, 100, 2
	// GABBRO: 5, 100, 2
	// PERIDOTITE: 3, 15, 0
	// BASALTIC_GLASS: 3, 15, 0
	// SCORIA: 1, 7, 0
	// TUFF: 2, 10, 0
	
	// SHALE: 1.5, 10, 0
	// CONGLOMERATE: 1.5, 10, 0
	// DOLOMITE: 3, 15, 1
	// LIMESTONE: 1.5, 10, 0
	// MARBLE: 1.5, 10, 0	
	// SILTSTONE: 1, 10, 0
	// ROCK_SALT: 1.5, 10, 0

	// SLATE: 1.5, 10, 0
	// SCHIST: 3, 15, 1
	// GNEISS: 3, 15, 1
	// PHYLLITE: 1.5, 10, 0
	// AMPHIBOLITE: 3, 15, 1
	// HORNFELS: 3, 15, 1
	// QUARTZITE: 4, 15, 1
	// NOVACULITE: 3, 15, 1
	
	private static boolean useRawOrSmooth;
	
	public static void mainRegistry(Configuration config) {
		config.load();
		useRawOrSmooth = config.getBoolean("Use Raw or Smooth", Configuration.CATEGORY_GENERAL, false, 
				"When true, golems can be built using both smooth and raw stone");
		
		
		// BASE METAL GOLEMS:  initialize and register with GolemLookup
//			GolemLookup.addConfig(EntityAdamantineGolem.class,
//					new GolemConfigSet(config, "Adamantine Golem", 240.0D, 21.0F)
//					.addKey(EntityAdamantineGolem.DAMAGE_TOUGH, true, "Whether this golem deals extra damage to tough mobs")
//					.addKey(EntityAdamantineGolem.ALLOW_RESIST, true, "Whether this golem reduces damage dealt to it"));
		GolemLookup.addConfig(EntityAmphiboliteGolem.class, 
				new GolemConfigSet(config, MGolemNames.AMPHIBOLITE, 65.0D, 4.5F));
		GolemLookup.addConfig(EntityAndesiteGolem.class, 
				new GolemConfigSet(config, MGolemNames.ANDESITE, 55.0D, 3.0F));
		
		// TODO replace with actual stats
		GolemLookup.addConfig(EntityBasaltGolem.class, 
				new GolemConfigSet(config, MGolemNames.BASALT, 55.0D, 3.0F));
		GolemLookup.addConfig(EntityBasalticGlassGolem.class, 
				new GolemConfigSet(config, MGolemNames.BASALTIC_GLASS, 55.0D, 3.0F));
		GolemLookup.addConfig(EntityConglomerateGolem.class, 
				new GolemConfigSet(config, MGolemNames.CONGLOMERATE, 55.0D, 3.0F));
		GolemLookup.addConfig(EntityDiabaseGolem.class, 
				new GolemConfigSet(config, MGolemNames.DIABASE, 55.0D, 3.0F));
		GolemLookup.addConfig(EntityDioriteGolem.class, 
				new GolemConfigSet(config, MGolemNames.DIORITE, 55.0D, 3.0F));
		GolemLookup.addConfig(EntityDolomiteGolem.class, 
				new GolemConfigSet(config, MGolemNames.DOLOMITE, 55.0D, 3.0F));
		GolemLookup.addConfig(EntityGabbroGolem.class, 
				new GolemConfigSet(config, MGolemNames.GABBRO, 55.0D, 3.0F));
		GolemLookup.addConfig(EntityGneissGolem.class, 
				new GolemConfigSet(config, MGolemNames.GNEISS, 55.0D, 3.0F));
		GolemLookup.addConfig(EntityGraniteGolem.class, 
				new GolemConfigSet(config, MGolemNames.GRANITE, 55.0D, 3.0F));
		GolemLookup.addConfig(EntityHornfelsGolem.class, 
				new GolemConfigSet(config, MGolemNames.HORNFELS, 55.0D, 3.0F));
		GolemLookup.addConfig(EntityLimestoneGolem.class, 
				new GolemConfigSet(config, MGolemNames.LIMESTONE, 55.0D, 3.0F));
		GolemLookup.addConfig(EntityMarbleGolem.class, 
				new GolemConfigSet(config, MGolemNames.MARBLE, 55.0D, 3.0F));
		GolemLookup.addConfig(EntityNovaculiteGolem.class, 
				new GolemConfigSet(config, MGolemNames.NOVACULITE, 55.0D, 3.0F));
		GolemLookup.addConfig(EntityPegmatiteGolem.class, 
				new GolemConfigSet(config, MGolemNames.PEGMATITE, 55.0D, 3.0F));
		GolemLookup.addConfig(EntityPeridotiteGolem.class, 
				new GolemConfigSet(config, MGolemNames.PERIDOTITE, 55.0D, 3.0F));
		GolemLookup.addConfig(EntityPhosphorousGolem.class, 
				new GolemConfigSet(config, MGolemNames.PHOSPHOROUS, 55.0D, 3.0F)
				.addKey(EntityPhosphorousGolem.ALLOW_SPECIAL, true, "Whether this golem burns spontaneously"));
		GolemLookup.addConfig(EntityPhylliteGolem.class, 
				new GolemConfigSet(config, MGolemNames.PHYLLITE, 55.0D, 3.0F));
		GolemLookup.addConfig(EntityQuartziteGolem.class, 
				new GolemConfigSet(config, MGolemNames.QUARTZITE, 55.0D, 3.0F));
		GolemLookup.addConfig(EntityRhyoliteGolem.class, 
				new GolemConfigSet(config, MGolemNames.RHYOLITE, 55.0D, 3.0F));
		GolemLookup.addConfig(EntityRockSaltGolem.class, 
				new GolemConfigSet(config, MGolemNames.ROCK_SALT, 55.0D, 3.0F)
				.addKey(EntityRockSaltGolem.ALLOW_SPECIAL, true, "Whether the golem can emit light")
				.addKey(EntityRockSaltGolem.FREQUENCY, 2, 1, 24000, "Number of ticks between light updates"));
		GolemLookup.addConfig(EntitySchistGolem.class, 
				new GolemConfigSet(config, MGolemNames.SCHIST, 55.0D, 3.0F));
		GolemLookup.addConfig(EntityScoriaGolem.class, 
				new GolemConfigSet(config, MGolemNames.SCORIA, 55.0D, 3.0F));
		GolemLookup.addConfig(EntityShaleGolem.class, 
				new GolemConfigSet(config, MGolemNames.SHALE, 55.0D, 3.0F));
		GolemLookup.addConfig(EntitySiltstoneGolem.class, 
				new GolemConfigSet(config, MGolemNames.SILTSTONE, 55.0D, 3.0F));
		GolemLookup.addConfig(EntitySlateGolem.class, 
				new GolemConfigSet(config, MGolemNames.SLATE, 55.0D, 3.0F));
		GolemLookup.addConfig(EntitySulfurGolem.class, 
				new GolemConfigSet(config, MGolemNames.SULFUR, 55.0D, 3.0F));
		GolemLookup.addConfig(EntityTuffGolem.class, 
				new GolemConfigSet(config, MGolemNames.TUFF, 55.0D, 3.0F));
	
		config.save();
	}
	
	public static boolean useRawOrSmooth() {
		return useRawOrSmooth;
	}
}
