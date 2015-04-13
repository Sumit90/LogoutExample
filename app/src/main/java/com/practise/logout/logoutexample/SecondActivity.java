package com.practise.logout.logoutexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by e00959 on 4/13/2015.
 */
public class SecondActivity extends Activity {

    Button logout=null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        logout=(Button)findViewById(R.id.logout_btn);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_send=new Intent();
                intent_send.setAction("com.practise.logout.logoutexample.MyAction");
                sendBroadcast(intent_send);

                Log.d("Myapp", "SecondActivity finished");
                SecondActivity.this.finish();


            }
        });



    }
}
