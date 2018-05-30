package test.travkarta.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import test.travkarta.Adapter.ListViewAdapter;
import test.travkarta.MainActivity;
import test.travkarta.Model.Location;
import test.travkarta.R;

public class TravelFragment extends Fragment{


    ListView lv_travel ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.travel_fragment, container, false);
        lv_travel = v.findViewById(R.id.lv_Travel);
        ListViewAdapter lvAdapter = new ListViewAdapter(getContext(), MainActivity.mTravelLocation);
        lv_travel.setAdapter(lvAdapter);

        return  v;
    }
}
