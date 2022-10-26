package cap.aplication.wimk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Principal extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ImageButton flecha1 = (ImageButton)  findViewById(R.id.imageButton70);
        flecha1.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), CerrarSesion.class);
            startActivity(intencion);
        });

        ImageButton Confi = (ImageButton)  findViewById(R.id.imageButton71);
        Confi.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), ConfiPrincipal.class);
            startActivity(intencion);
        });

        Button buscaIngre = (Button)  findViewById(R.id.button9);
        buscaIngre.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Home_fragment.class);
            startActivity(intencion);
        });

        Button crearRece = (Button)  findViewById(R.id.button10);
        crearRece.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Gallery_Fragment.class);
            startActivity(intencion);
        });

        Button perfil = (Button)  findViewById(R.id.button11);
        perfil.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Slideshow_Fragment.class);
            startActivity(intencion);
        });

    }

    @Override
    public void onClick(View view) {

    }

}