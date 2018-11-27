package org.everest.cosmos.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String text;
    @Temporal(value = TemporalType.DATE)
    private Calendar dateComment;
    @ManyToOne
    private Product product;


    public Calendar getDateComment() {
        return dateComment;
    }

    public void setDateComment(Calendar dateComment) {
        this.dateComment = dateComment;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Comment() {
    }
}
