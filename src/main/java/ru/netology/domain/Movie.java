package ru.netology.domain;

public class Movie {
    private int id;
    private String imageUrlId;
    private String name;
    private String genre;
    private boolean premierTomorrow;


    public Movie() {
    }

    public Movie(int id, String imageUrlId, String name, String genre, boolean premierTomorrow) {
        this.id = id;
        this.imageUrlId = imageUrlId;
        this.name = name;
        this.genre = genre;
        this.premierTomorrow = premierTomorrow;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrlId() {
        return imageUrlId;
    }

    public void setImageUrlId(String imageUrlId) {
        this.imageUrlId = imageUrlId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isPremierTomorrow() {
        return premierTomorrow;
    }

    public void setPremierTomorrow(boolean premierTomorrow) {
        this.premierTomorrow = premierTomorrow;
    }

}
