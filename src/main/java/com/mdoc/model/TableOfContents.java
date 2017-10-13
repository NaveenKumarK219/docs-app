package com.mdoc.model;

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
}
