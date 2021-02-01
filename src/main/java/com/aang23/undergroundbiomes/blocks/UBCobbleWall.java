package com.aang23.undergroundbiomes.blocks;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class UBCobbleWall extends WallBlock implements UBBlock {

    public UBStoneType stone_type;
    public IgneousVariant igneous_variant;
    public MetamorphicVariant metamorphic_variant;
    public SedimentaryVariant sedimentary_variant;

    public UBCobbleWall(IgneousVariant igneous_variant) {
        super(Properties.create(Material.ROCK));
        this.igneous_variant = igneous_variant;
        this.stone_type = UBStoneType.IGNEOUS;
        setRegistryName(UndergroundBiomes.MOD_ID + ":igneous_cobble_wall_" + igneous_variant.toString().toLowerCase());
    }

    public UBCobbleWall(MetamorphicVariant metamorphic_variant) {
        super(Properties.create(Material.ROCK));
        this.metamorphic_variant = metamorphic_variant;
        this.stone_type = UBStoneType.METAMORPHIC;
        setRegistryName(
                UndergroundBiomes.MOD_ID + ":metamorphic_cobble_wall_" + metamorphic_variant.toString().toLowerCase());
    }

    public UBCobbleWall(SedimentaryVariant sedimentary_variant) {
        super(Properties.create(Material.ROCK));
        this.sedimentary_variant = sedimentary_variant;
        this.stone_type = UBStoneType.SEDIMENTARY;
        setRegistryName(
                UndergroundBiomes.MOD_ID + ":sedimentary_cobble_wall_" + sedimentary_variant.toString().toLowerCase());
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.STONE;
    }

    @Override
    public BlockItem getItemBlock() {
        BlockItem itemBlock = new BlockItem(this, new Item.Properties().group(UndergroundBiomes.CREATIVE_TAB));
        itemBlock.setRegistryName(this.getRegistryName().toString().replace(UndergroundBiomes.MOD_ID + ":", ""));
        return itemBlock;
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

    @Override
    public Block getThisBlock() {
        return this;
    }
}