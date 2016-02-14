package ru.application.task1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

/*
    Задание:
    Приложение андроид (одна активность),
    которое принимает на вход строку и проверяет - является ли она палиндромом (строка, читаемая и наоборот)
    
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText)findViewById(R.id.editText);
        final Pattern pattern = Pattern.compile("^[\\p{L}0-9].*");

        findViewById(R.id.okButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString().toLowerCase();
                if (pattern.matcher(input).matches()) {
                    input = input.replaceAll("[^\\p{L}0-9]+","");
                    String reversedInput = new StringBuilder(input).reverse().toString();
                    Toast.makeText(MainActivity.this, reversedInput.equals(input) ? "ok" : "not ok", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "not ok", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
