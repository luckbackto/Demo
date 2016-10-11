package usuario.app.amareh;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static usuario.app.amareh.R.id.button6;
import static usuario.app.amareh.R.id.editText;

public class CriarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar);

        Button botao = (Button)findViewById(R.id.button8);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText login = (EditText)findViewById(R.id.editText2);
                EditText senha = (EditText)findViewById((R.id.editText3));
                EditText email = (EditText)findViewById(R.id.editText5);
                String loginString = login.getText().toString();
                String senhaString = senha.getText().toString();
                String emailString = email.getText().toString();
                String resultado;

                resultado = crud.insereDado(loginString,senhaString,emailString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}