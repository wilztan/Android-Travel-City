package test.travkarta.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import test.travkarta.Model.Booking;
import test.travkarta.R;
import test.travkarta.TicketView;

public class BookingAdapter extends BaseAdapter {
    private ArrayList<Booking> bookings = new ArrayList<>();
    private Context con;
    LayoutInflater inflater ;

    public BookingAdapter(ArrayList<Booking> bookings, Context con) {
        this.bookings = bookings;
        this.con = con;
    }

    @Override
    public int getCount() {
        return bookings.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater.from(con));
        convertView = inflater.inflate(R.layout.view_booking_resource,null);

        TextView title = convertView.findViewById(R.id.bookingPlace),
                ticket = convertView.findViewById(R.id.tvTicketShow);
        LinearLayout ladapter = convertView.findViewById(R.id.bookingListAdapter);
        final Booking book= bookings.get(position);
        title.setText(book.getLocation());
        ticket.setText("Ticket Ordered : "+book.getTotalTicket());
        ladapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(con, TicketView.class);
                i.putExtra("name",book.getLocation());
                i.putExtra("booked",book.getTotalTicket());
                con.startActivity(i);
            }
        });
        return convertView;
    }
}
