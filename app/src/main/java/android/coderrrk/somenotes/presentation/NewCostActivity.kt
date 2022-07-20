package android.coderrrk.somenotes.presentation

import android.app.Activity


import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import somenotes.R


//новый интент для добавления элемента
class NewCostActivity: AppCompatActivity() {

    private lateinit var editCostView: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_cost)
        editCostView = findViewById(R.id.edit_cost)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editCostView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val cost = editCostView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, cost)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "REPLY"




    }


}







