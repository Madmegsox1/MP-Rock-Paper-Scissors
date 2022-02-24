package org.madmeg.server.models;

public final class User {
    public String username;
    public String hashedPassword;
    public String token;

    public User(String username, String hashedPassword, String token){
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.token = token;
    }
}
