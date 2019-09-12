import loot_tables
import recipes
import blockstates

# Loot tables
loot_tables.generate_gravel_loot()
loot_tables.generate_sand_loot()
loot_tables.generate_cobble_loot()
loot_tables.generate_brick_loot()
loot_tables.generate_cobble_stairs_loot()
loot_tables.generate_stone_stairs_loot()
loot_tables.generate_stone_button_loot()
loot_tables.generate_cobble_button_loot()

# Recipes
recipes.generate_smelting_cobble_recipes()
recipes.generate_stone_brick_recipes()
recipes.generate_cobble_stair_recipes()
recipes.generate_stone_stair_recipes()
recipes.generate_stone_button_recipes()

# Blockstates
blockstates.generate_stone_button_blockstates()
blockstates.generate_brick_blockstates()
blockstates.generate_cobble_blockstates()
blockstates.generate_stone_blockstates()
blockstates.generate_stone_stairs_blockstates()
blockstates.generate_cobble_stairs_blockstates()
blockstates.generate_gravel_blockstates()
blockstates.generate_sand_blockstates()
blockstates.generate_infested_stone_blockstates()