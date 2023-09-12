package me.auroraluciri.alcocraftvulpinia.fluids;

import com.tterrag.registrate.util.entry.FluidEntry;
import me.auroraluciri.alcocraftvulpinia.AlcocraftVulpinia;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static me.auroraluciri.alcocraftvulpinia.AlcocraftVulpinia.REGISTRATE;

//import static me.auroraluciri.alcocraftvulpinia.AlcocraftVulpinia.REGISTRATE;



public class AlcoFluids {

    public static final ResourceLocation FLUID_STILL_RL = new ResourceLocation("minecraft:block/water_still");
    public static final ResourceLocation FLUID_FLOWING_RL = new ResourceLocation("minecraft:block/water_still");

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, AlcocraftVulpinia.MOD_ID);


    //public static final DeferredRegister<Fluids> FLUIDS = DeferredRegister.create(ForgeRegistries, AlcocraftVulpinia.MOD_ID);

    //public static FluidEntry<ForgeFlowingFluid.Flowing> CHORUS_ALE;


    /*public static void register() {

        FluidEntry<ForgeFlowingFluid.Flowing, CreateRegistrate> chorusAle = AlcocraftVulpinia.REGISTRATE.fluid("chorus_ale", new ResourceLocation("minecraft", "block/water_still"), new ResourceLocation("minecraft", "block/water_flow"))
                .attributes(b -> b.viscosity(1500)
                        .density(500))
                .properties(p -> p.levelDecreasePerBlock(2)
                        .tickRate(25)
                        .slopeFindDistance(3)
                        .explosionResistance(100f))
                .source((ForgeFlowingFluid.Source::new));

        var chorusAleBucket = chorusAle.bucket()
                .properties(p -> p.stacksTo(1))
                .register();

        CHORUS_ALE = chorusAle.register();


    }*/
    public static final FluidEntry<ForgeFlowingFluid.Flowing> CHORUS_ALE =
            REGISTRATE.fluid("chorus_ale", new ResourceLocation("minecraft:block/water_still"), new ResourceLocation("minecraft:block/water_flow"))
                    .lang("Chorus Ale")
                    .attributes(b -> b.viscosity(1500)
                            .density(500)
                            .color(0xFFAE79C7)
                            .sound(SoundEvents.BUCKET_FILL))
                    .properties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f))
                    .source(ForgeFlowingFluid.Source::new)
                    .bucket()
                        .properties(b -> b.rarity(Rarity.UNCOMMON))//
                    .build()
                    .register();

    public static final FluidEntry<ForgeFlowingFluid.Flowing> DIGGER_BITTER =
            REGISTRATE.fluid("digger_bitter", new ResourceLocation("minecraft:block/water_still"), new ResourceLocation("minecraft:block/water_flow"))
                    .lang("Digger Bitter")
                    .attributes(b -> b.viscosity(1500)
                            .density(500)
                            .color(0xFFC76F0A)
                            .sound(SoundEvents.BUCKET_FILL))
                    .properties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f))
                    .source(ForgeFlowingFluid.Source::new)
                    .bucket()
                    .properties(b -> b.rarity(Rarity.UNCOMMON))//
                    .build()
                    .register();

    public static void register(IEventBus eventBus) {}
}




