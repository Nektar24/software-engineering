#Nektar

# Βιβλιοθήκες , δεν μας νοιάζουν για τώρα

from kivy.app import App
from kivy.lang import Builder
from kivy.properties import StringProperty
from kivy.clock import mainthread
from kivy.utils import platform
from kivy.garden.mapview import MapView, MapMarker # type: ignore

gps = None

if platform == "android":
    from plyer import gps

if platform == "win":
    from geopy.geocoders import Nominatim


# Αυτο εδώ έχει σημασία , εδώ γράφεις τι εμφανίζεται στην εφαρμογή

kv = '''
BoxLayout:
    orientation: 'vertical'

    MapView:
        id: mapview
        lat: app.lat
        lon: app.lon
        zoom: 15
        size_hint: 1, 7

    Label:
        text: app.gps_location

    Label:
        text: app.gps_status

    BoxLayout:
        size_hint_y: None
        height: '48dp'
        padding: '4dp'

        ToggleButton:
            text: 'Start' if self.state == 'normal' else 'Stop'
            on_state:
                app.start(1000, 0) if self.state == 'down' else app.stop()
'''

# παράδειγμα από
# https://github.com/kivy/plyer/blob/master/examples/gps/main.py

class GpsTest(App):

    gps_location = StringProperty()
    lat = 0
    lon = 0
    gps_status = StringProperty('Click Start to get GPS location updates')

    def request_android_permissions(self):
        from android.permissions import request_permissions, Permission # type: ignore

        request_permissions([Permission.ACCESS_COARSE_LOCATION, Permission.ACCESS_FINE_LOCATION])

    def build(self):
        if platform == "android":
            try:
                gps.configure(on_location=self.on_location,
                            on_status=self.on_status)
            except NotImplementedError:
                import traceback
                traceback.print_exc()
                self.gps_status = 'GPS is not implemented for your platform'

        if platform == "android":
            print("gps.py: Android detected. Requesting permissions")
            self.request_android_permissions()

        elif platform == "win":
            self.gps_status = 'Για λόγους παρουσίασης θετουμε τις συντεταγμένες στο κέντρο της Πάτρας'
            self.geolocator = Nominatim(user_agent="up1072594@upnet.gr")
            location = self.geolocator.geocode("Patra, Greece")
            self.gps_location = 'lat=0\nlon=0'
            self.lat = location.latitude
            self.lon = location.longitude

        return Builder.load_string(kv)

    def start(self, minTime, minDistance):
        if platform == "android":
            gps.start(minTime, minDistance)
        elif platform == "win":
            location = self.geolocator.geocode("Patra, Greece")
            self.gps_location = 'lat={}\nlon={}'.format(location.latitude, location.longitude)
            self.lat = location.latitude
            self.lon = location.longitude
        self.root.ids.mapview.center_on(self.lat, self.lon)

    def stop(self):
        if platform == "android":
            gps.stop()

    @mainthread
    def on_location(self, **kwargs):
        self.gps_location = '\n'.join([
            '{}={}'.format(k, v) for k, v in kwargs.items()])

    @mainthread
    def on_status(self, stype, status):
        self.gps_status = 'type={}\n{}'.format(stype, status)

    def on_pause(self):
        if platform == "android":
            gps.stop()
        return True

    def on_resume(self):
        if platform == "android":
            gps.start(1000, 0)
        pass


if __name__ == '__main__':
    GpsTest().run()