package com.tryingOutNeo4j.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class Account {

@Id
@GeneratedValue
    private Long id;

private String name;
private String typeOfAccount;
private boolean isPremiumAccount;

@Relationship(type = "INCLUDES")
@JsonIgnoreProperties("userAccounts")
    private List<User> users = new ArrayList<User>();

public Account(){

}

public Account(String name, String typeOfAccount, boolean isPremiumAccount){
    this.name = name;
    this.typeOfAccount = typeOfAccount;
    this.isPremiumAccount = isPremiumAccount;
}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public boolean isPremiumAccount() {
        return isPremiumAccount;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addUser(User user){
    this.users.add(user);
    }

    public void setTypeOfAccount(String typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }

    public void setPremiumAccount(boolean premiumAccount) {
        isPremiumAccount = premiumAccount;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
