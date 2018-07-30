package com.ogeniuspriority.boolax.boolax;

/**
 * Created by USER on 1/5/2018.
 */


public class boolax_boo_data_stream {
    private String names, thumbnailUrl,location;
    private int age;
    private String additional_datastream;

    public boolax_boo_data_stream() {

    }

    public boolax_boo_data_stream(String name, String thumbnailUrl, int age, String location,
                                  String additional_datastream) {
        this.names = name;
        this.thumbnailUrl = thumbnailUrl;
        this.age = age;
        this.location = location;
        this.additional_datastream = additional_datastream;
    }

    public String getTitle() {
        return names;
    }

    public void setTitle(String name) {
        this.names = name;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setlocation(String location) {
        this.location = location;
    }

    public String getAdditional_datastream() {
        return additional_datastream;
    }

    public void setAdditional_datastream(String additional_datastream) {
        this.additional_datastream = additional_datastream;
    }

}