package cap.aplication.wimk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

        private static final int SPLASH_DELAY = 2000; // Tiempo de duración de la pantalla de carga en milisegundos

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_pantallacarga);

            // Retraso para mostrar la pantalla de carga
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Iniciar la actividad principal después del tiempo de retraso
                    Intent intent = new Intent(MainActivity.this, ArrancaApp.class); // Reemplaza HomeActivity con la actividad principal de tu aplicación
                    startActivity(intent);
                    finish();
                }
            }, SPLASH_DELAY);
        }



    @Override
    public void onClick(View view) {

    }
}


