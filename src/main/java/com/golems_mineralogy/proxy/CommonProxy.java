package com.golems_mineralogy.proxy;

import java.util.ArrayList;
import java.util.List;

import com.golems.entity.GolemBase;
import com.golems.util.GolemLookup;
import com.golems_mineralogy.entity.*;
import com.golems_mineralogy.entity.MineralGolemBase.*;
import com.golems_mineralogy.init.InterModComm;
import com.golems_mineralogy.init.MGolemNames;
import com.golems_mineralogy.init.MineralogyGolemsConfig;
import com.golems_mineralogy.init.MineralogyGolems;
import com.mcmoddev.mineralogy.init.MineralogyRegistry;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod.EventBusSubscriber(modid = MineralogyGolems.MODID)
public class CommonProxy {

	protected static int entityCount = 0;

	public void preInitRenders() {
		//
	}
	
	public void registerEntities() {	
		register(EntityAmphiboliteGolem.class, InterModComm.AMPHIBOLITE);
		register(EntityAndesiteGolem.class, InterModComm.ANDESITE);
		register(EntityBasaltGolem.class, InterModComm.BASALT);
		register(EntityBasalticGlassGolem.class, InterModComm.BASALTIC_GLASS);
		register(EntityConglomerateGolem.class, InterModComm.CONGLOMERATE);
		register(EntityDiabaseGolem.class, InterModComm.DIABASE);
		register(EntityDolomiteGolem.class, InterModComm.DOLOMITE);
		register(EntityGabbroGolem.class, InterModComm.GABBRO);
		register(EntityGneissGolem.class, InterModComm.GNEISS);
		register(EntityGraniteGolem.class, InterModComm.GRANITE);
		register(EntityHornfelsGolem.class, InterModComm.HORNFELS);
		register(EntityLimestoneGolem.class, InterModComm.LIMESTONE);
		register(EntityMarbleGolem.class, InterModComm.MARBLE);
		register(EntityNovaculiteGolem.class, InterModComm.NOVACULITE);
		register(EntityPegmatiteGolem.class, InterModComm.PEGMATITE);
		register(EntityPeridotiteGolem.class, InterModComm.PERIDOTITE);
		register(EntityPhosphorousGolem.class, MGolemNames.PHOSPHOROUS, null, InterModComm.PHOSPHORUS);
		register(EntityPhylliteGolem.class, InterModComm.PHYLLITE);
		register(EntityQuartziteGolem.class, InterModComm.QUARTZITE);
		register(EntityRhyoliteGolem.class, InterModComm.RHYOLITE);
		register(EntityRockSaltGolem.class, InterModComm.ROCK_SALT);
		register(EntitySchistGolem.class, InterModComm.SCHIST);
		register(EntityScoriaGolem.class, InterModComm.SCORIA);
		register(EntityShaleGolem.class, InterModComm.SHALE);
		register(EntitySiltstoneGolem.class, InterModComm.SILTSTONE);
		register(EntitySlateGolem.class, InterModComm.SLATE);
		register(EntitySulfurGolem.class, MGolemNames.SULFUR, null, InterModComm.SULFUR);
		register(EntityTuffGolem.class, InterModComm.TUFF);
	}

	protected static void register(final Class<? extends GolemBase> entityClass, final String golemName, 
			final String blockNameRaw, final String blockNameSmooth) {
		// register the entity with Forge
		EntityRegistry.registerModEntity(new ResourceLocation(MineralogyGolems.MODID, golemName), entityClass,
				MineralogyGolems.MODID + "." + golemName, ++entityCount, MineralogyGolems.instance, 16 * 4, 3, true);
		// make a list of compatible building blocks
		final List<Block> blocks = new ArrayList<>();
		if(MineralogyGolemsConfig.useRawOrSmooth() && blockNameRaw != null 
				&& MineralogyRegistry.MineralogyBlockRegistry.containsKey(blockNameRaw)) {
			blocks.add(MineralogyRegistry.MineralogyBlockRegistry.get(blockNameRaw).PairedBlock);
		}
		if(blockNameSmooth != null && MineralogyRegistry.MineralogyBlockRegistry.containsKey(blockNameSmooth)) {
			blocks.add(MineralogyRegistry.MineralogyBlockRegistry.get(blockNameSmooth).PairedBlock);
		}
		final Block[] blockArray = blocks.isEmpty() ? new Block[] {} : blocks.toArray(new Block[blocks.size()]);
		GolemLookup.addGolem(entityClass, blockArray);
		// register loot table
		registerLootTable(golemName);
	}
	
	protected static void register(final Class<? extends GolemBase> entityClass, final String blockName) {
		register(entityClass, "golem_".concat(blockName), blockName, blockName.concat("_smooth"));
	}

	protected static void registerLootTable(final String name) {
		LootTableList.register(new ResourceLocation(MineralogyGolems.MODID, "entities/" + name));
	}
}
