package model;

import java.io.Serializable;
import java.util.*;

public class User implements Serializable {
    private String userid;
    private String name;
    private String password;
    private List<Account> accounts;

    public User(String userid, String name, String password){
        this.userid=userid;
        this.name=name;
        this.password=password;
        this.accounts=new ArrayList<>();

    }
    public void addAccount(Account acc){
        accounts.add(acc);
    }
    public List<Account> getAccounts() {
        return accounts;
    }

    public String getUserId() {
        return userid;
    }

    public String getName() {
        return name;
    }

}
