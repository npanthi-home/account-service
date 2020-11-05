package com.intuit.craft.account.repository.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.UUID;

@Entity
public class UserEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "username")
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

    @PrePersist
    public void autofill() {
        this.setId(UUID.randomUUID().toString());
    }
}
