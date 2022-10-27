package cap.aplication.wimk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Crear_receta extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_receta);


        Button ingredi = (Button) findViewById(R.id.button13);
        ingredi.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Ingredientes.class);
            startActivity(intencion);
        });

        Button etique = (Button) findViewById(R.id.button12);
        etique.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Etiquetas.class);
            startActivity(intencion);
        });

        Button guardar = (Button) findViewById(R.id.registro2);
        guardar.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Principal.class);
            startActivity(intencion);
        });

        ImageButton flecha = (ImageButton) findViewById(R.id.imageButton51);
        flecha.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), VolverReceta.class);
            startActivity(intencion);
        });

    }

    @Override
    public void onClick(View view) {

    }

}