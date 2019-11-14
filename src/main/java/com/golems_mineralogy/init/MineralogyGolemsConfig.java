package com.golems_mineralogy.init;

import com.golems.util.GolemConfigSet;
import com.golems.util.GolemLookup;
import com.golems_mineralogy.entity.*;
import com.golems_mineralogy.entity.MineralGolemBase.*;

import net.minecraftforge.common.config.Configuration;

public class MineralogyGolemsConfig {
	
	// hardness How hard (time duration) the block is to pick. 
	//// For reference, dirt is 0.5, stone is 1.5, ores are 3, and obsidian is 50
	// blastResistance how resistant the block is to explosions. 
	//// For reference, dirt is0, stone is 10, and blast-proof materials are 2000
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
	
		GolemLookup.addConfig(EntityAmphiboliteGolem.class, 
				new GolemConfigSet(config, MGolemNames.AMPHIBOLITE_GOLEM, 66.0D, 4.5F));
		GolemLookup.addConfig(EntityAndesiteGolem.class, 
				new GolemConfigSet(config, MGolemNames.ANDESITE_GOLEM, 48.0D, 3.0F));
		GolemLookup.addConfig(EntityBasaltGolem.class, 
				new GolemConfigSet(config, MGolemNames.BASALT_GOLEM, 80.0D, 6.0F));
		GolemLookup.addConfig(EntityBasalticGlassGolem.class, 
				new GolemConfigSet(config, MGolemNames.BASALTIC_GLASS_GOLEM, 36.0D, 4.5F));
		GolemLookup.addConfig(EntityChertGolem.class, 
				new GolemConfigSet(config, MGolemNames.CHERT_GOLEM, 82.0D, 5.8F));
		GolemLookup.addConfig(EntityConglomerateGolem.class, 
				new GolemConfigSet(config, MGolemNames.CONGLOMERATE_GOLEM, 40.0D, 3.0F));
		GolemLookup.addConfig(EntityDiabaseGolem.class, 
				new GolemConfigSet(config, MGolemNames.DIABASE_GOLEM, 72.0D, 6.0F));
		GolemLookup.addConfig(EntityDioriteGolem.class, 
				new GolemConfigSet(config, MGolemNames.DIORITE_GOLEM, 64.0D, 4.2F));
		GolemLookup.addConfig(EntityDolomiteGolem.class, 
				new GolemConfigSet(config, MGolemNames.DOLOMITE_GOLEM, 50.0D, 6.2F));
		GolemLookup.addConfig(EntityGabbroGolem.class, 
				new GolemConfigSet(config, MGolemNames.GABBRO_GOLEM, 80.0D, 6.0F));
		GolemLookup.addConfig(EntityGneissGolem.class, 
				new GolemConfigSet(config, MGolemNames.GNEISS_GOLEM, 88.0D, 4.6F));
		GolemLookup.addConfig(EntityGraniteGolem.class, 
				new GolemConfigSet(config, MGolemNames.GRANITE_GOLEM, 96.0D, 5.5F));
		GolemLookup.addConfig(EntityHornfelsGolem.class, 
				new GolemConfigSet(config, MGolemNames.HORNFELS_GOLEM, 60.0D, 6.5F));
		GolemLookup.addConfig(EntityLimestoneGolem.class, 
				new GolemConfigSet(config, MGolemNames.LIMESTONE_GOLEM, 42.0D, 3.0F));
		GolemLookup.addConfig(EntityMarbleGolem.class, 
				new GolemConfigSet(config, MGolemNames.MARBLE_GOLEM, 46.0D, 4.6F));
		GolemLookup.addConfig(EntityNovaculiteGolem.class, 
				new GolemConfigSet(config, MGolemNames.NOVACULITE_GOLEM, 82.0D, 4.0F));
		GolemLookup.addConfig(EntityPegmatiteGolem.class, 
				new GolemConfigSet(config, MGolemNames.PEGMATITE_GOLEM, 84.0D, 5.0F));
		GolemLookup.addConfig(EntityPeridotiteGolem.class, 
				new GolemConfigSet(config, MGolemNames.PERIDOTITE_GOLEM, 70.0D, 5.8F));
		GolemLookup.addConfig(EntityPhosphorousGolem.class, 
				new GolemConfigSet(config, MGolemNames.PHOSPHOROUS_GOLEM, 56.0D, 3.0F)
				.addKey(EntityPhosphorousGolem.ALLOW_SPECIAL, true, "Whether this golem burns spontaneously"));
		GolemLookup.addConfig(EntityPhylliteGolem.class, 
				new GolemConfigSet(config, MGolemNames.PHYLLITE_GOLEM, 44.0D, 3.5F));
		GolemLookup.addConfig(EntityQuartziteGolem.class, 
				new GolemConfigSet(config, MGolemNames.QUARTZITE_GOLEM, 86.0D, 6.0F));
		GolemLookup.addConfig(EntityRhyoliteGolem.class, 
				new GolemConfigSet(config, MGolemNames.RHYOLITE_GOLEM, 64.0D, 4.2F));
		GolemLookup.addConfig(EntityRockSaltGolem.class, 
				new GolemConfigSet(config, MGolemNames.ROCK_SALT_GOLEM, 40.0D, 2.5F)
				.addKey(EntityRockSaltGolem.ALLOW_SPECIAL, true, "Whether the golem can emit light")
				.addKey(EntityRockSaltGolem.FREQUENCY, 2, 1, 24000, "Number of ticks between light updates"));
		GolemLookup.addConfig(EntitySchistGolem.class, 
				new GolemConfigSet(config, MGolemNames.SCHIST_GOLEM, 70.0D, 4.1F));
		GolemLookup.addConfig(EntityScoriaGolem.class, 
				new GolemConfigSet(config, MGolemNames.SCORIA_GOLEM, 70.0D, 4.0F));
		GolemLookup.addConfig(EntityShaleGolem.class, 
				new GolemConfigSet(config, MGolemNames.SHALE_GOLEM, 34.0D, 3.5F));
		GolemLookup.addConfig(EntitySiltstoneGolem.class, 
				new GolemConfigSet(config, MGolemNames.SILTSTONE_GOLEM, 36.0D, 3.2F));
		GolemLookup.addConfig(EntitySlateGolem.class, 
				new GolemConfigSet(config, MGolemNames.SLATE_GOLEM, 40.0D, 3.2F));
		GolemLookup.addConfig(EntitySulfurGolem.class, 
				new GolemConfigSet(config, MGolemNames.SULFUR_GOLEM, 44.0D, 5.0F));
		GolemLookup.addConfig(EntityTuffGolem.class, 
				new GolemConfigSet(config, MGolemNames.TUFF_GOLEM, 40.0D, 3.0F));
	
		config.save();
	}
	
	public static boolean useRawOrSmooth() {
		return useRawOrSmooth;
	}
}
