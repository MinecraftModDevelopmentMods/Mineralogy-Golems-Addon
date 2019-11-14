package com.golems_mineralogy.proxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

import com.golems.entity.EntityFurnaceGolem;
import com.golems.entity.GolemBase;
import com.golems.util.GolemLookup;
import com.golems_mineralogy.entity.*;
import com.golems_mineralogy.entity.MineralGolemBase.*;
import com.golems_mineralogy.init.InterModComm;
import com.golems_mineralogy.init.MGolemNames;
import com.golems_mineralogy.init.MineralogyGolemsConfig;
import com.golems_mineralogy.init.MineralogyGolems;
import com.mcmoddev.mineralogy.data.Material;
import com.mcmoddev.mineralogy.data.MaterialData;
import com.mcmoddev.mineralogy.init.MineralogyRegistry;
import com.mcmoddev.mineralogy.util.BlockItemPair;

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
		register(EntityChertGolem.class, InterModComm.CHERT, false);
		register(EntityConglomerateGolem.class, InterModComm.CONGLOMERATE);
		register(EntityDiabaseGolem.class, InterModComm.DIABASE);
		register(EntityDioriteGolem.class, InterModComm.DIORITE);
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
		register(EntityPhosphorousGolem.class, InterModComm.PHOSPHORUS, false);
		register(EntityPhylliteGolem.class, InterModComm.PHYLLITE);
		register(EntityQuartziteGolem.class, InterModComm.QUARTZITE);
		register(EntityRhyoliteGolem.class, InterModComm.RHYOLITE);
		register(EntityRockSaltGolem.class, InterModComm.ROCK_SALT);
		register(EntitySchistGolem.class, InterModComm.SCHIST);
		register(EntityScoriaGolem.class, InterModComm.SCORIA);
		register(EntityShaleGolem.class, InterModComm.SHALE);
		register(EntitySiltstoneGolem.class, InterModComm.SILTSTONE);
		register(EntitySlateGolem.class, InterModComm.SLATE);
		register(EntitySulfurGolem.class, InterModComm.SULFUR, false);
		register(EntityTuffGolem.class, InterModComm.TUFF);
		
		// add furnace golem aliases
		for(final Material d : MaterialData.toArray()) {
			final String blockName = d.materialName.toLowerCase();
			final String furnace = blockName.concat("_furnace");
			final String smoothFurnace = blockName.concat("_smooth_furnace");
			final String smoothBrickFurnace = blockName.concat("_smooth_brick_furnace");
			for(final String s : new String [] {furnace, smoothFurnace, smoothBrickFurnace}) {
				if(MineralogyRegistry.MineralogyBlockRegistry.containsKey(s) 
						&& MineralogyRegistry.MineralogyBlockRegistry.get(s).PairedBlock != null) {
					GolemLookup.addBlockAlias(MineralogyRegistry.MineralogyBlockRegistry.get(s).PairedBlock, EntityFurnaceGolem.class);
				}
			}
		}
	}
	
	/** HELPER METHOD to register a golem with its material **/
	protected static void register(final Class<? extends GolemBase> entityClass, final String blockName) {
		register(entityClass, blockName, true);
	}
	
	/** HELPER METHOD to register a golem with its material **/
	protected static void register(final Class<? extends GolemBase> entityClass, final String blockName, final boolean polished) {
		register(entityClass, "golem_".concat(blockName), polished ? getBoth(blockName) : getAll(blockName));
	}

	/**
	 * WORKER METHOD to register this mod's golems
	 * @param entityClass the entity class
	 * @param golemName the unique golem name
	 * @param blocks an array of blocks that will be used to build the golem. 
	 * Cannot be null but may be empty.
	 **/
	protected static void register(final Class<? extends GolemBase> entityClass, final String golemName, 
			final Block... blocks) {
		// register the entity with Forge
		EntityRegistry.registerModEntity(new ResourceLocation(MineralogyGolems.MODID, golemName), entityClass,
				MineralogyGolems.MODID + "." + golemName, ++entityCount, MineralogyGolems.instance, 16 * 4, 3, true);
		// register with GolemLookup
		GolemLookup.addGolem(entityClass, blocks);
		// register loot table
		registerLootTable(golemName);
	}
	
	/**
	 * @param mineralogyName the name of a block from the Mineralogy mod
	 * @return the block if found, else null
	 **/
	@Nullable
	protected static Block get(final String mineralogyName) {
		if(mineralogyName != null && MineralogyRegistry.MineralogyBlockRegistry.containsKey(mineralogyName)) {
			final BlockItemPair pair = MineralogyRegistry.MineralogyBlockRegistry.get(mineralogyName);
			if(pair != null && pair.PairedBlock != null) {
				return pair.PairedBlock;
			}
		}
		return null;
	}
	
	/**
	 * @param mineralogyNames a list of block names from the
	 * Mineralogy mod
	 * @return an array of blocks matching the given names
	 * where none of the array elements are null. May be empty.
	 **/
	protected static Block[] getAll(final String... mineralogyNames) {
		List<Block> list = new ArrayList<>();
		for(final String s : mineralogyNames) {
			final Block b = get(s);
			if(b != null) {
				list.add(b);
			}
		}
	    return list.isEmpty() ? new Block[0] : list.toArray(new Block[list.size()]);
	}
	
	/**
	 * Helper method to quickly get both the smooth and raw variants
	 * of a Mineralogy stone type. Also references the config.
	 * @param mineralogyName the block name
	 * @return an array of blocks where no array elements are null. May be empty.
	 * Only includes raw stone if allowed by config.
	 **/
	protected static Block[] getBoth(final String mineralogyName) {
		final String smooth = mineralogyName.concat("_smooth");
		if(MineralogyGolemsConfig.useRawOrSmooth()) {
			return getAll(mineralogyName, smooth);
		} else {
			return getAll(smooth);
		}
	}
	
	protected static void registerLootTable(final String name) {
		LootTableList.register(new ResourceLocation(MineralogyGolems.MODID, "entities/" + name));
	}
}
