package com.example.sharkgym3.Interfaces;

public interface FormInterface {

    public interface View {
        void addPerson();

    }
    public interface Presenter{
        void Start();
        String getError(String error_code);
    }

}
