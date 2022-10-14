package Interacao;

/**
 * Created by Marcos martins on 01/12/2016.
 */

public class ImagemEvento {


    private Integer idImagemEvento ;
    private String imagem_evento ; // poderia ser o blob



    // criando o metodo construtor que tem o mesmo nome da classe
    public  ImagemEvento (){

        // fica vazio por enquanto
    }


    //criando o mesmo metodo construtor, mas este recebe parametros
    public ImagemEvento(Integer idImagemEvento, String imagem_evento){

        //variavel da classe vai receber a variavel que está vindo por parametro (This faz referencia a classe)
        this.idImagemEvento = idImagemEvento ;
        this.imagem_evento = imagem_evento ;
    }



    // Implementados Automaticamente
    public Integer getIdImagemEvento() {
        return idImagemEvento;
    }

    public void setIdImagemEvento(Integer idImagemEvento) {
        this.idImagemEvento = idImagemEvento;
    }

    public String getImagem_evento() {
        return imagem_evento;
    }

    public void setImagem_evento(String imagem_evento) {
        this.imagem_evento = imagem_evento;
    }

}
