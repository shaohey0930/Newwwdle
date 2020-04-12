package com.example.newwwdle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    private Button button;

    TextView IMEI_View;
    TelephonyManager tm;
    String IMEI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        IMEI_View = (TextView)findViewById(R.id.tv3);

        tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);

        try {
            IMEI = tm.getDeviceId();
        }
        catch (SecurityException e){
            Log.d("TAG","SecurityException e");
        }

        //TimeZone.setDefault(TimeZone.getTimeZone("Asia/Taipei"));
        ////click button and represent
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                if(IMEI != null){
                    IMEI_View.setText("IMEI Number :"+ IMEI);
                }
            }
        });





    }
}
