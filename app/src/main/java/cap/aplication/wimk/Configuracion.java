package cap.aplication.wimk;

import static androidx.core.content.ContextCompat.startActivity;

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

public class Configuracion extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);



        Button guardar = (Button)  findViewById(R.id.registro22);
        guardar.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Registro.class);
            startActivity(intencion);
        });

        ((ImageButton) findViewById(R.id.imageButton20)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resources res= Configuracion.this.getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.locale= new Locale("es");
                res.updateConfiguration(conf, dm);

                Configuracion.this.recreate();

            }
        });

        ((ImageButton) findViewById(R.id.imageButton23)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resources res= Configuracion.this.getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.locale= new Locale("en");
                res.updateConfiguration(conf, dm);

                Configuracion.this.recreate();

            }
        });

    }


    @Override
    public void onClick(View view) {

    }
}