package cap.aplication.wimk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Pantalla_Bienve extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setTheme(R.style.Theme_Wimk); con esto debería funcionar para que salga la pantalla de carga, cambios en manager, themes
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis_bienve);

        ImageButton flecha1 = (ImageButton)  findViewById(R.id.imageButton2);
        flecha1.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Alergenos.class);
            startActivity(intencion);
        });

    }

    @Override
    public void onClick(View view) {

    }
}