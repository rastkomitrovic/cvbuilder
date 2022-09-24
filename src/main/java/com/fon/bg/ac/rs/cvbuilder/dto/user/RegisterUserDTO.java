package com.fon.bg.ac.rs.cvbuilder.dto.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class RegisterUserDTO {

    @NotNull(message = "Korisnicko ime korisnika ne sme biti prazno")
    @Size(min = 3, max = 255, message = "Korisnicko ime mora imati izmedju 3 i 255 karaktera")
    private String username;

    @NotNull(message = "Sifra korisnika ne sme biti prazna")
    @Size(min = 5, max = 255, message = "Sifra korisnika mora imati izmedju 3 i 255 karaktera")
    private String password;

    @NotNull(message = "Ime korisnika ne sme biti prazno")
    @Size(message = "Ime korisnika mora imati izmedju 3 i 255 karaktera")
    private String firstName;

    @NotNull(message = "Prezime korisnika ne sme biti prazno")
    @Size(message = "Prezime korisnika mora imati izmedju 3 i 255 karaktera")
    private String lastName;

    @NotNull(message = "Email korisnika ne sme biti prazan")
    @Email(message = "Email korisnika mora biti u ispravnom formatu")
    private String email;

    @NotNull(message = "Broj indeksa korisnika ne sme biti prazan")
    private String indexNumber;

    public RegisterUserDTO() {

    }

    public RegisterUserDTO(String username, String password, String firstName, String lastName, String email, String indexNumber) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.indexNumber = indexNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        RegisterUserDTO that = (RegisterUserDTO) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(email, that.email) && Objects.equals(indexNumber, that.indexNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, firstName, lastName, email, indexNumber);
    }

    @Override
    public String toString() {
        return "RegisterUserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", indexNumber='" + indexNumber + '\'' +
                '}';
    }
}
