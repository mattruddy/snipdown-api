package com.snip.down.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "snip", indexes = @Index(columnList = "title,body", name = "Index_snip"))
public class Snip {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String title;

    @Column
    private String body;

    @Column
    private Timestamp createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
