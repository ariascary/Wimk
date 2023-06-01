package cap.aplication.wimk;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Buscar_ingredientes extends AppCompatActivity implements View.OnClickListener {

    private EditText ingredientesEditText;
    private String ingredientes;
    private CheckBox postreCheck;
    private boolean postre;
    private CheckBox vegeCheck;
    private  CheckBox veganaCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busc_ingredient);


        ingredientesEditText = findViewById(R.id.multiValueEditText);
        postreCheck = findViewById(R.id.checkBox67);
        vegeCheck = findViewById(R.id.checkBox71);
        veganaCheck = findViewById(R.id.checkBox70);

        Button buscar = (Button) findViewById(R.id.button19);
        buscar.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), SegunBus.class);

            ingredientes = ingredientesEditText.getText().toString().trim();
            List<String> listaIngredientes = new ArrayList<>(Arrays.asList(ingredientes.split(",")));
            postre = postreCheck.isChecked();
            boolean vegetariano = vegeCheck.isChecked();
            boolean vegano = veganaCheck.isChecked();
            intencion.putStringArrayListExtra("ingredientes", (ArrayList<String>)listaIngredientes);
            intencion.putExtra("vegetariano", vegetariano);
            intencion.putExtra("vegano", vegano);
            startActivity(intencion);
        });


        ImageButton flecha = (ImageButton) findViewById(R.id.imageButton100);
        flecha.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Principal.class);
            startActivity(intencion);
        });

    }

    @Override
    public void onClick(View view) {

    }
}
