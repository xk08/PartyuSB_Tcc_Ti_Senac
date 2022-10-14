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

import Interacao.AvaliacaoOrganizador;

/**
 * Created by Marcos Martins on 06/12/2016.
 */
public class AvaliacaoOrganizadorAdapter extends BaseAdapter{

    //Criando novos objetos
    private Context context;
    private List<AvaliacaoOrganizador> lista;


    //Criando o metodo construtor
    public AvaliacaoOrganizadorAdapter(Context ctx, List<AvaliacaoOrganizador> avaliacaoOrganizadors) { // Recebendo por parametro e setando.
        this.context = ctx;
        this.lista = avaliacaoOrganizadors;
    }

    //Implementados Automaticamente
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

        AvaliacaoOrganizador avaliacaoOrganizador = lista.get(position) ;

        if (convertView == null){ //testando um componente grafico que está sendo pego pelo "getView" acima

            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) ;

            convertView = inflater.inflate(R.layout.avaliacaoorganizador , null) ;
        }




        TextView textView = (TextView) convertView.findViewById(R.id.avaliacaoorganizador_lista_avaliacaoorganizador) ;
        textView.setText(avaliacaoOrganizador.getComentario());


        return convertView;

    }
}
