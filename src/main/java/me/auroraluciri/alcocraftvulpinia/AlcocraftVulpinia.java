package me.auroraluciri.alcocraftvulpinia;

import com.simibubi.create.foundation.data.CreateRegistrate;
import me.auroraluciri.alcocraftvulpinia.blocks.AlcoBlockEntities;
import me.auroraluciri.alcocraftvulpinia.blocks.AlcoBlocks;
import me.auroraluciri.alcocraftvulpinia.effects.AlcoEffects;
import me.auroraluciri.alcocraftvulpinia.fluids.AlcoFluids;
import me.auroraluciri.alcocraftvulpinia.gui.AlcoMenuTypes;
import me.auroraluciri.alcocraftvulpinia.gui.KegScreen;
import me.auroraluciri.alcocraftvulpinia.items.AlcoItems;
import me.auroraluciri.alcocraftvulpinia.particles.AlcoParticles;
import me.auroraluciri.alcocraftvulpinia.recipes.AlcoRecipes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(AlcocraftVulpinia.MOD_ID)
public class AlcocraftVulpinia {
    public static final String MOD_ID = "alcocraftvulpinia";
    private static final Logger LOGGER = LogManager.getLogger();

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(AlcocraftVulpinia.MOD_ID);

    //public static final NonNullSupplier<Registrate> REGISTRATE = NonNullSupplier.lazy(() -> Registrate.create(AlcocraftVulpinia.MOD_ID));

    public AlcocraftVulpinia() {
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        AlcoBlocks.register(eventBus);
        AlcoItems.register(eventBus);
        AlcoFluids.register(eventBus);
        AlcoBlockEntities.register(eventBus);
        AlcoMenuTypes.register(eventBus);
        AlcoRecipes.register(eventBus);
        AlcoParticles.register(eventBus);
        AlcoEffects.register(eventBus);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> onClient(eventBus, forgeEventBus));


        //eventBus.addListener(this::clientSetup);
       // eventBus.addListener(this::clientSetup);
        //REGISTRATE.registerEventListeners(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
        REGISTRATE.registerEventListeners(eventBus);
    }

    private void onClient(IEventBus eventBus, IEventBus forgeEventBus) {
        eventBus.addListener(AlcocraftVulpinia::clientSetup);
    }

    public static void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(AlcoBlocks.KEG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AlcoBlocks.HOP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AlcoBlocks.HOP_PLANT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AlcoBlocks.MUG_EMPTY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AlcoBlocks.MUG_OF_SUN_PALE_ALE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(AlcoFluids.CHORUS_ALE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AlcoFluids.CHORUS_ALE.get().getSource(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AlcoFluids.DIGGER_BITTER.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AlcoFluids.DIGGER_BITTER.get().getSource(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AlcoFluids.DROWNED_ALE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AlcoFluids.DROWNED_ALE.get().getSource(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AlcoFluids.ICE_BEER.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AlcoFluids.ICE_BEER.get().getSource(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AlcoFluids.KVASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AlcoFluids.KVASS.get().getSource(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AlcoFluids.LEPRECHAUN_CIDER.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AlcoFluids.LEPRECHAUN_CIDER.get().getSource(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AlcoFluids.MAGNET_PILSNER.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AlcoFluids.MAGNET_PILSNER.get().getSource(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AlcoFluids.NETHER_PORTER.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AlcoFluids.NETHER_PORTER.get().getSource(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AlcoFluids.NETHER_STAR_LAGER.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AlcoFluids.NETHER_STAR_LAGER.get().getSource(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AlcoFluids.NIGHT_RAUCH.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AlcoFluids.NIGHT_RAUCH.get().getSource(), RenderType.translucent());

        MenuScreens.register(AlcoMenuTypes.KEG_MENU.get(), KegScreen::new);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Hello from pre-init!");
    }
}
