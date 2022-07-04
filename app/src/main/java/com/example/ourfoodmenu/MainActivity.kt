package com.example.ourfoodmenu

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        Log.d("テスト","成功")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val menuImage:ImageView = findViewById(R.id.menuImage)
        var menuText:TextView = findViewById(R.id.menuText)

        when (item?.itemId){
            R.id.home -> {
                Log.d("テスト","成功")
                menuImage.setImageResource(R.drawable.okaasan)
                menuText.text = ""
                Log.d("テスト","成功")
                return true
            }
            R.id.gapao_text -> {
                menuImage.setImageResource(R.drawable.gapao)
                menuText.text = getString(R.string.gapao_text)
                return true
            }
            R.id.greencare_text -> {
                menuImage.setImageResource(R.drawable.greencare)
                menuText.text = getString(R.string.greencare_text)
                return true
            }
            R.id.hiyasityuuka_text -> {
                menuImage.setImageResource(R.drawable.hiyasityuuka)
                menuText.text = getString(R.string.hiyasityuuka_text)
                return true
            }
            R.id.karaage_text -> {
                menuImage.setImageResource(R.drawable.karaage)
                menuText.text = getString(R.string.karaage_text)
                return true
            }
            R.id.kimakare_text -> {
                menuImage.setImageResource(R.drawable.kimakare)
                menuText.text = getString(R.string.kimakare_text)
                return true
            }
            R.id.pizza_text -> {
                menuImage.setImageResource(R.drawable.pizza)
                menuText.text = getString(R.string.pizza_text)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}