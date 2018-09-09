package dozkaz.bib.de.myandroidlotto;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class GeneratedActivity extends Activity {


    private ListView lvZiehungen4;

    private TextView tvLotto;
    private int[][] alleZiehungen;
    private int[] lottoZahlen;

    private ArrayList<String> ziehungen;



    private int anzahl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generated);

        tvLotto = (TextView)findViewById(R.id.lottoZ);


        anzahl = getIntent ().getExtras ().getInt("anzahl" );

        lottoZahlen = getIntent ().getExtras ().getIntArray("lottoZahlen" );
        tvLotto.setTextColor(Color.GREEN);


        tvLotto.setText(Ergebnis.erzeugeString((lottoZahlen)));

        alleZiehungen = AndLotto.generiereZiehungen(anzahl);
        ziehungen = new ArrayList<String>();

        int z =1;
        for (int i = 0; i < alleZiehungen.length; i++)
        {
            if ((AndLotto.xRichtige(lottoZahlen, alleZiehungen[i]) == 4))
            {
                ziehungen.add(z+":   "+intArrtoString(alleZiehungen[i])+"     (4-Richtige)   "+"      Ziehung("+i+")");
                z++;
            }
            if ((AndLotto.xRichtige(lottoZahlen, alleZiehungen[i]) == 5))
            {
                ziehungen.add(z+":   "+intArrtoString(alleZiehungen[i])+"     (5-Richtige)   "+"      Ziehung("+i+")");
                z++;
            }
            if ((AndLotto.xRichtige(lottoZahlen, alleZiehungen[i]) == 6))
            {
                ziehungen.add(z+":   "+intArrtoString(alleZiehungen[i])+"     (6-Richtige)   "+"      Ziehung("+i+")");
                z++;
            }
        }


        if(z==1)ziehungen.add("Keine Gewinner");

        lvZiehungen4 = (ListView) findViewById(R.id.won4);

        ListAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, ziehungen);

        lvZiehungen4.setAdapter(adapter);

    }


    private String intArrtoString(int [] arr)
    {
        String s = "";
        for (int i = 0; i < arr.length-1; i++)
        {
            s= s+arr[i]+" , ";
            if(i==arr.length-2)s= s+arr[i+1];

        }

        return s;
    }

}
