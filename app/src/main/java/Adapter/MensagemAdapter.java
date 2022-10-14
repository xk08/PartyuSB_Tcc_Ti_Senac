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

import Interacao.Mensagem;

/**
 * Created by Aluno on 06/12/2016.
 */
public class MensagemAdapter extends BaseAdapter {

    //Criando novos objetos
    private Context context;
    private List<Mensagem> lista;


    //Criando o metodo construtor
    public MensagemAdapter(Context ctx, List<Mensagem> mensagems) { // Recebendo por parametro e setando.
        this.context = ctx;
        this.lista = mensagems;
    }



    // Implementados Automaticamente
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

        Mensagem mensagem = lista.get(position) ;

        if (convertView == null){ //testando um componente grafico que está sendo pego pelo "getView" acima

            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) ;

            convertView = inflater.inflate(R.layout.mensagem , null) ;
        }

        TextView textView = (TextView) convertView.findViewById(R.id.mensagem_lista_mensagem) ;
        textView.setText(mensagem.getAssunto());

        return convertView;
    }
}
