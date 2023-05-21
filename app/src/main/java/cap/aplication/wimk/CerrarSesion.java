package cap.aplication.wimk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class CerrarSesion extends AppCompatActivity implements View.OnClickListener{

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerrar_sesion);


        Button no = (Button)  findViewById(R.id.button3);
        no.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Principal.class);
            startActivity(intencion);


        });
        mAuth= FirebaseAuth.getInstance();
        Button cerrarsesion = (Button)  findViewById(R.id.button2);
        cerrarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent intencion = new Intent(CerrarSesion.this, ArrancaApp.class);
                startActivity(intencion);
                finish();
                Toast.makeText(CerrarSesion.this, "Has cerrado sesión", Toast.LENGTH_SHORT);

            }

        });


    }

    @Override
    public void onClick(View view) {

    }

}