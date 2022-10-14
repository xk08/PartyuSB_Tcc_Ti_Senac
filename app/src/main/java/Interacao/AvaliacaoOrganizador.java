package Interacao;

/**
 * Created by Marcos on 01/12/2016.
 */

public class AvaliacaoOrganizador {

    private Integer idAvaliacao ;
    private Integer Organizador_id ;
    private Integer Usuario_id;
    private Double nota ;
    private String comentario ;
    private Integer favoritar_organizador ;


    // criando o metodo construtor que tem o mesmo nome da classe
    public  AvaliacaoOrganizador (){

        // fica vazio por enquanto
    }



    //criando o mesmo metodo construtor, mas este recebe parametros
    public AvaliacaoOrganizador(Integer idAvaliacao , Integer Organizador_id ,  Integer Usuario_id , Double nota ,
                                String comentario , Integer favoritar_organizador){

        //variavel da classe vai receber a variavel que está vindo por parametro (This faz referencia a classe)
        this.idAvaliacao = idAvaliacao ;
        this.Organizador_id = Organizador_id ;
        this.Usuario_id = Usuario_id ;
        this.nota = nota ;
        this.comentario = comentario ;
        this.favoritar_organizador = favoritar_organizador ;


    }


    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Integer getUsuario_id() {
        return Usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        Usuario_id = usuario_id;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Integer getFavoritar_organizador() {
        return favoritar_organizador;
    }

    public Integer getOrganizador_id() {
        return Organizador_id;
    }

    public void setOrganizador_id(Integer organizador_id) {
        Organizador_id = organizador_id;
    }

    public void setFavoritar_organizador(Integer favoritar_organizador) {
        this.favoritar_organizador = favoritar_organizador;

    }
}
