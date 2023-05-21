package cap.aplication.wimk;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class InicioSesion extends AppCompatActivity implements View.OnClickListener{

    Button registro2;
    EditText nombreuserlogin;
    EditText contrasenalogin;
    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        ImageButton flecha1 = (ImageButton)  findViewById(R.id.imageButton31);
        flecha1.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), ArrancaApp.class);
            startActivity(intencion);
        });

        ImageButton Confi = (ImageButton)  findViewById(R.id.imageButton30);
        Confi.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), ConfiInicio.class);
            startActivity(intencion);
        });

        Button guardar = (Button)  findViewById(R.id.button);
        guardar.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Olvidado_contraseña.class);
            startActivity(intencion);
        });


        nombreuserlogin= findViewById(R.id.nombreuserlogin);
        contrasenalogin= findViewById(R.id.contrasenalogin);
        registro2 = findViewById(R.id.registro2);
        mAuth= FirebaseAuth.getInstance();
        registro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();

            }


        });
    }

    private void login(){
        String emaillogin= nombreuserlogin.getText().toString();
        String contraseloging= contrasenalogin.getText().toString();
        if (!emaillogin.isEmpty() && !contraseloging.isEmpty()) {
            mAuth.signInWithEmailAndPassword(emaillogin, contraseloging).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Intent i = new Intent(InicioSesion.this, Principal.class);
                    startActivity(i);
                } else {
                    Toast.makeText(InicioSesion.this, "El correo o contraseña son incorrectas ", Toast.LENGTH_SHORT).show();
                }
            });
        }else{

            Toast.makeText(InicioSesion.this, "Para continuar inserta todos los campos", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onClick(View view) {

    }
}