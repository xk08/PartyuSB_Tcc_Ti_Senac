package Interacao;

/**
 * Created by marcos martins on 01/12/2016.
 */

public class Categoria {

    private Integer idCategoria ;
    private String nome_categoria ;
    private String icone_categoria ; // Aqui é o caminho pra imagem no banco, mas poderia ser o BLOOB


    // criando o metodo construtor que tem o mesmo nome da classe
    public  Categoria (){

        // fica vazio por enquanto
    }


    //criando o mesmo metodo construtor, mas este recebe parametros
    public Categoria(Integer idCategoria ,String nome_categoria, String icone_categoria){

        //variavel da classe vai receber a variavel que está vindo por parametro (This faz referencia a classe)
        this.idCategoria = idCategoria ;
        this.nome_categoria = nome_categoria ;
        this.icone_categoria = icone_categoria ;

    }


    //Metodos gerados automaticamente
    public String getIcone_categoria() {
        return icone_categoria;
    }

    public void setIcone_categoria(String icone_categoria) {
        this.icone_categoria = icone_categoria;
    }

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }


}
