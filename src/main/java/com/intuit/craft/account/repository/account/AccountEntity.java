package com.intuit.craft.account.repository.account;

import com.intuit.craft.account.repository.user.UserEntity;

import javax.persistence.Column;
import javax.persistence.Id;

public class AccountEntity {
    @Id
    private String id;
    @Column
    private String category;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private boolean favorite;
    @Column
    private long lastAccessed;
    @Column
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
}
