package com.intuit.craft.account.core.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Account {
    private String id;
    private Category category;
    private String username;
    private String email;
    private boolean isFavorite;
    private LocalDateTime lastAccessed;
    private User owner;

    public Account() {
        this.id = UUID.randomUUID().toString();
        this.category = Category.OTHERS;
        this.lastAccessed = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public LocalDateTime getLastAccessed() {
        return lastAccessed;
    }

    public void setLastAccessed(LocalDateTime lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
