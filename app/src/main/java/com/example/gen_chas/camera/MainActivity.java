package com.example.gen_chas.camera;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements Button.OnClickListener {
    //Variables

//Butttons
    Button btnNxt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        btnNxt=(Button)findViewById(R.id.btn_edit);
        btnNxt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    if(v.getId()==R.id.btn_edit){
            Intent intent = new Intent(this, Edit.class);
            startActivity(intent);
    }

    }

}

