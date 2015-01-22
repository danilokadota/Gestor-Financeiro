package br.com.brunokadota.gestorfinaceiro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by bruno.oliveira on 21/01/2015.
 */
public class LoginActivity extends ActionBarActivity {

    private EditText editTextUsuario;
    private EditText editTextSenha;
    private Button btnEntrar;
    private static final String USUARIO = "teste";
    private static final String SENHA = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findView();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //captureValues();
                Intent menuActivity = new Intent(getBaseContext(), MenuActivity.class);
                startActivity(menuActivity);
                finish();
            }
        });

    }

    public void findView() {
        editTextUsuario = (EditText) findViewById(R.id.login_edit_usuario);
        editTextSenha = (EditText) findViewById(R.id.login_edit_senha);
        btnEntrar = (Button) findViewById(R.id.login_btn_entrar);
    }

    public void captureValues() {
        String usuario = editTextUsuario.getText().toString();
        String senha = editTextSenha.getText().toString();
        if (usuario.equals(USUARIO) && senha.equals(SENHA)) {
            Intent menuActivity = new Intent(getBaseContext(), MenuActivity.class);
            startActivity(menuActivity);
            finish();
        } else {

            Toast.makeText(LoginActivity.this, "Informe usuário e senha válidos", Toast.LENGTH_SHORT).show();
            editTextSenha.setText("");
        }

    }


}
