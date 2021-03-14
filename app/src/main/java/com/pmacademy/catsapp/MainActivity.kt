package com.pmacademy.catsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pmacademy.catsapp.databinding.ActivityMainBinding
import com.pmacademy.catsapp.di.AppComponent
import com.pmacademy.catsapp.di.DaggerAppComponent
import com.pmacademy.catsapp.cats.ui.CatsFragment

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    lateinit var daggerComponent: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        createDaggerComponent()
        addCatsFragment()
    }

    private fun createDaggerComponent() {
        daggerComponent = DaggerAppComponent.builder().build()
    }

    private fun addCatsFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, CatsFragment.newInstance())
            .commit()
    }
}
