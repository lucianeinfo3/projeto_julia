package com.example.projeto_julia.ViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.projeto_julia.MenuActivity;
import com.example.projeto_julia.R;
import android.widget.EditText;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private EditText usuario, senha;
    private Button botao;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.Usuario_input);
        senha = findViewById(R.id.Senha_input);
        botao = findViewById(R.id.btnLogin);

        auth = FirebaseAuth.getInstance();

        botao.setOnClickListener(v -> {

            String email = usuario.getText().toString().trim();
            String password = senha.getText().toString().trim();

            if (email.isEmpty()) {
                usuario.setError("Digite o e-mail");
                usuario.requestFocus();
                return;
            }

            if (password.isEmpty()) {
                senha.setError("Digite a senha");
                senha.requestFocus();
                return;
            }

            auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {

                        if (task.isSuccessful()) {

                            startActivity(new Intent(MainActivity.this, MenuActivity.class));
                            finish();

                        } else {

                            senha.setError("E-mail ou senha inválidos");

                        }

                    });

        });

    }
}