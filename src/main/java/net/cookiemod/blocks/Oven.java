package net.cookiemod.blocks;

import net.cookiemod.entities.OvenEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class Oven extends Block implements BlockEntityProvider {


    public Oven(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new OvenEntity();
    }
}
