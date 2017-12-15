package teamtreehouse.com.locationtracker.UI;

import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import teamtreehouse.com.locationtracker.R;
import teamtreehouse.com.locationtracker.Services.Util;

public class MainActivity extends AppCompatActivity {

    EditText startDateTextView;
    EditText endDateTextView;
    Button submitButton;
    private static final String TAG = "MainActivity";
    public static Location location;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Util.scheduleJob(MainActivity.this);
        //startService(new Intent(this, MappingService.class));
        String pattern = "MM/dd/yyyy";
        final SimpleDateFormat format = new SimpleDateFormat(pattern);
        format.setLenient(false);

        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startDateTextView = findViewById(R.id.startDate);
                endDateTextView = findViewById(R.id.endDate);
                endDateTextView.getText().toString();

                try {
                    Long startDate = format.parse(startDateTextView.getText().toString()).getTime();
                    Long endDate = format.parse(endDateTextView.getText().toString()).getTime();


                    Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                    intent.putExtra("startDate", startDate);
                    intent.putExtra("endDate", endDate);
                    startActivity(intent);
                } catch (ParseException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Incorrectly formatted date, try again with format MM/DD/YYYY.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
