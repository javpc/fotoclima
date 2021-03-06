package utilidades.localizacion_gps;

import android.os.Bundle;

import utilidades.eventos.MiniReceptor;

public abstract class ReceptorCoordenadas extends MiniReceptor {
    @Override
    public void procesar (Bundle bundle) {

        Coordenada nuevaCoordenada = new Coordenada();

        nuevaCoordenada.setLatitud(bundle.getDouble("latitud"));
        nuevaCoordenada.setLongitud(bundle.getDouble("longitud"));
        nuevaCoordenada.setProveedor(bundle.getString("proveedor"));
        nuevaCoordenada.setVelocidad(bundle.getFloat("velocidad"));


        procesar_coordenada(nuevaCoordenada);

    }


    protected abstract void procesar_coordenada (Coordenada coordenada) ;



}
