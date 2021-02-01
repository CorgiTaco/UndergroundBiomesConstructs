package com.aang23.undergroundbiomes.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class UBConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final General GENERAL = new General(BUILDER);
    public static final WorldGen WORLDGEN = new WorldGen(BUILDER);
    public static final Items ITEMS = new Items(BUILDER);
    public static final Recipes RECIPES = new Recipes(BUILDER);
    public static final Advanced ADVANCED = new Advanced(BUILDER);
    public static final ForgeConfigSpec SPEC = BUILDER.build();

    public static class General {
        public final ForgeConfigSpec.ConfigValue<String> ubChunkKey;
        public final ForgeConfigSpec.ConfigValue<String> dimensionList;

        General(ForgeConfigSpec.Builder builder) {
            builder.push("General");

            ubChunkKey = builder.comment("The sring used to mark chunks as UB-fied. Change only if you want UBC to redo everything.").define("ubChunkKey", "ub");
            dimensionList = builder.comment("The list of dimension string ids. Must be separated by a comma (,). Whitelist.").define("dimensionList", "minecraft:overworld");

            builder.pop();
        }
    }

    public static class WorldGen {
        public final ForgeConfigSpec.BooleanValue replaceStone;
        public final ForgeConfigSpec.BooleanValue replaceGravel;
        public final ForgeConfigSpec.BooleanValue replaceCobble;
        public final ForgeConfigSpec.BooleanValue replaceSand;
        public final ForgeConfigSpec.BooleanValue replaceInfestedStone;

        public final ForgeConfigSpec.BooleanValue spawnVanillaStone;
        public final ForgeConfigSpec.BooleanValue harmoniousStrata;
        public final ForgeConfigSpec.ConfigValue<Integer> biomeSize;
        public final ForgeConfigSpec.ConfigValue<Integer> generationHeight;

        WorldGen(ForgeConfigSpec.Builder builder) {
            builder.push("WorldGen");

            replaceStone = builder.comment("Do you want UBC to replace vanilla stone ?").define("replaceStone", true);
            replaceCobble = builder.comment("Do you want UBC to replace vanilla cobblestone ?").define("replaceCobble", true);
            replaceGravel = builder.comment("Do you want UBC to replace vanilla gravel ?").define("replaceGravel", true);
            replaceSand = builder.comment("Do you want UBC to replace vanilla sand ?").define("replaceSand", true);
            replaceInfestedStone = builder.comment("Do you want UBC to replace vanilla infested stone ?").define("replaceInfestedStone", true);
            spawnVanillaStone = builder.comment("Enable if you want some biomes to contain vanilla stone.").define("spawnVanillaStone", false);
            harmoniousStrata = builder.comment("Smooth biome transitions.").define("harmoniousStrata", false);
            biomeSize = builder.comment("Sets the biome size. Exponential !").define("biomeSize", 4);
            generationHeight = builder.comment("How hight UBC's stones should stop generation at ?").define("generationHeight", 256);

            builder.pop();
        }
    }

    public static class Items {
        public final ForgeConfigSpec.ConfigValue<Integer> ligniteSmeltTime;

        Items(ForgeConfigSpec.Builder builder) {
            builder.push("Items");

            ligniteSmeltTime = builder.comment("Smelt time for the lignite item. In ticks.").define("ligniteSmeltTime", 200);

            builder.pop();
        }
    }

    public static class Recipes {
        public final ForgeConfigSpec.BooleanValue stoneToVanillaRecipe;
        public final ForgeConfigSpec.BooleanValue cobbleToVanillaRecipe;
        public final ForgeConfigSpec.BooleanValue gravelToVanillaRecipe;
        public final ForgeConfigSpec.BooleanValue sandToVanillaRecipe;

        Recipes(ForgeConfigSpec.Builder builder) {
            builder.push("Recipes");

            stoneToVanillaRecipe = builder.comment("Should a recipe to vanilla stone be available ?").define("stoneToVanillaRecipe", true);
            cobbleToVanillaRecipe = builder.comment("Should a recipe to vanilla cobblestone be available ?").define("cobbleToVanillaRecipe", true);
            gravelToVanillaRecipe = builder.comment("Should a recipe to vanilla gravel be available ?").define("gravelToVanillaRecipe", true);
            sandToVanillaRecipe = builder.comment("Should a recipe to vanilla sand be available ?").define("sandToVanillaRecipe", true);

            builder.pop();
        }
    }

    public static class Advanced {
        public final ForgeConfigSpec.BooleanValue differentSeedPerWorld;
        public final ForgeConfigSpec.BooleanValue sedimentaryCobble;

        Advanced(ForgeConfigSpec.Builder builder) {
            builder.push("Advanced");

            differentSeedPerWorld = builder.comment("Should UB's seed be different in each dimension ?").define("differentSeedPerWorld", false);
            sedimentaryCobble = builder.comment("Should UB drop cobblestone variants for sedimentary stones ?").define("sedimentaryCobble", false);

            builder.pop();
        }
    }
}