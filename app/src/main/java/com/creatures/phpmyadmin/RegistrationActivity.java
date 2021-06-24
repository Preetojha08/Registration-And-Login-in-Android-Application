package com.creatures.phpmyadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class RegistrationActivity extends AppCompatActivity {

    TextInputEditText reg_tiet_fullname,reg_tiet_username,reg_tiet_password,reg_tiet_email;
    Button btn_reg_main;
    TextView tv_error;
    ProgressBar progress_bar_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        reg_tiet_fullname=(TextInputEditText)findViewById(R.id.reg_textinput_et_fullname);
        reg_tiet_username=(TextInputEditText)findViewById(R.id.reg_textinput_et_username);
        reg_tiet_password=(TextInputEditText)findViewById(R.id.reg_textinput_et_password);
        reg_tiet_email=(TextInputEditText)findViewById(R.id.reg_textinput_et_email);

        tv_error=(TextView)findViewById(R.id.text_view_error);

        progress_bar_reg=(ProgressBar)findViewById(R.id.progress_bar_reg);

        btn_reg_main=(Button)findViewById(R.id.registration_button_main);

        btn_reg_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullname,username,password,email;
                fullname=reg_tiet_fullname.getText().toString();
                username=reg_tiet_username.getText().toString();
                password=reg_tiet_password.getText().toString();
                email=reg_tiet_email.getText().toString();

                if (fullname.equals("") && username.equals("") && password.equals("") && email.equals("") )
                {
                    Toast.makeText(RegistrationActivity.this, "Enter All Details", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //Start ProgressBar first (Set visibility VISIBLE)
                    progress_bar_reg.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[4];
                            field[0] = "fullname";
                            field[1] = "username";
                            field[2] = "password";
                            field[3] = "email";

                            //Creating array for data
                            String[] data = new String[4 ];
                            data[0] = fullname;
                            data[1] = username;
                            data[2] = password;   //192.168.1.101 http://192.168.64.2/test_login/signup.php http://192.168.64.2/ http://192.168.64.2/new_post_test/post_signup.php http://192.168.64.2/test_login/signup.php
                            data[3] = email;
                            PutData putData = new PutData("https://preetojhadatabasetrail.000webhostapp.com/signup_login_test/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progress_bar_reg.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.equals("Sign Up Success"))
                                    {
                                        Toast.makeText(RegistrationActivity.this, ""+result, Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
                                        finish();
                                    }
                                    else
                                    {
                                        Toast.makeText(RegistrationActivity.this, ""+result, Toast.LENGTH_SHORT).show();
                                        tv_error.setText(result);
                                    }
                                    //End ProgressBar (Set visibility to GONE)
                                    Log.i("PutData", result);
                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                    //End of handler

                }
                //Toast.makeText(RegistrationActivity.this, "Registration Button is Pressed", Toast.LENGTH_SHORT).show();

            }
        });







    }
}