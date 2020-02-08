package abdielandwolf.ste_men.blocks.fluids;


import abdielandwolf.ste_men.Ste_MenMod;
import abdielandwolf.ste_men.init.ModBlocks;
import abdielandwolf.ste_men.init.ModItems;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockHolyWaterFluid extends BlockFluidClassic{

	public BlockHolyWaterFluid(String name,  Fluid fluid,  Material material) {
		super(fluid, material);
		setUnlocalizedName(name);
		setRegistryName(name);
		//setCreativeTab(Ste_MenMod.modTab);

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
}




