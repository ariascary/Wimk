package cap.aplication.wimk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Ingredientes extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredientes);

        Button guardar = (Button) findViewById(R.id.registro2);
        guardar.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Crear_receta.class);
            startActivity(intencion);
        });

        Button verdu = (Button) findViewById(R.id.button4);
        verdu.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), VerdurasCrear.class);
            startActivity(intencion);
        });

        Button fru = (Button) findViewById(R.id.button5);
        fru.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), FrutasCrear.class);
            startActivity(intencion);
        });

        Button Carne = (Button) findViewById(R.id.button6);
        Carne.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), CarneCrear.class);
            startActivity(intencion);
        });

        Button frutoss = (Button) findViewById(R.id.button7);
        frutoss.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), FrutosseCrear.class);
            startActivity(intencion);
        });

        Button otro = (Button) findViewById(R.id.button8);
        otro.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), OtroCrear.class);
            startActivity(intencion);
        });


    }

    @Override
    public void onClick(View view) {

    }
}
