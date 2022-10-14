package Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aluno.partyusb.R;

import java.util.List;

import Interacao.Favorito;
import Interacao.Usuario;

/**
 * Created by Marcos Martins on 06/12/2016.
 */
public class FavoritoAdapter extends BaseAdapter {

    //Criando novos objetos
    private Context context;
    private List<Favorito> lista;


    //Criando o metodo construtor
    public FavoritoAdapter(Context ctx, List<Favorito> favoritos) { // Recebendo por parametro e setando.
        this.context = ctx;
        this.lista = favoritos;
    }


    // Metodos implementados Automaticamente
    @Override
    public int getCount() {
        return lista.size();  // pega o valor de tamanho total da lista
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Favorito favorito = lista.get(position) ;

        if (convertView == null){ //testando um componente grafico que está sendo pego pelo "getView" acima

            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) ;

            convertView = inflater.inflate(R.layout.favorito , null) ;
        }

        TextView textView = (TextView) convertView.findViewById(R.id.favorito_lista_favorito) ;
        textView.setText(favorito.getIdFavorito());

        return convertView;
    }
}
