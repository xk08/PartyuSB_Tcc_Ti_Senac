package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import Interacao.AvaliacaoOrganizador;

/**
 * Created by Marcos Martins on 02/12/2016.
 */
public class AvaliacaoOrganizadorBD {

    //criado uma variavel para abrir e manipular o Banco de Dados
    private Conexao dataBaseHelper;


    //Criando variavel que Permite que interações sejam feitas no Banco IMPORTA AUTOMATICAMENTE
    private SQLiteDatabase sqLiteDatabase;


    //criando o metodo contrutor ou Instanciando -> Recebe por padrão um contexto
    public AvaliacaoOrganizadorBD(Context context) { //Ira passar qual Activity que está chamando esta classe
        dataBaseHelper = new Conexao(context); // abrindo o banco de dados.
    }


    //Metodo com Retorno então não usa-se VOID
    public SQLiteDatabase getDataBase() {

        if (sqLiteDatabase == null) {
            sqLiteDatabase = dataBaseHelper.getWritableDatabase(); // Prepara o Banco de Dados para a manipulação (Escrita, Remoção ETC)

        }
        return sqLiteDatabase;
    }


    // Criando um Metodo para fechar o Banco de Dados de maneira pratica
    public void fechar() {

        dataBaseHelper.close(); // fechando o banco
        dataBaseHelper = null; // atribuindo null pra ele

    }

    //Criando um Retorno a Classe AvaliacaoEvento  e um novo objeto
    private AvaliacaoOrganizador criarAvaliacaoOrganizador(Cursor cursor) {

        //instanciando um novo objeto da classe AvaliacaoOrganizador
        AvaliacaoOrganizador avaliacaoOrganizador = new AvaliacaoOrganizador(


                //Pega um valor inteiro - de dentro de um index(exemplo posição em um vetor)- chamado _ID que tá na classe
                //Conecta e Sub-Classe -  AvaliacaoOrganizador


                // Esta parte manda para a Classe AvaliacaoEvento e manda para o metodo construtor que recebe parametros !
                cursor.getInt(cursor.getColumnIndex(Conexao.AvaliacaoOrganizador.ID_AVALIACAO)),
                cursor.getInt(cursor.getColumnIndex(Conexao.AvaliacaoOrganizador.ORGANIZADOR_ID)),
                cursor.getInt(cursor.getColumnIndex(Conexao.AvaliacaoOrganizador.USUARIO_ID)),
                cursor.getDouble(cursor.getColumnIndex(Conexao.AvaliacaoOrganizador.NOTA)),
                cursor.getString(cursor.getColumnIndex(Conexao.AvaliacaoOrganizador.COMENTARIO)),
                cursor.getInt(cursor.getColumnIndex(Conexao.AvaliacaoOrganizador.FAVORITAR_ORGANIZADOR)));


        return avaliacaoOrganizador;
    }

    // ESSSA PARTE DO CÓDOGO NÃO SEI SE É NECESSASÁRIA E SE É
    //DESTA MANEIRA QUE FAZ.


    // Maneira de Listar Todos os AvaliacaoOrganizador do Banco de Dados

    public List<AvaliacaoOrganizador> ListaAvaliacaoOrganizador() {

        // Gerando um Cursor ( Quase que tem os QUERYs)
        Cursor cursor = getDataBase().query(Conexao.AvaliacaoOrganizador.TABELA, //Cursor ta executando essa seleção que tá sendo feita
                Conexao.AvaliacaoOrganizador.COLUNAS, null, null, null, null, null);


        //Criando uma Lista de AvaliacaoOrganizador
        List<AvaliacaoOrganizador> avaliacaoOrganizador = new ArrayList<AvaliacaoOrganizador>();

        while (cursor.moveToNext()) { // Enquanto o cursos se mover para o proximo ou outra posição

            AvaliacaoOrganizador modelo = criarAvaliacaoOrganizador(cursor); // criando um novo objeto e passando parametros do cursor
            avaliacaoOrganizador.add(modelo); //adcionando um novo AvaliacaoOrganizador a lista

        }

        cursor.close(); // fechando o cursor e retornando para enderecos


        return avaliacaoOrganizador;
    }


    // Maneira de Salvar os dados no Banco de Dados seja eles não existente ou já existentes

    // Criando um novo metodo e passando um novo objeto da classe AvaliacaoOrganizador
    public long salvarAvaliacaoOrganizador(AvaliacaoOrganizador avaliacaoOrganizador) {


        // Classe que recebe os valores que serão salvos no banco de dados
        //Tem que informar O nome da Coluna e a Tabela e tambem as informações que deseja salvar nessa Tabela
        ContentValues valores = new ContentValues();

        //Metodo PUT recebe por parametro os tipos de dados String Key e Short Value
        valores.put(Conexao.AvaliacaoOrganizador.ID_AVALIACAO, avaliacaoOrganizador.getIdAvaliacao());
        valores.put(Conexao.AvaliacaoOrganizador.ORGANIZADOR_ID, "1");
        valores.put(Conexao.AvaliacaoOrganizador.USUARIO_ID,"1");
        valores.put(Conexao.AvaliacaoOrganizador.NOTA, avaliacaoOrganizador.getNota());
        valores.put(Conexao.AvaliacaoOrganizador.COMENTARIO, avaliacaoOrganizador.getComentario());
        valores.put(Conexao.AvaliacaoOrganizador.FAVORITAR_ORGANIZADOR, avaliacaoOrganizador.getFavoritar_organizador());


        if (avaliacaoOrganizador.getIdAvaliacao() != null) {
            return sqLiteDatabase.update(Conexao.AvaliacaoOrganizador.TABELA, valores, "IdAvaliacao = ?",
                    new String[]{avaliacaoOrganizador.getIdAvaliacao().toString()});

        }
        return getDataBase().insert(Conexao.AvaliacaoOrganizador.TABELA, null, valores);
    }


    // Maneira de REMOVER os dados no Banco de Dados seja eles não existente ou já existentes

    //REMOVENDO USUARIOS DE ACORDO COM O ID
    public boolean removerAvaliacaoOrganizador(int id) {

        return getDataBase().delete(Conexao.AvaliacaoOrganizador.TABELA, "IdAvaliacao = ?", new String[]{(Integer.toString(id))}) > 0;

    }

    // Maneira de BUSCAR os dados no Banco de Dados seja eles não existente ou já existentes

    //BUSCANDO USUARIO DE ACORDO COM O ID
    public AvaliacaoOrganizador buscarAvaliacaoOrganizador(int id) {
        Cursor cursor = getDataBase().query(Conexao.AvaliacaoOrganizador.TABELA, Conexao.AvaliacaoOrganizador.COLUNAS, "IdAvaliacao = ?", new String[]{Integer.toString(id)}, null, null, null);

        List<AvaliacaoOrganizador> avaliacaoOrganizador = new ArrayList<AvaliacaoOrganizador>();

        while (cursor.moveToNext()) {
            AvaliacaoOrganizador modelo = criarAvaliacaoOrganizador(cursor);
            avaliacaoOrganizador.add(modelo);
            cursor.close();
            return (AvaliacaoOrganizador) avaliacaoOrganizador; // fazendo Casting para o Tipo AvalicaoEvento

        }

        return null;


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
