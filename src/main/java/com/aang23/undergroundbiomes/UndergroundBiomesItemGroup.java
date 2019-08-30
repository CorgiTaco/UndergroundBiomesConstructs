package com.aang23.undergroundbiomes;

import com.aang23.undergroundbiomes.api.enums.IgneousVariant;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class UndergroundBiomesItemGroup extends ItemGroup {
    UndergroundBiomesItemGroup() {
        super("tabUndergroundBiomesBlocks");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(UBBlocks.getBlock(UBStoneStyle.STONE, IgneousVariant.BLACK_GRANITE));
    }
}