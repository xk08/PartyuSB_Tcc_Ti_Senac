package com.example.aluno.partyusb;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.example.aluno.partyusb.R;

/**
 * Created by Marcos Gronytzki on 11/12/2016.
 */

public class PopinAvaliacaoEvento extends Activity {


    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popin_avaliacaoevento);

        DisplayMetrics dm = new DisplayMetrics() ;

        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels ;

        int height = dm.heightPixels ;

        getWindow().setLayout((int)(width*.9) , (int)(height*.7));
    }

}

