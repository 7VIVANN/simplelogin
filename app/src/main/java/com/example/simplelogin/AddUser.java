package com.example.simplelogin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.simplelogin.viewmodel.LoginViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddUser#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddUser extends Fragment {

    private String mParam1;
    private String mParam2;
    private View root;

    private LoginViewModel loginViewModel;

    public AddUser() {
        // Required empty public constructor
    }

    public static AddUser newInstance(String param1, String param2) {
        AddUser fragment = new AddUser();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       root =  inflater.inflate(R.layout.fragment_add_user, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loginViewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);

        ((Button)(view.findViewById(R.id.add))).setOnClickListener(it->{
            EditText username_field = ((EditText)(view.findViewById(R.id.editTextTextPersonName))) ;
            EditText password_field = ((EditText)(view.findViewById(R.id.editTextTextPassword))) ;

            loginViewModel.insert(username_field.getText().toString(), password_field.getText().toString());
        });

        final NavController navController = Navigation.findNavController(view);
        ((Button)(view.findViewById(R.id.back))).setOnClickListener(it->{
            navController.navigate(R.id.action_addUser_to_displayUser);
        });
    }
}