package Interacao;

/**
 * Created by Marcos Martins on 02/12/2016.
 */

public class NivelAcesso{

    private Integer idNivelAcesso ;
    private String nome_acesso ;
    private String data_criacao ;
    private String data_modificacao ;


    // criando o metodo construtor que tem o mesmo nome da classe
    public  NivelAcesso (){

        // fica vazio por enquanto
    }


    //criando o mesmo metodo construtor, mas este recebe parametros
    public NivelAcesso(Integer idNivelAcesso ,String nome_acesso, String data_criacao ,
                       String data_modificacao){

        //variavel da classe vai receber a variavel que está vindo por parametro (This faz referencia a classe)
        this.idNivelAcesso = idNivelAcesso ;
        this.nome_acesso = nome_acesso ;
        this.data_criacao = data_criacao ;
        this.data_modificacao = data_modificacao ;

    }

    //METODOS IMPLEMENTADOS AUTOMATICAMENTE.
    public String getNome_acesso() {
        return nome_acesso;
    }

    public void setNome_acesso(String nome_acesso) {
        this.nome_acesso = nome_acesso;
    }

    public String getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(String data_criacao) {
        this.data_criacao = data_criacao;
    }

    public Integer getIdNivelAcesso() {
        return idNivelAcesso;
    }

    public void setIdNivelAcesso(Integer idNivelAcesso) {
        this.idNivelAcesso = idNivelAcesso;
    }

    public String getData_modificacao() {
        return data_modificacao;
    }

    public void setData_modificacao(String data_modificacao) {
        this.data_modificacao = data_modificacao;
    }
}
