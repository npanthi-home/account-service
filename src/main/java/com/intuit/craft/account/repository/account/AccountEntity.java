package com.intuit.craft.account.repository.account;

import com.intuit.craft.account.repository.user.UserEntity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class AccountEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "category")
    private String category;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "favorite")
    private boolean favorite;
    @Column(name = "last_accessed")
    private long lastAccessed;
    @ManyToOne
    private UserEntity owner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public long getLastAccessed() {
        return lastAccessed;
    }

    public void setLastAccessed(long lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    @PrePersist
    public void autofill() {
        this.setId(UUID.randomUUID().toString());
    }
}
