package com.intuit.craft.account.repository.user;

import javax.persistence.Column;
import javax.persistence.Id;

public class UserEntity {
    @Id
    private String id;
    @Column
    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
