package test.travkarta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TicketView extends AppCompatActivity {

    private TextView name,booked;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_view);
        i = getIntent();
        name = findViewById(R.id.tvTicketTitle);
        booked = findViewById(R.id.tvTicketBooked);

        name.setText("Venue : "+ i.getStringExtra("name"));
//        booked.setText("Ticket Booked : "+ i.getStringExtra("booked"));

    }
}
