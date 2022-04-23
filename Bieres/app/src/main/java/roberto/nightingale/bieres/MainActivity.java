package roberto.nightingale.bieres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Ecouteur ecouteur;
    Button boutonAjouterEvaluation;
    Button boutonAfficherEvatualions;
    GestionBD instance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boutonAjouterEvaluation = findViewById(R.id.ajouterEvaluation);
        boutonAfficherEvatualions = findViewById(R.id.meilleursBieres);

        instance = GestionBD.getInstance(this);
        ecouteur = new Ecouteur();


        boutonAjouterEvaluation.setOnClickListener(ecouteur);
        boutonAfficherEvatualions.setOnClickListener(ecouteur);
    }

    class Ecouteur implements View.OnClickListener {

        Intent intent;

        @Override
        public void onClick(View source) {
            if (source == boutonAjouterEvaluation)
                intent = new Intent(MainActivity.this, EvaluationBiere.class);
            else if (source == boutonAfficherEvatualions)
                intent = new Intent(MainActivity.this, ListeBieres.class);
            startActivity(intent);
        }


    }
}

