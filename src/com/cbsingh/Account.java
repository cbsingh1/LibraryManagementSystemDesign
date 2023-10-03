package com.cbsingh;

import com.cbsingh.model.AccountStatus;
import com.cbsingh.model.Person;

public class Account {
    private String id;
    private String password;
    private AccountStatus status;
    private Person person;

    public  boolean resetPassword(){
        return false;
    }

    public String getId() {
        return id;
    }

}
