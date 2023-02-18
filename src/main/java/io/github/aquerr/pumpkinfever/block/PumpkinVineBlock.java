package io.github.aquerr.pumpkinfever.block;

import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.PumpkinBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IForgeShearable;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

//TODO: Should connect to pumpkins and other pumpkin vines like glass pane.
public class PumpkinVineBlock extends BushBlock implements IForgeShearable, SimpleWaterloggedBlock
{
    public static final String REGISTRY_NAME = "pumpkin_vine";

    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

//    private final Map<BlockState, VoxelShape> stateToShapeMap;
//    private final Map<BlockState, VoxelShape> stateToCollisionShapeMap;

    private static final VoxelShape CENTER_POLE_SHAPE = Block.box(7.0D, 0.0D, 7.0D, 9.0D, 16.0D, 9.0D);
    private static final VoxelShape WALL_CONNECTION_NORTH_SIDE_SHAPE = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 16.0D, 9.0D);
    private static final VoxelShape WALL_CONNECTION_SOUTH_SIDE_SHAPE = Block.box(7.0D, 0.0D, 7.0D, 9.0D, 16.0D, 16.0D);
    private static final VoxelShape WALL_CONNECTION_WEST_SIDE_SHAPE = Block.box(0.0D, 0.0D, 7.0D, 9.0D, 16.0D, 9.0D);
    private static final VoxelShape WALL_CONNECTION_EAST_SIDE_SHAPE = Block.box(7.0D, 0.0D, 7.0D, 16.0D, 16.0D, 9.0D);

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
        super(Properties.of(Material.LEAVES)
                .requiresCorrectToolForDrops()
                .noOcclusion()
                .strength(1.0F)
                .sound(SoundType.GRASS));

//        this.registerDefaultState(this.stateDefinition.any().setValue(PICKLES, Integer.valueOf(1)).setValue(WATERLOGGED, Boolean.valueOf(true)));

        this.registerDefaultState(this.stateDefinition.any()
                .setValue(NORTH, Boolean.FALSE)
                .setValue(EAST, Boolean.FALSE)
                .setValue(SOUTH, Boolean.FALSE)
                .setValue(WEST, Boolean.FALSE)
                .setValue(UP, Boolean.FALSE)
                .setValue(DOWN, Boolean.FALSE)
                .setValue(WATERLOGGED, Boolean.FALSE));

//        this.stateToShapeMap = this.makeShapes(4.0F, 3.0F, 16.0F, 0.0F, 14.0F, 16.0F);
//        this.stateToCollisionShapeMap = this.makeShapes(4.0F, 3.0F, 24.0F, 0.0F, 24.0F, 24.0F);

        this.shapes = makeShapes();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder)
    {
        stateBuilder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN, WATERLOGGED);
    }

    private VoxelShape[] makeShapes()
    {
//        VoxelShape voxelshape = Block.makeCuboidShape(0.2, 0, 0.2, 0.8, 0.5, 0.8);
        VoxelShape voxelshape = Shapes.create(2, 0, 2, 8, 5, 8);
        VoxelShape[] avoxelshape = new VoxelShape[FACING_VALUES.length];

        for(int i = 0; i < FACING_VALUES.length; ++i) {
            Direction direction = FACING_VALUES[i];
            avoxelshape[i] = Shapes.create(0.5D + Math.min((double)(-0.1), (double)direction.getStepX() * 0.5D), 0.5D + Math.min((double)(-0.1), (double)direction.getStepY() * 0.5D), 0.5D + Math.min((double)(-0.1), (double)direction.getStepZ() * 0.5D), 0.5D + Math.max((double)0.1, (double)direction.getStepX() * 0.5D), 0.5D + Math.max((double)0.1, (double)direction.getStepY() * 0.5D), 0.5D + Math.max((double)0.1, (double)direction.getStepZ() * 0.5D));
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

//    @Override
//    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
//        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN, WATERLOGGED);
//    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter p_58051_, BlockPos p_58052_, CollisionContext p_58053_) {
        return this.shapes[this.getShapeIndex(state)];
    }

    protected int getShapeIndex(BlockState state)
    {
        for (int j = 0; j < FACING_VALUES.length; ++j)
        {
            if (state.getValue(FACING_TO_PROPERTY_MAP.get(FACING_VALUES[j])))
            {
                return j;
            }
        }
        return 0;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        Level iblockreader = context.getLevel();
        BlockPos currentPos = context.getClickedPos();
        FluidState fluidStateAtPos = context.getLevel().getFluidState(context.getClickedPos());
        BlockState blockStateNorth = iblockreader.getBlockState(currentPos.north());
        BlockState blockStateSouth = iblockreader.getBlockState(currentPos.south());
        BlockState blockStateWest = iblockreader.getBlockState(currentPos.west());
        BlockState blockStateEast = iblockreader.getBlockState(currentPos.east());
        BlockState blockStateUp = iblockreader.getBlockState(currentPos.above());
        BlockState blockStateDown = iblockreader.getBlockState(currentPos.below());
        return this.defaultBlockState()
                .setValue(NORTH, isConnectableBlock(blockStateNorth))
                .setValue(SOUTH, isConnectableBlock(blockStateSouth))
                .setValue(WEST, isConnectableBlock(blockStateWest))
                .setValue(EAST, isConnectableBlock(blockStateEast))
                .setValue(UP, isConnectableBlock(blockStateUp))
                .setValue(DOWN, isConnectableBlock(blockStateDown))
                .setValue(WATERLOGGED, fluidStateAtPos.getType() == Fluids.WATER);
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction direction, BlockState state, LevelAccessor levelAccessor, BlockPos blockPosIn, BlockPos blockPos)
    {
//        if (stateIn.getValue(WATERLOGGED))
//            levelAccessor.scheduleTick(blockPosIn, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
//
//        if (direction == Direction.DOWN) {
//            return super.updateShape(stateIn, direction, state, levelAccessor, blockPosIn, blockPos);
//        } else {
//            boolean flag = state.getBlock() == this || state.matchesBlock(ModBlocks.PUMPKIN_VINE_BLOCK) || facing == Direction.DOWN && state.matchesBlock(ModBlocks.PUMPKIN_VINE_BLOCK);
//            return stateIn.setValue(FACING_TO_PROPERTY_MAP.get(facing), flag);
//        }
        return stateIn;
    }

    protected static boolean isConnectableBlock(BlockState blockState)
    {
        return blockState.getBlock() instanceof PumpkinVineBlock || blockState.getBlock() instanceof PumpkinBlock;
    }

    private BlockState sideUpdate(LevelReader p_57989_, BlockPos p_57990_, BlockState p_57991_, BlockPos p_57992_, BlockState p_57993_, Direction p_57994_) {
        Direction direction = p_57994_.getOpposite();
        boolean flag = p_57994_ == Direction.NORTH ? this.connectsTo(p_57993_, p_57993_.isFaceSturdy(p_57989_, p_57992_, direction), direction) : isConnected(p_57991_, NORTH);
        boolean flag1 = p_57994_ == Direction.EAST ? this.connectsTo(p_57993_, p_57993_.isFaceSturdy(p_57989_, p_57992_, direction), direction) : isConnected(p_57991_, EAST);
        boolean flag2 = p_57994_ == Direction.SOUTH ? this.connectsTo(p_57993_, p_57993_.isFaceSturdy(p_57989_, p_57992_, direction), direction) : isConnected(p_57991_, SOUTH);
        boolean flag3 = p_57994_ == Direction.WEST ? this.connectsTo(p_57993_, p_57993_.isFaceSturdy(p_57989_, p_57992_, direction), direction) : isConnected(p_57991_, WEST);
        BlockPos blockpos = p_57990_.above();
        BlockState blockstate = p_57989_.getBlockState(blockpos);
        return this.updateShape(p_57989_, p_57991_, blockpos, blockstate, flag, flag1, flag2, flag3);
    }

    private BlockState updateShape(LevelReader p_57980_, BlockState p_57981_, BlockPos p_57982_, BlockState p_57983_, boolean p_57984_, boolean p_57985_, boolean p_57986_, boolean p_57987_) {
        VoxelShape voxelshape = p_57983_.getCollisionShape(p_57980_, p_57982_).getFaceShape(Direction.DOWN);
        BlockState blockstate = this.updateSides(p_57981_, p_57984_, p_57985_, p_57986_, p_57987_, voxelshape);
        return blockstate.setValue(UP, true);
    }

    private boolean connectsTo(BlockState blockState, boolean p_58022_, Direction direction) {
        return isConnectableBlock(blockState);
//        Block block = p_58021_.getBlock();
//        boolean flag = block instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(p_58021_, p_58023_);
//        return p_58021_.is(BlockTags.WALLS) || !isExceptionForConnection(p_58021_) && p_58022_ || block instanceof IronBarsBlock || flag;
    }

    private static boolean isConnected(BlockState p_58011_, BooleanProperty p_58012_) {
        return p_58011_.getValue(p_58012_) != false;
    }

    private BlockState updateSides(BlockState p_58025_, boolean p_58026_, boolean p_58027_, boolean p_58028_, boolean p_58029_, VoxelShape p_58030_) {
        return p_58025_.setValue(NORTH, true)
                .setValue(EAST, true)
                .setValue(SOUTH, true)
                .setValue(WEST, true);
    }
}
