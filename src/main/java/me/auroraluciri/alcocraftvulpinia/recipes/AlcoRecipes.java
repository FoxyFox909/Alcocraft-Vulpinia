package me.auroraluciri.alcocraftvulpinia.recipes;

import me.auroraluciri.alcocraftvulpinia.AlcocrafVulpinia;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AlcoRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, AlcocrafVulpinia.MOD_ID);

    public static final RegistryObject<RecipeSerializer<KegRecipe>> KEG_SERIALIZER =
            SERIALIZERS.register("beer_brewing", () -> KegRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
