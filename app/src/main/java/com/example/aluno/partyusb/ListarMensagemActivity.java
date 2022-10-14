package com.example.aluno.partyusb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.aluno.partyusb.R;

import java.util.List;

import Adapter.FavoritoAdapter;
import Adapter.MensagemAdapter;
import BD.FavoritoBD;
import BD.MensagemBD;
import Interacao.Mensagem;

public class ListarMensagemActivity extends AppCompatActivity {

    private ListView lista ;
    private List<Mensagem> mensagemList ;
    private MensagemAdapter mensagemAdapter;
    private MensagemBD mensagemBD ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_mensagem);

        mensagemBD = new MensagemBD(this) ;
        mensagemList = mensagemBD.ListaMensagem() ;
        mensagemAdapter = new MensagemAdapter(this , mensagemList) ; // ta passando a lista do banco de dados para o adaptador

        lista = (ListView) findViewById(R.id.ListViewMensagem) ;
        lista.setAdapter(mensagemAdapter);
    }
}
