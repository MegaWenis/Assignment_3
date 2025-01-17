package org.uob.a3.gameobjects;

/**
 * Represents a generic game object that can be part of the game world.
 * Game objects have a unique identifier (id), a user-friendly name (name), and a description.
 * These attributes define the basic properties of any game object.
 */
public abstract class GameObject {

    protected final String id;
    protected String name;
    protected String description;

    //constructor for case where fields not defined
    public GameObject() {
        this.id = "";
        this.name = "";
        this.description = "";
    }

    //constructor for object with specified fields
    public GameObject(String id, String name, String description) {
        //this applies to all gameObjects
        this.id = id;
        this.name = name;
        this.description = description;
    }

    //getters and setters
    public String getId() {return id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    //String describing the gameobject
    @Override
    public String toString() {
        return "GameObject {" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
