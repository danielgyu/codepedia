from django.db import models


class Restaurants(models.Model):
    id = models.BigAutoField(primary_key=True)
    name = models.CharField(max_length=128)


class Dishes(models.Model):
    id = models.BigAutoField(primary_key=True)
    name = models.CharField(max_length=128)
    price = models.PositiveIntegerField()

    restaurant_id = models.ForeignKey(
        Restaurants,
        on_delete=models.CASCADE,
    )
