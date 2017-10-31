package com.mdoc.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mdoc.model.TableOfContents;

@Repository("documentRepository")
public interface DocumentRepository extends JpaRepository<TableOfContents, Serializable> {
    
    @Query(value = "select * from table_of_contents order by id", nativeQuery = true)
    public List<TableOfContents> getTableOfContents();

    @Query(value = "select file_name from table_of_contents where title=?", nativeQuery = true)
    public String getDocFileName(String title);

    // Gets all from TableOfContents order by id
    public List<TableOfContents> findAllByOrderById();


}
