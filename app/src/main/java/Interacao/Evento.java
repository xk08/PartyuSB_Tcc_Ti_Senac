package Interacao;

import java.util.Date;

/**
 * Created by MARCOS MARTINS on 01/12/2016.
 */

public class Evento {

    private Integer idEvento ;
    private Integer Endereco_id ;
    private Integer Categoria_id ;
    private Integer ImagemEvento_id ;
    private String nome_evento ;
    private Double preco_evento;
    private String data_evento ;
    private String hora_inicial_evento; // Fazera conversão pra pegar APENAS A HORA
    private String hora_final_evento ; // Fazera conversão pra pegar APENAS A HORA
    private String descricao_evento ;
    private String statistica_evento ;


    // criando o metodo construtor que tem o mesmo nome da classe
    public  Evento (){

        // fica vazio por enquanto
    }



    //criando o mesmo metodo construtor, mas este recebe parametros
    public Evento(Integer idEvento, Integer Endereco_id,  Integer Categoria_id, Integer ImagemEvento_id ,
                  String nome_evento , Double preco_evento ,  String data_evento , String hora_inicial_evento ,
                  String hora_final_evento , String descricao_evento , String statistica_evento){

        //variavel da classe vai receber a variavel que está vindo por parametro (This faz referencia a classe)
        this.idEvento = idEvento ;
        this.Endereco_id = Endereco_id ;
        this.Categoria_id = Categoria_id ;
        this.ImagemEvento_id = ImagemEvento_id ;
        this.nome_evento = nome_evento ;
        this.preco_evento = preco_evento ;
        this.data_evento = data_evento ;
        this.hora_inicial_evento = hora_inicial_evento ;
        this.hora_final_evento = hora_final_evento ;
        this.descricao_evento = descricao_evento ;
        this.statistica_evento = statistica_evento ;

    }



    // Gerados Automaticamente
    public String getData_evento() {
        return data_evento;
    }

    public void setData_evento(String data_evento) {
        this.data_evento = data_evento;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Integer getEndereco_id() {
        return Endereco_id;
    }

    public void setEndereco_id(Integer endereco_id) {
        Endereco_id = endereco_id;
    }

    public Integer getCategoria_id() {
        return Categoria_id;
    }

    public void setCategoria_id(Integer categoria_id) {
        Categoria_id = categoria_id;
    }

    public Integer getImagemEvento_id() {
        return ImagemEvento_id;
    }

    public void setImagemEvento_id(Integer imagemEvento_id) {
        ImagemEvento_id = imagemEvento_id;
    }

    public String getNome_evento() {
        return nome_evento;
    }

    public void setNome_evento(String nome_evento) {
        this.nome_evento = nome_evento;
    }

    public Double getPreco_evento() {
        return preco_evento;
    }

    public void setPreco_evento(Double preco_evento) {
        this.preco_evento = preco_evento;
    }

    public String getHora_inicial_evento() {
        return hora_inicial_evento;
    }

    public void setHora_inicial_evento(String hora_inicial_evento) {
        this.hora_inicial_evento = hora_inicial_evento;
    }

    public String getHora_final_evento() {
        return hora_final_evento;
    }

    public void setHora_final_evento(String hora_final_evento) {
        this.hora_final_evento = hora_final_evento;
    }

    public String getDescricao_evento() {
        return descricao_evento;
    }

    public void setDescricao_evento(String descricao_evento) {
        this.descricao_evento = descricao_evento;
    }

    public String getStatistica_evento() {
        return statistica_evento;
    }

    public void setStatistica_evento(String statistica_evento) {
        this.statistica_evento = statistica_evento;
    }

}
