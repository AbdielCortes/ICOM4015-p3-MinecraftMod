package abdielandwolf.ste_men.blocks;

import abdielandwolf.ste_men.init.ModBlocks;
import abdielandwolf.ste_men.init.ModItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class SapphireOre extends BlockOreBase {

    public SapphireOre(String name) {
        super(name);
        setSoundType(SoundType.STONE);
        setHardness(3);
        setResistance(15);
        setHarvestLevel("pickaxe", 2);
        setLightLevel(0);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ModItems.SAPPHIRE;
    }

    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
        Random rand = world instanceof World ? ((World) world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
            int i = 0;
            if (this == ModBlocks.SAPPHIRE_ORE) {
                i = MathHelper.getInt(rand, 3, 7);
            }
            return i;
        }
        return 0;
    }
}
