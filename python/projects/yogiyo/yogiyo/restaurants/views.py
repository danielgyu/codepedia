from django.http import HttpResponse, JsonResponse

from restaurants.models import Restaurants, Dishes


def healthcheck(request):
    return HttpResponse("healthy")


def all_restaurants():
    restaurants = Restaurants.objects.all()
    return {"name": r.name for r in restaurants}
