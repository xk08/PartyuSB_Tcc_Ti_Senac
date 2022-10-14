package com.example.aluno.partyusb;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

        import com.example.aluno.partyusb.R;

        import java.util.List;

        import Adapter.EventoAdapter;
        import BD.EventoBD;
        import Interacao.Evento;
import util.MensagemGeral;

public class ListarEventoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, DialogInterface.OnClickListener{

    private ListView lista;
    private List<Evento> eventoList ;
    private EventoAdapter eventoAdapter ;
    private EventoBD eventoBD ;

    private int idPosicao;
    private AlertDialog alertDialog, alertConfirmacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_evento);

        // POLEMICA => ESSE CODIGO À BAIXO, NÃO ESTÁ NO SLIDE MATERIAL DEIXADO PELO WILLIAM
        alertDialog = MensagemGeral.CriarAlertDialog(this);

        alertConfirmacao = MensagemGeral.CriarDialogConfirmacao(this, "Sair", "Deseja Realmente Sair", R.drawable.fb, new DialogInterface.OnClickListener() {

            // Metodo Gerado Automaticamnete pelo " new DialogInterface.OnClickListener() " Acima'!
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });



        eventoBD = new EventoBD(this) ;
        eventoList = eventoBD.ListaEvento() ;
        eventoAdapter = new EventoAdapter(this , eventoList) ; // ta passando a lista do banco de dados para o adaptador

        lista = (ListView) findViewById(R.id.ListViewEvento) ;
        lista.setAdapter(eventoAdapter);

        lista.setOnItemClickListener(this); // Setando a maneira SetonClick para interagir com a lista.
    }


    //Metodos gerados automaticamente pelo "Implemets"
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        idPosicao = position ;
        alertDialog.show() ;

    }

    @Override
    public void onClick(DialogInterface dialog, int which) { //recebendo por parametros o que foi clicado
        int id  =  eventoList.get(idPosicao).getIdEvento() ; // enviando para id o a a posição do id que foi capturado pelo onclick

        switch (which){

            case 0 : //Editar
                Intent intent = new Intent(this , CriarEventoActivity.class) ;
                intent.putExtra("EVENTO_ID" , id) ; // no putExtra se utiliza (String name e short Value)
                startActivity(intent);
                finish();
                break ;

            case 1 :
                alertConfirmacao.show();
                break ;

            //Remove os Usuarios pela posição do ID
            case  DialogInterface.BUTTON_POSITIVE:
                eventoList.remove(idPosicao) ; //Remove apenas da lista o o usuario de acordo com o ID
                eventoBD.removerEvento(id) ; // Remove do Banco de Dados o usuário de acordo com o ID
                lista.invalidateViews(); // Atualiza os dados depois de feito as remoções.
                break ;

            case DialogInterface.BUTTON_NEGATIVE:
                alertConfirmacao.dismiss(); // comando que faz com que ela não seja exibida, saia fora do alert confirmation.
                break ;

            case 2:
                intent = new Intent(this , MostrarEventosActivity.class) ;
                intent.putExtra("EVENTO_ID" , id) ; // no putExtra se utiliza (String name e short Value)
                startActivity(intent);
                finish();
               break ;

        }

    }
}
