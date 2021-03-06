package com.aang23.undergroundbiomes.blocks;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.UBBlock;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.IdentityHashMap;
import java.util.List;

public class UBOre extends Block implements UBBlock {
    @Nullable
    public Block baseOre;
    public BlockState baseState;
    public UBStoneType stone_type;
    public String sub_stone_name;
    public final boolean useAlphaBlending;

    public static final IdentityHashMap<Block, RenderType> BLOCK_TO_RENDER_TYPE = new IdentityHashMap<>();


    public static UBOre create(Block baseOree, BlockState baseState, UBStoneType stoneType, String subStoneName, boolean useAlphaBlending) {
        return new UBOre(baseOree, baseState, stoneType, subStoneName, useAlphaBlending) {
            @Override
            protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
                if (baseOree != null)
                    baseOree.getStateContainer().getProperties().forEach(builder::add);
            }
        };
    }


    private UBOre(@Nullable Block baseOre, BlockState baseState, UBStoneType stoneType, String subStoneName, boolean useAlphaBlending) {
        super(Properties.create(baseOre.getDefaultState().getMaterial()));
        this.baseOre = baseOre;
        this.baseState = baseState;
        this.stone_type = stoneType;
        this.sub_stone_name = subStoneName;
        this.useAlphaBlending = useAlphaBlending;
        setRegistryName(UndergroundBiomes.MOD_ID + ":" + stoneType + "_ore_" + baseOre.getRegistryName().toString().replace(":", "_") + "_" + subStoneName);
        if (useAlphaBlending)
            BLOCK_TO_RENDER_TYPE.put(this, RenderType.getCutoutMipped());
        else
            BLOCK_TO_RENDER_TYPE.put(this, RenderType.getSolid());

    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.STONE;
    }

    @Override
    public BlockItem getItemBlock() {
        BlockItem itemBlock = new BlockItem(this, new Item.Properties().group(UndergroundBiomes.ORES_CREATIVE_TAB));
        itemBlock.setRegistryName(this.getRegistryName().toString().replace(UndergroundBiomes.MOD_ID + ":", ""));
        return itemBlock;
    }

    @Override
    public UBStoneType getStoneType() {
        return stone_type;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        if (baseOre != null)
            baseOre.getStateContainer().getProperties().forEach(builder::add);
    }


    @Override
    public BlockState getStateAtViewpoint(BlockState state, IBlockReader world, BlockPos pos, Vector3d viewpoint) {
        if (baseOre == null)
            return super.getStateAtViewpoint(state, world, pos, viewpoint);
        else
            return baseOre.getStateAtViewpoint(state, world, pos, viewpoint);
    }

    @Override
    public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
        if (baseOre == null)
            return super.getContainer(state, worldIn, pos);
        else
            return baseOre.getContainer(state, worldIn, pos);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        if (baseOre == null)
            return super.getStateForPlacement(context);
        else
            return baseOre.getStateForPlacement(context);
    }

    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        if (baseOre == null)
            super.onBlockClicked(state, worldIn, pos, player);
        else
            baseOre.onBlockClicked(state, worldIn, pos, player);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (baseOre == null)
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        else
            return baseOre.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, TileEntity te, ItemStack stack) {
        super.harvestBlock(worldIn, player, pos, state, te, stack);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        if (baseOre == null)
            return super.getDrops(state, builder);
        else
            return baseOre.getDrops(state, builder);
    }

    @Override
    public float getPlayerRelativeBlockHardness(BlockState state, PlayerEntity player, IBlockReader worldIn, BlockPos pos) {
        if (baseOre == null)
            return super.getPlayerRelativeBlockHardness(state, player, worldIn, pos);
        else
            return baseOre.getPlayerRelativeBlockHardness(state, player, worldIn, pos);
    }

    @Override
    public int getHarvestLevel(BlockState state) {
        if (baseOre == null)
            return super.getHarvestLevel(state);
        else
            return baseOre.getHarvestLevel(state);
    }

    @Override
    public ToolType getHarvestTool(BlockState state) {
        if (baseOre == null)
            return super.getHarvestTool(state);
        else
            return baseOre.getHarvestTool(state);
    }

    @Override
    public float getExplosionResistance() {
        if (baseOre == null)
            return super.getExplosionResistance();
        else
            return baseOre.getExplosionResistance();
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        if (baseState == null)
            return super.getLightValue(state, world, pos);
        else
            return 0;
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        if (baseOre == null)
            super.onBlockHarvested(worldIn, pos, state, player);
        else
            baseOre.onBlockHarvested(worldIn, pos, state, player);
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
        if (baseOre == null)
            return super.getExpDrop(state, world, pos, fortune, silktouch);
        else
            return baseOre.getExpDrop(state, world, pos, fortune, silktouch);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if (baseOre == null)
            super.onEntityWalk(worldIn, pos, entityIn);
        else
            baseOre.onEntityWalk(worldIn, pos, entityIn);
    }

    @Override
    public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
        if (baseOre == null)
            super.onPlayerDestroy(worldIn, pos, state);
        else
            baseOre.onPlayerDestroy(worldIn, pos, state);
    }

    @Override
    public Block getThisBlock() {
        return this;
    }
}