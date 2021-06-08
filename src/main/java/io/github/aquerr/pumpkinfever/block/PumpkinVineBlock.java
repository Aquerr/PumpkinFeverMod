package io.github.aquerr.pumpkinfever.block;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.IForgeShearable;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.Map;

//TODO: Should connect to pumpkins and other pumpkin vines like redstone.
public class PumpkinVineBlock extends Block implements IForgeShearable, IWaterLoggable
{
    private enum PumpkinVineSide implements IStringSerializable
    {
        UP("up"),
//        NORTH("north"),
//        EAST("east"),
//        SOUTH("south"),
//        WEST("west"),
        LOW("low"),
        TALL("tall"),
        SIDE("side"),
        NONE("none");

        private final String name;

        PumpkinVineSide(String name)
        {
            this.name = name;
        }

        @Override
        public String getString()
        {
            return this.name;
        }
    }

    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<PumpkinVineSide> NORTH = EnumProperty.create("north", PumpkinVineSide.class);
    public static final EnumProperty<PumpkinVineSide> EAST = EnumProperty.create("east", PumpkinVineSide.class);
    public static final EnumProperty<PumpkinVineSide> SOUTH = EnumProperty.create("south", PumpkinVineSide.class);
    public static final EnumProperty<PumpkinVineSide> WEST = EnumProperty.create("west", PumpkinVineSide.class);

    private final Map<BlockState, VoxelShape> stateToShapeMap;
    private final Map<BlockState, VoxelShape> stateToCollisionShapeMap;

    private static final VoxelShape CENTER_POLE_SHAPE = Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 16.0D, 9.0D);
    private static final VoxelShape WALL_CONNECTION_NORTH_SIDE_SHAPE = Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 16.0D, 9.0D);
    private static final VoxelShape WALL_CONNECTION_SOUTH_SIDE_SHAPE = Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 16.0D, 16.0D);
    private static final VoxelShape WALL_CONNECTION_WEST_SIDE_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 7.0D, 9.0D, 16.0D, 9.0D);
    private static final VoxelShape WALL_CONNECTION_EAST_SIDE_SHAPE = Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 16.0D, 16.0D, 9.0D);

    public PumpkinVineBlock()
    {
        super(Properties.create(Material.LEAVES)
                .harvestTool(ToolType.AXE)
                .notSolid()
                .hardnessAndResistance(1.0F)
                .sound(SoundType.PLANT));
        setRegistryName("pumpkin_vine");
        this.setDefaultState(this.stateContainer.getBaseState().with(UP, Boolean.valueOf(true)).with(NORTH, PumpkinVineSide.NONE).with(EAST, PumpkinVineSide.NONE).with(SOUTH, PumpkinVineSide.NONE).with(WEST, PumpkinVineSide.NONE).with(WATERLOGGED, Boolean.valueOf(false)));
        this.stateToShapeMap = this.makeShapes(4.0F, 3.0F, 16.0F, 0.0F, 14.0F, 16.0F);
        this.stateToCollisionShapeMap = this.makeShapes(4.0F, 3.0F, 24.0F, 0.0F, 24.0F, 24.0F);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(UP, NORTH, EAST, WEST, SOUTH, WATERLOGGED);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return this.stateToShapeMap.get(state);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return this.stateToCollisionShapeMap.get(state);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        IWorldReader iworldreader = context.getWorld();
        BlockPos blockpos = context.getPos();
        FluidState fluidstate = context.getWorld().getFluidState(context.getPos());
        BlockPos blockpos1 = blockpos.north();
        BlockPos blockpos2 = blockpos.east();
        BlockPos blockpos3 = blockpos.south();
        BlockPos blockpos4 = blockpos.west();
        BlockPos blockpos5 = blockpos.up();
        BlockState blockstate = iworldreader.getBlockState(blockpos1);
        BlockState blockstate1 = iworldreader.getBlockState(blockpos2);
        BlockState blockstate2 = iworldreader.getBlockState(blockpos3);
        BlockState blockstate3 = iworldreader.getBlockState(blockpos4);
        BlockState blockstate4 = iworldreader.getBlockState(blockpos5);
        boolean flag = this.shouldConnect(blockstate, blockstate.isSolidSide(iworldreader, blockpos1, Direction.SOUTH), Direction.SOUTH);
        boolean flag1 = this.shouldConnect(blockstate1, blockstate1.isSolidSide(iworldreader, blockpos2, Direction.WEST), Direction.WEST);
        boolean flag2 = this.shouldConnect(blockstate2, blockstate2.isSolidSide(iworldreader, blockpos3, Direction.NORTH), Direction.NORTH);
        boolean flag3 = this.shouldConnect(blockstate3, blockstate3.isSolidSide(iworldreader, blockpos4, Direction.EAST), Direction.EAST);
        BlockState blockstate5 = this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(fluidstate.getFluid() == Fluids.WATER));
        return this.func_235626_a_(iworldreader, blockstate5, blockpos5, blockstate4, flag, flag1, flag2, flag3);
    }

    private BlockState func_235626_a_(IWorldReader reader, BlockState state, BlockPos pos, BlockState collisionState, boolean connectedSouth, boolean connectedWest, boolean connectedNorth, boolean connectedEast) {
        VoxelShape voxelshape = collisionState.getCollisionShapeUncached(reader, pos).project(Direction.DOWN);
        BlockState blockstate = this.func_235630_a_(state, connectedSouth, connectedWest, connectedNorth, connectedEast, voxelshape);
        return blockstate.with(UP, Boolean.valueOf(this.func_235628_a_(blockstate, collisionState, voxelshape)));
    }

    private boolean func_235628_a_(BlockState p_235628_1_, BlockState p_235628_2_, VoxelShape shape) {
        boolean flag = p_235628_2_.getBlock() instanceof WallBlock && p_235628_2_.get(UP);
        if (flag) {
            return true;
        } else {
            PumpkinVineSide wallheight = p_235628_1_.get(NORTH);
            PumpkinVineSide wallheight1 = p_235628_1_.get(SOUTH);
            PumpkinVineSide wallheight2 = p_235628_1_.get(EAST);
            PumpkinVineSide wallheight3 = p_235628_1_.get(WEST);
            boolean flag1 = wallheight1 == PumpkinVineSide.NONE;
            boolean flag2 = wallheight3 == PumpkinVineSide.NONE;
            boolean flag3 = wallheight2 == PumpkinVineSide.NONE;
            boolean flag4 = wallheight == PumpkinVineSide.NONE;
            boolean flag5 = flag4 && flag1 && flag2 && flag3 || flag4 != flag1 || flag2 != flag3;
            if (flag5) {
                return true;
            } else {
                boolean flag6 = wallheight == PumpkinVineSide.TALL && wallheight1 == PumpkinVineSide.TALL || wallheight2 == PumpkinVineSide.TALL && wallheight3 == PumpkinVineSide.TALL;
                if (flag6) {
                    return false;
                } else {
                    return p_235628_2_.getBlock().isIn(BlockTags.WALL_POST_OVERRIDE) || compareShapes(shape, CENTER_POLE_SHAPE);
                }
            }
        }
    }

    private BlockState func_235630_a_(BlockState state, boolean connectedSouth, boolean connectedWest, boolean connectedNorth, boolean connectedEast, VoxelShape shape) {
        return state.with(NORTH, this.func_235633_a_(connectedSouth, shape, WALL_CONNECTION_NORTH_SIDE_SHAPE)).with(EAST, this.func_235633_a_(connectedWest, shape, WALL_CONNECTION_EAST_SIDE_SHAPE)).with(SOUTH, this.func_235633_a_(connectedNorth, shape, WALL_CONNECTION_SOUTH_SIDE_SHAPE)).with(WEST, this.func_235633_a_(connectedEast, shape, WALL_CONNECTION_WEST_SIDE_SHAPE));
    }

    private PumpkinVineSide func_235633_a_(boolean p_235633_1_, VoxelShape p_235633_2_, VoxelShape p_235633_3_) {
        if (p_235633_1_) {
            return compareShapes(p_235633_2_, p_235633_3_) ? PumpkinVineSide.TALL : PumpkinVineSide.LOW;
        } else {
            return PumpkinVineSide.NONE;
        }
    }

    private static boolean compareShapes(VoxelShape shape1, VoxelShape shape2) {
        return !VoxelShapes.compare(shape2, shape1, IBooleanFunction.ONLY_FIRST);
    }

    private Map<BlockState, VoxelShape> makeShapes(float p_235624_1_, float p_235624_2_, float p_235624_3_, float p_235624_4_, float p_235624_5_, float p_235624_6_) {
        float f = 8.0F - p_235624_1_;
        float f1 = 8.0F + p_235624_1_;
        float f2 = 8.0F - p_235624_2_;
        float f3 = 8.0F + p_235624_2_;
        VoxelShape voxelshape = Block.makeCuboidShape((double)f, 0.0D, (double)f, (double)f1, (double)p_235624_3_, (double)f1);
        VoxelShape voxelshape1 = Block.makeCuboidShape((double)f2, (double)p_235624_4_, 0.0D, (double)f3, (double)p_235624_5_, (double)f3);
        VoxelShape voxelshape2 = Block.makeCuboidShape((double)f2, (double)p_235624_4_, (double)f2, (double)f3, (double)p_235624_5_, 16.0D);
        VoxelShape voxelshape3 = Block.makeCuboidShape(0.0D, (double)p_235624_4_, (double)f2, (double)f3, (double)p_235624_5_, (double)f3);
        VoxelShape voxelshape4 = Block.makeCuboidShape((double)f2, (double)p_235624_4_, (double)f2, 16.0D, (double)p_235624_5_, (double)f3);
        VoxelShape voxelshape5 = Block.makeCuboidShape((double)f2, (double)p_235624_4_, 0.0D, (double)f3, (double)p_235624_6_, (double)f3);
        VoxelShape voxelshape6 = Block.makeCuboidShape((double)f2, (double)p_235624_4_, (double)f2, (double)f3, (double)p_235624_6_, 16.0D);
        VoxelShape voxelshape7 = Block.makeCuboidShape(0.0D, (double)p_235624_4_, (double)f2, (double)f3, (double)p_235624_6_, (double)f3);
        VoxelShape voxelshape8 = Block.makeCuboidShape((double)f2, (double)p_235624_4_, (double)f2, 16.0D, (double)p_235624_6_, (double)f3);
        ImmutableMap.Builder<BlockState, VoxelShape> builder = ImmutableMap.builder();

        for(Boolean obool : UP.getAllowedValues()) {
            for(PumpkinVineSide wallheight : EAST.getAllowedValues()) {
                for(PumpkinVineSide wallheight1 : NORTH.getAllowedValues()) {
                    for(PumpkinVineSide wallheight2 : WEST.getAllowedValues()) {
                        for(PumpkinVineSide wallheight3 : SOUTH.getAllowedValues()) {
                            VoxelShape voxelshape9 = VoxelShapes.empty();
                            voxelshape9 = getHeightAlteredShape(voxelshape9, wallheight, voxelshape4, voxelshape8);
                            voxelshape9 = getHeightAlteredShape(voxelshape9, wallheight2, voxelshape3, voxelshape7);
                            voxelshape9 = getHeightAlteredShape(voxelshape9, wallheight1, voxelshape1, voxelshape5);
                            voxelshape9 = getHeightAlteredShape(voxelshape9, wallheight3, voxelshape2, voxelshape6);
                            if (obool) {
                                voxelshape9 = VoxelShapes.or(voxelshape9, voxelshape);
                            }

                            BlockState blockstate = this.getDefaultState().with(UP, obool).with(EAST, wallheight).with(WEST, wallheight2).with(NORTH, wallheight1).with(SOUTH, wallheight3);
                            builder.put(blockstate.with(WATERLOGGED, Boolean.valueOf(false)), voxelshape9);
                            builder.put(blockstate.with(WATERLOGGED, Boolean.valueOf(true)), voxelshape9);
                        }
                    }
                }
            }
        }

        return builder.build();
    }

    private static VoxelShape getHeightAlteredShape(VoxelShape baseShape, PumpkinVineSide height, VoxelShape lowShape, VoxelShape tallShape) {
        if (height == PumpkinVineSide.TALL) {
            return VoxelShapes.or(baseShape, tallShape);
        } else {
            return height == PumpkinVineSide.LOW ? VoxelShapes.or(baseShape, lowShape) : baseShape;
        }
    }

    private boolean shouldConnect(BlockState state, boolean sideSolid, Direction direction) {
        Block block = state.getBlock();
        boolean flag = block instanceof FenceGateBlock && FenceGateBlock.isParallel(state, direction);
        return state.isIn(BlockTags.WALLS) || !cannotAttach(block) && sideSolid || block instanceof PaneBlock || flag;
    }

    protected static boolean canConnectTo(BlockState blockState, IBlockReader world, BlockPos pos, @Nullable Direction side) {
        if (blockState.matchesBlock(Blocks.REDSTONE_WIRE)) {
            return true;
        } else if (blockState.matchesBlock(Blocks.REPEATER)) {
            Direction direction = blockState.get(RepeaterBlock.HORIZONTAL_FACING);
            return direction == side || direction.getOpposite() == side;
        } else if (blockState.matchesBlock(Blocks.OBSERVER)) {
            return side == blockState.get(ObserverBlock.FACING);
        } else {
            return blockState.canConnectRedstone(world, pos, side) && side != null;
        }
    }
}
