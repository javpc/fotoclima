package aplicacion.vista;

import android.app.Activity;

import aplicacion.adaptador.ComponenteIndicador;
import aplicacion.adaptador.Pantalla;
import pc.javier.menulateralcompatible.R;
import utilidades.datos.JaviSON;

public class PantallaPrincipal extends Pantalla {

    private ComponenteIndicador componente_descripcion ;
    private ComponenteIndicador componente_temperatura ;
    private ComponenteIndicador componente_viento ;
    private ComponenteIndicador componente_nubosidad ;
    private ComponenteIndicador componente_humedad ;
    private ComponenteIndicador componente_ciudad ;


    public PantallaPrincipal (Activity actividad, String unidad) {
        super(actividad);

        componente_descripcion = new ComponenteIndicador(actividad , R.id.clima_descripcion);
        componente_temperatura= new ComponenteIndicador(actividad , R.id.clima_temperatura);
        componente_humedad= new ComponenteIndicador(actividad , R.id.clima_humedad);
        componente_viento= new ComponenteIndicador(actividad , R.id.clima_viento_velocidad);
        componente_nubosidad= new ComponenteIndicador(actividad , R.id.clima_nubosidad);
        componente_ciudad = new ComponenteIndicador(actividad , R.id.clima_ciudad);

        ajustar_medidas ();
        ajustar_leyendas ();
        ajustar_unidades (unidad);
    }




    private void ajustar_medidas () {
        componente_temperatura.getVistaValor().setTextSize(100);
        componente_temperatura.getVistaUnidad().setTextSize(30);

    }

    private void ajustar_leyendas () {
        componente_humedad.setLeyendaInferior("Humedad");
        componente_viento.setLeyendaInferior("Viento");
        componente_nubosidad.setLeyendaInferior("Nubosidad");

    }


    private void ajustar_unidades (String unidad) {
        switch (unidad) {
            case "":
            case "metric":
                componente_temperatura.setUnidad("C");
                componente_viento.setUnidad("km/h");
                break;

            case "imperial":
                componente_temperatura.setUnidad("F");
                break;

            case "standard":
                componente_temperatura.setUnidad("K");
                break;
        }


        componente_nubosidad.setUnidad("%");
        componente_humedad.setUnidad("%");


    }



    public void completar_datos (String cadena_json) {
        JaviSON json = new JaviSON(cadena_json);
        String descripcion = json.obtener_objeto("weather",0).obtener_cadena("description");
        String icono= json.obtener_objeto("weather",0).obtener_cadena("icon");

        String temperatura = json.obtener_objeto("main").obtener_cadena("temp");
        String humedad = json.obtener_objeto("main").obtener_cadena("humidity");
        String presion = json.obtener_objeto("main").obtener_cadena("pressure");
        String visibilidad = json.obtener_objeto("main").obtener_cadena("visibility");
        String nivel_suelo = json.obtener_objeto("main").obtener_cadena("grnd_level");
        String nivel_mar = json.obtener_objeto("main").obtener_cadena("sea_level");
        String sensacion_termica = json.obtener_objeto("main").obtener_cadena("feels_like");
        String probabilidad_presipitaciones = json.obtener_objeto("main").obtener_cadena("pop");


        String viento = json.obtener_objeto("wind").obtener_cadena("speed");
        String viento_rafaga = json.obtener_objeto("wind").obtener_cadena("gust");
        String viento_direccion = json.obtener_objeto("wind").obtener_cadena("deg");

        String ciudad = json.obtener_cadena("name");
        String actualizacion = json.obtener_cadena("dt");
        String nubosidad = json.obtener_objeto("clouds").obtener_cadena("all");

        componente_descripcion.setValor (descripcion);
        componente_nubosidad.setValor(nubosidad);
        componente_viento.setValor(viento);
        componente_humedad.setValor(humedad);
        componente_temperatura.setValor(temperatura);
        componente_ciudad.setValor(ciudad);


        setImagen (icono);
        setFondo (icono);

        setEstado("");
    }



    public void ocultar_boton_flotante (boolean oculto) {
        setOculto (R.id.fab, oculto);
    }




}
