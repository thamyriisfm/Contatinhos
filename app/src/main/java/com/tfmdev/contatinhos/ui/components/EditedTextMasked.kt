package com.tfmdev.contatinhos.ui.components

import android.content.Context
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class EditedTextMasked : AppCompatEditText {
    constructor(context: Context) : super(context) {
        setup()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setup()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        setup()
    }

    private fun setup() {
        // Define o limite de caracteres para 14 (incluindo parênteses, traço e espaço)
        filters = arrayOf<InputFilter>(InputFilter.LengthFilter(16))

        // Adiciona um TextWatcher para formatar o número conforme o usuário digita
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                removeTextChangedListener(this)

                // Remove todos os caracteres não numéricos
                val digitsOnly = s.toString().replace("\\D".toRegex(), "")

                // Aplica a máscara para o número de telefone (##) #####-####
/*                val formattedNumber = StringBuilder()
                formattedNumber.append("+")
                    .append(digitsOnly.substring(0, 2))
                    .append("(").append(digitsOnly.substring(2, 4)).append(")")
                    .append(digitsOnly.substring(4, 9)).append(digitsOnly.substring(9))
                setText(formattedNumber.toString())
                setSelection(text?.length ?: 0)*/

                addTextChangedListener(this)
            }
        })
    }
}
