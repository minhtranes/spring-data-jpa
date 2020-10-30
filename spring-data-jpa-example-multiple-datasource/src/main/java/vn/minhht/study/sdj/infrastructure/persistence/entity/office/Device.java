/*
 * Class: Device
 *
 * Created on Apr 7, 2018
 *
 * (c) Copyright Swiss Post Solution, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package vn.minhht.study.sdj.infrastructure.persistence.entity.office;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Access(AccessType.PROPERTY)
public class Device implements Serializable {
    private static final long serialVersionUID = 6872608541333431124L;

    private Long id;

    private String name;

    private Long ownedBy;

    private Double price;

    private Integer purchaseYear;

    @Id
    @SequenceGenerator(name = "device_seq", initialValue = 1, allocationSize = 1, sequenceName = "device_id_seq")
    @GeneratedValue(generator = "device_seq", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Long getOwnedBy() {
        return this.ownedBy;
    }

    public Double getPrice() {
        return this.price;
    }

    public Integer getPurchaseYear() {
        return this.purchaseYear;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setOwnedBy(final Long ownedBy) {
        this.ownedBy = ownedBy;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public void setPurchaseYear(final Integer purchaseYear) {
        this.purchaseYear = purchaseYear;
    }

    @Override
    public String toString() {
        return "Device [id=" + this.id + ", name=" + this.name + ", purchaseYear="
                + this.purchaseYear + ", price=" + this.price + "]";
    }
}
