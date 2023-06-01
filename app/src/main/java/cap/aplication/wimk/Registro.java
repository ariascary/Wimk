package cap.aplication.wimk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    //ImageView imageButton51;
    EditText nombre;
    EditText apellidos;
    EditText nombreuserregis;
    EditText correo;
    EditText contrasena;
    EditText repetircontra;
    Button crearPerfil;
    FirebaseAuth mAuth;
    //FirebaseFirestore firestone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = findViewById(R.id.nombre);
        apellidos = findViewById(R.id.apellidos);
        nombreuserregis = findViewById(R.id.nombreuserregis);
        correo = findViewById(R.id.correo);
        contrasena = findViewById(R.id.contrasenalogin);
        repetircontra = findViewById(R.id.repetircontra);
        crearPerfil = findViewById(R.id.registro2);
        mAuth = FirebaseAuth.getInstance();
        //firestone= FirebaseFirestore.getInstance();


        ImageButton flecha1 = (ImageButton) findViewById(R.id.imageButton51);
        flecha1.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), ArrancaApp.class);
            startActivity(intencion);
        });

        crearPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();

            }
        });

        ImageButton confi = (ImageButton) findViewById(R.id.imageButton50);
        confi.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Configuracion.class);
            startActivity(intencion);
        });

    }

    private void register() {
        String nombreUser = nombre.getText().toString();
        String apellidoslUser = apellidos.getText().toString();
        String nameUser = nombreuserregis.getText().toString();
        String contrasenaUser = contrasena.getText().toString();
        String emailUser = correo.getText().toString();
        String repetircontraUser = repetircontra.getText().toString();

        if (!nameUser.isEmpty() && !emailUser.isEmpty() && !contrasenaUser.isEmpty() && !repetircontraUser.isEmpty()) {
            if (isEmailValid(emailUser)) {
                if (contrasenaUser.equals(repetircontraUser)) {
                    if (contrasenaUser.length() > 5) {
                        createUser(nombreUser, apellidoslUser, nameUser, emailUser, contrasenaUser, repetircontraUser);
                    } else {
                        Toast.makeText(Registro.this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(Registro.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }


            } else {
                Toast.makeText(Registro.this, "El correo no es valido", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(Registro.this, "Para continuar inserta todos los campos", Toast.LENGTH_SHORT).show();
        }


    }

    private void createUser(String nombreUser, String apellidoslUser, String nameUser, String emailUser, String contrasenaUser, String repetircontraUser) {
        mAuth.createUserWithEmailAndPassword(emailUser, contrasenaUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String id = mAuth.getCurrentUser().getUid();
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", id);
                    map.put("name", nombreUser);
                    map.put("apellidos", apellidoslUser);
                    map.put("username", nameUser);
                    map.put("email", emailUser);
                    map.put("password", contrasenaUser);
                    map.put("passwordagain", repetircontraUser);
                    // firestone.collection("Users").document(id).set(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid()).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    Intent i = new Intent(Registro.this, InicioSesion.class);
                                    startActivity(i);
                                    Toast.makeText(Registro.this, "Usuario almacenado correctamente", Toast.LENGTH_SHORT).show();


                                }
                            });
                } else {
                    Toast.makeText(Registro.this, "No se pudo registrar", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public boolean isEmailValid(String email) {
        String expresion = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern patern = Pattern.compile(expresion, Pattern.CASE_INSENSITIVE);
        Matcher matcher = patern.matcher(email);
        return matcher.matches();
    }

    @Override
    public void onClick(View view) {

    }
}