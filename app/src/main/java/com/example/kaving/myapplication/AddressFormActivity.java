package com.example.kaving.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by KavinG on 10/22/2015.
 */
public class AddressFormActivity extends AppCompatActivity {
    EditText etAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address_form_activity);
        etAdd = (EditText)findViewById(R.id.etAddress);
    }

    public void processData(View v){
        String add = etAdd.getText().toString();
        switch(v.getId()){
            case R.id.btnSave:

                Intent intet = new Intent();
                intet.putExtra("address",add);
                setResult(RESULT_OK, intet);
                finish();
                break;
            case R.id.btnCancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}
