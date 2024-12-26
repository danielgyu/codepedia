from PIL import Image


def crop_original():
    img = Image.open("./lab/robots.png")

    row_height = img.height // 26

    cropped = img.crop((0, 0, img.width, row_height))

    cropped.save("./lab/cropped.png")


def crop_cropped():
    img = Image.open("./lab/cropped.png")

    middle_height = img.height // 2

    cropped = img.crop((1, middle_height, img.width, img.height))

    cropped.save("./lab/cropped.png")


def main():
    crop_original()
    crop_cropped()


if __name__ == "__main__":
    main()
