package abdielandwolf.ste_men.items.tools;

import abdielandwolf.ste_men.items.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ActivationWand extends ItemBase {

    public ActivationWand(String name) {
        super(name);
        this.maxStackSize = 1;
        this.setMaxDamage(512);
    }

    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        pos = pos.offset(facing);
        ItemStack itemstack = player.getHeldItem(hand);

        if (!player.canPlayerEdit(pos, facing, itemstack)) {
            return EnumActionResult.FAIL;
        }
        else {
            if (worldIn.isAirBlock(pos)) {
                worldIn.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                worldIn.setBlockState(pos, Blocks.FIRE.getDefaultState(), 11);
            }

            itemstack.damageItem(1, player);
            return EnumActionResult.SUCCESS;
        }
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);
        Vec3d aim = playerIn.getLookVec();

        EntitySmallFireball fireball = new EntitySmallFireball(worldIn, playerIn, 1, 1, 1);
        fireball.setPosition(playerIn.posX+aim.x*1.5D, playerIn.posY+aim.y*1.5D+1, playerIn.posZ+aim.z*1.5D);
        fireball.accelerationX = aim.x * 0.1;
        fireball.accelerationY = aim.y * 0.1;
        fireball.accelerationZ = aim.z * 0.1;
        worldIn.spawnEntity(fireball);
        worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);

        item.damageItem(1, playerIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
    }
}
