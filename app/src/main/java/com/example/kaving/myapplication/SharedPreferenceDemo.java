package com.example.kaving.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by KavinG on 11/3/2015.
 */
public class SharedPreferenceDemo extends AppCompatActivity {
    private EditText etUserName,etMail,etGender,etCity;
    private SharedPreferences sharedPreferences,sharedPreferences1;
    private LinearLayout lltSharedPref;
    private String mypref="myPref";
    private  String USER_NAME_KEY = "USER NAME";
    private  String EMAIL_KEY = "EMAIL";
    private  String GENDER_KEY = "GENDER";
    private  String CITY_KEY = "CITY";
    public  static final String COLOR="color";
    private int clr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_preference_activity);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etMail = (EditText) findViewById(R.id.etEmail);
        etGender = (EditText) findViewById(R.id.etGender);
        etCity = (EditText) findViewById(R.id.etCity);
        lltSharedPref = (LinearLayout) findViewById(R.id.lltSharedPref);
        sharedPreferences = getSharedPreferences(mypref, Context.MODE_PRIVATE);
        sharedPreferences1 = getSharedPreferences(mypref, Context.MODE_PRIVATE);
       // etUserName.setText(sharedPreferences.getString(USER_NAME_KEY,"No Username"));

        lltSharedPref.setBackgroundColor(sharedPreferences1.getInt("colour",0));
    }

    public void saveOn(View v){
        String userName = etUserName.getText().toString();
        String email = etMail.getText().toString();
        String gender = etGender.getText().toString();
        String city = etCity.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_NAME_KEY,userName);
        editor.putString(EMAIL_KEY,email);
        editor.putString(GENDER_KEY,gender);
        editor.putString(CITY_KEY, city);
        editor.commit();
    }

    public void displayOf(View v){
        Toast.makeText(SharedPreferenceDemo.this,
                        "Name: "+sharedPreferences.getString(USER_NAME_KEY,"")+"\n"+
                        "Email: "+sharedPreferences.getString(EMAIL_KEY,"")+"\n"+
                        "Gender: "+sharedPreferences.getString(GENDER_KEY,"")+"\n"+
                        "Gender: "+sharedPreferences.getString(CITY_KEY,""), Toast.LENGTH_LONG).show();
    }

    @Override
       public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.shared_preference, menu);
        menu.add("Help");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //noinspection SimplifiableIfStatement
        if (item.getItemId()== R.id.action_settings) {
            Intent intent=new Intent(getBaseContext(),BackGroundColorActivity.class);
            startActivityForResult(intent,1);
        }if (item.getItemId()== R.id.action_about){
            Toast.makeText(getBaseContext(), "Developed by KavinraJ...", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        clr=data.getIntExtra(COLOR,0);
        SharedPreferences.Editor editor1 = sharedPreferences1.edit();
        editor1.putInt("colour", clr);
        editor1.commit();
        lltSharedPref.setBackgroundColor(clr);
    }
}
