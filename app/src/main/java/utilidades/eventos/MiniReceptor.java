package utilidades.eventos;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;

public abstract class MiniReceptor extends Handler {

    protected String clave = "EVENTO";
    protected TipoDato tipoDato = TipoDato.CADENA;



    // recibe los mensajes por parte de los eventos y obtiene el "dato" (bundle)
    @Override
    public void handleMessage(Message mensaje) {
        // extrae datos del msj
        Bundle bundle = mensaje.getData();
        procesar (bundle);
        procesar ();

        // si no hay clave
        if (clave.isEmpty())
            return;

        switch (tipoDato) {
            case CADENA:
                procesar(bundle.getString(clave));
                break;

            case ENTERO:
                procesar(bundle.getInt(clave));
                break;

            case LISTA:
                procesar((ArrayList) bundle.getSerializable(clave));
                break;

            case PAQUETE:
                procesar(bundle.getBundle(clave));
                break;
        }

    }




    // metodos para procesar los datos recibidos (sobreescribir)
    public void procesar(Bundle dato) {  }
    public void procesar () { }


    // metodos de procesado rápido
    public void procesar (String valor) { }
    public void procesar (int valor) { }
    public void procesar (ArrayList valor) { }




    // gets - sets



    public String getClave () { return  clave; }
    public void setClave (String valor) { clave = valor; }




    public  enum TipoDato { ENTERO, CADENA, PAQUETE, LISTA, MULTIPLE }





}
