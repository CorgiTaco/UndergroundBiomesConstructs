package com.aang23.undergroundbiomes.blocks;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class UBBrick extends Block implements UBBlock {
    public UBStoneType stone_type;
    public IgneousVariant igneous_variant;
    public MetamorphicVariant metamorphic_variant;
    public SedimentaryVariant sedimentary_variant;

    public UBBrick(IgneousVariant variant) {
        super(Properties.create(Material.ROCK));
        this.igneous_variant = variant;
        this.stone_type = UBStoneType.IGNEOUS;
        setRegistryName(UndergroundBiomes.MOD_ID + ":igneous_brick_" + variant.toString().toLowerCase());
    }

    public UBBrick(MetamorphicVariant variant) {
        super(Properties.create(Material.ROCK));
        this.metamorphic_variant = variant;
        this.stone_type = UBStoneType.METAMORPHIC;
        setRegistryName(UndergroundBiomes.MOD_ID + ":metamorphic_brick_" + variant.toString().toLowerCase());
    }

    public UBBrick(SedimentaryVariant variant) {
        super(Properties.create(Material.ROCK));
        this.sedimentary_variant = variant;
        this.stone_type = UBStoneType.SEDIMENTARY;
        setRegistryName(UndergroundBiomes.MOD_ID + ":sedimentary_brick_" + variant.toString().toLowerCase());
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.BRICK;
    }

    @Override
    public BlockItem getItemBlock() {
        BlockItem itemBlock = new BlockItem(this, new Item.Properties().group(UndergroundBiomes.CREATIVE_TAB));
        itemBlock.setRegistryName(this.getRegistryName().toString().replace(UndergroundBiomes.MOD_ID + ":", ""));
        return itemBlock;
    }

    @Override
    public Block getThisBlock() {
        return this;
    }

    @Override
    public UBStoneType getStoneType() {
        return stone_type;
    }


    @Override
    public float getPlayerRelativeBlockHardness(BlockState state, PlayerEntity player, IBlockReader worldIn, BlockPos pos) {
        switch (stone_type) {
            case IGNEOUS:
                return igneous_variant.getHardness();
            case METAMORPHIC:
                return metamorphic_variant.getHardness();
            case SEDIMENTARY:
                return sedimentary_variant.getHardness();
            default:
                return super.getPlayerRelativeBlockHardness(state, player, worldIn, pos);
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
}