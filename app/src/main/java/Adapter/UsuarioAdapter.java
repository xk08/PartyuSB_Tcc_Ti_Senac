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

import Interacao.Endereco;
import Interacao.Evento;
import Interacao.Usuario;

/**
 * Created by Marcos Martins on 06/12/2016.
 */
public class UsuarioAdapter extends BaseAdapter {

    //Criando novos objetos
    private Context context;
    private List<Usuario> lista;


    //Criando o metodo construtor
    public UsuarioAdapter(Context ctx, List<Usuario> usuarios) { // Recebendo por parametro e setando.
        this.context = ctx;
        this.lista = usuarios;
    }


    // Metodos Implementados Automaticamente
    @Override
    public int getCount() {
        return lista.size(); // pega o valor de tamanho total da lista
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

        Usuario usuario = lista.get(position);

        if (convertView == null) { //testando um componente grafico que está sendo pego pelo "getView" acima

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.usuario, null);
        }



        /* AINDA NÃO É POSSIVEL CHAMAR INFORMAÇÕES DE OUTRAS TABELAS E ENVIAR PARA O TEXTVIEW E LISTVIEW  */

        TextView textView = (TextView) convertView.findViewById(R.id.usuario_lista_usuario);
        textView.setText("ID : "+ usuario.getIdUsuario()+"\n\nNOME: " + usuario.getNome_sobrenome() + "\n\nCPF: " + usuario.getCpf() + "\n\nTELEFONE:" + usuario.getTelefone() + "\n\nEMAIL: " + usuario.getEmail() +
                "\n\nSEXO:" + usuario.getSexo() +
                "\n\nNICK NAME: " + usuario.getNick_name() + "\n\nSENHA: " + usuario.getSenha()+"\n\nDATA NASCIMENTO: "+usuario.getData_de_nascimento()+"  \n\n                    - - - - - - - - - - - -    ");

        return convertView ;
    }

}




























