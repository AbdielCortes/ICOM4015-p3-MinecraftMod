package abdielandwolf.ste_men.entity;

import abdielandwolf.ste_men.init.ModItems;
import abdielandwolf.ste_men.util.handler.LootTableHandler;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntityUnicorn extends EntityHorse implements IShearable {

    public EntityUnicorn(World worldIn) {
        super(worldIn);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        if(ageable instanceof EntityUnicorn) {
            return new EntityUnicorn(world);
        }

        Random rand = new Random();
        if(rand.nextInt(10) < 8) {
            return new EntityHorse(world);
        }
        return new EntityUnicorn(world);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableHandler.UNICORN;
    }

    @Override
    public boolean wearsArmor() {
        return false;
    }

    @Override
    public boolean isShearable(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos) {
        return !this.isChild();
    }

    @Nonnull
    @Override
    public List<ItemStack> onSheared(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        List<ItemStack> hair = new ArrayList<ItemStack>();
        hair.add(new ItemStack(ModItems.UNICORN_HAIR));
        return hair;
    }
}
