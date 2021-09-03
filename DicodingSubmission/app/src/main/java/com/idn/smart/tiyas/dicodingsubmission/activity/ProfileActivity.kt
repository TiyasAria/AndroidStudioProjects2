package com.idn.smart.tiyas.dicodingsubmission.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.idn.smart.tiyas.dicodingsubmission.R
import com.idn.smart.tiyas.dicodingsubmission.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    companion object{
        fun getLaunchService (from: Context) = Intent(from, ProfileActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }
    private lateinit var  profileBinding : ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        profileBinding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(profileBinding.root)

        profileBinding.iconBack.setOnClickListener{
            startActivity(Intent(MainActivity.getLaunchService(this)))
        }
    }
}