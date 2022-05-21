package com.preschool.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A Person.
 */
@Entity
@Table(name = "person")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Person extends   AbstractBaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 2)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Size(min = 2)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birthday")
    private Instant birthday;

    @NotNull
    @Column(name = "identification_number", nullable = false)
    private String identificationNumber;

    @Size(min = 2)
    @Column(name = "address")
    private String address;

    @NotNull
    @Pattern(regexp = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "picture")
    private String picture;

    @NotNull
    @Size(min = 10)
    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Size(min = 10)
    @Column(name = "cellphone")
    private String cellphone;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToOne
    @JoinColumn(unique = true)
    private User user;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Gender gender;

//    @ManyToMany
//    @JoinTable(
//        name = "parent_student",
//        joinColumns = @JoinColumn(name = "person_id"),
//        inverseJoinColumns = @JoinColumn(name = "student_id")
//    )
//    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
//    @JsonIgnoreProperties(value = { "gender", "level", "people" }, allowSetters = true)
//    private Set<Student> students = new HashSet<>();
//
//    @ManyToMany(mappedBy = "persons")
//    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
//    @JsonIgnoreProperties(value = { "user", "persons" }, allowSetters = true)
//    private Set<Notice> notices = new HashSet<>();

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return this.id;
    }

    public Person id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Person firstName(String firstName) {
        this.setFirstName(firstName);
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Person lastName(String lastName) {
        this.setLastName(lastName);
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Instant getBirthday() {
        return this.birthday;
    }

    public Person birthday(Instant birthday) {
        this.setBirthday(birthday);
        return this;
    }

    public void setBirthday(Instant birthday) {
        this.birthday = birthday;
    }

    public String getIdentificationNumber() {
        return this.identificationNumber;
    }

    public Person identificationNumber(String identificationNumber) {
        this.setIdentificationNumber(identificationNumber);
        return this;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public Person address(String address) {
        this.setAddress(address);
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public Person email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return this.picture;
    }

    public Person picture(String picture) {
        this.setPicture(picture);
        return this;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public Person telephone(String telephone) {
        this.setTelephone(telephone);
        return this;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCellphone() {
        return this.cellphone;
    }

    public Person cellphone(String cellphone) {
        this.setCellphone(cellphone);
        return this;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Person user(User user) {
        this.setUser(user);
        return this;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Person gender(Gender gender) {
        this.setGender(gender);
        return this;
    }
//
//    public Set<Student> getStudents() {
//        return this.students;
//    }
//
//    public void setStudents(Set<Student> students) {
//        this.students = students;
//    }
//
//    public Person students(Set<Student> students) {
//        this.setStudents(students);
//        return this;
//    }
//
//    public Person addStudent(Student student) {
//        this.students.add(student);
//        student.getPeople().add(this);
//        return this;
//    }
//
//    public Person removeStudent(Student student) {
//        this.students.remove(student);
//        student.getPeople().remove(this);
//        return this;
//    }
//
//
//    public Set<Notice> getNotices() {
//        return this.notices;
//    }
//
//    public void setNotices(Set<Notice> notices) {
//        if (this.notices != null) {
//            this.notices.forEach(i -> i.removePersons(this));
//        }
//        if (notices != null) {
//            notices.forEach(i -> i.addPersons(this));
//        }
//        this.notices = notices;
//    }
//
//    public Person notices(Set<Notice> notices) {
//        this.setNotices(notices);
//        return this;
//    }
//
//
//    public Person addNotice(Notice notice) {
//        this.notices.add(notice);
//        notice.getPersons().add(this);
//        return this;
//    }
//
//    public Person removeNotice(Notice notice) {
//        this.notices.remove(notice);
//        notice.getPersons().remove(this);
//        return this;
//    }


    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        return id != null && id.equals(((Person) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Person{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", birthday='" + getBirthday() + "'" +
            ", identificationNumber='" + getIdentificationNumber() + "'" +
            ", address='" + getAddress() + "'" +
            ", email='" + getEmail() + "'" +
            ", picture='" + getPicture() + "'" +
            ", telephone='" + getTelephone() + "'" +
            ", cellphone='" + getCellphone() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", createdDate='" + getCreatedDate() + "'" +
            ", updatedBy=" + getUpdatedBy() +
            ", updatedDate='" + getUpdatedDate() + "'" +
            ", isActive='" + getActive() + "'" +
            "}";
    }
}
