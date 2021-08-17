package utilidades.datos;

import android.content.ContentValues;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import utilidades.basico.MensajeRegistro;

public  class JaviSON {

    private JSONObject json = new JSONObject();
    private boolean error = false;
    private String errorMensaje = "";

    public JaviSON(){ }

    public JaviSON(JSONObject objeto) {
        json = objeto;
        if (json == null)
            json = new JSONObject();

    }


    public JaviSON(String cadena) {

        crear(cadena);

    }



    // EMISIÓN


    public void agregar (String clave, String dato ) {
        try { json.put(clave, dato); }
        catch (Exception e) { error (e.getMessage()); }
    }

    public void agregar (String clave, int dato ) {
        try { json.put(clave, dato); }
        catch (Exception e) { error (e.getMessage()); }

    }

    public String cadena () {
        return json.toString();
    }














    // RECEPCIÓN

    public void crear (String cadena) {
        try { json = new JSONObject(cadena); }
        catch (Exception e) { error (e.getMessage()); json = new JSONObject(); }
    }








    // OBTENER

    public String obtener_cadena (String clave) {
        return obtener_cadena(clave, "");
    }

    public String obtener_cadena (String clave, String predeterminado) {

        String respuesta = predeterminado;
        try { respuesta = json.getString(clave); }
        catch (Exception e) { error(e.getMessage()); return respuesta; }
        return respuesta;
    }


    // Objeto json anidado.
    public JaviSON obtener_objeto (String clave) {
        JSONObject objeto = null;
        try { objeto = json.getJSONObject(clave); }
        catch (Exception e) { error (e.getMessage()); }
        return  new JaviSON(objeto);
    }

    // Arreglo

    public ArrayList<JaviSON> obtener_arreglo (String clave) {
        int total = 0;
        JSONArray arreglo = null;
        ArrayList<JaviSON> lista = new ArrayList<>();
        try {
            arreglo = json.getJSONArray(clave);
            for (int indice = 0; indice < arreglo.length(); indice++) {
                lista.add(new JaviSON(arreglo.getJSONObject(indice)));
            }
        }
        catch (Exception e) {
            error (e.getMessage());
        }
        return  lista;
    }


    public String obtener_cadena (String clave, int indice_arreglo) {
        int total = 0;
        String respuesta = "";
        JSONArray arreglo = null;
        try {
            arreglo = json.getJSONArray(clave);
            respuesta = arreglo.getString(indice_arreglo);
        }
        catch (Exception e) {
            error (e.getMessage());
        }
        return  respuesta;
    }




    public JaviSON obtener_objeto (String clave, int indice_arreglo) {
        int total = 0;
        JaviSON respuesta = null;
        JSONArray arreglo = null;
        try {
            arreglo = json.getJSONArray(clave);
            respuesta = new JaviSON( arreglo.getJSONObject (indice_arreglo));
        }
        catch (Exception e) {
            error (e.getMessage());
            respuesta = new JaviSON();
        }
        return  respuesta;
    }


    public int arregloTotal (String clave) {
        int total = 0;
        JSONArray arreglo = null;

        try {
            arreglo = json.getJSONArray(clave);
            total = arreglo.length();
        }
        catch (Exception e) {
            error (e.getMessage());
        }
        return  total;
    }



    public JaviSON indice (String clave, int indice) {


        int total = 0;
        JSONArray arreglo = null;
        try {
            arreglo = json.getJSONArray(clave);
            return  new JaviSON(arreglo.getJSONObject(indice));
        }

        catch (Exception e) {
            error (e.getMessage());
        }
        return  new JaviSON();
    }





    public ArrayList<JaviSON> crearDesdeLista (String cadena) {
        int total = 0;
        JSONArray arreglo ;

        ArrayList<JaviSON> lista = new ArrayList<>();
        try {
            arreglo = new JSONArray(cadena);
            for (int indice = 0; indice < arreglo.length(); indice++) {
                lista.add(new JaviSON(arreglo.getJSONObject(indice)));
            }
        }
        catch (Exception e) {
            error (e.getMessage());
        }
        return  lista;
    }





    public ArrayList<String> claves () {
        ArrayList<String> lista = new ArrayList<>();
        Iterator<String> i = json.keys();
        while (i.hasNext())
            lista.add(i.next());

        return lista;
    }










    public ContentValues contentValues () {
        ContentValues contentValues = new ContentValues();
        Iterator l = json.keys();
        while (l.hasNext()){
            String clave = l.next().toString();
            contentValues.put(clave, obtener_cadena(clave));
        }
        return contentValues;
    }







    private void error (String mensaje) {
        error = true;
        errorMensaje = mensaje;
        MensajeRegistro.msj(this, mensaje);
    }

    private void quitarError () {
        if (error == false)
            return;
        error = false;
        errorMensaje = "";
    }




    public boolean error () { return  error ;}
    public String mensajeError  () { return  errorMensaje ;}




/*
    private void prueba () {
        String valor;
        JaviSON dato = new JaviSON();
        dato.agregar("saludo", "hola");
        valor = dato.cadena();

        String JSON_STRING = "{\"employee\":{\"name\":\"Abhishek Saini\",\"salary\":65000}}";

        dato.crear(JSON_STRING);

        valor = dato.objeto("employee").obtener("name");


        PantallaPrincipal pantalla = new PantallaPrincipal(this);
        pantalla.mostrarMensajeInferior(valor);
        MensajeRegistro.msj(valor);
    }



 */

}
