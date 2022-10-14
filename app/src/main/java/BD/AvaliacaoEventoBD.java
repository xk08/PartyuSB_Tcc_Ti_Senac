package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import Interacao.AvaliacaoEvento;

/**
 * Created by Aluno on 02/12/2016.
 */
public class AvaliacaoEventoBD {

    //criado uma variavel para abrir e manipular o Banco de Dados
    private Conexao dataBaseHelper ;


    //Criando variavel que Permite que interações sejam feitas no Banco IMPORTA AUTOMATICAMENTE
    private SQLiteDatabase sqLiteDatabase;


    //criando o metodo contrutor ou Instanciando -> Recebe por padrão um contexto
    public AvaliacaoEventoBD(Context context) { //Ira passar qual Activity que está chamando esta classe
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

    //Criando um Retorno a Classe AvaliacaoEvento  e um novo objeto
    private AvaliacaoEvento criarAvaliacaoEvento (Cursor cursor){

        //instanciando um novo objeto da classe ENDERECO
        AvaliacaoEvento avaliacaoEvento = new AvaliacaoEvento(


                //Pega um valor inteiro - de dentro de um index(exemplo posição em um vetor)- chamado _ID que tá na classe
                //Conecta e Sub-Classe -  Avaliacão Evento


                // Esta parte manda para a Classe AvaliacaoEvento e manda para o metodo construtor que recebe parametros !
                cursor.getInt(cursor.getColumnIndex(Conexao.AvaliacaoEvento.ID_AVALIACAOEVENTO)),
                cursor.getInt(cursor.getColumnIndex(Conexao.AvaliacaoEvento.USUARIO_ID)),
                cursor.getInt(cursor.getColumnIndex(Conexao.AvaliacaoEvento.EVENTO_ID)),
                cursor.getDouble(cursor.getColumnIndex(Conexao.AvaliacaoEvento.NOTA)),
                cursor.getString(cursor.getColumnIndex(Conexao.AvaliacaoEvento.COMENTARIO)),
                cursor.getString(cursor.getColumnIndex(Conexao.AvaliacaoEvento.STATUS)));


        return avaliacaoEvento ;
    }

    // ESSSA PARTE DO CÓDOGO NÃO SEI SE É NECESSASÁRIA E SE É
    //DESTA MANEIRA QUE FAZ.


    // Maneira de Listar Todos os EVENTOS do Banco de Dados

    public List<AvaliacaoEvento> ListaAvaliacaoEvento() {

        // Gerando um Cursor ( Quase que tem os QUERYs)
        Cursor cursor = getDataBase().query(Conexao.AvaliacaoEvento.TABELA, //Cursor ta executando essa seleção que tá sendo feita
                Conexao.AvaliacaoEvento.COLUNAS, null, null, null, null, null);



        //Criando uma Lista de AvaliacaoEvento
        List<AvaliacaoEvento> avaliacaoEventos = new ArrayList<AvaliacaoEvento>();

        while (cursor.moveToNext()) { // Enquanto o cursos se mover para o proximo ou outra posição

            AvaliacaoEvento modelo = criarAvaliacaoEvento(cursor); // criando um novo objeto e passando parametros do cursor
            avaliacaoEventos.add(modelo); //adcionando um novo AvaliacaoEvento a lista

        }

        cursor.close(); // fechando o cursor e retornando para enderecos


        return avaliacaoEventos ;
    }


                            // Maneira de Salvar os dados no Banco de Dados seja eles não existente ou já existentes

    // Criando um novo metodo e passando um novo objeto da classe Evento
    public long salvarAvaliacaoEvento(AvaliacaoEvento avaliacaoEvento) {


        // Classe que recebe os valores que serão salvos no banco de dados
        //Tem que informar O nome da Coluna e a Tabela e tambem as informações que deseja salvar nessa Tabela
        ContentValues valores = new ContentValues();

        //Metodo PUT recebe por parametro os tipos de dados String Key e Short Value
        valores.put(Conexao.AvaliacaoEvento.ID_AVALIACAOEVENTO, avaliacaoEvento.getIdAvalicaoEvento());
        valores.put(Conexao.AvaliacaoEvento.USUARIO_ID, "1");
        valores.put(Conexao.AvaliacaoEvento.EVENTO_ID, "1");
        valores.put(Conexao.AvaliacaoEvento.NOTA, avaliacaoEvento.getNota());
        valores.put(Conexao.AvaliacaoEvento.COMENTARIO, avaliacaoEvento.getComentario());
        valores.put(Conexao.AvaliacaoEvento.STATUS, "Teste");


        if (avaliacaoEvento.getIdAvalicaoEvento() != null) {
            return sqLiteDatabase.update(Conexao.AvaliacaoEvento.TABELA , valores, "IdAvalicaoEvento = ?" ,
                    new String[]{avaliacaoEvento.getIdAvalicaoEvento().toString()}   );

        }
        return getDataBase().insert(Conexao.AvaliacaoEvento.TABELA , null , valores) ;
    }



                            // Maneira de REMOVER os dados no Banco de Dados seja eles não existente ou já existentes

    //REMOVENDO USUARIOS DE ACORDO COM O ID
    public boolean removerAvaliacaoEvento(int id){

        return getDataBase().delete(Conexao.AvaliacaoEvento.TABELA , "IdAvalicaoEvento = ?" , new String[]{(Integer.toString(id))}) > 0 ;



    }

                                    // Maneira de BUSCAR os dados no Banco de Dados seja eles não existente ou já existentes

    //BUSCANDO USUARIO DE ACORDO COM O ID
    public AvaliacaoEvento buscarAvaliacaoEvento(int id){
        Cursor cursor = getDataBase().query(Conexao.AvaliacaoEvento.TABELA , Conexao.AvaliacaoEvento.COLUNAS , "IdAvalicaoEvento = ?" , new String[]{Integer.toString(id)} , null , null , null) ;

        List<AvaliacaoEvento> avaliacaoEventos = new ArrayList<AvaliacaoEvento>() ;

        while(cursor.moveToNext()){
            AvaliacaoEvento modelo = criarAvaliacaoEvento(cursor) ;
            avaliacaoEventos.add(modelo);
        }

        cursor.close();
        return (AvaliacaoEvento) avaliacaoEventos ; // fazendo Casting para o Tipo AvalicaoEvento
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
