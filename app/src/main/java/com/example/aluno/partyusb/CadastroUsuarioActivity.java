package com.example.aluno.partyusb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import BD.EnderecoBD;
import BD.UsuarioBD;
import Interacao.Endereco;
import Interacao.Usuario;
import util.MensagemGeral;

public class CadastroUsuarioActivity extends AppCompatActivity  implements View.OnClickListener{

    private Endereco endereco;
    EnderecoBD enderecoBD;
    private int idEndereco;

    private Usuario usuario ;
    UsuarioBD usuarioBD ;
    private  int idUsuario ;


    // DECLARANDO OS TEXTS VIEWS
    private TextView cadastro_textview_Descricao ;
    private TextView cadastro_textview_titulo1 ;
    private TextView cadastro_textview_NomeSobrenome ;
    private TextView cadastro_textview_NickName ;
    private TextView cadastro_textview_Cpf ;
    private TextView cadastro_textview_Email ;
    private TextView cadastro_textview_DataDeNascimento ;
    private TextView cadastro_textview_Sexo ;
    private TextView cadastro_textview_Celular ;
    private TextView cadastro_textview_Cidade ;
    private TextView cadastro_textview_Rua ;
    private TextView cadastro_textview_Numero ;
    private TextView cadastro_textview_Bairro ;
    private TextView cadastro_textview_Estado ;
    private TextView cadastro_textview_Pais ;
    private TextView cadastro_textview_Senha ;
    private TextView cadastro_textview_ConfirmarSenha ;
    private TextView cadastro_textview_Rodape ;



    // DECLARANDO OS EDITS TEXTS

    private EditText cadastro_edittext_NomeSobrenome ;
    private EditText cadastro_edittext_NickName ;
    private EditText cadastro_edittext_Cpf ;
    private EditText cadastro_edittext_Email ;
    private EditText cadastro_edittext_DataDeNascimento ;
    private EditText cadastro_edittext_Celular ;
    private EditText cadastro_edittext_Rua ;
    private EditText cadastro_edittext_Numero ;
    private EditText cadastro_edittext_Senha ;
    private EditText cadastro_edittext_ConfirmarSenha ;




    // DECLARANDO OS SPINERS

    private Spinner cadastro_spinner_Estado ;
    private Spinner cadastro_spinner_Pais ;
    private Spinner cadastro_spinner_Sexo ;
    private Spinner cadastro_spinner_Cidade ;
    private Spinner cadastro_spinner_Bairro ;


    // DECLARANDO OS BOTOES
    private Button cadastrar_button_CadastrarUsuario ;



    // DECLARANDO OS CheckBox
    private CheckBox cadastro_checkbox_TermosDeUso ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);


        enderecoBD = new EnderecoBD(this);

        usuarioBD = new UsuarioBD(this) ;


        //ATRIBUINDO O ID PARA DENTRO DA VARIAVEL CRIADA A CIMA  ( NOS TEXTES VIEWS)
        cadastro_textview_titulo1 =  (TextView)  findViewById(R.id.cadastro_textview_titulo1) ;
                cadastro_textview_NickName = (TextView)  findViewById(R.id.cadastro_textview_NickName) ;
                cadastro_textview_NomeSobrenome  = (TextView)  findViewById(R.id.cadastro_textview_NomeSobrenome) ;
                cadastro_textview_Cpf = (TextView)  findViewById(R.id.cadastro_textview_Cpf) ;
                cadastro_textview_Email = (TextView)  findViewById(R.id.cadastro_textview_Email) ;
                cadastro_textview_DataDeNascimento = (TextView)  findViewById(R.id.cadastro_textview_DataDeNascimento) ;
                cadastro_textview_Sexo = (TextView)  findViewById(R.id.cadastro_textview_Sexo) ;
                cadastro_textview_Celular = (TextView)  findViewById(R.id.cadastro_textview_Celular) ;
                cadastro_textview_Cidade = (TextView)  findViewById(R.id.cadastro_textview_Cidade) ;
                cadastro_textview_Rua = (TextView)  findViewById(R.id.cadastro_textview_Rua) ;
                cadastro_textview_Numero = (TextView)  findViewById(R.id.cadastro_textview_Numero) ;
                cadastro_textview_Bairro = (TextView)  findViewById(R.id.cadastro_textview_Bairro) ;
                cadastro_textview_Estado = (TextView)  findViewById(R.id.cadastro_textview_Estado) ;
                cadastro_textview_Pais = (TextView)  findViewById(R.id.cadastro_textview_Pais) ;
                cadastro_textview_Senha = (TextView)  findViewById(R.id.cadastro_textview_Senha) ;
                cadastro_textview_ConfirmarSenha  = (TextView) findViewById(R.id.cadastro_textview_ConfirmarSenha);
                cadastro_textview_Rodape  = (TextView) findViewById(R.id.cadastro_textview_Rodape);
                cadastro_textview_Descricao  = (TextView) findViewById(R.id.cadastro_textview_Descricao);






        //ATRIBUINDO O ID PARA DENTRO DA VARIAVEL CRIADA A CIMA  ( NOS EDIT TEXTS)
        cadastro_edittext_NomeSobrenome = (EditText) findViewById(R.id.cadastro_edittext_NomeSobrenome) ;
                cadastro_edittext_NickName = (EditText) findViewById(R.id.cadastro_edittext_NickName) ;
                cadastro_edittext_Cpf = (EditText) findViewById(R.id.cadastro_edittext_Cpf) ;
                cadastro_edittext_Email = (EditText) findViewById(R.id.cadastro_edittext_Email) ;
                cadastro_edittext_DataDeNascimento = (EditText) findViewById(R.id.cadastro_edittext_DataDeNascimento) ;
                cadastro_edittext_Celular= (EditText) findViewById(R.id.cadastro_edittext_Celular) ;
                cadastro_edittext_Rua = (EditText) findViewById(R.id.cadastro_edittext_Rua) ;
                cadastro_edittext_Numero = (EditText) findViewById(R.id.cadastro_edittext_Numero) ;
                cadastro_edittext_Senha = (EditText) findViewById(R.id.cadastro_edittext_Senha) ;
                cadastro_edittext_ConfirmarSenha= (EditText) findViewById(R.id.cadastro_edittext_ConfirmarSenha) ;



        //ATRIBUINDO O ID PARA DENTRO DA VARIAVEL CRIADA A CIMA  ( NOS SPINERS)
        cadastro_spinner_Estado = (Spinner) findViewById(R.id.cadastro_spinner_Estado);

                ArrayAdapter<CharSequence> adapterSpinnerEstado = ArrayAdapter.createFromResource(this , R.array.Spinner_Estado, android.R.layout.simple_spinner_dropdown_item) ;
                adapterSpinnerEstado.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                cadastro_spinner_Estado.setAdapter(adapterSpinnerEstado);



        cadastro_spinner_Pais = (Spinner) findViewById(R.id.cadastro_spinner_Pais);

                ArrayAdapter<CharSequence> adapterSpinnerPais = ArrayAdapter.createFromResource(this , R.array.Spinner_Pais , android.R.layout.simple_spinner_dropdown_item) ;
                adapterSpinnerPais.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                cadastro_spinner_Pais.setAdapter(adapterSpinnerPais);




        cadastro_spinner_Sexo = (Spinner) findViewById(R.id.cadastro_spinner_Sexo);

                ArrayAdapter<CharSequence> adapterSpinnerSexo = ArrayAdapter.createFromResource(this , R.array.Spinner_Sexo, android.R.layout.simple_spinner_dropdown_item) ;
                adapterSpinnerSexo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                cadastro_spinner_Sexo.setAdapter(adapterSpinnerSexo);




        cadastro_spinner_Cidade = (Spinner) findViewById(R.id.cadastro_spinner_Cidade);

                ArrayAdapter<CharSequence> adapterSpinnerCidade = ArrayAdapter.createFromResource(this , R.array.Spinner_Cidade, android.R.layout.simple_spinner_dropdown_item) ;
                adapterSpinnerCidade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                cadastro_spinner_Cidade.setAdapter(adapterSpinnerCidade);




        cadastro_spinner_Bairro = (Spinner) findViewById(R.id.cadastro_spinner_Bairro);

                ArrayAdapter<CharSequence> adapterSpinnerBairro = ArrayAdapter.createFromResource(this , R.array.Spinner_Bairro, android.R.layout.simple_spinner_dropdown_item) ;
                adapterSpinnerBairro.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                cadastro_spinner_Bairro.setAdapter(adapterSpinnerBairro);

        /*
            //Fazendo a ação ao clickar no elemento
            cadastro_spinner_Estado.setOnClickListener(this);
            cadastro_spinner_Pais.setOnClickListener(this);
            cadastro_spinner_Sexo.setOnClickListener(this);
            cadastro_spinner_Cidade.setOnClickListener(this);
            cadastro_spinner_Bairro.setOnClickListener(this);
        */


        //ATRIBUINDO O ID PARA DENTRO DA VARIAVEL CRIADA A CIMA  ( BUTTONS)
        cadastrar_button_CadastrarUsuario = (Button) findViewById(R.id.cadastrar_button_CadastrarUsuario) ;

                        //Fazendo a ação ao clickar no elemento
                        cadastrar_button_CadastrarUsuario.setOnClickListener(this);

        //ATRIBUINDO O ID PARA DENTRO DA VARIAVEL CRIADA A CIMA  ( CHECK BOX)
        cadastro_checkbox_TermosDeUso = (CheckBox) findViewById(R.id.cadastro_checkbox_TermosDeUso) ;
                       // cadastro_checkbox_TermosDeUso.setOnClickListener(this);



        //FORMATANDO O CPF NO CADASTRO COMPLETO
        SimpleMaskFormatter maskDataCpf = new SimpleMaskFormatter("NNN.NNN.NNN-NN") ;
        MaskTextWatcher maskTextWatcherCpf = new MaskTextWatcher(cadastro_edittext_Cpf , maskDataCpf ) ;
        cadastro_edittext_Cpf.addTextChangedListener(maskTextWatcherCpf);

        //FORMATANDO O DATA DE NASCIMENTO NO CADASTRO COMPLETO
        SimpleMaskFormatter maskDataDeNascimento = new SimpleMaskFormatter("NN/NN/NNNN") ;
        MaskTextWatcher maskTextWatcherNascimento = new MaskTextWatcher(cadastro_edittext_DataDeNascimento , maskDataDeNascimento ) ;
        cadastro_edittext_DataDeNascimento.addTextChangedListener(maskTextWatcherNascimento);

        //FORMATANDO O CELULAR NO CADASTRO COMPLETO
        SimpleMaskFormatter maskDataCelular = new SimpleMaskFormatter("(NN) NNNNN-NNNN") ;
        MaskTextWatcher maskTextWatcherCelular = new MaskTextWatcher(cadastro_edittext_Celular , maskDataCelular ) ;
        cadastro_edittext_Celular.addTextChangedListener(maskTextWatcherCelular);

        //FORMATANDO O NUMERO DA RUA NO CADASTRO COMPLETO
        SimpleMaskFormatter maskNumeroRua = new SimpleMaskFormatter("NNNNNN") ;
        MaskTextWatcher maskTextWatcherNumeroRua = new MaskTextWatcher(cadastro_edittext_Numero , maskNumeroRua) ;
        cadastro_edittext_Numero.addTextChangedListener(maskTextWatcherNumeroRua);


        idUsuario = getIntent().getIntExtra("USUARIO_ID" , 0) ;

        if (idUsuario > 0){
            Usuario model = usuarioBD.buscarUsuario(idUsuario) ;

            //cadastro_spinner_Estado.setText(model.getEstado()) ; -> NÃO SEI COMO SETAR ISSO DAQUI POR SER SPINNER E ENDERECO
            //cadastro_spinner_Pais.setText(model.getPais()) ;
            //cadastro_spinner_Cidade.setText(model.getCidade()) ;
            //cadastro_spinner_Bairro.setText(model.getCidade()) ;

           // cadastro_edittext_Rua.setText(model.getRua);  -> NÃO TA MOSTRANDO OS GET DA TABELA ENDERECO
           // cadastro_edittext_Numero.setText(model.getNumero); -> NÃO TA MOSTRANDO OS GET DA TABELA ENDERECO


            cadastro_edittext_NomeSobrenome.setText(model.getNome_sobrenome());
            cadastro_edittext_NickName.setText(model.getNick_name());
            cadastro_edittext_Cpf.setText(model.getCpf());
            cadastro_edittext_Email.setText(model.getEmail());
            cadastro_edittext_DataDeNascimento.setText(model.getData_de_nascimento());
            cadastro_edittext_Celular.setText(model.getTelefone());
            cadastro_edittext_Senha.setText(model.getSenha());
           // cadastro_spinner_Sexo.setText(model.getSexo()); -> NÃO PEGA POR SER SPINNER

            //setTitle(R.string.mensagem_atualizar);

        }
    }


    protected void onDestoyUsuario() {
        usuarioBD.fechar();
        super.onDestroy();
    }


    public void cadEndereco(){

        boolean validacao = true ;

        String spinnerEstado = cadastro_spinner_Estado.getSelectedItem().toString() ;
        String spinnerPais = cadastro_spinner_Pais.getSelectedItem().toString() ;
        String spinnerCidade = cadastro_spinner_Cidade.getSelectedItem().toString() ;
        String spinnerBairro = cadastro_spinner_Bairro.getSelectedItem().toString() ;
        String rua = cadastro_edittext_Rua.getText().toString() ;
        String numero = cadastro_edittext_Numero.getText().toString() ;

        if (validacao){
            endereco = new Endereco() ;

            endereco.setRua(rua);
            endereco.setNumero(Integer.parseInt(numero));
            endereco.setEstado(spinnerEstado);
            endereco.setPais(spinnerPais);
            endereco.setCidade(spinnerCidade);
            endereco.setBairro(spinnerBairro);

            // Se for alteração
            if (idEndereco > 0) {
                endereco.setIdEndereco(idEndereco);
            }

            long resultado = enderecoBD.salvarEndereco(endereco);

            if (resultado != -1) {
                if (idEndereco > 0) {
                    MensagemGeral.Msg(this, getString(R.string.mensagem_atualizar));

                    // Se for Cadastrar
                } else {
                    this.cadUsuario();
                }
                finish();
                //startActivity(new Intent(this, ListarUsuarioActivity.class));


                // Se for dar algum Erro
            } else {
                MensagemGeral.Msg(this, getString(R.string.mensagem_erro));
            }



        }
    }

    //--------------------------------------

    public void cadUsuario(){

        boolean validacao = true ;

        String nome_sobrenome = cadastro_edittext_NomeSobrenome.getText().toString() ;
        String nick_name = cadastro_edittext_NickName.getText().toString() ;
        String cpf = cadastro_edittext_Cpf.getText().toString() ;
        String email = cadastro_edittext_Email.getText().toString() ;
        String data_de_nascimento = cadastro_edittext_DataDeNascimento.getText().toString() ;
        String celular = cadastro_edittext_Celular.getText().toString() ;
        String senha = cadastro_edittext_Senha.getText().toString() ;
        String sexo = cadastro_spinner_Sexo.getSelectedItem().toString() ;


        if (validacao){
            usuario = new Usuario() ;

            usuario.setNome_sobrenome(nome_sobrenome);
            usuario.setNick_name(nick_name);
            usuario.setCpf(cpf);
            usuario.setEmail(email);
            usuario.setData_de_nascimento(data_de_nascimento);
            usuario.setSenha(senha);
            usuario.setTelefone(celular);
            usuario.setSexo(sexo);



            // Se for alteração
            if (idUsuario > 0) {
                usuario.setIdUsuario(idUsuario);
            }

            long resultado = usuarioBD.salvarUsuario(usuario);

            if (resultado != -1) {
                if (idUsuario > 0) {
                    MensagemGeral.Msg(this, getString(R.string.mensagem_atualizar));

                    // Se for Cadastrar
                } else {
                    MensagemGeral.Msg(this, getString(R.string.mensagem_cadastrar));
                }
                finish();
               // startActivity(new Intent(this, ListarUsuarioActivity.class));


                // Se for dar algum Erro
            } else {
                MensagemGeral.Msg(this, getString(R.string.mensagem_erro));
            }

        }
    }





    @Override
    public void onClick(View v) {
        this.cadUsuario();


        if (cadastrar_button_CadastrarUsuario.isPressed()) {

            startActivity(new Intent(this, ListarUsuarioActivity.class));
        }

        if(cadastro_checkbox_TermosDeUso.isPressed()){


        }





    }
}
