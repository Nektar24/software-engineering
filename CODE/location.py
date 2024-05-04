from kivy.utils import platform

if platform == "android":
    from plyer import gps

if platform == "win":
    from geopy.geocoders import Nominatim


class location:
    def __init__(self):
        self.lat = 0
        self.lon = 0
        self.gps = None
        self.geolocator = None

        if platform == "android":
            self.gps = gps
            self.request_android_permissions()

        if platform == "win":
            self.geolocator = Nominatim(user_agent="up1072594@upnet.gr")
            self.lat, self.log = self.get_coordinates()

    def start_gps(self, minTime, minDistance):
        if platform == "android":
            self.gps.start(minTime, minDistance)

    def stop_gps(self):
        if platform == "android":
            self.gps.stop()

    def get_coordinates(self):
        if platform == "win":
            location = self.geolocator.geocode("Patra, Greece")
            self.lat = location.latitude
            self.lon = location.longitude
        return self.lat, self.lon
    
    def request_android_permissions(self):
        from android.permissions import request_permissions, Permission # type: ignore

        request_permissions([Permission.ACCESS_COARSE_LOCATION, Permission.ACCESS_FINE_LOCATION])
