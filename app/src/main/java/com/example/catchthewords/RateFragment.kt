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
        val cancelBtn : Button = view.findViewById(R.id.cancelBT);
        val submitBtn : Button = view.findViewById(R.id.submitBT);
        val radioGroup = view.findViewById<RadioGroup>(R.id.ratingRadioGroup)
        cancelBtn.setOnClickListener{
            dismiss()
        }
        submitBtn.setOnClickListener {
            val selectedOption: Int = radioGroup.checkedRadioButtonId
            val radioButton = view.findViewById<RadioButton>(selectedOption)
            Toast.makeText(context, radioButton.text, Toast.LENGTH_SHORT).show()
            val m1: MainActivity = getActivity() as MainActivity;
            m1.receiveFeedback(radioButton.text.toString())
            dismiss()
        }
    }
}