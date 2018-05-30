package test.travkarta;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import test.travkarta.Fragment.MapsActivity;
import test.travkarta.Model.Booking;
import test.travkarta.Model.Location;
import test.travkarta.MainActivity;

public class LocationDetail extends AppCompatActivity {
    private String title,
        desc,
        longitude,
        price,
        latitude;
    private int imageInt;

    private TextView ldName,
        ldPrice,
        ldDesc;

    private ImageView ivImage;

    private Button
        btnBook,
        btnMap;

    private TextView tvTicket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_detail);
        Intent i = getIntent();
        setIntentItem(i);
        declareView();

        ivImage.setImageResource(imageInt);
        ldName.setText(title);
        ldDesc.setText(desc);
        ivImage.getLayoutParams().height = getScreenHeight()/3;
        ldPrice.setText("Entrance Fee : "+price);

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LocationDetail.this, MapsActivity.class);
                i.putExtra("lat",latitude);
                i.putExtra("long",longitude);
                startActivity(i);
            }
        });

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = tvTicket.getText().toString();
                if(!result.equals("")){
                    int results =Integer.parseInt(result);
                    if(results>0){
                        MainActivity.bookings.add(new Booking(title,results));
                        Toast.makeText(LocationDetail.this, "Succesfully Added", Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(LocationDetail.this, "You Ordered No Tickets", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(LocationDetail.this, "You Can's Submit Empty Tickets", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    private void declareView() {
        ldName = findViewById(R.id.tvLDTitle);
        ldDesc = findViewById(R.id.tvLdDesc);
        ivImage = findViewById(R.id.ivLocationDetail);
        btnBook = findViewById(R.id.btnBook);
        btnMap = findViewById(R.id.btnCheckMap);
        tvTicket = findViewById(R.id.tvTicket);
        ldPrice = findViewById(R.id.tvLdPrice);
    }

    private void setIntentItem(Intent i) {
        title = i.getStringExtra("name");
        desc = i.getStringExtra("desc");
        longitude = i.getStringExtra("longitude");
        latitude = i.getStringExtra("latitude");
        imageInt = i.getIntExtra("image",imageInt);
        price = i.getStringExtra("price");
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}
