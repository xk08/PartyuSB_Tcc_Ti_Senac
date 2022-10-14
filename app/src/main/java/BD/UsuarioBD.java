package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import Interacao.Usuario;

/**
 * Created by marcos martins on 02/12/2016.
 */
public class UsuarioBD {

    //String teste = "select max(idEndereco) from endereco;" ;
    // sqLiteDatabase.execSQL(teste);

    // /criado uma variavel para abrir e manipular o Banco de Dados
    private Conexao dataBaseHelper;


    //Criando variavel que Permite que interações sejam feitas no Banco IMPORTA AUTOMATICAMENTE
    private SQLiteDatabase sqLiteDatabase;


    //criando o metodo contrutor ou Instanciando -> Recebe por padrão um contexto
    public UsuarioBD(Context context) { //Ira passar qual Activity que está chamando esta classe
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

    //Criando um Retorno a Classe Usuário  e um novo objeto
    private Usuario criarUsuario(Cursor cursor) {

        //instanciando um novo objeto da classe USUARIO
        Usuario usuario = new Usuario(


                //Pega um valor inteiro - de dentro de um index(exemplo posição em um vetor)- chamado _ID que tá na classe
                //Conecta e Sub-Classe -  USUÁRIO

                // Esta parte manda para a Classe USUÁRIO e manda para o metodo construtor que recebe parametros !

                cursor.getInt(cursor.getColumnIndex(Conexao.Usuario.ID_USUARIO)),
                cursor.getInt(cursor.getColumnIndex(Conexao.Usuario.ENDERECO_ID)),
                cursor.getInt(cursor.getColumnIndex(Conexao.Usuario.IMAGEMUSUARIO_ID)),
                cursor.getInt(cursor.getColumnIndex(Conexao.Usuario.NIVELACESSO_ID)),
                cursor.getString(cursor.getColumnIndex(Conexao.Usuario.NOME_SOBRENOME)),
                cursor.getString(cursor.getColumnIndex(Conexao.Usuario.NICK_NAME)),
                cursor.getString(cursor.getColumnIndex(Conexao.Usuario.SENHA)),
                cursor.getString(cursor.getColumnIndex(Conexao.Usuario.EMAIL)),
                cursor.getString(cursor.getColumnIndex(Conexao.Usuario.CPF)),
                cursor.getString(cursor.getColumnIndex(Conexao.Usuario.DATA_DE_NASCIMENTO)),
                cursor.getString(cursor.getColumnIndex(Conexao.Usuario.SEXO)),
                cursor.getString(cursor.getColumnIndex(Conexao.Usuario.TELEFONE)),
                cursor.getString(cursor.getColumnIndex(Conexao.Usuario.DATA_CRIACAO_CADASTRO)),
                cursor.getString(cursor.getColumnIndex(Conexao.Usuario.DATA_MODIFICACAO_CADASTRO)),
                cursor.getString(cursor.getColumnIndex(Conexao.Usuario.STATUS)));


        return usuario;
    }

    // ESSSA PARTE DO CÓDOGO NÃO SEI SE É NECESSASÁRIA E SE É
    //DESTA MANEIRA QUE FAZ.


    // Maneira de Listar Todos os USUÁRIOS do Banco de Dados

    public List<Usuario> ListaUsuario() {

        // Gerando um Cursor ( Quase que tem os QUERYs)
        Cursor cursor = getDataBase().query(Conexao.Usuario.TABELA, //Cursor ta executando essa seleção que tá sendo feita
                Conexao.Usuario.COLUNAS, null, null, null, null, null);


        //Criando uma Lista de Usuário
        List<Usuario> usuarios = new ArrayList<Usuario>();

        while (cursor.moveToNext()) { // Enquanto o cursos se mover para o proximo ou outra posição

            Usuario modelo = criarUsuario(cursor); // criando um novo objeto e passando parametros do cursor
            usuarios.add(modelo); //adcionando um novo Usuário a lista

        }

        cursor.close(); // fechando o cursor e retornando para enderecos


        return usuarios;
    }


    // Maneira de Salvar os dados no Banco de Dados seja eles não existente ou já existentes

    // Criando um novo metodo e passando um novo objeto da classe Usuário
    public long salvarUsuario(Usuario usuario) {


        // Classe que recebe os valores que serão salvos no banco de dados
        //Tem que informar O nome da Coluna e a Tabela e tambem as informações que deseja salvar nessa Tabela
        ContentValues valores = new ContentValues();


        /* AINDA FALTA CONSEGUIR PEGAR O ID MAIOR E SETAR ELE COMO CHAVE ESTRANGEIRA
        E FALTA PEGAR A DATA ATUAL DO SISTEMA TAMBEM
         */

        //Metodo PUT recebe por parametro os tipos de dados String Key e Short Value
        valores.put(Conexao.Usuario.ID_USUARIO, usuario.getIdUsuario());
        valores.put(Conexao.Usuario.ENDERECO_ID, "1");
        valores.put(Conexao.Usuario.IMAGEMUSUARIO_ID, "1");
        valores.put(Conexao.Usuario.NIVELACESSO_ID, "2");
        valores.put(Conexao.Usuario.NOME_SOBRENOME, usuario.getNome_sobrenome());
        valores.put(Conexao.Usuario.NICK_NAME, usuario.getNick_name());
        valores.put(Conexao.Usuario.SENHA, usuario.getSenha());
        valores.put(Conexao.Usuario.EMAIL, usuario.getEmail());
        valores.put(Conexao.Usuario.CPF, usuario.getCpf());
        valores.put(Conexao.Usuario.DATA_DE_NASCIMENTO, usuario.getData_de_nascimento());
        valores.put(Conexao.Usuario.SEXO, usuario.getSexo());
        valores.put(Conexao.Usuario.TELEFONE, usuario.getTelefone());
        valores.put(Conexao.Usuario.DATA_CRIACAO_CADASTRO, "2016-11-11 14:52:00");
        valores.put(Conexao.Usuario.DATA_MODIFICACAO_CADASTRO, "2016-11-11 15:52:00");
        valores.put(Conexao.Usuario.STATUS, "Ativo");


        if (usuario.getIdUsuario() != null) {
            return sqLiteDatabase.update(Conexao.Usuario.TABELA, valores, "IdUsuario = ?",
                    new String[]{usuario.getIdUsuario().toString()});

        }


        return getDataBase().insert(Conexao.Usuario.TABELA, null, valores);

    }


    // Maneira de REMOVER os dados no Banco de Dados seja eles não existente ou já existentes

    //REMOVENDO USUARIOS DE ACORDO COM O ID
    public boolean removerUsuario(int id) {

        return getDataBase().delete(Conexao.Usuario.TABELA, "IdUsuario = ?", new String[]{(Integer.toString(id))}) > 0;


    }

    // Maneira de BUSCAR os dados no Banco de Dados seja eles não existente ou já existentes

    //BUSCANDO USUARIO DE ACORDO COM O ID
    public Usuario buscarUsuario(int id) {
        Cursor cursor = getDataBase().query(Conexao.Usuario.TABELA, Conexao.Usuario.COLUNAS, "IdUsuario = ?", new String[]{Integer.toString(id)}, null, null, null);

        List<Usuario> usuarios = new ArrayList<Usuario>();

        while (cursor.moveToNext()) {
            Usuario modelo = criarUsuario(cursor);
            usuarios.add(modelo);
            cursor.close();
            return modelo;
        }

        return null;
    }


    public boolean logar(String email, String senha) { // Criando novo objeto e recebendo parametros do "loginActivity"
        Cursor cursor = getDataBase().query(Conexao.Usuario.TABELA, null, "EMAIL = ? AND SENHA = ?", new String[]{email, senha}, null, null, null);

        if (cursor.moveToFirst()) { // Procura e Retorna o Primeiro que for encontrado
            return true;

        } else {
            return false;
        }


    }
}











