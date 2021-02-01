package com.aang23.undergroundbiomes.world;

import com.aang23.undergroundbiomes.config.UBConfig;
import com.aang23.undergroundbiomes.config.WorldConfig;
import com.aang23.undergroundbiomes.world.strata.TraditionalStoneReplacer;
import com.aang23.undergroundbiomes.world.strata.UBBiomesSet;
import com.aang23.undergroundbiomes.world.strata.UBStoneReplacer;
import com.aang23.undergroundbiomes.world.strata.UndergroundBiomeSet;
import com.aang23.undergroundbiomes.world.utils.WorldChunkChecker;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.thread.EffectiveSide;

public class WorldGenManager {

  private UBStoneReplacer stoneReplacer;

  private WorldConfig worldConfig;

  private final String dimensionID;

  private UndergroundBiomeSet biomesSet = null;

  private boolean worldDone = false;
  private int seed;

  public WorldGenManager(String dimensionID) {
    this.dimensionID = dimensionID;
  }

  @SubscribeEvent(priority = EventPriority.HIGHEST)
  public void onWorldLoad(WorldEvent.Load event) {
    if (EffectiveSide.get() == LogicalSide.SERVER) {
      if (dimensionID.equals(((World) event.getWorld()).getDimensionKey().getLocation().toString())) {
        if (!worldDone) {

          worldConfig = new WorldConfig(event.getWorld());
          worldConfig.loadConfig();

          biomesSet = new UBBiomesSet(worldConfig);
          seed = (int) ((ServerWorld) event.getWorld()).getSeed();
          if (UBConfig.ADVANCED.differentSeedPerWorld.get())
            seed += dimensionID.hashCode();

          this.stoneReplacer = new TraditionalStoneReplacer(seed, worldConfig.biomeSize(), biomesSet, worldConfig);

          // TODO World specific config

          worldDone = true;
        }
      }
    }
  }

  @SubscribeEvent(priority = EventPriority.LOWEST)
  public void onPopulateChunk(ChunkEvent.Load event) {

    if (!worldDone || event.getWorld() == null || event.getChunk() == null)
      return;

    if (EffectiveSide.get() == LogicalSide.SERVER) {
      if (dimensionID.equals(((World) event.getWorld()).getDimensionKey().getLocation().toString())) {
        if (!WorldChunkChecker.hasAlreadyBeenUBfied(event.getChunk())) {
          IChunk chunk = event.getChunk();

          this.stoneReplacer.replaceStoneInChunk(chunk);
          // stoneReplacer.redoOres(event.getWorld());

          ((Chunk) chunk).setModified(true);
          ((Chunk) chunk).markDirty();
          WorldChunkChecker.setDone(event.getChunk());
        }
      }
    }
  }
}