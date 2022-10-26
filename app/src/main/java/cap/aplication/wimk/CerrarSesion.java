package cap.aplication.wimk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CerrarSesion extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerrar_sesion);


        Button si = (Button)  findViewById(R.id.button2);
        si.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), InicioSesion.class);
            startActivity(intencion);
        });

        Button no = (Button)  findViewById(R.id.button3);
        no.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Principal.class);
            startActivity(intencion);
        });


    }

    @Override
    public void onClick(View view) {

    }

}