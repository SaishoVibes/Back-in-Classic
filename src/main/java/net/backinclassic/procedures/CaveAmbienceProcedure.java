package net.backinclassic.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.BiomeDictionary;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;

import net.backinclassic.BackInClassicMod;

import java.util.Map;

public class CaveAmbienceProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency x for procedure CaveAmbience!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency y for procedure CaveAmbience!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency z for procedure CaveAmbience!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency world for procedure CaveAmbience!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double AmbientSelector = 0;
		AmbientSelector = (double) Math.random();
		if ((((AmbientSelector > 0) && (AmbientSelector < 0.3)) && (!(world.canBlockSeeSky(new BlockPos((int) x, (int) y, (int) z)))))) {
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("back_in_classic:cave_chimes")),
						SoundCategory.NEUTRAL, (float) 0.5, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("back_in_classic:cave_chimes")),
						SoundCategory.NEUTRAL, (float) 0.5, (float) 1, false);
			}
		}
		if ((((AmbientSelector > 0.3) && (AmbientSelector < 0.6)) && (!(world.canBlockSeeSky(new BlockPos((int) x, (int) y, (int) z)))))) {
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")),
						SoundCategory.NEUTRAL, (float) 0.5, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")),
						SoundCategory.NEUTRAL, (float) 0.5, (float) 1, false);
			}
		}
		if ((((AmbientSelector > 0.6) && (AmbientSelector < 0.9)) && (!(world.canBlockSeeSky(new BlockPos((int) x, (int) y, (int) z)))))) {
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")),
						SoundCategory.NEUTRAL, (float) 0.5, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")),
						SoundCategory.NEUTRAL, (float) 0.5, (float) 1, false);
			}
		}
		if ((((AmbientSelector > 0)
				&& ((world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
						&& BiomeDictionary
								.hasType(
										RegistryKey
												.getOrCreateKey(Registry.BIOME_KEY,
														world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(
																new BlockPos((int) x, (int) y, (int) z)))),
										BiomeDictionary.Type.FOREST))
						|| (world.func_241828_r().getRegistry(Registry.BIOME_KEY)
								.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
								&& BiomeDictionary.hasType(
										RegistryKey.getOrCreateKey(Registry.BIOME_KEY,
												world.func_241828_r().getRegistry(Registry.BIOME_KEY)
														.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))),
										BiomeDictionary.Type.JUNGLE))))
				&& (world.canBlockSeeSky(new BlockPos((int) x, (int) y, (int) z))))) {
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("back_in_classic:birds_chirping")),
						SoundCategory.NEUTRAL, (float) 0.5, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("back_in_classic:birds_chirping")),
						SoundCategory.NEUTRAL, (float) 0.5, (float) 1, false);
			}
		}
		if ((((AmbientSelector > 0)
				&& ((world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
						&& BiomeDictionary
								.hasType(
										RegistryKey
												.getOrCreateKey(Registry.BIOME_KEY,
														world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(
																new BlockPos((int) x, (int) y, (int) z)))),
										BiomeDictionary.Type.BEACH))
						|| (world.func_241828_r().getRegistry(Registry.BIOME_KEY)
								.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
								&& BiomeDictionary.hasType(
										RegistryKey.getOrCreateKey(Registry.BIOME_KEY,
												world.func_241828_r().getRegistry(Registry.BIOME_KEY)
														.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))),
										BiomeDictionary.Type.OCEAN))))
				&& (world.canBlockSeeSky(new BlockPos((int) x, (int) y, (int) z))))) {
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("back_in_classic:ocean_loop")),
						SoundCategory.NEUTRAL, (float) 0.5, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("back_in_classic:ocean_loop")),
						SoundCategory.NEUTRAL, (float) 0.5, (float) 1, false);
			}
		}
	}
}
