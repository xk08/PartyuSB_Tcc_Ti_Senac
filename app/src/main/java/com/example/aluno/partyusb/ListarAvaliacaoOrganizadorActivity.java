package com.example.aluno.partyusb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.aluno.partyusb.R;

import java.util.List;

import Adapter.AvaliacaoEventoAdapter;
import Adapter.AvaliacaoOrganizadorAdapter;
import BD.AvaliacaoEventoBD;
import BD.AvaliacaoOrganizadorBD;
import Interacao.AvaliacaoOrganizador;

public class ListarAvaliacaoOrganizadorActivity extends AppCompatActivity {

    private ListView lista ;
    private List<AvaliacaoOrganizador> avaliacaoOrganizadorList ;
    private AvaliacaoOrganizadorAdapter avaliacaoOrganizadorAdapter;
    private AvaliacaoOrganizadorBD avaliacaoOrganizadorBD ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_avaliacao_organizador);

        avaliacaoOrganizadorBD = new AvaliacaoOrganizadorBD(this) ;
        avaliacaoOrganizadorList = avaliacaoOrganizadorBD.ListaAvaliacaoOrganizador() ;
        avaliacaoOrganizadorAdapter = new AvaliacaoOrganizadorAdapter(this , avaliacaoOrganizadorList) ; // ta passando a lista do banco de dados para o adaptador

        lista = (ListView) findViewById(R.id.ListViewAvaliacaoOrganizador) ;
        lista.setAdapter(avaliacaoOrganizadorAdapter);
    }
}
