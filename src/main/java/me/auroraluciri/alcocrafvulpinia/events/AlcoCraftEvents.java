package me.auroraluciri.alcocrafvulpinia.events;

import me.auroraluciri.alcocrafvulpinia.AlcocrafVulpinia;
import me.auroraluciri.alcocrafvulpinia.loot.DungeonChests;
import me.auroraluciri.alcocrafvulpinia.loot.HopSeeds;
import me.auroraluciri.alcocrafvulpinia.particles.AlcoParticles;
import me.auroraluciri.alcocrafvulpinia.particles.YellowBubbleParticles;
import me.auroraluciri.alcocrafvulpinia.recipes.KegRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = AlcocrafVulpinia.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AlcoCraftEvents {
    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, KegRecipe.Type.ID, KegRecipe.Type.INSTANCE);
    }

    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(AlcoParticles.YELLOW_BUBBLES.get(),
                YellowBubbleParticles.Provider::new);
    }

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                           event) {
        event.getRegistry().register(
                new HopSeeds.Serializer().setRegistryName
                        (new ResourceLocation(AlcocrafVulpinia.MOD_ID,"hop_seeds"))
        );

        event.getRegistry().register(
                new DungeonChests.Serializer().setRegistryName
                        (new ResourceLocation(AlcocrafVulpinia.MOD_ID,"add_item"))
        );
    }
}
