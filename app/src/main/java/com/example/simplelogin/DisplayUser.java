package com.example.simplelogin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.simplelogin.viewmodel.LoginViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DisplayUser#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisplayUser extends Fragment {

    private String mParam1;
    private String mParam2;
    private View root;
    private View container;
    private LoginViewModel loginViewModel;

    private DisplayUserAdapter adapter;

    public RecyclerView recyclerView;

    public DisplayUser() {
        // Required empty public constructor
    }

    public static DisplayUser newInstance(String param1, String param2) {
        DisplayUser fragment = new DisplayUser();
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
        root =  inflater.inflate(R.layout.fragment_display_user, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) (root.findViewById(R.id.user_display));
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        adapter = new DisplayUserAdapter(new DisplayUserAdapter.UserDiff());
        recyclerView.setAdapter(adapter);

        loginViewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);

        loginViewModel.getUserList().observe(getViewLifecycleOwner(),adapter::submitList);

        final NavController navController = Navigation.findNavController(view);

        ((FloatingActionButton)view.findViewById(R.id.add_user)).setOnClickListener(it->{
            navController.navigate(R.id.action_displayUser_to_addUser);
        });
    }
}