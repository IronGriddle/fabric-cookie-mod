package net.cookiemod.blocks;

import net.cookiemod.entities.MirrorEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Mirror extends Block implements BlockEntityProvider {


    public Mirror(Settings settings) {
        super(settings.nonOpaque());
    }




    //Geckolib setup
    @Override
    public BlockRenderType getRenderType(BlockState state)
    {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }


    @Override
    public MirrorEntity createBlockEntity(BlockView world) {
        return new MirrorEntity();
    }
}
