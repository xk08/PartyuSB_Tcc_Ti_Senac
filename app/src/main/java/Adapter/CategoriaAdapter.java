package Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aluno.partyusb.R;

import java.util.List;

import Interacao.Categoria;
import Interacao.Favorito;

/**
 * Created by Aluno on 13/12/2016.
 */

public class CategoriaAdapter extends BaseAdapter {


    //Criando novos objetos
    private Context context;
    private List<Categoria> lista;


    //Criando o metodo construtor
    public CategoriaAdapter(Context ctx, List<Categoria> categorias) { // Recebendo por parametro e setando.
        this.context = ctx;
        this.lista = categorias;
    }



    @Override
    public int getCount() {
        return lista.size();
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

        Categoria categoria = lista.get(position) ;

        if (convertView == null){ //testando um componente grafico que está sendo pego pelo "getView" acima

            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) ;

            convertView = inflater.inflate(R.layout.categoria , null) ;
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.categoria_ImagemCategoria) ;
        imageView.setImageResource(R.drawable.rp); // Futuramente irá pegar do banco

        TextView textView = (TextView) convertView.findViewById(R.id.categoria_lista_categoria) ;
        textView.setText(categoria.getNome_categoria());

        return convertView;
    }
}
