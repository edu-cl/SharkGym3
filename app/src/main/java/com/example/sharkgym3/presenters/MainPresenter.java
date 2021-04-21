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

    @Override
    public void OnClickSearch() {
        view.startSeachActivity();
    }

    @Override
    public void OnClickAbout() {
        view.startAboutActivity();
    }

    @Override
    public void onClickRecyclerViewItem(String DNI) {

        view.startFormActivity(DNI);
    }

    public void onSwipeRecyclerViewItem(String id){
        //Decirle al modelo que borre id
        //En la unidad 5

        //Decirle al RV que lo elimino
       // view.removeRecyclerViewItem(id);
        //Decirle al view que muestre toast
       // view.showToast("error");
    }


}
