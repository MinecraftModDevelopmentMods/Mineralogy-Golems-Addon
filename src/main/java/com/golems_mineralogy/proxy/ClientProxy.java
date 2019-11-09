package com.golems_mineralogy.proxy;

import com.golems.entity.GolemBase;
import com.golems_mineralogy.entity.*;
import com.golems_mineralogy.entity.MineralGolemBase.*;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInitRenders() {
		// reg golem rendering classes
		reg(EntityAmphiboliteGolem.class);
		reg(EntityAndesiteGolem.class);
		reg(EntityBasaltGolem.class);
		reg(EntityBasalticGlassGolem.class);
		reg(EntityConglomerateGolem.class);
		reg(EntityDiabaseGolem.class);
		reg(EntityDolomiteGolem.class);
		reg(EntityGabbroGolem.class);
		reg(EntityGneissGolem.class);
		reg(EntityGraniteGolem.class);
		reg(EntityHornfelsGolem.class);
		reg(EntityLimestoneGolem.class);
		reg(EntityMarbleGolem.class);
		reg(EntityNovaculiteGolem.class);
		reg(EntityPegmatiteGolem.class);
		reg(EntityPeridotiteGolem.class);
		reg(EntityPhosphorousGolem.class);
		reg(EntityPhylliteGolem.class);
		reg(EntityQuartziteGolem.class);
		reg(EntityRhyoliteGolem.class);
		reg(EntityRockSaltGolem.class);
		reg(EntitySchistGolem.class);
		reg(EntityScoriaGolem.class);
		reg(EntityShaleGolem.class);
		reg(EntitySiltstoneGolem.class);
		reg(EntitySlateGolem.class);
		reg(EntitySulfurGolem.class);
		reg(EntityTuffGolem.class);
	}
	
	private static void reg(final Class<? extends GolemBase> clazz) {
		com.golems.proxies.ClientProxy.registerEntityRender(clazz);
	}
}
