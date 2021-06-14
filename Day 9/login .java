06.14 09:06
package com.example.signup_login_by_sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText lg_email, lg_psswd;
    Button lg_btn;
    TextView signup;
    String reg_name, reg_email, reg_password,reg_mobile;
    SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "userdata";
    public static final String id = "name";
    public static final String email_id = "email_id";
    public static final String psswd = "psswd";
    public static final String mob = "mob";
    public static final String login_status = "login_status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.bg));
        }

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        lg_email = findViewById(R.id.login_name);
        lg_psswd = findViewById(R.id.login_password);
        signup = findViewById(R.id.signup_txt);
        lg_btn = findViewById(R.id.login_btn1);


        check_login();

        lg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reg_name = sharedPreferences.getString(id, "");
                reg_password = sharedPreferences.getString(psswd, "");
                reg_email = sharedPreferences.getString(email_id, "");
                reg_mobile =sharedPreferences.getString(mob, "");

                if (lg_email.getText().toString().equals(reg_email) == true && lg_psswd.getText().toString().equals(reg_password) == true) {
                    Intent i = new Intent(Login.this, Logout.class);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(login_status, true);
                    editor.commit();
                    finish();
                    startActivity(i);
                    Toast.makeText(Login.this, "Login Success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    void check_login() {
        if(sharedPreferences.getBoolean(login_status,false)==true)
        {
            Intent i = new Intent(Login.this, Logout.class);
            finish();
            startActivity(i);
            Toast.makeText(Login.this, "Login Success", Toast.LENGTH_SHORT).show();
        }
    }


}
