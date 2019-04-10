package com.linderaredux.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.linderaredux.R;

import java.util.regex.Pattern;

public class Validation implements TextWatcher {
    private EditText mEdittextview;

    public enum ValidationType {
        CompanyName,
        Street,
        HouseNumber,
        PostalCode,
        City,
        Email,
        Phone,
        StreetSecond,
        HouseNumberSecond,
        PostalCodeSecond,
        CitySecond,
        Password,
    }

    private ValidationType valType;

    public Validation(EditText editText, ValidationType validationType) {

        this.mEdittextview = editText;
        this.valType = validationType;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (valType == ValidationType.CompanyName) {
            setTick(isValidName(mEdittextview.getText().toString().trim()));
        } else if (valType == ValidationType.Street || valType == ValidationType.StreetSecond) {
            setTick(isValidName(mEdittextview.getText().toString().trim()));
        } else if (valType == ValidationType.HouseNumber || valType == ValidationType.HouseNumberSecond) {
            setTick(isValidateZIP(mEdittextview.getText().toString().trim()));
        } else if (valType == ValidationType.PostalCode || valType == ValidationType.PostalCodeSecond) {
            setTick(isValidateZIP(mEdittextview.getText().toString().trim()));
        } else if (valType == ValidationType.City || valType == ValidationType.CitySecond) {
            setTick(isValidName(mEdittextview.getText().toString().trim()));
        } else if (valType == ValidationType.Email) {
            setTick(isValidEmail(mEdittextview.getText().toString().trim()));
        } else if (valType == ValidationType.Phone) {
            setTick(isValidNumber(mEdittextview.getText().toString().trim()));
        } else if (valType == ValidationType.Password) {
            setTick(isValidPassword(mEdittextview.getText().toString().trim()));
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
    }

    private void setTick(boolean isValid) {
        if (isValid) {
            mEdittextview.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check_ok, 0);
        } else {
            mEdittextview.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean isValidUserName(String str) {
        return Pattern.compile("^[a-zA-Z0-9_-]{3,32}$").matcher(str).matches();
    }

    private boolean isValidName(String str) {
        return Pattern.compile("^[a-zA-Z0-9 àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð'-]{2,32}$").matcher(str).matches();
    }

    private boolean isValidNumber(String str) {
        return Pattern.compile("^[0-9]{1,3}$").matcher(str).matches();
    }

    private boolean isValidateZIP(String str) {
        return Pattern.compile("^[0-9]{4,16}$").matcher(str).matches();
    }

    private boolean isValidEmail(String str) {
        return Pattern.compile("^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?$").matcher(str).matches();
    }

    private boolean isValidPassword(String str) {
        return str.length() > 7;
    }

    private boolean isNumberInput(String str) {
        return Pattern.compile("^[0-9]*$").matcher(str).matches();
    }

    private boolean isLetterInput(String str) {
        return Pattern.compile("^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð,.'-]*$").matcher(str).matches();
    }
}
