package cat.itacademy.barcelonactiva.tomasfranco.antonio.s05.t01.n01.model.dto;

import java.util.Arrays;
import java.util.List;

public class BranchDTO {

    private Integer pk_branchId;
    private String branchName;
    private String branchCountry;
    private String branchType;
    private List<String> ueCountries = Arrays.asList("Alemania", "Bélgica", "Croacia", "Dinamarca", "España", "Francia", "Irlanda", "Letonia", "Luxemburgo", "Países Bajos", "Suecia", "Bulgaria", "Eslovaquia", "Estonia", "Grecia", "Malta", "Polonia", "República Checa", "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungría", "Italia", "Lituania", "Portugal", "Rumanía");

    public BranchDTO() {

    }

    public BranchDTO(Integer pk_branchId, String branchName, String branchCountry) {
        this.pk_branchId = pk_branchId;
        this.branchName = branchName;
        this.branchCountry = branchCountry;
        checkForUeMembership(branchCountry);
    }

    public Integer getPk_branchId() {
        return pk_branchId;
    }

    public void setPk_branchId(Integer pk_branchId) {
        this.pk_branchId = pk_branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchCountry() {
        return branchCountry;
    }

    public void setBranchCountry(String branchCountry) {
        this.branchCountry = branchCountry;
        checkForUeMembership(branchCountry);
    }

    public String getBranchType() {
        return branchType;
    }

    public void setBranchType(String branchType) {
        this.branchType = branchType;
    }

    private void checkForUeMembership(String branchCountry) {
        if (this.ueCountries.contains(branchCountry)) {
            this.branchType = "UE";
        } else {
            this.branchType = "Fuera UE";
        }
    }

    @Override
    public String toString() {
        return "Sucursal: ID=" + pk_branchId + ", nombre='" + branchName + ", pais='" + branchCountry + ".";
    }
}
