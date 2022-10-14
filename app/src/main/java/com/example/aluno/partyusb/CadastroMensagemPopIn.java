package com.example.aluno.partyusb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import BD.MensagemBD;
import Interacao.Mensagem;
import util.MensagemGeral;

/**
 * Created by Marcos Martins on 13/12/2016.
 */

public class CadastroMensagemPopIn extends AppCompatActivity implements View.OnClickListener {

    private TextView popin_textview_MensagemTitulo;
    private TextView popin_textview_MensagemDescricao;
    private TextView popin_textview_Assunto;
    private TextView popin_textview_Descricao;

    private EditText popin_edittext_Assunto;
    private EditText popin_edittext_Descricao;

    private Button popin_button_EnviarMensagem;

    private Mensagem mensagem;
    private MensagemBD mensagemBD;
    private int idMensagem;   // Ver porque não está sendo atualizado


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popin_mensagem);

        mensagemBD = new MensagemBD(this);

        popin_textview_MensagemTitulo = (TextView) findViewById(R.id.popin_textview_MensagemTitulo);
        popin_textview_MensagemDescricao = (TextView) findViewById(R.id.popin_textview_MensagemDescricao);
        popin_textview_Assunto = (TextView) findViewById(R.id.popin_textview_Assunto);
        popin_textview_Descricao = (TextView) findViewById(R.id.popin_textview_Descricao);

        popin_edittext_Assunto = (EditText) findViewById(R.id.popin_edittext_Assunto);
        popin_edittext_Descricao = (EditText) findViewById(R.id.popin_edittext_Descricao);

        popin_button_EnviarMensagem = (Button) findViewById(R.id.popin_button_EnviarMensagem);
        popin_button_EnviarMensagem.setOnClickListener(this);

    }

        //--------------------

    public void cadastrarMensagem() {

        boolean validacao = true;

        String assunto = popin_edittext_Assunto.getText().toString();
        String descricao = popin_edittext_Descricao.getText().toString();


        if (validacao) {
            mensagem = new Mensagem();

            mensagem.setAssunto(assunto);
            mensagem.setDescricao(descricao);

            // Se for alteração
            if (idMensagem > 0) {
                mensagem.setIdMensagem(idMensagem);
            }

            long resultado = mensagemBD.salvarMensagem(mensagem);

            if (resultado != -1) {
                if (idMensagem > 0) {
                    MensagemGeral.Msg(this, getString(R.string.mensagem_atualizar));

                    // Se for Cadastrar
                } else {
                    //this.cadastrarMensagem();
                }
                finish();
                //startActivity(new Intent(this, ListarMensagemActivity.class));


                // Se for dar algum Erro
            } else {
                MensagemGeral.Msg(this, getString(R.string.mensagem_erro));
            }

        }
    }




    @Override
    public void onClick(View v) {

        if (popin_button_EnviarMensagem.isPressed()) {
           
            this.cadastrarMensagem();

            startActivity(new Intent(this, ListarMensagemActivity.class));
        }
    }
}




