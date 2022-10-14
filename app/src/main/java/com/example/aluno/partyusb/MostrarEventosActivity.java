package com.example.aluno.partyusb;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import Adapter.EventoAdapter;
import Adapter.MostarEventoAdapter;
import BD.EventoBD;
import Interacao.Evento;
import util.MensagemGeral;

public class MostrarEventosActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView evento_popin_mensagem ;
    private TextView evento_popin_avaliar ;

    private ListView lista;
    private List<Evento> eventoList;
    private MostarEventoAdapter mostarEventoAdapter ;
    private EventoBD eventoBD;
    private int idEvento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_eventos);

        evento_popin_mensagem = (TextView) findViewById(R.id.evento_popin_mensagem) ;
        evento_popin_avaliar = (TextView) findViewById(R.id.evento_popin_avaliar) ;



        evento_popin_avaliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MostrarEventosActivity.this, PopinAvaliacaoEvento.class));

            }
        });

        evento_popin_mensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MostrarEventosActivity.this, PopinEnviarMensagem.class));
            }
        });



                idEvento = getIntent().getIntExtra("EVENTO_ID",0);


        eventoBD = new EventoBD(this);
        eventoList = eventoBD.ListaEventoUnico(idEvento);
        mostarEventoAdapter = new MostarEventoAdapter(this, eventoList); // ta passando a lista do banco de dados para o adaptador


        lista = (ListView) findViewById(R.id.ListViewMostrarEvento);
        lista.setAdapter(mostarEventoAdapter);
    }

    @Override
    public void onClick(View v) {

        }
}





