/*AULA DIA 29/11/16 - MARCIS VINICIUS MARTINS

# 1° PASSO

 - CRIAÇÃO DE UM PACOTE 'DB'
 - CRIAÇÃO DE CLASSE 'Conexão' JAVA NO PACOTE
 - CRIAÇÃO DE TABELAS DO BANCO E INSERSÃO DE DADOS DE ADMN.



 */



package BD;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;


public class Conexao extends SQLiteOpenHelper {

    private final static String BANCO_DE_DADOS = "partiu_sb";  // "final" cria uma constante  do tipo string -> define o nome do banco.

    private final static int VERSAO = 5; // definindo a versão do banco do tipo inteiro  // Static Não precisa Instanciar

    public Conexao(Context context) {


        super(context, BANCO_DE_DADOS, null, VERSAO);
    }

    public void onCreate(SQLiteDatabase db) {


                                            // METODO INPLEMENTANDO AUTOMATICAMENTE PELO 'SQLLITEOPENHELPER'


        //CRIANDO AS TABELAS NO BANCO DE DADOS

        // CRIANDO A TABELA ENDERECO e EXECUTANDO ELA
        String sql = "create table if not exists endereco (" +
                "idEndereco integer primary key autoincrement not null unique," +
                "cidade text(45) default'Sao Borja'," +
                "estado text(2) default 'RS'," +
                "pais text(50) default 'Brasil'," +
                "bairro text(6) null," +
                "numero integer(6)," +
                "rua text(60)," +
                "local_evento text(50) default 'casa')";


        db.execSQL(sql); // executa o sql que foi recem criado ( no parametro vai o nome que recem foi criado)


        // CRIANDO A TABELA IMAGEM USÁRIO e EXECUTANDO ELA
        sql = "create table if not exists imagem_usuario (" +
                "idImagemUsuario integer primary key autoincrement not null unique," +
                "imagem_usuario MEDIUMBLOB )";


        db.execSQL(sql); // executa o sql que foi recem criado


        // CRIANDO A TABELA NÍVEL ACESSO e EXECUTANDO ELA
        sql = "create table if not exists nivel_acesso (" +
                "idNivelAcesso integer primary key autoincrement not null unique," +
                "nome_acesso text(20)  null," +
                "data_criacao datetime  null," +
                "data_modificacao datetime default null )";

        db.execSQL(sql); // executa o sql que foi recem criado


        // CRIANDO A TABELA USUÁRIO e EXECUTANDO ELA
        sql = "create table if not exists usuario (" +
                "idUsuario integer primary key autoincrement not null unique," +
                "Endereco_id integer not null," +
                "ImagemUsuario_id integer not null," +
                "NivelAcesso_id integer not null default '2'," +
                "nome_sobrenome text(50)  null," +
                "nick_name text(20)," +
                "senha text(64)  null," +
                "email text(60)  null," +
                "cpf text(14)," +
                "data_de_nascimento date  null," +
                "sexo text (10)  null," +
                "telefone text(15) null," +
                "data_criacao_cadastro datetime  null," +
                "data_modificacao_cadastro datetime  default null," +
                "status text(10) default 'ativo'," +

                "FOREIGN KEY(Endereco_id)REFERENCES endereco(idEndereco),"+
                "FOREIGN KEY(ImagemUsuario_id)REFERENCES imagem_usuario(idImagemUsuario),"+
                "FOREIGN KEY(NivelAcesso_id)REFERENCES nivel_acesso(idNivelAcesso))";




        db.execSQL(sql); // executa o sql que foi recem criado


        // CRIANDO A TABELA CATEGORIA e EXECUTANDO ELA
        sql = "create table if not exists categoria (" +
                "idCategoria integer primary key autoincrement null unique," +
                "nome_categoria text(20) null," +
                "icone_categoria MEDIUMBLOB null )";


        db.execSQL(sql); // executa o sql que foi recem criado


        // CRIANDO A TABELA IMAGEM_EVENTO e EXECUTANDO ELA
        sql = "create table if not exists imagem_evento (" +
                "idImagemEvento integer primary key autoincrement not null unique," +
                "imagem_evento  MEDIUMBLOB null)";

        db.execSQL(sql); // executa o sql que foi recem criado


        // CRIANDO A TABELA EVENTO e EXECUTANDO ELA
        sql = "create table if not exists evento (" +
                "idEvento integer primary key autoincrement not null unique," +
                "Endereco_id integer not null," +
                "Categoria_id integer not null," +
                "ImagemEvento_id integer not null," +
                "nome_evento text(100) null," +
                "preco_evento double null default 0.00," +
                "data_evento date null," +
                "hora_inicial_evento time null," +
                "hora_final_evento time null," +
                "descricao_evento text(1000) null," +
                "statistica_evento text(15)  default 'Organizando'," +

                "FOREIGN KEY(Endereco_id)REFERENCES endereco(idEndereco),"+
                "FOREIGN KEY(Categoria_id)REFERENCES categoria(idCategoria),"+
                "FOREIGN KEY(ImagemEvento_id)REFERENCES imagem_evento(idImagemEvento))";

        db.execSQL(sql); // executa o sql que foi recem criado


        // CRIANDO A TABELA ORGANIZADOR e EXECUTANDO ELA
        sql = "create table if not exists organizador (" +
                "idOganizador integer primary key autoincrement not null unique," +
                "Usuario_id integer null," +
                "Evento_id integer null,"+

                "FOREIGN KEY(Usuario_id)REFERENCES usuario(idUsuario),"+
                "FOREIGN KEY(Evento_id)REFERENCES evento(idEvento))";

        db.execSQL(sql); // executa o sql que foi recem criado


        // CRIANDO A TABELA MENSAGEM e EXECUTANDO ELA
        sql = "create table if not exists mensagem (" +
                "idMensagem integer primary key autoincrement not null unique," +
                "Usuario_id integer null," +
                "Evento_id integer null," +
                "assunto text(80)  null," +
                "descricao text(500)  null," +
                "data_horario datetime  null,"+

                "FOREIGN KEY(Usuario_id)REFERENCES usuario(idUsuario),"+
                "FOREIGN KEY(Evento_id)REFERENCES evento(idEvento))";


        db.execSQL(sql); // executa o sql que foi recem criado


        // CRIANDO A TABELA MENSAGEM e EXECUTANDO ELA
        sql = "create table if not exists favorito (" +
                "idFavorito integer primary key autoincrement not null unique," +
                "Usuario_id integer null," +
                "Evento_id integer null,"+

                "FOREIGN KEY(Usuario_id)REFERENCES usuario(idUsuario),"+
                "FOREIGN KEY(Evento_id)REFERENCES evento(idEvento))";

        db.execSQL(sql); // executa o sql que foi recem criado


        // CRIANDO A TABELA AVALIAÇÃO ORGANIZADOR e EXECUTANDO ELA
        sql = "create table if not exists avaliacao_organizador (" +
                "idAvaliacao integer primary key autoincrement not null unique," +
                "Organizador_id integer null," +
                "Usuario_id integer null," +
                "nota double null," +
                "comentario text(250) null," +
                "favoritar_organizador integer(1) null,"+

                "FOREIGN KEY(Usuario_id)REFERENCES usuario(idUsuario),"+
                "FOREIGN KEY(Organizador_id)REFERENCES organizador(idOganizador))";



        db.execSQL(sql); // executa o sql que foi recem criado


        // CRIANDO A TABELA AVALIAÇÃO EVENTO e EXECUTANDO ELA
        sql = "create table if not exists avaliacao_evento (" +
                "idAvalicaoEvento integer primary key autoincrement not null unique," +
                "Usuario_id integer null," +
                "Evento_id integer null," +
                "nota double  null," +
                "comentario text(250) null," +
                "status text(20) null,"+

                "FOREIGN KEY(Usuario_id)REFERENCES usuario(idUsuario),"+
                "FOREIGN KEY(Evento_id)REFERENCES evento(idEvento))";

        db.execSQL(sql); // executa o sql que foi recem criado




                                // INSERINDO ALGUNS DADOS DE ADMINISTRADOR, PARA SEREM GERADOS COM O BANCO.

       // Objeto que está pegando a a data e hora atual e salvando no banco
        //long date  = System.currentTimeMillis() ;
       // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        //String dateString = sdf.format(date) ;


        //INSERINDO DADOS PRÉ0FEFINIDOS NA TABELA NIVEIS DE ACESSO
        sql = "insert into nivel_acesso(idNivelAcesso, nome_acesso, data_criacao, data_modificacao) values (1, 'Administrador', '2016-08-05' , null)"; //PEGAR  DIA E HORA ATUAL DO SISTEMA
        db.execSQL(sql);

        sql = "insert into nivel_acesso(idNivelAcesso, nome_acesso, data_criacao, data_modificacao) values (2, 'Usuario', '2016-05-05' , null)";
        db.execSQL(sql);

        //INSERINDO DADOS PRÉ DEFINIDOS NA TABELA ENDERECO
        sql = "insert into endereco(idEndereco,cidade,estado,pais,bairro,numero,rua,local_evento) values (1 , 'São Borja' , 'RS' , 'Brasil' , 'Passo' , '791' , 'Joaquim Nabuco' , 'Casa')";
        db.execSQL(sql);


        //INSERINDO DADOS PRÉ DEFINIDOS NA IMAGEM USUARIO
        sql = "insert into imagem_usuario(idImagemUsuario) values (1)";
        db.execSQL(sql);

        //INSERINDO DADOS PRÉ DEFINIDOS NA IMAGEM USUARIO
        sql = "insert into usuario(idUsuario,Endereco_id,ImagemUsuario_id,NivelAcesso_id,status,nome_sobrenome,nick_name,senha,email,cpf,data_de_nascimento,sexo,telefone,data_criacao_cadastro)" +
                "values (1 , 1 , 1 , 1 , 'ativo' , 'Marcos Gronytzki' , 'xk08' , 'xk08' , 'gronytzki@gmail.com' , '037.296.880-57' , '1997-08-18' , 'Masculino' , '(55)99607-0031' , '2016-11-11')";
        //PEGAR DIA E HORA ATUAL DO SISTEMA
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

                                         //Criando a Sub-Classe ENDERECO

    public static class Endereco {

        public static final String TABELA = "endereco";

        public static final String ID_ENDERECO = "idEndereco";

        public static final String CIDADE = "cidade";

        public static final String ESTADO = "estado";

        public static final String PAIS = "pais";

        public static final String BAIRRO = "bairro";

        public static final String NUMERO = "numero";

        public static final String RUA = "rua";

        public static final String LOCAL_EVENTO = "local_evento";


        public final static String[] COLUNAS = new String[]{

                ID_ENDERECO, CIDADE, ESTADO, PAIS, BAIRRO, NUMERO, RUA, LOCAL_EVENTO

        };

    }
                                 //Criando a Sub-Classe IMAGEM USUÁRIO

    public static class ImagemUsuario {

        public static final String TABELA = "imagem_usuario";

        public static final String ID_IMAGEMUSUARIO = "idImagemUsuario";

        public static final String IMAGEM_USUARIO = "imagem_usuario";


        public final static String[] COLUNAS = new String[]{

                ID_IMAGEMUSUARIO, IMAGEM_USUARIO
        };
    }

                         //Criando a Sub-Classe NIVEL DE ACESSO

    public static class NivelAcesso {

        public static final String TABELA = "nivel_acesso";

        public static final String ID_NIVELACESSO = "idNivelAcesso";

        public static final String NOME_ACESSO = "nome_acesso";

        public static final String DATA_CRIACAO = "data_criacao";

        public static final String DATA_MODIFICACAO = "data_modificacao";


        public final static String[] COLUNAS = new String[]{

                ID_NIVELACESSO, NOME_ACESSO, DATA_CRIACAO, DATA_MODIFICACAO
        };
    }


                                //Criando a Sub-Classe USUÁRIO

    public static class Usuario {

        public static final String TABELA = "usuario";

        public static final String ID_USUARIO = "idUsuario";

        public static final String ENDERECO_ID = "Endereco_id";

        public static final String IMAGEMUSUARIO_ID = "ImagemUsuario_id";

        public static final String NIVELACESSO_ID = "NivelAcesso_id" ;

        public static final String NOME_SOBRENOME = "nome_sobrenome";

        public static final String NICK_NAME = "nick_name";

        public static final String SENHA = "senha";

        public static final String EMAIL = "email";

        public static final String CPF = "cpf";

        public static final String DATA_DE_NASCIMENTO = "data_de_nascimento";

        public static final String SEXO = "sexo";

        public static final String TELEFONE = "telefone";

        public static final String DATA_CRIACAO_CADASTRO = "data_criacao_cadastro";

        public static final String DATA_MODIFICACAO_CADASTRO = "data_modificacao_cadastro";

        public static final String STATUS = "status";


        public final static String[] COLUNAS = new String[]{

                ID_USUARIO, ENDERECO_ID, IMAGEMUSUARIO_ID , NIVELACESSO_ID ,  NOME_SOBRENOME, NICK_NAME, SENHA, EMAIL, CPF, DATA_DE_NASCIMENTO,
                SEXO, TELEFONE, DATA_CRIACAO_CADASTRO, DATA_MODIFICACAO_CADASTRO, STATUS

        };
    }

                                 //Criando a Sub-Classe CATEGORIA

    public static class Categoria {

        public static final String TABELA = "categoria";

        public static final String ID_CATEGORIA = "idCategoria";

        public static final String NOME_CATEGORIA = "nome_categoria";

        public static final String ICONE_CATEGORIA = "icone_categoria";


        public final static String[] COLUNAS = new String[]{

                ID_CATEGORIA, NOME_CATEGORIA, ICONE_CATEGORIA
        };
    }

                        //Criando a Sub-Classe IMAGEM EVENTO

    public static class ImagemEvento {

        public static final String TABELA = "imagem_evento";

        public static final String ID_IMAGEMEVENTO = "idImagemEvento";

        public static final String IMAGEM_EVENTO = "imagem_evento";


        public final static String[] COLUNAS = new String[]{

                ID_IMAGEMEVENTO, IMAGEM_EVENTO
        };
    }


                                    //Criando a Sub-Classe EVENTO

    public static class Evento {

        public static final String TABELA = "evento";

        public static final String ID_EVENTO = "idEvento";

        public static final String ENDERECO_ID = "Endereco_id";

        public static final String CATEGORIA_ID = "Categoria_id";

        public static final String IMAGEMEVENTO_ID = "ImagemEvento_id";

        public static final String NOME_EVENTO = "nome_evento";

        public static final String PRECO_EVENTO = "preco_evento";

        public static final String DATA_EVENTO = "data_evento";

        public static final String HORA_INICIAL_EVENTO = "hora_inicial_evento";

        public static final String HORA_FINAL_EVENTO = "hora_final_evento";

        public static final String DESCRICAO_EVENTO = "descricao_evento";

        public static final String ESTATISTICA_EVENTO = "statistica_evento";


        public final static String[] COLUNAS = new String[]{

                ID_EVENTO, ENDERECO_ID, CATEGORIA_ID, IMAGEMEVENTO_ID, NOME_EVENTO, PRECO_EVENTO, DATA_EVENTO, HORA_INICIAL_EVENTO, HORA_FINAL_EVENTO,
                DESCRICAO_EVENTO, ESTATISTICA_EVENTO
        };
    }


                                 //Criando a Sub-Classe ORGANIZADOR

    public static class Organizador {

        public static final String TABELA = "organizador";

        public static final String ID_ORGANIZADOR = "idOganizador";

        public static final String USUARIO_ID = "Usuario_id";

        public static final String EVENTO_ID = "Evento_id";


        public final static String[] COLUNAS = new String[]{

                ID_ORGANIZADOR, USUARIO_ID, EVENTO_ID
        };
    }

                                //Criando a Sub-Classe MENSAGEM


    public static class Mensagem {

        public static final String TABELA = "mensagem";

        public static final String ID_MENSAGEM = "idMensagem";

        public static final String USUARIO_ID = "Usuario_id";

        public static final String EVENTO_ID = "Evento_id";

        public static final String ASSUNTO = "assunto";

        public static final String DESCRICAO = "descricao";

        public static final String DATA_HORARIO = "data_horario";


        public final static String[] COLUNAS = new String[]{

                ID_MENSAGEM, USUARIO_ID, EVENTO_ID, ASSUNTO, DESCRICAO, DATA_HORARIO
        };
    }


                                //Criando a Sub-Classe FAVORITO

    public static class Favorito {

        public static final String TABELA = "favorito";

        public static final String ID_FAVORITO = "idFavorito";

        public static final String USUARIO_ID = "Usuario_id";

        public static final String EVENTO_ID = "Evento_id";


        public final static String[] COLUNAS = new String[]{

                ID_FAVORITO, USUARIO_ID, EVENTO_ID
        };
    }

                        //Criando a Sub-Classe AVALIAÇÃO ORGANIZADOR


    public static class AvaliacaoOrganizador {

        public static final String TABELA = "avaliacao_organizador";

        public static final String ID_AVALIACAO = "idAvaliacao";

        public static final String ORGANIZADOR_ID = "Organizador_id" ;

        public static final String USUARIO_ID = "Usuario_id";

        public static final String NOTA = "nota";

        public static final String COMENTARIO = "comentario";

        public static final String FAVORITAR_ORGANIZADOR = "favoritar_organizador";


        public final static String[] COLUNAS = new String[]{

                ID_AVALIACAO , ORGANIZADOR_ID , USUARIO_ID, NOTA, COMENTARIO, FAVORITAR_ORGANIZADOR
        };
    }

                                //Criando a Sub-Classe AVALIAÇÃO EVENTO


    public static class AvaliacaoEvento {

        public static final String TABELA = "avaliacao_evento";

        public static final String ID_AVALIACAOEVENTO = "idAvalicaoEvento";

        public static final String USUARIO_ID = "Usuario_id";

        public static final String EVENTO_ID = "Evento_id";

        public static final String NOTA = "nota";

        public static final String COMENTARIO = "comentario";

        public static final String STATUS = "status";


        public final static String[] COLUNAS = new String[]{

                ID_AVALIACAOEVENTO, USUARIO_ID, NOTA, COMENTARIO, EVENTO_ID, STATUS
        };
    }
}








