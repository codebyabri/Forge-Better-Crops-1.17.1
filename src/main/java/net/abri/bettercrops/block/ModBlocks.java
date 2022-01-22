package net.abri.bettercrops.block;

import net.abri.bettercrops.Main;
import net.abri.bettercrops.item.ModCreativeModeTab;
import net.abri.bettercrops.item.ModItems;
import net.abri.bettercrops.item.custom.PieceOfWoodBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unused")
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
            () -> new PieceOfWoodBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).instabreak()),
            block -> new PieceOfWoodBlockItem(block, new Item.Properties().tab(ModCreativeModeTab.BETTER_CROPS))
    );

    public static final RegistryObject<Block> PEBBLE = registerBlock("pebble",
            () -> new Pebble(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).instabreak()));

    public static final RegistryObject<Block> ROCK = registerBlock("rock",
            () -> new Rock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).instabreak()));

//    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
//        RegistryObject<T> toReturn = BLOCKS.register(name, block);
//        registerBlockItem(name, toReturn, tab);
//        return toReturn;
//    }
//
//    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
//        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
//                new Item.Properties().tab(tab)));
//    }

    /**
     * Registers a block with given name and {@link Block} supplier.  This registers a block with a default block item.
     *
     * @param name          name of the block to register
     * @param blockSupplier supplies {@link Block} instances
     * @param <T>           the actual block type
     * @return a {@link RegistryObject} that represents the registration of the block
     */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> blockSupplier) {
        RegistryObject<T> toReturn = BLOCKS.register(name, blockSupplier);
        registerBlockItem(name, toReturn, ModBlocks::createDefaultBlockItem);
        return toReturn;
    }

    private static BlockItem createDefaultBlockItem(Block block) {
        return new BlockItem(block, new Item.Properties().tab(ModCreativeModeTab.BETTER_CROPS));
    }

    /**
     * Registers a block with given name and {@link Block} supplier.  This registers a block with a custom block item.
     *
     * @param name          name of the block to register
     * @param blockSupplier supplies {@link Block} instances
     * @param blockItemSupplier supplies a custom {@link BlockItem}
     * @param <T>           the actual block type
     * @return a {@link RegistryObject} that represents the registration of the block
     */
    private static <T extends Block> RegistryObject<T> registerBlock(String name,
                                                                     Supplier<T> blockSupplier,
                                                                     Function<Block, BlockItem> blockItemSupplier) {
        RegistryObject<T> toReturn = BLOCKS.register(name, blockSupplier);
        registerBlockItem(name, toReturn, blockItemSupplier);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name,
                                                            RegistryObject<T> block,
                                                            Function<Block, BlockItem> blockItemSupplier) {
        ModItems.ITEMS.register(name, () -> blockItemSupplier.apply(block.get()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
