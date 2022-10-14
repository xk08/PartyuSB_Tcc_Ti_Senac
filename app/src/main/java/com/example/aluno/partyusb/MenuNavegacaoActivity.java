package com.example.aluno.partyusb;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import util.MensagemGeral;

public class MenuNavegacaoActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_navegacao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sair, menu);


        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.Sair_APP) {

            MensagemGeral.MsgConfirmar(this, "Sair", "Deseja Realmente Sair?", R.drawable.info, new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();

                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }


            });
        }
        if (id == R.id.Deslogar){

            //Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show();

            SharedPreferences preferences = getSharedPreferences("LoginActivityPreferences", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.commit();
            finish();
            Intent intent = new Intent (this , TelaLoginActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }






    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


       if (id == R.id.Alterar_Cadastro) {

            Intent intent = new Intent(this, CadastroUsuarioActivity.class); // criando um novo objeto da classe Intent e passado os parametros a outra activity

            startActivity(intent); // comecando a activity

            //finish(); // finaliza a activity anterior

            //overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);


        } else if (id == R.id.Criar_Categoria) {

            Intent intent = new Intent(this, CriarCategoriaActivity.class); // criando um novo objeto da classe Intent e passado os parametros a outra activity

            startActivity(intent); // comecando a activity

            //finish(); // finaliza a activity anterior

            //overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);

        } else if (id == R.id.Criar_Evento) {

            Intent intent = new Intent(this, CriarEventoActivity.class); // criando um novo objeto da classe Intent e passado os parametros a outra activity

            startActivity(intent); // comecando a activity

            //finish(); // finaliza a activity anterior

            //overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);


        } else if (id == R.id.Listar_Eventos) {


            Intent intent = new Intent(this, ListarEventoActivity.class); // criando um novo objeto da classe Intent e passado os parametros a outra activity

            startActivity(intent); // comecando a activity

            //finish(); // finaliza a activity anterior

            //overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);

        } else if (id == R.id.Listar_Usuario) {

            Intent intent = new Intent(this, ListarUsuarioActivity.class); // criando um novo objeto da classe Intent e passado os parametros a outra activity

            startActivity(intent); // comecando a activity

            //finish(); // finaliza a activity anterior

            //overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
        } else if (id == R.id.Listar_Categoria) {

           Intent intent = new Intent(this, ListarCategoriaActivity.class); // criando um novo objeto da classe Intent e passado os parametros a outra activity

           startActivity(intent); // comecando a activity

           //finish(); // finaliza a activity anterior

           //overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);

       }


    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    }

