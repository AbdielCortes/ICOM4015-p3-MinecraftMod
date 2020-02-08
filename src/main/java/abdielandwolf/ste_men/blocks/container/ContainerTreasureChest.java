package abdielandwolf.ste_men.blocks.container;

// Import Locals
import abdielandwolf.ste_men.tileentity.TileEntityTreasureChest;

// Import Minecraft
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


public class ContainerTreasureChest extends Container
{
	private final int numberOfRows;
	private final TileEntityTreasureChest chestInventory;
	
	public ContainerTreasureChest(InventoryPlayer playerInv, TileEntityTreasureChest tileEntityTreasureChest, EntityPlayer player) {
		this.chestInventory = tileEntityTreasureChest;
		this.numberOfRows = tileEntityTreasureChest.getSizeInventory() / 9;
		tileEntityTreasureChest.openInventory(player);
		
		for(int i = 0; i < this.numberOfRows; ++i) {
			for(int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(tileEntityTreasureChest, j + i*9, 8 + j*18, 18 + i*18));
			}
		}
		
		for(int y = 0; y < 3; y++) {
			for(int x = 0; x < 9; x++) {
				this.addSlotToContainer(new Slot(playerInv, x + y*9 + 9, 8 + x*18, 175 + y*18));
			}
		}
		
		for(int x = 0; x < 9; x++) {
			this.addSlotToContainer(new Slot(playerInv, x, 8 + x*18, 233));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.chestInventory.isUsableByPlayer(playerIn);
	}
	
	@Override
	public void onContainerClosed(EntityPlayer playerIn) {
		super.onContainerClosed(playerIn);
		chestInventory.closeInventory(playerIn);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < this.numberOfRows * 9) {
                if (!this.mergeItemStack(itemstack1, this.numberOfRows * 9, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, this.numberOfRows * 9, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            }
            else {
                slot.onSlotChanged();
            }
        }
        return itemstack;
	}
	
	public TileEntityTreasureChest getChestInventory() {
		return this.chestInventory;
	}
}