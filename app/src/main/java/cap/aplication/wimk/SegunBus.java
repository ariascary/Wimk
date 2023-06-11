package cap.aplication.wimk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
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

    private ArrayList<String> nombresRecetas = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private boolean postre;
    private boolean vegetariano;
    private boolean vegano;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segun_busqueda);

        listView = (ListView) findViewById(R.id.listaIngredientes);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresRecetas);
        listView.setAdapter(adapter);

        // Obtener los ingredientes pasados como extra en el Intent
        Intent intent = getIntent();
        ArrayList<String> listaIngredientes = intent.getStringArrayListExtra("ingredientes");
        postre = intent.getBooleanExtra("postre", false);
        vegetariano = intent.getBooleanExtra("vegetariano", false);
        vegano = intent.getBooleanExtra("vegano", false);

        // Realizar la búsqueda en la base de datos
        buscarRecetas((ArrayList<String>) listaIngredientes);


        ImageButton flecha = (ImageButton) findViewById(R.id.imageButton100);
        flecha.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Principal.class);
            startActivity(intencion);
            finish();
        });
    }

    private void buscarRecetas(ArrayList<String> listaIngredientes) {
        DatabaseReference recetasRef = FirebaseDatabase.getInstance().getReference().child("recetas");

        recetasRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {


                    for (DataSnapshot recetaSnapshot : dataSnapshot.getChildren()) {
                        boolean esPostre = recetaSnapshot.child("postre").getValue(Boolean.class);
                        boolean esVegetariano = recetaSnapshot.child("vegetariana").getValue(Boolean.class);
                        boolean esVegano = recetaSnapshot.child("vegana").getValue(Boolean.class);

                        if (postre == false  && vegetariano== false && vegano== false && esPostre==false) {
                            // Obtener los ingredientes de la receta actual
                            ArrayList<String> ingredientesReceta = recetaSnapshot.child("ingredientes").getValue(new GenericTypeIndicator<ArrayList<String>>() {
                            });
                            for (int i = 0; i < listaIngredientes.size(); i++) {
                                // Verificar si la receta contiene algún ingrediente de la lista proporcionada
                                for (String ingrediente : ingredientesReceta) {
                                    if (ingrediente.toLowerCase().contains(listaIngredientes.get(i).toLowerCase())) {
                                        // La receta contiene al menos uno de los ingredientes buscados
                                        // Agregar el nombre de la receta a la lista de nombres

                                        String nombreReceta = recetaSnapshot.child("nombre").getValue(String.class);
                                        if (!nombresRecetas.contains(nombreReceta)) {
                                            nombresRecetas.add(nombreReceta);
                                        }
                                    }
                                }
                            }
                            listView.setAdapter(adapter);
                        }else if (postre == false  && vegetariano== true && vegano== false && esVegetariano==true && esPostre==false){
                            // Obtener los ingredientes de la receta actual
                            ArrayList<String> ingredientesReceta = recetaSnapshot.child("ingredientes").getValue(new GenericTypeIndicator<ArrayList<String>>() {
                            });
                            for (int i = 0; i < listaIngredientes.size(); i++) {
                                // Verificar si la receta contiene algún ingrediente de la lista proporcionada
                                for (String ingrediente : ingredientesReceta) {
                                    if (ingrediente.toLowerCase().contains(listaIngredientes.get(i).toLowerCase())) {
                                        // La receta contiene al menos uno de los ingredientes buscados
                                        // Agregar el nombre de la receta a la lista de nombres

                                        String nombreReceta = recetaSnapshot.child("nombre").getValue(String.class);
                                        if (!nombresRecetas.contains(nombreReceta)) {
                                            nombresRecetas.add(nombreReceta);
                                        }
                                    }
                                }
                            }
                            listView.setAdapter(adapter);
                        }else if (postre == false  && vegetariano== false && vegano== true && esVegano==true && esPostre==false){
                            // Obtener los ingredientes de la receta actual
                            ArrayList<String> ingredientesReceta = recetaSnapshot.child("ingredientes").getValue(new GenericTypeIndicator<ArrayList<String>>() {
                            });
                            for (int i = 0; i < listaIngredientes.size(); i++) {
                                // Verificar si la receta contiene algún ingrediente de la lista proporcionada
                                for (String ingrediente : ingredientesReceta) {
                                    if (ingrediente.toLowerCase().contains(listaIngredientes.get(i).toLowerCase())) {
                                        // La receta contiene al menos uno de los ingredientes buscados
                                        // Agregar el nombre de la receta a la lista de nombres

                                        String nombreReceta = recetaSnapshot.child("nombre").getValue(String.class);
                                        if (!nombresRecetas.contains(nombreReceta)) {
                                            nombresRecetas.add(nombreReceta);
                                        }
                                    }
                                }
                            }
                            listView.setAdapter(adapter);
                        }else if (postre == true  && vegetariano== false && vegano== false &&  esPostre==true){
                            // Obtener los ingredientes de la receta actual
                            ArrayList<String> ingredientesReceta = recetaSnapshot.child("ingredientes").getValue(new GenericTypeIndicator<ArrayList<String>>() {
                            });
                            for (int i = 0; i < listaIngredientes.size(); i++) {
                                // Verificar si la receta contiene algún ingrediente de la lista proporcionada
                                for (String ingrediente : ingredientesReceta) {
                                    if (ingrediente.toLowerCase().contains(listaIngredientes.get(i).toLowerCase())) {
                                        // La receta contiene al menos uno de los ingredientes buscados
                                        // Agregar el nombre de la receta a la lista de nombres

                                        String nombreReceta = recetaSnapshot.child("nombre").getValue(String.class);
                                        if (!nombresRecetas.contains(nombreReceta)) {
                                            nombresRecetas.add(nombreReceta);
                                        }
                                    }
                                }
                            }
                            listView.setAdapter(adapter);
                        }else if (postre == true  && vegetariano== true && vegano== false && esVegetariano==true && esPostre==true){
                            // Obtener los ingredientes de la receta actual
                            ArrayList<String> ingredientesReceta = recetaSnapshot.child("ingredientes").getValue(new GenericTypeIndicator<ArrayList<String>>() {
                            });
                            for (int i = 0; i < listaIngredientes.size(); i++) {
                                // Verificar si la receta contiene algún ingrediente de la lista proporcionada
                                for (String ingrediente : ingredientesReceta) {
                                    if (ingrediente.toLowerCase().contains(listaIngredientes.get(i).toLowerCase())) {
                                        // La receta contiene al menos uno de los ingredientes buscados
                                        // Agregar el nombre de la receta a la lista de nombres

                                        String nombreReceta = recetaSnapshot.child("nombre").getValue(String.class);
                                        if (!nombresRecetas.contains(nombreReceta)) {
                                            nombresRecetas.add(nombreReceta);
                                        }
                                    }
                                }
                            }
                            listView.setAdapter(adapter);
                        }else if (postre == true  && vegetariano== false && vegano== true && esVegano==true && esPostre==true){
                            // Obtener los ingredientes de la receta actual
                            ArrayList<String> ingredientesReceta = recetaSnapshot.child("ingredientes").getValue(new GenericTypeIndicator<ArrayList<String>>() {
                            });
                            for (int i = 0; i < listaIngredientes.size(); i++) {
                                // Verificar si la receta contiene algún ingrediente de la lista proporcionada
                                for (String ingrediente : ingredientesReceta) {
                                    if (ingrediente.toLowerCase().contains(listaIngredientes.get(i).toLowerCase())) {
                                        // La receta contiene al menos uno de los ingredientes buscados
                                        // Agregar el nombre de la receta a la lista de nombres

                                        String nombreReceta = recetaSnapshot.child("nombre").getValue(String.class);
                                        if (!nombresRecetas.contains(nombreReceta)) {
                                            nombresRecetas.add(nombreReceta);
                                        }
                                    }
                                }
                            }
                            listView.setAdapter(adapter);
                        }else if (postre == false  && vegetariano== true && vegano== true && esVegetariano==true && esPostre==false && esVegano==true){
                            // Obtener los ingredientes de la receta actual
                            ArrayList<String> ingredientesReceta = recetaSnapshot.child("ingredientes").getValue(new GenericTypeIndicator<ArrayList<String>>() {
                            });
                            for (int i = 0; i < listaIngredientes.size(); i++) {
                                // Verificar si la receta contiene algún ingrediente de la lista proporcionada
                                for (String ingrediente : ingredientesReceta) {
                                    if (ingrediente.toLowerCase().contains(listaIngredientes.get(i).toLowerCase())) {
                                        // La receta contiene al menos uno de los ingredientes buscados
                                        // Agregar el nombre de la receta a la lista de nombres

                                        String nombreReceta = recetaSnapshot.child("nombre").getValue(String.class);
                                        if (!nombresRecetas.contains(nombreReceta)) {
                                            nombresRecetas.add(nombreReceta);
                                        }
                                    }
                                }
                            }
                            listView.setAdapter(adapter);
                        }else if (postre == true  && vegetariano== true && vegano== true && esVegetariano==true && esPostre==true && esVegano==true){
                            // Obtener los ingredientes de la receta actual
                            ArrayList<String> ingredientesReceta = recetaSnapshot.child("ingredientes").getValue(new GenericTypeIndicator<ArrayList<String>>() {
                            });
                            for (int i = 0; i < listaIngredientes.size(); i++) {
                                // Verificar si la receta contiene algún ingrediente de la lista proporcionada
                                for (String ingrediente : ingredientesReceta) {
                                    if (ingrediente.toLowerCase().contains(listaIngredientes.get(i).toLowerCase())) {
                                        // La receta contiene al menos uno de los ingredientes buscados
                                        // Agregar el nombre de la receta a la lista de nombres

                                        String nombreReceta = recetaSnapshot.child("nombre").getValue(String.class);
                                        if (!nombresRecetas.contains(nombreReceta)) {
                                            nombresRecetas.add(nombreReceta);
                                        }
                                    }
                                }
                            }
                            listView.setAdapter(adapter);
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






    private void mostrarNombresRecetas(ArrayList<String> nombresRecetas) {
        // Verificar si la lista de nombres de recetas no está vacía
        if (!nombresRecetas.isEmpty()) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String text = listView.getItemAtPosition(position).toString().trim();
                    Intent intent = new Intent(SegunBus.this, Receta.class);
                    intent.putExtra("nombreReceta", nombresRecetas.get(position)); // Aquí se pasa el nombre de la receta
                    intent.putStringArrayListExtra("listaRecetas", nombresRecetas);
                    startActivity(intent);
                }
            });
        }else{
            String nombreReceta = "No hay recetas para mostrar";
            nombresRecetas.add(nombreReceta);

        }
    }



    @Override
    public void onClick(View view) {

    }
}
