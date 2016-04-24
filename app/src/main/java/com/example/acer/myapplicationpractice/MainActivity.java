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

import static com.example.acer.myapplicationpractice.R.id.BT_JumpToThird;

public class MainActivity extends ActionBarActivity
{
    public static final int PAGE_MAIN = 1;
    public static final int PAGE_THIRD = 3;
    public static final String KEY = "key";

    public static int currentPage;
    Button jumpToThird = null;
    EditText editMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentPage = PAGE_MAIN;
        setContentView(R.layout.activity_main);

        editMessage = (EditText)findViewById(R.id.ET_EditMessage);
        jumpToThird = (Button)findViewById(R.id.BT_JumpToThird);
        if (jumpToThird != null)
        {
            jumpToThird.setOnClickListener(JumpToThird);
        }

    }

    private void pageSetMain()
    {
        currentPage = PAGE_MAIN;
        jumpToThird = (Button)findViewById(BT_JumpToThird);
        if (jumpToThird != null)
        {
            jumpToThird.setOnClickListener(JumpToThird);
        }
        editMessage = (EditText)findViewById(R.id.ET_EditMessage);

        setContentView(R.layout.activity_main);
    }


    private OnClickListener JumpToThird = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            String strInput = editMessage.getText().toString();

            Intent intent = new Intent();
            intent.setClass(MainActivity.this, ThirdActivity.class);
            intent.putExtra(KEY , strInput);
            startActivity(intent);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
