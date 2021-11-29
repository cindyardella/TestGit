package com.example.testgit;

public class Model {

    Model(int id,String nama, String gambar_url){
        this.id = id;
        this.nama = nama;
        this.gambar_url = gambar_url;
    }
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGambar() {
        return gambar_url;
    }

    public void setGambar(String gambar) {
        this.gambar_url = gambar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String nama;
    private String gambar_url;

}
