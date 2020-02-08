package abdielandwolf.ste_men.blocks;

import abdielandwolf.ste_men.Ste_MenMod;
import abdielandwolf.ste_men.init.ModBlocks;
import abdielandwolf.ste_men.init.ModItems;
import abdielandwolf.ste_men.tileentity.TileEntityTreasureChest;
import abdielandwolf.ste_men.util.Reference;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTreasureChest extends BlockContainer
{
	public static final PropertyDirection FACING = PropertyDirection.create("facing");
	public BlockTreasureChest(String name, Material material) 
	{
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(Ste_MenMod.modTab);
		setHardness(13.0f);
		setHarvestLevel("pickaxe", -1);
		setResistance(30.0f);
		setSoundType(SoundType.WOOD);
		setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.SOUTH));

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote) {
			playerIn.openGui(Ste_MenMod.instance, Reference.GUI_TREASURE_CHEST, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) 
	{
		TileEntityTreasureChest tileentity = (TileEntityTreasureChest)worldIn.getTileEntity(pos);
		InventoryHelper.dropInventoryItems(worldIn, pos, tileentity);
		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		if(stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if(tileentity instanceof TileEntityTreasureChest) {
				((TileEntityTreasureChest)tileentity).setCustomName(stack.getDisplayName());
			}
		}
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityTreasureChest();
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
}