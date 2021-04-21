package com.example.sharkgym3.presenters;

import com.example.sharkgym3.Interfaces.FormInterface;
import com.example.sharkgym3.R;
import com.example.sharkgym3.views.MyApplication;

public class FormPresenter implements FormInterface.Presenter {
    private FormInterface.View view;

    public FormPresenter(FormInterface.View view) {
        this.view = view;
    }


    public String getError(String error_code) {
        String error_msg = "";
        switch (error_code) {
            case "NameError":
                error_msg = MyApplication.getContext().getResources().getString(R.string.name_error);
                break;
            case "Valid":
                error_msg = "";
                break;
            case "SurnameError":
                error_msg = MyApplication.getContext().getResources().getString(R.string.surname_error);
                break;
            case "DNIError":
                error_msg = MyApplication.getContext().getResources().getString(R.string.DNI_error);
                break;

            case "DateError":
                error_msg = MyApplication.getContext().getResources().getString(R.string.date_error);
                break;
        }
        return error_msg;
    }

    @Override
    public void Start() {
        view.addPerson();
    }
}
