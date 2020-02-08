 package abdielandwolf.ste_men.init;

import java.util.ArrayList;
import java.util.List;

import abdielandwolf.ste_men.blocks.*;
import abdielandwolf.ste_men.blocks.fluids.BlockHolyWaterFluid;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockChest;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
	
	//Blocks
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	public static final Block SAPPHIRE_BLOCK = new SapphireBlock("sapphire_block", Material.IRON);
	public static final Block SAPPHIRE_ORE =  new SapphireOre("sapphire_ore");
	public static final Block COPPER_ORE = new CopperOre("copper_ore");
	public static final Block COPPER_BLOCK = new BlockBase("copper_block", Material.IRON);
	public static final Block NICOLAS_CAGE_BLOCK = new BlockBase("nicolas_cage_block", Material.SPONGE);
	public static final ManaFlower MANA_FLOWER = new ManaFlower("mana_flower");
	
	// Fluids
	public static final Block HOLY_WATER_FLUID = new BlockHolyWaterFluid("holy_water", FluidInit.HOLY_WATER_FLUID, Material.WATER); 
	
	//Chests
	//public static final Block TREASURE_CHEST = new BlockTreasureChest("treasure_chest", Material.WOOD);
}
