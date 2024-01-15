package com.joel.lenguaje.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="idiomas")
public class Idioma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2 , max = 20)
    private String name;
    
    @NotBlank
    @Size(min = 2 , max = 20)
    private String creator;

    @Min(1)
    @Max(10)
    @NotNull
    private double currentVersion;

    @NotNull
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    public Idioma(){}

    @PrePersist
    protected void onCreate(){
        this.createdAt=new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt=new Date();
    }

    //GET and SET: ID
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    //GET and SET: name
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    //GET and SET: creator
    public String getCreator(){
        return creator;
    }
    public void setCreator(String creator){
        this.creator=creator;
    }

    //GET and SET: currentVersion
    public double getCurrentVersion(){
        return currentVersion;
    }
    public void setCurrentVersion(double currentVersion){
        this.currentVersion=currentVersion;
    }

    //GET and SET: creacion de tabla
    public Date getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(Date createdAt){
        this.createdAt=createdAt;
    }

    //GET and SET: actualizacion de tabla
    public Date getUpdatedAt(){
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt){
        this.updatedAt=updatedAt;
    }

}
