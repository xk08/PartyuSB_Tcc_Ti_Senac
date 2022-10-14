package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.example.aluno.partyusb.CadastroUsuarioActivity;

import java.util.ArrayList;
import java.util.List;

import Interacao.Endereco;

/**
 * Created by Marcos Martins on 01/12/2016.
 */

public class EnderecoBD {

    // /criado uma variavel para abrir e manipular o Banco de Dados
    private Conexao dataBaseHelper ;


    //Criando variavel que Permite que interações sejam feitas no Banco IMPORTA AUTOMATICAMENTE
    private SQLiteDatabase sqLiteDatabase;


    //criando o metodo contrutor ou Instanciando -> Recebe por padrão um contexto
    public EnderecoBD(Context context) { //Ira passar qual Activity que está chamando esta classe
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
    private Endereco criarEndereco(Cursor cursor){

        //instanciando um novo objeto da classe ENDERECO
        Endereco endereco = new Endereco(


                //Pega um valor inteiro - de dentro de um index(exemplo posição em um vetor)- chamado _ID que tá na classe
                //Conecta e Sub-Classe -  Endereco

                // Esta parte manda para a Classe ENDERECO e manda para o metodo construtor que recebe parametros !

                cursor.getInt(cursor.getColumnIndex(Conexao.Endereco.ID_ENDERECO)),
                cursor.getString(cursor.getColumnIndex(Conexao.Endereco.CIDADE)),
                cursor.getString(cursor.getColumnIndex(Conexao.Endereco.ESTADO)),
                cursor.getString(cursor.getColumnIndex(Conexao.Endereco.PAIS)),
                cursor.getString(cursor.getColumnIndex(Conexao.Endereco.BAIRRO)),
                cursor.getInt(cursor.getColumnIndex(Conexao.Endereco.NUMERO)),
                cursor.getString(cursor.getColumnIndex(Conexao.Endereco.RUA)),
                cursor.getString(cursor.getColumnIndex(Conexao.Endereco.LOCAL_EVENTO)));

        return endereco ;
    }

    // ESSSA PARTE DO CÓDOGO NÃO SEI SE É NECESSASÁRIA E SE É
    //DESTA MANEIRA QUE FAZ.



                                             // Maneira de Listar Todos os Usuarios do Banco de Dados

    public List<Endereco> ListaEndereco() {

        // Gerando um Cursor ( Quase que tem os QUERYs)
        Cursor cursor = getDataBase().query(Conexao.Usuario.TABELA, //Cursor ta executando essa seleção que tá sendo feita
                Conexao.Usuario.COLUNAS, null, null, null, null, null);



        //Criando uma Lista de ENDERECOS
        List<Endereco> enderecos = new ArrayList<Endereco>();

        while (cursor.moveToNext()) { // Enquanto o cursos se mover para o proximo ou outra posição

            Endereco modelo = criarEndereco(cursor); // criando um novo objeto e passando parametros do cursor
            enderecos.add(modelo); //adcionando um novo usuario a lista

        }

        cursor.close(); // fechando o cursor e retornando para enderecos


        return enderecos ;
    }




                             // Maneira de Salvar os dados no Banco de Dados seja eles não existente ou já existentes

    // Criando um novo metodo e passando um novo objeto da classe Endereco
    public long salvarEndereco(Endereco endereco) {


        // Classe que recebe os valores que serão salvos no banco de dados
        //Tem que informar O nome da Coluna e a Tabela e tambem as informações que deseja salvar nessa Tabela
        ContentValues valores = new ContentValues();

        //Metodo PUT recebe por parametro os tipos de dados String Key e Short Value
        valores.put(Conexao.Endereco.CIDADE, endereco.getCidade());
        valores.put(Conexao.Endereco.ESTADO, endereco.getEstado());
        valores.put(Conexao.Endereco.PAIS, endereco.getPais());
        valores.put(Conexao.Endereco.BAIRRO, endereco.getBairro());
        valores.put(Conexao.Endereco.NUMERO, endereco.getNumero());
        valores.put(Conexao.Endereco.RUA, endereco.getRua());
        valores.put(Conexao.Endereco.LOCAL_EVENTO, "Casa");


        if (endereco.getIdEndereco() != null) {
            return sqLiteDatabase.update(Conexao.Endereco.TABELA , valores, "IdEndereco = ?" ,
                    new String[]{endereco.getIdEndereco().toString()}    );

        }
        return getDataBase().insert(Conexao.Endereco.TABELA , null , valores) ;
    }



                         // Maneira de REMOVER os dados no Banco de Dados seja eles não existente ou já existentes

    //REMOVENDO USUARIOS DE ACORDO COM O ID
    public boolean removerEndereco(int id){

        return getDataBase().delete(Conexao.Endereco.TABELA , "IdEndereco = ?" , new String[]{(Integer.toString(id))}) > 0 ;



    }

                              // Maneira de BUSCAR os dados no Banco de Dados seja eles não existente ou já existentes

    //BUSCANDO USUARIO DE ACORDO COM O ID
    public Endereco buscarEndereco(int id){
        Cursor cursor = getDataBase().query(Conexao.Endereco.TABELA , Conexao.Usuario.COLUNAS , "IdEndereco = ?" , new String[]{Integer.toString(id)} , null , null , null) ;

        List<Endereco> enderecos = new ArrayList<Endereco>() ;

        while(cursor.moveToNext()){
            Endereco modelo = criarEndereco(cursor) ;
            enderecos.add(modelo);
        }

        cursor.close();
        return (Endereco) enderecos ; // fazendo Casting para o Tipo Usuário
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




































