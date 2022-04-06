package com.example.fishybusiness;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.fishybusiness.databinding.ActivityMapsBinding;
import android.graphics.drawable.Drawable;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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

        // Add a marker in Sydney and move the camera
        LatLng provo = new LatLng(40.253501, -111.675223);

        LatLng provoRiver = new LatLng(40.236482, -111.734727);
        mMap.addMarker(new MarkerOptions().position(provoRiver).title("Provo River")
            .icon(BitmapFromVector(getApplicationContext(), R.drawable.ic_baseline_place_24)));

        LatLng provoBay = new LatLng(40.186915, -111.716765);
        mMap.addMarker(new MarkerOptions().position(provoBay).title("Provo Bay")
                .icon(BitmapFromVector(getApplicationContext(), R.drawable.ic_baseline_place_24)));

        LatLng utahLake = new LatLng(40.267255, -111.850494);
        mMap.addMarker(new MarkerOptions().position(utahLake).title("Utah Lake")
                .icon(BitmapFromVector(getApplicationContext(), R.drawable.ic_baseline_place_24)));

        LatLng unionAqueduct = new LatLng(40.323653, -111.645861);
        mMap.addMarker(new MarkerOptions().position(unionAqueduct).title("Union Aqueduct")
                .icon(BitmapFromVector(getApplicationContext(), R.drawable.ic_baseline_place_24)));

        LatLng hathenbrookSpring = new LatLng(40.207658, -111.623850);
        mMap.addMarker(new MarkerOptions().position(hathenbrookSpring).title("Hathenbrook Spring")
                .icon(BitmapFromVector(getApplicationContext(), R.drawable.ic_baseline_place_24)));

        mMap.addMarker(new MarkerOptions().position(provo).title("You are here")
            .icon(BitmapFromVector(getApplicationContext(), R.drawable.ic_baseline_my_location_24)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(provo));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(provo, 11.0f));

    }
    private BitmapDescriptor BitmapFromVector(Context context, int vectorResId) {
        // below line is use to generate a drawable.
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);

        // below line is use to set bounds to our vector drawable.
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());

        // below line is use to create a bitmap for our
        // drawable which we have added.
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

        // below line is use to add bitmap in our canvas.
        Canvas canvas = new Canvas(bitmap);

        // below line is use to draw our
        // vector drawable in canvas.
        vectorDrawable.draw(canvas);

        // after generating our bitmap we are returning our bitmap.
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}