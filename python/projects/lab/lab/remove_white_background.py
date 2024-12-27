from PIL import Image
  
def convert_image(file_path: str, output_file_path: str):
    img = Image.open(file_path)
    img = img.convert("RGBA")
  
    datas = img.getdata()
  
    new_data = []
  
    for item in datas:
        if item[0] == 255 and item[1] == 255 and item[2] == 255:
            new_data.append((255, 255, 255, 0))
        else:
            new_data.append(item)
  
    img.putdata(new_data)
    img.save(output_file_path, "PNG")
