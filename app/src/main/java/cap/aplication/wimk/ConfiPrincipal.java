package cap.aplication.wimk;


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

public class ConfiPrincipal extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);


        ImageButton Confi = (ImageButton)  findViewById(R.id.imageButton21);
        Confi.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), VolverPrinci.class);
            startActivity(intencion);
        });

        Button guardar = (Button)  findViewById(R.id.registro22);
        guardar.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Principal.class);
            startActivity(intencion);
        });

    }


    @Override
    public void onClick(View view) {

    }
}