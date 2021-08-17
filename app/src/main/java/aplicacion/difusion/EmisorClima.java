package aplicacion.difusion;

import android.content.Context;

import utilidades.datos.JaviSON;
import utilidades.difusion.EmisorDifusion;

public class EmisorClima  {


    EmisorDifusion emisor ;
    public EmisorClima(Context contexto) {
        emisor = new EmisorDifusion(contexto, "Fotoclima");

    }

    public  void emitir (String cadena_json) {
        completar_datos(cadena_json);
        emisor.emitir ("clima");
    }

    public void completar_datos (String cadena_json) {
        JaviSON json = new JaviSON(cadena_json);

        emisor.extra ("descripcion",  json.obtener_objeto("weather",0).obtener_cadena("description") );
        emisor.extra ("icono",  json.obtener_objeto("weather",0).obtener_cadena("icon") );
        emisor.extra ("temperatura",  json.obtener_objeto("main").obtener_cadena("temp") );
        emisor.extra ("viento",  json.obtener_objeto("wind").obtener_cadena("speed") );
        emisor.extra ("viento_rafaga",  json.obtener_objeto("wind").obtener_cadena("gust") );
        emisor.extra ("viento_direccion",  json.obtener_objeto("wind").obtener_cadena("deg") );
        emisor.extra ("nubosidad",  json.obtener_objeto("clouds").obtener_cadena("all") );

        emisor.extra("json", cadena_json);



    }




}
