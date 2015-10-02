package com.example.hello.storagetest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.content.res.Resources;

public class MainActivity extends Activity {
    private Button btnRead=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRead = (Button)super.findViewById(R.id.read);
        btnRead.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = MainActivity.this.getResources();
                InputStream input = res.openRawResource(R.raw.friend);
                Scanner scan = new Scanner(input);
                StringBuffer info=new StringBuffer();
                while(scan.hasNext())
                    info.append(scan.next()).append("\n");
                scan.close();
                try{
                    input.close();
                }catch(IOException e)
                {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(),info.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }


}
