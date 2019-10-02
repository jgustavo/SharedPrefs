package br.edu.ceunsp.sharedprefs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static String APP_PREFS = "app_prefs";
    final static String USERNAME_KEY = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getSharedPreferences(APP_PREFS, MODE_PRIVATE);
        String username = prefs.getString(USERNAME_KEY, null);
        TextView message = (TextView) findViewById(R.id.textView);
        Button addNameButton = (Button) findViewById(R.id.button);
        if (username != null) {
            message.setText("Bem vindo , " + username + "!");
            addNameButton.setText(" Trocar de nome ");
        } else {
            message.setText(" Você não cadastrou seu nome ... ");
            addNameButton.setText(" Adicionar nome ");
        }
    }

    public void onClick(View view) {

        Intent intent = new Intent(MainActivity.this,NameActivity.class);
        startActivity(intent);

    }
}
