package modelo;

import java.util.ArrayList;

/**
 * Created by JosiasJr on 24/04/2016.
 */
public class MapsDirection {

    private String error_message;
    private ArrayList routes;
    private String status;

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public ArrayList getRoutes() {
        return routes;
    }

    public void setRoutes(ArrayList routes) {
        this.routes = routes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
