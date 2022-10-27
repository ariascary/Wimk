package cap.aplication.wimk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Perfil extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiity_perfil);


        Button guardar = (Button) findViewById(R.id.registro27);
        guardar.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Principal.class);
            startActivity(intencion);
        });

        ImageButton flecha = (ImageButton) findViewById(R.id.imageButton651);
        flecha.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), VolverPerfil.class);
            startActivity(intencion);
        });

        Button camPrefe = (Button) findViewById(R.id.button3313);
        camPrefe.setOnClickListener(view -> {
            Toast notification = Toast.makeText(Perfil.this, "Estamos trabajando en esta opción", Toast.LENGTH_SHORT);
            notification.show();
        });

        Button modifrece = (Button) findViewById(R.id.button1662);
        modifrece.setOnClickListener(view -> {
            Toast notification = Toast.makeText(Perfil.this, "Estamos trabajando en esta opción", Toast.LENGTH_SHORT);
            notification.show();
        });


    }

    @Override
    public void onClick(View view) {

    }

}