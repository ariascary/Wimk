package cap.aplication.wimk;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SegunBus extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segun_busqueda);


        ImageButton listo = (ImageButton) findViewById(R.id.imageButton100);
        listo.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Principal.class);
            startActivity(intencion);
        });
    }

    @Override
    public void onClick(View view) {

    }
}
