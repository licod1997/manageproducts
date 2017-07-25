/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.detail;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Notebook
 */
@Entity
@Table(name = "tbl_import", catalog = "Shop", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblImport.findAll", query = "SELECT t FROM TblImport t"),
    @NamedQuery(name = "TblImport.findById", query = "SELECT t FROM TblImport t WHERE t.id = :id"),
    @NamedQuery(name = "TblImport.findByImportedDate", query = "SELECT t FROM TblImport t WHERE t.importedDate = :importedDate"),
    @NamedQuery(name = "TblImport.findByPrice", query = "SELECT t FROM TblImport t WHERE t.price = :price"),
    @NamedQuery(name = "TblImport.findByQuantity", query = "SELECT t FROM TblImport t WHERE t.quantity = :quantity"),
    @NamedQuery(name = "TblImport.deleteByProductID", query = "DELETE FROM TblImport t WHERE t.productID = :productID"),
    @NamedQuery(name = "TblImport.findByProductID", query = "SELECT t FROM TblImport t WHERE t.productID = :productID")})
public class TblImport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "importedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date importedDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price", precision = 53)
    private Double price;
    @Column(name = "quantity")
    private Integer quantity;
    @Basic(optional = false)
    @Column(name = "productID", nullable = false, length = 10)
    private String productID;

    public TblImport() {
    }

//    public TblImport(Integer id) {
//        this.id = id;
//    }

    public TblImport(Integer id, Date importedDate, String productID) {
        this.id = id;
        this.importedDate = importedDate;
        this.productID = productID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getImportedDate() {
        return importedDate;
    }

    public void setImportedDate(Date importedDate) {
        this.importedDate = importedDate;
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

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblImport)) {
            return false;
        }
        TblImport other = (TblImport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sample.detail.TblImport[ id=" + id + " ]";
    }
    
}
