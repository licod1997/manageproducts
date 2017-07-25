/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.product;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Notebook
 */
@Entity
@Table(name = "tbl_product", catalog = "Shop", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProduct.findAll", query = "SELECT t FROM TblProduct t"),
    @NamedQuery(name = "TblProduct.findByProductID", query = "SELECT t FROM TblProduct t WHERE t.productID = :productID"),
    @NamedQuery(name = "TblProduct.findByProductName", query = "SELECT t FROM TblProduct t WHERE t.productName = :productName"),
    @NamedQuery(name = "TblProduct.findByPrice", query = "SELECT t FROM TblProduct t WHERE t.price = :price"),
    @NamedQuery(name = "TblProduct.findByQuantity", query = "SELECT t FROM TblProduct t WHERE t.quantity = :quantity"),
    @NamedQuery(name = "TblProduct.findByUnit", query = "SELECT t FROM TblProduct t WHERE t.unit = :unit")})
public class TblProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "productID", nullable = false, length = 10)
    private String productID;
    @Basic(optional = false)
    @Column(name = "productName", nullable = false, length = 50)
    private String productName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price", precision = 53)
    private Double price;
    @Column(name = "quantity")
    private Integer quantity;
    @Basic(optional = false)
    @Column(name = "unit", nullable = false, length = 20)
    private String unit;

    public TblProduct() {
    }

    public TblProduct(String productID) {
        this.productID = productID;
    }

    public TblProduct(String productID, String productName, String unit) {
        this.productID = productID;
        this.productName = productName;
        this.unit = unit;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProduct)) {
            return false;
        }
        TblProduct other = (TblProduct) object;
        if ((this.productID == null && other.productID != null) || (this.productID != null && !this.productID.equals(other.productID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sample.product.TblProduct[ productID=" + productID + " ]";
    }
    
}
