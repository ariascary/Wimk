package cap.aplication.wimk;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FrutosseCrear extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legumbre_pasta);


         Button listo = (Button) findViewById(R.id.button444);
        listo.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Ingredientes.class);
            startActivity(intencion);
        });
    }

    @Override
    public void onClick(View view) {

    }
}