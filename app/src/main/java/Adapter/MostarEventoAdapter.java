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

import Interacao.Evento;

/**
 * Created by Aluno on 14/12/2016.
 */

public class MostarEventoAdapter extends BaseAdapter {

    //Criando novos objetos
    private Context context;
    private List<Evento> lista;


    //Criando o metodo construtor
    public MostarEventoAdapter(Context ctx, List<Evento> mostrareventos) { // Recebendo por parametro e setando.
        this.context = ctx;
        this.lista = mostrareventos;
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

            convertView = inflater.inflate(R.layout.mostraeventos , null) ;
        }

        // ESTA PARTE DO CODIGO É RESPONSÁVEL POR ENVIAR PARA P TEXVIEW QUE LISTA OS EVENTOS

        ImageView imageView = (ImageView) convertView.findViewById(R.id.evento_ImagemMostrarEvento) ;
        imageView.setImageResource(R.drawable.sn); // Futuramente irá pegar do banco

        TextView textView = (TextView) convertView.findViewById(R.id.mostrarevento_lista_mostrarevento) ;
        textView.setText("Nome do Evento: "+evento.getNome_evento().toString()+"\n\nPreço: "+evento.getPreco_evento()+" R$"+"\n\nData: "+evento.getData_evento()+"\n\nEstatus: "+evento.getStatistica_evento()+
                "\n\nHora Inicial: "+evento.getHora_inicial_evento()+"\n\nHora Final: "+evento.getHora_final_evento()+"\n \nDescricao: "+evento.getDescricao_evento());

        //TENTAR PEGAR MAIS INFORMAÇÕES DE ENDEREÇO


        return convertView;
    }
}
