package com.asierg.spring.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Book")
public class Book {

    private Long id;

    @Column(name = "title", length = 40, nullable = false)
    @NotEmpty
    @Length(min = 5, max = 40)
    private String title;

    @Column(name = "description", length = 500, nullable = false)
    @Length(min = 10, max = 500)
    private String description;

    @Column(name = "date", nullable = false)
    @NotNull
    private Date date;

    @Column(name = "writer", length = 50)
    @Length(min = 5, max = 50)
    private String writer;

    @Column(name = "price")
    @NotNull
    private Double price;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", description=" + description + ", date=" + date + ", writer="
                + writer + ", price=" + price + "]";
    }

}
