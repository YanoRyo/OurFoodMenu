package com.example.ourfoodmenu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menuImage = findViewById<ImageView>(R.id.menuImage)
        registerForContextMenu(menuImage)

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

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        val menuText = findViewById<TextView>(R.id.menuText)
        super.onCreateContextMenu(menu, v, menuInfo)
        if (menuText.text.isNotEmpty()) {
            menuInflater.inflate(R.menu.context, menu)
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val menuText = findViewById<TextView>(R.id.menuText)
        when (item?.itemId) {
            R.id.mail -> {
                val subject = getString(R.string.app_name)
                val text = "${menuText.text}が食べたい！"
                val uri = Uri.fromParts("mailto", "yanoryo7032@gmail.com",null)
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                intent.putExtra(Intent.EXTRA_SUBJECT, subject)
                intent.putExtra(Intent.EXTRA_TEXT, text)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
                return true
            }
            R.id.sms -> {
                val text = "${menuText.text}が食べたい！"
                val uri = Uri.fromParts("smsto", "08058855493",null)
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                val sms_body:String? = null
                intent.putExtra(sms_body, text)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}