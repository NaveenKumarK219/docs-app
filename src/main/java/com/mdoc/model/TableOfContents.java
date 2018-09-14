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
    private String editedBy;

    @Column(name = "created_dtm")
    private Date createdDtm;

    @Column(name = "edited_dtm")
    private Date editedDtm;

    @Column(name="active")
    private Boolean active;

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

    public String getEditedBy() {
	return editedBy;
    }

    public void setEditedBy(String editedBy) {
	this.editedBy = editedBy;
    }

    public Date getCreatedDtm() {
	return createdDtm;
    }

    public void setCreatedDtm(Date createdDtm) {
	this.createdDtm = createdDtm;
    }

    public Date getEditedDtm() {
	return editedDtm;
    }

    public void setEditedDtm(Date editedDtm) {
	this.editedDtm = editedDtm;
    }

    public Boolean getActive() {
	return active;
    }

    public void setActive(Boolean active) {
	this.active = active;
    }
}
