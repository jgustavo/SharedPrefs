package br.edu.ceunsp.sharedprefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        prefs = getSharedPreferences(MainActivity.APP_PREFS, MODE_PRIVATE);

        name = (EditText) findViewById(R.id.editText);
        Button saveButton = (Button) findViewById(R.id.button2);
    }

    public void onClick2(View view) {
        String username = name.getEditableText().toString();
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(MainActivity.USERNAME_KEY, username);
        editor.commit();
        finish();
    }
}
