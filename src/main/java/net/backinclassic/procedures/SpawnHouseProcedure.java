package net.backinclassic.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;

import net.backinclassic.BackInClassicModVariables;
import net.backinclassic.BackInClassicMod;

import java.util.Map;

public class SpawnHouseProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency x for procedure SpawnHouse!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency y for procedure SpawnHouse!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency z for procedure SpawnHouse!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency world for procedure SpawnHouse!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((1000 <= (world.getWorldInfo().getDayTime()))) {
			BackInClassicModVariables.MapVariables.get(world).FirstJoin = (boolean) (true);
			BackInClassicModVariables.MapVariables.get(world).syncData(world);
		} else {
			if (((false) == BackInClassicModVariables.MapVariables.get(world).FirstJoin)) {
				if ((Math.random() >= 0.5)) {
					if ((Math.random() >= 0.5)) {
						if ((Math.random() >= 0.5)) {
							if (world instanceof ServerWorld) {
								Template template = ((ServerWorld) world).getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("back_in_classic", "moss_spawn_house"));
								if (template != null) {
									template.func_237144_a_(
											(ServerWorld) world, new BlockPos((int) (x - 0), (int) y, (int) (z - 0)), new PlacementSettings()
													.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
											((World) world).rand);
								}
							}
						} else {
							if (world instanceof ServerWorld) {
								Template template = ((ServerWorld) world).getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("back_in_classic", "moss_spawn_house"));
								if (template != null) {
									template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 0), (int) y, (int) (z - 0)),
											new PlacementSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setChunk(null)
													.setIgnoreEntities(false),
											((World) world).rand);
								}
							}
						}
					} else {
						if ((Math.random() >= 0.5)) {
							if (world instanceof ServerWorld) {
								Template template = ((ServerWorld) world).getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("back_in_classic", "moss_spawn_house"));
								if (template != null) {
									template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 0), (int) y, (int) (z - 0)),
											new PlacementSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setChunk(null)
													.setIgnoreEntities(false),
											((World) world).rand);
								}
							}
						} else {
							if (world instanceof ServerWorld) {
								Template template = ((ServerWorld) world).getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("back_in_classic", "moss_spawn_house"));
								if (template != null) {
									template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 0), (int) y, (int) (z - 0)),
											new PlacementSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setChunk(null)
													.setIgnoreEntities(false),
											((World) world).rand);
								}
							}
						}
					}
				} else {
					if ((Math.random() >= 0.5)) {
						if ((Math.random() >= 0.5)) {
							if (world instanceof ServerWorld) {
								Template template = ((ServerWorld) world).getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("back_in_classic", "wood_spawn_house"));
								if (template != null) {
									template.func_237144_a_(
											(ServerWorld) world, new BlockPos((int) (x - 0), (int) y, (int) (z - 0)), new PlacementSettings()
													.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
											((World) world).rand);
								}
							}
						} else {
							if (world instanceof ServerWorld) {
								Template template = ((ServerWorld) world).getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("back_in_classic", "wood_spawn_house"));
								if (template != null) {
									template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 0), (int) y, (int) (z - 0)),
											new PlacementSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setChunk(null)
													.setIgnoreEntities(false),
											((World) world).rand);
								}
							}
						}
					} else {
						if ((Math.random() >= 0.5)) {
							if (world instanceof ServerWorld) {
								Template template = ((ServerWorld) world).getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("back_in_classic", "wood_spawn_house"));
								if (template != null) {
									template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 0), (int) y, (int) (z - 0)),
											new PlacementSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setChunk(null)
													.setIgnoreEntities(false),
											((World) world).rand);
								}
							}
						} else {
							if (world instanceof ServerWorld) {
								Template template = ((ServerWorld) world).getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("back_in_classic", "wood_spawn_house"));
								if (template != null) {
									template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 0), (int) y, (int) (z - 0)),
											new PlacementSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setChunk(null)
													.setIgnoreEntities(false),
											((World) world).rand);
								}
							}
						}
					}
				}
				BackInClassicModVariables.MapVariables.get(world).FirstJoin = (boolean) (true);
				BackInClassicModVariables.MapVariables.get(world).syncData(world);
			}
		}
		BackInClassicModVariables.MapVariables.get(world).FirstJoin = (boolean) (true);
		BackInClassicModVariables.MapVariables.get(world).syncData(world);
	}
}
