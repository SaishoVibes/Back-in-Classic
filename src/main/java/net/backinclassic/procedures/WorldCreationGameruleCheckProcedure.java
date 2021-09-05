package net.mcreator.backinclassic.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.storage.ISpawnWorldInfo;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.backinclassic.world.DoClassicOverworldGameRule;
import net.mcreator.backinclassic.BackInClassicMod;

import java.util.Map;
import java.util.HashMap;

public class WorldCreationGameruleCheckProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			Entity entity = event.getPlayer();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", entity.getPosX());
			dependencies.put("y", entity.getPosY());
			dependencies.put("z", entity.getPosZ());
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency entity for procedure WorldCreationGameruleCheck!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency x for procedure WorldCreationGameruleCheck!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency y for procedure WorldCreationGameruleCheck!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency z for procedure WorldCreationGameruleCheck!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency world for procedure WorldCreationGameruleCheck!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getWorldInfo().getGameRulesInstance().getBoolean(DoClassicOverworldGameRule.gamerule)) == (true))) {
			if (((entity.world.getDimensionKey()) == (World.OVERWORLD))) {
				if (world instanceof ServerWorld) {
					IWorld _worldorig = world;
					world = ((ServerWorld) world).getServer()
							.getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("back_in_classic:classic_overworld")));
					if (world != null) {
						{
							Entity _ent = entity;
							if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
								RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
										new ResourceLocation("back_in_classic:classic_overworld"));
								ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
								if (nextWorld != null) {
									((ServerPlayerEntity) _ent).connection
											.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
									((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
											nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
											_ent.rotationPitch);
									((ServerPlayerEntity) _ent).connection
											.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
									for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
										((ServerPlayerEntity) _ent).connection
												.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
									}
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
						if (world.getWorldInfo() instanceof ISpawnWorldInfo)
							((ISpawnWorldInfo) world.getWorldInfo()).setSpawn(new BlockPos((int) x, (int) y, (int) z), 0);
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).func_242111_a(((ServerPlayerEntity) entity).world.getDimensionKey(),
									new BlockPos((int) x, (int) y, (int) z), 0, true, false);
					}
					world = _worldorig;
				}
			}
		}
	}
}
