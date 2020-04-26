package clase2.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "shippers")
public class Shipper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shipperid;
    @Column(name="companyname",nullable = false)
    private String companyname;
    @Column(name="phone")
    private String phone;

    public int getShipperid() {
        return shipperid;
    }

    public void setShipperid(int shipperid) {
        this.shipperid = shipperid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
