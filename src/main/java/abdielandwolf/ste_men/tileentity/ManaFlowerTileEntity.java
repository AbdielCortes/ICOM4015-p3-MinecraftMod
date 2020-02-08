package abdielandwolf.ste_men.tileentity;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class ManaFlowerTileEntity extends TileEntity {

    private int mana = 0;
    public static final int RADIUS = 3;

    public void incrementMana(int amount) {
        for (int i = -RADIUS; i <= RADIUS; i++) {
            for (int j = -RADIUS; j <= RADIUS; j++) {
                if (world.isBlockFullCube(pos.add(i, 0, j)) && Block.isEqualTo(world.getBlockState(pos.add(i, 0, j)).getBlock(), Block.getBlockFromName("coal_block"))) {
                    if (this.mana < 600) {
                        world.setBlockState(pos.add(i, 0, j), Blocks.FIRE.getDefaultState(), 11); //Creates fire where block of coal was
                        this.mana += amount;
                    }
                }
            }
        }
        markDirty();
    }

    public void decrementMana(int amount) {
        if(this.mana > 0) {
            this.mana -= amount;
            markDirty();
        }
    }

    public int getMana() {
        return this.mana;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.mana = compound.getInteger("mana");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("mana", this.mana);
        return compound;
    }
}
