/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ti.enterprise.project.KTP;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author weann
 */
@Entity
@Table(name = "data_ktp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DataKtp.findAll", query = "SELECT d FROM DataKtp d"),
    @NamedQuery(name = "DataKtp.findById", query = "SELECT d FROM DataKtp d WHERE d.id = :id"),
    @NamedQuery(name = "DataKtp.findByNoktp", query = "SELECT d FROM DataKtp d WHERE d.noktp = :noktp"),
    @NamedQuery(name = "DataKtp.findByNama", query = "SELECT d FROM DataKtp d WHERE d.nama = :nama"),
    @NamedQuery(name = "DataKtp.findByTgllahir", query = "SELECT d FROM DataKtp d WHERE d.tgllahir = :tgllahir"),
    @NamedQuery(name = "DataKtp.findByJeniskelamin", query = "SELECT d FROM DataKtp d WHERE d.jeniskelamin = :jeniskelamin"),
    @NamedQuery(name = "DataKtp.findByAlamat", query = "SELECT d FROM DataKtp d WHERE d.alamat = :alamat"),
    @NamedQuery(name = "DataKtp.findByAgama", query = "SELECT d FROM DataKtp d WHERE d.agama = :agama"),
    @NamedQuery(name = "DataKtp.findByStatus", query = "SELECT d FROM DataKtp d WHERE d.status = :status"),
    @NamedQuery(name = "DataKtp.findByPekerjaan", query = "SELECT d FROM DataKtp d WHERE d.pekerjaan = :pekerjaan"),
    @NamedQuery(name = "DataKtp.findByWarganegara", query = "SELECT d FROM DataKtp d WHERE d.warganegara = :warganegara"),
    @NamedQuery(name = "DataKtp.findByBerlakuhingga", query = "SELECT d FROM DataKtp d WHERE d.berlakuhingga = :berlakuhingga")})
public class DataKtp implements Serializable {

    @Lob
    @Column(name = "foto")
    private byte[] foto;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "noktp")
    private String noktp;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @Column(name = "tgllahir")
    @Temporal(TemporalType.DATE)
    private Date tgllahir;
    @Basic(optional = false)
    @Column(name = "jeniskelamin")
    private String jeniskelamin;
    @Basic(optional = false)
    @Column(name = "alamat")
    private String alamat;
    @Basic(optional = false)
    @Column(name = "agama")
    private String agama;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Column(name = "pekerjaan")
    private String pekerjaan;
    @Basic(optional = false)
    @Column(name = "warganegara")
    private String warganegara;
    @Column(name = "berlakuhingga")
    private String berlakuhingga;

    public DataKtp() {
    }

    public DataKtp(Long id) {
        this.id = id;
    }

    public DataKtp(Long id, String noktp, String nama, Date tgllahir, String jeniskelamin, String alamat, String agama, String status, String warganegara) {
        this.id = id;
        this.noktp = noktp;
        this.nama = nama;
        this.tgllahir = tgllahir;
        this.jeniskelamin = jeniskelamin;
        this.alamat = alamat;
        this.agama = agama;
        this.status = status;
        this.warganegara = warganegara;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoktp() {
        return noktp;
    }

    public void setNoktp(String noktp) {
        this.noktp = noktp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTgllahir() {
        return tgllahir;
    }

    public void setTgllahir(Date tgllahir) {
        this.tgllahir = tgllahir;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getWarganegara() {
        return warganegara;
    }

    public void setWarganegara(String warganegara) {
        this.warganegara = warganegara;
    }

    public String getBerlakuhingga() {
        return berlakuhingga;
    }

    public void setBerlakuhingga(String berlakuhingga) {
        this.berlakuhingga = berlakuhingga;
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
        if (!(object instanceof DataKtp)) {
            return false;
        }
        DataKtp other = (DataKtp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ti.enterprise.project.KTP.DataKtp[ id=" + id + " ]";
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
}
