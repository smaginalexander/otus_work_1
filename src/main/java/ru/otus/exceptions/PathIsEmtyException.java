package ru.otus.exceptions;

public class PathIsEmtyException extends Exception{
    public PathIsEmtyException(){
        super("Path is empty");
    }
}
