package com.idn.smart.tiyas.dicodingsubmission.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.idn.smart.tiyas.dicodingsubmission.R
import com.idn.smart.tiyas.dicodingsubmission.activity.DetailActivity
import com.idn.smart.tiyas.dicodingsubmission.databinding.ItemScarlettBinding
import com.idn.smart.tiyas.dicodingsubmission.model.ScarlettModel
import org.jetbrains.anko.intentFor

class ScarlettAdapter( private val listScarlett: ArrayList<ScarlettModel>) : RecyclerView.Adapter<ScarlettAdapter.ScarlettViewHolder>() {

    inner class ScarlettViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemScarlettBinding = ItemScarlettBinding.bind(itemView)
        fun bind(scarlett: ScarlettModel) {
            with(itemView) {

                itemScarlettBinding.tvJudul.text = scarlett.name
                itemScarlettBinding.tvPrice.text = scarlett.price
                itemScarlettBinding.tvDesc.text = scarlett.description
                Glide.with(itemView.context)
                    .load(scarlett.photo)
                    .apply(RequestOptions().override(80, 80))
                    .into(itemScarlettBinding.imgItem)



                itemView.setOnClickListener {
                    itemView.context?.startActivity(
                        itemView.context.intentFor<DetailActivity>(
                            "EXTRA_SKIN_CARE" to scarlett
                        )
                    )
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScarlettViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_scarlett, parent, false)
        return ScarlettViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScarlettViewHolder, position: Int) {
       holder.bind(listScarlett[position])
    }

    override fun getItemCount(): Int = listScarlett.size

    private lateinit var onItemClickCallback : OnItemCLickCallback

    fun setOnClickCallBack(onItemClickCallback : OnItemCLickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemCLickCallback{
        fun onItemClick(data : ScarlettModel)
    }

}