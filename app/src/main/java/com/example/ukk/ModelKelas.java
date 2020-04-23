package com.example.ukk;

public class ModelKelas {
    String kelas, idkelas;

    public ModelKelas(){

    }

    public ModelKelas(String kelas, String idkelas) {
        this.kelas = kelas;
        this.idkelas = idkelas;
    }

    public String getKelas() {
        return kelas;
    }

    public String setKelas(String kelas) {
        this.kelas = kelas;
        return kelas;
    }

    public String getIdkelas() {
        return idkelas;
    }

    public void setIdkelas(String idkelas) {
        this.idkelas = idkelas;
    }
}