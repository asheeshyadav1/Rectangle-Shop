/*
 * AUTHOR: Asheesh Yadav
 * DESCRIPTION: This class is the model for the users making the rectangles
 * DATE: 6/09/2024
 *
 */
package rectangle.homework.rectangle.model;

import jakarta.persistence.*;

//Creates a table in psql database with the name users
// and following attributes down below

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid; // not used but can be used to get the user id for future implementations
    private String name; 
    private String color; 
    private float width;
    private float height;
    private String delete; //user will not enter anything here but it will be used to delete the rectangle
    public User() {

    }
    public User(String name, String color, float width, float height, String delete) {
        this.name = name;
        this.color = color;
        this.width = width;
        this.height = height;
        this.delete = delete; 
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public float getWidth() {
        return width;
    }
    public void setWidth(float width) {
        this.width = width;
    }
    public float getHeight() {
        return height;
    }
    public void setHeight(float height) {
        this.height = height;
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getDelete() {
        return delete;
    }
    public void setDelete(String delete) {
        this.delete = delete;
    }
    
}
