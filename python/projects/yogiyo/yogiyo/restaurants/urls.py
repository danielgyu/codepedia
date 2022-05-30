from django.urls import path

from . import views

urlpatterns = [
    path("", views.all_restaurants),
    path("<int:restaurant_id>/", views.get_restaurant),
]
