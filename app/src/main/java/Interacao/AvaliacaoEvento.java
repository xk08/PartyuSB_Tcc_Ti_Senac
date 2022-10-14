package Interacao;

/**
 * Created by Marcos Martins on 01/12/2016.
 */

public class AvaliacaoEvento {

    private Integer idAvalicaoEvento ;
    private Integer Usuario_id;
    private Integer Evento_id;
    private Double nota ;
    private String comentario ;
    private String status ;


    // criando o metodo construtor que tem o mesmo nome da classe
    public  AvaliacaoEvento (){

        // fica vazio por enquanto
    }



    //criando o mesmo metodo construtor, mas este recebe parametros
    public AvaliacaoEvento(Integer idAvalicaoEvento , Integer Usuario_id , Integer Evento_id ,  Double nota ,
                                String comentario , String status){

        //variavel da classe vai receber a variavel que está vindo por parametro (This faz referencia a classe)
        this.idAvalicaoEvento = idAvalicaoEvento ;
        this.Usuario_id = Usuario_id ;
        this.Evento_id = Evento_id ;
        this.nota = nota ;
        this.comentario = comentario ;
        this.status = status ;

    }



    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getIdAvalicaoEvento() {
        return idAvalicaoEvento;
    }

    public void setIdAvalicaoEvento(Integer idAvalicaoEvento) {
        this.idAvalicaoEvento = idAvalicaoEvento;
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

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
