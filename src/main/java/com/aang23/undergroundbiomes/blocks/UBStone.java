package com.aang23.undergroundbiomes.blocks;

import com.aang23.undergroundbiomes.UBBlocks;
import com.aang23.undergroundbiomes.UBItems;
import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import java.util.ArrayList;
import java.util.List;

public class UBStone extends Block implements UBBlock {

    public UBStoneType stone_type;
    public IgneousVariant igneous_variant;
    public MetamorphicVariant metamorphic_variant;
    public SedimentaryVariant sedimentary_variant;

    public UBStone(IgneousVariant igneous_variant) {
        super(Properties.create(Material.ROCK));
        this.igneous_variant = igneous_variant;
        this.stone_type = UBStoneType.IGNEOUS;
        setRegistryName(UndergroundBiomes.MOD_ID + ":igneous_stone_" + igneous_variant.toString().toLowerCase());
    }

    public UBStone(MetamorphicVariant metamorphic_variant) {
        super(Properties.create(Material.ROCK));
        this.metamorphic_variant = metamorphic_variant;
        this.stone_type = UBStoneType.METAMORPHIC;
        setRegistryName(UndergroundBiomes.MOD_ID + ":metamorphic_stone_" + metamorphic_variant.toString().toLowerCase());
    }

    public UBStone(SedimentaryVariant sedimentary_variant) {
        super(Properties.create(Material.ROCK));
        this.sedimentary_variant = sedimentary_variant;
        this.stone_type = UBStoneType.SEDIMENTARY;
        setRegistryName(UndergroundBiomes.MOD_ID + ":sedimentary_stone_" + sedimentary_variant.toString().toLowerCase());
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

    @Override
    public List<ItemStack> getDrops(BlockState blockstate, LootContext.Builder builder) {
        List<ItemStack> drops = new ArrayList<ItemStack>();

        switch (stone_type) {
            case IGNEOUS:
                drops.add(new ItemStack(UBBlocks.getBlock(UBStoneStyle.COBBLE, igneous_variant)));
                break;
            case METAMORPHIC:
                drops.add(new ItemStack(UBBlocks.getBlock(UBStoneStyle.COBBLE, metamorphic_variant)));
                break;
            case SEDIMENTARY:
            if (sedimentary_variant == SedimentaryVariant.LIGNITE) {
                drops.add(new ItemStack(UBItems.LIGNITE_COAL));
            } else {
                if (Math.random() * 10 > 8) {
                    switch (sedimentary_variant) {
                    case CHALK:
                        drops.add(new ItemStack(UBItems.getRandomFossil()));
                        break;
                    case DOLOMITE:
                        drops.add(new ItemStack(this.asItem()));
                    case LIGNITE:
                        drops.add(new ItemStack(this.asItem()));
                    case LIMESTONE:
                        drops.add(new ItemStack(UBItems.getRandomFossil()));
                        break;
                    case SILTSTONE:
                        drops.add(new ItemStack(UBItems.getRandomFossil()));
                        break;
                    case SHALE:
                        drops.add(new ItemStack(Items.CLAY_BALL));
                        break;
                    case CHERT:
                        drops.add(new ItemStack(Items.FLINT));
                        break;
                    default:
                        break;
                    }
                } else
                    drops.add(new ItemStack(this.asItem()));
            }
            break;
        }

        // TODO Fortune compat?
        return drops;
    }
}