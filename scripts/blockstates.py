import ub_enums
import os


def generate_stone_button_blockstates():
    folder = "build/resources/main/assets/undergroundbiomes/blockstates/"

    data = 0
    with open('resources_templates/blockstates/button.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            block_name = stype + "_stone_button_" + variant
            model_name = "undergroundbiomes:block/stone_button/" + variant
            final_file = data.replace("modelpath", model_name)
            print(block_name)
            text_file = open(folder + block_name + ".json", "w")
            text_file.write(final_file)
            text_file.close()

def generate_brick_blockstates():
    folder = "build/resources/main/assets/undergroundbiomes/blockstates/"

    data = 0
    with open('resources_templates/blockstates/block.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            if variant != 'lignite':
                block_name = stype + "_brick_" + variant
                model_name = "undergroundbiomes:block/brick/" + variant
                final_file = data.replace("modelpath", model_name)
                print(block_name)
                text_file = open(folder + block_name + ".json", "w")
                text_file.write(final_file)
                text_file.close()

def generate_cobble_blockstates():
    folder = "build/resources/main/assets/undergroundbiomes/blockstates/"

    data = 0
    with open('resources_templates/blockstates/block.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            if variant != 'lignite':
                block_name = stype + "_cobble_" + variant
                model_name = "undergroundbiomes:block/cobble/" + variant
                final_file = data.replace("modelpath", model_name)
                print(block_name)
                text_file = open(folder + block_name + ".json", "w")
                text_file.write(final_file)
                text_file.close()

def generate_stone_blockstates():
    folder = "build/resources/main/assets/undergroundbiomes/blockstates/"

    data = 0
    with open('resources_templates/blockstates/block.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            block_name = stype + "_stone_" + variant
            model_name = "undergroundbiomes:block/stone/" + variant
            final_file = data.replace("modelpath", model_name)
            print(block_name)
            text_file = open(folder + block_name + ".json", "w")
            text_file.write(final_file)
            text_file.close()

def generate_infested_stone_blockstates():
    folder = "build/resources/main/assets/undergroundbiomes/blockstates/"

    data = 0
    with open('resources_templates/blockstates/block.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            block_name = stype + "_infested_stone_" + variant
            model_name = "undergroundbiomes:block/stone/" + variant
            final_file = data.replace("modelpath", model_name)
            print(block_name)
            text_file = open(folder + block_name + ".json", "w")
            text_file.write(final_file)
            text_file.close()

def generate_stone_stairs_blockstates():
    folder = "build/resources/main/assets/undergroundbiomes/blockstates/"

    data = 0
    with open('resources_templates/blockstates/stairs.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            block_name = stype + "_stone_stairs_" + variant
            model_name = "undergroundbiomes:block/stone_stairs/" + variant
            final_file = data.replace("modelpath", model_name)
            print(block_name)
            text_file = open(folder + block_name + ".json", "w")
            text_file.write(final_file)
            text_file.close()

def generate_cobble_stairs_blockstates():
    folder = "build/resources/main/assets/undergroundbiomes/blockstates/"

    data = 0
    with open('resources_templates/blockstates/stairs.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            if variant != 'lignite':
                block_name = stype + "_cobble_stairs_" + variant
                model_name = "undergroundbiomes:block/cobble_stairs/" + variant
                final_file = data.replace("modelpath", model_name)
                print(block_name)
                text_file = open(folder + block_name + ".json", "w")
                text_file.write(final_file)
                text_file.close()                

def generate_gravel_blockstates():
    folder = "build/resources/main/assets/undergroundbiomes/blockstates/"

    data = 0
    with open('resources_templates/blockstates/block.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            block_name = stype + "_gravel_" + variant
            model_name = "undergroundbiomes:block/gravel/" + variant
            final_file = data.replace("modelpath", model_name)
            print(block_name)
            text_file = open(folder + block_name + ".json", "w")
            text_file.write(final_file)
            text_file.close()

def generate_sand_blockstates():
    folder = "build/resources/main/assets/undergroundbiomes/blockstates/"

    data = 0
    with open('resources_templates/blockstates/block.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            block_name = stype + "_sand_" + variant
            model_name = "undergroundbiomes:block/sand/" + variant
            final_file = data.replace("modelpath", model_name)
            print(block_name)
            text_file = open(folder + block_name + ".json", "w")
            text_file.write(final_file)
            text_file.close()

def generate_cobble_wall_blockstates():
    folder = "build/resources/main/assets/undergroundbiomes/blockstates/"

    data = 0
    with open('resources_templates/blockstates/wall.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            if variant != 'lignite':
                block_name = stype + "_cobble_wall_" + variant
                model_name = "undergroundbiomes:block/cobble_wall/" + variant
                final_file = data.replace("modelpath", model_name)
                print(block_name)
                text_file = open(folder + block_name + ".json", "w")
                text_file.write(final_file)
                text_file.close() 