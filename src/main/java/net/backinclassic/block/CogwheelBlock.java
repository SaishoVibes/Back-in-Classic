
package net.backinclassic.block;
import net.backinclassic.BackInClassicModElements;
import net.backinclassic.procedures.CogwheelValueProcedure;
/*
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.state.properties.SlabType;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.List;
import java.util.Collections;

@BackInClassicModElements.ModElement.Tag
public class SodSlabBlock extends BackInClassicModElements.ModElement {
	@ObjectHolder("back_in_classic:sod_slab")
	public static final Block block = null;
	public SodSlabBlock(BackInClassicModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutoutMipped());
	}
	public static class CustomBlock extends SlabBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.EARTH).sound(SoundType.GROUND).hardnessAndResistance(0.5f, 10f).setLightLevel(s -> 0)
					.harvestLevel(-1).harvestTool(ToolType.SHOVEL).setRequiresTool().notSolid().setOpaque((bs, br, bp) -> false));
			setRegistryName("sod_slab");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, state.get(TYPE) == SlabType.DOUBLE ? 2 : 1));
		}
	}
}*/
import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.StateContainer;
import net.minecraft.state.BooleanProperty;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockItem;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.FluidState;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.world.server.ServerWorld;

import java.util.List;
import java.util.Collections;

import com.google.common.collect.ImmutableMap;

@BackInClassicModElements.ModElement.Tag
public class CogwheelBlock extends BackInClassicModElements.ModElement {
	@ObjectHolder("back_in_classic:cogwheel")
	public static final Block block = null;
	public CogwheelBlock(BackInClassicModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
	public static class CustomBlock extends Block implements IWaterLoggable {
		public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
        //public static final BooleanProperty LIT = BlockStateProperties.LIT;
		public CustomBlock() {
			super(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0).harvestLevel(-1)
					.harvestTool(ToolType.PICKAXE).setRequiresTool().doesNotBlockMovement().notSolid().setOpaque((bs, br, bp) -> false));
			this.setDefaultState(this.stateContainer.getBaseState().with(WATERLOGGED, false));
            //this.setDefaultState(this.getDefaultState().with(LIT, Boolean.valueOf(false)));
			setRegistryName("cogwheel");
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return state.getFluidState().isEmpty();
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 0;
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			boolean flag = context.getWorld().getFluidState(context.getPos()).getFluid() == Fluids.WATER;
			return this.getDefaultState().with(WATERLOGGED, flag);
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(WATERLOGGED);
		}

		@Override
		public FluidState getFluidState(BlockState state) {
			return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
		}

		@Override
		public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos,
				BlockPos facingPos) {
			if (state.get(WATERLOGGED)) {
				world.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
			}
			return super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
		}
        
        /*public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
            if (!worldIn.isRemote) {
                boolean flag = state.get(LIT);
                if (flag != worldIn.isBlockPowered(pos)) {
                    if (flag) {
                    worldIn.getPendingBlockTicks().scheduleTick(pos, this, 4);
                    } else {
                    worldIn.setBlockState(pos, state.func_235896_a_(LIT), 2);
                    }
                }

            }
        }

        public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
            if (state.get(LIT) && !worldIn.isBlockPowered(pos)) {
                worldIn.setBlockState(pos, state.func_235896_a_(LIT), 2);
            }
        
        }*/
        
        /*protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
            builder.add(LIT);
        }*/
        
		@Override
		public boolean canProvidePower(BlockState state) {
			return true;
		}

		/*@Override
		public int getWeakPower(BlockState blockstate, IBlockReader blockAccess, BlockPos pos, Direction side) {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			World world = (World) blockAccess;
			return (int) CogwheelValueProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world));
		}*/
        
        @Override
		public int getWeakPower(BlockState blockstate, IBlockReader blockAccess, BlockPos pos, Direction side) {
			return 15;
		}

		@Override
		public boolean canConnectRedstone(BlockState state, IBlockReader world, BlockPos pos, Direction side) {
			return true;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}

