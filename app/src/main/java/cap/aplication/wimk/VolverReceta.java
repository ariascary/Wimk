package cap.aplication.wimk;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class VolverReceta extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volver_atras);


        Button si = (Button) findViewById(R.id.button2);
        si.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Principal.class);
            startActivity(intencion);
        });

        Button no = (Button) findViewById(R.id.button3);
        no.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Crear_receta.class);
            startActivity(intencion);
        });

    }

    @Override
    public void onClick(View view) {

    }
}
