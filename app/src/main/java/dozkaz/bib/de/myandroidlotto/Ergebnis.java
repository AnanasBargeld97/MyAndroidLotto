package dozkaz.bib.de.myandroidlotto;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ergebnis extends Activity {
    private TextView tvMeineZahlen;
    private TextView tvLottoZahlen;
    private TextView tvResult;

    private Button btnGenData;

    private String meineZahlen;
    private int [] lottoZahlen;
    private int erg;

    private int anzahl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ergebnis);

        tvMeineZahlen = (TextView) findViewById ( R.id.tvMeineZahlen);
        tvLottoZahlen = (TextView) findViewById ( R.id.tvLottozahlen);
        tvResult= (TextView) findViewById ( R.id.tvResult);
        btnGenData= (Button) findViewById ( R.id.btnGenData);
        btnGenData.setEnabled(false);




        tvLottoZahlen.setTextColor(Color.GREEN);
        tvMeineZahlen.setTextColor(Color.BLUE);


        anzahl = getIntent ().getExtras().getInt("anzahl");

        if(anzahl>0)btnGenData.setEnabled(true);

        meineZahlen = getIntent ().getExtras ().getString ( "meineZahlen" );
        tvMeineZahlen.setText(""+meineZahlen );


        lottoZahlen =  AndLotto.generiereLottozahlen();
        erg = AndLotto.xRichtige (lottoZahlen ,splitZahlen (  meineZahlen) );


        tvLottoZahlen.setText ( erzeugeString(lottoZahlen) );

        tvResult.setText ( ""+erg+ "-Richtige"  );

    }


    public void nochmalClick(View v)
    {
        Intent i = new Intent(this,MainActivity.class);

        startActivity(i);
    }


    public void genDataClick(View v)
    {
        Intent i = new Intent(this,GeneratedActivity.class);

        i.putExtra("anzahl",anzahl);
        i.putExtra("lottoZahlen", lottoZahlen);
        startActivity(i);
    }

    private int [] splitZahlen(String  arr)
    {

        String[] tmp2= arr.split(",");
        int [] tmp=new int  [tmp2.length];
        for(int i=0; i<tmp2.length;i++)
        {
            tmp[i]=Integer.parseInt ( tmp2[i].trim () );
        }
        return tmp;
    }


    public static String  erzeugeString(int []arr)
    {
        String  a=new String();
        for(int i = 0 ; i<arr.length;i++)
        {
            a +=( arr[i]+"  ");
        }
        return a;

    }
}
