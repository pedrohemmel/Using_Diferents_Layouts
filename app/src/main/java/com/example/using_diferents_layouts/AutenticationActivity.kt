package com.example.using_diferents_layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog

class AutenticationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autentication)

        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextPhoneNumber: EditText = findViewById(R.id.editTextPhoneNumber)
        val editTextEmail: EditText = findViewById(R.id.editTextEmail)
        val checkBoxEmail: CheckBox = findViewById(R.id.checkBoxEmail)
        val checkBoxPhoneNumber: CheckBox = findViewById(R.id.checkBoxPhoneNumber)
        val registerButton: Button = findViewById(R.id.btnRegister)
        val radioGroupShift: RadioGroup = findViewById(R.id.radioGroupShift)

        registerButton.setOnClickListener {
            if (!editTextName.text.isBlank() && !editTextEmail.text.isBlank() && !editTextPhoneNumber.text.isBlank()) {
                var shiftPrefered = when(radioGroupShift.checkedRadioButtonId) {
                    R.id.morningRadio -> "Morning"
                    R.id.afternoonRadio -> "Afternoon"
                    R.id.nightRadio -> "Night"
                    else -> "Não informado"
                }

                val msg = """Nome: ${editTextName.text}
                    |Phone number: ${editTextPhoneNumber.text}
                    |E-mail: ${editTextEmail.text}
                    |Phone number contact: ${checkBoxPhoneNumber.isChecked}
                    |E-mail contact: ${checkBoxEmail.isChecked}
                    |Shift choosed: ${shiftPrefered}
                """.trimMargin()

                showDialog("Sucesso", msg)
            } else {
                showDialog("Error", "Invalid Information")
            }
        }
    }

    //Funções aqui
    fun showDialog(title: String, msg: String) {
        AlertDialog.Builder(this)
            .setTitle("${title}")
            .setMessage("${msg}")
            .setPositiveButton("Ok",null)
            .create()
            .show()
    }
}