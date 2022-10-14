package com.example.aluno.partyusb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import BD.CategoriaBD;
import BD.EnderecoBD;
import BD.EventoBD;
import BD.UsuarioBD;
import Interacao.Categoria;
import Interacao.Endereco;
import Interacao.Evento;
import Interacao.Usuario;
import util.MensagemGeral;

import static com.example.aluno.partyusb.R.id.cadastro_spinner_Cidade;
import static com.example.aluno.partyusb.R.id.cadastro_spinner_Estado;
import static com.example.aluno.partyusb.R.id.cadastro_spinner_Pais;
import static com.example.aluno.partyusb.R.id.criarevento_edittext_Descricao;
import static com.example.aluno.partyusb.R.id.criarevento_edittext_Numero;
import static com.example.aluno.partyusb.R.id.criarevento_spinner_Categoria;

public class CriarEventoActivity extends AppCompatActivity implements View.OnClickListener {


    private Endereco endereco;
    EnderecoBD enderecoBD;
    private int idEndereco;

    private Usuario usuario ;
    UsuarioBD usuarioBD ;
    private  int idUsuario ;

    private Evento evento ;
    private EventoBD eventoBD ;
    private int idEvento ;

    private Categoria categoria ;
    private CategoriaBD categoriaBD ;
    private int idCategoria ;




    private ImageView criarevento_imageview_Logo ;
    private ImageButton criarevento_imagebutton_ImagemEvento ;
    private  ImageButton criarevento_imagebutton_PagarEvento ;

    private TextView criarevento_textview_Titulo1 ;
    private TextView criarevento_textview_Descricao ;
    private TextView criarevento_textview_NomeEvento ;
    private TextView criarevento_textview_LocalEvento ;
    private TextView criarevento_textview_Categoria ;
    private TextView criarevento_textview_DescricaoEvento ;
    private TextView criarevento_textview_Preco ;
    private TextView criarevento_textview_DataEvento ;
    private TextView criarevento_textview_HoraInicial ;
    private TextView criarevento_textview_HoraFinal ;
    private TextView criarevento_textview_ImagemEvento ;
    private TextView criarevento_textview_Rodape ;
    private TextView criarevento_textview_Bairro ;
    private TextView criarevento_textview_Rua ;
    private TextView criarevento_textview_Numero ;
    private TextView criarevento_textview_Cidade ;
    private TextView criarevento_textview_PagarEvento ;

    private EditText criarevento_edittext_NomeEvento ;
    private EditText criarevento_edittext_LocalEvento ;
    private EditText criarevento_edittext_Descricao ;
    private EditText criarevento_edittext_Preco ;
    private EditText criarevento_edittext_Rua ;
    private EditText criarevento_edittext_Numero ;

    private Spinner criarevento_spinner_Categoria ;
    private Spinner criarevento_spinner_Bairro ;
    private Spinner criarevento_spinner_Cidade ;

    //private DatePicker criarevento_datepicker_DataEvento ;
   // private TimePicker criarevento_timepicker_HoraInicial ;
   // private TimePicker criarevento_timepicker_HoraFinal ;

    private EditText criarevento_edittext_DataEvento ;
    private EditText criarevento_edittext_HoraInicial ;
    private EditText criarevento_edittext_HoraFinal ;


    private Button criarevento_button_CriarEvento ;

    //-----------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_evento);


        enderecoBD = new EnderecoBD(this);
        usuarioBD = new UsuarioBD(this);
        eventoBD = new EventoBD(this);
        categoriaBD = new CategoriaBD(this) ;


        criarevento_imageview_Logo = (ImageView) findViewById(R.id.criarevento_imageview_Logo);

        criarevento_imagebutton_ImagemEvento = (ImageButton) findViewById(R.id.criarevento_imagebutton_ImagemEvento);
        //criarevento_imagebutton_ImagemEvento.setOnClickListener(this) ;


        criarevento_imagebutton_PagarEvento = (ImageButton) findViewById(R.id.criarevento_imagebutton_PagarEvento);

        //criarevento_imagebutton_PagarEvento.setOnClickListener(this) ;


        criarevento_textview_PagarEvento = (TextView) findViewById(R.id.criarevento_textview_PagarEvento);
        criarevento_textview_Titulo1 = (TextView) findViewById(R.id.criarevento_textview_Titulo1);
        criarevento_textview_Descricao = (TextView) findViewById(R.id.criarevento_textview_Descricao);
        criarevento_textview_NomeEvento = (TextView) findViewById(R.id.criarevento_textview_NomeEvento);
        criarevento_textview_LocalEvento = (TextView) findViewById(R.id.criarevento_textview_LocalEvento);
        criarevento_textview_Categoria = (TextView) findViewById(R.id.criarevento_textview_Categoria);
        criarevento_textview_DescricaoEvento = (TextView) findViewById(R.id.criarevento_textview_DescricaoEvento);
        criarevento_textview_Preco = (TextView) findViewById(R.id.criarevento_textview_Preco);
        criarevento_textview_DataEvento = (TextView) findViewById(R.id.criarevento_textview_DataEvento);
        criarevento_textview_HoraInicial = (TextView) findViewById(R.id.criarevento_textview_HoraInicial);
        criarevento_textview_HoraFinal = (TextView) findViewById(R.id.criarevento_textview_HoraFinal);
        criarevento_textview_ImagemEvento = (TextView) findViewById(R.id.criarevento_textview_ImagemEvento);
        criarevento_textview_Rodape = (TextView) findViewById(R.id.criarevento_textview_Rodape);
        criarevento_textview_Bairro = (TextView) findViewById(R.id.criarevento_textview_Bairro);
        criarevento_textview_Rua = (TextView) findViewById(R.id.criarevento_textview_Rua);
        criarevento_textview_Numero = (TextView) findViewById(R.id.criarevento_textview_Numero);
        criarevento_textview_Cidade = (TextView) findViewById(R.id.criarevento_textview_Cidade);


        criarevento_edittext_NomeEvento = (EditText) findViewById(R.id.criarevento_edittext_NomeEvento);
        criarevento_edittext_LocalEvento = (EditText) findViewById(R.id.criarevento_edittext_LocalEvento);
        criarevento_edittext_Descricao = (EditText) findViewById(R.id.criarevento_edittext_Descricao);
        criarevento_edittext_Preco = (EditText) findViewById(R.id.criarevento_edittext_Preco);
        criarevento_edittext_Rua = (EditText) findViewById(R.id.criarevento_edittext_Rua);
        criarevento_edittext_Numero = (EditText) findViewById(R.id.criarevento_edittext_Numero);

        criarevento_edittext_DataEvento = (EditText) findViewById(R.id.criarevento_edittext_DataEvento);
        criarevento_edittext_HoraInicial = (EditText) findViewById(R.id.criarevento_edittext_HoraInicial);
        criarevento_edittext_HoraFinal = (EditText) findViewById(R.id.criarevento_edittext_HoraFinal);



        criarevento_spinner_Categoria = (Spinner) findViewById(R.id.criarevento_spinner_Categoria);

                ArrayAdapter<CharSequence> adapterSpinnerCategoria = ArrayAdapter.createFromResource(this, R.array.Spinner_Categoria, android.R.layout.simple_spinner_dropdown_item);
                adapterSpinnerCategoria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                criarevento_spinner_Categoria.setAdapter(adapterSpinnerCategoria);

        criarevento_spinner_Bairro = (Spinner) findViewById(R.id.criarevento_spinner_Bairro);

                    ArrayAdapter<CharSequence> adapterSpinnerBairro = ArrayAdapter.createFromResource(this, R.array.Spinner_Bairro, android.R.layout.simple_spinner_dropdown_item);
                    adapterSpinnerBairro.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    criarevento_spinner_Bairro.setAdapter(adapterSpinnerBairro);

        criarevento_spinner_Cidade = (Spinner) findViewById(R.id.criarevento_spinner_Cidade);

                    ArrayAdapter<CharSequence> adapterSpinnerCidade = ArrayAdapter.createFromResource(this, R.array.Spinner_Cidade, android.R.layout.simple_spinner_dropdown_item);
                    adapterSpinnerCidade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    criarevento_spinner_Cidade.setAdapter(adapterSpinnerCidade);
        /*
            //Fazendo a ação ao clickar no elemento
            criarevento_spinner_Categoria.setOnClickListener(this);
            criarevento_spinner_Bairro.setOnClickListener(this);
            criarevento_spinner_Cidade.setOnClickListener(this);
        */

        //criarevento_datepicker_DataEvento = (DatePicker) findViewById(R.id.criarevento_datepicker_DataEvento);
        //criarevento_timepicker_HoraInicial = (TimePicker) findViewById(R.id.criarevento_timepicker_HoraInicial);
        //criarevento_timepicker_HoraFinal = (TimePicker) findViewById(R.id.criarevento_timepicker_HoraFinal);

       // criarevento_datepicker_DataEvento.setOnClickListener(this);
       // criarevento_timepicker_HoraInicial.setOnClickListener(this);
       // criarevento_timepicker_HoraFinal.setOnClickListener(this);



        criarevento_button_CriarEvento = (Button) findViewById(R.id.criarevento_button_CriarEvento);
            criarevento_button_CriarEvento.setOnClickListener(this);

        //FORMATANDO O NUMERO NO CRIAR EVENTO
        SimpleMaskFormatter maskDataNumero = new SimpleMaskFormatter("NNNNNN");
        MaskTextWatcher maskTextWatcher = new MaskTextWatcher(criarevento_edittext_Numero, maskDataNumero);
        criarevento_edittext_Numero.addTextChangedListener(maskTextWatcher);



        SimpleMaskFormatter maskDataEvento = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher maskTextWatcherDataEvento = new MaskTextWatcher(criarevento_edittext_DataEvento, maskDataEvento);
        criarevento_edittext_DataEvento.addTextChangedListener(maskTextWatcherDataEvento);

        SimpleMaskFormatter maskHoraInicial = new SimpleMaskFormatter("NN:NN");
        MaskTextWatcher maskTextWatcherHoraInicial = new MaskTextWatcher(criarevento_edittext_HoraInicial, maskHoraInicial);
        criarevento_edittext_HoraInicial.addTextChangedListener(maskTextWatcherHoraInicial);

        SimpleMaskFormatter maskHoraFinal = new SimpleMaskFormatter("NN:NN");
        MaskTextWatcher maskTextWatcherHoraFinal = new MaskTextWatcher(criarevento_edittext_HoraFinal, maskHoraFinal);
        criarevento_edittext_HoraFinal.addTextChangedListener(maskTextWatcherHoraFinal);



        idEvento = getIntent().getIntExtra("EVENTO_ID" , 0) ;

        if (idEvento > 0){
            Evento model = eventoBD.buscarEventoUnico(idEvento) ;

            //criarevento_spinner_Bairro.setText(model.getBairro()) ; -> NÃO PEGA POR SER SPINNER E SER DE OUTRA TABELA
            //criarevento_spinner_Cidade.setText(model.getBairro()) ;

            //criarevento_edittext_LocalEvento.setText(model.getLocal_Evento()); -> NÃO PEGA POR SER DE OUTRA TABELA
            //criarevento_edittext_Rua.setText(model.getRua());
            //criarevento_edittext_Numero.setText(model.getNumero());


            criarevento_edittext_NomeEvento.setText(model.getNome_evento());
            criarevento_edittext_Descricao.setText(model.getDescricao_evento());

           // criarevento_edittext_Preco.setText(model.getPreco_evento()); -> TEM QUE CONVERTER PRA STRING

        }
    }


    protected void onDestoyEvento() {
        usuarioBD.fechar();
        super.onDestroy();
    }


        public void cadEndereco(){

            boolean validacao = true ;

            String spinnerBairro = criarevento_spinner_Bairro.getSelectedItem().toString() ;
            String spinnerCidade = criarevento_spinner_Cidade.getSelectedItem().toString() ;
            String local_evento = criarevento_edittext_LocalEvento.getText().toString() ;
            String rua = criarevento_edittext_Rua.getText().toString() ;
            String numero = criarevento_edittext_Numero.getText().toString() ;


            if (validacao){
                endereco = new Endereco() ;

                endereco.setBairro(spinnerBairro);
                endereco.setCidade(spinnerCidade);
                endereco.setLocal_evento(local_evento);
                endereco.setRua(rua);
                endereco.setNumero(Integer.parseInt(numero)) ;



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
                        this.cadEvento();
                    }
                    finish();
                    startActivity(new Intent(this, ListarEventoActivity.class));


                    // Se for dar algum Erro
                } else {
                    MensagemGeral.Msg(this, getString(R.string.mensagem_erro));
                }

            }
        }

    //-----------------------

    public void cadEvento(){

        boolean validacao = true ;

        String nome_evento = criarevento_edittext_NomeEvento.getText().toString() ;
        String descricao = criarevento_edittext_Descricao.getText().toString() ;
        String preco = criarevento_edittext_Preco.getText().toString() ;

        String data_evento = criarevento_edittext_DataEvento.getText().toString() ;
        String hora_inicial = criarevento_edittext_HoraInicial.getText().toString() ;
        String hora_final = criarevento_edittext_HoraFinal.getText().toString() ;



        /* FALTA CONSEGUIR CPEGAR UMA CATEGORIA AO CLICKAR NO SPINNER -> POIS NÃO APARECE E SE CRIAR UM METODO CATEGORIA ELE TRAZ MUITAS INFORMAÇÕES */
        //String categoria = criarevento_spinner_Categoria.getSelectedItem().toString() ;


        if (validacao){
            evento = new Evento() ;

            evento.setNome_evento(nome_evento);
            evento.setDescricao_evento(descricao);
            evento.setPreco_evento(Double.parseDouble(preco));

            //evento.setCategoria_id(Integer.parseInt(categoria));

            evento.setData_evento(data_evento);
            evento.setHora_inicial_evento(hora_inicial);
            evento.setHora_final_evento(hora_final);



            // Se for alteração
            if (idEvento > 0) {
                evento.setIdEvento(idEvento);
            }

            long resultado = eventoBD.salvarEvento(evento);

            if (resultado != -1) {
                if (idEvento > 0) {
                    MensagemGeral.Msg(this, getString(R.string.mensagem_atualizar));

                    // Se for Cadastrar
                } else {

                }
                finish();
                startActivity(new Intent(this, ListarEventoActivity.class));


                // Se for dar algum Erro
            } else {
                MensagemGeral.Msg(this, getString(R.string.mensagem_erro));
            }

        }
    }





    /*



                            // TENTATIVA DE CONSEGUIR PEGAR E CADASTRAR O SPINNER CATEGORIA



    public void cadCategoria(){

        //criarevento_edittext_NomeEvento = (EditText) findViewById(R.id.criarevento_edittext_NomeEvento);
        //criarevento_edittext_Descricao = (EditText) findViewById(R.id.criarevento_edittext_Descricao);
        // criarevento_edittext_Preco = (EditText) findViewById(R.id.criarevento_edittext_Preco);

        String spinnerCategoria = criarevento_spinner_Categoria.getSelectedItem().toString() ;

        boolean validacao = true ;



        if (validacao){
            categoria = new Categoria() ;

            categoria.setCa(spinnerCategoria);



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
                    //this.cadEndereco();
                }
                finish();
                startActivity(new Intent(this, ListarEventoActivity.class));


                // Se for dar algum Erro
            } else {
                MensagemGeral.Msg(this, getString(R.string.mensagem_erro));
            }
        }
    }

*/



    @Override
    public void onClick(View view) {
       // this.cadEndereco();
        this.cadEvento();




        /*

        if (criarevento_button_CriarEvento.isPressed()) {

            cadastrarEvento();

            Intent intent = new Intent(this, ListarEventoActivity.class); // criando um novo objeto da classe Intent e passado os parametros a outra activity

            startActivity(intent); // comecando a activity

            //finish(); // finaliza a activity anterior

            //overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);

        }

        */
    }
}
