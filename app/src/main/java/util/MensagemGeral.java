package util;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by Marcos on 07/12/2016.
 */

public class MensagemGeral {

    // criando um novo metodo que irá receber os parametros das outras classes e fará toda a interação
    public static void Msg (Activity activity , String mensagem){                   // por estar com o 'void' não retorna nada
        Toast.makeText(activity , mensagem , Toast.LENGTH_LONG).show();             //NÃO PODE ESQUECER DO ' .SHOW()'
    }


                            // Criando um metodo genérico que recebe vários parametros


    // para agilizar o envio de mensagens.
    public static void MsgOk(Activity activity , String titulo , String mensagem , int icone){
        AlertDialog.Builder dlg = new AlertDialog.Builder(activity) ; // criando um novo objeto e atribuindo a ele uma activity
        dlg.setTitle(titulo) ;
        dlg.setMessage(mensagem) ;
        dlg.setIcon(icone) ;
        dlg.setNeutralButton("OK" , null) ;
        dlg.show() ;
    }

    public static AlertDialog CriarAlertDialog (Activity activity){
        final CharSequence[] items = {

                "Editar",
                "Excluir",
                "Ver Mais Informações"

        } ;

        AlertDialog.Builder dlg = new AlertDialog.Builder(activity) ;
        dlg.setTitle("Opções") ;
        dlg.setItems(items , (DialogInterface.OnClickListener)activity) ;
        return dlg.create() ;
    }

    public static AlertDialog CriarDialogConfirmacao (Activity activity , String sair , String s , int i , DialogInterface.OnClickListener onClickListener){
        AlertDialog.Builder dlg =  new AlertDialog.Builder(activity) ;
        dlg.setMessage(" Tem Certeza que Deseja Excluir ?") ;
        dlg.setPositiveButton("Sim" , (DialogInterface.OnClickListener) activity) ;
        dlg.setNegativeButton("Não" , (DialogInterface.OnClickListener) activity) ;

        return dlg.create() ;
    }

    public static void MsgConfirmar(Activity activity , String titulo, String mensagem , int icone , DialogInterface.OnClickListener listener ){

        AlertDialog.Builder dlg =  new AlertDialog.Builder(activity) ;
        dlg.setTitle(titulo) ;
        dlg.setMessage(mensagem) ;
        dlg.setIcon(icone) ;
        dlg.setPositiveButton("Sim" , listener) ;
        dlg.setNegativeButton("Não" , null) ;
        dlg.show() ;


    }
}
