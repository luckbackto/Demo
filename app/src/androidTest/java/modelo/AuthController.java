package modelo;

import android.util.Log;

import com.google.gson.Gson;

import br.com.uther.httpcliente_okhttp.model.AuthResult;
import br.com.uther.httpcliente_okhttp.model.MapsDirection;

/**
 * Created by JosiasJr on 24/04/2016.
 */
public class AuthController {

    private static AuthController INSTANCE = null;

    private AuthController(){}

    public static AuthController getInstance(){
        if (INSTANCE == null)
            INSTANCE = new AuthController();

        return INSTANCE;
    }

    public static String loadAuthFromJSON(String json){
        Gson gson = new Gson();
        AuthResult ar = gson.fromJson(json, AuthResult.class);

        return ar.toString();
    }
}
