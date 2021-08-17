package aplicacion.adaptador;

import android.app.Activity;
import android.graphics.Typeface;

import pc.javier.menulateralcompatible.R;
import utilidades.componente.Componente_Indicador;
import utilidades.eventos.Instrumento;


public class ComponenteIndicador extends Componente_Indicador {
    private Instrumento instrumento;




    public ComponenteIndicador(Activity actividad, int id_panel) {
        super(actividad, id_panel);

        instrumento = new Instrumento(getVistaValor());

        Typeface typeface= Typeface.createFromAsset(actividad.getAssets(), "font/Comfortaa_Light.ttf");
        getVistaValor().setTypeface(typeface);

    }

    public void setTam (int valor ) {
        getVistaValor().setTextSize(valor);
    }


    public Instrumento getInstrumento() {
        return instrumento;
    }

    public void setValorIntrumento (String texto) {
        instrumento.texto(texto);
    }

    public void setLeyendaInferior (String texto) {
        setVisible(R.id.componente_indicador_texto_inferior);
        setTextView(R.id.componente_indicador_texto_inferior, texto);
    }

}
