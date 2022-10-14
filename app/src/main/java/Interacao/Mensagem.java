package Interacao;

import java.util.Date;

/**
 * Created by mARcOos martinS on 01/12/2016.
 */

public class Mensagem {

    private Integer idMensagem ;
    private Integer Usuario_id ;
    private Integer Evento_id ;
    private String assunto ;
    private String descricao ;
    private String data_horario ; // Formatar em Data e Hora


    // criando o metodo construtor que tem o mesmo nome da classe
    public  Mensagem (){

        // fica vazio por enquanto
    }


    //criando o mesmo metodo construtor, mas este recebe parametros
    public Mensagem(Integer idMensagem , Integer Usuario_id , Integer Evento_id , String assunto ,  String descricao , String data_horario){

        //variavel da classe vai receber a variavel que está vindo por parametro (This faz referencia a classe)
        this.idMensagem = idMensagem ;
        this.Usuario_id = Usuario_id ;
        this.Evento_id = Evento_id ;
        this.assunto = assunto ;
        this.descricao = descricao ;
        this.data_horario = data_horario ;

    }


//Gerado Automaticamente Pelo Getters And Setters
    public String getData_horario() {
        return data_horario;
    }

    public void setData_horario(String data_horario) {
        this.data_horario = data_horario;
    }

    public Integer getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(Integer idMensagem) {
        this.idMensagem = idMensagem;
    }

    public Integer getUsuario_id() {
        return Usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        Usuario_id = usuario_id;
    }

    public Integer getEvento_id() {
        return Evento_id;
    }

    public void setEvento_id(Integer evento_id) {
        Evento_id = evento_id;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



}
