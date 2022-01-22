package net.abri.bettercrops.block;

import net.abri.bettercrops.Main;
import net.abri.bettercrops.item.ModCreativeModeTab;
import net.abri.bettercrops.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);

    public static final RegistryObject<Block> DRIED_MUD = registerBlock("dried_mud",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.BASALT).strength(0.5f)));

    public static final RegistryObject<Block> LIMESTONE = registerBlock("limestone",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(1.5f)));

    public static final RegistryObject<Block> MUD = registerBlock("mud",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.ROOTED_DIRT).strength(0.6f)));

    public static final RegistryObject<Block> PACKED_DIRT = registerBlock("packed_dirt",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.ROOTED_DIRT).strength(0.6f)));

    public static final RegistryObject<Block> SLATE = registerBlock("slate",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.DEEPSLATE_BRICKS).requiresCorrectToolForDrops().strength(1.5f)));

    public static final RegistryObject<Block> STRATA = registerBlock("strata",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.DRIPSTONE_BLOCK).requiresCorrectToolForDrops().strength(1.5f)));

    public static final RegistryObject<Block> PIECE_OF_WOOD = registerBlock("piece_of_wood",
            () -> new PieceOfWood(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).instabreak()));

    public static final RegistryObject<Block> PEBBLE = registerBlock("pebble",
            () -> new PieceOfWood(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).instabreak()));

    public static final RegistryObject<Block> ROCK = registerBlock("rock",
            () -> new PieceOfWood(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).instabreak()));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModCreativeModeTab.BETTER_CROPS)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
