package com.example.sharkgym3.Interfaces;

public interface MainInterface {

    public interface View {
        void startFormActivity();
        void startSeachActivity();
        void startAboutActivity();
        void startFormActivity(String DNI);


    }
    public interface Presenter{
        void OnClickAddPerson();
        void OnClickSearch();
        void OnClickAbout();
        void onClickRecyclerViewItem(String DNI);
    }
}
