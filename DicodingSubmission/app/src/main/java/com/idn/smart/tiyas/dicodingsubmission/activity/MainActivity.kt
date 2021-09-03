package com.idn.smart.tiyas.dicodingsubmission.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.smart.tiyas.dicodingsubmission.R
import com.idn.smart.tiyas.dicodingsubmission.adapter.ScarlettAdapter
import com.idn.smart.tiyas.dicodingsubmission.databinding.ActivityMainBinding
import com.idn.smart.tiyas.dicodingsubmission.model.ScarlettModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var  mainBinding: ActivityMainBinding
    private val list = ArrayList<ScarlettModel>()

    companion object{
        fun getLaunchService (from:Context) = Intent(from, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.rvItem.setHasFixedSize(true)
        list.addAll(getDataScarlett())
        showRecyclerList()

        mainBinding.profile.setOnClickListener(this)



    }

    private fun showRecyclerList() {
      mainBinding.rvItem.layoutManager = LinearLayoutManager(this)
        val listScarlettAdapter = ScarlettAdapter(list)
        mainBinding.rvItem.adapter = listScarlettAdapter

        listScarlettAdapter.setOnClickCallBack(object : ScarlettAdapter.OnItemCLickCallback {

            override fun onItemClick (data : ScarlettModel) {
                val intent = Intent (this@MainActivity, DetailActivity::class.java)
                    .apply {
                      putExtra(DetailActivity.EXTRA_SKIN_CARE, data.name)
                      putExtra(DetailActivity.EXTRA_SKIN_CARE, data.photo)
                      putExtra(DetailActivity.EXTRA_SKIN_CARE, data.description)
                      putExtra(DetailActivity.EXTRA_SKIN_CARE, data.price)
                    }
                startActivity(intent)
                finish()
            }
        })

    }

    private fun getDataScarlett(): ArrayList<ScarlettModel> {
         val dataName = resources.getStringArray(R.array.data_name)
         val dataPrice = resources.getStringArray(R.array.data_price)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val listScarlett = ArrayList<ScarlettModel>()
        for (position in dataName.indices){
            val scarlett = ScarlettModel(
                dataName[position],
                dataPrice[position],
                dataPhoto[position],
                dataDescription[position],

            )
            listScarlett.add(scarlett)
        }
        return listScarlett
    }

    override fun onClick(v: View) {
    when(v.id) {
        R.id.profile -> startActivity(Intent(ProfileActivity.getLaunchService(this)))
    }
    }
}