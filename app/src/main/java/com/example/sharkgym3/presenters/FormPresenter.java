package com.example.sharkgym3.presenters;

import com.example.sharkgym3.Interfaces.FormInterface;

public class FormPresenter implements FormInterface.Presenter {
    private FormInterface.View view;

    public FormPresenter(FormInterface.View view) {
        this.view = view;
    }

    @Override
    public void Start() {
        view.addPerson();
    }
}
