package roberto.nightingale.bieres;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class EvaluationBiere extends AppCompatActivity {
    Button boutonEnregistrer;
    Ecouteur ecouteur;

    EditText champNomBiere;
    EditText champNomMicrobrasserie;
    RatingBar etoilesBiere;

    GestionBD instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation_biere);

        champNomBiere = findViewById(R.id.champNomBiere);
        champNomMicrobrasserie = findViewById(R.id.champNomMicrobrasserie);
        etoilesBiere = findViewById(R.id.ratingBar);

        boutonEnregistrer = findViewById(R.id.boutonEnregistrer);

        instance = GestionBD.getInstance(this);
        ecouteur = new Ecouteur();


        boutonEnregistrer.setOnClickListener(ecouteur);
    }

    public class Ecouteur implements View.OnClickListener {

        @Override
        public void onClick(View source) {
            instance.ajouterEvaluation(new Evaluation(champNomBiere.getText().toString(), champNomMicrobrasserie.getText().toString(), (int) etoilesBiere.getRating()));

            // finish pour terminer la tache
           // instance.closeDB();
            finish();
        }
    }
}