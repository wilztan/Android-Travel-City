package test.travkarta.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import test.travkarta.Adapter.BookingAdapter;
import test.travkarta.MainActivity;
import test.travkarta.Model.Booking;
import test.travkarta.R;

public class BookingFragment extends Fragment {

    private ListView lv_booking;
    private TextView textStatus;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.booking_fragment, container, false);
        lv_booking = v.findViewById(R.id.lvBooking);
        textStatus = v.findViewById(R.id.bookingText);
        if(MainActivity.bookings.size()==0){
            textStatus.setText("No Booking Listed");
        }else {
            textStatus.setText("");
        }
        BookingAdapter badapter = new BookingAdapter(MainActivity.bookings,getContext());
        lv_booking.setAdapter(badapter);
        return v;
    }
}
