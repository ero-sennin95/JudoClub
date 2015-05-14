package intent_ed4_ex4.android.nfa025.com.judoclub;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class pseudoActivity extends ActionBarActivity {
    EditText pseudoET;
    String oldPseudo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pseudo);
        Intent result = this.getIntent();
       oldPseudo =  result.getStringExtra(MonJeu.TXT_PSEUDO);
        pseudoET =(EditText) this.findViewById(R.id.pseudoET);
        pseudoET.setText(oldPseudo);
    }

    public void onValidAction(View view){
    Log.i(MonJeu.APP_TAG, "onValidAction(): Debut");
        switch (view.getId()){
            case R.id.OK_btn:
                Log.i(MonJeu.APP_TAG, "OK Click");
                String pseudo1=pseudoET.getText().toString();
                if (pseudo1.equals(oldPseudo)) {
                    Toast.makeText(this, "Le pseudo est le meme", Toast.LENGTH_SHORT).show();
                    Log.i(MonJeu.APP_TAG, "OK Click, les chaine sont les meme");
                    this.setResult(RESULT_CANCELED);
                    break;

                }
                Intent result = new Intent();
                result.putExtra(MonJeu.TXT_PSEUDO, pseudoET.getText().toString());
                this.setResult(RESULT_OK,result);
                break;
            case R.id.Cancel_Btn:
                Log.i(MonJeu.APP_TAG,"Cancel Click");
                this.setResult(RESULT_CANCELED);
                break;
        }
        this.finish();

    }
}
