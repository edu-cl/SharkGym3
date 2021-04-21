package com.example.sharkgym3.presenters;

import com.example.sharkgym3.Interfaces.AboutInterface;

public class AboutPresenter implements AboutInterface.Presenter {
    private AboutInterface.View view;

    public  AboutPresenter(AboutInterface.View view){
        this.view=view;
    }

    @Override
    public void onclickAbout() {
        view.closeAboutActivity();
    }
}
