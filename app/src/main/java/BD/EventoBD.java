package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.List;

import Interacao.Evento;

/**
 * Created by MARCOS MARTINS on 02/12/2016.
 */
public class EventoBD {

    // /criado uma variavel para abrir e manipular o Banco de Dados
    private Conexao dataBaseHelper ;


    //Criando variavel que Permite que interações sejam feitas no Banco IMPORTA AUTOMATICAMENTE
    private SQLiteDatabase sqLiteDatabase;


    //criando o metodo contrutor ou Instanciando -> Recebe por padrão um contexto
    public EventoBD(Context context) { //Ira passar qual Activity que está chamando esta classe
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
    private Evento criarEvento(Cursor cursor){

        //instanciando um novo objeto da classe ENDERECO
        Evento evento = new Evento(


                //Pega um valor inteiro - de dentro de um index(exemplo posição em um vetor)- chamado _ID que tá na classe
                //Conecta e Sub-Classe -  EVENTO

                // Esta parte manda para a Classe EVENTO e manda para o metodo construtor que recebe parametros !

                cursor.getInt(cursor.getColumnIndex(Conexao.Evento.ID_EVENTO)),
                cursor.getInt(cursor.getColumnIndex(Conexao.Evento.ENDERECO_ID)),
                cursor.getInt(cursor.getColumnIndex(Conexao.Evento.CATEGORIA_ID)),
                cursor.getInt(cursor.getColumnIndex(Conexao.Evento.IMAGEMEVENTO_ID)),
                cursor.getString(cursor.getColumnIndex(Conexao.Evento.NOME_EVENTO)),
                cursor.getDouble(cursor.getColumnIndex(Conexao.Evento.PRECO_EVENTO)),
                cursor.getString(cursor.getColumnIndex(Conexao.Evento.DATA_EVENTO)),
                cursor.getString(cursor.getColumnIndex(Conexao.Evento.HORA_INICIAL_EVENTO)),
                cursor.getString(cursor.getColumnIndex(Conexao.Evento.HORA_FINAL_EVENTO)),
                cursor.getString(cursor.getColumnIndex(Conexao.Evento.DESCRICAO_EVENTO)),
                cursor.getString(cursor.getColumnIndex(Conexao.Evento.ESTATISTICA_EVENTO)));




        return evento ;
    }

    // ESSSA PARTE DO CÓDOGO NÃO SEI SE É NECESSASÁRIA E SE É
    //DESTA MANEIRA QUE FAZ.


    // Maneira de Listar Todos os EVENTOS do Banco de Dados

    public List<Evento> ListaEvento() {

        // Gerando um Cursor ( Quase que tem os QUERYs)
        Cursor cursor = getDataBase().query(Conexao.Evento.TABELA, //Cursor ta executando essa seleção que tá sendo feita
                Conexao.Evento.COLUNAS, null, null, null, null, null);



        //Criando uma Lista de EVENTOS
        List<Evento> eventos = new ArrayList<Evento>();

        while (cursor.moveToNext()) { // Enquanto o cursos se mover para o proximo ou outra posição

            Evento modelo = criarEvento(cursor); // criando um novo objeto e passando parametros do cursor
            eventos.add(modelo); //adcionando um novo Eventos a lista

        }

        cursor.close(); // fechando o cursor e retornando para enderecos


        return eventos ;
    }

    public List<Evento> ListaEventoUnico(int id) {

        // Gerando um Cursor ( Quase que tem os QUERYs)
        Cursor cursor = getDataBase().query(Conexao.Evento.TABELA , Conexao.Evento.COLUNAS , "IdEvento = ?" , new String[]{Integer.toString(id)} , null , null , null) ;


        //Criando uma Lista de EVENTOS
        List<Evento> eventos = new ArrayList<Evento>();
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            Evento modelo = criarEvento(cursor); // criando um novo objeto e passando parametros do cursor
            eventos.add(modelo); //adcionando um novo Eventos a lista
        }
        cursor.close(); // fechando o cursor e retornando para enderecos
        return eventos ;
    }


    // Gets the Date and Time from a DatePicker and TimePicker and return a JodaTime DateTime from them, in current timezone.
    //


                                // Maneira de Salvar os dados no Banco de Dados seja eles não existente ou já existentes

    // Criando um novo metodo e passando um novo objeto da classe Evento
    public long salvarEvento(Evento evento) {


        // Classe que recebe os valores que serão salvos no banco de dados
        //Tem que informar O nome da Coluna e a Tabela e tambem as informações que deseja salvar nessa Tabela
        ContentValues valores = new ContentValues();

        //Metodo PUT recebe por parametro os tipos de dados String Key e Short Value
        valores.put(Conexao.Evento.ENDERECO_ID, "1");
        valores.put(Conexao.Evento.CATEGORIA_ID, "1");
        valores.put(Conexao.Evento.IMAGEMEVENTO_ID, "1");
        valores.put(Conexao.Evento.NOME_EVENTO, evento.getNome_evento());
        valores.put(Conexao.Evento.PRECO_EVENTO, evento.getPreco_evento());
        valores.put(Conexao.Evento.DATA_EVENTO, evento.getData_evento());
        valores.put(Conexao.Evento.HORA_INICIAL_EVENTO, evento.getHora_inicial_evento());
        valores.put(Conexao.Evento.HORA_FINAL_EVENTO, evento.getHora_final_evento());
        valores.put(Conexao.Evento.DESCRICAO_EVENTO, evento.getDescricao_evento());
        valores.put(Conexao.Evento.ESTATISTICA_EVENTO, "Organizando");




        if (evento.getIdEvento() != null) {
            return sqLiteDatabase.update(Conexao.Evento.TABELA , valores, "IdEvento = ?" ,
                    new String[]{evento.getIdEvento().toString()}   );

        }
        return getDataBase().insert(Conexao.Evento.TABELA , null , valores) ;
    }



    // Maneira de REMOVER os dados no Banco de Dados seja eles não existente ou já existentes

    //REMOVENDO USUARIOS DE ACORDO COM O ID
    public boolean removerEvento(int id){

        return getDataBase().delete(Conexao.Evento.TABELA , "IdEvento = ?" , new String[]{(Integer.toString(id))}) > 0 ;



    }

    // Maneira de BUSCAR os dados no Banco de Dados seja eles não existente ou já existentes

    //BUSCANDO USUARIO DE ACORDO COM O ID
    public Evento buscarEvento(int id){
        Cursor cursor = getDataBase().query(Conexao.Evento.TABELA , Conexao.Evento.COLUNAS , "IdEvento = ?" , new String[]{Integer.toString(id)} , null , null , null) ;

        List<Evento> eventos = new ArrayList<Evento>() ;

        while(cursor.moveToNext()){
            Evento modelo = criarEvento(cursor) ;
            eventos.add(modelo);
            cursor.close();
            return modelo ;
        }

        return null ;
    }

    public Evento buscarEventoUnico(int id){
        Cursor cursor = getDataBase().query(Conexao.Evento.TABELA , Conexao.Evento.COLUNAS , "IdEvento = ?" , new String[]{Integer.toString(id)} , null , null , null) ;

        List<Evento> eventos = new ArrayList<Evento>() ;

        if (cursor.getCount() >0){
            cursor.moveToFirst();

            Evento modelo = criarEvento(cursor) ;
            eventos.add(modelo);
            cursor.close();
            return modelo ;

        }
        return null;
    }



}
