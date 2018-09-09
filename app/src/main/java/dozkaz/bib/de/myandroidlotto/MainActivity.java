package dozkaz.bib.de.myandroidlotto;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {

    private MultiSelectionSpinner multiSpin;
    private EditText etGen;
    private Button btnGen;

    private String[] zahlen;
    private int[] auswahl;
    private int anzahl=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zahlen = new String[49];

        fillNumbers(zahlen);


        //itemSelected();

        multiSpin = (MultiSelectionSpinner) findViewById(R.id.mySpinner1);
        etGen = (EditText) findViewById(R.id.etGenerate);
        btnGen = (Button) findViewById(R.id.btnGenerate);

        btnGen.setEnabled(false);

        multiSpin.setItems(zahlen);


        textChanged();
    }

    public void playClick(View v)
    {

        String s = multiSpin.getSelectedItem().toString();


        String[] tmp= s.split ( "," );
        if(tmp.length>6 || tmp.length <6)
        {
            Toast.makeText ( this , "Bitte genau 6 Zahlen waehlen" ,Toast.LENGTH_LONG ).show ();
        }
        else
        {
            Intent erg= new Intent(this, Ergebnis.class);

            erg.putExtra ( "meineZahlen" , s )	;
            erg.putExtra("anzahl", anzahl);
            startActivity (erg);
        }

    }




    public void generateClick(View v)
    {
        String st = multiSpin.getSelectedItem().toString();


        String[] tmp= st.split ( "," );
        if(tmp.length>6 || tmp.length <6)
        {
            Toast.makeText ( this , "Bitte genau 6 Zahlen waehlen" ,Toast.LENGTH_LONG ).show ();
        }

        else{
            int count = Integer.parseInt(etGen.getText().toString());

            if (count>100000 || count>Integer.MAX_VALUE) {Toast.makeText(this,"Maximal 100.000  Ziehungen!!", Toast.LENGTH_SHORT).show();}

            else
            {
                anzahl=count;
                Toast.makeText(this, ""+anzahl+"- Ziehungen generiert...", Toast.LENGTH_SHORT).show();
            }

            String s2 = multiSpin.getSelectedItem().toString();



            Intent erg= new Intent(this, Ergebnis.class);

            erg.putExtra ( "meineZahlen" , s2 )	;
            erg.putExtra("anzahl", anzahl);
            startActivity (erg);

        }

    }



    private void textChanged()
    {
        etGen.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s)
            {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                Log.d("KAAAAAAZ", "In Edittext steht mindestens ein Buchsatbe drin");
                checkEmpty();
            }

        });

    }





    private void  checkEmpty()
    {

        if(etGen.getText().toString().trim().length() == 0 )

            btnGen.setEnabled(false);

        else btnGen.setEnabled(true);




    }




    private void fillNumbers(List<Integer> list)
    {
        for (int i = 0; i < 49; i++)
        {
            list.add(i+1);
            zahlen[i]= String.valueOf(i+1);
        }
    }

    private void fillNumbers(String [] arr)
    {
        for (int i = 0; i < 49; i++)
        {
            arr[i]=i+1+"";

        }
    }

}
