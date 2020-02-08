package abdielandwolf.ste_men.init;

import abdielandwolf.ste_men.Ste_MenMod;
import abdielandwolf.ste_men.entity.EntityHolyArrow;
import abdielandwolf.ste_men.entity.EntityUnicorn;
import abdielandwolf.ste_men.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {

    public static void registerEntities() {
        registerEntity("unicorn", EntityUnicorn.class, Reference.ENTITY_UNICORN, 50, 16748280, 9362943);
        registerArrow("holy_arrow", EntityHolyArrow.class, Reference.ENTITY_HOLY_ARROW);
    }

    public static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Ste_MenMod.instance, range, 1, true, color1, color2);
    }
    
	private static void registerArrow(String name, Class<? extends Entity> entity, int id) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Ste_MenMod.instance, 64, 20, true);
	}
	
	private static void registerProjectile(String name, int id, Class<? extends Entity> entity, Item item) {
		EntityRegistry.registerModEntity(new ResourceLocation(name), entity, name, id, Ste_MenMod.instance, 64, 10, true);
	}
    
}
