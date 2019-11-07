package com.golems_mineralogy.init;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.golems_mineralogy.proxy.CommonProxy;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod.EventBusSubscriber
@Mod(modid = MineralogyGolems.MODID, name = MineralogyGolems.NAME, version = MineralogyGolems.VERSION, dependencies = MineralogyGolems.DEPENDENCIES, acceptedMinecraftVersions = MineralogyGolems.MCVERSION)
public class MineralogyGolems {
	
	public static final String MODID = "golems_mineralogy";
	public static final String DEPENDENCIES = "required:forge@[14.23.4.2768,);required-after:golems@[7.1.6,);required-after:mineralogy@[3.8.0.53,)";
	public static final String NAME = "Mineralogy Golems";
	public static final String VERSION = "7.1.6-1";
	public static final String MCVERSION = "1.12.2";
	
	@Mod.Instance(MineralogyGolems.MODID)
	public static MineralogyGolems instance;
	
	@SidedProxy(clientSide = "com." + MODID + ".proxy.ClientProxy", serverSide = "com." + MODID + ".proxy.CommonProxy")
	public static CommonProxy proxy;
	
	public static final Logger LOGGER = LogManager.getFormatterLogger(MODID);
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		MineralConfig.mainRegistry(new Configuration(event.getSuggestedConfigurationFile()));
		proxy.preInitRenders();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		// register entities
		proxy.registerEntities();
	}
}

