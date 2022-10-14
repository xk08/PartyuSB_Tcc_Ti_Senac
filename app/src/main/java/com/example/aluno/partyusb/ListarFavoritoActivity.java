package com.example.aluno.partyusb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.aluno.partyusb.R;

import java.util.List;

import Adapter.FavoritoAdapter;
import BD.FavoritoBD;
import BD.UsuarioBD;
import Interacao.Favorito;

public class ListarFavoritoActivity extends AppCompatActivity {

    private ListView lista ;
    private List<Favorito> favoritoList ;
    private FavoritoAdapter favoritoAdapter;
    private FavoritoBD favoritoBD ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_favorito);

        favoritoBD = new FavoritoBD(this) ;
        favoritoList = favoritoBD.ListaFavorito() ;
        favoritoAdapter = new FavoritoAdapter(this , favoritoList) ; // ta passando a lista do banco de dados para o adaptador

        lista = (ListView) findViewById(R.id.ListViewUsuario) ;
        lista.setAdapter(favoritoAdapter);
    }
}
