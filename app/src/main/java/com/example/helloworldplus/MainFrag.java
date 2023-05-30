package com.example.helloworldplus;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFrag extends Fragment implements View.OnClickListener  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ItemViewModel viewModel;
    Button NameButton;
    EditText NameBox;


    public MainFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFrag newInstance(String param1, String param2) {
        MainFrag fragment = new MainFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ItemViewModel viewModel = new ViewModelProvider(getActivity()).get(ItemViewModel.class);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main, container, false);      //creates view and listener for button
        NameButton = (Button) view.findViewById(R.id.NameButton);
        NameButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {       //listener for button click
        AppCompatEditText TextField = view.findViewById(R.id.TextField);
        EditText NameBox = view.findViewById(R.id.HelloNameBox);
        ItemViewModel viewModel = new ViewModelProvider(getActivity()).get(ItemViewModel.class);

        String  text = TextField.getText().toString();
        viewModel.setUserName(text);
        NameBox.setText("Hello " +  viewModel.getUserName());
        String log = viewModel.getUserName();
        Log.i("Name", log);     //logs name in fragment
        ((MainActivity)getActivity()).LogName();        //calls activity log function
    }

}