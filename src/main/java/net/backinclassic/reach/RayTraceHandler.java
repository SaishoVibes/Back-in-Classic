package net.backinclassic.reach;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

public class RayTraceHandler {

	public static HitResult rayTrace(Entity entity, Level world, Player player, Block blockMode, Fluid fluidMode) {
		return rayTrace(entity, world, player, blockMode, fluidMode, getEntityRange(player));
	}
	
	public static HitResult rayTrace(Entity entity, Level world, Entity player, Block blockMode, Fluid fluidMode, double range) {
		 Pair<Vec3, Vec3> params = getEntityParams(player);
		
		return rayTrace(entity, world, params.getLeft(), params.getRight(), blockMode, fluidMode, range);
	}
	
	public static HitResult rayTrace(Entity entity, Level world, Vec3 startPos, Vec3 ray, Block blockMode, Fluid fluidMode, double range) {
		return rayTrace(entity, world, startPos, ray.scale(range), blockMode, fluidMode);
	}

	public static HitResult rayTrace(Entity entity, Level world, Vec3 startPos, Vec3 ray, Block blockMode, Fluid fluidMode) {
		Vec3 end = startPos.add(ray);
		ClipContext context = new ClipContext(startPos, end, blockMode, fluidMode, entity);
		return world.clip(context);
	}
	
	public static double getEntityRange(LivingEntity player) {
		return player.getAttribute(ForgeMod.REACH_DISTANCE.get()).getValue();
	}
	
	public static Pair<Vec3, Vec3> getEntityParams(Entity player) {
		float scale = 1.0F;
		float pitch = player.xRotO + (player.getXRot() - player.xRotO) * scale;
		float yaw = player.yRotO + (player.getYRot() - player.yRotO) * scale;
		Vec3 pos = player.position();
		double posX = player.xo + (pos.x - player.xo) * scale;
		double posY = player.yo + (pos.y - player.yo) * scale;
		if (player instanceof Player)
			posY += ((Player) player).getEyeHeight();
		double posZ = player.zo + (pos.z - player.zo) * scale;
		Vec3 rayPos = new Vec3(posX, posY, posZ);

		float zYaw = -Mth.cos(yaw * (float) Math.PI / 180);
		float xYaw = Mth.sin(yaw * (float) Math.PI / 180);
		float pitchMod = -Mth.cos(pitch * (float) Math.PI / 180);
		float azimuth = -Mth.sin(pitch * (float) Math.PI / 180);
		float xLen = xYaw * pitchMod;
		float yLen = zYaw * pitchMod;
		Vec3 ray = new Vec3(xLen, azimuth, yLen);
		
		return Pair.of(rayPos, ray);
	}
	
}