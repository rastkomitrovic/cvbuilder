package com.fon.bg.ac.rs.cvbuilder.dto.user;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class UpdateUserDTO {

    @NotNull(message = "Id korisnika ne sme biti null")
    @Min(value = 0, message = "Id korisnika mora biti 0 ili vece")
    private Long id;

    private String username;

    @NotNull(message = "Sifra korisnika ne sme biti prazna")
    @Size(min = 5, max = 255, message = "Sifra korisnika mora imati izmedju 3 i 255 karaktera")
    private String oldPassword;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String indexNumber;

    public UpdateUserDTO() {

    }

    public UpdateUserDTO(Long id, String username, String oldPassword, String password, String firstName, String lastName, String email, String indexNumber) {
        this.id = id;
        this.username = username;
        this.oldPassword = oldPassword;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.indexNumber = indexNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateUserDTO that = (UpdateUserDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(oldPassword, that.oldPassword) && Objects.equals(password, that.password) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(email, that.email) && Objects.equals(indexNumber, that.indexNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, oldPassword, password, firstName, lastName, email, indexNumber);
    }

    @Override
    public String toString() {
        return "UpdateUserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", oldPassword='" + oldPassword + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", indexNumber='" + indexNumber + '\'' +
                '}';
    }
}

