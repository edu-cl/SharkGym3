package com.example.sharkgym3.presenters;

import com.example.sharkgym3.Interfaces.SearchInterface;

public class Searchpresenter implements SearchInterface.Presenter {
       private SearchInterface.View view;

       public  Searchpresenter(SearchInterface.View view){
           this.view=view;
       }



    @Override
    public void onclickSearchPerson() {
           view.closeSearchActivity();
    }
}
