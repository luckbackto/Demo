package usuario.app.amareh;

import com.google.gson.Gson;

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
