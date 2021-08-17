package aplicacion.adaptador;

import android.app.Activity;

import pc.javier.aplicacion.Aplicacion;

public class Preferencias extends utilidades.control.Preferencias {
    public Preferencias (Activity actividad) {
        super(actividad);
    }



    public String get_json () { return obtenerString("json"); }

    public String get_api_url () { return obtenerString("url", Aplicacion.api_url); }
    public String get_api_idioma () { return obtenerString("idioma", Aplicacion.api_idioma); }
    public String get_api_unidad () { return obtenerString("unidad",  Aplicacion.api_unidad); }
    public String get_api_id () { return obtenerString("api_id", Aplicacion.api_id);}

    public void set_api_url (String valor) {  guardar ("url", valor ); }
    public void set_api_idioma (String valor) {  guardar ("idioma", valor ); }
    public void set_api_unidad (String valor) {  guardar ("unidad",  valor ); }
    public void set_api_id (String valor) {  guardar ("api_id", valor ); }


    public String get_api_ciudad () { return obtenerString("api_ciudad", ""); }

    public String get_api_latitud () { return obtenerString("api_latitud", ""); }
    public String get_api_longitud () { return obtenerString("api_longitud", ""); }


    public long get_actualizacion () { return obtenerLong("actualizacion"); }

    public void set_json (String cadena) {
        guardar("json", cadena);
    }

    public void set_actualizacion (long fecha) {
        guardarLong("actualizacion", fecha);
    }

    public void set_coordenada (double latitud, double longitud) {
        guardar("api_latitud", String.valueOf(latitud));
        guardar("api_longitud", String.valueOf(longitud));
    }


    public boolean no_hay_idioma () { return obtenerString("idioma", "").isEmpty(); }

  /*


{"coord":{
"lon":-66.3356,
"lat":-33.295},
"weather":[{
"id":804,
"main":"Clouds",
"description":"nubes",
"icon":"04d"}],
"base":"stations",
"main":{
"temp":16.83,
"feels_like":16.74,
"temp_min":16.83,
"temp_max":16.83,
"pressure":1013,
"humidity":83,
"sea_level":1013,
"grnd_level":930},
"visibility":10000,
"wind":{
"speed":2.22,
"deg":255,
"gust":2.05},
"clouds":{
"all":98},
"dt":1619189062,
"sys":{
"country":"AR",
"sunrise":1619175195,
"sunset":1619214816},
"timezone":-10800,
"id":3837056,
"name":"San Luis",
"cod":200}


   */

  /*

    public void set_coord (int valor) { guardarLong (valor); }
    public void set_lon (int valor) { guardarLong (valor); }
    public void set_lat (int valor) { guardarLong (valor); }
    public void set_weather (int valor) { guardarLong (valor); }
    public void set_id (int valor) { guardarLong (valor); }
    public void set_main (int valor) { guardarLong (valor); }
    public void set_description (int valor) { guardarLong (valor); }
    public void set_icon (int valor) { guardarLong (valor); }
    public void set_base (int valor) { guardarLong (valor); }
    public void set_main (int valor) { guardarLong (valor); }
    public void set_temp (int valor) { guardarLong (valor); }
    public void set_feels_like (int valor) { guardarLong (valor); }
    public void set_temp_min (int valor) { guardarLong (valor); }
    public void set_temp_max (int valor) { guardarLong (valor); }
    public void set_pressure (int valor) { guardarLong (valor); }
    public void set_humidity (int valor) { guardarLong (valor); }
    public void set_sea_level (int valor) { guardarLong (valor); }
    public void set_grnd_level (int valor) { guardarLong (valor); }
    public void set_visibility (int valor) { guardarLong (valor); }
    public void set_wind (int valor) { guardarLong (valor); }
    public void set_speed (int valor) { guardarLong (valor); }
    public void set_deg (int valor) { guardarLong (valor); }
    public void set_gust (int valor) { guardarLong (valor); }
    public void set_clouds (int valor) { guardarLong (valor); }
    public void set_all (int valor) { guardarLong (valor); }
    public void set_dt (int valor) { guardarLong (valor); }
    public void set_sys (int valor) { guardarLong (valor); }
    public void set_country (int valor) { guardarLong (valor); }
    public void set_sunrise (int valor) { guardarLong (valor); }
    public void set_sunset (int valor) { guardarLong (valor); }
    public void set_timezone (int valor) { guardarLong (valor); }
    public void set_id (int valor) { guardarLong (valor); }
    public void set_name (int valor) { guardarLong (valor); }
    public void set_cod (int valor) { guardarLong (valor); }



    public long get_coord () { return obtenerLong ("coord"); }
    public long get_lon () { return obtenerLong ("lon"); }
    public long get_lat () { return obtenerLong ("lat"); }
    public long get_weather () { return obtenerLong ("weather"); }
    public long get_id () { return obtenerLong ("id"); }
    public long get_main () { return obtenerLong ("main"); }
    public long get_description () { return obtenerLong ("description"); }
    public long get_icon () { return obtenerLong ("icon"); }
    public long get_base () { return obtenerLong ("base"); }
    public long get_main () { return obtenerLong ("main"); }
    public long get_temp () { return obtenerLong ("temp"); }
    public long get_feels_like () { return obtenerLong ("feels_like"); }
    public long get_temp_min () { return obtenerLong ("temp_min"); }
    public long get_temp_max () { return obtenerLong ("temp_max"); }
    public long get_pressure () { return obtenerLong ("pressure"); }
    public long get_humidity () { return obtenerLong ("humidity"); }
    public long get_sea_level () { return obtenerLong ("sea_level"); }
    public long get_grnd_level () { return obtenerLong ("grnd_level"); }
    public long get_visibility () { return obtenerLong ("visibility"); }
    public long get_wind () { return obtenerLong ("wind"); }
    public long get_speed () { return obtenerLong ("speed"); }
    public long get_deg () { return obtenerLong ("deg"); }
    public long get_gust () { return obtenerLong ("gust"); }
    public long get_clouds () { return obtenerLong ("clouds"); }
    public long get_all () { return obtenerLong ("all"); }
    public long get_dt () { return obtenerLong ("dt"); }
    public long get_sys () { return obtenerLong ("sys"); }
    public long get_country () { return obtenerLong ("country"); }
    public long get_sunrise () { return obtenerLong ("sunrise"); }
    public long get_sunset () { return obtenerLong ("sunset"); }
    public long get_timezone () { return obtenerLong ("timezone"); }
    public long get_id () { return obtenerLong ("id"); }
    public long get_name () { return obtenerLong ("name"); }
    public long get_cod () { return obtenerLong ("cod"); }


   */
}
