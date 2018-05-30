package test.travkarta.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import test.travkarta.LocationDetail;
import test.travkarta.Model.Location;
import test.travkarta.R;

public class ListViewAdapter extends BaseAdapter {

    ArrayList<Location> mLocation = new ArrayList<Location>();
    Context con;
    LayoutInflater inflater ;

    public ListViewAdapter(Context con,
                           ArrayList<Location> mLocation
    ){
        this.con  = con;
        this.mLocation = mLocation;
    }

    @Override
    public int getCount() {
        return mLocation.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater.from(con));
        convertView = inflater.inflate(R.layout.view_location_adapter,null);

        LinearLayout main_layout = convertView.findViewById(R.id.la_main_layout),
                Text_layout= convertView.findViewById(R.id.la_text_layout);
        TextView tvLATitle = convertView.findViewById(R.id.la_Title),
                tvLADesc = convertView.findViewById(R.id.la_desc),
                tvLAPrice = convertView.findViewById(R.id.la_price);
        ImageView ivCard = convertView.findViewById(R.id.la_image);

        final String title = mLocation.get(position).getName(),
                desc = mLocation.get(position).getDescription(),
                lotd = mLocation.get(position).getLongitude(),
                latd = mLocation.get(position).getLatitude(),
                price = mLocation.get(position).getPrice();
        final int image = mLocation.get(position).getImage();

        Text_layout.getLayoutParams().width = (getScreenWidth() - 20) * 4/5;
        ivCard.getLayoutParams().width = (getScreenWidth() - 20) * 1/5;
        ivCard.getLayoutParams().height =200;
        Log.d("seting view", "getView: ");
        String name = title;
        String descz = desc;
        try {
            name = title.substring(0,15)+"...";
        }catch (Exception e){
            Log.d(e.toString(), "catch: ");
        }
        try {
            descz = desc.substring(0,20)+"...";
        }catch (Exception e){
            Log.d(e.toString(), "catch: ");
        }
        tvLATitle.setText(name);
        tvLADesc.setText(descz);
        ivCard.setImageResource(image);
        tvLAPrice.setText("Entrance Fee : "+price);

        main_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(con, LocationDetail.class);
                i.putExtra("name",title);
                i.putExtra("desc",desc);
                i.putExtra("longitude",lotd);
                i.putExtra("latitude",latd);
                i.putExtra("image",image);
                i.putExtra("price",price);
                con.startActivity(i);
            }
        });

        return convertView;
    }
}
