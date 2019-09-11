package com.aang23.undergroundbiomes.blocks;

import java.util.ArrayList;
import java.util.List;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.IgneousVariant;
import com.aang23.undergroundbiomes.api.enums.MetamorphicVariant;
import com.aang23.undergroundbiomes.api.enums.SedimentaryVariant;
import com.aang23.undergroundbiomes.api.enums.UBBlock;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GravelBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.ToolType;
import net.minecraft.world.storage.loot.LootContext.Builder;

public class UBGravel extends GravelBlock implements UBBlock {

    public UBStoneType stone_type;
    public IgneousVariant igneous_variant;
    public MetamorphicVariant metamorphic_variant;
    public SedimentaryVariant sedimentary_variant;

    public UBGravel(IgneousVariant igneous_variant) {
        super(Properties.create(Material.SAND));
        this.igneous_variant = igneous_variant;
        this.stone_type = UBStoneType.IGNEOUS;
        setRegistryName(UndergroundBiomes.modid + ":igneous_gravel_" + igneous_variant.getName().toLowerCase());
    }

    public UBGravel(MetamorphicVariant metamorphic_variant) {
        super(Properties.create(Material.SAND));
        this.metamorphic_variant = metamorphic_variant;
        this.stone_type = UBStoneType.METAMORPHIC;
        setRegistryName(UndergroundBiomes.modid + ":metamorphic_gravel_" + metamorphic_variant.getName().toLowerCase());
    }

    public UBGravel(SedimentaryVariant sedimentary_variant) {
        super(Properties.create(Material.SAND));
        this.sedimentary_variant = sedimentary_variant;
        this.stone_type = UBStoneType.SEDIMENTARY;
        setRegistryName(UndergroundBiomes.modid + ":sedimentary_gravel_" + sedimentary_variant.getName().toLowerCase());
    }

    @Override
    public SoundType getSoundType(BlockState state) {
        return SoundType.SAND;
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.GRAVEL;
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
    public ToolType getHarvestTool(BlockState state) {
        return Blocks.GRAVEL.getHarvestTool(state);
    }

    @Override
    public float getBlockHardness(BlockState blockState, IBlockReader worldIn, BlockPos pos) {
        return Blocks.GRAVEL.getBlockHardness(blockState, worldIn, pos);
    }

    @Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing,
            IPlantable plantable) {
        return Blocks.GRAVEL.canSustainPlant(state, world, pos, facing, plantable);
    }

    @Override
    public Block getThisBlock() {
        return this;
    }
}