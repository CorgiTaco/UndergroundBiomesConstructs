package com.aang23.undergroundbiomes;

import com.aang23.undergroundbiomes.api.enums.*;
import com.aang23.undergroundbiomes.blocks.*;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UBBlocks {
        private static Map<Pair<UBStoneStyle, IgneousVariant>, UBBlock> igneous_blocks = new HashMap<Pair<UBStoneStyle, IgneousVariant>, UBBlock>();
        private static Map<Pair<UBStoneStyle, MetamorphicVariant>, UBBlock> metamorphic_blocks = new HashMap<Pair<UBStoneStyle, MetamorphicVariant>, UBBlock>();
        private static Map<Pair<UBStoneStyle, SedimentaryVariant>, UBBlock> sedimentary_blocks = new HashMap<Pair<UBStoneStyle, SedimentaryVariant>, UBBlock>();

        public static void initialSetup() {
                for (IgneousVariant currentVariant : IgneousVariant.values()) {
                        igneous_blocks.put(new Pair<UBStoneStyle, IgneousVariant>(UBStoneStyle.STONE, currentVariant),
                                new UBStone(currentVariant));
                        igneous_blocks.put(new Pair<UBStoneStyle, IgneousVariant>(UBStoneStyle.BRICK, currentVariant),
                                        new UBBrick(currentVariant));
                        igneous_blocks.put(new Pair<UBStoneStyle, IgneousVariant>(UBStoneStyle.COBBLE, currentVariant),
                                        new UBCobble(currentVariant));
                        igneous_blocks.put(new Pair<UBStoneStyle, IgneousVariant>(UBStoneStyle.COBBLE_STAIRS,
                                        currentVariant), new UBCobbleStairs(currentVariant));
                        igneous_blocks.put(new Pair<UBStoneStyle, IgneousVariant>(UBStoneStyle.STONE_STAIRS,
                                        currentVariant), new UBStoneStairs(currentVariant));
                        igneous_blocks.put(new Pair<UBStoneStyle, IgneousVariant>(UBStoneStyle.SAND, currentVariant),
                                        new UBSand(currentVariant));
                        igneous_blocks.put(new Pair<UBStoneStyle, IgneousVariant>(UBStoneStyle.GRAVEL, currentVariant),
                                        new UBGravel(currentVariant));
                        igneous_blocks.put(new Pair<UBStoneStyle, IgneousVariant>(UBStoneStyle.INFESTED_STONE,
                                        currentVariant), new UBInfestedStone(currentVariant));
                        igneous_blocks.put(new Pair<UBStoneStyle, IgneousVariant>(UBStoneStyle.STONE_BUTTON,
                                        currentVariant), new UBStoneButton(currentVariant));
                        igneous_blocks.put(new Pair<UBStoneStyle, IgneousVariant>(UBStoneStyle.COBBLE_WALL,
                                        currentVariant), new UBCobbleWall(currentVariant));
                }
                for (MetamorphicVariant currentVariant : MetamorphicVariant.values()) {
                        metamorphic_blocks.put(
                                        new Pair<UBStoneStyle, MetamorphicVariant>(UBStoneStyle.STONE, currentVariant),
                                        new UBStone(currentVariant));
                        metamorphic_blocks.put(
                                        new Pair<UBStoneStyle, MetamorphicVariant>(UBStoneStyle.BRICK, currentVariant),
                                        new UBBrick(currentVariant));
                        metamorphic_blocks.put(
                                        new Pair<UBStoneStyle, MetamorphicVariant>(UBStoneStyle.COBBLE, currentVariant),
                                        new UBCobble(currentVariant));
                        metamorphic_blocks.put(new Pair<UBStoneStyle, MetamorphicVariant>(UBStoneStyle.COBBLE_STAIRS,
                                        currentVariant), new UBCobbleStairs(currentVariant));
                        metamorphic_blocks.put(new Pair<UBStoneStyle, MetamorphicVariant>(UBStoneStyle.STONE_STAIRS,
                                        currentVariant), new UBStoneStairs(currentVariant));
                        metamorphic_blocks.put(
                                        new Pair<UBStoneStyle, MetamorphicVariant>(UBStoneStyle.SAND, currentVariant),
                                        new UBSand(currentVariant));
                        metamorphic_blocks.put(
                                        new Pair<UBStoneStyle, MetamorphicVariant>(UBStoneStyle.GRAVEL, currentVariant),
                                        new UBGravel(currentVariant));
                        metamorphic_blocks.put(new Pair<UBStoneStyle, MetamorphicVariant>(UBStoneStyle.INFESTED_STONE,
                                        currentVariant), new UBInfestedStone(currentVariant));
                        metamorphic_blocks.put(new Pair<UBStoneStyle, MetamorphicVariant>(UBStoneStyle.STONE_BUTTON,
                                        currentVariant), new UBStoneButton(currentVariant));
                        metamorphic_blocks.put(new Pair<UBStoneStyle, MetamorphicVariant>(UBStoneStyle.COBBLE_WALL,
                                        currentVariant), new UBCobbleWall(currentVariant));
                }
                for (SedimentaryVariant currentVariant : SedimentaryVariant.values()) {
                        sedimentary_blocks.put(
                                        new Pair<UBStoneStyle, SedimentaryVariant>(UBStoneStyle.STONE, currentVariant),
                                        new UBStone(currentVariant));
                        if (currentVariant != SedimentaryVariant.LIGNITE) // No Lignite brick
                                sedimentary_blocks.put(new Pair<UBStoneStyle, SedimentaryVariant>(UBStoneStyle.BRICK,
                                                currentVariant), new UBBrick(currentVariant));
                        if (currentVariant != SedimentaryVariant.LIGNITE) // No Lignite cobble
                                sedimentary_blocks.put(new Pair<UBStoneStyle, SedimentaryVariant>(UBStoneStyle.COBBLE,
                                                currentVariant), new UBCobble(currentVariant));
                        if (currentVariant != SedimentaryVariant.LIGNITE) // No Lignite cobble stairs
                                sedimentary_blocks.put(
                                                new Pair<UBStoneStyle, SedimentaryVariant>(UBStoneStyle.COBBLE_STAIRS,
                                                                currentVariant),
                                                new UBCobbleStairs(currentVariant));
                        sedimentary_blocks.put(new Pair<UBStoneStyle, SedimentaryVariant>(UBStoneStyle.STONE_STAIRS,
                                        currentVariant), new UBStoneStairs(currentVariant));
                        sedimentary_blocks.put(
                                        new Pair<UBStoneStyle, SedimentaryVariant>(UBStoneStyle.SAND, currentVariant),
                                        new UBSand(currentVariant));
                        sedimentary_blocks.put(
                                        new Pair<UBStoneStyle, SedimentaryVariant>(UBStoneStyle.GRAVEL, currentVariant),
                                        new UBGravel(currentVariant));
                        sedimentary_blocks.put(new Pair<UBStoneStyle, SedimentaryVariant>(UBStoneStyle.INFESTED_STONE,
                                        currentVariant), new UBInfestedStone(currentVariant));
                        sedimentary_blocks.put(new Pair<UBStoneStyle, SedimentaryVariant>(UBStoneStyle.STONE_BUTTON,
                                        currentVariant), new UBStoneButton(currentVariant));
                        if (currentVariant != SedimentaryVariant.LIGNITE) // No Lignite cobble wall
                                sedimentary_blocks.put(
                                                new Pair<UBStoneStyle, SedimentaryVariant>(UBStoneStyle.COBBLE_WALL,
                                                                currentVariant),
                                                new UBCobbleWall(currentVariant));
                }
        }

        public static void registerBlocks(final RegistryEvent.Register<Block> e) {
                for (UBBlock currentToReg : igneous_blocks.values())
                        e.getRegistry().register(currentToReg.getThisBlock());
                for (UBBlock currentToReg : metamorphic_blocks.values())
                        e.getRegistry().register(currentToReg.getThisBlock());
                for (UBBlock currentToReg : sedimentary_blocks.values())
                        e.getRegistry().register(currentToReg.getThisBlock());
        }

        public static void registerItems(final RegistryEvent.Register<Item> e) {
                for (UBBlock currentToReg : igneous_blocks.values())
                        e.getRegistry().register(currentToReg.getItemBlock());
                for (UBBlock currentToReg : metamorphic_blocks.values())
                        e.getRegistry().register(currentToReg.getItemBlock());
                for (UBBlock currentToReg : sedimentary_blocks.values())
                        e.getRegistry().register(currentToReg.getItemBlock());
        }

        public static Block getBlock(UBStoneStyle style, IgneousVariant variant) {
                return igneous_blocks.containsKey(new Pair<UBStoneStyle, IgneousVariant>(style, variant))
                                ? igneous_blocks.get(new Pair<UBStoneStyle, IgneousVariant>(style, variant))
                                                .getThisBlock()
                                : null;
        }

        public static Block getBlock(UBStoneStyle style, MetamorphicVariant variant) {
                return metamorphic_blocks.containsKey(new Pair<UBStoneStyle, MetamorphicVariant>(style, variant))
                                ? metamorphic_blocks.get(new Pair<UBStoneStyle, MetamorphicVariant>(style, variant))
                                                .getThisBlock()
                                : null;
        }

        public static Block getBlock(UBStoneStyle style, SedimentaryVariant variant) {
                return sedimentary_blocks.containsKey(new Pair<UBStoneStyle, SedimentaryVariant>(style, variant))
                                ? sedimentary_blocks.get(new Pair<UBStoneStyle, SedimentaryVariant>(style, variant))
                                                .getThisBlock()
                                : null;
        }

        public static Optional<Block> getBlockVariantForStoneIfExists(Block initialBlock, UBStoneStyle style) {
                if (initialBlock instanceof UBStone) {
                        UBStone initialStone = (UBStone) initialBlock;
                        switch (initialStone.getStoneType()) {
                        case IGNEOUS:
                                Block blockI = getBlock(style, initialStone.igneous_variant);
                                return blockI != null ? Optional.of(blockI) : Optional.empty();
                        case METAMORPHIC:
                                Block blockM = getBlock(style, initialStone.metamorphic_variant);
                                return blockM != null ? Optional.of(blockM) : Optional.empty();
                        case SEDIMENTARY:
                                Block blockS = getBlock(style, initialStone.sedimentary_variant);
                                return blockS != null ? Optional.of(blockS) : Optional.empty();
                        default:
                                return Optional.empty();
                        }
                } else
                        return Optional.empty();
        }
}