package com.example.projeto_julia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    Button btnCatalogo, btnCarrinho, btnPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnCatalogo = findViewById(R.id.btnCatalogo);
        btnCarrinho = findViewById(R.id.btnCarrinho);
        btnPerfil = findViewById(R.id.btnPerfil);

        btnCatalogo.setOnClickListener(v ->
                startActivity(new Intent(this, CatalogoActivity.class)));

        btnCarrinho.setOnClickListener(v ->
                startActivity(new Intent(this, CarrinhoActivity.class)));

        btnPerfil.setOnClickListener(v ->
                startActivity(new Intent(this, PerfilActivity.class)));
    }
}
