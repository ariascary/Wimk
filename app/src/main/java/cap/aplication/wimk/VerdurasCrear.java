package cap.aplication.wimk;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class VerdurasCrear extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verduras);


        Button listo = (Button) findViewById(R.id.registro3);
        listo.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Ingredientes.class);
            startActivity(intencion);
        });
    }

    @Override
    public void onClick(View view) {

    }
}