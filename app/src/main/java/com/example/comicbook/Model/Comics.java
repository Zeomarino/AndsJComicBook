package com.example.comicbook.Model;

import java.io.Serializable;

public class Comics implements Serializable {
    private String name;
    private String bio;
    private int pictureInteger;

            //Constructor Create "ComicBookModeliNot.java"
    public Comics(String name, String bio, int pictureInteger) {
        this.name = name;
        this.bio = bio;
        this.pictureInteger = pictureInteger;
    }
            //Getter Açıklaması - "ListedeGösterimNot.java - Kod Zamanı 1 - 4'de"
    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public int getPictureInteger() {
        return pictureInteger;
    }
    //Getter fnish.

}
