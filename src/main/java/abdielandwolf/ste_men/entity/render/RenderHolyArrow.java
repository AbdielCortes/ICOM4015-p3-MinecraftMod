package abdielandwolf.ste_men.entity.render;


import abdielandwolf.ste_men.entity.EntityHolyArrow;
import abdielandwolf.ste_men.util.Reference;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHolyArrow extends RenderArrow<EntityHolyArrow>
{
	public RenderHolyArrow(RenderManager manager) 
	{
		super(manager);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityHolyArrow entity) 
	{
		return new ResourceLocation(Reference.MOD_ID + ":textures/items/holy_arrow.png");
	}
}
