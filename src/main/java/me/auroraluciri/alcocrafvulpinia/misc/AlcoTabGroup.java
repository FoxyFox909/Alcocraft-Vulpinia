package me.auroraluciri.alcocrafvulpinia.misc;

import me.auroraluciri.alcocrafvulpinia.items.AlcoItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class AlcoTabGroup {
    public static final CreativeModeTab GROUP = new CreativeModeTab("alcotabgroup") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(AlcoItems.MUG_OF_CHORUS_ALE.get());
        }
    };
}
