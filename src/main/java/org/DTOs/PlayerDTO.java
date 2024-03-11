package org.DTOs;

public class PlayerDTO {
    private int id;
    private String name;
    private float rating;
    private int age;

    // Default Constructor
    public PlayerDTO() {
    }

    // Parameterized Constructor
    public PlayerDTO(int id, String name, float rating, int age) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.age = age;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // toString method for better representation
    @Override
    public String toString() {
        return "PlayerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", age=" + age +
                '}';
    }
}

