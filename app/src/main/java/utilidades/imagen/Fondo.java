package utilidades.imagen;

import android.app.Activity;
import android.app.WallpaperManager;
import android.graphics.Bitmap;

import java.io.IOException;

public class Fondo {

    Activity actividad;
    WallpaperManager wallpaperManager ;
    public Fondo (Activity actividad) {
        this.actividad = actividad;
        this.wallpaperManager = WallpaperManager.getInstance(actividad);
    }

    public void usarBitmap (Bitmap imagen) {

        try {
            // set the wallpaper by calling the setResource function and
            // passing the drawable file
            wallpaperManager.setBitmap(imagen);
        } catch (IOException e) {
            // here the errors can be logged instead of printStackTrace
            e.printStackTrace();
        }
    }

    public void usarRecurso (int imagen) {

        try {
            // set the wallpaper by calling the setResource function and
            // passing the drawable file
            wallpaperManager.setResource(imagen);
        } catch (IOException e) {
            // here the errors can be logged instead of printStackTrace
            e.printStackTrace();
        }
    }

}
