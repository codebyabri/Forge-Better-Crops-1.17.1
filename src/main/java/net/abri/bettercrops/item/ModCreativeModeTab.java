package net.abri.bettercrops.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab BETTER_CROPS = new CreativeModeTab("betterCropsTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.PIECE_OF_WOOD.get());
        }
    };
}
