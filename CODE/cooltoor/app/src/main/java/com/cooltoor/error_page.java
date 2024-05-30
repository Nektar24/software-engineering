package com.cooltoor;

import android.os.Bundle;
import android.provider.ContactsContract;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class error_page extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.home_menu_page); // TODO change to error_page

    }
}
