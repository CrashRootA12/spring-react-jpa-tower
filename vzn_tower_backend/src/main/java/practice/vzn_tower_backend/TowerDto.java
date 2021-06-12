package practice.vzn_tower_backend;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TOWER")
public class TowerDto {
    public TowerDto() {
    }

    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Column(name = "DOCUMENTNAME")
    String documentType;
    @Column(name = "BTSTYPE")
    String btsType;
    @Column(name = "SITETYPE")
    String siteType;
    @Column(name = "TMTYPE")
    String tmType;

    @Override
    public String toString() {
        return "TowerDto [btsType=" + btsType + ", documentType=" + documentType + ", fileAddress=" + fileAddress
                + ", id=" + id + ", mwAzimuth=" + mwAzimuth + ", mwHeight=" + mwHeight + ", siteType=" + siteType
                + ", srType=" + srType + ", tmType=" + tmType + "]";
    }

    @Column(name = "MWAZIMUTH")
    double mwAzimuth;
    @Column(name = "MWHEIGHT")
    double mwHeight;

    public TowerDto(int id, String documentType, String btsType, String siteType, String tmType, double mwAzimuth,
            double mwHeight, String srType) {
        this.id = id;
        this.documentType = documentType;
        this.btsType = btsType;
        this.siteType = siteType;
        this.tmType = tmType;
        this.mwAzimuth = mwAzimuth;
        this.mwHeight = mwHeight;
        this.srType = srType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getBtsType() {
        return btsType;
    }

    public void setBtsType(String btsType) {
        this.btsType = btsType;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getTmType() {
        return tmType;
    }

    public void setTmType(String tmType) {
        this.tmType = tmType;
    }

    public double getMwAzimuth() {
        return mwAzimuth;
    }

    public void setMwAzimuth(double mwAzimuth) {
        this.mwAzimuth = mwAzimuth;
    }

    public double getMwHeight() {
        return mwHeight;
    }

    public void setMwHeight(double mwHeight) {
        this.mwHeight = mwHeight;
    }

    public String getSrType() {
        return srType;
    }

    public void setSrType(String srType) {
        this.srType = srType;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    @Column(name = "SRTYPE")
    String srType;
    @Column(name = "DOCUMENTADDRESS")
    String fileAddress;

}
