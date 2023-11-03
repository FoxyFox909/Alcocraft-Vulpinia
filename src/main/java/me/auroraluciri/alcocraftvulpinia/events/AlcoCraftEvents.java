package me.auroraluciri.alcocraftvulpinia.events;

import me.auroraluciri.alcocraftvulpinia.AlcocraftVulpinia;
import me.auroraluciri.alcocraftvulpinia.loot.DungeonChests;
import me.auroraluciri.alcocraftvulpinia.loot.HopSeeds;
import me.auroraluciri.alcocraftvulpinia.particles.AlcoParticles;
import me.auroraluciri.alcocraftvulpinia.particles.YellowBubbleParticles;
import me.auroraluciri.alcocraftvulpinia.recipes.KegRecipe;
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

@Mod.EventBusSubscriber(modid = AlcocraftVulpinia.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
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
                        (new ResourceLocation(AlcocraftVulpinia.MOD_ID,"hop_seeds"))
        );

        event.getRegistry().register(
                new DungeonChests.Serializer().setRegistryName
                        (new ResourceLocation(AlcocraftVulpinia.MOD_ID,"add_item"))
        );
    }

//    @SubscribeEvent
//    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
//        event.register(AlcoholContent.class);
//    }
//
//    @SubscribeEvent
//    public static void onAttachCapabilitiesItem(AttachCapabilitiesEvent<ItemStack> event) {
//        if (event.getObject() instanceof ItemStack(MugItem)) {
//            if (!event.getObject().getCapability(AlcoholContentProvider.ALCOHOL_CONTENT).isPresent()) {
//                event.addCapability(new ResourceLocation(AlcocraftVulpinia.MOD_ID), new AlcoholContentProvider());
//            }
//        }
//
//    }





}
