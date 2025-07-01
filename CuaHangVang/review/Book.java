package CuaHangVang.review;

public class Book {
String title;
String author;
int numPages;
Book() { } ; 
public Book(String t, String a, int p) {
title = t;
author = a;
numPages = p;
}

public void In(){
Book myObj = new Book("a","b",2);
System.out.println(myObj.title);    
}
}
