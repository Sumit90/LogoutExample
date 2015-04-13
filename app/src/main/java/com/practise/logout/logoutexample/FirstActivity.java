package com.practise.logout.logoutexample;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by e00959 on 4/13/2015.
 */
public class FirstActivity extends Activity{

    Button secondBtn=null;

    BroadcastReceiver myReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d("Myapp","FirstActivity finished");
            FirstActivity.this.finish();
        }
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        secondBtn=(Button)findViewById(R.id.second_btn);

        IntentFilter filter=new IntentFilter();
        filter.addAction("com.practise.logout.logoutexample.MyAction");

        registerReceiver(myReceiver,filter);

        secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent l_intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(l_intent);

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       unregisterReceiver(myReceiver);

    }
}
