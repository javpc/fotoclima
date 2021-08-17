package aplicacion.evento;

import android.app.Activity;

import java.util.Date;

import aplicacion.adaptador.Preferencias;
import aplicacion.vista.PantallaPrincipal;
import utilidades.conexion.ConexionHTTP;
import utilidades.conexion.ReceptorConexionHTTP;

public class ReceptorConexion extends ReceptorConexionHTTP {

    private Preferencias preferencias;
    private PantallaPrincipal pantalla;
    public ReceptorConexion(Activity activity) {
        super(activity);
        this.preferencias = new Preferencias(actividad);
    }

    public void setPantalla(PantallaPrincipal pantalla) {
        this.pantalla = pantalla;
    }

    @Override
    public void procesar(String dato) {


        if (dato ==null)
            return;
        preferencias.set_json (dato);
        Date fecha = new Date();
        preferencias.set_actualizacion(fecha.getTime());
        if (pantalla != null)
            pantalla.completar_datos (dato);
    }

    @Override
    public void estado(ConexionHTTP.Estado estado) {

        pantalla.setEstado(estado.name());

        if (estado == ConexionHTTP.Estado.Error || estado == ConexionHTTP.Estado.Finalizado)
            pantalla.ocultar_boton_flotante (false);


        if (estado == ConexionHTTP.Estado.Conectando)
            pantalla.ocultar_boton_flotante (true);
    }
}
