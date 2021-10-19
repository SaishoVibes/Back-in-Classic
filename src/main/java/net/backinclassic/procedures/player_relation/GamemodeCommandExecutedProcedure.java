package net.backinclassic.procedures.player_relation;

import net.minecraft.world.GameType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.backinclassic.BackInClassicMod;

import java.util.Map;
import java.util.HashMap;

public class GamemodeCommandExecutedProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency entity for procedure GamemodeCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency cmdparams for procedure GamemodeCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		if (((("s").equals((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()))) || (("0").equals((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()))))) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).setGameType(GameType.SURVIVAL);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Set gamemode to survival."), (false));
			}
		} else if (((("c").equals((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()))) || (("1").equals((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()))))) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).setGameType(GameType.CREATIVE);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Set gamemode to creative."), (false));
			}
		} else if (((("a").equals((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()))) || (("2").equals((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()))))) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).setGameType(GameType.ADVENTURE);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Set gamemode to adventure."), (false));
			}
		} else if (((("sp").equals((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()))) || (("3").equals((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()))))) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).setGameType(GameType.SPECTATOR);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Set gamemode to spectator."), (false));
			}
		}
	}
}
