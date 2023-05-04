package cap.aplication.wimk;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Configuracion extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);


        ImageButton Confi = (ImageButton)  findViewById(R.id.imageButton21);
        Confi.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), VolverrAtras.class);
            startActivity(intencion);
        });

        Button guardar = (Button)  findViewById(R.id.registro22);
        guardar.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Registro.class);
            startActivity(intencion);
        });

    }


    @Override
    public void onClick(View view) {

    }
}