package com.aang23.undergroundbiomes.config.utils;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.config.UBConfig;
import com.google.gson.JsonObject;

import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class StoneRecipeHandler implements IConditionSerializer {

    @Override
    public ResourceLocation getID() {
        return new ResourceLocation(UndergroundBiomes.modid, "stone_recipe_enabled");
    }

    @Override
    public ICondition read(JsonObject json) {
        return new StoneRecipeHandlerCondition(
                JSONUtils.getBoolean(json, "value", true) == UBConfig.RECIPES.stoneToVanillaRecipe.get());
    }

    @Override
    public void write(JsonObject arg0, ICondition arg1) {

    }

    public class StoneRecipeHandlerCondition implements ICondition {

        boolean value;

        public StoneRecipeHandlerCondition(boolean value) {
            this.value = value;
        }

        @Override
        public ResourceLocation getID() {
            return new ResourceLocation(UndergroundBiomes.modid, "stone_recipe_enabled");
        }

        @Override
        public boolean test() {
            return value;
        }

    }

}