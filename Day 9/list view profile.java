
package com.example.signup_login_by_sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Listview_profile extends AppCompatActivity {
    ListView listprofile;
    String List_name, List_email, List_mob, List_state, List_pincode, List_dob;
    ArrayList<String> profiledata = new ArrayList<>();
    SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "userdata";
    public static final String id = "name";
    public static final String email_id = "email_id";
    public static final String psswd = "psswd";
    public static final String mob = "mob";
    public static final String city = "state";
    public static final String dob = "dob";
    public static final String pincode = "pincode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.bg));
        }

        listprofile = findViewById(R.id.list_profile);
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        List_name = sharedPreferences.getString(id, "");
        List_email = sharedPreferences.getString(email_id, "");
        List_mob = sharedPreferences.getString(mob, "");
        List_state = sharedPreferences.getString(city, "");
        List_pincode = sharedPreferences.getString(pincode, "");
        List_dob= sharedPreferences.getString(dob, "");
        profiledata.add(List_name);
        profiledata.add(List_email);
        profiledata.add(List_mob);
        profiledata.add(List_state);
        profiledata.add(List_pincode);
        profiledata.add(List_dob);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Listview_profile.this, android.R.layout.simple_list_item_1, profiledata);
        listprofile.setAdapter(adapter);
    }
}
