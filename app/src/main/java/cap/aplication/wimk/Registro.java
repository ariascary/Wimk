package cap.aplication.wimk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Registro extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ImageButton flecha1 = (ImageButton)  findViewById(R.id.imageButton51);
        flecha1.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intencion);
        });

        Button crearPerfil = (Button)  findViewById(R.id.registro2);
        crearPerfil.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Pantalla_Bienve.class);
            startActivity(intencion);
        });

        ImageButton confi = (ImageButton)  findViewById(R.id.imageButton50);
        confi.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Configuracion.class);
            startActivity(intencion);
        });

    }

    @Override
    public void onClick(View view) {

    }
}