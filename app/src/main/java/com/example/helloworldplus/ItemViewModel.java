package com.example.helloworldplus;

import androidx.lifecycle.ViewModel;

public class ItemViewModel extends ViewModel {

     public String UserName = "";

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
