package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import Interacao.ImagemUsuario;

/**
 * Created by Marcos Martins on 02/12/2016.
 */

public class ImagemUsuarioBD {

    // /criado uma variavel para abrir e manipular o Banco de Dados
    private Conexao dataBaseHelper ;


    //Criando variavel que Permite que interações sejam feitas no Banco IMPORTA AUTOMATICAMENTE
    private SQLiteDatabase sqLiteDatabase;


    //criando o metodo contrutor ou Instanciando -> Recebe por padrão um contexto
    public ImagemUsuarioBD(Context context) { //Ira passar qual Activity que está chamando esta classe
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

    //Criando um Retorno a Classe ENDEREÇO  e um novo objeto
    private ImagemUsuario criarImagemUsuario(Cursor cursor){

        //instanciando um novo objeto da classe ImagemUsuario
        ImagemUsuario imagemUsuario = new ImagemUsuario(


                //Pega um valor inteiro - de dentro de um index(exemplo posição em um vetor)- chamado _ID que tá na classe
                //Conecta e Sub-Classe -  ImagemUsuario

                // Esta parte manda para a Classe ImagemUsuario e manda para o metodo construtor que recebe parametros !

                cursor.getInt(cursor.getColumnIndex(Conexao.ImagemUsuario.ID_IMAGEMUSUARIO)),
                cursor.getString(cursor.getColumnIndex(Conexao.ImagemUsuario.IMAGEM_USUARIO)));


        return imagemUsuario ;
    }

    // ESSSA PARTE DO CÓDOGO NÃO SEI SE É NECESSASÁRIA E SE É
    //DESTA MANEIRA QUE FAZ.


                                         // Maneira de Listar Todos os ImagemUsuario do Banco de Dados

    public List<ImagemUsuario> ListaImagemUsuario() {

        // Gerando um Cursor ( Quase que tem os QUERYs)
        Cursor cursor = getDataBase().query(Conexao.Usuario.TABELA, //Cursor ta executando essa seleção que tá sendo feita
                Conexao.ImagemUsuario.COLUNAS, null, null, null, null, null);



        //Criando uma Lista de ImagemUsuario
        List<ImagemUsuario> imagemUsuarios = new ArrayList<ImagemUsuario>();

        while (cursor.moveToNext()) { // Enquanto o cursos se mover para o proximo ou outra posição

            ImagemUsuario modelo = criarImagemUsuario(cursor); // criando um novo objeto e passando parametros do cursor
            imagemUsuarios.add(modelo); //adcionando um novas ImagemUsuario a lista

        }

        cursor.close(); // fechando o cursor e retornando para enderecos


        return imagemUsuarios ;
    }


                                // Maneira de Salvar os dados no Banco de Dados seja eles não existente ou já existentes

    // Criando um novo metodo e passando um novo objeto da classe ImagemUsuario
    public long salvarImagemUsuario(ImagemUsuario imagemUsuario) {


        // Classe que recebe os valores que serão salvos no banco de dados
        //Tem que informar O nome da Coluna e a Tabela e tambem as informações que deseja salvar nessa Tabela
        ContentValues valores = new ContentValues();

        //Metodo PUT recebe por parametro os tipos de dados String Key e Short Value
        valores.put(Conexao.ImagemUsuario.ID_IMAGEMUSUARIO, imagemUsuario.getIdImagemUsuario());
        valores.put(Conexao.ImagemUsuario.IMAGEM_USUARIO, imagemUsuario.getImagem_usuario());





        if (imagemUsuario.getIdImagemUsuario() != null) {
            return sqLiteDatabase.update(Conexao.ImagemUsuario.TABELA , valores, "IdImagemUsuario = ?" ,
                    new String[]{imagemUsuario.getIdImagemUsuario().toString()}   );

        }
        return getDataBase().insert(Conexao.ImagemUsuario.TABELA , null , valores) ;
    }



                                            // Maneira de REMOVER os dados no Banco de Dados seja eles não existente ou já existentes

    //REMOVENDO USUARIOS DE ACORDO COM O ID
    public boolean removerEndereco(int id){

        return getDataBase().delete(Conexao.Endereco.TABELA , "IdImagemUsuario = ?" , new String[]{(Integer.toString(id))}) > 0 ;
    }

                                    // Maneira de BUSCAR os dados no Banco de Dados seja eles não existente ou já existentes

    //BUSCANDO USUARIO DE ACORDO COM O ID
    public ImagemUsuario buscarImagemUsuario(int id){
        Cursor cursor = getDataBase().query(Conexao.ImagemUsuario.TABELA , Conexao.ImagemUsuario.COLUNAS , "IdImagemUsuario = ?" , new String[]{Integer.toString(id)} , null , null , null) ;

        List<ImagemUsuario> imagemUsuarios = new ArrayList<ImagemUsuario>() ;

        while(cursor.moveToNext()){
            ImagemUsuario modelo = criarImagemUsuario(cursor) ;
            imagemUsuarios.add(modelo);
        }

        cursor.close();
        return (ImagemUsuario) imagemUsuarios ; // fazendo Casting para o Tipo Usuário
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
