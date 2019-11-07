package com.golems_mineralogy.proxy;

import com.golems.entity.GolemBase;
import com.golems_mineralogy.entity.EntityAmphiboliteGolem;
import com.golems_mineralogy.entity.EntityAndesiteGolem;
import com.golems_mineralogy.entity.EntityBasaltGolem;
import com.golems_mineralogy.entity.EntityBasalticGlassGolem;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInitRenders() {
		// Register golem rendering classes
		// call com.golems.proxies.ClientProxy.registerEntityRender(clazz);
		reg(EntityAmphiboliteGolem.class);
		reg(EntityAndesiteGolem.class);
		reg(EntityBasaltGolem.class);
		reg(EntityBasalticGlassGolem.class);
	}
	
	private static void reg(final Class<? extends GolemBase> clazz) {
		com.golems.proxies.ClientProxy.registerEntityRender(clazz);
	}
}
