package com.example.kaving.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by KavinG on 10/22/2015.
 */
public class UserDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_data);
    }
    Intent intent;
    public void getUserAddress(View v){
        intent = new Intent(getBaseContext(),AddressFormActivity.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       // super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                Toast.makeText(getBaseContext(),"address:"+ data.getStringExtra("address"),Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getBaseContext(),"please enter a valid address...!!!",Toast.LENGTH_LONG).show();
            }
        }


    }
}
