package com.example.gispolylinemap;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        mMap = googleMap;

        // Add a marker in Home and move the camera
        LatLng home = new LatLng(-0.815740, 119.887429);
        LatLng mouza = new LatLng(-0.849129, 119.882459);
        LatLng alfamidi_1 = new LatLng(-0.840332, 119.883411);
        LatLng alfamidi_2 = new LatLng(-0.844960, 119.882769);

        //Custome size marker
        int tinggi = 100;
        int lebar = 50;
        BitmapDrawable bitmapStart = (BitmapDrawable)getResources().getDrawable(R.drawable.pin_map_home);
        BitmapDrawable bitmapDes = (BitmapDrawable)getResources().getDrawable(R.drawable.pin_map_supermarket);
        Bitmap s = bitmapStart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();
        Bitmap markerStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap markerDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);

        //Add marker to Map
        mMap.addMarker (new MarkerOptions().position(home).title("Marker in My Home")
         .snippet("Ini adalah Tempat Tinggal saya!")
         .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));

         mMap.addMarker (new MarkerOptions().position(mouza).title("Marker in Mouza Supermarket")
         .snippet("Ini adalah Mouza Supermarket!")
         .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

        mMap.addMarker (new MarkerOptions().position(alfamidi_1).title("Marker in Alfamidi 1")
                .snippet("Ini adalah Alfamidi RE Martadinata 2!")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

        mMap.addMarker (new MarkerOptions().position(alfamidi_2).title("Marker in Alfamidi 2")
                .snippet("Ini adalah Alfamidi Martadinata Tondo!")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

         mMap.addPolyline(new PolylineOptions().add(
                 home,
                 new LatLng(-0.815740, 119.887429),
                 new LatLng(-0.815877, 119.887218),
                 new LatLng(-0.816087, 119.886894),
                 new LatLng(-0.816112, 119.886240),
                 new LatLng(-0.819418, 119.885859),
                 new LatLng(-0.820649, 119.885535),
                 new LatLng(-0.821099, 119.885430),
                 new LatLng(-0.822184, 119.885452),
                 new LatLng(-0.825119, 119.885685),
                 new LatLng(-0.825354, 119.885662),
                 new LatLng(-0.826947, 119.884733),
                 new LatLng(-0.827333, 119.884818),
                 new LatLng(-0.830404, 119.887822),
                 new LatLng(-0.832942, 119.888696),
                 new LatLng(-0.835655, 119.889279),
                 new LatLng(-0.836028, 119.889432),
                 new LatLng(-0.836086, 119.889452),
                 new LatLng(-0.836195, 119.889588),
                 new LatLng(-0.836367, 119.889539),
                 new LatLng(-0.836383, 119.889369),
                 new LatLng(-0.836291, 119.889243),
                 new LatLng(-0.836107, 119.885698),
                 new LatLng(-0.836221, 119.883424),
                 new LatLng(-0.838045, 119.883463),
                 new LatLng(-0.839069, 119.883364),
                 new LatLng(-0.841529, 119.883282),
                 new LatLng(-0.844287, 119.882964),
                 new LatLng(-0.848480, 119.882611),
                 new LatLng(-0.849089, 119.882720),
                 new LatLng(-0.849129, 119.882459),
                 mouza
                 ).width(7)
                 .color(Color.MAGENTA)
         );
         mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home,15.5f));
    }
}
