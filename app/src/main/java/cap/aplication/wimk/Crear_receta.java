package cap.aplication.wimk;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Crear_receta extends AppCompatActivity implements View.OnClickListener{

        private EditText nombreEditText;
        private EditText descripcionEditText;
        private EditText ingredientesEditText;
        private Button registroButton;
        private ImageButton backButton;
        private CheckBox postreCheck;
        private CheckBox veganaCheck;
        private CheckBox vegeCheck;

        // Referencia a la base de datos de Firebase
        private DatabaseReference recetasRef;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_crear_receta);

            // Obtener la referencia a la base de datos de Firebase
            recetasRef = FirebaseDatabase.getInstance().getReference("recetas");

            nombreEditText = findViewById(R.id.editText3);
            descripcionEditText = findViewById(R.id.editText4);
            ingredientesEditText = findViewById(R.id.multiValueEditText);
            registroButton = findViewById(R.id.registro2);
            backButton = findViewById(R.id.imageButton51);
            postreCheck = findViewById(R.id.checkBox67);
            veganaCheck = findViewById(R.id.checkBox70);
            vegeCheck = findViewById(R.id.checkBox71);

            registroButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Obtener los datos ingresados por el usuario
                    String nombreReceta = nombreEditText.getText().toString().trim();
                    String descripcionReceta = descripcionEditText.getText().toString().trim();
                    String ingredientes = ingredientesEditText.getText().toString().trim();
                    boolean postre = postreCheck.isChecked();
                    boolean vegana = veganaCheck.isChecked();
                    boolean vegetal = vegeCheck.isChecked();

                    // Verificar si todos los campos están completos
                    if (nombreReceta.isEmpty() || descripcionReceta.isEmpty() || ingredientes.isEmpty()) {
                        Toast.makeText(Crear_receta.this, "Debe completar todos los campos", Toast.LENGTH_SHORT).show();
                    } else {
                        // Separar los ingredientes por comas y convertirlos en una lista
                        List<String> listaIngredientes = Arrays.asList(ingredientes.split(","));

                        // Guardar los datos en la base de datos de Firebase
                        guardarRecetaEnBaseDeDatos(nombreReceta, descripcionReceta, listaIngredientes, postre, vegana,vegetal);
                    }
                }
            });

            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Cerrar la actividad actual
                    Intent i = new Intent(Crear_receta.this, Principal.class);
                    startActivity(i);
                }
            });
        }

        private void guardarRecetaEnBaseDeDatos(String nombre, String descripcion, List<String> ingredientes, boolean postre, boolean vegana,boolean vegetal) {
            // Crear un mapa con los datos de la receta
            Map<String, Object> recetaMap = new HashMap<>();
            recetaMap.put("nombre", nombre);
            recetaMap.put("descripcion", descripcion);
            recetaMap.put("ingredientes", ingredientes);
            recetaMap.put("postre", postre);
            recetaMap.put("vegana", vegana);
            recetaMap.put("vegetariana", vegetal);

            // Generar una clave única para la receta
            String recetaKey = recetasRef.push().getKey();

            // Guardar los datos en la base de datos de Firebase
            recetasRef.child(recetaKey).setValue(recetaMap);

            // Mostrar mensaje de éxito
            Toast.makeText(this, "Receta guardada correctamente", Toast.LENGTH_SHORT).show();

            // Cerrar la actividad actual
            Intent i = new Intent(Crear_receta.this, Principal.class);
            startActivity(i);
        }



    @Override
    public void onClick(View view) {

    }
}
