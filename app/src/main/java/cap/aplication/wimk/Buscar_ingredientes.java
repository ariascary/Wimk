package cap.aplication.wimk;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Buscar_ingredientes extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busc_ingredient);

        Button buscar = (Button) findViewById(R.id.button19);
        buscar.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), SegunBus.class);
            startActivity(intencion);
        });

        Button verdu = (Button) findViewById(R.id.button13);
        verdu.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), VerdurasBusq.class);
            startActivity(intencion);
        });

        Button fru = (Button) findViewById(R.id.button14);
        fru.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), FrutasBusq.class);
            startActivity(intencion);
        });

        Button Carne = (Button) findViewById(R.id.button15);
        Carne.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), CarneBusq.class);
            startActivity(intencion);
        });

        Button frutoss = (Button) findViewById(R.id.button16);
        frutoss.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), PastaBusq.class);
            startActivity(intencion);
        });

        Button otro = (Button) findViewById(R.id.button17);
        otro.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), OtroBusq.class);
            startActivity(intencion);
        });

        Button filtro = (Button) findViewById(R.id.button18);
        filtro.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), Filtros.class);
            startActivity(intencion);
        });

        ImageButton flecha = (ImageButton) findViewById(R.id.imageButton100);
        flecha.setOnClickListener(view -> {
            Intent intencion = new Intent(getApplicationContext(), VolverBusqueda.class);
            startActivity(intencion);
        });

    }

    @Override
    public void onClick(View view) {

    }
}
