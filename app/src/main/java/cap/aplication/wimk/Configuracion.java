package cap.aplication.wimk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Configuracion  extends AppCompatActivity implements View.OnClickListener {
    private Button boton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

       /*  Para cuanod le demos a un boton los salga un mensajito
        Button boton1 = (Button) findViewById(R.id.button9);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast notification = Toast.makeText(MainActivity.this, "hola", Toast.LENGTH_SHORT);
                notification.show();
            }
        });*/

        boton1=(Button) findViewById(R.id.imageButton21);
        boton1.setOnClickListener(this);
    }
    /*con esto le decimos que cuando pulse el noton de buscar por ingrediente vaya a esa pagina*/
    @Override
    public void onClick(View view) {
        Intent intencion = new Intent(this, RecetasIngredientes.class);
        startActivity(intencion);

    }
}