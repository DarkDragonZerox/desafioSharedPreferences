package cl.desafiolatam.desafiounobase

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var nameInput: TextInputEditText
    lateinit var advance: Button
    lateinit var container: ConstraintLayout
    var spFile="cl.desafiolatam.desafiounobase"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameInput = findViewById(R.id.name_input)
        advance = findViewById(R.id.login_button)
        container = findViewById(R.id.container)
        setUpListeners()
    }

    private fun setUpListeners() {
        val sharedPreferences:SharedPreferences=this.getSharedPreferences(spFile,Context.MODE_PRIVATE)
        advance.setOnClickListener {
            if (nameInput.text!!.isNotEmpty()) {
                val intent: Intent

                val name:String=nameInput.text.toString()
                val editor:SharedPreferences.Editor=sharedPreferences.edit()
                editor.putString("user",name)
                editor.apply()

                if (hasSeenWelcome()) {
                    intent = Intent(this, HomeActivity::class.java)

                } else {
                    intent = Intent(this, WelcomeActivity::class.java)

                }
                startActivity(intent)
            } else {
                Snackbar.make(container, "El nombre no puede estar vacío", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun hasSeenWelcome(): Boolean {
        var returnValue = false
        //implementar este método para saber si el usuario ya ha entrado a la aplicación y ha visto
        //la pantalla de bienvenida. Este método permite decidir que pantalla se muestra después de presionar Ingresar
        //recorra la lista de usuarios
        return returnValue
    }
}
