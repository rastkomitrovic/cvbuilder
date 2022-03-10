package com.fon.bg.ac.rs.cvbuilder.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class UserDTO {

    @NotNull(message = "Id korisnika ne sme biti null")
    private Long id;

    @NotNull(message = "Korisnicko ime korisnika ne sme biti prazno")
    @Size(min = 3,max = 255, message = "Korisnicko ime mora imati izmedju 3 i 255 karaktera")
    private String username;

    @NotNull(message = "Sifra korisnika ne sme biti prazna")
    @Size(min = 5, max = 255, message = "Sifra korisnika mora imati izmedju 3 i 255 karaktera")
    private String password;

    private String oldPassword;

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

    @NotNull(message = "Aktivan polje ne sme biti prazno")
    private boolean activated;

    @NotNull(message = "Rola korisnika ne sme biti prazna")
    private RoleDTO role;

    public UserDTO(){

    }

    public UserDTO(Long id, String username, String password, String oldPassword, String firstName, String lastName, String email, String indexNumber, boolean activated, RoleDTO role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.oldPassword = oldPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.indexNumber = indexNumber;
        this.activated = activated;
        this.role = role;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getOldPassword() {
        return oldPassword;
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

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO)) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id);
    }

}
