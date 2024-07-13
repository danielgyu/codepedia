import asyncio
import random
from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()

ids =[0]


class Item(BaseModel):
    eventType: str

@app.post("/adyo")
async def root(item: Item):
    global ids
    ids.append(ids[-1]+1)

    id_to_return = ids[-1]+1
    sleep_time = random.randint(2, 10)

    print("sleeping for", sleep_time)
    print("returning", id_to_return)

    await asyncio.sleep(sleep_time)
    return {"id": id_to_return}

