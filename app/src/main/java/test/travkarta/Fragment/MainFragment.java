package test.travkarta.Fragment;

import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import test.travkarta.R;

public class MainFragment extends Fragment {

    private ImageView ivMain;

    private  RequestQueue queue;

    private String url_weather = "http://api.openweathermap.org/data/2.5/weather?q=Jakarta,ID&appid=50817e1815a7186ed5800037c259576f";

    private TextView mWeatherDegree,
        mWeatherCity,
        mWeatherName,
        mWeatherHumid;

    private LinearLayout weather_layout,
        weather_linear_layout
    ;

    private JSONObject weatherObject;

    private String weatherName,
        weatherDegree,
        weatherHumid;

    public MainFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_main, container, false);
        declare(v);
        mainSetScreen(v);
        getData();
        return  v;
    }

    private void mainSetScreen(View v) {
        ivMain.getLayoutParams().height = getScreenHeight()/3;
        weather_layout.getLayoutParams().width = (getScreenWidth()-20)*3/5;
        mWeatherDegree.getLayoutParams().width = (getScreenWidth()-20)*2/5;
    }

    private void declare(View v){
        ivMain = v.findViewById(R.id.ivMain);
        weather_layout = v.findViewById(R.id.llWeatherStatus);
        mWeatherCity = v.findViewById(R.id.tvCityName);
        mWeatherName = v.findViewById(R.id.tvWeatherName);
        mWeatherDegree = v.findViewById(R.id.tvWeatherDegree);
        mWeatherHumid = v.findViewById(R.id.tvWeatherHumidity);
        weather_linear_layout = v.findViewById(R.id.weather_layout);

    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    private void getData(){

        // Instantiate the RequestQueue.
        queue = Volley.newRequestQueue(getContext());

        // prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url_weather, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        weatherObject = response;
                        JSONObject mainObject;
                        JSONArray weatherNameObject;
                        try {
                            mainObject = weatherObject.getJSONObject("main");
                            Log.d("response", mainObject.toString());
                            weatherNameObject = weatherObject.getJSONArray("weather");
                            Log.d("response", weatherNameObject.toString());
                            weatherDegree = ((Float.parseFloat(mainObject.getString("temp"))/10 )+"").substring(0,2);
                            weatherName = weatherNameObject.getJSONObject(0).getString("main");
                            weatherHumid = mainObject.getString("humidity");

                            mWeatherDegree.setText(weatherDegree);
                            mWeatherName.setText(weatherName);
                            mWeatherHumid.setText("Humidity : "+weatherHumid);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mWeatherDegree.setText(0+" C");
                        mWeatherHumid.setText("None");
                        mWeatherName.setText("Network Error");
                    }
                }
        );

// add it to the RequestQueue
        queue.add(getRequest);
    }
}
