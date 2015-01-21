package br.com.brunokadota.gestorfinaceiro.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bruno.oliveira on 21/01/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String BANCO_DADOS = "GestorFinanceiro";
    private static int VERSAO = 1;


    public DatabaseHelper(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE gastos (_id INTEGER PRIMARY KEY, " +
                "nome TEXT, " +
                "valor DOUBLE, " +
                "vencimento DATE, mes TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static class Gasto {
        public static final String TABELA = "GASTOS";
        public static final String _ID = "_ID";
        public static final String NOME = "NOME";
        public static final String VALOR = "VALOR";
        public static final String VENCIMENTO = "VENCIMENTO";
        public static final String MES = "MES";

        public static final String[] COLUNAS = new String[]{
                _ID, NOME, VALOR, VENCIMENTO, MES
        };
    }
}
