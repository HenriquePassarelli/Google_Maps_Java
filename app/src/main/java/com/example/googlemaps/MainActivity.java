package com.example.googlemaps;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goMaps(View view) {
        EditText editTextLocal = findViewById(R.id.editTextLocal);
        EditText editTextLatitude = findViewById(R.id.editTextLatitude);
        EditText editTextLongitude = findViewById(R.id.editTextLongitude);

        LocalMaps localMaps = new LocalMaps("Finland",61.99110244210922,26.27076298108069);

        /*
        String local = "Finland";
        if(!editTextLocal.getText().toString().isEmpty()){
            local = editTextLocal.getText().toString();
        }else{
            editTextLocal.setText(local);
        }

        Double latitude = 61.99110244210922;
        EditText editTextLatitude = findViewById(R.id.editTextLatitude);
        if(!editTextLatitude.getText().toString().isEmpty()){
            latitude = Double.parseDouble(editTextLatitude.getText().toString());
        }else{
            editTextLatitude.setText(latitude.toString());
        }
        Double longitude = 26.27076298108069;
        EditText editTextLongitude = findViewById(R.id.editTextLongitude);
        if(!editTextLongitude.getText().toString().isEmpty()){
            longitude = Double.parseDouble(editTextLongitude.getText().toString());
        }else{
            editTextLongitude.setText(longitude.toString());
        }
*/
        if(editTextLocal.getText().toString().isEmpty()){
            editTextLocal.setText(localMaps.getLocal());
        }else{
            localMaps.setLocal(editTextLocal.getText().toString());
        }

        if(editTextLatitude.getText().toString().isEmpty()){
            editTextLatitude.setText(localMaps.getLatitude().toString());
        }else{
            localMaps.setLatitude(Double.parseDouble(editTextLatitude.getText().toString()));
        }

        if(editTextLongitude.getText().toString().isEmpty()){
            editTextLongitude.setText(localMaps.getLongitude().toString());
        }else{
            localMaps.setLongitude(Double.parseDouble(editTextLongitude.getText().toString()));
        }


            Bundle bundle = new Bundle();
        bundle.putString("local",localMaps.getLocal());
        bundle.putDouble("latitude",localMaps.getLatitude());
        bundle.putDouble("longitude",localMaps.getLongitude());

        Intent intent = new Intent(this,MapsActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

        editTextLocal.setText("");
        editTextLatitude.setText("");
        editTextLongitude.setText("");



    }



    public void exit(View view) {
        finish();
    }
}