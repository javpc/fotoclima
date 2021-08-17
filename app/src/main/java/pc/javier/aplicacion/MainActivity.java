package pc.javier.aplicacion;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import aplicacion.actividad.ActividadAyuda;
import aplicacion.actividad.ActividadOpciones;
import aplicacion.control.ControlPantallaPrincipal;
import pc.javier.menulateralcompatible.R;
import utilidades.basico.EnlaceExterno;
import utilidades.menu.MenuLateral;
import utilidades.menu.PantallaPrincipalConMenuLateral;


public class MainActivity extends PantallaPrincipalConMenuLateral {


    private ControlPantallaPrincipal control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.principal_pantalla);

        menuLateral = new MenuLateral(this, R.id.panel_layout, R.id.panel_view);

        control = new ControlPantallaPrincipal(this, menuLateral);




    }

    @Override
    public void onResume () {
        super.onResume();



        if (control.no_hay_idioma ())
            control.iniciarActividad(ActividadOpciones.class);
        else
            control.actualizar();


    }

    @Override
    public void onDestroy () {
        super.onDestroy();

    }






    // Menú lateral -----------------------------------------------------------------

    @Override
    public void clicMenu (MenuItem item) {
        super.clicMenu(item);


        switch (item.getItemId()) {

            case R.id.menu_actualizar:
                control.actualizar();
                break;



            case R.id.menu_ayuda:
                control.iniciarActividad(ActividadAyuda.class);
                break;



            case R.id.menu_opciones:
                control.iniciarActividad(ActividadOpciones.class);
                break;

            case R.id.menu_proyectos:
                abrir_enlace(Aplicacion.url_telegram);
                break;

            case R.id.menu_donar:
                abrir_enlace(Aplicacion.url_donacion);
                break;
        }


    }


    public void clicBoton (View v) {
        menuLateral.alternar();
    }


    private void abrir_enlace (String enlace){
         (new EnlaceExterno(this)).abrirEnlace(enlace);
    }



    public void fab (View v) {
        control.actualizar();

    }



    public  void prueba () {

    }




}
