package aplicacion.vista;

import android.app.Activity;
import android.widget.RadioButton;

import pc.javier.menulateralcompatible.R;
import utilidades.vista.EditorVistas;

public class PantallaOpcionesApi extends EditorVistas {
    public PantallaOpcionesApi(Activity actividad) {
        super(actividad);
    }





    private void crear_idiomas () {
        nuevo_idioma ("af",  "Afrikaans");
        nuevo_idioma ("al",  "Albanian");
        nuevo_idioma ("ar",  "Arabic");
        nuevo_idioma ("az",  "Azerbaijani");
        nuevo_idioma ("bg",  "Bulgarian");
        nuevo_idioma ("ca",  "Catalan");
        nuevo_idioma ("cz",  "Czech");
        nuevo_idioma ("da",  "Danish");
        nuevo_idioma ("de",  "German");
        nuevo_idioma ("el",  "Greek");
        nuevo_idioma ("en",  "English");
        nuevo_idioma ("eu",  "Basque");
        nuevo_idioma ("fa",  "Persian (Farsi)");
        nuevo_idioma ("fi",  "Finnish");
        nuevo_idioma ("fr",  "French");
        nuevo_idioma ("gl",  "Galician");
        nuevo_idioma ("he",  "Hebrew");
        nuevo_idioma ("hi",  "Hindi");
        nuevo_idioma ("hr",  "Croatian");
        nuevo_idioma ("hu",  "Hungarian");
        nuevo_idioma ("id",  "Indonesian");
        nuevo_idioma ("it",  "Italian");
        nuevo_idioma ("ja",  "Japanese");
        nuevo_idioma ("kr",  "Korean");
        nuevo_idioma ("la",  "Latvian");
        nuevo_idioma ("lt",  "Lithuanian");
        nuevo_idioma ("mk",  "Macedonian");
        nuevo_idioma ("no",  "Norwegian");
        nuevo_idioma ("nl",  "Dutch");
        nuevo_idioma ("pl",  "Polish");
        nuevo_idioma ("pt",  "Portuguese");
        nuevo_idioma ("pt_br",  "Português Brasil");
        nuevo_idioma ("ro",  "Romanian");
        nuevo_idioma ("ru",  "Russian");
        nuevo_idioma ("sv",  "Swedish");
        nuevo_idioma ("se",  "Swedish");
        nuevo_idioma ("sk",  "Slovak");
        nuevo_idioma ("sl",  "Slovenian");
        nuevo_idioma ("sp",  "Spanish");
        nuevo_idioma ("es",  "Spanish");
        nuevo_idioma ("sr",  "Serbian");
        nuevo_idioma ("th",  "Thai");
        nuevo_idioma ("tr",  "Turkish");
        nuevo_idioma ("ua",  "Ukrainian");
        nuevo_idioma ("uk",  "Ukrainian");
        nuevo_idioma ("vi",  "Vietnamese");
        nuevo_idioma ("zh_cn",  "Chinese Simplified");
        nuevo_idioma ("zh_tw",  "Chinese Traditional");
        nuevo_idioma ("zu",  "Zulu");
    }

    private void  nuevo_idioma (String codigo, String descripcion) {
        RadioButton radio = new RadioButton (actividad);

        radio.setText("[" + codigo + "] " + descripcion);
        radio.setTag(codigo);

        // radio.setTextSize(30);


        agregarRadio(R.id.api_idioma, radio);
    }




    public void idioma_seleccionado (String idioma_seleccionado) {
        // this.idioma_seleccionado = idioma_seleccionado;
        crear_idiomas();
        radio_seleccionar_etiqueta(R.id.api_idioma, idioma_seleccionado);
    }

    public void unidad_seleccionada (String unidad_seleccionada) {
        radio_seleccionar_etiqueta(R.id.api_unidad, unidad_seleccionada);
    }

    public void id_seleccionado (String id_seleccionado) {
        setEditText(R.id.api_id, id_seleccionado);
    }


}


