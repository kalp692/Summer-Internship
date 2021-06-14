06.14 09:09
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
import android.widget.EditText;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    TextView pro_name,pro_email,pro_mob,pro_dob;
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
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.bg));
        }

        pro_name=findViewById(R.id.profile_name);
        pro_mob=findViewById(R.id.profile_mobile);
        pro_email=findViewById(R.id.profile_email);
        pro_dob=findViewById(R.id.profile_dob);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        pro_name.setText(sharedPreferences.getString(id,""));
        pro_mob.setText(sharedPreferences.getString(mob,""));
        pro_email.setText(sharedPreferences.getString(email_id,""));
        pro_dob.setText(sharedPreferences.getString(dob,""));

    }


}
