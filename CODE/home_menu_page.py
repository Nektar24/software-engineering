from kivy.app import App
from kivy.lang import Builder
from kivy.properties import StringProperty
from kivy.clock import mainthread
from kivy.utils import platform
from kivy.garden.mapview import MapView # type: ignore

import location

kv = '''
BoxLayout:
    orientation: 'vertical'

    MapView:
        id: mapview
        lat: app.location_manager.lat
        lon: app.location_manager.lon
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
                app.start() if self.state == 'down' else app.stop()
'''


class MainPage(App):

    gps_location = StringProperty()
    gps_status = StringProperty('Click Start to get GPS location updates')

    def __init__(self, **kwargs):
        super(MainPage, self).__init__(**kwargs)
        self.location_manager = location.location()

    def build(self):
        return Builder.load_string(kv)

    def start(self):
        self.location_manager.start_gps(1000, 0)
        self.root.ids.mapview.center_on(self.location_manager.lat,self.location_manager.lon)
    
    def stop(self):
        self.location_manager.stop_gps()

    @mainthread
    def update_location(self, lat, lon):
        self.root.ids.mapview.center_on(lat, lon)
        self.gps_location = f'lat={lat}\nlon={lon}'

    @mainthread
    def update_status(self, status):
        self.gps_status = status

    def on_pause(self):
        self.location_manager.stop_gps()
        return True

    def on_resume(self):
        self.location_manager.start_gps(1000, 0)


if __name__ == '__main__':
    MainPage().run()
