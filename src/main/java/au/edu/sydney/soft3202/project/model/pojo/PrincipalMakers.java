package au.edu.sydney.soft3202.project.model.pojo;

import java.util.List;

public class PrincipalMakers {

    private String name;
    private String unFixedName;
    private String placeOfBirth;
    private String dateOfBirth;
    private boolean dateOfBirthPrecision;
    private String dateOfDeath;
    private boolean dateOfDeathPrecision;
    private String placeOfDeath;
    private List<String> occupation;
    private List<String> roles;
    private String nationality;
    private boolean biography;
    private List<String> productionPlaces;
    private boolean qualification;

    public void setProductionPlaces(List<String> productionPlaces) {
        this.productionPlaces = productionPlaces;
    }

    public List<String> getProductionPlaces() {
        return productionPlaces;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBiography() {
        return biography;
    }

    public boolean isDateOfBirthPrecision() {
        return dateOfBirthPrecision;
    }

    public boolean isDateOfDeathPrecision() {
        return dateOfDeathPrecision;
    }

    public boolean isQualification() {
        return qualification;
    }

    public List<String> getOccupation() {
        return occupation;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getPlaceOfDeath() {
        return placeOfDeath;
    }

    public String getUnFixedName() {
        return unFixedName;
    }

    public void setBiography(boolean biography) {
        this.biography = biography;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfBirthPrecision(boolean dateOfBirthPrecision) {
        this.dateOfBirthPrecision = dateOfBirthPrecision;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void setDateOfDeathPrecision(boolean dateOfDeathPrecision) {
        this.dateOfDeathPrecision = dateOfDeathPrecision;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setOccupation(List<String> occupation) {
        this.occupation = occupation;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public void setPlaceOfDeath(String placeOfDeath) {
        this.placeOfDeath = placeOfDeath;
    }

    public void setQualification(boolean qualification) {
        this.qualification = qualification;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void setUnFixedName(String unFixedName) {
        this.unFixedName = unFixedName;
    }

    @Override
    public String toString() {
        return "PrincipalMakers{" +
                "name='" + name + '\'' +
                ", unFixedName='" + unFixedName + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", dateOfBirthPrecision=" + dateOfBirthPrecision +
                ", dateOfDeath='" + dateOfDeath + '\'' +
                ", dateOfDeathPrecision=" + dateOfDeathPrecision +
                ", placeOfDeath='" + placeOfDeath + '\'' +
                ", occupation=" + occupation +
                ", roles=" + roles +
                ", nationality='" + nationality + '\'' +
                ", biography=" + biography +
                ", productionPlaces=" + productionPlaces +
                ", qualification=" + qualification +
                '}';
    }
}
