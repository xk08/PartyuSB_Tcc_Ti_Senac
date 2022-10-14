package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import Interacao.Categoria;

/**
 * Created by MARCOS MARTINS on 02/12/2016.
 */

public class CategoriaBD {

    //criado uma variavel para abrir e manipular o Banco de Dados
    private Conexao dataBaseHelper ;


    //Criando variavel que Permite que interações sejam feitas no Banco IMPORTA AUTOMATICAMENTE
    private SQLiteDatabase sqLiteDatabase;


    //criando o metodo contrutor ou Instanciando -> Recebe por padrão um contexto
    public CategoriaBD(Context context) { //Ira passar qual Activity que está chamando esta classe
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

    //Criando um Retorno a Classe Categoria e um novo objeto
    private Categoria criarCategoria (Cursor cursor){

        //instanciando um novo objeto da classe ENDERECO
        Categoria categoria = new Categoria(


                //Pega um valor inteiro - de dentro de um index(exemplo posição em um vetor)- chamado _ID que tá na classe
                //Conecta e Sub-Classe -  Categoria


                // Esta parte manda para a Classe Categoria e manda para o metodo construtor que recebe parametros !
                cursor.getInt(cursor.getColumnIndex(Conexao.Categoria.ID_CATEGORIA)),
                cursor.getString(cursor.getColumnIndex(Conexao.Categoria.NOME_CATEGORIA)),
                cursor.getString(cursor.getColumnIndex(Conexao.Categoria.ICONE_CATEGORIA)));

        return categoria ;
    }

    // ESSSA PARTE DO CÓDOGO NÃO SEI SE É NECESSASÁRIA E SE É
    //DESTA MANEIRA QUE FAZ.


                                // Maneira de Listar Todos as Categoria do Banco de Dados

    public List<Categoria> ListaCategoria() {

        // Gerando um Cursor ( Quase que tem os QUERYs)
        Cursor cursor = getDataBase().query(Conexao.Categoria.TABELA, //Cursor ta executando essa seleção que tá sendo feita
                Conexao.Categoria.COLUNAS, null, null, null, null, null);



        //Criando uma Lista de Categoria
        List<Categoria> categorias = new ArrayList<Categoria>();

        while (cursor.moveToNext()) { // Enquanto o cursos se mover para o proximo ou outra posição

            Categoria modelo = criarCategoria(cursor); // criando um novo objeto e passando parametros do cursor
            categorias.add(modelo); //adcionando uma nova Categoria a lista

        }

        cursor.close(); // fechando o cursor e retornando para enderecos


        return categorias ;
    }


                                 // Maneira de Salvar os dados no Banco de Dados seja eles não existente ou já existentes

    // Criando um novo metodo e passando um novo objeto da classe Categoria
    public long salvarCategoria(Categoria categoria) {


        // Classe que recebe os valores que serão salvos no banco de dados
        //Tem que informar O nome da Coluna e a Tabela e tambem as informações que deseja salvar nessa Tabela
        ContentValues valores = new ContentValues();

        //Metodo PUT recebe por parametro os tipos de dados String Key e Short Value
        valores.put(Conexao.Categoria.ID_CATEGORIA, categoria.getIdCategoria());
        valores.put(Conexao.Categoria.NOME_CATEGORIA, categoria.getNome_categoria());
        valores.put(Conexao.Categoria.ICONE_CATEGORIA, categoria.getIcone_categoria());



        if (categoria.getIdCategoria() != null) {
            return sqLiteDatabase.update(Conexao.Categoria.TABELA , valores, "IdCategoria = ?" ,
                    new String[]{categoria.getIdCategoria().toString()}   );

        }
        return getDataBase().insert(Conexao.Categoria.TABELA , null , valores) ;
    }



                                 // Maneira de REMOVER os dados no Banco de Dados seja eles não existente ou já existentes

    //REMOVENDO USUARIOS DE ACORDO COM O ID
    public boolean removerCategoria(int id){

        return getDataBase().delete(Conexao.Categoria.TABELA , "IdCategoria = ?" , new String[]{(Integer.toString(id))}) > 0 ;

    }

                            // Maneira de BUSCAR os dados no Banco de Dados seja eles não existente ou já existentes

    //BUSCANDO USUARIO DE ACORDO COM O ID
    public Categoria buscarCategoria(int id){
        Cursor cursor = getDataBase().query(Conexao.Categoria.TABELA , Conexao.Categoria.COLUNAS , "IdCategoria = ?" , new String[]{Integer.toString(id)} , null , null , null) ;

        List<Categoria> categorias = new ArrayList<Categoria>() ;

        while(cursor.moveToNext()){
            Categoria modelo = criarCategoria(cursor) ;
            categorias.add(modelo);
            cursor.close();
            return modelo ;
        }


        return null ;
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




