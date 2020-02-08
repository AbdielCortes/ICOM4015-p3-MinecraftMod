package abdielandwolf.ste_men.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class ManaSwordTileEntity extends TileEntity {
    private int mana = 0;

    public int decrement(int amount) {
        mana -= amount;
        markDirty();
        return mana;
    }

    public int increment(int amount) {
        mana += amount;
        markDirty();
        return mana;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setInteger("mana", mana);
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        mana = compound.getInteger("mana");
        super.readFromNBT(compound);
    }

}
