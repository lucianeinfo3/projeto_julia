package com.example.projeto_julia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.projeto_julia.ViewModel.CadastroViewModel;

public class CadastroActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtUsuario;
    private EditText edtSenha;
    private EditText edtConfirmarSenha;
    private Button btnCadastrar;
    private TextView txtEntrar;

    private CadastroViewModel cadastroViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtUsuario = findViewById(R.id.edtUsuario);
        edtSenha = findViewById(R.id.edtSenha);
        edtConfirmarSenha = findViewById(R.id.edtConfirmarSenha);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        txtEntrar = findViewById(R.id.txtEntrar);

        cadastroViewModel = new ViewModelProvider(this)
                .get(CadastroViewModel.class);

        btnCadastrar.setOnClickListener(v -> {
            cadastroViewModel.cadastrar(
                    edtNome.getText().toString().trim(),
                    edtEmail.getText().toString().trim(),
                    edtUsuario.getText().toString().trim(),
                    edtSenha.getText().toString().trim(),
                    edtConfirmarSenha.getText().toString().trim()
            );
        });

        cadastroViewModel.getMensagem().observe(this, mensagem -> {
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();

            if ("Cadastro realizado com sucesso!".equals(mensagem)) {
                Intent intent = new Intent(
                        CadastroActivity.this,
                        MenuActivity.class
                );
                startActivity(intent);
                finish();
            }
        });

        txtEntrar.setOnClickListener(v -> finish());
    }
}
