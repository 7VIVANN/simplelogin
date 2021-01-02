package com.example.simplelogin.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.simplelogin.model.User;

import java.util.ArrayList;
import java.util.List;

public class LoginViewModel extends ViewModel {
   public MutableLiveData<List<User>> userList;

    public LoginViewModel(MutableLiveData<List<User>> userList) {
        this.userList = userList;
    }

    public MutableLiveData<List<User>> getUserList() {
        return userList;
    }

    public void setUserList(MutableLiveData<List<User>> userList) {
        this.userList = userList;
    }

    public LoginViewModel() {
        User user1 = new User("admin", "password");
        User user2 = new User("user", "PASSWORD");

       List<User> arrayList = new ArrayList<>();
       arrayList.add(user1);
       arrayList.add(user2);

        userList = new MutableLiveData<>();
        userList.setValue(arrayList);
    }

    public void insert(String username, String password)
    {
        List<User> arrayList = getUserList().getValue();
        arrayList.add(new User(username,password));

        MutableLiveData<List<User>> userMutableLiveData = new MutableLiveData<>();
        userMutableLiveData.setValue(arrayList);

        setUserList(userMutableLiveData);
    }
}
