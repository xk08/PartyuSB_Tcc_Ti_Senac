package Interacao;

/**
 * Created by MARCOS MARTINS on 01/12/2016.
 */

public class Endereco {

    //Criando os Atributos
    private Integer idEndereco ;
    private String cidade ;
    private String estado ;
    private String pais ;
    private String bairro ;
    private Integer numero ;
    private String rua ;
    private String local_evento ;




    //Criando Metodo Construtor com o mesmo nome da classe que não recebe parametros.
    public Endereco(){

        //Fica vazio por enquanto
    }




    //Criando o metodo Construtor que recebe parametros.
    public Endereco (Integer idEndereco , String cidade , String estado , String pais, String bairro,
                     Integer numero , String rua , String local_evento  ){

        this.idEndereco = idEndereco ;
        this.cidade = cidade ;
        this.estado = estado ;
        this.pais = pais ;
        this.bairro = bairro ;
        this.numero = numero;
        this.rua = rua ;
        this.local_evento = local_evento ;
    }


    // Metodos gerados automaticamente pelo Get And Setters
    public  Integer getIdEndereco() {
        return idEndereco;
    }public void    setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }public String  getCidade() {
        return cidade;
    }public void    setCidade(String cidade) {
        this.cidade = cidade;
    }public String  getPais() {
        return pais;
    }public void    setPais(String pais) {
        this.pais = pais;
    }public String  getEstado() {
        return estado;
    }public void    setEstado(String estado) {
        this.estado = estado;
    }public String  getBairro() {
        return bairro;
    }public void    setBairro(String bairro) {
        this.bairro = bairro;
    }public Integer getNumero() {
        return numero;
    }public void    setNumero(Integer numero) {
        this.numero = numero;
    }public String  getRua() {
        return rua;
    }public void    setRua(String rua) {
        this.rua = rua;
    }public String  getLocal_evento() {
        return local_evento;
    }public void    setLocal_evento(String local_evento) {
        this.local_evento = local_evento;
    }


} // Fim da classe Principal
