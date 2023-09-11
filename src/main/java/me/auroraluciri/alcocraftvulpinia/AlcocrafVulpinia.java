package me.auroraluciri.alcocraftvulpinia;

import me.auroraluciri.alcocraftvulpinia.blocks.AlcoBlockEntities;
import me.auroraluciri.alcocraftvulpinia.blocks.AlcoBlocks;
import me.auroraluciri.alcocraftvulpinia.effects.AlcoEffects;
import me.auroraluciri.alcocraftvulpinia.gui.AlcoMenuTypes;
import me.auroraluciri.alcocraftvulpinia.gui.KegScreen;
import me.auroraluciri.alcocraftvulpinia.items.AlcoItems;
import me.auroraluciri.alcocraftvulpinia.particles.AlcoParticles;
import me.auroraluciri.alcocraftvulpinia.recipes.AlcoRecipes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(AlcocrafVulpinia.MOD_ID)
public class AlcocrafVulpinia {
    public static final String MOD_ID = "alcocraftvulpinia";
    private static final Logger LOGGER = LogManager.getLogger();

    public AlcocrafVulpinia() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        AlcoBlocks.register(eventBus);
        AlcoItems.register(eventBus);
        AlcoBlockEntities.register(eventBus);
        AlcoMenuTypes.register(eventBus);
        AlcoRecipes.register(eventBus);
        AlcoParticles.register(eventBus);
        AlcoEffects.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(AlcoBlocks.KEG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AlcoBlocks.HOP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AlcoBlocks.HOP_PLANT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AlcoBlocks.MUG_EMPTY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AlcoBlocks.MUG_OF_SUN_PALE_ALE.get(), RenderType.cutout());

        MenuScreens.register(AlcoMenuTypes.KEG_MENU.get(), KegScreen::new);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Hello from pre-init!");
    }
}