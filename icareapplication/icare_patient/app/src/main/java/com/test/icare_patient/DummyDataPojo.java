package com.test.icare_patient;


public class DummyDataPojo {

    String id;
    String name;
    String image;

    public DummyDataPojo(String id, String name, String image){
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public DummyDataPojo(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
