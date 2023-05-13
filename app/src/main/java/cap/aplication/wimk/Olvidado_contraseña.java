package cap.aplication.wimk;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Olvidado_contraseña  extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvidado_contrasena);

        FirebaseAuth mAuth= FirebaseAuth.getInstance();

        EditText emailolvidcontrasena;
        emailolvidcontrasena= findViewById(R.id.nombreuserlogin);

        Button enviar_correo = (Button)  findViewById(R.id.registro2);
        enviar_correo.setOnClickListener(view -> {
            mAuth.sendPasswordResetEmail(emailolvidcontrasena.getText().toString()).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(Olvidado_contraseña.this, "Revisa tu correo para resetear tu contraseña", Toast.LENGTH_LONG).show();
                    enviar_correo.setVisibility(View.INVISIBLE);
                }
            });
        });

        ImageButton flecha1 = (ImageButton)  findViewById(R.id.imageButton31);
        flecha1.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), InicioSesion.class);
            startActivity(intencion);
        });

    }

    @Override
    public void onClick(View view) {

    }
}
