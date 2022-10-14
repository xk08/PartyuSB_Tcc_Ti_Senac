package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import Interacao.ImagemEvento;

/**
 * Created by Aluno on 02/12/2016.
 */

public class ImagemEventoBD {


    // /criado uma variavel para abrir e manipular o Banco de Dados
    private Conexao dataBaseHelper ;


    //Criando variavel que Permite que interações sejam feitas no Banco IMPORTA AUTOMATICAMENTE
    private SQLiteDatabase sqLiteDatabase;


    //criando o metodo contrutor ou Instanciando -> Recebe por padrão um contexto
    public ImagemEventoBD(Context context) { //Ira passar qual Activity que está chamando esta classe
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

    //Criando um Retorno a Classe ImagemEvento  e um novo objeto
    private ImagemEvento criarImagemEvento(Cursor cursor){

        //instanciando um novo objeto da classe ImagemEvento
        ImagemEvento imagemEvento = new ImagemEvento(


                //Pega um valor inteiro - de dentro de um index(exemplo posição em um vetor)- chamado _ID que tá na classe
                //Conecta e Sub-Classe -  ImagemEvento

                // Esta parte manda para a Classe ImagemEvento e manda para o metodo construtor que recebe parametros !

                cursor.getInt(cursor.getColumnIndex(Conexao.ImagemEvento.ID_IMAGEMEVENTO)),
                cursor.getString(cursor.getColumnIndex(Conexao.ImagemEvento.IMAGEM_EVENTO)));


        return imagemEvento ;
    }

    // ESSSA PARTE DO CÓDOGO NÃO SEI SE É NECESSASÁRIA E SE É
    //DESTA MANEIRA QUE FAZ.


                                     // Maneira de Listar Todos os ImagemEvento do Banco de Dados

    public List<ImagemEvento> ListaImagemEventoo() {

        // Gerando um Cursor ( Quase que tem os QUERYs)
        Cursor cursor = getDataBase().query(Conexao.ImagemEvento.TABELA, //Cursor ta executando essa seleção que tá sendo feita
                Conexao.ImagemEvento.COLUNAS, null, null, null, null, null);



        //Criando uma Lista de ImagemUsuario
        List<ImagemEvento> imagemEventos = new ArrayList<ImagemEvento>();

        while (cursor.moveToNext()) { // Enquanto o cursos se mover para o proximo ou outra posição

            ImagemEvento modelo = criarImagemEvento(cursor); // criando um novo objeto e passando parametros do cursor
            imagemEventos.add(modelo); //adcionando um novas ImagemEvento a lista

        }

        cursor.close(); // fechando o cursor e retornando para enderecos


        return imagemEventos ;
    }


                        // Maneira de Salvar os dados no Banco de Dados seja eles não existente ou já existentes

    // Criando um novo metodo e passando um novo objeto da classe ImagemEvento
    public long salvarImagemEvento(ImagemEvento imagemEvento) {


        // Classe que recebe os valores que serão salvos no banco de dados
        //Tem que informar O nome da Coluna e a Tabela e tambem as informações que deseja salvar nessa Tabela
        ContentValues valores = new ContentValues();

        //Metodo PUT recebe por parametro os tipos de dados String Key e Short Value
        valores.put(Conexao.ImagemEvento.ID_IMAGEMEVENTO, imagemEvento.getIdImagemEvento());
        valores.put(Conexao.ImagemEvento.IMAGEM_EVENTO, imagemEvento.getImagem_evento());





        if (imagemEvento.getIdImagemEvento() != null) {
            return sqLiteDatabase.update(Conexao.ImagemEvento.TABELA , valores, "idImagemEvento = ?" ,
                    new String[]{imagemEvento.getIdImagemEvento().toString()}   );

        }
        return getDataBase().insert(Conexao.ImagemEvento.TABELA , null , valores) ;
    }



                            // Maneira de REMOVER os dados no Banco de Dados seja eles não existente ou já existentes

    //REMOVENDO USUARIOS DE ACORDO COM O ID
    public boolean removerImagemEvento(int id){

        return getDataBase().delete(Conexao.ImagemEvento.TABELA , "idImagemEvento = ?" , new String[]{(Integer.toString(id))}) > 0 ;
    }

                        // Maneira de BUSCAR os dados no Banco de Dados seja eles não existente ou já existentes

    //BUSCANDO USUARIO DE ACORDO COM O ID
    public ImagemEvento buscarImagemEvento(int id){
        Cursor cursor = getDataBase().query(Conexao.ImagemEvento.TABELA , Conexao.ImagemEvento.COLUNAS , "idImagemEvento = ?" , new String[]{Integer.toString(id)} , null , null , null) ;

        List<ImagemEvento> imagemEventos = new ArrayList<ImagemEvento>() ;

        while(cursor.moveToNext()){
            ImagemEvento modelo = criarImagemEvento(cursor) ;
            imagemEventos.add(modelo);
        }

        cursor.close();
        return (ImagemEvento) imagemEventos ; // fazendo Casting para o Tipo ImagemEvento
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
