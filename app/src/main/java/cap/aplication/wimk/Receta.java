package cap.aplication.wimk;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Receta extends AppCompatActivity implements View.OnClickListener {

    TextView nombreReceta;
    TextView descripcion;
    TextView ingredientes;
    FirebaseAuth mAuth;
    DatabaseReference userRef; //FirebaseDatabase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas_info);


        nombreReceta = findViewById(R.id.text_home);
        descripcion = findViewById(R.id.descrip);
        descripcion.setMovementMethod(new ScrollingMovementMethod());
        ingredientes = findViewById(R.id.ingredient);
        ingredientes.setMovementMethod(new ScrollingMovementMethod());
        mAuth= FirebaseAuth.getInstance();
        String id = mAuth.getCurrentUser().getUid();

        Intent intent = getIntent();
        String nombreRecetaSeleccionada = intent.getStringExtra("nombreReceta");
        ArrayList<String> listaIngredients= intent.getStringArrayListExtra("listaRecetas");

        // Obtén la referencia al nodo de la receta seleccionada en la base de datos
        DatabaseReference recetaRef = FirebaseDatabase.getInstance().getReference().child("recetas");
        Query query = recetaRef.orderByChild("nombre").equalTo(nombreRecetaSeleccionada);

        // Agrega un listener para leer los datos de la receta en tiempo real
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        // Muestra los datos de la receta en la interfaz de usuario
                        String nombre = snapshot.child("nombre").getValue(String.class);
                        nombreReceta.setText(nombre);

                        String descripcionReceta = snapshot.child("descripcion").getValue(String.class);
                        descripcion.setText(descripcionReceta);

                        List<String> listaIngredientes = snapshot.child("ingredientes").getValue(new GenericTypeIndicator<List<String>>() {});
                        StringBuilder sbIngredientes = new StringBuilder();
                        for (String ingrediente : listaIngredientes) {
                            sbIngredientes.append("- ").append(ingrediente).append("\n");
                        }
                        ingredientes.setText(sbIngredientes.toString());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Maneja el error de lectura de datos
            }
        });

        ImageButton flecha = findViewById(R.id.imageButton100);
        flecha.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Principal.class);
            finish();
            startActivity(intencion);
        });
    }

    @Override
    public void onClick(View view) {

    }
}
