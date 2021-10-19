package net.backinclassic.procedures.player_relation;

import com.backinclassic.PacketHandler;
import com.backinclassic.EventHandler;
import net.minecraftforge.common.MinecraftForge;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Map;
import java.util.Collections;

public class OnStartupInitProcedure {
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void init(FMLCommonSetupEvent event) {
			executeProcedure(Collections.emptyMap());
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		/* code */
		PacketHandler.init();
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
}
