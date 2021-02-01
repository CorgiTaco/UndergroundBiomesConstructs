package com.aang23.undergroundbiomes.registrar;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import com.aang23.undergroundbiomes.blocks.UBOre;
import com.aang23.undergroundbiomes.blocks.UBStone;
import com.aang23.undergroundbiomes.api.enums.IgneousVariant;
import com.aang23.undergroundbiomes.api.enums.MetamorphicVariant;
import com.aang23.undergroundbiomes.api.enums.SedimentaryVariant;
import com.aang23.undergroundbiomes.api.enums.UBBlock;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;
import com.aang23.undergroundbiomes.registrar.pack.UBPackFinder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.loading.FMLPaths;

public class UBOreRegistrar {

    public static File oreFolder;

    public static File mcdir = FMLPaths.GAMEDIR.get().toFile();

    public static File packDir = new File(mcdir, "ubpack");

    private static Map<String, UBOre> REGISTERED_ORES = new HashMap<String, UBOre>();

    public static void registerOre(Block toRegisterAsOre) {
        for (IgneousVariant currentVariant : IgneousVariant.values()) {
            UBOre ore = new UBOre(toRegisterAsOre, toRegisterAsOre.getDefaultState(), UBStoneType.IGNEOUS,
                    currentVariant.toString(),
                    UBOreConfigManager.alphaBlendingCache.get(toRegisterAsOre.getRegistryName().toString()));
            REGISTERED_ORES.put(toRegisterAsOre.getRegistryName().toString() + "/" + currentVariant.toString(), ore);
        }

        for (MetamorphicVariant currentVariant : MetamorphicVariant.values()) {
            UBOre ore = new UBOre(toRegisterAsOre, toRegisterAsOre.getDefaultState(), UBStoneType.METAMORPHIC,
                    currentVariant.toString(),
                    UBOreConfigManager.alphaBlendingCache.get(toRegisterAsOre.getRegistryName().toString()));
            REGISTERED_ORES.put(toRegisterAsOre.getRegistryName().toString() + "/" + currentVariant.toString(), ore);
        }

        for (SedimentaryVariant currentVariant : SedimentaryVariant.values()) {
            UBOre ore = new UBOre(toRegisterAsOre, toRegisterAsOre.getDefaultState(), UBStoneType.SEDIMENTARY,
                    currentVariant.toString(),
                    UBOreConfigManager.alphaBlendingCache.get(toRegisterAsOre.getRegistryName().toString()));
            REGISTERED_ORES.put(toRegisterAsOre.getRegistryName().toString() + "/" + currentVariant.toString(), ore);
        }
    }

    public static void registerOres(final RegistryEvent.Register<Block> e) {
        for (UBOre toRegister : REGISTERED_ORES.values())
            e.getRegistry().register(toRegister);
    }

    public static void registerOresItems(final RegistryEvent.Register<Item> e) {
        for (UBOre toRegister : REGISTERED_ORES.values())
            e.getRegistry().register(toRegister.getItemBlock());
    }

    public static void registerPack(final FMLClientSetupEvent event) {
        generatePack();
        event.getMinecraftSupplier().get().getResourcePackList().addPackFinder(new UBPackFinder());
    }

    public static void initialSetup() {
        UBOreConfigManager.setupConfigs();
    }

    public static void generatePack() {
        UBPackGenerator generator = new UBPackGenerator();
        generator.createFolders();
        generator.createMcMeta();
        for (UBOre toRegister : REGISTERED_ORES.values()) {
            generator.createModelForOre(toRegister.getRegistryName().toString(),
                    "undergroundbiomes:block/"
                            + UBOreConfigManager.stoneVariantCache.get(toRegister.baseOre.getRegistryName().toString())
                            + "/" + toRegister.sub_stone_name,
                    UBOreConfigManager.overlayCache.get(toRegister.baseOre.getRegistryName().toString()));
            generator.createBlockstateForOre(toRegister.getRegistryName().toString());
            generator.createItemModelForOre(toRegister.getRegistryName().toString());
            String localizedName = Character.toUpperCase(toRegister.sub_stone_name.charAt(0))
                    + toRegister.sub_stone_name.substring(1).replace("_", " ") + " "
                    + UBOreConfigManager.nameCache.get(toRegister.baseOre.getRegistryName().toString());
            generator.createLangEntryForItem(toRegister.getRegistryName().toString(), localizedName);
        }
        generator.createLangFile();
    }

    public static BlockState getOreForStoneIfExists(Block inStone, BlockState original) {
        if (!(inStone instanceof UBStone))
            return original;
        UBStone inBlockStone = (UBStone) inStone;
        if (inBlockStone.getStoneType() == UBStoneType.IGNEOUS) {
            if (REGISTERED_ORES.containsKey(
                    original.getBlock().getRegistryName().toString() + "/" + inBlockStone.igneous_variant.toString())) {

                return REGISTERED_ORES.get(
                        original.getBlock().getRegistryName().toString() + "/" + inBlockStone.igneous_variant.toString())
                        .getDefaultState();
            } else
                return original;
        } else if (inBlockStone.getStoneType() == UBStoneType.METAMORPHIC) {
            if (REGISTERED_ORES.containsKey(original.getBlock().getRegistryName().toString() + "/"
                    + inBlockStone.metamorphic_variant.toString())) {

                return REGISTERED_ORES.get(original.getBlock().getRegistryName().toString() + "/"
                        + inBlockStone.metamorphic_variant.toString()).getDefaultState();
            } else
                return original;
        } else if (inBlockStone.getStoneType() == UBStoneType.SEDIMENTARY) {
            if (REGISTERED_ORES.containsKey(original.getBlock().getRegistryName().toString() + "/"
                    + inBlockStone.sedimentary_variant.toString())) {

                return REGISTERED_ORES.get(original.getBlock().getRegistryName().toString() + "/"
                        + inBlockStone.sedimentary_variant.toString()).getDefaultState();
            } else
                return original;
        } else
            return original;

    }
}