package com.aang23.undergroundbiomes.blocks;

import java.util.ArrayList;
import java.util.List;

import com.aang23.undergroundbiomes.UBBlocks;
import com.aang23.undergroundbiomes.UBItems;
import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.IgneousVariant;
import com.aang23.undergroundbiomes.api.enums.MetamorphicVariant;
import com.aang23.undergroundbiomes.api.enums.SedimentaryVariant;
import com.aang23.undergroundbiomes.api.enums.UBBlock;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.storage.loot.LootContext.Builder;

public class UBStone extends Block implements UBBlock {

    public UBStoneType stone_type;
    public IgneousVariant igneous_variant;
    public MetamorphicVariant metamorphic_variant;
    public SedimentaryVariant sedimentary_variant;

    public UBStone(IgneousVariant igneous_variant) {
        super(Properties.create(Material.ROCK));
        this.igneous_variant = igneous_variant;
        this.stone_type = UBStoneType.IGNEOUS;
        setRegistryName(UndergroundBiomes.modid + ":igneous_stone_" + igneous_variant.getName().toLowerCase());
    }

    public UBStone(MetamorphicVariant metamorphic_variant) {
        super(Properties.create(Material.ROCK));
        this.metamorphic_variant = metamorphic_variant;
        this.stone_type = UBStoneType.IGNEOUS;
        setRegistryName(UndergroundBiomes.modid + ":metamorphic_stone_" + metamorphic_variant.getName().toLowerCase());
    }

    public UBStone(SedimentaryVariant sedimentary_variant) {
        super(Properties.create(Material.ROCK));
        this.sedimentary_variant = sedimentary_variant;
        this.stone_type = UBStoneType.IGNEOUS;
        setRegistryName(UndergroundBiomes.modid + ":sedimentary_stone_" + sedimentary_variant.getName().toLowerCase());
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.STONE;
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

    @Override
    public List<ItemStack> getDrops(BlockState blockstate, Builder builder) {
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