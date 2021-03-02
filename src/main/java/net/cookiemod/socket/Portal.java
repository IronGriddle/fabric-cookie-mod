package net.cookiemod.socket;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static net.cookiemod.CookieMod.PACKET_BUFFER;
import static net.cookiemod.registry.ItemTags.COOKIE_TAG;
import static net.cookiemod.registry.Sounds.GENERAL_FADE;
import static net.cookiemod.registry.Sounds.VILLAGER_FADE;

public class Portal extends Block implements BlockEntityProvider {
    public Portal(Settings settings) {
        super(settings);
    }

    //TODO: FIX BUG HERE.
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        PortalEntity portalEntity = (PortalEntity) world.getBlockEntity(pos);
        return portalEntity != null ? portalEntity.getCollisionShape() : VoxelShapes.empty();
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (!world.isClient) {
            PortalEntity portalEntity = (PortalEntity) world.getBlockEntity(pos);
            if (portalEntity == null) {
                return;
            }
            portalEntity.onPlace();
        }

        super.onPlaced(world, pos, state, placer, itemStack);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient) {
            PortalEntity portalEntity = (PortalEntity) world.getBlockEntity(pos);
            if (portalEntity == null){
                return;
            }

            //Import Villagers
            if(entity instanceof VillagerEntity) {
                entity.remove();
                //Maybe change this sound.
                world.playSound((PlayerEntity)null, pos.getX(), pos.getY(), pos.getZ(), VILLAGER_FADE, SoundCategory.NEUTRAL, (float) 0.5, 1);
                PACKET_BUFFER.addVillagers(1);
                //Play animation
                portalEntity.onTeleport();
                return;
            }

            //Import cookies with tags. Return only if item is a cookie.
            if(entity instanceof ItemEntity){
                ItemStack stack = ((ItemEntity) entity).getStack().copy();
                if (ItemTags.getTagGroup().getTagOrEmpty(COOKIE_TAG).contains(stack.getItem())){
                    PACKET_BUFFER.addCookies(stack.getCount());
                    entity.remove();
                    //Play animation
                    portalEntity.onTeleport();
                    return;
                }
            }

            //Destroy everything else. which is not the player
            if (!(entity instanceof PlayerEntity)){
                entity.remove();
                world.playSound((PlayerEntity)null, pos.getX(), pos.getY(), pos.getZ(), GENERAL_FADE, SoundCategory.NEUTRAL, (float) 0.5, 1);
                //Grow portal
                portalEntity.growPortal();
                //Play animation
                portalEntity.onTeleport();
            }

        }
    }

    @Override
    public BlockRenderType getRenderType(BlockState state)
    {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new PortalEntity();
    }
}
