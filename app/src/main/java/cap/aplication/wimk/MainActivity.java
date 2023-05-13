package cap.aplication.wimk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTheme(R.style.Theme_Wimk);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton1 = (Button)  findViewById(R.id.inicioSesion);
        boton1.setOnClickListener(view -> {
          Intent intencion = new Intent(getApplicationContext(), InicioSesion.class);
          startActivity(intencion);
        });

        ImageButton Imagenboton3 = (ImageButton)  findViewById(R.id.imageButton2);
        Imagenboton3.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), ConfiMain.class);
            startActivity(intencion);
        });

        Button boton2 = (Button)  findViewById(R.id.registro);
        boton2.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Registro.class);
            startActivity(intencion);
        });

    }

    @Override
    public void onClick(View view) {

    }
}