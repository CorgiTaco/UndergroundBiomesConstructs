package com.aang23.undergroundbiomes.blocks;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.ToolType;

public class UBSand extends SandBlock implements UBBlock {

    public UBStoneType stone_type;
    public IgneousVariant igneous_variant;
    public MetamorphicVariant metamorphic_variant;
    public SedimentaryVariant sedimentary_variant;

    public UBSand(IgneousVariant igneous_variant) {
        super(0, Properties.create(Material.SAND));
        this.igneous_variant = igneous_variant;
        this.stone_type = UBStoneType.IGNEOUS;
        setRegistryName(UndergroundBiomes.MOD_ID + ":igneous_sand_" + igneous_variant.toString().toLowerCase());
    }

    public UBSand(MetamorphicVariant metamorphic_variant) {
        super(0, Properties.create(Material.SAND));
        this.metamorphic_variant = metamorphic_variant;
        this.stone_type = UBStoneType.METAMORPHIC;
        setRegistryName(UndergroundBiomes.MOD_ID + ":metamorphic_sand_" + metamorphic_variant.toString().toLowerCase());
    }

    public UBSand(SedimentaryVariant sedimentary_variant) {
        super(0, Properties.create(Material.SAND));
        this.sedimentary_variant = sedimentary_variant;
        this.stone_type = UBStoneType.SEDIMENTARY;
        setRegistryName(UndergroundBiomes.MOD_ID + ":sedimentary_sand_" + sedimentary_variant.toString().toLowerCase());
    }

    @Override
    public SoundType getSoundType(BlockState state) {
        return SoundType.SAND;
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.SAND;
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
    public ToolType getHarvestTool(BlockState state) {
        return Blocks.SAND.getHarvestTool(state);
    }

    @Override
    public float getPlayerRelativeBlockHardness(BlockState state, PlayerEntity player, IBlockReader worldIn, BlockPos pos) {
        return Blocks.SAND.getPlayerRelativeBlockHardness(state, player, worldIn, pos);
    }

    @Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing,
            IPlantable plantable) {
        return Blocks.SAND.canSustainPlant(state, world, pos, facing, plantable);
    }

    @Override
    public Block getThisBlock() {
        return this;
    }
}