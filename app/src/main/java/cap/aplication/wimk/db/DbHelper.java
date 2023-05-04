package cap.aplication.wimk.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_Nombre = "wimk.bd";
    public static final String TABLE_RECETAS = "t_recetas";



    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_Nombre, null, DATABASE_VERSION);
    }

    @Override  //para crear  base de datos
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_RECETAS+ "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombreReceta TEXT NOT NULL," +
                "descripcionReceta TEXT, " +
                "eligeIngredientes TEXT," +
                "eligeEtiqueta TEXT)");
    }

    @Override //se ejecuta cuando cambie la version de la bbdd
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " +TABLE_RECETAS);
        onCreate(sqLiteDatabase);

    }
}
