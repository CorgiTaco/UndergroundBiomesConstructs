package com.aang23.undergroundbiomes.blocks;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.api.enums.UBBlock;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;

import net.minecraft.block.AnvilBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext.Builder;
import net.minecraftforge.common.ToolType;

public class UBOre extends Block implements UBBlock {
    public Block baseOre;
    public BlockState baseState;
    public UBStoneType stone_type;
    public String sub_stone_name;
    public final boolean useAlphaBlending;

    public UBOre(Block baseOre, BlockState baseState, UBStoneType stone_type, String sub_stone_name,
            boolean useAlphaBlending) {
        super(Properties.create(baseOre.getMaterial(baseState)));
        System.out.println(baseOre);
        this.baseOre = baseOre;
        this.baseState = baseState;
        this.stone_type = stone_type;
        this.sub_stone_name = sub_stone_name;
        this.useAlphaBlending = useAlphaBlending;
        setRegistryName(UndergroundBiomes.modid + ":" + stone_type + "_ore_"
                + baseOre.getRegistryName().toString().replace(":", "_") + "_" + sub_stone_name);
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.STONE;
    }

    @Override
    public BlockItem getItemBlock() {
        BlockItem itemBlock = new BlockItem(this, new Item.Properties().group(UndergroundBiomes.ORES_CREATIVE_TAB));
        itemBlock.setRegistryName(this.getRegistryName().toString().replace(UndergroundBiomes.modid + ":", ""));
        return itemBlock;
    }

    @Override
    public UBStoneType getStoneType() {
        return stone_type;
    }

    @Override
    protected void fillStateContainer(net.minecraft.state.StateContainer.Builder<Block, BlockState> builder) {
        // This method gets called in our parent's constructor... So this would crash
        // since baseOre would be null
        if (baseOre == null) {
            super.fillStateContainer(builder);
            return;
        }

        // Reflection to access private method on baseOre
        try {
            Method fillStateMethod = null;
            fillStateMethod = baseOre.getClass().getDeclaredMethod("fillStateContainer",
                    new Class[] { net.minecraft.state.StateContainer.Builder.class });
            fillStateMethod.setAccessible(true);
            fillStateMethod.invoke(baseOre, builder);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockState state, Direction facing, BlockState state2, IWorld world,
            BlockPos pos1, BlockPos pos2, Hand hand) {
        // TODO Auto-generated method stub
        return baseOre.getStateForPlacement(state, facing, state2, world, pos1, pos2, hand);
    }

    @Override
    public BlockState getStateAtViewpoint(BlockState state, IBlockReader world, BlockPos pos, Vec3d viewpoint) {
        // TODO Auto-generated method stub
        return baseOre.getStateAtViewpoint(state, world, pos, viewpoint);
    }

    @Override
    public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
        // TODO Auto-generated method stub
        return baseOre.getContainer(state, worldIn, pos);
    }

    @Override
    public BlockState getExtendedState(BlockState state, IBlockReader world, BlockPos pos) {
        // TODO Auto-generated method stub
        return baseOre.getExtendedState(state, world, pos);
    }

    @Override
    public StateContainer<Block, BlockState> getStateContainer() {
        // TODO Auto-generated method stub
        return baseOre.getStateContainer();
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        // TODO Auto-generated method stub
        return baseOre.getStateForPlacement(context);
    }

    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        // TODO Auto-generated method stub
        baseOre.onBlockClicked(state, worldIn, pos, player);
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
            BlockRayTraceResult hit) {
        // TODO Auto-generated method stub
        return baseOre.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return useAlphaBlending ? BlockRenderLayer.CUTOUT_MIPPED : BlockRenderLayer.SOLID;
    }

    @Override
    public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, TileEntity te,
            ItemStack stack) {
        super.harvestBlock(worldIn, player, pos, state, te, stack);
    }

    @Override
    public List<ItemStack> getDrops(BlockState p_220076_1_, Builder p_220076_2_) {
        return baseOre.getDrops(p_220076_1_, p_220076_2_);
    }

    @Override
    public float getBlockHardness(BlockState blockState, IBlockReader worldIn, BlockPos pos) {
        return baseOre.getBlockHardness(blockState, worldIn, pos);
    }

    @Override
    public int getHarvestLevel(BlockState state) {
        return baseOre.getHarvestLevel(state);
    }

    @Override
    public ToolType getHarvestTool(BlockState state) {
        return baseOre.getHarvestTool(state);
    }

    @Override
    public float getExplosionResistance() {
        return baseOre.getExplosionResistance();
    }

    @Override
    public int getLightValue(BlockState state) {
        return 0; // TODO fix
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        baseOre.onBlockHarvested(worldIn, pos, state, player);
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
        return baseOre.getExpDrop(state, world, pos, fortune, silktouch);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        baseOre.onEntityWalk(worldIn, pos, entityIn); // TODO fix
    }

    @Override
    public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
        baseOre.onPlayerDestroy(worldIn, pos, state);
    }

    @Override
    public Block getThisBlock() {
        return this;
    }
}