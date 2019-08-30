package com.aang23.undergroundbiomes;

import com.aang23.undergroundbiomes.config.UBConfig;
import com.aang23.undergroundbiomes.config.utils.CobbleRecipeHandler;
import com.aang23.undergroundbiomes.config.utils.GravelRecipeHandler;
import com.aang23.undergroundbiomes.config.utils.StoneRecipeHandler;
import com.aang23.undergroundbiomes.registrar.UBOreRegistrar;
import com.aang23.undergroundbiomes.world.WorldGenManager;
import com.aang23.undergroundbiomes.world.utils.WorldChunkChecker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("undergroundbiomes")
public class UndergroundBiomes {
    public static String modid = "undergroundbiomes";
    public static final ItemGroup CREATIVE_TAB = new UndergroundBiomesItemGroup();
    public static final ItemGroup ORES_CREATIVE_TAB = new UndergroundBiomesItemGroupOres();
    private static final Logger LOGGER = LogManager.getLogger(modid);

    public UndergroundBiomes() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, UBConfig.SPEC);
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(WorldChunkChecker::preInit);
        MinecraftForge.EVENT_BUS.register(new WorldChunkChecker());

        CraftingHelper.register(new CobbleRecipeHandler());
        CraftingHelper.register(new StoneRecipeHandler());
        CraftingHelper.register(new GravelRecipeHandler());

        UBOreRegistrar.initialSetup();

        UBBlocks.initialSetup();
    }

    private void setup(final FMLCommonSetupEvent event) {
        // Register a WorldGenManager for each enabled dimension
        String dimsIds[] = UBConfig.GENERAL.dimensionList.get().split(",");
        for (String dimId : dimsIds) {
            MinecraftForge.EVENT_BUS.register(new WorldGenManager(Integer.parseInt(dimId)));
            LOGGER.info("Enabled UndergroundBiomes for dim " + dimId);
        }
        // MinecraftForge.EVENT_BUS.register(new WorldGenManager(0));
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        UBOreRegistrar.registerPack(event);
        event.getMinecraftSupplier().get().reloadResources();
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {

    }

    private void processIMC(final InterModProcessEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> e) {

            // Ores
            UBOreRegistrar.registerOres(e);

            // Blocks
            UBBlocks.registerBlocks(e);

        }

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> e) {

            // Ores
            UBOreRegistrar.registerOresItems(e);

            // Blocks
            UBBlocks.registerItems(e);

            // Fossils
            e.getRegistry().register(UBItems.FOSSIL_PIECE_AMMONITE.getItem());
            e.getRegistry().register(UBItems.FOSSIL_PIECE_SHELL.getItem());
            e.getRegistry().register(UBItems.FOSSIL_PIECE_RIB.getItem());
            e.getRegistry().register(UBItems.FOSSIL_PIECE_BONE.getItem());
            e.getRegistry().register(UBItems.FOSSIL_PIECE_SKULL.getItem());
            e.getRegistry().register(UBItems.FOSSIL_PIECE_BONE2.getItem());
            e.getRegistry().register(UBItems.FOSSIL_PIECE_SHELL2.getItem());
            e.getRegistry().register(UBItems.FOSSIL_PIECE_BONESHARD.getItem());

            // Others
            e.getRegistry().register(UBItems.LIGNITE_COAL.getItem());
        }
    }
}
