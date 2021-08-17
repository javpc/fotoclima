package utilidades.eventos;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;

public class MiniEvento {

    private Bundle datos = new Bundle();
    private MiniReceptor receptorPrivado;
    private ArrayList<MiniReceptor> receptoresPrivados = new ArrayList<MiniReceptor>();

    // Clave para que el receptor obtenga el "valor" (bundle.get (clave))
    public String clave = "EVENTO";

    // Clave para que el receptor obtenga el "valor" (getSTRING, getINT, getXXX)
    public MiniReceptor.TipoDato tipo_dato = MiniReceptor.TipoDato.CADENA;



    // Agrega datos al paquete - Clave personalizada

    public void agregarDato (String clave, String valor) {
        datos.putString(clave, valor);
    }

    public void agregarDato (String clave, double valor) {
        datos.putDouble(clave, valor);
    }

    public void agregarDato (String clave, float valor) {
        datos.putFloat(clave, valor);
    }

    public void agregarDato (String clave, int valor) {
        datos.putInt (clave, valor);
    }

    public void agregarDato (String clave, ArrayList valor) {
        datos.putSerializable(clave, valor);
    }



    // Agrega datos al paquete - Clave genérica

    public void agregarDato (String valor) {
        datos.putString(clave, valor);
    }

    public void agregarDato (double valor) {
        datos.putDouble(clave, valor);
    }

    public void agregarDato (float valor) {
        datos.putFloat(clave, valor);
    }

    public void agregarDato (int valor) {
        datos.putInt (clave, valor);
    }

    public void agregarDato (ArrayList valor) {
        datos.putSerializable(clave, valor);
    }


    // Paquete

    public Bundle getBundle () {
        return datos;
    }

    public void setBundle (Bundle valor) {
        datos = valor;
    }

    public void borrar () { datos.clear(); }

    public void nuevo () { datos = new Bundle(); }







    // Emisión de eventos

    private void emitir(Handler receptor) {
        Message mensaje = new Message();
        mensaje.setData(datos);
        receptor.sendMessage(mensaje);
    }




    // Lanzamientos

    public void lanzar () {
        // Lanza el evento a su receptor
        if (receptorPrivado != null)
            emitir(receptorPrivado);

        // Lanza el evento a una lista de receptores
        for (MiniReceptor receptor : receptoresPrivados)
            emitir(receptor);

        nuevo();
    }






    // Lanzamientos rápidos

    public void lanzar (String clave, String valor) {
        datos.putString(clave, valor);
        lanzar();
    }

    public void lanzar (String clave, double valor) {
        datos.putDouble(clave, valor);
        lanzar();
    }

    public void lanzar (String clave, float valor) {
        datos.putFloat(clave, valor);
        lanzar();
    }

    public void lanzar (String clave, int valor) {
        datos.putInt (clave, valor);
        lanzar();
    }

    public void lanzar (String clave, ArrayList valor) {
        datos.putSerializable(clave, valor);
        lanzar();
    }



    // Lanzamientos  más rápidos

    public void lanzar (String valor) {
        datos.putString(clave, valor);
        lanzar();
    }

    public void lanzar (double valor) {
        datos.putDouble(clave, valor);
        lanzar();
    }

    public void lanzar (float valor) {
        datos.putFloat(clave, valor);
        lanzar();
    }

    public void lanzar (int valor) {
        datos.putInt (clave, valor);
        lanzar();
    }

    public void lanzar (ArrayList valor) {
        datos.putSerializable(clave, valor);
        lanzar();
    }






    // Receptor

    public void receptor (MiniReceptor miniReceptor) {
        this.receptorPrivado = miniReceptor;
        this.receptorPrivado.tipoDato = this.tipo_dato;
    }

    public MiniReceptor receptor () {
        return receptorPrivado;
    }


    // Receptores

    public void agregar_receptor (MiniReceptor miniReceptor) {
        if (receptoresPrivados.contains(miniReceptor))
            return;
        miniReceptor.tipoDato = this.tipo_dato;
        receptoresPrivados.add(miniReceptor);
    }

    public void quitar_receptor (MiniReceptor miniReceptor) {
        if (receptoresPrivados.contains(miniReceptor))
            receptoresPrivados.remove(miniReceptor);
    }

    public void quitar_receptores () {
        receptoresPrivados.clear();
    }

    public ArrayList<MiniReceptor> receptores () {
        return receptoresPrivados;
    }

}
