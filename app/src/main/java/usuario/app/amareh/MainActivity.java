package usuario.app.amareh;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private MainActivityController mac = MainActivityController.getInstance();

    private String jsonString = "{\"Id\":123,\"email\":\"joaodasilva@mail.com\",\"nome\":\"JoÃ£o da Silva\"}";
    private String responseJSON;

    private EditText edtLogin;
    private EditText edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLogin = (EditText) findViewById(R.id.editText);
        edtSenha  = (EditText) findViewById(R.id.editText4);
    }


    public String parseUserToJSON() {
        Usuario Us = new Usuario();
        //Pega os parametros do singleton
        Us.setLogin(mac.getLogin());
        Us.setSenha(mac.getSenha());

        //cÃ³digo que faz o trabalho ;-)
        Gson gson = new Gson();
        String userJSONString = gson.toJson(Us);
        AuthRequest r = new AuthRequest();
        r.setJson(userJSONString);

        userJSONString = gson.toJson(r);

        //Para ver o resultado no Logcat
        Log.d("Gson", "User JSON String: " + userJSONString);
        return userJSONString;
    }

    public void loadUserFromJSON(View v) {
        Gson gson = new Gson();
        Usuario Us = gson.fromJson(jsonString, Usuario.class);

        Log.d("Gson", "User infos: " + Us.getLogin() + " - " + Us.getSenha());

        Snackbar snackbar = Snackbar
                .make(v, Us.toString(), Snackbar.LENGTH_LONG);

        snackbar.show();
    }

    private class ExampleOkHttp extends AsyncTask<Void, Void, Response> {

        OkHttpClient client;
        Request request;

        public final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            client = new OkHttpClient();
            RequestBody body = RequestBody.create(JSON, parseUserToJSON());
            //URL exemplo: n recebe post requests
            request = new Request.Builder()
                    .url(Constants.URL_SERVICE4)
                    .post(body)
                    .build();
        }

        @Override
        protected Response doInBackground(Void... params) {
            try {
                Response response = client.newCall(request).execute();
                return response;
            } catch (IOException e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(Response response) {
            try {
                if (response.message().equals("OK")) { //
                    responseJSON = AuthController.getInstance().loadAuthFromJSON(response.body().string());
                    if(responseJSON.contains("ok")){
                        limpaLoginESenhaController();
                        Intent intent = new Intent(MainActivity.this, PrincipalActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        limpaLoginESenhaController();
                        Toast.makeText(MainActivity.this, "Erro ao efetuar o login", Toast.LENGTH_SHORT).show();
                    }
                }
            } catch (IOException e) {
                Toast.makeText(MainActivity.this, "Falha na conexão!", Toast.LENGTH_SHORT).show();
                //Se der erro, limpa os dados do controller
                limpaLoginESenhaController();
                responseJSON = "OPS - Fail connection";
            }
        }
    }

    public void btEntrar(View v) {
        //Passa os parametros da visao para o controller
        mac.setLogin(edtLogin.getText().toString());
        mac.setSenha(edtSenha.getText().toString());

        //Instancia uma nova clase exampleOkHttp e a executa;
        new ExampleOkHttp().execute();
        /*Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
        finish();*/
    }

    public void btCriar(View v) {
        Intent intent = new Intent(this, CriarActivity.class);
        startActivity(intent);
        finish();
    }

    public void limpaLoginESenhaController(){
        mac.setLogin("");
        mac.setSenha("");
    }

}

