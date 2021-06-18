package com.apinanyogaratnam.restservice;

public class Secrets {
    private String username;
    private String password;
    private String url;

    public Secrets(String username, String password, String url) {
        this.setUsername(username);
        this.setPassword(password);
        this.setUrl(url);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
