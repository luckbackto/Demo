package usuario.app.amareh;

/**
 * Created by Luciano Medeiros on 23/10/2016.
 */

public class MainActivityController {
    //Classe Singleton para armazenar o usuario e a senha, por essa classe pode pegar esses parametros
    //em qualquer lugar o do sistema
    private static MainActivityController instance = null;

    private String login;
    private String senha;

    public static MainActivityController getInstance(){
        if(instance == null){
            instance = new MainActivityController();
        }

        return instance;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
