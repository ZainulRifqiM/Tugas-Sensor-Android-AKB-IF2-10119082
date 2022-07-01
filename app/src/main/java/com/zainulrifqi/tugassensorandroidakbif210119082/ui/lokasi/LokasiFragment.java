//package com.zainulrifqi.tugassensorandroidakbif210119082.ui.lokasi;
//
//import android.Manifest;
//import android.content.pm.PackageManager;
//import android.location.Address;
//import android.location.Geocoder;
//import android.location.Location;
//import android.os.Bundle;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.core.app.ActivityCompat;
//import androidx.drawerlayout.widget.DrawerLayout;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.navigation.NavController;
//import androidx.navigation.Navigation;
//import androidx.navigation.ui.AppBarConfiguration;
//import androidx.navigation.ui.NavigationUI;
//
//import android.text.Html;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.google.android.gms.location.FusedLocationProviderClient;
//import com.google.android.gms.location.LocationServices;
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.android.gms.tasks.Task;
//import com.google.android.material.navigation.NavigationView;
//import com.google.android.material.snackbar.Snackbar;
//import com.zainulrifqi.tugassensorandroidakbif210119082.R;
//import com.zainulrifqi.tugassensorandroidakbif210119082.databinding.ActivityMainBinding;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Locale;
//
//
//public class LokasiFragment extends Fragment {
//
//    Button btn_lokasi;
//    TextView tv1, tv2, tv3, tv4, tv5;
//    FusedLocationProviderClient fusedLocationProviderClient;
//    private AppBarConfiguration mAppBarConfiguration;
//    private ActivityMainBinding binding;
//
//
//    SupportMapFragment supportMapFragment;
//    FusedLocationProviderClient client;
//
//    public LokasiFragment() {
//        // Required empty public constructor
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        btn_lokasi = (Button) getActivity().findViewById(R.id.btn_lokasi);
//        tv1 = getActivity().findViewById(R.id.tv1);
//        tv2 = getActivity().findViewById(R.id.tv2);
//        tv3 = getActivity().findViewById(R.id.tv3);
//        tv4 = getActivity().findViewById(R.id.tv4);
//        tv5 = getActivity().findViewById(R.id.tv5);
//
//        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity());
//
//        btn_lokasi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//                    getLocation();
//                } else {
//                    ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
//                }
//            }
//
//
//        });
//    }
//
//        private void getLocation() {
//        if (ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
//            @Override
//            public void onComplete(@NonNull Task<Location> task) {
//                Location location = task.getResult();
//                if (location != null) {
//
//                    try {
//                        Geocoder geocoder = new Geocoder(requireActivity(), Locale.getDefault());
//                        List<Address> addresses = geocoder.getFromLocation(
//                                location.getLatitude(), location.getLongitude(), 1
//                        );
//                        tv1.setText(Html.fromHtml("<font color = '#6200EE'><b>Latitude :</b><br></font>" + addresses.get(0).getLatitude()));
//                        tv2.setText(Html.fromHtml("<font color = '#6200EE'><b>Long :</b><br></font>" + addresses.get(0).getLongitude()));
//                        tv3.setText(Html.fromHtml("<font color = '#6200EE'><b>Country Name :</b><br></font>" + addresses.get(0).getCountryName()));
//                        tv4.setText(Html.fromHtml("<font color = '#6200EE'><b>Locality :</b><br></font>" + addresses.get(0).getLocality()));
//                        tv5.setText(Html.fromHtml("<font color = '#6200EE'><b>Address :</b><br></font>" + addresses.get(0).getAddressLine(0)));
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_lokasi, container, false);
//    }
//}