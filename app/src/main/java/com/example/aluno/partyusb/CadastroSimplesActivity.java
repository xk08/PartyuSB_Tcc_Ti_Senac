package com.example.aluno.partyusb;

import android.app.Activity;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import BD.EnderecoBD;
import BD.UsuarioBD;
import Interacao.Endereco;
import Interacao.Usuario;
import util.MensagemGeral;

public class CadastroSimplesActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView cadastrosimples_textview_Titulo;
    private TextView cadastrosimples_textview_Descricao;
    private TextView cadastrosimples_textview_NomeSobrenome;
    private TextView cadastrosimples_textview_Email;
    private TextView cadastrosimples_textview_DataDeNascimento;
    private TextView cadastrosimples_textview_Cidade;
    private TextView cadastrosimples_textview_Bairro;
    private TextView cadastrosimples_textview_Sexo;
    private TextView cadastrosimples_textview_Senha;
    private TextView cadastrosimples_textview_ConfirmarSenha;
    private TextView cadastrosimples_textview_CadastroCompleto;
    private TextView cadastrosimples_textview_Rodape;

    private ImageView cadastrosimples_imageview_Logo;
    private ImageButton cadastrosimples_imagebutton_CadastroFaceBook;

    private EditText cadastrosimples_edittext_NomeSobrenome;
    private EditText cadastrosimples_edittext_Email;
    private EditText cadastrosimples_edittext_DataDeNascimento;
    private EditText cadastrosimples_edittext_Senha;
    private EditText cadastrosimples_edittext_ConfirmarSenha;

    private Spinner cadastrosimples_spinner_Cidade;
    private Spinner cadastrosimples_spinner_Bairro;
    private Spinner cadastrosimples_spinner_Sexo;

    private CheckBox cadastrosimples_checkbox_TermosDeUso;

    private Button cadastrosimples_button_Cadastrar;

    //-------------

    private Usuario usuario;
    private UsuarioBD usuarioBD;
    private int idUsuario;

    private Endereco endereco;
    EnderecoBD enderecoBD;
    private int idEndereco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_simples);

        usuarioBD = new UsuarioBD(this); //Atribuindo a activity atual ao usuarioBD
        enderecoBD = new EnderecoBD(this);


        cadastrosimples_textview_Titulo = (TextView) findViewById(R.id.cadastrosimples_textview_Titulo);
        cadastrosimples_textview_Descricao = (TextView) findViewById(R.id.cadastrosimples_textview_Descricao);
        cadastrosimples_textview_NomeSobrenome = (TextView) findViewById(R.id.cadastrosimples_textview_NomeSobrenome);
        cadastrosimples_textview_Email = (TextView) findViewById(R.id.cadastrosimples_textview_Email);
        cadastrosimples_textview_DataDeNascimento = (TextView) findViewById(R.id.cadastrosimples_textview_DataDeNascimento);
        cadastrosimples_textview_Cidade = (TextView) findViewById(R.id.cadastrosimples_textview_Cidade);
        cadastrosimples_textview_Bairro = (TextView) findViewById(R.id.cadastrosimples_textview_Bairro);
        cadastrosimples_textview_Sexo = (TextView) findViewById(R.id.cadastrosimples_textview_Sexo);
        cadastrosimples_textview_Senha = (TextView) findViewById(R.id.cadastrosimples_textview_Senha);
        cadastrosimples_textview_ConfirmarSenha = (TextView) findViewById(R.id.cadastrosimples_textview_ConfirmarSenha);
        cadastrosimples_textview_CadastroCompleto = (TextView) findViewById(R.id.cadastrosimples_textview_CadastroCompleto);
        cadastrosimples_textview_Rodape = (TextView) findViewById(R.id.cadastrosimples_textview_Rodape);

        cadastrosimples_textview_CadastroCompleto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CadastroSimplesActivity.this, CadastroUsuarioActivity.class));

            }
        });

        //-----

        cadastrosimples_imageview_Logo = (ImageView) findViewById(R.id.cadastrosimples_imageview_Logo);
        //cadastrosimples_imagebutton_CadastroFaceBook = (ImageButton) findViewById(R.id.cadastrosimples_imagebutton_CadastroFaceBook);
        //cadastrosimples_imagebutton_CadastroFaceBook.setOnClickListener(this);

        //-----

        cadastrosimples_edittext_NomeSobrenome = (EditText) findViewById(R.id.cadastrosimples_edittext_NomeSobrenome);
        cadastrosimples_edittext_Email = (EditText) findViewById(R.id.cadastrosimples_edittext_Email);
        cadastrosimples_edittext_DataDeNascimento = (EditText) findViewById(R.id.cadastrosimples_edittext_DataDeNascimento);
        cadastrosimples_edittext_Senha = (EditText) findViewById(R.id.cadastrosimples_edittext_Senha);
        cadastrosimples_edittext_ConfirmarSenha = (EditText) findViewById(R.id.cadastrosimples_edittext_ConfirmarSenha);

        //-----

        cadastrosimples_spinner_Cidade = (Spinner) findViewById(R.id.cadastrosimples_spinner_Cidade);

        ArrayAdapter<CharSequence> adapterSpinnerCidade = ArrayAdapter.createFromResource(this, R.array.Spinner_Cidade, android.R.layout.simple_spinner_dropdown_item);
        adapterSpinnerCidade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cadastrosimples_spinner_Cidade.setAdapter(adapterSpinnerCidade);

        cadastrosimples_spinner_Bairro = (Spinner) findViewById(R.id.cadastrosimples_spinner_Bairro);

        ArrayAdapter<CharSequence> adapterSpinnerBairro = ArrayAdapter.createFromResource(this, R.array.Spinner_Bairro, android.R.layout.simple_spinner_dropdown_item);
        adapterSpinnerBairro.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cadastrosimples_spinner_Bairro.setAdapter(adapterSpinnerBairro);

        cadastrosimples_spinner_Sexo = (Spinner) findViewById(R.id.cadastrosimples_spinner_Sexo);

        ArrayAdapter<CharSequence> adapterSpinnerSexo = ArrayAdapter.createFromResource(this, R.array.Spinner_Sexo, android.R.layout.simple_spinner_dropdown_item);
        adapterSpinnerSexo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cadastrosimples_spinner_Sexo.setAdapter(adapterSpinnerSexo);

                /*
            //Fazendo a ação ao clickar no elemento
            cadastrosimples_spinner_Cidade.setOnClickListener(this);
            cadastrosimples_spinner_Bairro.setOnClickListener(this);
            cadastrosimples_spinner_Sexo.setOnClickListener(this);
        */


        //-----

        cadastrosimples_checkbox_TermosDeUso = (CheckBox) findViewById(R.id.cadastrosimples_checkbox_TermosDeUso);
        // cadastrosimples_checkbox_TermosDeUso.setOnClickListener(this);

        //-----

        cadastrosimples_button_Cadastrar = (Button) findViewById(R.id.cadastrosimples_button_Cadastrar);
        cadastrosimples_button_Cadastrar.setOnClickListener(this);


        //FORMATANDO A DATA NO CADASTRO SIMPLES
        SimpleMaskFormatter maskDataNascimento = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher maskTextWatcher = new MaskTextWatcher(cadastrosimples_edittext_DataDeNascimento, maskDataNascimento);
        cadastrosimples_edittext_DataDeNascimento.addTextChangedListener(maskTextWatcher);


        // PARTE REFERENTE AO CRUD

        idUsuario = getIntent().getIntExtra("USUARIO_ID", 0);

        if (idUsuario > 0) {

            Usuario model = usuarioBD.buscarUsuario(idUsuario);

            cadastrosimples_edittext_NomeSobrenome.setText(model.getNome_sobrenome());
            cadastrosimples_edittext_Email.setText(model.getEmail());
            cadastrosimples_edittext_DataDeNascimento.setText(model.getData_de_nascimento());
            cadastrosimples_edittext_Senha.setText(model.getSenha());

            setTitle(R.string.Atualizar_Evento);

        }
    }

    protected void onDestroyEndereco() {

        enderecoBD.fechar();
        super.onDestroy();
    }

    public void cadastrarEndereco() {

        boolean validacao = true;

        String spinnerCidade = cadastrosimples_spinner_Cidade.getSelectedItem().toString();
        String spinnerBairro = cadastrosimples_spinner_Bairro.getSelectedItem().toString();


        if (validacao) {
            endereco = new Endereco();

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
                    this.cadastrarUsuario();
                }
                finish();
                //startActivity(new Intent(this, ListarUsuarioActivity.class));


                // Se for dar algum Erro
            } else {
                MensagemGeral.Msg(this, getString(R.string.mensagem_erro));
            }

        }
    }

    //--------------------------

    protected void onDestroyUsuario() {

        usuarioBD.fechar();
        super.onDestroy();
    }

    public void cadastrarUsuario() {

        boolean validacao = true;

        String nome_sobrenome = cadastrosimples_edittext_NomeSobrenome.getText().toString();
        String email = cadastrosimples_edittext_Email.getText().toString();
        String data_de_nascimento = cadastrosimples_edittext_DataDeNascimento.getText().toString();
        String senha = cadastrosimples_edittext_Senha.getText().toString();
        String spinnerSexo = cadastrosimples_spinner_Sexo.getSelectedItem().toString();



        /*

        if ((nome_sobrenome == null) || (nome_sobrenome.equals(""))) {
            validacao = false;
            cadastrosimples_edittext_NomeSobrenome.setError(getString(R.string.Campos_Obrigatorios));
        }

        if ((email == null) || (email.equals(""))) {
            validacao = false;
            cadastrosimples_edittext_Email.setError(getString(R.string.Campos_Obrigatorios));
        }

        if ((data_de_nascimento == null) || (data_de_nascimento.equals(""))) {
            validacao = false;
            cadastrosimples_edittext_DataDeNascimento.setError(getString(R.string.Campos_Obrigatorios));

        }

        if ((senha == null) || (senha.equals(""))) {
            validacao = false;
            cadastrosimples_edittext_Senha.setError(getString(R.string.Campos_Obrigatorios));

        }

        // Não foi feita ação nenhuma apra os SPINNER ATÉ O MOMENTO


        */

        if (validacao) {

            usuario = new Usuario();

            usuario.setNome_sobrenome(nome_sobrenome);
            usuario.setEmail(email);
            usuario.setData_de_nascimento(data_de_nascimento);
            usuario.setSenha(senha);
            usuario.setSexo(spinnerSexo);

            // Se for Alteração de Dados
            if (idUsuario > 0) {
                usuario.setIdUsuario(idUsuario);
            }

            long resultado = usuarioBD.salvarUsuario(usuario);

            if (resultado != -1) {

                if (idUsuario > 0) {
                    MensagemGeral.Msg(this, getString(R.string.mensagem_atualizar));

                    //Se for Cadastro de Dados
                } else {
                    MensagemGeral.Msg(this, getString(R.string.mensagem_cadastrar));
                }

                finish();

                //startActivity(new Intent(this, ListarUsuarioActivity.class));

                // Caso de Algum Erro apresentará esta mensagem
            } else {
                MensagemGeral.Msg(this, getString(R.string.mensagem_erro));
            }
        }
    }


    @Override
    public void onClick(View view) {

        this.cadastrarUsuario();

        if (cadastrosimples_button_Cadastrar.isPressed()) {

            Intent intentUsuario = new Intent(this, ListarUsuarioActivity.class); // criando um novo objeto da classe Intent e passado os parametros a outra activity

            startActivity(intentUsuario); // comecando a activity

            //finish(); // finaliza a activity anterior

            overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);

        }
    }
}





