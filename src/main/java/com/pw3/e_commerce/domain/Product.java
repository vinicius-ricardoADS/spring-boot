package com.pw3.e_commerce.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "products")
public class Product extends AbstractEntity<Long> {

    @Column(name = "name", nullable = false, unique = false, length = 60)
    private String name;

    @Column(name = "barCode", nullable = false, unique = true)
    private String barCode;

    @Column(name = "typeOfProduct")
    private String type;

    @DateTimeFormat(iso = ISO.DATE)
    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate manufactoringDate;

    @DateTimeFormat(iso = ISO.DATE)
    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate expirationDate;

    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    @Column(nullable = false, columnDefinition = "DECIMAL(3,2) DEFAULT 0.00")
    private BigDecimal unitPrice;

    public Product() {
    }

    public Product(String name, String barCode, String type, LocalDate manufactoringDate, LocalDate expirationDate,
            BigDecimal unitPrice) {
        this.name = name;
        this.barCode = barCode;
        this.type = type;
        this.manufactoringDate = manufactoringDate;
        this.expirationDate = expirationDate;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getManufactoringDate() {
        return manufactoringDate;
    }

    public void setManufactoringDate(LocalDate manufactoringDate) {
        this.manufactoringDate = manufactoringDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((barCode == null) ? 0 : barCode.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((manufactoringDate == null) ? 0 : manufactoringDate.hashCode());
        result = prime * result + ((expirationDate == null) ? 0 : expirationDate.hashCode());
        result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (barCode == null) {
            if (other.barCode != null)
                return false;
        } else if (!barCode.equals(other.barCode))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (manufactoringDate == null) {
            if (other.manufactoringDate != null)
                return false;
        } else if (!manufactoringDate.equals(other.manufactoringDate))
            return false;
        if (expirationDate == null) {
            if (other.expirationDate != null)
                return false;
        } else if (!expirationDate.equals(other.expirationDate))
            return false;
        if (unitPrice == null) {
            if (other.unitPrice != null)
                return false;
        } else if (!unitPrice.equals(other.unitPrice))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", barCode=" + barCode + ", type=" + type + ", manufactoringDate="
                + manufactoringDate + ", expirationDate=" + expirationDate + ", unitPrice=" + unitPrice + "]";
    }

}
