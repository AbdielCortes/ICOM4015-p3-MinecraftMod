package abdielandwolf.ste_men.util.handler;

// Import Locals
import abdielandwolf.ste_men.blocks.container.ContainerTreasureChest;
import abdielandwolf.ste_men.tabs.guis.GuiTreasureChest;
import abdielandwolf.ste_men.tileentity.TileEntityTreasureChest;
import abdielandwolf.ste_men.util.Reference;

// Import Minecraft
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Reference.GUI_TREASURE_CHEST) {
			return new ContainerTreasureChest(player.inventory, (TileEntityTreasureChest)world.getTileEntity(new BlockPos(x,y,z)), player);
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Reference.GUI_TREASURE_CHEST) {
			return new GuiTreasureChest(player.inventory, (TileEntityTreasureChest)world.getTileEntity(new BlockPos(x,y,z)), player);
		}
		return null;
	}
}
