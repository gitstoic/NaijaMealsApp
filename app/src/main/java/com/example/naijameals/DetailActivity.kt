package com.example.naijameals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.naijameals.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        const val DEETS: String = "deets"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        aboutFood(binding)
    }

    private fun aboutFood(binding: ActivityDetailBinding) {
         val foodDeets = intent.getIntExtra(DEETS, R.string.abacha)

          binding.apply {
              activity2detail.text = getString(foodDeets)

          }
        }
    }
