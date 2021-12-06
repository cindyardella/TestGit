package com.example.testgit;

public class Model {

    Model(int mal_id,String title, String image_url){
        this.mal_id = mal_id;
        this.title = title;
        this.image_url = image_url;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image_url;
    }

    public void setImage(String image) {
        this.image_url = image;
    }

    public int getId() {
        return mal_id;
    }

    public void setId(int id) {
        this.mal_id = id;
    }

    private int mal_id;
    private String title;
    private String image_url;

}
