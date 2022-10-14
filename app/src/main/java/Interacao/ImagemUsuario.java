package Interacao;

/**
 * Created by marcos martins on 01/12/2016.
 */

public class ImagemUsuario {

    //Criando os Atributos
    private Integer idImagemUsuario ;
    private String imagem_usuario ; // Aqui é o caminho pra imagem no banco, mas poderia ser o BLOOB


    // criando o metodo construtor que tem o mesmo nome da classe
    public  ImagemUsuario () {

        // fica vazio por enquanto
    }



    //Criando o metodo Construtor que recebe parametros.
    public ImagemUsuario (Integer idImagemUsuario , String imagem_usuario){

        this.idImagemUsuario = idImagemUsuario ;
        this.imagem_usuario = imagem_usuario ;

    }



    //metodos gerados Automaticamente pelo Gets And Seter (IR em -> CODE - GENERATE - GET AND SETER )
        public Integer getIdImagemUsuario() {
        return idImagemUsuario;
    }

    public void setIdImagemUsuario(Integer idImagemUsuario) {
        this.idImagemUsuario = idImagemUsuario;
    }

    public String getImagem_usuario() {
        return imagem_usuario;
    }

    public void setImagem_usuario(String imagem_usuario) {
        this.imagem_usuario = imagem_usuario;
    }


} // Final da classe principal
