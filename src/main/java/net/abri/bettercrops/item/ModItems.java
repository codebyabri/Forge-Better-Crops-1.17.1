package net.abri.bettercrops.item;

import net.abri.bettercrops.Main;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);

    public static final RegistryObject<Item> PEBBLE = ITEMS.register("pebble",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BETTER_CROPS)));

    public static final RegistryObject<Item> PIECE_OF_WOOD = ITEMS.register("piece_of_wood",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BETTER_CROPS)));

    public static final RegistryObject<Item> ROCK = ITEMS.register("rock",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BETTER_CROPS)));



    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
