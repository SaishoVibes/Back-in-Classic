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

import net.backinclassic.BackInClassicMod;

import java.util.Map;

public class OnVillageInstanceGeneratedProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency x for procedure OnVillageInstanceGenerated!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency y for procedure OnVillageInstanceGenerated!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency z for procedure OnVillageInstanceGenerated!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency world for procedure OnVillageInstanceGenerated!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			Template template = ((ServerWorld) world).getStructureTemplateManager()
					.getTemplateDefaulted(new ResourceLocation("back_in_classic", "village_well"));
			if (template != null) {
				template.func_237144_a_((ServerWorld) world, new BlockPos((int) x, (int) (y + 1), (int) z),
						new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
						((World) world).rand);
			}
		}
		for (int index0 = 0; index0 < (int) (4); index0++) {
			if ((Math.random() < 0.5)) {
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("back_in_classic", "double_farm"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world,
								new BlockPos((int) (x + ((Math.random() / Math.random()) * 32)), (int) y,
										(int) (z + ((Math.random() / Math.random()) * 32))),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
			} else {
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("back_in_classic", "single_farm"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world,
								new BlockPos((int) (x - ((Math.random() / Math.random()) * 32)), (int) y,
										(int) (z - ((Math.random() / Math.random()) * 32))),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
			}
		}
		for (int index1 = 0; index1 < (int) (4); index1++) {
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("back_in_classic", "street_light"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world,
							new BlockPos((int) (x + ((Math.random() / Math.random()) * 32)), (int) y,
									(int) (z + ((Math.random() / Math.random()) * 32))),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
			}
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("back_in_classic", "street_light"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world,
							new BlockPos((int) (x - ((Math.random() / Math.random()) * 32)), (int) y,
									(int) (z - ((Math.random() / Math.random()) * 32))),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
			}
		}
		for (int index2 = 0; index2 < (int) (4); index2++) {
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("back_in_classic", "gravel_path"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world,
							new BlockPos((int) (x + ((Math.random() / Math.random()) * 32)), (int) y,
									(int) (z + ((Math.random() / Math.random()) * 32))),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
			}
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("back_in_classic", "gravel_path"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world,
							new BlockPos((int) (x - ((Math.random() / Math.random()) * 32)), (int) y,
									(int) (z - ((Math.random() / Math.random()) * 32))),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
			}
		}
		for (int index3 = 0; index3 < (int) (4); index3++) {
			if ((Math.random() < 0.5)) {
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("back_in_classic", "square_hut_fence"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world,
								new BlockPos((int) (x + ((Math.random() / Math.random()) * 32)), (int) y,
										(int) (z + ((Math.random() / Math.random()) * 32))),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
			} else {
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("back_in_classic", "square_hut_flat"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world,
								new BlockPos((int) (x - ((Math.random() / Math.random()) * 32)), (int) y,
										(int) (z - ((Math.random() / Math.random()) * 32))),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
			}
		}
		for (int index4 = 0; index4 < (int) (4); index4++) {
			if ((Math.random() < 0.5)) {
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("back_in_classic", "small_hut_short"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world,
								new BlockPos((int) (x + ((Math.random() / Math.random()) * 32)), (int) y,
										(int) (z + ((Math.random() / Math.random()) * 32))),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
			} else {
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("back_in_classic", "small_hut_tall"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world,
								new BlockPos((int) (x - ((Math.random() / Math.random()) * 32)), (int) y,
										(int) (z - ((Math.random() / Math.random()) * 32))),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
			}
		}
		for (int index5 = 0; index5 < (int) (4); index5++) {
			if ((Math.random() < 0.5)) {
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("back_in_classic", "large_house"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world,
								new BlockPos((int) (x + ((Math.random() / Math.random()) * 32)), (int) y,
										(int) (z + ((Math.random() / Math.random()) * 32))),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
			} else {
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("back_in_classic", "library_house"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world,
								new BlockPos((int) (x - ((Math.random() / Math.random()) * 32)), (int) y,
										(int) (z - ((Math.random() / Math.random()) * 32))),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
			}
		}
	}
}
