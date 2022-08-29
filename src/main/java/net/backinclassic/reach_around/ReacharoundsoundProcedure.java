package net.backinclassic.reach_around;

import net.backinclassic.BackInClassicConfig;
import net.backinclassic.BackInClassicMod;

//Thank You Vazkii for inspiring the reach_around!

import net.minecraft.block.material.Material;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;

import java.util.Map;

public class ReacharoundsoundProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency x for procedure Reacharoundsound!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency y for procedure Reacharoundsound!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency z for procedure Reacharoundsound!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency world for procedure Reacharoundsound!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
        if ((BackInClassicConfig.reach_around_block.get())) {
            if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK) {
                ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.place")),
                        SoundCategory.BLOCKS, (float) 1, (float) 1);
            }
            else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == net.minecraft.block.material.Material.GLASS) {
                ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")),
                        SoundCategory.BLOCKS, (float) 1, (float) 1);
            }
            else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == Material.ANVIL) {
                ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")),
                        SoundCategory.BLOCKS, (float) 1, (float) 1);
            }
            else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == Material.BARRIER) {
                ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.place")),
                        SoundCategory.BLOCKS, (float) 1, (float) 1);
            }
            else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == Material.ICE) {
                ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.ice.place")),
                        SoundCategory.BLOCKS, (float) 1, (float) 1);
            }
            else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == Material.CLAY) {
                ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.clay.place")),
                        SoundCategory.BLOCKS, (float) 1, (float) 1);
            }
            else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == Material.EARTH) {
                ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dirt.place")),
                        SoundCategory.BLOCKS, (float) 1, (float) 1);
            }
            else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == Material.GOURD) {
                ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.melon.place")),
                        SoundCategory.BLOCKS, (float) 1, (float) 1);
            }
            else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == Material.IRON) {
                ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_block.place")),
                        SoundCategory.BLOCKS, (float) 1, (float) 1);
            }
            else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == Material.PLANTS) {
                ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.place")),
                        SoundCategory.BLOCKS, (float) 1, (float) 1);
            }
            else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == Material.SAND) {
                ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.sand.place")),
                        SoundCategory.BLOCKS, (float) 1, (float) 1);
            }
            else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == Material.SPONGE) {
                ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.place")),
                        SoundCategory.BLOCKS, (float) 1, (float) 1);
            }
            else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == Material.WOOD) {
                ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.oak_planks.place")),
                        SoundCategory.BLOCKS, (float) 1, (float) 1);
            }
            else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == Material.WOOL) {
                ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.white_wool.place")),
                        SoundCategory.BLOCKS, (float) 1, (float) 1);
            }
            else {
                ((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.place")),
                        SoundCategory.BLOCKS, (float) 1, (float) 1);
            }
        }
	}
}
