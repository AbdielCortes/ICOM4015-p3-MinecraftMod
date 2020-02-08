package abdielandwolf.ste_men.blocks;

import abdielandwolf.ste_men.Ste_MenMod;
import abdielandwolf.ste_men.init.ModBlocks;
import abdielandwolf.ste_men.init.ModItems;
import abdielandwolf.ste_men.util.HasModel;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockOreBase extends BlockOre implements HasModel {
    public BlockOreBase(String name) {
        super();
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Ste_MenMod.modTab);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        Ste_MenMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
