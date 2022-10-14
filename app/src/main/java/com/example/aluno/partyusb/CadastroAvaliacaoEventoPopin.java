package com.example.aluno.partyusb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import BD.AvaliacaoEventoBD;
import BD.Conexao;
import Interacao.AvaliacaoEvento;
import util.MensagemGeral;

/**
 * Created by Aluno on 13/12/2016.
 */

public class CadastroAvaliacaoEventoPopin extends AppCompatActivity implements View.OnClickListener {

    private TextView popin_textview_AvaliacaoEvento;
    private TextView popin_textview_AvaliacaoEventoDescricao;
    private TextView popin_textview_NotaEvento;
    private TextView popin_textview_EventoComentario;

    private EditText popin_edittext_ComentarioEvento;

    private RatingBar popin_ratingbar_NotaEvento ;

    private Button popin_button_AvaliarEvento;

    private AvaliacaoEvento avaliacaoEvento;
    private AvaliacaoEventoBD avaliacaoEventoBD;
    private int idAvaliacaoEvento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popin_avaliacaoevento);

        avaliacaoEventoBD = new AvaliacaoEventoBD(this);

        popin_textview_AvaliacaoEvento = (TextView) findViewById(R.id.popin_textview_AvaliacaoEvento);
        popin_textview_AvaliacaoEventoDescricao = (TextView) findViewById(R.id.popin_textview_AvaliacaoEventoDescricao);
        popin_textview_NotaEvento = (TextView) findViewById(R.id.popin_textview_NotaEvento);
        popin_textview_EventoComentario = (TextView) findViewById(R.id.popin_textview_EventoComentario);

        popin_edittext_ComentarioEvento = (EditText) findViewById(R.id.popin_edittext_ComentarioEvento);
        popin_ratingbar_NotaEvento = (RatingBar) findViewById(R.id.popin_ratingbar_NotaEvento);

        popin_button_AvaliarEvento = (Button) findViewById(R.id.popin_button_AvaliarEvento);
        popin_button_AvaliarEvento.setOnClickListener(this);
    }

    //--------------------

    public void cadastrarAvaliacaoEvento() {

        boolean validacao = true;

        // FALTA VER COMO QUE SE PEGA O R A T I N G    B A R
        String comentario = popin_edittext_ComentarioEvento.getText().toString();
        //String nota_evento = popin_ratingbar_NotaEvento.getText().toString() ;

        if (validacao) {
            avaliacaoEvento = new AvaliacaoEvento();











            //TEM QUE VER COMO QUE PEGA ESSA PARTE
            avaliacaoEvento.setComentario(comentario);
            //avaliacaoEvento.setNota(nota);

            // Se for alteração
            if (idAvaliacaoEvento > 0) {
                avaliacaoEvento.setIdAvalicaoEvento(idAvaliacaoEvento);
            }

            long resultado = avaliacaoEventoBD.salvarAvaliacaoEvento(avaliacaoEvento);

            if (resultado != -1) {
                if (idAvaliacaoEvento > 0) {
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

        if (popin_button_AvaliarEvento.isPressed()) {

            this.cadastrarAvaliacaoEvento();

            startActivity(new Intent(this, ListarAvaliacaoEventoActivity.class));
        }
    }
}