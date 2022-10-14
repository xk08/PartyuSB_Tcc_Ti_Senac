package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Interacao.Mensagem;

/**
 * Created by Marcos Martins on 02/12/2016.
 */

public class MensagemBD {

    // criado uma variavel para abrir e manipular o Banco de Dados
    private Conexao dataBaseHelper ;


    //Criando variavel que Permite que interações sejam feitas no Banco IMPORTA AUTOMATICAMENTE
    private SQLiteDatabase sqLiteDatabase;


    //criando o metodo contrutor ou Instanciando -> Recebe por padrão um contexto
    public MensagemBD(Context context) { //Ira passar qual Activity que está chamando esta classe
        dataBaseHelper = new Conexao(context); // abrindo o banco de dados.
    }


    //Metodo com Retorno então não usa-se VOID
    public SQLiteDatabase getDataBase() {

        if (sqLiteDatabase == null){
            sqLiteDatabase = dataBaseHelper.getWritableDatabase() ; // Prepara o Banco de Dados para a manipulação (Escrita, Remoção ETC)

        }return sqLiteDatabase ;
    }


    // Criando um Metodo para fechar o Banco de Dados de maneira pratica
    public void fechar(){

        dataBaseHelper.close(); // fechando o banco
        dataBaseHelper = null ; // atribuindo null pra ele

    }

    //Criando um Retorno a Classe Mensagem  e um novo objeto
    private Mensagem criarMensagem(Cursor cursor){

        //instanciando um novo objeto da classe Mensagem
        Mensagem mensagem = new Mensagem(


                //Pega um valor inteiro - de dentro de um index(exemplo posição em um vetor)- chamado _ID que tá na classe
                //Conecta e Sub-Classe -  Mensagem

                // Esta parte manda para a Classe Mensagem e manda para o metodo construtor que recebe parametros !

                cursor.getInt(cursor.getColumnIndex(Conexao.Mensagem.ID_MENSAGEM)),
                cursor.getInt(cursor.getColumnIndex(Conexao.Mensagem.USUARIO_ID)),
                cursor.getInt(cursor.getColumnIndex(Conexao.Mensagem.EVENTO_ID)),
                cursor.getString(cursor.getColumnIndex(Conexao.Mensagem.ASSUNTO)),
                cursor.getString(cursor.getColumnIndex(Conexao.Mensagem.DESCRICAO)),
                cursor.getString(cursor.getColumnIndex(Conexao.Mensagem.DATA_HORARIO)));


        return mensagem ;
    }

    // ESSSA PARTE DO CÓDOGO NÃO SEI SE É NECESSASÁRIA E SE É
    //DESTA MANEIRA QUE FAZ.


    // Maneira de Listar Todos as Mensagem do Banco de Dados

    public List<Mensagem> ListaMensagem() {

        // Gerando um Cursor ( Quase que tem os QUERYs)
        Cursor cursor = getDataBase().query(Conexao.Mensagem.TABELA, //Cursor ta executando essa seleção que tá sendo feita
                Conexao.Mensagem.COLUNAS, null, null, null, null, null);



        //Criando uma Lista de Mensagem
        List<Mensagem> mensagems = new ArrayList<Mensagem>();

        while (cursor.moveToNext()) { // Enquanto o cursos se mover para o proximo ou outra posição

            Mensagem modelo = criarMensagem(cursor); // criando um novo objeto e passando parametros do cursor
            mensagems.add(modelo); //adcionando um novo Mensagem a lista

        }

        cursor.close(); // fechando o cursor e retornando para enderecos


        return mensagems ;
    }


                        // Maneira de Salvar os dados no Banco de Dados seja eles não existente ou já existentes

    // Criando um novo metodo e passando um novo objeto da classe Mensagem
    public long salvarMensagem(Mensagem mensagem) {


        // Classe que recebe os valores que serão salvos no banco de dados
        //Tem que informar O nome da Coluna e a Tabela e tambem as informações que deseja salvar nessa Tabela
        ContentValues valores = new ContentValues();


        //Metodo PUT recebe por parametro os tipos de dados String Key e Short Value
        valores.put(Conexao.Mensagem.ID_MENSAGEM, mensagem.getIdMensagem());
        valores.put(Conexao.Mensagem.USUARIO_ID,"1");
        valores.put(Conexao.Mensagem.EVENTO_ID,"1");
        valores.put(Conexao.Mensagem.ASSUNTO, mensagem.getAssunto());
        valores.put(Conexao.Mensagem.DESCRICAO, mensagem.getDescricao());
        valores.put(Conexao.Mensagem.DATA_HORARIO, mensagem.getData_horario());



        if (mensagem.getIdMensagem() != null) {
            return sqLiteDatabase.update(Conexao.Mensagem.TABELA , valores, "IdMensagem = ?" ,
                    new String[]{mensagem.getIdMensagem().toString()}   );

        }
        return getDataBase().insert(Conexao.Mensagem.TABELA , null , valores) ;
    }


                                 // Maneira de REMOVER os dados no Banco de Dados seja eles não existente ou já existentes

    //REMOVENDO USUARIOS DE ACORDO COM O ID
    public boolean removerMensagem(int id){

        return getDataBase().delete(Conexao.Mensagem.TABELA , "IdMensagem = ?" , new String[]{(Integer.toString(id))}) > 0 ;



    }

                         // Maneira de BUSCAR os dados no Banco de Dados seja eles não existente ou já existentes

    //BUSCANDO USUARIO DE ACORDO COM O ID
    public Mensagem buscarMensagem(int id){
        Cursor cursor = getDataBase().query(Conexao.Mensagem.TABELA , Conexao.Mensagem.COLUNAS , "IdMensagem = ?" , new String[]{Integer.toString(id)} , null , null , null) ;

        List<Mensagem> mensagems = new ArrayList<Mensagem>() ;

        while(cursor.moveToNext()){
            Mensagem modelo = criarMensagem(cursor) ;
            mensagems.add(modelo);
        }

        cursor.close();
        return (Mensagem) mensagems ; // fazendo Casting para o Tipo Mensagem
    }

    /*

                                            NÃO SABE-SE SE ESTA PARTE DO CODIGO É ÚTIL PARA A HUMANIDADE

    public boolean logar (String usuario , String senha) { // Criando novo objeto e recebendo parametros do "loginActivity"
        Cursor cursor = getDataBase().query(Conecta.Usuario.TABELA, null, "LOGIN = ? AND SENHA = ?", new String[]{usuario, senha}, null, null, null);

        if (cursor.moveToFirst()) { // Procura e Retorna o Primeiro que for encontrado
            return true;

        } else {
            return false;
        }
    }

        */


}
