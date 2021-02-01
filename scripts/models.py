import ub_enums
import os


def generate_cobble_wall_models_inventory():
    folder = "build/resources/main/assets/undergroundbiomes/models/block/cobble_wall/"

    data = 0
    with open('resources_templates/models/wall_inventory.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            if variant != 'lignite':
                block_name = variant + "_inventory"
                model_name = "undergroundbiomes:block/cobble/" + variant
                final_file = data.replace("texturepath", model_name)
                print(block_name)
                text_file = open(folder + block_name + ".json", "w")
                text_file.write(final_file)
                text_file.close() 

def generate_cobble_wall_models_post():
    folder = "build/resources/main/assets/undergroundbiomes/models/block/cobble_wall/"

    data = 0
    with open('resources_templates/models/wall_post.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            if variant != 'lignite':
                block_name = variant + "_post"
                model_name = "undergroundbiomes:block/cobble/" + variant
                final_file = data.replace("texturepath", model_name)
                print(block_name)
                text_file = open(folder + block_name + ".json", "w")
                text_file.write(final_file)
                text_file.close() 

def generate_cobble_wall_models_side():
    folder = "build/resources/main/assets/undergroundbiomes/models/block/cobble_wall/"

    data = 0
    with open('resources_templates/models/wall_side.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            if variant != 'lignite':
                block_name = variant + "_side"
                model_name = "undergroundbiomes:block/cobble/" + variant
                final_file = data.replace("texturepath", model_name)
                print(block_name)
                text_file = open(folder + block_name + ".json", "w")
                text_file.write(final_file)
                text_file.close()

def generate_cobble_wall_models_side_tall():
    folder = "build/resources/main/assets/undergroundbiomes/models/block/cobble_wall/"

    data = 0
    with open('resources_templates/models/wall_side_tall.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            if variant != 'lignite':
                block_name = variant + "_side_tall"
                model_name = "undergroundbiomes:block/cobble/" + variant
                final_file = data.replace("texturepath", model_name)
                print(block_name)
                text_file = open(folder + block_name + ".json", "w")
                text_file.write(final_file)
                text_file.close()

def generate_cobble_wall_models_item():
    folder = "build/resources/main/assets/undergroundbiomes/models/item/"

    data = 0
    with open('resources_templates/models/wall_item.json', 'r') as file:
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