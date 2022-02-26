package org.madmeg.server;

import java.util.Objects;

/**
 * @author Madmegsox1
 * @since 09/02/2022
 */

public final class Client {
    public String uuid;
    public String username;
    public boolean loggedIn;
    public String token;


    public Client(String uuid, String username){
        this.uuid = uuid;
        this.username = username;
        this.loggedIn = false;
        this.token = "null";
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object client){
        if(client instanceof String username){
            return Objects.equals(username, this.username);
        }
        if(client instanceof Client c){
            return Objects.equals(c.uuid, this.uuid);
        }
        return false;
    }
}
