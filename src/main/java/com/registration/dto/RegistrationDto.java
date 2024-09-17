package com.registration.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.BatchSize;

import java.util.Date;

public class RegistrationDto {
    private Long id;

    @NotNull
    @Size(min = 2, message = "Should be at least 2 characters")
    private String name;

    @Email
    private String email;

    @Size(min = 10, max = 10, message = "Should be at least 10 digits")
    private String mobile;

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
