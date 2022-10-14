package Interacao;

import java.util.Date;

/**
 * Created by marcos amrtins on 01/12/2016.
 */

public class Usuario {

    //Criando os Atributos
    private Integer idUsuario ;
    private Integer Endereco_id ;
    private Integer ImagemUsuario_id ;
    private Integer NivelAcesso_id ;
    private String nome_sobrenome ;
    private String nick_name ;
    private String senha ;
    private String email ;
    private String cpf ;
    private String data_de_nascimento ;
    private String sexo ;
    private String telefone ;
    private String data_criacao_cadastro ; // pesquisar se suporta a hora junto
    private String data_modificacao_cadastro ;
    private String status ;


    // criando o metodo construtor que tem o mesmo nome da classe
    public  Usuario (){

        // fica vazio por enquanto
    }


    //criando o mesmo metodo construtor, mas este recebe parametros
    public Usuario(Integer idUsuario , Integer Endereco_id , Integer ImagemUsuario_id,Integer NivelAcesso_id, String nome_sobrenome ,
                   String nick_name , String senha , String email , String cpf , String data_de_nascimento,
                   String sexo , String telefone , String data_criacao_cadastro , String data_modificacao_cadastro,
                   String status){

        //variavel da classe vai receber a variavel que está vindo por parametro (This faz referencia a classe)
        this.idUsuario = idUsuario ;
        this.Endereco_id = Endereco_id ;
        this.ImagemUsuario_id = ImagemUsuario_id ;
        this.NivelAcesso_id = NivelAcesso_id ;
        this.nome_sobrenome = nome_sobrenome ;
        this.nick_name = nick_name ;
        this.senha = senha ;
        this.email = email ;
        this.cpf = cpf ;
        this.data_de_nascimento = data_de_nascimento ;
        this.sexo = sexo ;
        this.telefone = telefone ;
        this.data_criacao_cadastro = data_criacao_cadastro ;
        this.data_modificacao_cadastro = data_modificacao_cadastro ;
        this.status = status ;


    }



    //metodos gerados Automaticamente pelo Gets And Seter (IR em -> CODE - GENERATE - GET AND SETER )
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome_sobrenome() {
        return nome_sobrenome;
    }

    public void setNome_sobrenome(String nome_sobrenome) {
        this.nome_sobrenome = nome_sobrenome;
    }

    public Integer getEndereco_id() {
        return Endereco_id;
    }

    public void setEndereco_id(Integer endereco_id) {
        Endereco_id = endereco_id;
    }

    public Integer getImagemUsuario_id() {
        return ImagemUsuario_id;
    }

    public void setImagemUsuario_id(Integer imagemUsuario_id) {
        ImagemUsuario_id = imagemUsuario_id;
    }

    public Integer getNivelAcesso_id() {
        return NivelAcesso_id;
    }

    public void setNivelAcesso_id(Integer nivelAcesso_id) {
        NivelAcesso_id = nivelAcesso_id;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData_de_nascimento() {
        return data_de_nascimento;
    }

    public void setData_de_nascimento(String data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getData_criacao_cadastro() {
        return data_criacao_cadastro;
    }

    public void setData_criacao_cadastro(String data_criacao_cadastro) {
        this.data_criacao_cadastro = data_criacao_cadastro;
    }

    public String getData_modificacao_cadastro() {
        return data_modificacao_cadastro;
    }

    public void setData_modificacao_cadastro(String data_modificacao_cadastro) {
        this.data_modificacao_cadastro = data_modificacao_cadastro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


} // Fim da classe Principal
