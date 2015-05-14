package intent_ed4_ex4.android.nfa025.com.judoclub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MonJeu extends Activity {

    public static final String APP_TAG = "NFA025_EX4_TAG";
    public static final String TXT_PSEUDO = "PSEUDO_TXT";
    public static final int RESULT_ID = 1;

    TextView pseudo_Tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monjeu);
         pseudo_Tv = (TextView) this.findViewById(R.id.pseudoTv);

        if(null !=savedInstanceState){
            Log.i(APP_TAG,"Restaure etat précédent");
            pseudo_Tv.setText(savedInstanceState.getString(TXT_PSEUDO));
        }
        else{
            Log.i(APP_TAG,"Premier démarrage");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TXT_PSEUDO, pseudo_Tv.getText().toString());
    }

    public void identifyPlayer(View view){
        Log.i(APP_TAG,"identifyPlayer : Debut");
        Intent pseudoIntent = new Intent(this,pseudoActivity.class);
        pseudoIntent.putExtra(TXT_PSEUDO,pseudo_Tv.getText());
        this.startActivityForResult(pseudoIntent,RESULT_ID);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i(APP_TAG, "onActivityResult : Debut");
        if (resultCode==RESULT_OK)
            if (requestCode==RESULT_ID)
                pseudo_Tv.setText(data.getStringExtra(TXT_PSEUDO));
        super.onActivityResult(requestCode, resultCode, data);
    }
}
