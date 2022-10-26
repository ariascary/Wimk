package cap.aplication.wimk;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class InicioSesion extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        ImageButton flecha1 = (ImageButton)  findViewById(R.id.imageButton31);
        flecha1.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intencion);
        });

        ImageButton Confi = (ImageButton)  findViewById(R.id.imageButton30);
        Confi.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), ConfiInicio.class);
            startActivity(intencion);
        });

        Button ingresar = (Button)  findViewById(R.id.registro2);
        ingresar.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Principal.class);
            startActivity(intencion);
        });

    }

    @Override
    public void onClick(View view) {

    }
}