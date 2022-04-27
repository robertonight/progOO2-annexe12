package roberto.nightingale.bieres;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListeBieres extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_bieres);

        listView = findViewById(R.id.listView);

        GestionBD instance = GestionBD.getInstance(this);


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, instance.retournerMeilleurs());
        listView.setAdapter(arrayAdapter);
    }
}