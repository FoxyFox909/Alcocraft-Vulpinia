package me.auroraluciri.alcocraftvulpinia.blocks;

import me.auroraluciri.alcocraftvulpinia.AlcocraftVulpinia;
import me.auroraluciri.alcocraftvulpinia.blocks.workstations.KegEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AlcoBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, AlcocraftVulpinia.MOD_ID);

    public static final RegistryObject<BlockEntityType<KegEntity>> KEG_ENTITY =
            BLOCK_ENTITIES.register("keg_entity",
                    () -> BlockEntityType.Builder.of(KegEntity::new, AlcoBlocks.KEG.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
