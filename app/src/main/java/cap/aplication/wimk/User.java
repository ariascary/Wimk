package cap.aplication.wimk;

import androidx.appcompat.app.AppCompatActivity;

public class User extends AppCompatActivity {
    private String name;
    private String email;
    private String apellidos;
    private String username;
    private String id;
    private String password;
    private String passwordagain;

    public User() {
        // Constructor vacío requerido para Firebase
    }

    public User(String apellidos, String email, String id, String name, String password, String passwordagain, String username) {
        this.name = name;
        this.email = email;
        this.apellidos = apellidos;
        this.username = username;
        this.id = id;
        this.password = password;
        this.passwordagain = passwordagain;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordagain() {
        return passwordagain;
    }

    public String getUsername() {
        return username;
    }


}

