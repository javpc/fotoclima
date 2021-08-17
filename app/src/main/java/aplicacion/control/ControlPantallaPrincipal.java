package aplicacion.control;

import android.app.Activity;

import aplicacion.adaptador.Conexion;
import aplicacion.adaptador.Preferencias;
import aplicacion.evento.ReceptorConexion;
import aplicacion.evento.ReceptorDifusion;
import aplicacion.vista.PantallaPrincipal;
import utilidades.control.Control;
import utilidades.localizacion_gps.Coordenada;
import utilidades.localizacion_gps.Localizador;
import utilidades.localizacion_gps.ReceptorCoordenadas;
import utilidades.menu.MenuLateral;

public class ControlPantallaPrincipal extends Control {

    private Preferencias preferencias;
    private PantallaPrincipal pantalla;
    private MenuLateral menu;





    private ReceptorDifusion difusion;
    private ReceptorConexion receptor;
    private Conexion conexion;

    public ControlPantallaPrincipal (Activity actividad, MenuLateral menu) {
        super(actividad);
        preferencias = new Preferencias(actividad);
        pantalla = new PantallaPrincipal(actividad, preferencias.get_api_unidad());
        this.menu = menu;




        if (preferencias.get_json().isEmpty())
            conectar();
        else
            pantalla.completar_datos(preferencias.get_json());





    }



    public void conectar () {




        difusion = new ReceptorDifusion(actividad);


        receptor = new ReceptorConexion(actividad);
        receptor.setPantalla(pantalla);

        conexion = new Conexion();
        conexion.agregarReceptor(receptor);
        conexion.agregarReceptor(difusion);

        StringBuilder url_builde= new StringBuilder();
        url_builde.append(preferencias.get_api_url());
        url_builde.append("?");
        url_builde.append("appid=");
        url_builde.append(preferencias.get_api_id());
        url_builde.append("&");
        url_builde.append("lang=");
        url_builde.append(preferencias.get_api_idioma());
        url_builde.append("&");
        url_builde.append("units=");
        url_builde.append(preferencias.get_api_unidad());
        url_builde.append("&");




        String ubicacion = preferencias.get_api_ciudad();
        if (ubicacion.length() > 0)
            ubicacion = "id=" + ubicacion;
        else
            if (preferencias.get_api_latitud ().length() > 0)
                ubicacion = "lat=" + preferencias.get_api_latitud () + "&lon=" + preferencias.get_api_longitud ();
            else
                return;




        url_builde.append(ubicacion);



        conexion.setUrl(url_builde.toString());



        conexion.ejecutarHilo();
    }


    public void actualizar() {

        activar_gps();

        if (preferencias.get_api_latitud().equals(" "))
            return;


        conectar();

        //pantalla.completar_datos();
    }






    Localizador localizador = null;
    public void activar_gps () {
        if (localizador == null)
            localizador = new Localizador(actividad);





        ReceptorCoordenadas receptor = new ReceptorCoordenadas() {
            @Override
            protected void procesar_coordenada(Coordenada coordenada) {
                localizador.desactivar();
                preferencias.set_coordenada (coordenada.getLatitud(), coordenada.getLongitud());
                conectar();
            }
        };


        localizador.agregarReceptor(receptor);
        localizador.activar();
    }


    public boolean no_hay_idioma () {
        return preferencias.no_hay_idioma();
    }

}

