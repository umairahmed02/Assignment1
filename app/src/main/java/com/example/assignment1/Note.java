package com.example.assignment1;
import java.time.LocalDate;

public class Note {

    String body;
    String author;
    String subject;
    String title;
    LocalDate dateCreated;

    public Note(String b, String a, String s, String t, LocalDate d) {
        this.setBody(b);
        this.setAuthor(a);
        this.setSubject(s);
        this.setTitle(t);
        this.setDateCreated(d);
    }

    public Note(String b, String t) {
        this.setBody(b);
        this.setAuthor("Sue Donym");
        this.setSubject("Subject1");
        this.setTitle(t);
        this.setDateCreated(LocalDate.now());
    }

    public Note() {
        this.setBody("My Note");
        this.setAuthor("Sue Donym");
        this.setSubject("Subject1");
        this.setTitle("New Note");
        this.setDateCreated(LocalDate.now());
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) {this.title = title; }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
