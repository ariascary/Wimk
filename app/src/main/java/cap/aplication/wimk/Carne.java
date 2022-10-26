package cap.aplication.wimk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Carne extends AppCompatActivity implements View.OnClickListener{
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_carnes);


    Button roja = (Button) findViewById(R.id.button4);
    roja.setOnClickListener(view -> {
        Intent intencion = new Intent(getApplicationContext(), CarneRoja.class);
        startActivity(intencion);
    });

    Button blanca = (Button) findViewById(R.id.button5);
    blanca.setOnClickListener(view -> {
        Intent intencion = new Intent(getApplicationContext(), CarneBlanca.class);
        startActivity(intencion);
    });

    ImageButton flecha = (ImageButton)  findViewById(R.id.imageButton2);
    flecha.setOnClickListener(view -> {
        Intent intencion = new Intent(getApplicationContext(), Alergenos.class);
        startActivity(intencion);
    });
}

@Override
public void onClick(View view) {

}
}