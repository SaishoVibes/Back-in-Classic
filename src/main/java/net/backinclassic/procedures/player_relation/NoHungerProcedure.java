package net.backinclassic.procedures.player_relation;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.FoodStats;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.backinclassic.world.DoBetaHungerGameRule;
import net.backinclassic.BackInClassicMod;

import java.util.Map;

public class NoHungerProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency entity for procedure NoHunger!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency world for procedure NoHunger!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private IWorld world;
			public void start(IWorld world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				if (((world.getWorldInfo().getGameRulesInstance().getBoolean(DoBetaHungerGameRule.gamerule)) == (true))) {
					if ((entity instanceof PlayerEntity)) {
						if (entity instanceof PlayerEntity) {
							ObfuscationReflectionHelper.setPrivateValue(FoodStats.class, ((PlayerEntity) entity).getFoodStats(), (float) 0,
									"field_75125_b");
						}
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getFoodStats().setFoodLevel((int) 7);
					}
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 2);
	}
}
