package cat.itacademy.barcelonactiva.tomasfranco.antonio.s05.t01.n01.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "branches")
public class Branch {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pk_branchId;
    @Column(name = "branch_name")
    private String branchName;
    @Column(name = "branch_country")
    private String branchCountry;

    public Branch() {

    }

    public Branch(String branchName, String branchCountry) {
        this.branchName = branchName;
        this.branchCountry = branchCountry;
    }

    public Branch(Integer pkBranchId, String branchName, String branchCountry) {
        this.pk_branchId = pkBranchId;
        this.branchName = branchName;
        this.branchCountry = branchCountry;
    }


    public Integer getId() {
        return pk_branchId;
    }

    public void setId(Integer pk_branchId) {
        this.pk_branchId = pk_branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getCountry() {
        return branchCountry;
    }

    public void setCountry(String branchCountry) {
        this.branchCountry = branchCountry;
    }

    @Override
    public String toString() {
        return "Sucursal: ID=" + pk_branchId + ", nombre='" + branchName + ", pais='" + branchCountry + ".";
    }
}
