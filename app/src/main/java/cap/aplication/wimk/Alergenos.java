package cap.aplication.wimk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Alergenos extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alergenos);


        Button verduras = (Button)  findViewById(R.id.button4);
        verduras.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Verduras.class);
            startActivity(intencion);
        });

        Button  fruta= (Button)  findViewById(R.id.button5);
        fruta.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Fruta.class);
            startActivity(intencion);
        });

        Button carne = (Button)  findViewById(R.id.button6);
        carne.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Carne.class);
            startActivity(intencion);
        });

        Button FrutosSec = (Button)  findViewById(R.id.button7);
        FrutosSec.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), FrutoSec.class);
            startActivity(intencion);
        });

        Button otros = (Button)  findViewById(R.id.button8);
        otros.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Otros.class);
            startActivity(intencion);
        });

        Button continuar = (Button)  findViewById(R.id.registro2);
        continuar.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Restricciones.class);
            startActivity(intencion);
        });
    }

    @Override
    public void onClick(View view) {

    }
}