package net.backinclassic.mixin.reacharound;

import net.backinclassic.BackInClassicConfig;
import net.backinclassic.BackInClassicMod;
import net.backinclassic.reach_around.ReacharoundsoundProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;

import java.util.HashMap;
import java.util.Map;

@Mixin(BlockItem.class)
public class BlockItemMixin {


    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        PlayerEntity entity = event.getPlayer();
        if (event.getHand() != entity.getActiveHand()) {
            return;
        }
        double i = event.getPos().getX();
        double j = event.getPos().getY();
        double k = event.getPos().getZ();
        IWorld world = event.getWorld();
        Map<String, Object> dependencies = new HashMap<>();
        dependencies.put("x", i);
        dependencies.put("y", j);
        dependencies.put("z", k);
        dependencies.put("world", world);
        dependencies.put("entity", entity);
        dependencies.put("event", event);
        executeProcedure(dependencies);
    }

    private static void executeProcedure(Map<String, Object> dependencies) {
        Entity entity = (Entity) dependencies.get("entity");
        double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
        double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
        double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
        Level world = (IWorld) dependencies.get("world");
        double rtx = 0;
        double rty = 0;
        double rtz = 0;
        
        Vec3 eyePos = entity.getEyePosition(1F);
        Vec3 viewVector = entity.getViewVector(1f);

        BlockPos clipPos = entity.level.clip(new ClipContext(eyePos,
                eyePos.add(viewVector.x * 2, viewVector.y * 2, viewVector.z * 2),
                ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)
        ).getBlockPos();

        if (((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.AIR))
                && (BackInClassicConfig.reach_around_block.get() == true) && ((new Object() {
            public BlockState toBlock(ItemStack _stk) {
                if (_stk.getItem() instanceof BlockItem) {
                    return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
                }
                return Blocks.AIR.getDefaultState();
            }
        }.toBlock(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))).isValidPosition(world,
                new BlockPos((int) rtx, (int) rty, (int) rtz))))) {
            if ((!((((world.getBlockState(new BlockPos((int) (rtx - 1), (int) rty, (int) (rtz - 0)))).getBlock() == Blocks.AIR)
                    && ((world.getBlockState(new BlockPos((int) (rtx + 1), (int) rty, (int) (rtz - 0)))).getBlock() == Blocks.AIR))
                    && (((world.getBlockState(new BlockPos((int) (rtx - 0), (int) rty, (int) (rtz - 1)))).getBlock() == Blocks.AIR)
                    && ((world.getBlockState(new BlockPos((int) (rtx + 0), (int) rty, (int) (rtz + 1)))).getBlock() == Blocks.AIR)))
                    && ((world.getBlockState(new BlockPos((int) (rtx + 0), (int) rty, (int) (rtz + 0)))).getBlock() == Blocks.AIR))) {
                world.setBlockState(new BlockPos((int) rtx, (int) rty, (int) rtz), (new Object() {
                    public BlockState toBlock(ItemStack _stk) {
                        if (_stk.getItem() instanceof BlockItem) {
                            return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
                        }
                        return Blocks.AIR.getDefaultState();
                    }
                }.toBlock(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))), 3);
                if (entity instanceof LivingEntity) {
                    ((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
                }
                if ((!(new Object() {
                    public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayerEntity) {
                            return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
                        } else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
                            NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
                                    .getPlayerInfo(((LocalPlayer) _ent).getGameProfile().getId());
                            return _npi != null && _npi.getGameType() == GameType.CREATIVE;
                        }
                        return false;
                    }
                }.checkGamemode(entity)))) {
                    (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
                }
                {
                    Map<String, Object> $_dependencies = new HashMap<>();
                    $_dependencies.put("entity", entity);
                    $_dependencies.put("world", world);
                    $_dependencies.put("x", rtx);
                    $_dependencies.put("y", rty);
                    $_dependencies.put("z", rtz);
                    ReacharoundsoundProcedure.executeProcedure($_dependencies);
                }
            }
        }
    }
    
            
}
