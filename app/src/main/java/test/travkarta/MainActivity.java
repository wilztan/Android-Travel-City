package test.travkarta;

import android.app.Fragment;
import android.app.FragmentContainer;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

import test.travkarta.Fragment.BookingFragment;
import test.travkarta.Fragment.MainFragment;
import test.travkarta.Fragment.MapFragment;
import test.travkarta.Fragment.TravelFragment;
import test.travkarta.Model.Booking;
import test.travkarta.Model.Location;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;

    public static ArrayList<Booking> bookings = new ArrayList<Booking>();

    public static ArrayList<Location> mTravelLocation = new ArrayList<Location>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    onFragmentOne();
                    return true;
                case R.id.navigation_dashboard:
                    onFragmentTravel();
                    return true;
                case R.id.navigation_Booking:
                    onFragmentBooking();
                    return true;
//                case R.id.navigation_notifications:
//                    onFragmentMap();
//                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.fmMain);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        onFragmentOne();
        addCustomDatabase();
    }

    private void onFragmentOne(){
        setTitle("TravJakarta");
        MainFragment mainFragment = new MainFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fmMain,mainFragment,"Main");
        fragmentTransaction.commit();
    }

    private void onFragmentTravel(){
        setTitle("Visit Jakarta");
        TravelFragment mainFragment = new TravelFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fmMain,mainFragment,"Main");
        fragmentTransaction.commit();
    }

    private void onFragmentMap(){
        setTitle("Your Location");
        MapFragment mainFragment = new MapFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fmMain,mainFragment,"Main");
        fragmentTransaction.commit();
    }

    private void onFragmentBooking(){
        setTitle("Your Booking");
        BookingFragment mainFragment = new BookingFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fmMain,mainFragment,"Main");
        fragmentTransaction.commit();

    }



    private void addCustomDatabase() {
        mTravelLocation.add(new Location("Dufan",
                "Internationally themed amusement park offering roller coasters, interactive rides, flumes & shows.",
                "-6.123533", "106.831886","200000",
                R.drawable.dufan
        ));

        mTravelLocation.add(new Location("Kota Tua",
                "Kota Tua Jakarta, officially known as Kota Tua, is a neighborhood comprising the original downtown area of Jakarta, Indonesia. It is also known as Oud Batavia, Benedenstad, or Kota Lama.",
                "-6.126181","106.826025","Free",
                R.drawable.kotatua
        ));

        mTravelLocation.add(new Location("Instana Presiden",
                "The Merdeka Palace, is one of six presidential palaces in Indonesia. It is located on the north side of the Merdeka Square in Central Jakarta, Indonesia and is used as the official residence of the President of the Republic of Indonesia.",
                "-6.169952","106.824153","Free",
                R.drawable.istanapres
        ));

        mTravelLocation.add(new Location("Ragunan",
                "Ragunan is known for Ragunan Zoo, a large rainforest park with a primate center, elephants and Sumatran tigers, as well as shaded paths popular with joggers. Nearby Taman Anggrek Ragunan is a green public space with orchid gardens. Dining options in the area include pizzerias and ramen bars, as well as relaxed local eateries serving mutton fried rice and sambal chili catfish.",
                "-6.311246","106.820255","50000",
                R.drawable.ragunan
        ));

        mTravelLocation.add(new Location("Monas",
                "The National Monument is a 132 m tower in the centre of Merdeka Square, Central Jakarta, symbolizing the fight for Indonesia. It is the national monument of the Republic of Indonesia, built to commemorate the struggle for Indonesian independence.",
                "-6.175040","106.827121","Free",
                R.drawable.monas
        ));

        mTravelLocation.add(new Location("Dufan Part 2",
                "Internationally themed amusement park offering roller coasters, interactive rides, flumes & shows.",
                "-6.123533", "106.831886","200000",
                R.drawable.dufan
        ));

        mTravelLocation.add(new Location("Kota Tua Bagian Belakang",
                "Kota Tua Jakarta, officially known as Kota Tua, is a neighborhood comprising the original downtown area of Jakarta, Indonesia. It is also known as Oud Batavia, Benedenstad, or Kota Lama.",
                "-6.126181","106.826025","Free",
                R.drawable.kotatua
        ));

        mTravelLocation.add(new Location("Instana Presiden Exit 1",
                "The Merdeka Palace, is one of six presidential palaces in Indonesia. It is located on the north side of the Merdeka Square in Central Jakarta, Indonesia and is used as the official residence of the President of the Republic of Indonesia.",
                "-6.169952","106.824153","Free",
                R.drawable.istanapres
        ));

        mTravelLocation.add(new Location("Ragunan Zoo selatan",
                "Ragunan is known for Ragunan Zoo, a large rainforest park with a primate center, elephants and Sumatran tigers, as well as shaded paths popular with joggers. Nearby Taman Anggrek Ragunan is a green public space with orchid gardens. Dining options in the area include pizzerias and ramen bars, as well as relaxed local eateries serving mutton fried rice and sambal chili catfish.",
                "-6.311246","106.820255","70000",
                R.drawable.ragunan
        ));

        mTravelLocation.add(new Location("Pintu Masuk Monas",
                "The National Monument is a 132 m tower in the centre of Merdeka Square, Central Jakarta, symbolizing the fight for Indonesia. It is the national monument of the Republic of Indonesia, built to commemorate the struggle for Indonesian independence.",
                "-6.175040","106.827121","Free",
                R.drawable.monas
        ));
    }

}
