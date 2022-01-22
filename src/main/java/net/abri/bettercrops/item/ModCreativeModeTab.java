package net.abri.bettercrops.item;

import net.abri.bettercrops.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab BETTER_CROPS = new CreativeModeTab("betterCropsTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.PIECE_OF_WOOD.get());
        }
    };
}
