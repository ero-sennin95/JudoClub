package intent_ed4_ex4.android.nfa025.com.judoclub;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MonJeu extends Activity {

    public static final String APP_TAG = "NFA025_EX4_TAG";
    public static final String TXT_PSEUDO = "PSEUDO_TXT";

    TextView pseudo_Tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monjeu);
         pseudo_Tv = (TextView) this.findViewById(R.id.pseudoTv);

        if(null !=savedInstanceState){
            Log.i(APP_TAG,"Restaure etat précédent");
        }
        else{
            Log.i(APP_TAG,"Premier démarrage");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putString(TXT_PSEUDO,pseudo_tv.getText().toString());
    }

    public void identifyPlayer(View view){
        Log.i(APP_TAG,"identifyPlayer : Debut");
    }
}
