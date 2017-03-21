package net.annecaroline.calculadora;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2;
    int valor1, valor2;
    int resultado;
    TextView soma;
    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        linear = (LinearLayout) findViewById(R.id.lb_resultado);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button ver = (Button)findViewById(R.id.bt_somar);
        ver.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                e1 = (EditText)findViewById(R.id.in_valor1);
                e2 = (EditText)findViewById(R.id.in_valor2);

                valor1 = stringToInt(e1.getText().toString());
                valor2 = stringToInt(e2.getText().toString());
                resultado = somaValores(valor1, valor2);

                soma = createNewTextView(resultado+"");
                linear.removeView((TextView)findViewById(R.id.soma_valor));
                linear.addView(soma);

                e1.getText().clear();
                e2.getText().clear();

            }


        });
    }

    public int somaValores(int valor1, int valor2) {
        return valor1 + valor2;
    }

    private TextView createNewTextView(String text) {
        final Toolbar.LayoutParams lparams =
                new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT,
                        Toolbar.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        textView.setLayoutParams(lparams);
        textView.setId(R.id.soma_valor);
        textView.setText("Resultado: " + text);
        return textView;
    }

    private int stringToInt(String s) {
        int value;
        try {
            value = Integer.parseInt(s);
        } catch (NumberFormatException e){
            value = 0;
        }
        return value;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public EditText getE1(){
        return e1;
    }

    public void setE1(EditText e) {
        e1.setText(e.getText());
    }

    public void setE2(EditText e) {
        e2.setText(e.getText());
    }

    public EditText getE2(){
        return e2;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int r){
        resultado = r;
    }

    public int getValor1() {
        return valor1;
    }

    public void setValor1(int v1){
        valor1 = v1;
    }

    public int getValor2() {
        return valor2;
    }


    public void setValor2(int v2){
        valor2 = v2;
    }
}
