package clase2.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regionid;
    @Column(nullable = false)
    private String regiondescription;

    public int getRegionid() {
        return regionid;
    }

    public void setRegionid(int regionid) {
        this.regionid = regionid;
    }

    public String getRegiondescription() {
        return regiondescription;
    }

    public void setRegiondescription(String regiondescription) {
        this.regiondescription = regiondescription;
    }
}
