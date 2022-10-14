package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import Interacao.Favorito;

/**
 * Created by Marcos Gronytzki on 04/12/2016.
 */

public class FavoritoBD {


    //criado uma variavel para abrir e manipular o Banco de Dados
    private Conexao dataBaseHelper ;


    //Criando variavel que Permite que interações sejam feitas no Banco IMPORTA AUTOMATICAMENTE
    private SQLiteDatabase sqLiteDatabase;


    //criando o metodo contrutor ou Instanciando -> Recebe por padrão um contexto
    public FavoritoBD(Context context) { //Ira passar qual Activity que está chamando esta classe
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

    //Criando um Retorno a Classe Favorito e um novo objeto
    private Favorito criarFavorito (Cursor cursor){

        //instanciando um novo objeto da classe Favorito
        Favorito favorito = new Favorito(


                //Pega um valor inteiro - de dentro de um index(exemplo posição em um vetor)- chamado _ID que tá na classe
                //Conecta e Sub-Classe -  Favorito


                // Esta parte manda para a Classe Favorito e manda para o metodo construtor que recebe parametros !

                cursor.getInt(cursor.getColumnIndex(Conexao.Favorito.ID_FAVORITO)),
                cursor.getInt(cursor.getColumnIndex(Conexao.Favorito.USUARIO_ID)),
                cursor.getInt(cursor.getColumnIndex(Conexao.Favorito.EVENTO_ID)));

        return favorito ;
    }

    // ESSSA PARTE DO CÓDOGO NÃO SEI SE É NECESSASÁRIA E SE É
    //DESTA MANEIRA QUE FAZ.


    // Maneira de Listar Todos as Favorito do Banco de Dados

    public List<Favorito> ListaFavorito() {

        // Gerando um Cursor ( Quase que tem os QUERYs)
        Cursor cursor = getDataBase().query(Conexao.Favorito.TABELA, //Cursor ta executando essa seleção que tá sendo feita
                Conexao.Favorito.COLUNAS, null, null, null, null, null);


        //Criando uma Lista de Favorito
        List<Favorito> favoritos = new ArrayList<Favorito>();

        while (cursor.moveToNext()) { // Enquanto o cursos se mover para o proximo ou outra posição

            Favorito modelo = criarFavorito(cursor); // criando um novo objeto e passando parametros do cursor
            favoritos.add(modelo); //adcionando uma nova Favorito a lista

        }

        cursor.close(); // fechando o cursor e retornando para enderecos

        return favoritos ;
    }

                         // Maneira de Salvar os dados no Banco de Dados seja eles não existente ou já existentes

    // Criando um novo metodo e passando um novo objeto da classe Favorito
    public long salvarFavorito(Favorito favorito) {


        // Classe que recebe os valores que serão salvos no banco de dados
        //Tem que informar O nome da Coluna e a Tabela e tambem as informações que deseja salvar nessa Tabela
        ContentValues valores = new ContentValues();

        //Metodo PUT recebe por parametro os tipos de dados String Key e Short Value
        valores.put(Conexao.Favorito.ID_FAVORITO, favorito.getIdFavorito());
        valores.put(Conexao.Favorito.USUARIO_ID, "1");
        valores.put(Conexao.Favorito.EVENTO_ID, "1");


        if (favorito.getIdFavorito() != null) {
            return sqLiteDatabase.update(Conexao.Favorito.TABELA , valores, "IdFavorito = ?" ,
                    new String[]{favorito.getIdFavorito().toString()}   );

        }
        return sqLiteDatabase.insert(Conexao.Favorito.TABELA , null , valores) ;
    }

                             // Maneira de REMOVER os dados no Banco de Dados seja eles não existente ou já existentes

    //REMOVENDO USUARIOS DE ACORDO COM O ID
    public boolean removerFavorito(int id){

        return getDataBase().delete(Conexao.Favorito.TABELA , "IdFavorito = ?" , new String[]{(Integer.toString(id))}) > 0 ;

    }

                            // Maneira de BUSCAR os dados no Banco de Dados seja eles não existente ou já existentes

    //BUSCANDO USUARIO DE ACORDO COM O ID
    public Favorito buscarFavorito(int id){
        Cursor cursor = getDataBase().query(Conexao.Favorito.TABELA , Conexao.Favorito.COLUNAS , "IdFavorito = ?" , new String[]{Integer.toString(id)} , null , null , null) ;

        List<Favorito> favoritos = new ArrayList<Favorito>() ;

        while(cursor.moveToNext()){
            Favorito modelo = criarFavorito(cursor) ;
            favoritos.add(modelo);
        }

        cursor.close();
        return (Favorito) favoritos ; // fazendo Casting para o Tipo Favorito
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
