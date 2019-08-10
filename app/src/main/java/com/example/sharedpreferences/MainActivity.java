package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textoNome;
    private Button botaoSalva;
    private TextView textoExibicao;

    private static final String ARQUIVO_PREFERENCIA  =  "AquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoNome     = (EditText) findViewById(R.id.TextoNomeId);
        textoExibicao = (TextView) findViewById(R.id.textExibicao);
        botaoSalva    = (Button)   findViewById(R.id.BotaoSalvarId);

        botaoSalva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if (textoNome.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Por favor digite o nome", Toast.LENGTH_SHORT).show();
                }else{
                    editor.putString("nome", textoNome.getText().toString());
                    editor.commit();
                }
            }
        });

        //Recuperar os dados salvos
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if ( sharedPreferences.contains("nome") ){
            String nomeUsuario = sharedPreferences.getString("nome","usuario não definido");
            textoExibicao.setText(nomeUsuario);
        }else{
            textoExibicao.setText("olá, Usuario não definido");
        }




     }

}
