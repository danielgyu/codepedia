from django.contrib import admin
from django.http import HttpResponse
from django.urls import include, path


def healthcheck(request):
    return HttpResponse("healthy")


urlpatterns = [
    path("healthcheck", healthcheck),
    path("restaurants/", include("restaurants.urls")),
    path('admin/', admin.site.urls),
]
