package sg.edu.rp.c346.p08_practical_quiz;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etAge;
    Button btnSave;
    Spinner spinner;

    int classes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etAge = findViewById(R.id.editTextAge);
        btnSave = findViewById(R.id.buttonSave);
        spinner = findViewById(R.id.spinner);

        etAge.requestFocus();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clicked = true;
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor edit = preferences.edit();
                edit.putString("Name",etName.getText().toString());
                edit.putInt("Age",Integer.parseInt(etAge.getText().toString()));
                edit.putInt("c",classes);
                edit.commit();
                Toast.makeText(getBaseContext(),"Saved",Toast.LENGTH_SHORT).show();
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        classes = i;
                        break;
                    case 1:
                        classes = i;
                        break;
                    case 2:
                        classes = i;
                        break;
                    case 3:
                        classes = i;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String name = preferences.getString("Name","Failed");
        int age = preferences.getInt("Age",0);
        int id = preferences.getInt("c",0);
        if(name.equalsIgnoreCase("Failed")){
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            etName.setText(null);
            etAge.setText(null);
        }
        else{
            Toast.makeText(getBaseContext(), String.valueOf(id), Toast.LENGTH_SHORT).show();
            etName.setText(name);
            etAge.setText(String.valueOf(age));
            spinner.setSelection(id);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        /*SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = preferences.edit();
        if(clicked){
            edit.putString("Name",etName.getText().toString());
            edit.putInt("Age",Integer.parseInt(etAge.getText().toString()));
            edit.putInt("c",classes);
        }
        edit.commit();*/
    }
}
