package net.backinclassic.procedures.structuretool;

import net.backinclassic.BackInClassicMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.HashMap;

public class PlaceStructure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency guistate for procedure PlaceStructure!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency x for procedure PlaceStructure!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency y for procedure PlaceStructure!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency z for procedure PlaceStructure!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency world for procedure PlaceStructure!");
			return;
		}
		HashMap guistate = (HashMap) dependencies.get("guistate");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:AddStructure");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText())).equals("Cube")) || ((((new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:AddStructure");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText())).equals("Cube"))
				&& ((world instanceof World) ? ((World) world).isBlockPowered(new BlockPos((int) x, (int) y, (int) z)) : false)))) {
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("back_in_classic", "cube"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x + 0), (int) (y + 0), (int) (z + 0)),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
            }
		}        
        else if (((((new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:AddStructure");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText())).equals("Path")) || ((((new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:AddStructure");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText())).equals("Path"))
				&& ((world instanceof World) ? ((World) world).isBlockPowered(new BlockPos((int) x, (int) y, (int) z)) : false)))) {
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("back_in_classic", "gravel_path"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x + 0), (int) (y + 0), (int) (z + 0)),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
			}
		}
	}
}
