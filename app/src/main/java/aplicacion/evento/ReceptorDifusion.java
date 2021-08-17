package aplicacion.evento;

import android.app.Activity;
import android.content.Context;

import aplicacion.difusion.EmisorClima;
import utilidades.conexion.ConexionHTTP;
import utilidades.conexion.ReceptorConexionHTTP;
import utilidades.eventos.MiniReceptor;

public class ReceptorDifusion extends ReceptorConexionHTTP {
    private EmisorClima emisor;

    public ReceptorDifusion(Activity actividad) {
        super(actividad);
        emisor = new EmisorClima (actividad) ;
    }


    @Override
    public void procesar (String cadena) {
        emisor.emitir(cadena);
    }

    @Override
    public void estado(ConexionHTTP.Estado estado) {

    }

}
