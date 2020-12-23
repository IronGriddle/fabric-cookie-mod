package net.cookiemod.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.stream.Stream;

import static net.cookiemod.registry.Items.BIGCOOKIE_ITEM;

public class BigCookie extends Block {


    //TODO: change material sound so this thing isn't like stone.
    //TODO: Add a recipe or a way to make a big cookie.
    //TODO: Add a loot-table.
    //TODO: change the model when the player holds it.


    private static final VoxelShape SHAPE_1 =  Block.createCuboidShape(2, -1, 2, 14, 2, 14);
    private static final VoxelShape SHAPE_2 =  VoxelShapes.combineAndSimplify(Block.createCuboidShape(2, -1, 2, 14, 2, 14),
            Block.createCuboidShape(2, 2, 2, 14, 5, 14), BooleanBiFunction.OR);

    private static final VoxelShape SHAPE_3 = Stream.of(
            Block.createCuboidShape(2, -1, 2, 14, 2, 14),
            Block.createCuboidShape(2, 2, 2, 14, 5, 14),
            Block.createCuboidShape(2, 5, 2, 14, 8, 14)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR);}).get();

    private static final VoxelShape SHAPE_4 = Stream.of(
            Block.createCuboidShape(2, -1, 2, 14, 2, 14),
            Block.createCuboidShape(2, 2, 2, 14, 5, 14),
            Block.createCuboidShape(2, 5, 2, 14, 8, 14),
            Block.createCuboidShape(2, 8, 2, 14, 11, 14)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR);}).get();


    //state management
    public static final IntProperty BIGCOOKIELAYERS = IntProperty.of("bigcookielayer", 1, 4);


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(BIGCOOKIELAYERS)) {
            case 1:
                return SHAPE_1;
            case 2:
                return SHAPE_2;
            case 3:
                return SHAPE_3;
            case 4:
                return SHAPE_4;
            default:
                return  SHAPE_1;
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(BIGCOOKIELAYERS);
    }



    public BigCookie(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(BIGCOOKIELAYERS, 1));

    }




    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        ItemStack itemstack = player.getStackInHand(hand);

        int i = state.get(BIGCOOKIELAYERS);

        //If the player is holding nothing, then remove a big cookie from the big cookie stack.
        if (itemstack.isEmpty()) {
            if (i - 1 <= 0){
                world.removeBlock(pos, false);

                if (!world.isClient()) {

                    dropStack(world, pos, new ItemStack(BIGCOOKIE_ITEM.asItem(), 1));
                }

            } else{
                world.setBlockState(pos, state.with(BIGCOOKIELAYERS, Integer.valueOf(i - 1)), 3);

                if (!world.isClient()) {
                    dropStack(world, pos, new ItemStack(BIGCOOKIE_ITEM.asItem(), 1));
                }

            }

            return ActionResult.SUCCESS;

            //If the player is holding a big cookie, then remove it from the player and "add" it to the stack of cookies.
        } else if (itemstack.getItem() == BIGCOOKIE_ITEM.asItem()) {

            if (Integer.valueOf(i + 1) < 5){
                player.inventory.removeStack(player.inventory.selectedSlot, 1);
                world.setBlockState(pos, state.with(BIGCOOKIELAYERS, Integer.valueOf(i + 1)), 3);
            }

            return ActionResult.SUCCESS;

        } else {
            return ActionResult.PASS;
        }

    }
}
