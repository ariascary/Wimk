package cap.aplication.wimk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*  Para cuanod le demos a un boton los salga un mensajito
            Toast notification = Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT);
            notification.show();*/


        Button boton1 = (Button) findViewById(R.id.inicioSesion);
        boton1.setOnClickListener(view ->  {
            Intent intencion = new Intent(getApplicationContext(), RecetasIngredientes.class);
            startActivity(intencion);
        });

        Button boton2 = (Button) findViewById(R.id.registro);
        boton2.setOnClickListener(view ->  {
            Intent intencion = new Intent(getApplicationContext(), RecetasIngredientes.class);
            startActivity(intencion);
        });

        ImageButton imaboton3 = (ImageButton) findViewById(R.id.imageButton2);
        imaboton3.setOnClickListener(view ->  {
            Intent intencion = new Intent(getApplicationContext(), RecetasIngredientes.class);
            startActivity(intencion);
        });


    }
    /*con esto le decimos que cuando pulse el noton de buscar por ingrediente vaya a esa pagina*/
    @Override
    public void onClick(View view) {

    }
}