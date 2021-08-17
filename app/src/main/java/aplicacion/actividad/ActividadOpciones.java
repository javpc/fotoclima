package aplicacion.actividad;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import aplicacion.control.ControlPantallaOpcionesAPI;
import pc.javier.menulateralcompatible.R;

public class ActividadOpciones extends AppCompatActivity {



    ControlPantallaOpcionesAPI control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_opciones_api);


        control = new ControlPantallaOpcionesAPI(this);


    }






    public void clic_componente_si (View v) {
        control.clic_si ();
    }

    public void clic_componente_no (View v) {
        control.clic_no ();
    }

}
