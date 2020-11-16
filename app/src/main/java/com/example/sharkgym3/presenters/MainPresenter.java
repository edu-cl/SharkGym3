package com.example.sharkgym3.presenters;

import com.example.sharkgym3.Interfaces.MainInterface;

public class MainPresenter implements MainInterface.Presenter {
    private MainInterface.View view;

    public MainPresenter(MainInterface.View view) {
        this.view = view;
    }

    @Override
    public void OnClickAddPerson() {
        view.startFormActivity();
    }


}
