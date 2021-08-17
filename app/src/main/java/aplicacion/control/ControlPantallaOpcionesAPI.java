package aplicacion.control;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import aplicacion.adaptador.Preferencias;
import aplicacion.vista.PantallaOpcionesApi;
import pc.javier.menulateralcompatible.R;
import utilidades.basico.MensajeRegistro;
import utilidades.control.Control;

public class ControlPantallaOpcionesAPI extends Control {


    private Preferencias preferencias;
    private PantallaOpcionesApi pantalla;

    public ControlPantallaOpcionesAPI(Activity actividad) {
        super(actividad);

        preferencias = new Preferencias(actividad);
        pantalla = new PantallaOpcionesApi(actividad);

        pantalla.idioma_seleccionado (preferencias.get_api_idioma());
        pantalla.unidad_seleccionada (preferencias.get_api_unidad());
        pantalla.id_seleccionado(preferencias.get_api_id());
    }





    public void clic_si () {
        String idioma = opcion_seleccionada(R.id.api_idioma);
        String unidad = opcion_seleccionada(R.id.api_unidad);
        String id_api = pantalla.texto(R.id.api_id);

        MensajeRegistro.msj("IDIOMA", idioma);
        MensajeRegistro.msj("UNIDAD", unidad);
        MensajeRegistro.msj("ID_API", id_api);

        if (idioma.length() > 0)
            preferencias.set_api_idioma(idioma);
        if (unidad.length() > 0)
            preferencias.set_api_unidad(unidad);
        preferencias.set_api_id(id_api);

        pantalla.finalizarActividad();


    }

    public void clic_no () {
        pantalla.finalizarActividad();

    }




    private String opcion_seleccionada (int id_radio) {
        RadioButton radio_seleccionado = pantalla.getRadioSeleecionado(id_radio);
        if (radio_seleccionado != null)
            return radio_seleccionado.getTag().toString();
        return "";
    }


}
