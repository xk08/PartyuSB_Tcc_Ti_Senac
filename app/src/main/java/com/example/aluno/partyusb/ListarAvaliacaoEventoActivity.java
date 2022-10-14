package com.example.aluno.partyusb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.aluno.partyusb.R;

import java.util.List;

import Adapter.AvaliacaoEventoAdapter;
import Adapter.UsuarioAdapter;
import BD.AvaliacaoEventoBD;
import BD.UsuarioBD;
import Interacao.AvaliacaoEvento;

public class ListarAvaliacaoEventoActivity extends AppCompatActivity {

    private ListView lista ;
    private List<AvaliacaoEvento> avaliacaoEventoList ;
    private AvaliacaoEventoAdapter avaliacaoEventoAdapter;
    private AvaliacaoEventoBD avaliacaoEventoBD ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_avaliacao_evento);

        avaliacaoEventoBD = new AvaliacaoEventoBD(this) ;
        avaliacaoEventoList = avaliacaoEventoBD.ListaAvaliacaoEvento() ;
        avaliacaoEventoAdapter = new AvaliacaoEventoAdapter(this , avaliacaoEventoList) ; // ta passando a lista do banco de dados para o adaptador

        lista = (ListView) findViewById(R.id.ListViewAvaliacaoEvento) ;
        lista.setAdapter(avaliacaoEventoAdapter);
    }
}
