package com.example.kaving.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.provider.SyncStateContract;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Marker  marker;
    private Circle mCircle;
    private Marker mMarker;
    public static final String NEWS_TYPE = "news_type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

   /* private void updateMarkerWithCircle(LatLng position) {
        mCircle.setCenter(position);
        mMarker.setPosition(position);
    }
*/
    //Draw circle
    private void drawMarkerWithCircle(){
        LatLng latLng = new LatLng(12.9200,77.6100);
        double radiusInMeters = 500.0;
        int strokeColor = 0xffff0000; //red outline
        int shadeColor = 0x44ff0000; //opaque red fill

        CircleOptions circleOptions = new CircleOptions().center(latLng).radius(radiusInMeters)
                .fillColor(shadeColor).strokeColor(strokeColor).strokeWidth(8);
        mCircle = mMap.addCircle(circleOptions);

        MarkerOptions markerOptions = new MarkerOptions().position(latLng);
        mMarker = mMap.addMarker(markerOptions);

    }

    //To retrive the address of a particular latlang.
    private String getAddress(double latitude, double longitude) {
        StringBuilder result = new StringBuilder();
        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses.size() > 0) {
                Address address = addresses.get(0);
                result.append(address.getLocality()).append("\n");
                result.append(address.getCountryName());
            }
        } catch (IOException e) {
            Log.e("tag", e.getMessage());
        }

        return result.toString();
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        //to draw circle

               /* LatLng latLng = new LatLng(12.9200,77.6100);
                if (mCircle == null || mMarker == null) {
                    drawMarkerWithCircle(latLng);
                } else {
                    updateMarkerWithCircle(latLng);
                }*/

        //to setup map
        mMap = googleMap;
        mMap.setMyLocationEnabled(true);
        mMap.getMyLocation();
        drawMarkerWithCircle();

        // Add a marker in Sydney and move the camera
         LatLng bangalore = new LatLng(12.9667, 77.5667);

        marker = mMap.addMarker(new MarkerOptions().position(new LatLng(12.9667, 77.5667)).title("Bengaluru City")
                .snippet("Thinking of finding some thing...")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        marker.showInfoWindow();
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(bangalore));
        //To zoom a specific marker on start.
        // private void moveToCurrentLocation(LatLng currentLocation)
        // {
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bangalore,5));
        // Zoom in, animating the camera.
        googleMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 4000, null);


        //}

        MarkerOptions lalbagh = new MarkerOptions();
        BitmapDescriptor icon1 = BitmapDescriptorFactory.fromResource(R.drawable.lalbagh);
        lalbagh.position(new LatLng(12.9500, 77.5900)).title("Lalbagh").icon(icon1);
        mMap.addMarker(lalbagh);
        getAddress(12.9500, 77.5900);

        MarkerOptions iscon = new MarkerOptions();
        BitmapDescriptor icon2 = BitmapDescriptorFactory.fromResource(R.drawable.iscon);
        iscon.position(new LatLng(13.0094, 77.5508)).title("Iscon Temple").icon(icon2);
        mMap.addMarker(iscon);

        MarkerOptions nandi = new MarkerOptions();
        nandi.position(new LatLng(13.3666667, 77.6833333)).title("Nandi Hills")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        mMap.addMarker(nandi);




        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                // Toast.makeText(MapsActivity.this, "hi buddy", Toast.LENGTH_SHORT).show();
                Intent newsIntent = new Intent(getBaseContext(), GoogleMapNewsRead.class);
                switch (marker.getTitle()) {
                    case "Bengaluru City":
                        newsIntent.putExtra(NEWS_TYPE, "https://en.wikipedia.org/wiki/Bangalore");
                        startActivity(newsIntent);
                        Toast.makeText(MapsActivity.this, "hi buddy this is Bengaluru", Toast.LENGTH_SHORT).show();
                        break;
                    case "Lalbagh":
                         newsIntent.putExtra(NEWS_TYPE, getAddress(12.9500, 77.5900));
                        startActivity(newsIntent);
                        Toast.makeText(MapsActivity.this, "hi buddy this is Lalbagh", Toast.LENGTH_SHORT).show();
                        break;
                    case "Iscon Temple":
                        newsIntent.putExtra(NEWS_TYPE, "https://en.wikipedia.org/wiki/ISKCON_Temple_Bangalore");
                        startActivity(newsIntent);
                        Toast.makeText(MapsActivity.this, "hi buddy this is Iscon Temple", Toast.LENGTH_SHORT).show();
                        break;
                    case "Nandi Hills":
                        newsIntent.putExtra(NEWS_TYPE, "https://en.wikipedia.org/wiki/Nandi_Hills,_India");
                        startActivity(newsIntent);
                        Toast.makeText(MapsActivity.this, "hi buddy this is Nandhi hills", Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });

    }
}
