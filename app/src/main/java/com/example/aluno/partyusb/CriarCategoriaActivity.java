package com.example.aluno.partyusb;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import BD.CategoriaBD;
import BD.EnderecoBD;
import Interacao.Categoria;
import Interacao.Endereco;
import Interacao.Evento;
import util.MensagemGeral;

public class CriarCategoriaActivity extends AppCompatActivity implements View.OnClickListener {


    private Categoria categoria;
    CategoriaBD categoriaBD;
    private int idCategoria;

    private ImageView criarcategoria_imageview_Logo;
    private ImageButton criarcategoria_imagebutton_IconeCategoria;

    private TextView criarcategoria_textview_NomeCategoria;
    private TextView criarcategoria_textview_IconeCategoria;
    private TextView criarcategoria_textview_VisializarCategoria;

    private EditText criarcategoria_edittext_NomeCategoria;

    private Button criarcategoria_button_CriarCategoria;

    private Spinner criarcategoria_spinner_VisializarCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_categoria);

        categoriaBD = new CategoriaBD(this);


        criarcategoria_imageview_Logo = (ImageView) findViewById(R.id.criarcategoria_imageview_Logo);
        criarcategoria_imagebutton_IconeCategoria = (ImageButton) findViewById(R.id.criarcategoria_imagebutton_IconeCategoria);
        //criarcategoria_imagebutton_IconeCategoria.setOnClickListener(this);

        criarcategoria_textview_NomeCategoria = (TextView) findViewById(R.id.criarcategoria_textview_NomeCategoria);
        criarcategoria_textview_IconeCategoria = (TextView) findViewById(R.id.criarcategoria_textview_IconeCategoria);
        criarcategoria_textview_VisializarCategoria = (TextView) findViewById(R.id.criarcategoria_textview_VisualizarCategorias);


        criarcategoria_edittext_NomeCategoria = (EditText) findViewById(R.id.criarcategoria_edittext_NomeCategoria);

        criarcategoria_button_CriarCategoria = (Button) findViewById(R.id.criarcategoria_button_CriarCategoria);
        criarcategoria_button_CriarCategoria.setOnClickListener(this);

        criarcategoria_spinner_VisializarCategoria = (Spinner) findViewById(R.id.criarcategoria_spinner_VisualizarCategorias);

        ArrayAdapter<CharSequence> adapterSpinnerCategoria = ArrayAdapter.createFromResource(this, R.array.Spinner_Categoria, android.R.layout.simple_spinner_dropdown_item);
        adapterSpinnerCategoria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        criarcategoria_spinner_VisializarCategoria.setAdapter(adapterSpinnerCategoria);

        idCategoria = getIntent().getIntExtra("CATEGORIA_ID" , 0) ;

        if (idCategoria > 0){
            Categoria model = categoriaBD.buscarCategoria(idCategoria) ;

            criarcategoria_edittext_NomeCategoria.setText(model.getNome_categoria());


            setTitle(R.string.mensagem_atualizar);

        }
    }


    protected void onDestoyCategoria() {
        categoriaBD.fechar();
        super.onDestroy();
    }

    public void cadCategoria() {

        boolean validacao = true;






        //VER COMO SE CADASTRA AO CLICKAR NO IMAGEM BUTTON
        String nome_categoria = criarcategoria_edittext_NomeCategoria.getText().toString();
        //String icone_categoria = criarcategoria_imagebutton_IconeCategoria.getText();toString() ;


        if (validacao) {
            categoria = new Categoria();

            categoria.setNome_categoria(nome_categoria);
            //categoria.getIcone_categoria(icone_categoria) ;

            // Se for alteração
            if (idCategoria > 0) {
                categoria.setIdCategoria(idCategoria);
            }

            long resultado = categoriaBD.salvarCategoria(categoria);

            if (resultado != -1) {
                if (idCategoria > 0) {
                    MensagemGeral.Msg(this, getString(R.string.mensagem_atualizar));

                    // Se for Cadastrar
                } else {

                    MensagemGeral.Msg(this , "Sucesso ao Cadastrar");

                    //this.cadEvento();
                }
                finish();
                startActivity(new Intent(this, ListarCategoriaActivity.class));


                // Se for dar algum Erro
            } else {
                MensagemGeral.Msg(this, getString(R.string.mensagem_erro));
            }

        }
    }

    @Override
    public void onClick(View v) {
        this.cadCategoria();


    }
}



