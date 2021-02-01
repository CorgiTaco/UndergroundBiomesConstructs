package com.aang23.undergroundbiomes.helpers;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateContainer;

public interface BlockHelper {
    void getFillStateContainer(StateContainer.Builder<Block, BlockState> builder);
}
