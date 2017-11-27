package com.mdoc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "table_of_contents")
public class TableOfContents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "author")
    private String author;

    @Column(name = "edited_by")
    private String edited_by;

    @Column(name = "created_dtm")
    private Date created_dtm;

    @Column(name = "edited_dtm")
    private Date edited_dtm;

    public void setId(int id) {
	this.id = id;
    }

    public int getId() {
	return id;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getTitle() {
	return title;
    }

    public void setFileName(String fileName) {
	this.fileName = fileName;
    }

    public String getFileName() {
	return fileName;
    }

    public String getAuthor() {
	return author;
    }

    public void setAuthor(String author) {
	this.author = author;
    }

    public String getEdited_by() {
	return edited_by;
    }

    public void setEdited_by(String edited_by) {
	this.edited_by = edited_by;
    }

    public Date getCreated_dtm() {
	return created_dtm;
    }

    public void setCreated_dtm(Date created_dtm) {
	this.created_dtm = created_dtm;
    }

    public Date getEdited_dtm() {
	return edited_dtm;
    }

    public void setEdited_dtm(Date edited_dtm) {
	this.edited_dtm = edited_dtm;
    }
}
