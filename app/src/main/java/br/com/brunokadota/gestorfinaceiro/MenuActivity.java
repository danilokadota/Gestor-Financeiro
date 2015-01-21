package br.com.brunokadota.gestorfinaceiro;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity {

    private Button btncadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btncadastro = (Button) findViewById(R.id.menu_btn_cadastro);
        btncadastro.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCadastro();
            }
        });

    }
    public void showCadastro(){
        Intent intent = new Intent(this,CadastroActivity.class);
        startActivity(intent);
    }

}
