package cl.desafiolatam.desafiounobase

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    lateinit var nameUser: TextView
    lateinit var advance: Button
    var spFile="cl.desafiolatam.desafiounobase"
    lateinit var sharedPreferences:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        nameUser = findViewById(R.id.welcome_name)
        advance = findViewById(R.id.advance_button)
        sharedPreferences=this.getSharedPreferences(spFile, Context.MODE_PRIVATE)
        setUpViewsAndListener()


    }

    private fun setUpViewsAndListener() {
       //var editor:SharedPreferences.Editor=sharedPreferences.edit()
        val userName =  sharedPreferences.getString("user","")

        nameUser.text = userName
        advance.setOnClickListener {
            //Agregar los pasos necesarios para manejar la persistencia
            //de cuando un usuario ve la pantalla de bienvenida la primera vez
            val intent = Intent(this, HomeActivity::class.java)

            startActivity(intent)
            finish()
        }
    }
}
