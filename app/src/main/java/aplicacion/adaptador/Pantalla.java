package aplicacion.adaptador;

import android.app.Activity;
import android.widget.ImageView;

import aplicacion.vista.Fondo;
import pc.javier.menulateralcompatible.R;
import utilidades.basico.MensajeRegistro;
import utilidades.vista.EditorVistas;

public class Pantalla extends EditorVistas {


    public Pantalla(Activity activity) {
        super(activity);
        usarCache = false;
    }





    public void setEstado (String texto) {
        setTextView(R.id.estado, texto);
    }

    public void setImagen (String codigo) {
        ImageView imagen = getImageView(R.id.clima_icono);
        if (imagen == null)
            return;

        switch (codigo) {
            case "01d" : imagen.setImageResource (R.drawable.clima_icono_01d) ; break;
            case "01n" : imagen.setImageResource (R.drawable.clima_icono_01n) ; break;
            case "02d" : imagen.setImageResource (R.drawable.clima_icono_02d) ; break;
            case "02n" : imagen.setImageResource (R.drawable.clima_icono_02n) ; break;
            case "03d" : imagen.setImageResource (R.drawable.clima_icono_03d) ; break;
            case "03n" : imagen.setImageResource (R.drawable.clima_icono_03n) ; break;
            case "04d" : imagen.setImageResource (R.drawable.clima_icono_04d) ; break;
            case "04n" : imagen.setImageResource (R.drawable.clima_icono_04n) ; break;
            case "09d" : imagen.setImageResource (R.drawable.clima_icono_09d) ; break;
            case "09n" : imagen.setImageResource (R.drawable.clima_icono_09n) ; break;
            case "10d" : imagen.setImageResource (R.drawable.clima_icono_10d) ; break;
            case "10n" : imagen.setImageResource (R.drawable.clima_icono_10n) ; break;
            case "11d" : imagen.setImageResource (R.drawable.clima_icono_11d) ; break;
            case "11n" : imagen.setImageResource (R.drawable.clima_icono_11n) ; break;
            case "13d" : imagen.setImageResource (R.drawable.clima_icono_13d) ; break;
            case "13n" : imagen.setImageResource (R.drawable.clima_icono_13n) ; break;
            case "50d" : imagen.setImageResource (R.drawable.clima_icono_50d) ; break;
            case "50n" : imagen.setImageResource (R.drawable.clima_icono_50n) ; break;
        }

    }

    public void setFondo (String codigo) {

        int recurso = recurso_fondo(codigo);

        MensajeRegistro.msj ("************************ codigo: ", codigo);
        // fondo del telefono
        Fondo fondo = new Fondo(actividad);
        fondo.usarRecurso(recurso);

        // fondo de la aplicacion
        ImageView imagen = getImageView(R.id.clima_fondo);
        if (imagen == null)
            return;
        imagen.setImageResource(recurso);

    }

    public int recurso_fondo  (String codigo) {
        int recurso = R.drawable.clima_fondo_01d;
        switch (codigo) {
            case "01d" : recurso = R.drawable.clima_fondo_01d ;  break;
            case "01n" : recurso = R.drawable.clima_fondo_01n ;  break;
            case "02d" : recurso = R.drawable.clima_fondo_02d ;  break;
            case "02n" : recurso = R.drawable.clima_fondo_02n ;  break;
            case "03d" : recurso = R.drawable.clima_fondo_03d ;  break;
            case "03n" : recurso = R.drawable.clima_fondo_03n ;  break;
            case "04d" : recurso = R.drawable.clima_fondo_04d ;  break;
            case "04n" : recurso = R.drawable.clima_fondo_04n ;  break;
            case "09d" : recurso = R.drawable.clima_fondo_09d ;  break;
            case "09n" : recurso = R.drawable.clima_fondo_09n ;  break;
            case "10d" : recurso = R.drawable.clima_fondo_10d ;  break;
            case "10n" : recurso = R.drawable.clima_fondo_10n ;  break;
            case "11d" : recurso = R.drawable.clima_fondo_11d ;  break;
            case "11n" : recurso = R.drawable.clima_fondo_11n ;  break;
            case "13d" : recurso = R.drawable.clima_fondo_13d ;  break;
            case "13n" : recurso = R.drawable.clima_fondo_13n ;  break;
            case "50d" : recurso = R.drawable.clima_fondo_50d ;  break;
            case "50n" : recurso = R.drawable.clima_fondo_50n ;  break;
        }
        return recurso;

    }

}
