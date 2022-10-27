package cap.aplication.wimk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Etiquetas extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etiquetas);


        Button guardar = (Button) findViewById(R.id.registro26);
        guardar.setOnClickListener(view -> {
            Toast notification = Toast.makeText(Etiquetas.this, "Se ha creado la receta correctamente", Toast.LENGTH_SHORT);
            notification.show();
            Intent intencion = new Intent(getApplicationContext(), Principal.class);
            startActivity(intencion);
        });

        ImageButton flecha = (ImageButton) findViewById(R.id.imageButton3351);
        flecha.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), VolverEtique.class);
            startActivity(intencion);
        });


    }



    @Override
    public void onClick(View view) {

    }
}
