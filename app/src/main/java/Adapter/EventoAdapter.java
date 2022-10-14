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

import BD.EnderecoBD;
import Interacao.Endereco;
import Interacao.Evento;

/**
 * Created by Marcos Martins on 06/12/2016.
 */
public class EventoAdapter extends BaseAdapter {


    //Criando novos objetos
    private Context context;
    private List<Evento> lista;


    //Criando o metodo construtor
    public EventoAdapter(Context ctx, List<Evento> eventos) { // Recebendo por parametro e setando.
        this.context = ctx;
        this.lista = eventos;
    }


    // Metodos Automaticos
    @Override
    public int getCount() {
        return lista.size() ;// pega o valor de tamanho total da lista
    }


    @Override
    public Object getItem(int position) {
        return lista.get(position) ;  // pegando da lista , algo de uma determinada posição que se quer
    }

    @Override
    public long getItemId(int position) {
        return position; //recebe por parametro uma posição e retorna ela
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Evento evento = lista.get(position) ;

        if (convertView == null){ //testando um componente grafico que está sendo pego pelo "getView" acima

            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) ;

            convertView = inflater.inflate(R.layout.evento , null) ;
        }

        // ESTA PARTE DO CODIGO É RESPONSÁVEL POR ENVIAR PARA P TEXVIEW QUE LISTA OS EVENTOS

        ImageView imageView = (ImageView) convertView.findViewById(R.id.evento_ImagemEvento) ;
        imageView.setImageResource(R.drawable.th); // Futuramente irá pegar do banco

        TextView textView = (TextView) convertView.findViewById(R.id.evento_lista_evento) ;
                textView.setText("Nome do Evento: "+evento.getNome_evento().toString()+"\nPreço: "+evento.getPreco_evento()+" R$");
        //TENTAR LISTAR OS BAIRROS

        return convertView;
    }


}










