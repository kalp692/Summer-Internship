06.14 09:08
package com.example.signup_login_by_sharedpreference;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText name, email, password, mobile, state, pin,dateofBirth;
    Button signup;
    String Reg_detail, Reg_name, Reg_email, Reg_password, Reg_phone, Reg_state, Reg_pincode,date;
    DatePickerDialog datepicker;
    TimePickerDialog timepicker;
    public static final String MyPREFERENCES = "userdata";
    public static final String id = "name";
    public static final String email_id = "email_id";
    public static final String psswd = "psswd";
    public static final String mob = "mob";
    public static final String city = "state";
    public static final String pincode = "pincode";
    public static final String dob = "dob";
    public static final String login_status = "login_status";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.bg));
        }

        name = findViewById(R.id.registration_name);
        email = findViewById(R.id.registration_email);
        password = findViewById(R.id.registration_password);
        signup = findViewById(R.id.registration_btn1);
        mobile = findViewById(R.id.registration_phone);
        state = findViewById(R.id.registration_state);
        pin = findViewById(R.id.registration_pincode);
        dateofBirth= findViewById(R.id.registration_dob);
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        /* to show date*/
        dateofBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                datepicker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                date = year + "/" + monthOfYear+1 + "/" + dayOfMonth;
                                dateofBirth.setText(date);
                            }
                        }, year, month, day);
                datepicker.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datepicker.show();
            }
        });
            /* to show time*/
//        dateofBirth.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Calendar mcurrentTime = Calendar.getInstance();
//                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
//                int minute = mcurrentTime.get(Calendar.MINUTE);
//                timepicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                        date = hourOfDay + ":" + minute;
//                        dateofBirth.setText(date);
//                    }
//                }, hour, minute, true);
//                timepicker.setTitle("Select Time");
//                timepicker.show();
//            }
//        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Reg_name = name.getText().toString();
                Reg_email = email.getText().toString();
                Reg_password = password.getText().toString();
                Reg_phone = mobile.getText().toString();
                Reg_state = state.getText().toString();
                Reg_pincode = pin.getText().toString();

                if (Reg_name.equals("")) {
                    name.setError("Enter your name");
                } else if (Reg_email.equals("")) {
                    email.setError("Enter your Email");
                } else if (Reg_password.equals("")) {
                    password.setError("Enter Password");
                } else if (Reg_phone.equals("")) {
                    mobile.setError("Enter Mobile Number ");
                } else if (Reg_phone.length() < 10 && Reg_phone.length() > 10) {
                    mobile.setError("Enter valid Mobile Number ");
                } else if (Reg_state.equals("")) {
                    state.setError("Enter State Name");
                } else if (Reg_pincode.equals("")) {
                    pin.setError("Enter Pincode");
                }


                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(id, Reg_name);
                editor.putString(email_id, Reg_email);
                editor.putString(psswd, Reg_password);
                editor.putString(mob, Reg_phone);
                editor.putString(city, Reg_state);
                editor.putString(pincode, Reg_pincode);
                editor.putString(dob, date);

                editor.putBoolean(login_status, false);
                editor.commit();

                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);
            }
        });


    }
}
