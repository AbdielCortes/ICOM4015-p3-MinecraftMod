package abdielandwolf.ste_men.entity.render;

import abdielandwolf.ste_men.entity.EntityUnicorn;
import abdielandwolf.ste_men.entity.model.ModelUnicorn;
import abdielandwolf.ste_men.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderUnicorn extends RenderLiving<EntityUnicorn> {

    public static final ResourceLocation TEXTURES =  new ResourceLocation(Reference.MOD_ID + ":textures/entity/unicorn.png");

    public RenderUnicorn(RenderManager manager) {
        super(manager, new ModelUnicorn(), 0.75F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityUnicorn entity) {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityUnicorn entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
