package com.tfmdev.contatinhos.ui.components

import android.content.Context
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class EditedTextMasked(context: Context, attrs: AttributeSet) : AppCompatEditText(context, attrs) {
    init {
        setup()
    }

    private fun setup() {
        filters = arrayOf<InputFilter>(InputFilter.LengthFilter(16))

        addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    removeTextChangedListener(this)

                    // Remove todos os caracteres não numéricos
                    val digitsOnly = s.toString().replace("\\D".toRegex(), "")

                    val formattedNumber = StringBuilder()
                    when (digitsOnly.length) {
                        in 1..8 -> formattedNumber.append("+").append(digitsOnly.substring(0))
                        in 9..16 -> {
                            formattedNumber.append("+")
                            if (digitsOnly.substring(0, 2) == "55") {
                                // Aplica a máscara +##(##)######### [PT-BR]
                                formattedNumber
                                    .append(digitsOnly.substring(0, 2))
                                    .append("(").append(digitsOnly.substring(2, 4)).append(")")
                                    .append(digitsOnly.substring(4, 9))
                                    .append(digitsOnly.substring(9))
                            } else {
                                // Aplica a máscara +### ### ### ### [PT-PT]
                                formattedNumber
                                    .append(digitsOnly.substring(0, 3)).append(" ")
                                    .append(digitsOnly.substring(3, 6)).append(" ")
                                    .append(digitsOnly.substring(6, 9)).append(" ")
                                    .append(digitsOnly.substring(9))
                            }
                        }
                    }
                    setText(formattedNumber.toString())
                    setSelection(text?.length ?: 0)

                    addTextChangedListener(this)
                }

                override fun afterTextChanged(s: Editable?) {}
            }
        )
    }
}
