package com.example.kaving.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CallMsg extends AppCompatActivity {

    Button btnSendMsg;
    Button btnCall;
    EditText etEnterMobNum;
    EditText etEnterText;
    Intent intent;
    private static final int PICK_CONTACT = 1;
    private  String contactID;
    Uri contactData;
    String contactNumber=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callmsg);
        btnSendMsg =(Button)findViewById(R.id.btnSendMsg);
        btnCall =(Button)findViewById(R.id.btnCall);
        etEnterMobNum = (EditText)findViewById(R.id.etEnterMobNum);
        etEnterText = (EditText)findViewById(R.id.etEnterText);


        btnSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num =etEnterMobNum.getText().toString();
                String msg =etEnterText.getText().toString();
                if(msg != null){
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(num,null,msg,null,null);
                }else{
                    Toast.makeText(getBaseContext(),"Please enter my text...",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num =etEnterMobNum.getText().toString();
                if(num.equals("")){
                    Toast.makeText(getBaseContext(),"Please enter mobile number...",Toast.LENGTH_LONG);
                }else {
                    intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + num));
                    startActivity(intent);
                }

            }
        });

    }
    public void openContacts(View v) {
        Intent contacts = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(contacts, PICK_CONTACT);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_CONTACT && resultCode == RESULT_OK) {
            contactData = data.getData();
            getContactNumber();
        }
    }
    public void getContactNumber(){

        Cursor cursorID = getContentResolver().query(contactData,
                new String[]{ContactsContract.Contacts._ID},
                null, null, null);

        if (cursorID.moveToFirst()) {

            contactID = cursorID.getString(cursorID.getColumnIndex(ContactsContract.Contacts._ID));
        }

        cursorID.close();

        // Using the contact ID now we will get contact phone number
        Cursor cursorPhone = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER},

                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ? AND " +
                        ContactsContract.CommonDataKinds.Phone.TYPE + " = " +
                        ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE,

                new String[]{contactID},
                null);

        if (cursorPhone.moveToFirst()) {
            contactNumber = cursorPhone.getString(cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

        }

        cursorPhone.close();
        Toast.makeText(this, "" + contactNumber, Toast.LENGTH_LONG).show();
        etEnterMobNum.setText(contactNumber);
    }


}
