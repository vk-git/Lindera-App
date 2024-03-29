package com.linderaredux.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

import com.linderaredux.R

import java.util.regex.Pattern

class Validation(private val mEdittextview: EditText, private val valType: ValidationType) : TextWatcher {

    enum class ValidationType {
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
        Password
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        if (valType == ValidationType.CompanyName) {
            setTick(isValidName(mEdittextview.text.toString().trim { it <= ' ' }))
        } else if (valType == ValidationType.Street || valType == ValidationType.StreetSecond) {
            setTick(isValidName(mEdittextview.text.toString().trim { it <= ' ' }))
        } else if (valType == ValidationType.HouseNumber || valType == ValidationType.HouseNumberSecond) {
            setTick(isValidateZIP(mEdittextview.text.toString().trim { it <= ' ' }))
        } else if (valType == ValidationType.PostalCode || valType == ValidationType.PostalCodeSecond) {
            setTick(isValidateZIP(mEdittextview.text.toString().trim { it <= ' ' }))
        } else if (valType == ValidationType.City || valType == ValidationType.CitySecond) {
            setTick(isValidName(mEdittextview.text.toString().trim { it <= ' ' }))
        } else if (valType == ValidationType.Email) {
            setTick(isValidEmail(mEdittextview.text.toString().trim { it <= ' ' }))
        } else if (valType == ValidationType.Phone) {
            setTick(isValidNumber(mEdittextview.text.toString().trim { it <= ' ' }))
        } else if (valType == ValidationType.Password) {
            setTick(isValidPassword(mEdittextview.text.toString().trim { it <= ' ' }))
        }
    }

    override fun afterTextChanged(s: Editable) {}

    private fun setTick(isValid: Boolean) {
        if (isValid) {
            mEdittextview.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check_ok, 0)
        } else {
            mEdittextview.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
        }
    }


    companion object {
        fun removeBadSpaces(str: String): String {
            return str.replace(" ", "")
        }

        fun isValidUserName(str: String): Boolean {
            return Pattern.compile("^[a-zA-Z0-9_-]{3,32}$").matcher(str).matches()
        }

        fun isValidName(str: String): Boolean {
            return Pattern.compile("^[a-zA-Z0-9 àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð'-]{2,32}$").matcher(str).matches()
        }

        fun isValidNumber(str: String): Boolean {
            return Pattern.compile("^[0-9]{1,3}$").matcher(str).matches()
        }

        fun isValidateZIP(str: String): Boolean {
            return Pattern.compile("^[0-9]{4,16}$").matcher(str).matches()
        }

        fun isValidEmail(str: String): Boolean {
            return Pattern.compile("^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?$").matcher(str).matches()
        }

        fun isValidPassword(str: String): Boolean {
            return str.length > 7
        }

        fun isNumberInput(str: String): Boolean {
            return Pattern.compile("^[0-9]*$").matcher(str).matches()
        }

        fun isLetterInput(str: String): Boolean {
            return Pattern.compile("^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð,.'-]*$").matcher(str).matches()
        }

        fun isMatchPassword(one: String,two: String): Boolean {
            return two == one
        }
    }
}
