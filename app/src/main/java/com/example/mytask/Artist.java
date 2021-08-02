package com.example.mytask;

public class Artist
{
    private  String name;
    private  String type;
    private  String award;


    public Artist(String name, String type, String award) {
        this.name = name;
        this.type = type;
        this.award = award;
    }

    public Artist()
    {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
