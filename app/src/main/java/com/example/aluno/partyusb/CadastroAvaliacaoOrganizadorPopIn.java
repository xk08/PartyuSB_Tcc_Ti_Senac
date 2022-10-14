package com.example.aluno.partyusb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import BD.AvaliacaoOrganizadorBD;
import Interacao.AvaliacaoOrganizador;
import util.MensagemGeral;

/**
 * Created by Marcos Gronytzki on 13/12/2016.
 */

public class CadastroAvaliacaoOrganizadorPopIn extends AppCompatActivity implements View.OnClickListener {

    private TextView popin_textview_AvaliacaoOrganizador;
    private TextView popin_textview_AvaliacaoOrganizadorDescricao;
    private TextView popin_textview_NotaOrganizador;
    private TextView popin_textview_OrganizadorComentario;

    private EditText popin_edittext_ComentarioOrganizador;

    private RatingBar popin_ratingbar_NotaOrganizador ;

    private Button popin_button_AvaliarOrganizador;

    private AvaliacaoOrganizador avaliacaoOrganizador;
    private AvaliacaoOrganizadorBD avaliacaoOrganizadorBD;
    private int idAvaliacaoOrganizador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popin_avaliacaoevento);

        avaliacaoOrganizadorBD = new AvaliacaoOrganizadorBD(this);

        popin_textview_AvaliacaoOrganizador = (TextView) findViewById(R.id.popin_textview_AvaliacaoOrganizador);
        popin_textview_AvaliacaoOrganizadorDescricao = (TextView) findViewById(R.id.popin_textview_AvaliacaoOrganizadorDescricao);
        popin_textview_NotaOrganizador = (TextView) findViewById(R.id.popin_textview_NotaOrganizador);
        popin_textview_OrganizadorComentario = (TextView) findViewById(R.id.popin_textview_OrganizadorComentario);

        popin_edittext_ComentarioOrganizador = (EditText) findViewById(R.id.popin_edittext_ComentarioOrganizador);

        popin_ratingbar_NotaOrganizador = (RatingBar) findViewById(R.id.popin_ratingbar_NotaOrganizador);

        popin_button_AvaliarOrganizador = (Button) findViewById(R.id.popin_button_AvaliarOrganizador);
                    popin_button_AvaliarOrganizador.setOnClickListener(this);
    }

    //--------------------

    public void cadastrarAvaliacaoOrganizador() {

        boolean validacao = true;












        // FALTA VER COMO QUE SE PEGA O R A T I N G    B A R
        String comentario = popin_edittext_ComentarioOrganizador.getText().toString();
        //String nota_organizador = popin_ratingbar_NotaOrganizador.getText().toString() ;

        if (validacao) {
            avaliacaoOrganizador = new AvaliacaoOrganizador();

            avaliacaoOrganizador.setComentario(comentario);
            //avaliacaoOrganizador.setNota(nota_organizador);                     TEM QUE VER COMO QUE PEGA ESSA PARTE

            // Se for alteração
            if (idAvaliacaoOrganizador > 0) {
                avaliacaoOrganizador.setIdAvaliacao(idAvaliacaoOrganizador);
            }

            long resultado = avaliacaoOrganizadorBD.salvarAvaliacaoOrganizador(avaliacaoOrganizador);

            if (resultado != -1) {
                if (idAvaliacaoOrganizador > 0) {
                    MensagemGeral.Msg(this, getString(R.string.mensagem_atualizar));

                    // Se for Cadastrar
                } else {
                    //this.cadastrarMensagem();
                }
                finish();
                startActivity(new Intent(this, ListarAvaliacaoEventoActivity.class));


                // Se for dar algum Erro
            } else {
                MensagemGeral.Msg(this, getString(R.string.mensagem_erro));
            }

        }
    }


    @Override
    public void onClick(View v) {

        if (popin_button_AvaliarOrganizador.isPressed()) {

            this.cadastrarAvaliacaoOrganizador();

            startActivity(new Intent(this, ListarAvaliacaoOrganizadorActivity.class));
        }
    }
}


