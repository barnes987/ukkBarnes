package com.example.ukk;

public class ModelUser {
    String id_petugas;
    String nama_petugas;
    String username;
    String password;
    String level;
    int  id_level;

    public ModelUser () {

    }

    public ModelUser(String id_petugas, int id_level, String nama_petugas, String username, String password,String level) {
        this.id_petugas = id_petugas;
        this.id_level = id_level;
        this.nama_petugas = nama_petugas;
        this.username = username;
        this.password = password;
        this.level = level;
    }

    public String getId_petugas() {
        return id_petugas;
    }

    public void setId_petugas(String id_petugas) {
        this.id_petugas = id_petugas;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getId_level() {
        return id_level;
    }

    public void setId_level(int id_level) {
        this.id_level = id_level;
    }

    public String getNama_petugas() {
        return nama_petugas;
    }

    public void setNama_petugas(String nama_petugas) {
        this.nama_petugas = nama_petugas;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}