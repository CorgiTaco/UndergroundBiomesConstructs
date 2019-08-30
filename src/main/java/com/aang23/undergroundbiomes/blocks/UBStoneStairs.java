package com.aang23.undergroundbiomes.blocks;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.IgneousVariant;
import com.aang23.undergroundbiomes.api.enums.MetamorphicVariant;
import com.aang23.undergroundbiomes.api.enums.SedimentaryVariant;
import com.aang23.undergroundbiomes.api.enums.UBBlock;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class UBStoneStairs extends StairsBlock implements UBBlock {

    public UBStoneType stone_type;
    public IgneousVariant igneous_variant;
    public MetamorphicVariant metamorphic_variant;
    public SedimentaryVariant sedimentary_variant;

    public UBStoneStairs(IgneousVariant igneous_variant) {
        super(new UBCobble(igneous_variant).getDefaultState(), Properties.create(Material.ROCK));
        this.igneous_variant = igneous_variant;
        this.stone_type = UBStoneType.IGNEOUS;
        setRegistryName(UndergroundBiomes.modid + ":igneous_stone_stairs_" + igneous_variant.getName().toLowerCase());
    }

    public UBStoneStairs(MetamorphicVariant metamorphic_variant) {
        super(new UBCobble(metamorphic_variant).getDefaultState(), Properties.create(Material.ROCK));
        this.metamorphic_variant = metamorphic_variant;
        this.stone_type = UBStoneType.METAMORPHIC;
        setRegistryName(
                UndergroundBiomes.modid + ":metamorphic_stone_stairs_" + metamorphic_variant.getName().toLowerCase());
    }

    public UBStoneStairs(SedimentaryVariant sedimentary_variant) {
        super(new UBCobble(sedimentary_variant).getDefaultState(), Properties.create(Material.ROCK));
        this.sedimentary_variant = sedimentary_variant;
        this.stone_type = UBStoneType.SEDIMENTARY;
        setRegistryName(
                UndergroundBiomes.modid + ":sedimentary_stone_stairs_" + sedimentary_variant.getName().toLowerCase());
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.STONE_STAIRS;
    }

    @Override
    public BlockItem getItemBlock() {
        BlockItem itemBlock = new BlockItem(this, new Item.Properties().group(UndergroundBiomes.CREATIVE_TAB));
        itemBlock.setRegistryName(this.getRegistryName().toString().replace(UndergroundBiomes.modid + ":", ""));
        return itemBlock;
    }

    @Override
    public UBStoneType getStoneType() {
        return stone_type;
    }

    @Override
    public float getBlockHardness(BlockState blockState, IBlockReader worldIn, BlockPos pos) {
        switch (stone_type) {
        case IGNEOUS:
            return igneous_variant.getHardness();
        case METAMORPHIC:
            return metamorphic_variant.getHardness();
        case SEDIMENTARY:
            return sedimentary_variant.getHardness();
        default:
            return super.getBlockHardness(blockState, worldIn, pos);
        }
    }

    @Override
    public float getExplosionResistance() {
        switch (stone_type) {
        case IGNEOUS:
            return igneous_variant.getResistance();
        case METAMORPHIC:
            return metamorphic_variant.getResistance();
        case SEDIMENTARY:
            return sedimentary_variant.getResistance();
        default:
            return super.getExplosionResistance();
        }
    }

    @Override
    public Block getThisBlock() {
        return this;
    }
}