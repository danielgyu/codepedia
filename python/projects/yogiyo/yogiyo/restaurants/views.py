from django.http import HttpResponse

from restaurants.models import Restaurants, Dishes


def healthcheck(request):
    return HttpResponse("healthy")


def
