package com.example.aluno.partyusb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PrimeiraTelaActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView primeiratela_textview_text1 ;
    private TextView primeiratela_textview_text2 ;
    private TextView primeiratela_textview_Login ;
    private TextView primeiratela_textview_Cadastrar ;
    private TextView primeiratela_textview_Rodape ;

    private ImageView primeiratela_imagemview_logo ;

    private Button primeiratela_button_Login ;
    private Button primeiratela_button_Cadastro ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira_tela);

        //ATRIBUINDO O ID PARA DENTRO DA VARIAVEL CRIADA A CIMA  ( NOS TEXTES VIEWS)
        primeiratela_textview_text1 = (TextView) findViewById(R.id.primeiratela_textview_texto1)  ;
        primeiratela_textview_text2 = (TextView) findViewById(R.id.primeiratela_textview_texto2)  ;
        primeiratela_textview_Login = (TextView) findViewById(R.id.primeiratela_textview_Login)  ;
        primeiratela_textview_Cadastrar = (TextView) findViewById(R.id.primeiratela_textview_Cadastrar)  ;
        primeiratela_textview_Rodape = (TextView) findViewById(R.id.primeiratela_textview_Rodape)  ;

        primeiratela_imagemview_logo = (ImageView) findViewById(R.id.primeiratela_imagemview_logo) ;

        primeiratela_button_Login = (Button) findViewById(R.id.primeiratela_button_Login) ;
        primeiratela_button_Cadastro = (Button) findViewById(R.id.primeiratela_button_Cadastro) ;

                primeiratela_button_Login.setOnClickListener(this);
                primeiratela_button_Cadastro.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        // TESTE DE QUAL BOTÃO FOI CLICKADO NA PRIMEIRA TELA E DIRECIONA PARA A MESMA

        if (primeiratela_button_Login.isPressed()) {

            Intent intent = new Intent(this, TelaLoginActivity.class); // criando um novo objeto da classe Intent e passado os parametros a outra activity

            startActivity(intent); // comecando a activity

            //finish(); // finaliza a activity anterior

            //overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);


        }
        if (primeiratela_button_Cadastro.isPressed()) {

            Intent intent = new Intent(this, CadastroSimplesActivity.class); // criando um novo objeto da classe Intent e passado os parametros a outra activity

            startActivity(intent); // comecando a activity

            //finish(); // finaliza a activity anterior

           // overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);

        }
    }
}
