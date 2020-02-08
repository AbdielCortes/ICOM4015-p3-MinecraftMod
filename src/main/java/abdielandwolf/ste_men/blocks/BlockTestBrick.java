package abdielandwolf.ste_men.blocks;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
//import net.minecraft.init.Blocks;
import net.minecraft.block.Block;;

// Test brick
public class BlockTestBrick extends Block{

	public BlockTestBrick(){
		super(Material.ROCK);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return MapColor.NETHERRACK;
		
	}
	
}
