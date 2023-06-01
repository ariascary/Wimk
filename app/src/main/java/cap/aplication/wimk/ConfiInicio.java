package cap.aplication.wimk;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Locale;

public class ConfiInicio extends AppCompatActivity implements View.OnClickListener{

    private boolean aumentarLetra = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        Button btnAumentarLetra = findViewById(R.id.btn_aumentar_letra);
        Button btnDisminuirLetra = findViewById(R.id.btn_disminuir_letra);

        btnAumentarLetra.setOnClickListener(this);
        btnDisminuirLetra.setOnClickListener(this);

        Button guardar = (Button)  findViewById(R.id.registro22);
        guardar.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), InicioSesion.class);
            startActivity(intencion);
        });

        ((ImageButton) findViewById(R.id.imageButton20)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resources res= ConfiInicio.this.getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.locale= new Locale("es");
                res.updateConfiguration(conf, dm);

                ConfiInicio.this.recreate();

            }
        });

        ((ImageButton) findViewById(R.id.imageButton23)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resources res= ConfiInicio.this.getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.locale= new Locale("en");
                res.updateConfiguration(conf, dm);

                ConfiInicio.this.recreate();

            }
        });

    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_aumentar_letra) {
            // Cambiar el estado de aumentarLetra
            aumentarLetra = !aumentarLetra;

            // Obtener la configuración actual
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();

            // Modificar la escala de la fuente
            conf.fontScale = aumentarLetra ? 1.35f : 1.0f;

            // Actualizar la configuración y recrear la actividad
            res.updateConfiguration(conf, dm);
            recreate();
        } else if (view.getId() == R.id.btn_disminuir_letra) {
            // Cambiar el estado de aumentarLetra
            aumentarLetra = !aumentarLetra;

            // Obtener la configuración actual
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();

            // Modificar la escala de la fuente
            conf.fontScale = aumentarLetra ? 1.1f : 0.8f; // Ajusta los valores según tus necesidades

            // Actualizar la configuración y recrear la actividad
            res.updateConfiguration(conf, dm);
            recreate();
        }
    }
}