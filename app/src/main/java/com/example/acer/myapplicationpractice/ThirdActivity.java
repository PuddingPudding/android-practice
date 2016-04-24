package com.example.acer.myapplicationpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ThirdActivity extends ActionBarActivity
{

    TextView output;
    Button back = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        output = (TextView)findViewById(R.id.TV_Output);
        back = (Button)findViewById(R.id.BT_Back);
        if(back != null)
        {
            back.setOnClickListener(backToMain);
        }

        Intent intent = getIntent();
        String strInput = intent.getStringExtra(MainActivity.KEY);
        if(strInput.equals("") == true)
        {
            output.setText("nothing!");
        }
        else
        {
            output.setText(strInput);
        }
    }

    private View.OnClickListener backToMain = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            finish();
        }
    };

}
