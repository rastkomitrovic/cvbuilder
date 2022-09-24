package com.fon.bg.ac.rs.cvbuilder.dto.user;


import com.fon.bg.ac.rs.cvbuilder.dto.RoleDTO;

import java.util.Objects;

public class FindUserDTO {

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private String indexNumber;

    private boolean activated;

    private RoleDTO role;

    public FindUserDTO() {

    }

    public FindUserDTO(Long id, String username, String firstName, String lastName, String indexNumber, boolean activated, RoleDTO role) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
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
        if (o == null || getClass() != o.getClass()) return false;
        FindUserDTO that = (FindUserDTO) o;
        return activated == that.activated && Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(indexNumber, that.indexNumber) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, firstName, lastName, indexNumber, activated, role);
    }

    @Override
    public String toString() {
        return "FindUserByIdDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", indexNumber='" + indexNumber + '\'' +
                ", activated=" + activated +
                ", role=" + role +
                '}';
    }
}
