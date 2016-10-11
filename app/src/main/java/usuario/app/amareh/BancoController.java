package usuario.app.amareh;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class BancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context) {
        banco = new CriaBanco(context);

    }


    public String insereDado(String login, String senha, String email){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.LOGIN, login);
        valores.put(CriaBanco.SENHA, senha);
        valores.put(CriaBanco.EMAIL, email);


        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso" ;

    }
}

