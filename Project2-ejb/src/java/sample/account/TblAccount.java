/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.account;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tbl_account", catalog = "Shop", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAccount.findAll", query = "SELECT t FROM TblAccount t"),
    @NamedQuery(name = "TblAccount.findByAccount", query = "SELECT t FROM TblAccount t WHERE t.accountID = :accountID AND t.password = :password"),
    @NamedQuery(name = "TblAccount.findByAccountID", query = "SELECT t FROM TblAccount t WHERE t.accountID = :accountID"),
    @NamedQuery(name = "TblAccount.findByEmployeeName", query = "SELECT t FROM TblAccount t WHERE t.employeeName = :employeeName"),
    @NamedQuery(name = "TblAccount.findByPassword", query = "SELECT t FROM TblAccount t WHERE t.password = :password"),
    @NamedQuery(name = "TblAccount.findByExpired", query = "SELECT t FROM TblAccount t WHERE t.expired = :expired")})
public class TblAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "accountID", nullable = false, length = 10)
    private String accountID;
    @Basic(optional = false)
    @Column(name = "employeeName", nullable = false, length = 50)
    private String employeeName;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 20)
    private String password;
    @Basic(optional = false)
    @Column(name = "expired", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date expired;

    public TblAccount() {
    }

    public TblAccount(String accountID) {
        this.accountID = accountID;
    }

    public TblAccount(String accountID, String employeeName, String password, Date expired) {
        this.accountID = accountID;
        this.employeeName = employeeName;
        this.password = password;
        this.expired = expired;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountID != null ? accountID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAccount)) {
            return false;
        }
        TblAccount other = (TblAccount) object;
        if ((this.accountID == null && other.accountID != null) || (this.accountID != null && !this.accountID.equals(other.accountID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sample.account.TblAccount[ accountID=" + accountID + " ]";
    }
    
}
