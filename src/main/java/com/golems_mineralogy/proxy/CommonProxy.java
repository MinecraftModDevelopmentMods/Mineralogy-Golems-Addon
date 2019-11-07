package com.golems_mineralogy.proxy;

import com.golems.entity.GolemBase;
import com.golems.util.GolemLookup;
import com.golems_mineralogy.entity.*;
import com.golems_mineralogy.init.InterModComm;
import com.golems_mineralogy.init.MineralogyGolems;
import com.mcmoddev.mineralogy.init.MineralogyRegistry;
import com.mcmoddev.mineralogy.util.BlockItemPair;

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
	}

	protected static void register(final Class<? extends GolemBase> entityClass, final String blockName) {
		// register the entity with Forge
		final String name = "golem_".concat(blockName);
		EntityRegistry.registerModEntity(new ResourceLocation(MineralogyGolems.MODID, name), entityClass,
				MineralogyGolems.MODID + "." + name, ++entityCount, MineralogyGolems.instance, 16 * 4, 3, true);
		// register building block
		final BlockItemPair pair = MineralogyRegistry.MineralogyBlockRegistry.get(blockName);
		GolemLookup.addGolem(entityClass, pair != null ? pair.PairedBlock : null);
		// register loot table
		registerLootTable(name);
	}

	protected static void registerLootTable(final String name) {
		LootTableList.register(new ResourceLocation(MineralogyGolems.MODID, "entities/" + name));
	}
}
