package io.github.aquerr.pumpkinfever.block;

import com.google.common.collect.Maps;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.IForgeShearable;
import net.minecraftforge.common.ToolType;

import java.util.Map;

//TODO: Should connect to pumpkins and other pumpkin vines like glass pane.
public class PumpkinVineBlock extends Block implements IForgeShearable, IWaterLoggable
{
    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

//    private final Map<BlockState, VoxelShape> stateToShapeMap;
//    private final Map<BlockState, VoxelShape> stateToCollisionShapeMap;

    private static final VoxelShape CENTER_POLE_SHAPE = Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 16.0D, 9.0D);
    private static final VoxelShape WALL_CONNECTION_NORTH_SIDE_SHAPE = Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 16.0D, 9.0D);
    private static final VoxelShape WALL_CONNECTION_SOUTH_SIDE_SHAPE = Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 16.0D, 16.0D);
    private static final VoxelShape WALL_CONNECTION_WEST_SIDE_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 7.0D, 9.0D, 16.0D, 9.0D);
    private static final VoxelShape WALL_CONNECTION_EAST_SIDE_SHAPE = Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 16.0D, 16.0D, 9.0D);

    private static final Direction[] FACING_VALUES = Direction.values();
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    public static final Map<Direction, BooleanProperty> FACING_TO_PROPERTY_MAP = Util.make(Maps.newEnumMap(Direction.class), (directions) -> {
        directions.put(Direction.NORTH, NORTH);
        directions.put(Direction.EAST, EAST);
        directions.put(Direction.SOUTH, SOUTH);
        directions.put(Direction.WEST, WEST);
        directions.put(Direction.UP, UP);
        directions.put(Direction.DOWN, DOWN);
    });
    protected final VoxelShape[] shapes;

    public PumpkinVineBlock()
    {
        super(Properties.create(Material.LEAVES)
                .harvestTool(ToolType.AXE)
                .notSolid()
                .hardnessAndResistance(1.0F)
                .sound(SoundType.PLANT));

        setRegistryName("pumpkin_vine");
        this.setDefaultState(this.stateContainer.getBaseState()
                .with(NORTH, Boolean.FALSE)
                .with(EAST, Boolean.FALSE)
                .with(SOUTH, Boolean.FALSE)
                .with(WEST, Boolean.FALSE)
                .with(UP, Boolean.FALSE)
                .with(DOWN, Boolean.FALSE)
                .with(WATERLOGGED, Boolean.FALSE));

//        this.stateToShapeMap = this.makeShapes(4.0F, 3.0F, 16.0F, 0.0F, 14.0F, 16.0F);
//        this.stateToCollisionShapeMap = this.makeShapes(4.0F, 3.0F, 24.0F, 0.0F, 24.0F, 24.0F);

        this.shapes = makeShapes();
    }

    private VoxelShape[] makeShapes()
    {
//        VoxelShape voxelshape = Block.makeCuboidShape(0.2, 0, 0.2, 0.8, 0.5, 0.8);
        VoxelShape voxelshape = VoxelShapes.create(2, 0, 2, 8, 5, 8);
        VoxelShape[] avoxelshape = new VoxelShape[FACING_VALUES.length];

        for(int i = 0; i < FACING_VALUES.length; ++i) {
            Direction direction = FACING_VALUES[i];
            avoxelshape[i] = VoxelShapes.create(0.5D + Math.min((double)(-0.1), (double)direction.getXOffset() * 0.5D), 0.5D + Math.min((double)(-0.1), (double)direction.getYOffset() * 0.5D), 0.5D + Math.min((double)(-0.1), (double)direction.getZOffset() * 0.5D), 0.5D + Math.max((double)0.1, (double)direction.getXOffset() * 0.5D), 0.5D + Math.max((double)0.1, (double)direction.getYOffset() * 0.5D), 0.5D + Math.max((double)0.1, (double)direction.getZOffset() * 0.5D));
        }

//        VoxelShape[] avoxelshape1 = new VoxelShape[64];

//        for(int k = 0; k < 64; ++k) {
//            VoxelShape voxelshape1 = voxelshape;
//
//            for(int j = 0; j < FACING_VALUES.length; ++j) {
//                if ((k & 1 << j) != 0) {
//                    voxelshape1 = VoxelShapes.or(voxelshape1, avoxelshape[j]);
//                }
//            }
//
//            avoxelshape1[k] = voxelshape1;
//        }

        return avoxelshape;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN, WATERLOGGED);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return this.shapes[this.getShapeIndex(state)];
    }

    protected int getShapeIndex(BlockState state) {
        for(int j = 0; j < FACING_VALUES.length; ++j) {
            if (state.get(FACING_TO_PROPERTY_MAP.get(FACING_VALUES[j]))) {
                return j;
            }
        }
        return 0;
//        int i = 0;
//
//        for(int j = 0; j < FACING_VALUES.length; ++j) {
//            if (state.get(FACING_TO_PROPERTY_MAP.get(FACING_VALUES[j]))) {
//                i |= 1 << j;
//            }
//        }
//
//        return i;
    }

//    @Override
//    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
//        return this.stateToShapeMap.get(state);
//        return makeShapes(4.0F, 3.0F, 16.0F, 0.0F, 14.0F, 16.0F).get(state);
//        return WALL_CONNECTION_NORTH_SIDE_SHAPE;
//    }

//    @Override
//    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
//        return this.stateToCollisionShapeMap.get(state);
//        return this.makeShapes(4.0F, 3.0F, 24.0F, 0.0F, 24.0F, 24.0F).get(state);
//    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        World iblockreader = context.getWorld();
        BlockPos currentPos = context.getPos();
        FluidState fluidStateAtPos = context.getWorld().getFluidState(context.getPos());
        BlockState blockStateNorth = iblockreader.getBlockState(currentPos.north());
        BlockState blockStateSouth = iblockreader.getBlockState(currentPos.south());
        BlockState blockStateWest = iblockreader.getBlockState(currentPos.west());
        BlockState blockStateEast = iblockreader.getBlockState(currentPos.east());
        BlockState blockStateUp = iblockreader.getBlockState(currentPos.up());
        BlockState blockStateDown = iblockreader.getBlockState(currentPos.down());
        return this.getDefaultState()
                .with(NORTH, isConnectableBlock(blockStateNorth))
                .with(SOUTH, isConnectableBlock(blockStateSouth))
                .with(WEST, isConnectableBlock(blockStateWest))
                .with(EAST, isConnectableBlock(blockStateEast))
                .with(UP, isConnectableBlock(blockStateUp))
                .with(DOWN, isConnectableBlock(blockStateDown))
                .with(WATERLOGGED, fluidStateAtPos.getFluid() == Fluids.WATER);
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.isValidPosition(worldIn, currentPos)) {
            worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
            return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        } else {
            boolean flag = facingState.getBlock() == this || facingState.matchesBlock(ModBlocks.PUMPKIN_VINE_BLOCK) || facing == Direction.DOWN && facingState.matchesBlock(ModBlocks.PUMPKIN_VINE_BLOCK);
            return stateIn.with(FACING_TO_PROPERTY_MAP.get(facing), flag);
        }
    }

    protected static boolean isConnectableBlock(BlockState blockState)
    {
        return blockState.getBlock() instanceof PumpkinVineBlock || blockState.getBlock() instanceof PumpkinBlock;
    }
}
