package aplicacion.evento;

import android.app.Activity;

import utilidades.conexion.ConexionHTTP;
import utilidades.conexion.ReceptorConexionHTTP;

public class ReceptorFondo  extends ReceptorConexionHTTP {
    public ReceptorFondo(Activity actividad) {
        super(actividad);
    }

    @Override
    public void procesar(String dato) {
        // cambiar fondo
    }

    @Override
    public void estado(ConexionHTTP.Estado estado) {

    }
}
