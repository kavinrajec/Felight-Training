package com.example.kaving.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by KavinG on 10/14/2015.
 */
public class Calculator extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);
    }
    public void onButtonClick(View v){
        //two edit text fields
        try {
            EditText e1 = (EditText) findViewById(R.id.editText);
            EditText e2 = (EditText) findViewById(R.id.editText2);
            //one text view field
            boolean flag = false;

            TextView t1 = (TextView) findViewById(R.id.textView2);

            double num1, num2, ans = 0;

            num1 = Double.parseDouble(e1.getText().toString());
            num2 = Double.parseDouble(e2.getText().toString());

            switch (v.getId()) {
                case R.id.Badd:
                    ans = num1 + num2;
                    break;
                case R.id.Bsub:
                    ans = num1 - num2;
                    break;
                case R.id.Bmul:
                    ans = num1 * num2;
                    break;
                case R.id.Bdiv:
                    ans = num1 / num2;
                    break;
            }
            t1.setText(ans + "");
        }catch (Exception ex){
            // t1.setText("Enter valid numbers");
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add("Help");
        return super.onCreateOptionsMenu(menu);
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
