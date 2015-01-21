package br.com.brunokadota.gestorfinaceiro.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.brunokadota.gestorfinaceiro.model.Gasto;

/**
 * Created by bruno.oliveira on 21/01/2015.
 */
public class GastoDAO {

    private DatabaseHelper helper;

    private SQLiteDatabase db;

    public GastoDAO(Context context) {
        helper = new DatabaseHelper(context);
    }

    private SQLiteDatabase getDb() {
        if (db == null) {
            db = helper.getWritableDatabase();
        }
        return db;
    }

    public long inserir(Gasto gasto) {

        ContentValues values = new ContentValues();

        values.put(DatabaseHelper.Gasto.NOME, gasto.getNome());

        values.put(DatabaseHelper.Gasto.VALOR,
                gasto.getValor());

        values.put(DatabaseHelper.Gasto.VENCIMENTO,
                gasto.getVencimento().getTime());

        values.put(DatabaseHelper.Gasto.MES,
                gasto.getMes());

        return getDb().insert(DatabaseHelper.Gasto.TABELA,
                null, values);
    }
}
