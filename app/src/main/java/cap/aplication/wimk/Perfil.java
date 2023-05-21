package cap.aplication.wimk;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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
import com.google.firebase.database.ValueEventListener;

public class  Perfil extends AppCompatActivity implements View.OnClickListener{

    TextView nombre;
    TextView apellidos;
    TextView nombreuserregis;
    TextView correo;
    FirebaseAuth mAuth;
    DatabaseReference userRef; //FirebaseDatabase



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiity_perfil);


        nombre = findViewById(R.id.nombrePerfil);
        apellidos = findViewById(R.id.editText);
        nombreuserregis= findViewById(R.id.textInputLayout78);
        correo= findViewById(R.id.editText2);
        mAuth= FirebaseAuth.getInstance();
        String id = mAuth.getCurrentUser().getUid();


        // Obtén la referencia al nodo del usuario en la base de datos
        userRef = FirebaseDatabase.getInstance().getReference().child("Users").child(id);

        // Agrega un listener para leer los datos del usuario en tiempo real
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                  // Muestra los datos del usuario en la interfaz de usuario
                  String name = dataSnapshot.child("name").getValue(String.class);
                  nombre.setText(name);

                  String apellido = dataSnapshot.child("apellidos").getValue(String.class);
                  apellidos.setText( apellido);

                  String correoo = dataSnapshot.child("email").getValue(String.class);
                  correo.setText(correoo);

                  String usernam = dataSnapshot.child("username").getValue(String.class);
                  nombreuserregis.setText(usernam);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Maneja el error de lectura de datos
            }
        });


        ImageButton flecha = (ImageButton) findViewById(R.id.imageButton651);
        flecha.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Principal.class);
            startActivity(intencion);
        });

        Button camPrefe = (Button) findViewById(R.id.button3313);
        camPrefe.setOnClickListener(view -> {
            Toast notification = Toast.makeText(Perfil.this, "Estamos trabajando en esta opción", Toast.LENGTH_SHORT);
            notification.show();
        });

        Button modifrece = (Button) findViewById(R.id.button1662);
        modifrece.setOnClickListener(view -> {
            Toast notification = Toast.makeText(Perfil.this, "Estamos trabajando en esta opción", Toast.LENGTH_SHORT);
            notification.show();
        });


    }

    @Override
    public void onClick(View view) {

    }

}