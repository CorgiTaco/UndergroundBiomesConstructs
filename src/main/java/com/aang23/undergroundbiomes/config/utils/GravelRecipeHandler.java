package com.aang23.undergroundbiomes.config.utils;

import com.aang23.undergroundbiomes.UndergroundBiomes;
import com.aang23.undergroundbiomes.config.UBConfig;
import com.google.gson.JsonObject;

import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class GravelRecipeHandler implements IConditionSerializer {
    @Override
    public ResourceLocation getID() {
        return new ResourceLocation(UndergroundBiomes.modid, "gravel_recipe_enabled");
    }

    @Override
    public ICondition read(JsonObject json) {
        return new GravelRecipeHandlerCondition(
                JSONUtils.getBoolean(json, "value", true) == UBConfig.RECIPES.gravelToVanillaRecipe.get());
    }

    @Override
    public void write(JsonObject arg0, ICondition arg1) {

    }

    public class GravelRecipeHandlerCondition implements ICondition {

        boolean value;

        public GravelRecipeHandlerCondition(boolean value) {
            this.value = value;
        }

        @Override
        public ResourceLocation getID() {
            return new ResourceLocation(UndergroundBiomes.modid, "gravel_recipe_enabled");
        }

        @Override
        public boolean test() {
            return value;
        }

    }

}