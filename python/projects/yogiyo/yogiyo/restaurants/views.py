from django.http import JsonResponse
from django.core.exceptions import ObjectDoesNotExist

from restaurants.models import Restaurants, Dishes


def all_restaurants(request):
    restaurants = Restaurants.objects.all()
    return JsonResponse({r.id: r.name for r in restaurants})


def get_restaurant(request, restaurant_id):
    try:
        restaurant = Restaurants.objects.get(id=restaurant_id)
        return JsonResponse({restaurant.id: restaurant.name})
    except ObjectDoesNotExist:
        return JsonResponse({"error": "None"})
