package com.example.aluno.partyusb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import BD.UsuarioBD;
import util.MensagemGeral;

public class TelaLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView telalogin_imageview_Logo;
    private ImageButton telalogin_imagebutton_FaceBook ;


    private TextView telalogin_textview_Descricao;
    private TextView telalogin_textview_Login;
    private TextView telalogin_textview_Senha;
    private TextView telalogin_textview_EsqueceuSenha;
    private TextView telalogin_textview_Rodape;

    private EditText telalogin_edittext_Login;
    private EditText telalogin_edittext_Senha;

    private Button telalogin_button_Logar;

    private CheckBox telalogin_checkbox_ManterConectado;

    //----------------


    //Criando as contantes FINAL DEFINE QUE É UMA CONSTANTE
    private static final String MANTER_CONECTADO = "manter conectado";

    private static final String PREFERENCE_NAME = "LoginActivityPreference";


    // Criando um objeto da classe criada pro banco de dados.
    private UsuarioBD helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        helper = new UsuarioBD(this);

        telalogin_imageview_Logo = (ImageView) findViewById(R.id.telalogin_imageview_Logo);
        //telalogin_imagebutton_FaceBook = (ImageButton) findViewById(R.id.telalogin_imagebutton_FaceBook);

        telalogin_textview_Descricao = (TextView) findViewById(R.id.telalogin_textview_Descricao);
        telalogin_textview_Login = (TextView) findViewById(R.id.telalogin_textview_Login);
        telalogin_textview_Senha = (TextView) findViewById(R.id.telalogin_textview_Senha);
        telalogin_textview_EsqueceuSenha = (TextView) findViewById(R.id.telalogin_textview_EsqueceuSenha);
        telalogin_textview_Rodape = (TextView) findViewById(R.id.telalogin_textview_Rodape);

        telalogin_edittext_Login = (EditText) findViewById(R.id.telalogin_edittext_Login);
        telalogin_edittext_Senha = (EditText) findViewById(R.id.telalogin_edittext_Senha);

        telalogin_button_Logar = (Button) findViewById(R.id.telalogin_button_Logar);

        telalogin_checkbox_ManterConectado = (CheckBox) findViewById(R.id.telalogin_checkbox_ManterConectado);

        telalogin_button_Logar.setOnClickListener(this);
        //telalogin_checkbox_ManterConectado.setOnClickListener(this);




       // telalogin_imagebutton_FaceBook.setOnClickListener(this) ;

        //--------------------------------------------------------------------------------------------

        // Irá Pegar o Arquivo de Preferencia que foi salvo e testar
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);


        //Caso não tenha encontrado nada no 'Manter_Conectado' será Atribuido o Valor Falso
        boolean conectado = sharedPreferences.getBoolean(MANTER_CONECTADO, false);


        if (conectado==true) {
            chamarMenuNavegacao(); // Se o teste for correto, irá chamar a Activity Desejada.
        }


    }

    // Criando um Metodo pra a partir de uma activity atual- chamar uma outra e encerrar a que chamou.
    public void chamarMenuNavegacao() {
        startActivity(new Intent(this, MenuNavegacaoActivity.class)); // comando para iniciar a Activity que recebe 2 parametros( qual local que tá chamando ,  e qual tela que tá sendo chamada )
        finish(); // finalizando a activity que está chamando.

    }

    @Override

    public void onClick(View view) {

            logar() ;

        }




    //Criando um Novo Metodo para Logar

    public void logar() {

        String email = telalogin_edittext_Login.getText().toString(); // Criando variaveis que recebem o que foi digitado nos EditTexts
        String senha = telalogin_edittext_Senha.getText().toString();

        boolean validacao = true; // criando um nova variavel que já começa com um valor definido.


        // Fazendo o teste logico e testanto se o usuario não digitou nada ou deixou nulo
        if ((email == null) || (email.equals(""))) {
            validacao = false;
            telalogin_edittext_Login.setError("E-mail inválido !!"); // mostrando de erro criado no <String>

        }
        if ((senha == null) || (senha.equals(""))) {
            validacao = false;
            telalogin_edittext_Senha.setError("Senha Inválida");

        }

        if (validacao) { // A condição assim, significa que é Verdadeiro, pois no inicio do codigo da classe foi definido como True.

           // Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();

            // Se a validação tiver sido POSITIVA irá fazer os comando abaixo e enviar os parametros para a classe UsuárioDB
            if (helper.logar(email, senha)) {

                if (telalogin_checkbox_ManterConectado.isChecked()) {
                    // Cria um arquivo de preferencia, onde é passado um nome para o arquivo e um tipo ou modo -> recomenda-se deixar privado
                    SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE); // Criando um nome objeto da classe SharedPreferences e usando um metodo que pega as preferencias e atribui neste objeto criado.
                    SharedPreferences.Editor editor = sharedPreferences.edit(); // Criando um novo objeto do tipo editor para fazer as edições no arquivo de preferencia

                    editor.putBoolean(MANTER_CONECTADO, true); // chamando o objeto criado 'editor' e deixando ele atravez do PUTBLOOLEAN como sempre conectado - utiliza de parametro (o nome da preferencia e o tipo( true ou false))
                    editor.commit(); // comando para executar/enviar o que foi criado.
                }
             //   startActivity(new Intent(this, MenuNavegacaoActivity.class));
                chamarMenuNavegacao(); // chamando a Activity Expecifica
            } else {
                // Se o Login for Incorreto ele cai nesta condição, E chama o metodo mensagem - o objeto criado - por parametros recebe obrigatoriamente
                // (A Activity que deseja que apareça a mensagem neste caso usa-se THIS pois é nesta activity atual 'LoginActivity', com o comando 'getString' está sendo
                // setada a mensagem -> usa-se a Classe 'R' -  o Tipo de dados(String) e o metodo que foi criado com as mensagens)
                MensagemGeral.Msg(this, "Usuário e/ou Senha inválido!");
            }
        }

    }


}
