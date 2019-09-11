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
            if variant != 'lignite':
                block_name = stype + "_stone_button_" + variant
                model_name = "undergroundbiomes:block/stone_button/" + variant
                final_file = data.replace("modelpath", model_name)
                print(block_name)
                text_file = open(folder + block_name + ".json", "w")
                text_file.write(final_file)
                text_file.close()