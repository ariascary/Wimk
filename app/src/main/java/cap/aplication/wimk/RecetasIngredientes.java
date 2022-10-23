package cap.aplication.wimk;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import cap.aplication.wimk.databinding.ActivityRecetasIngredientesBinding;

public class RecetasIngredientes extends AppCompatActivity implements View.OnClickListener{

    private ImageButton imagen1;
    private ImageButton imagen2;
    private AppBarConfiguration mAppBarConfiguration;

private ActivityRecetasIngredientesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityRecetasIngredientesBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarRecetasIngredientes.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_recetas_ingredientes);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);



        imagen1=(ImageButton) findViewById(R.id.imageButton80);
        imagen1.setOnClickListener(view ->  {
            Intent intencion = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intencion);
        });

        imagen2=(ImageButton) findViewById(R.id.imageButton81);
        imagen2.setOnClickListener(view ->  {
            Intent intencion1 = new Intent(getApplicationContext(), Configuracion.class);
            startActivity(intencion1);
        });




    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.recetas_ingredientes, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_recetas_ingredientes);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public void onClick(View view) {

    }
}