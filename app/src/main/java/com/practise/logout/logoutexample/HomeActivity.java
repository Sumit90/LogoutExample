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
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by e00959 on 4/13/2015.
 */
public class HomeActivity extends Activity {

    private TextView userId= null;
    private Button firstActivity = null;

    BroadcastReceiver myReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d("Myapp", "HomeActivity finished");

            Intent l_intent=new Intent(HomeActivity.this,LoginActivity.class);
            startActivity(l_intent);
            HomeActivity.this.finish();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        userId=(TextView)findViewById(R.id.welcome_txt);
        firstActivity=(Button)findViewById(R.id.First_btn);

        IntentFilter filter=new IntentFilter();
        filter.addAction("com.practise.logout.logoutexample.MyAction");

        Intent l_intent=new Intent();

        registerReceiver(myReceiver,filter);

        String l_userId=getIntent().getStringExtra("UserId");
        if(l_userId !=null ) {
            userId.setText(l_userId);
        }
        else{

            userId.setText("Hello");
        }

        firstActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l_intent =new Intent(HomeActivity.this,FirstActivity.class);
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
