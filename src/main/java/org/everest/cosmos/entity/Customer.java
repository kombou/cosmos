package org.everest.cosmos.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Temporal(value = TemporalType.DATE)
    private Calendar CustomerSince;
    @OneToMany(mappedBy = "id",cascade = CascadeType.REMOVE)
    private List<Order> orders;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getCustomerSince() {
        return CustomerSince;
    }

    public void setCustomerSince(Calendar customerSince) {
        CustomerSince = customerSince;
    }
}
