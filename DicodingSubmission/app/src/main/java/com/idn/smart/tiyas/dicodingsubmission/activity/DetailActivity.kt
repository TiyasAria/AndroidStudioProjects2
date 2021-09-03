package com.idn.smart.tiyas.dicodingsubmission.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.idn.smart.tiyas.dicodingsubmission.R
import com.idn.smart.tiyas.dicodingsubmission.databinding.ActivityDetailBinding
import com.idn.smart.tiyas.dicodingsubmission.model.ScarlettModel

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_SKIN_CARE = "extra_skin_care"
    }

    private lateinit var  detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)
        supportActionBar?.hide()

        detailBinding.fbBack.setOnClickListener {
            startActivity(Intent(MainActivity.getLaunchService(this)))
        }

        detailBinding.fbShare.setOnClickListener {
            val share_judul = detailBinding.tvJudulDetail.text.toString()
            val share_harga = detailBinding.tvPriceDetail.text.toString()
            val share_desc = detailBinding.tvDescDetail.text.toString()
            val share_poto = detailBinding.imgDetail.toString()


            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = "text/plain"
            shareIntent.putExtra(
                Intent.EXTRA_TEXT,
                "Assalamu'alaikum! Aloha Muslimah \n \nBeli produk kecantikan scarlett yuk\n" +
                        " \n$share_judul\n$share_harga\n$share_desc\n$share_poto \njangan sampai ketinggalan ya, dan dapatkan kulit cantik berseri dengan scarlett whitening"
            )
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Scarlett Produk")
            startActivity(Intent.createChooser(shareIntent, "Share text via"))
        }

        val scarlett = intent.getParcelableExtra<ScarlettModel>("EXTRA_SKIN_CARE") as ScarlettModel
        Glide.with(this).load(scarlett.photo).into(detailBinding.imgDetail)
        detailBinding.tvJudulDetail.text = scarlett.name
        detailBinding.tvDescDetail.text = scarlett.description
        detailBinding.tvPriceDetail.text = scarlett.price
    }
}