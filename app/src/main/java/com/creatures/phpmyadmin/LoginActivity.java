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
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class LoginActivity extends AppCompatActivity {

    Button btn_log_main;
    TextInputEditText tiet_username,tiet_password;
    ProgressBar progress_bar_log;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String MobilePattern = "[0-9]{10}";
    String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{6,10}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tiet_username=(TextInputEditText)findViewById(R.id.log_textinput_et_username);
        tiet_password=(TextInputEditText)findViewById(R.id.log_textinput_et_password);

        progress_bar_log=(ProgressBar)findViewById(R.id.progress_bar_login);

        btn_log_main=(Button)findViewById(R.id.login_button_main);

        btn_log_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username,password;

                username=tiet_username.getText().toString().trim();
                password=tiet_password.getText().toString().trim();

                if (username.equals("") && password.equals("") )
                {
                    Toast.makeText(getApplicationContext(), "Enter All Details", Toast.LENGTH_SHORT).show();
                }
                else if (username.matches(emailPattern))
                {
                    //Email ID with Password
                    //Toast.makeText(LoginActivity.this, "Valid Email address", Toast.LENGTH_SHORT).show();

                    progress_bar_log.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];

                            field[0] = "username";
                            field[1] = "password";

                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = username;
                            data[1] = password;   //192.168.1.101 http://192.168.64.2/test_login/signup.php http://192.168.64.2/ http://192.168.64.2/new_post_test/post_signup.php http://192.168.64.2/test_login/signup.php
                            PutData putData = new PutData("https://preetojhadatabasetrail.000webhostapp.com/signup_login_test/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progress_bar_log.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.equals("Login Success"))
                                    {
                                        Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                        finish();
                                    }
                                    else
                                    {
                                        Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_SHORT).show();
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
                else if (username.matches(MobilePattern))
                {
                    // Mobile Number with Password
                    progress_bar_log.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];

                            field[0] = "username";
                            field[1] = "password";

                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = email;
                            data[1] = password;   //192.168.1.101 http://192.168.64.2/test_login/signup.php http://192.168.64.2/ http://192.168.64.2/new_post_test/post_signup.php http://192.168.64.2/test_login/signup.php
                            PutData putData = new PutData("https://preetojhadatabasetrail.000webhostapp.com/signup_login_test/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progress_bar_log.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.equals("Login Success"))
                                    {
                                        Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                        finish();
                                    }
                                    else
                                    {
                                        Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_SHORT).show();
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
                else
                {
                    //Username with Password
                    progress_bar_log.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];

                            field[0] = "username";
                            field[1] = "password";

                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = username;
                            data[1] = password;   //192.168.1.101 http://192.168.64.2/test_login/signup.php http://192.168.64.2/ http://192.168.64.2/new_post_test/post_signup.php http://192.168.64.2/test_login/signup.php
                            PutData putData = new PutData("https://preetojhadatabasetrail.000webhostapp.com/signup_login_test/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progress_bar_log.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.equals("Login Success"))
                                    {
                                        Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                        finish();
                                    }
                                    else
                                    {
                                        Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_SHORT).show();
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
            }
        });

        /*btn_reg_main.setOnClickListener(new View.OnClickListener() {
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
                            data[0] = fullname;http:
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
         */


    }
}