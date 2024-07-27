package com.example.catchthewords

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class RateFragment: DialogFragment(R.layout.rate_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val cancelBtn : Button = view.findViewById(R.id.cancelBtn);
        val submitBtn : Button = view.findViewById(R.id.submitBtn);
        val radioGroup = view.findViewById<RadioGroup>(R.id.ratingRadioGroup)
        cancelBtn.setOnClickListener{
            dismiss()
        }
        submitBtn.setOnClickListener {
            val selectedOption: Int = radioGroup.checkedRadioButtonId
            val m1: MainActivity = getActivity() as MainActivity;

            if (radioGroup.checkedRadioButtonId == -1) {
                Toast.makeText(context, "Please select an option", Toast.LENGTH_SHORT).show()
                m1.receiveFeedback("")
            }
            else {
                val radioButton = view.findViewById<RadioButton>(selectedOption)
                m1.receiveFeedback(radioButton.text.toString())
            }


            dismiss()
        }
    }
}