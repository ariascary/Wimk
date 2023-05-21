package cap.aplication.wimk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Crear_receta extends AppCompatActivity implements View.OnClickListener{

    private DatabaseReference databaseRef;
    /*private EditText editTextDescripcion;
    private Button buttonGuardar;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_receta);

        databaseRef = FirebaseDatabase.getInstance().getReference().child("Recetas");

       /* editTextNombre = findViewById(R.id.editTextNombre);
        editTextDescripcion = findViewById(R.id.editTextDescripcion);
        buttonGuardar = findViewById(R.id.buttonGuardar);
        buttonGuardar.setOnClickListener(this);*/


            Button ingredi = (Button) findViewById(R.id.button13);
            ingredi.setOnClickListener(view -> {
                Intent intencion = new Intent(getApplicationContext(), Ingredientes.class);
                startActivity(intencion);
            });

            Button etique = (Button) findViewById(R.id.button12);
            etique.setOnClickListener(view -> {
                Toast notification = Toast.makeText(Crear_receta.this, "Estamos trabajando en esta opción", Toast.LENGTH_SHORT);
                notification.show();
            });

            Button guardar = (Button) findViewById(R.id.registro2);
            guardar.setOnClickListener(view -> {
                Intent intencion = new Intent(getApplicationContext(), Principal.class);
                startActivity(intencion);
            });

            ImageButton flecha = (ImageButton) findViewById(R.id.imageButton51);
            flecha.setOnClickListener(view -> {
                Intent intencion = new Intent(getApplicationContext(), VolverReceta.class);
                startActivity(intencion);
            });

        }

        @Override
        public void onClick(View view) {
     /*   if (view.getId() == R.id.buttonGuardar) {
            String nombre = editTextNombre.getText().toString();
            String descripcion = editTextDescripcion.getText().toString();

            Receta nuevaReceta = new Receta(nombre, descripcion);
            databaseRef.push().setValue(nuevaReceta);

            Toast.makeText(this, "Receta guardada", Toast.LENGTH_SHORT).show();

            // Reiniciar los campos de texto después de guardar la receta
            editTextNombre.setText("");
            editTextDescripcion.setText("");*/
        }

    }