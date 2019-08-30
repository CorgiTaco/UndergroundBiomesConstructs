package com.aang23.undergroundbiomes.world;

import java.util.Optional;

import com.aang23.undergroundbiomes.UBBlocks;
import com.aang23.undergroundbiomes.blocks.UBStone;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

public class StoneRegistry {
    public static Block getVariantForStone(BlockState initialState, UBStoneStyle style) {
        Block initialBlock = initialState.getBlock();
        if (initialBlock instanceof UBStone) {
            UBStone stone = (UBStone) initialBlock;
            switch (style) {
            case GRAVEL:
                return getGravelForStone(stone);
            case COBBLE:
                return getCobbleForStone(stone);
            case SAND:
                return getSandForStone(stone);
            case INFESTED_STONE:
                return getInfestedStoneForStone(stone);
            default:
                return null;
            }
        } else
            return initialBlock;
    }

    public static Block getGravelForStone(UBStone stone) {
        Optional<Block> newBlock = UBBlocks.getBlockVariantForStoneIfExists(stone, UBStoneStyle.GRAVEL);
        if (newBlock.isPresent())
            return newBlock.get();
        else
            return Blocks.GRAVEL;
    }

    public static Block getInfestedStoneForStone(UBStone stone) {
        Optional<Block> newBlock = UBBlocks.getBlockVariantForStoneIfExists(stone, UBStoneStyle.INFESTED_STONE);
        if (newBlock.isPresent())
            return newBlock.get();
        else
            return Blocks.INFESTED_STONE;
    }

    public static Block getCobbleForStone(UBStone stone) {
        Optional<Block> newBlock = UBBlocks.getBlockVariantForStoneIfExists(stone, UBStoneStyle.COBBLE);
        if (newBlock.isPresent())
            return newBlock.get();
        else
            return Blocks.COBBLESTONE;
    }

    public static Block getSandForStone(UBStone stone) {
        Optional<Block> newBlock = UBBlocks.getBlockVariantForStoneIfExists(stone, UBStoneStyle.SAND);
        if (newBlock.isPresent())
            return newBlock.get();
        else
            return Blocks.SAND;
    }
}