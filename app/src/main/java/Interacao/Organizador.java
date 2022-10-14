package Interacao;

/**
 * Created by Marcos on 01/12/2016.
 */

public class Organizador {


    private Integer idOganizador ;
    private Integer Usuario_id ;
    private Integer Evento_id ;


    // criando o metodo construtor que tem o mesmo nome da classe
    public  Organizador (){

        // fica vazio por enquanto

    }


    //criando o mesmo metodo construtor, mas este recebe parametros
    public Organizador(Integer idOganizador , Integer Usuario_id , Integer Evento_id){

        //variavel da classe vai receber a variavel que está vindo por parametro (This faz referencia a classe)
        this.idOganizador = idOganizador ;
        this.Usuario_id = Usuario_id ;
        this.Evento_id = Evento_id ;

    }


    //METODOS GERADOS AUTOMATICAMENTE PELO GET AND SETTERS
    public Integer getEvento_id() {
        return Evento_id;
    }

    public void setEvento_id(Integer evento_id) {
        Evento_id = evento_id;
    }

    public Integer getUsuario_id() {
        return Usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        Usuario_id = usuario_id;
    }

    public Integer getIdOganizador() {
        return idOganizador;
    }

    public void setIdOganizador(Integer idOganizador) {
        this.idOganizador = idOganizador;
    }



}
