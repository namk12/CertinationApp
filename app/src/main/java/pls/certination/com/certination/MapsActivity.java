package pls.certination.com.certination;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    TextView certidelhi;



    @Override
    public void onMapReady(GoogleMap googleMap) {

        Marker m1 = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(22.800134, 86.189717))
                .anchor(0.5f, 0.5f)
                .title("Jamshedpur Location"));



        Marker m2 = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(31.258189,75.707936))
                .anchor(0.5f, 0.5f)
                .title("Jalandhar Location"));


        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng delhi = new LatLng(28.584291, 77.071556);
        mMap.addMarker(new MarkerOptions().position(delhi).title("Delhi Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(delhi));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        certidelhi=(TextView)findViewById(R.id.certinationdelhi);
        certidelhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*LatLng pos = new LatLng(28.584291, 77.071556);
                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(pos, 15);
                mMap.moveCamera(update);*/
                LatLng latLng = new LatLng(28.584291, 77.071556);
                CameraUpdate cameraUpdate = (CameraUpdateFactory.newLatLngZoom(latLng, 10));
                mMap.animateCamera(cameraUpdate);
            }
        });

        certidelhi=(TextView)findViewById(R.id.certinationjalandhar);
        certidelhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*LatLng pos = new LatLng(28.584291, 77.071556);
                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(pos, 15);
                mMap.moveCamera(update);*/
                LatLng latLng = new LatLng(31.258189, 75.707936);
                CameraUpdate cameraUpdate = (CameraUpdateFactory.newLatLngZoom(latLng, 10));
                mMap.animateCamera(cameraUpdate);
            }
        });

        certidelhi=(TextView)findViewById(R.id.certinationjamshedpur);
        certidelhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*LatLng pos = new LatLng(28.584291, 77.071556);
                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(pos, 15);
                mMap.moveCamera(update);*/
                LatLng latLng = new LatLng(22.800134, 86.189717);
                CameraUpdate cameraUpdate = (CameraUpdateFactory.newLatLngZoom(latLng, 10));
                mMap.animateCamera(cameraUpdate);
            }
        });

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */



}
