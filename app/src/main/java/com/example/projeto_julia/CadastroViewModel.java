package com.example.projeto_julia.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CadastroViewModel extends ViewModel {

    private final MutableLiveData<String> mensagem = new MutableLiveData<>();

    public MutableLiveData<String> getMensagem() {
        return mensagem;
    }

    public void cadastrar(String nome, String email, String usuario,
                          String senha, String confirmarSenha) {

        if (nome.isEmpty() || email.isEmpty() || usuario.isEmpty()
                || senha.isEmpty() || confirmarSenha.isEmpty()) {

            mensagem.setValue("Preencha todos os campos!");
            return;
        }

        if (!senha.equals(confirmarSenha)) {
            mensagem.setValue("As senhas não são iguais!");
            return;
        }

        mensagem.setValue("Cadastro realizado com sucesso!");
    }
}
