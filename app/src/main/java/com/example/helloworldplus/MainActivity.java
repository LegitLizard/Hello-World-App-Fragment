package com.example.helloworldplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private ItemViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment FirstFrag = new MainFrag();        //creates fragment
        FragmentTransaction tran = getSupportFragmentManager().beginTransaction();
        tran.add(R.id.FragContainer, FirstFrag).commit();
    }

    void LogName(){     //logs name in activity
        ItemViewModel viewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        String log = viewModel.getUserName();
        Log.i("Name", log);
    }

};