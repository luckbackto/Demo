package usuario.app.amareh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }
    public void btMares(View v){
        Intent intent = new Intent(this, MaresActivity.class);
        startActivity(intent);
        finish();
    }
    public void btAgenda(View v){
        Intent intent = new Intent(this, AgendamentoActivity.class);
        startActivity(intent);
        finish();
    }
    public void btHistorico(View v){
        Intent intent = new Intent(this, HistoricoActivity.class);
        startActivity(intent);
        finish();
    }
}
