package utilidades.imagen;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import utilidades.basico.MensajeRegistro;
import utilidades.eventos.MiniEvento;
import utilidades.eventos.MiniReceptor;

public class Imagen  {


    // código interto para recibir imágenes de la galeria.
    private final int AFIRMATIVO = 100;

    private ImageView vistaImagen;
    private Activity actividad;

    private Uri uri;
    private Bitmap bitmap;

    private File archivo;


    public Imagen (Activity actividad, ImageView vistaImagen) {
        this.actividad = actividad;
        this.vistaImagen = vistaImagen;
    }


    public Imagen (Activity actividad) {
        this.actividad = actividad;
    }


    public void vista (ImageView vistaImagen) {
        this.vistaImagen = vistaImagen;
    }

    public void vista (int id) {
        this.vistaImagen = (ImageView) actividad.findViewById(id);
    }

    public void asociarEventoClic () {
        asociarEventoClic(vistaImagen);
    }

    public void asociarEventoClic (View vista) {
        vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elegirImagen();
            }
        });
    }

    public void elegirImagen (){
        Intent galeria = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        // galeria.setType("image/*");
        actividad.startActivityForResult(galeria, AFIRMATIVO);
    }






    public void onActivityResult(int codigo, int resultado, Intent dato){

        if (resultado != Activity.RESULT_OK)
            return;

        if (codigo  != AFIRMATIVO)
            return;

            uri = dato.getData();

            archivo = new File (nombreCompleto());

            if (vistaImagen != null)
                vistaImagen.setImageURI(uri);

            try {
                bitmap = MediaStore.Images.Media.getBitmap (actividad.getContentResolver(), uri);
            } catch (IOException e) {
                e.printStackTrace();
            }

    }


    public File archivo () {
        return archivo;
    }


    public Uri uri () { return  uri; }
    public Bitmap bitmap () { return bitmap; }

    public void bitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        if (vistaImagen != null)
            vistaImagen.setImageBitmap(bitmap);
    }

    public void bitmap (String base64) {
        this.bitmap = decodificar(base64);
        vistaImagen.setImageBitmap(bitmap);
    }





    public byte[] bytes () {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        if (bitmap != null)
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }



    public String base64 () {
        byte[] bytes = bytes();
        Bitmap bm= BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (bm == null)
            return "";
        bm.compress(Bitmap.CompressFormat.PNG,100,baos);
        byte[] b = baos.toByteArray();
        return Base64.encodeToString(b, Base64.DEFAULT);
    }




    public Bitmap decodificar (String codigoB64) {
        MensajeRegistro.msj(this, "Decodificando + " + codigoB64);
        byte[] bytes = Base64.decode(codigoB64, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }





    public void url (URL direccion) {
        Conexion conexion = new Conexion(direccion);
        conexion.start();
    }

    public void url (String direccion) {
        try {
            URL url= new URL(direccion);
            url(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }



    private class Conexion extends Thread {
        private URL url;
        MiniReceptor r = new Receptor(); // RECEPTOR EN HILO PRINCIPAL

        public Conexion (URL url) {
            this.url = url;
        }
        @Override
        public void run () {
            try {

                Bitmap bitmap = BitmapFactory.decodeStream(url.openStream());
                MiniEvento evento = new MiniEvento();
                ArrayList<Bitmap> a = new ArrayList<>();
                a.add(bitmap);
                evento.agregarDato("imagen",a);
                evento.receptor (r);
                evento.lanzar();
                MensajeRegistro.msj (this, "IMAGEN LANZADA");

            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }


    private class Receptor extends MiniReceptor {


        @Override
        public void procesar (Bundle bundle) {
            ArrayList<Bitmap> a;
            try {
                a = (ArrayList) bundle.getSerializable("imagen");
            } catch (Exception e) {
                return;
            }
            MensajeRegistro.msj (this, "IMAGEN RECIBIDA");
            Bitmap bitmap = (Bitmap) a.get(0);
            bitmap(bitmap);
        }
    }





    public String nombreCompleto() {
        return nombreCompleto(uri);
    }



    private String nombreCompleto(Uri uri) {
        if (uri == null)
            return "";

        String result;
        Cursor cursor = actividad.getContentResolver().query(uri, null, null, null, null);
        if (cursor == null) {
            // Source is Dropbox or other similar local file path
        result = uri.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        } return result;
    }




}


