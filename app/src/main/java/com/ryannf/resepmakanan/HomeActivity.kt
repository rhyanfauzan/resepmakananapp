package com.ryannf.resepmakanan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bellodev.recyclerviewapp.MyAdapter
import com.ryannf.resepmakanan.helper.Constant
import com.ryannf.resepmakanan.helper.PreferencesHelper

class HomeActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MyAdapter


    lateinit var sharedpref: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        sharedpref = PreferencesHelper(this)

        val textUsername = findViewById(R.id.textUsername) as TextView
        val buttonLogout = findViewById(R.id.buttonLogout) as Button

        textUsername.text = sharedpref.getString(Constant.PREF_USERNAME)
        buttonLogout.setOnClickListener{
            sharedpref.clear()
            showMessage("Keluar")
            moveIntent()

        }

        init()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    private fun moveIntent(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun showMessage(message: String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    private fun init() {
        recyclerView = findViewById(R.id.list_card_resep)

        var data = ArrayList<ResepMakanan>()
        data.add(ResepMakanan(R.drawable.sayurlodeh, "Sayur Lodeh", "Cara membuat sayur lodeh yang lezat"))
        data.add(ResepMakanan(R.drawable.ayamkatsu, "Ayam Katsu", "Cara membuat ayam katsu seperti di restoran"))
        data.add(ResepMakanan(R.drawable.bakwan, "Bakwan Mie Sayur", "Cara membuat bakwan mie sayur kekinian"))
        data.add(ResepMakanan(R.drawable.ayamkrispi, "Ayam Crispy", "Cara membuat ayam goreng krispi"))
        data.add(ResepMakanan(R.drawable.mieramen, "Mie Ramen", "Cara membuat mie ramen seperti aslinya"))
        data.add(ResepMakanan(R.drawable.ayamgeprek, "Ayam Geprek", "Cara membuat ayam geprek"))
        data.add(ResepMakanan(R.drawable.muffin, "Muffin Sayur", "Cara membuat muffin sayur yang enak"))
        data.add(ResepMakanan(R.drawable.nasikuning, "Nasi Kuning", "Cara membuat nasi kuning kerucut"))
        data.add(ResepMakanan(R.drawable.telurdadar, "Telur Dadar", "Cara membuat telur dadar yang enak dan estetik"))
        data.add(ResepMakanan(R.drawable.telurbalado, "Telur Balado", "Cara membuat telur balado hot"))

        adapter = MyAdapter(data)
    }

}