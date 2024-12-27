from PIL import Image

def crop_original():
    img = Image.open("./images/dlodys.png")

    row_height = img.height // 26

    cropped = img.crop((0, 0, img.width, row_height))

    cropped.save("./lab/dlodys_cropped.png")


def crop_cropped():
    img = Image.open("./lab/dlodys_cropped.png")

    middle_height = img.height // 2

    cropped = img.crop((1, middle_height, img.width, img.height))

    cropped.save("./lab/dlodys_final.png")


def crop_dlody():
    img = Image.open("./images/dlodys.png")

    row_height = img.height // 2

    cropped = img.crop((0, 0, img.width, row_height))

    cropped.save("./images/dlodys_final.png")


def crop_width():
    img = Image.open("./images/dlodys.png")

    row_width = img.width // 2

    cropped = img.crop((0, 0, row_width, img.height))

    cropped.save("./images/dlodys_cropped.png")


def crop():
    #crop_original()
    #crop_cropped()
    #crop_dlody()
    crop_width()
