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

import Interacao.AvaliacaoEvento;

/**
 * Created by Marcos Martins on 06/12/2016.
 */
public class AvaliacaoEventoAdapter extends BaseAdapter {

    //Criando novos objetos
    private Context context;
    private List<AvaliacaoEvento> lista;


    //Criando o metodo construtor
    public AvaliacaoEventoAdapter(Context ctx, List<AvaliacaoEvento> avaliacaoEventos) { // Recebendo por parametro e setando.
        this.context = ctx;
        this.lista = avaliacaoEventos;
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

        AvaliacaoEvento avaliacaoEvento = lista.get(position) ;

        if (convertView == null){ //testando um componente grafico que está sendo pego pelo "getView" acima

            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) ;

            convertView = inflater.inflate(R.layout.avaliacaoevento , null) ;
        }

        TextView textView = (TextView) convertView.findViewById(R.id.avaliacaoevento_lista_avaliacaoevento) ;
        textView.setText(avaliacaoEvento.getNota().toString());

        return convertView;
    }
}
