package usuario.app.amareh;

/**
 * Created by JosiasJr on 24/04/2016.
 */
public class AuthResult {
    private String status;
    private String token;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String toString() {
        return status + " - " + token;
    }
}
