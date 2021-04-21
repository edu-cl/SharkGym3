package com.example.sharkgym3.Models;

public class PersonEntity {

    int id;
    String name="";
    String surname="";
    String DNI="";
    String problem="";
    String fecha="";
    String image="";
    String category="";

    boolean diary;

    public PersonEntity(int id, String name, String surname, String DNI, String problem, String fecha, String image, String category, boolean diary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.DNI = DNI;
        this.problem = problem;
        this.fecha = fecha;
        this.image = image;
        this.category = category;
        this.diary = diary;
    }

    public PersonEntity() {
        this(0,"","","","","","","",false);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isDiary() {
        return diary;
    }

    public void setDiary(boolean diary) {
        this.diary = diary;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        boolean result=false;
        if (name.matches("\\D")) {
            this.name = name;
            result=true;
        }

        return result;
    }

    public String getSurname() {
        return surname;
    }

    public boolean setSurname(String surname) {
        boolean result=false;
        if (name.matches("\\D")) {
            this.surname = surname;
            result=true;
        }

        return result;
    }

    public String getDNI() {
        return DNI;
    }


    public boolean setDNI(String DNI) {
        boolean result=false;
        if (DNI.matches("[0-9]{7,8}[A-Za-z]")) {
            this.DNI = DNI;
            result=true;
        }
        return result;

    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getFecha() {
        return fecha;
    }

    public boolean setFecha(String fecha) {
        boolean result=false;
        if (fecha.matches("^(?:3[01]|[12][0-9]|0?[1-9])([\\-/.])(0?[1-9]|1[1-2])\\1\\d{4}$")) {
            this.fecha = fecha;
            result=true;

        }
        return result;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
