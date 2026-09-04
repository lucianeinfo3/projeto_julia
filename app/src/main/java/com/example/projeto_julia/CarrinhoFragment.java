package com.example.projeto_julia;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CarrinhoActivity extends AppCompatActivity {

    TextView txtTotal;
    Button btnFinalizar;

    // Valores exemplo (depois você pode mudar)
    double precoRosa = 10.0;
    double precoGirassol = 15.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        txtTotal = findViewById(R.id.txtTotal);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        // Calcula total
        double total = precoRosa + precoGirassol;

        txtTotal.setText("Total: R$ " + total);

        // Botão finalizar
        btnFinalizar.setOnClickListener(v -> {
            Toast.makeText(this, "Compra finalizada 💖", Toast.LENGTH_SHORT).show();
        });
    }
}