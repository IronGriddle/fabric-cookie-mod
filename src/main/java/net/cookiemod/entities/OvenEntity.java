package net.cookiemod.entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;


import static net.cookiemod.registry.Entities.OVEN_BLOCK_ENTITY;

public class OvenEntity extends BlockEntity {

    private int number = 7;

    public OvenEntity() {
        super(OVEN_BLOCK_ENTITY);
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.toTag(tag);
        number = tag.getInt("number");
    }


    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        // Save the current value of the number to the tag
        tag.putInt("number", number);
        return tag;
    }
}


