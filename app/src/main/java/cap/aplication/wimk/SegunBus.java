package cap.aplication.wimk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SegunBus extends AppCompatActivity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segun_busqueda);

        // Obtener los ingredientes pasados como extra en el Intent
        Intent intent = getIntent();
        List<String> listaIngredientes = intent.getStringArrayListExtra("ingredientes");
        boolean postre = intent.getBooleanExtra("postre", false);
        boolean vegetariano = intent.getBooleanExtra("vegetariano", false);
        boolean vegano = intent.getBooleanExtra("vegano", false);

        // Realizar la búsqueda en la base de datos
        buscarRecetas((ArrayList<String>) listaIngredientes);

        ImageButton flecha = (ImageButton) findViewById(R.id.imageButton100);
        flecha.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Principal.class);
            startActivity(intencion);
        });
    }

    private void buscarRecetas(ArrayList<String> listaIngredientes) {
        DatabaseReference recetasRef = FirebaseDatabase.getInstance().getReference().child("recetas");

        recetasRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    List<String> nombresRecetas = new ArrayList<>();

                    for (DataSnapshot recetaSnapshot : dataSnapshot.getChildren()) {
                        // Obtener los ingredientes de la receta actual
                        List<String> ingredientesReceta = recetaSnapshot.child("ingredientes").getValue(new GenericTypeIndicator<List<String>>() {
                        });

                        // Verificar si la receta contiene algún ingrediente de la lista proporcionada
                        for (String ingrediente : ingredientesReceta) {
                            if (listaIngredientes.contains(ingrediente)) {
                                // La receta contiene al menos uno de los ingredientes buscados
                                // Agregar el nombre de la receta a la lista de nombres
                                String nombreReceta = recetaSnapshot.child("nombre").getValue(String.class);
                                nombresRecetas.add(nombreReceta);
                                break; // Salir del bucle una vez encontrada una coincidencia
                            }
                        }
                    }

                    // Mostrar los nombres de las recetas que cumplen con los ingredientes
                    mostrarNombresRecetas(nombresRecetas);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Manejar el error de la consulta
            }
        });
    }






    private void mostrarNombresRecetas(List<String> nombresRecetas) {
        TextView receta1 = findViewById(R.id.receta1);
        TextView receta2 = findViewById(R.id.receta2);

        if (nombresRecetas.size() > 0) {
            receta1.setText(nombresRecetas.get(0));
        }

        if (nombresRecetas.size() > 1) {
            receta2.setText(nombresRecetas.get(1));
        }
    }



    @Override
    public void onClick(View view) {

    }
}
