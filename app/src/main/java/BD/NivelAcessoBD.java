package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import Interacao.NivelAcesso;

/**
 * Created by MARCOS MARTINS on 02/12/2016.
 */

public class NivelAcessoBD {

    // criado uma variavel para abrir e manipular o Banco de Dados
    private Conexao dataBaseHelper ;


    //Criando variavel que Permite que interações sejam feitas no Banco IMPORTA AUTOMATICAMENTE
    private SQLiteDatabase sqLiteDatabase;


    //criando o metodo contrutor ou Instanciando -> Recebe por padrão um contexto
    public NivelAcessoBD(Context context) { //Ira passar qual Activity que está chamando esta classe
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

    //Criando um Retorno a Classe NivelAcesso  e um novo objeto
    private NivelAcesso criarNivelAcesso(Cursor cursor){

        //instanciando um novo objeto da classe NivelAcesso
        NivelAcesso nivelAcesso = new NivelAcesso(


                //Pega um valor inteiro - de dentro de um index(exemplo posição em um vetor)- chamado _ID que tá na classe
                //Conecta e Sub-Classe -  NivelAcesso

                // Esta parte manda para a Classe NivelAcesso e manda para o metodo construtor que recebe parametros !

                cursor.getInt(cursor.getColumnIndex(Conexao.NivelAcesso.ID_NIVELACESSO)),
                cursor.getString(cursor.getColumnIndex(Conexao.NivelAcesso.NOME_ACESSO)),
                cursor.getString(cursor.getColumnIndex(Conexao.NivelAcesso.DATA_CRIACAO)),
                cursor.getString(cursor.getColumnIndex(Conexao.NivelAcesso.DATA_MODIFICACAO)));

        return nivelAcesso ;
    }

    // ESSSA PARTE DO CÓDOGO NÃO SEI SE É NECESSASÁRIA E SE É
    //DESTA MANEIRA QUE FAZ.


                                     // Maneira de Listar Todos os NivelAcesso do Banco de Dados

    public List<NivelAcesso> ListaNivelAcesso() {

        // Gerando um Cursor ( Quase que tem os QUERYs)
        Cursor cursor = getDataBase().query(Conexao.NivelAcesso.TABELA, //Cursor ta executando essa seleção que tá sendo feita
                Conexao.NivelAcesso.COLUNAS, null, null, null, null, null);



        //Criando uma Lista de NivelAcesso
        List<NivelAcesso> nivelAcessos = new ArrayList<NivelAcesso>();

        while (cursor.moveToNext()) { // Enquanto o cursos se mover para o proximo ou outra posição

            NivelAcesso modelo = criarNivelAcesso(cursor); // criando um novo objeto e passando parametros do cursor
            nivelAcessos.add(modelo); //adcionando um novo NivelAcesso a lista

        }

        cursor.close(); // fechando o cursor e retornando para enderecos


        return nivelAcessos ;
    }


                        // Maneira de Salvar os dados no Banco de Dados seja eles não existente ou já existentes

    // Criando um novo metodo e passando um novo objeto da classe NivelAcesso
    public long salvarNivelAcesso(NivelAcesso nivelAcesso) {


        // Classe que recebe os valores que serão salvos no banco de dados
        //Tem que informar O nome da Coluna e a Tabela e tambem as informações que deseja salvar nessa Tabela
        ContentValues valores = new ContentValues();

        //Metodo PUT recebe por parametro os tipos de dados String Key e Short Value
        valores.put(Conexao.NivelAcesso.ID_NIVELACESSO, nivelAcesso.getIdNivelAcesso());
        valores.put(Conexao.NivelAcesso.NOME_ACESSO, nivelAcesso.getNome_acesso());
        valores.put(Conexao.NivelAcesso.DATA_CRIACAO, nivelAcesso.getData_criacao());
        valores.put(Conexao.NivelAcesso.DATA_MODIFICACAO, nivelAcesso.getData_modificacao());



        if (nivelAcesso.getIdNivelAcesso() != null) {
            return sqLiteDatabase.update(Conexao.Evento.TABELA , valores, "IdNivelAcesso = ?" ,
                    new String[]{nivelAcesso.getIdNivelAcesso().toString()}   );

        }
        return getDataBase().insert(Conexao.NivelAcesso.TABELA , null , valores) ;
    }



                         // Maneira de REMOVER os dados no Banco de Dados seja eles não existente ou já existentes

    //REMOVENDO USUARIOS DE ACORDO COM O ID
    public boolean removerNivelAcesso(int id){

        return getDataBase().delete(Conexao.NivelAcesso.TABELA , "IdNivelAcesso = ?" , new String[]{(Integer.toString(id))}) > 0 ;



    }

                        // Maneira de BUSCAR os dados no Banco de Dados seja eles não existente ou já existentes

    //BUSCANDO USUARIO DE ACORDO COM O ID
    public NivelAcesso buscarNivelAcesso(int id){
        Cursor cursor = getDataBase().query(Conexao.NivelAcesso.TABELA , Conexao.NivelAcesso.COLUNAS , "IdNivelAcesso = ?" , new String[]{Integer.toString(id)} , null , null , null) ;

        List<NivelAcesso> nivelAcessos = new ArrayList<NivelAcesso>() ;

        while(cursor.moveToNext()){
            NivelAcesso modelo = criarNivelAcesso(cursor) ;
            nivelAcessos.add(modelo);
        }

        cursor.close();
        return (NivelAcesso) nivelAcessos ; // fazendo Casting para o Tipo NivelAcesso
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
