package br.com.brunokadota.gestorfinaceiro;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import br.com.brunokadota.gestorfinaceiro.dao.GastoDAO;
import br.com.brunokadota.gestorfinaceiro.model.Gasto;


public class CadastroActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks, View.OnClickListener {

    private NavigationDrawerFragment mNavigationDrawerFragment;
    private CharSequence mTitle;
    private EditText editTextNome;
    private EditText editTextValor;
    private Button btnDateVencimento;
    static final int DATE_DIALOG_ID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        findView();

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        btnDateVencimento.setOnClickListener((View.OnClickListener) this);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    public void inserirGasto() {
        Gasto gasto = new Gasto(1, editTextNome.getText().toString(),
                Float.parseFloat(editTextValor.getText().toString()),
                "12/12/2015", "Janeiro");
        GastoDAO gastoDAO = new GastoDAO(getBaseContext());

        long resp = gastoDAO.inserir(gasto);

        Toast.makeText(getBaseContext(), "retorno: " + resp, Toast.LENGTH_SHORT).show();
    }

    public void findView() {
        editTextNome = (EditText) findViewById(R.id.cadastro_edit_nome);
        editTextValor = (EditText) findViewById(R.id.cadastro_edit_valor);
        btnDateVencimento = (Button) findViewById(R.id.cadastro_edit_vencimento);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.janeiro);
                break;
            case 2:
                mTitle = getString(R.string.fevereiro);
                break;
            case 3:
                mTitle = getString(R.string.marco);
                break;
            case 4:
                mTitle = getString(R.string.abril);
                break;
            case 5:
                mTitle = getString(R.string.maio);
                break;
            case 6:
                mTitle = getString(R.string.junho);
                break;
            case 7:
                mTitle = getString(R.string.julho);
                break;
            case 8:
                mTitle = getString(R.string.agosto);
                break;
            case 9:
                mTitle = getString(R.string.setembro);
                break;
            case 10:
                mTitle = getString(R.string.outubro);
                break;
            case 11:
                mTitle = getString(R.string.novembro);
                break;
            case 12:
                mTitle = getString(R.string.dezembro);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.menu_cadastro, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_example) {
            inserirGasto();
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v == btnDateVencimento) {
            showDialog(DATE_DIALOG_ID);
        }
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_meses, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((CadastroActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Calendar calendar = Calendar.getInstance();

        int ano = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);

        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateSetListener, ano, mes, dia);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            String data = String.valueOf(dayOfMonth) + "/" + String.valueOf(monthOfYear + 1) + "/" + String.valueOf(year);
            btnDateVencimento.setText(data);
        }
    };
}
