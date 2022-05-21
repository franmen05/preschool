package com.preschool.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * A Company.
 */
@Entity
@Table(name = "company")
public class Company extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 5)
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Size(min = 2)
    @Column(name = "address", nullable = false)
    private String address;

    @NotNull
    @Size(min = 9)
    @Column(name = "r_nc", nullable = false)
    private String rNC;

    @NotNull
    @Pattern(regexp = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")
    @Column(name = "email", nullable = false)
    @Email
    private String email;

    @NotNull
    @Size(min = 10)
    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Size(min = 10)
    @Column(name = "cell_phone")
    private String cellPhone;

    @Column(name = "logo")
    private String logo;

    @Column(name = "motto")
    private String motto;

    @Column(name = "primary_color")
    private String primaryColor;

    @Column(name = "secundary_color")
    private String secundaryColor;

    @Column(name = "mission")
    private String mission;

    @Column(name = "vision")
    private String vision;

    @Column(name = "jhi_values")
    private String values;

    @Column(name = "is_delete")
    private Boolean isDelete = false;

    @Column(name = "is_active")
    private Boolean isActive = true;

    // jhipster-needle-entity-add-field - JHipster will add fields here


    public Company(Long id) {
        this.id = id;
    }

    public Company() {
    }

    public Long getId() {
        return this.id;
    }

    public Company id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Company name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public Company address(String address) {
        this.setAddress(address);
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getrNC() {
        return this.rNC;
    }

    public Company rNC(String rNC) {
        this.setrNC(rNC);
        return this;
    }

    public void setrNC(String rNC) {
        this.rNC = rNC;
    }

    public String getEmail() {
        return this.email;
    }

    public Company email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public Company telephone(String telephone) {
        this.setTelephone(telephone);
        return this;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCellPhone() {
        return this.cellPhone;
    }

    public Company cellPhone(String cellPhone) {
        this.setCellPhone(cellPhone);
        return this;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getLogo() {
        return this.logo;
    }

    public Company logo(String logo) {
        this.setLogo(logo);
        return this;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getMotto() {
        return this.motto;
    }

    public Company motto(String motto) {
        this.setMotto(motto);
        return this;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getPrimaryColor() {
        return this.primaryColor;
    }

    public Company primaryColor(String primaryColor) {
        this.setPrimaryColor(primaryColor);
        return this;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public String getSecundaryColor() {
        return this.secundaryColor;
    }

    public Company secundaryColor(String secundaryColor) {
        this.setSecundaryColor(secundaryColor);
        return this;
    }

    public void setSecundaryColor(String secundaryColor) {
        this.secundaryColor = secundaryColor;
    }

    public String getMission() {
        return this.mission;
    }

    public Company mission(String mission) {
        this.setMission(mission);
        return this;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getVision() {
        return this.vision;
    }

    public Company vision(String vision) {
        this.setVision(vision);
        return this;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getValues() {
        return this.values;
    }

    public Company values(String values) {
        this.setValues(values);
        return this;
    }

    public void setValues(String values) {
        this.values = values;
    }


    public Boolean getIsDelete() {
        return this.isDelete;
    }

    public Company isDelete(Boolean isDelete) {
        this.setIsDelete(isDelete);
        return this;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public Company isActive(Boolean isActive) {
        this.setIsActive(isActive);
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Company)) {
            return false;
        }
        return id != null && id.equals(((Company) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Company{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", address='" + getAddress() + "'" +
            ", rNC='" + getrNC() + "'" +
            ", email='" + getEmail() + "'" +
            ", telephone='" + getTelephone() + "'" +
            ", cellPhone='" + getCellPhone() + "'" +
            ", logo='" + getLogo() + "'" +
            ", motto='" + getMotto() + "'" +
            ", primaryColor='" + getPrimaryColor() + "'" +
            ", secundaryColor='" + getSecundaryColor() + "'" +
            ", mission='" + getMission() + "'" +
            ", vision='" + getVision() + "'" +
            ", values='" + getValues() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", createdDate='" + getCreatedDate() + "'" +
            ", updatedBy=" + getUpdatedBy() +
            ", updatedDate='" + getUpdatedDate() + "'" +
            ", isDelete='" + getIsDelete() + "'" +
            ", isActive='" + getIsActive() + "'" +
            "}";
    }
}
