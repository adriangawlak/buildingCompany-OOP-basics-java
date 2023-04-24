package org.example;

public class NotUniqueNameException extends Exception{

    public NotUniqueNameException(){
        super("Ta nazwa już istnieje!\n");
    }
}
