package abdielandwolf.ste_men.blocks;

import abdielandwolf.ste_men.tileentity.ManaFlowerTileEntity;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ManaFlower extends BlockFlowerBase implements ITileEntityProvider {

    private int mana;

    public ManaFlower(String name) {
        super(name);
        setSoundType(SoundType.PLANT);
        setLightLevel(10);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
//          if (player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof ActivationWand) {
            //if(player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof ManaSword) {
                //getTE(world, pos).decrementMana(10);
                //this.mana = getTE(world, pos).getMana();

           // } else {
            getTE(world, pos).incrementMana(20);
            this.mana = getTE(world, pos).getMana();
            //}
            TextComponentTranslation component = new TextComponentTranslation("message.ste_men.mana", getTE(world, pos).getMana());
            component.getStyle().setColor(TextFormatting.BLUE);
            player.sendStatusMessage(component, false);
        }
        return true;
    }

    public ManaFlowerTileEntity getTE(World world, BlockPos pos) {
        return (ManaFlowerTileEntity) world.getTileEntity(pos);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new ManaFlowerTileEntity();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this);
    }
}
