package com.golems_mineralogy.init;

import com.golems.util.GolemConfigSet;
import com.golems.util.GolemLookup;
import com.golems_mineralogy.entity.*;

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
	
	public static void mainRegistry(Configuration config) {
		config.load();
		
		// BASE METAL GOLEMS:  initialize and register with GolemLookup
//			GolemLookup.addConfig(EntityAdamantineGolem.class,
//					new GolemConfigSet(config, "Adamantine Golem", 240.0D, 21.0F)
//					.addKey(EntityAdamantineGolem.DAMAGE_TOUGH, true, "Whether this golem deals extra damage to tough mobs")
//					.addKey(EntityAdamantineGolem.ALLOW_RESIST, true, "Whether this golem reduces damage dealt to it"));
//			GolemLookup.addConfig(EntityAntimonyGolem.class,
//					new GolemConfigSet(config, "Antimony Golem", 50.0D, 4.5F));
		GolemLookup.addConfig(EntityAmphiboliteGolem.class, 
				new GolemConfigSet(config, MGolemNames.AMPHIBOLITE, 65.0D, 4.5F));
		GolemLookup.addConfig(EntityAndesiteGolem.class, 
				new GolemConfigSet(config, MGolemNames.ANDESITE, 55.0D, 3.0F));
	
		config.save();
	}
}
