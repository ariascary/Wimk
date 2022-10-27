package cap.aplication.wimk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Filtros extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtros);


        Button guardar = (Button) findViewById(R.id.registro662);
        guardar.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Buscar_ingredientes.class);
            startActivity(intencion);
        });

        ImageButton flecha = (ImageButton) findViewById(R.id.imageButton951);
        flecha.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), VolverFiltro.class);
            startActivity(intencion);
        });


    }

    @Override
    public void onClick(View view) {

    }
}