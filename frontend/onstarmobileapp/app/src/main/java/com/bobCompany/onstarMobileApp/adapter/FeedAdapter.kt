package com.bobCompany.onstarMobileApp.adapter

import android.content.Intent
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bobCompany.onstarMobileApp.data.FeedItem
import com.bobCompany.onstarMobileApp.databinding.ItemFeedCardBinding
import android.graphics.Color
import com.bobCompany.onstarMobileApp.FeedDetailActivity

class FeedAdapter(private val items: List<FeedItem>) :
    RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    //카드 연결
    inner class FeedViewHolder(val binding: ItemFeedCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFeedCardBinding.inflate(inflater, parent, false)
        return FeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val item = items[position]
        holder.binding.placeTitle.text = item.title
        holder.binding.address.text = item.address + " "+item.subAddress
        holder.binding.feedDate.text = "Date ${item.date}"
        holder.binding.tagPlace.text = item.tag1
        holder.binding.tagLocation.text = "| ${item.tag2}"
        holder.binding.likeCount.text = item.likeCount.toString()
        holder.binding.viewCount.text = item.viewCount.toString()
        holder.binding.placeImage.setImageResource(item.imageResId)
        
        //피드 클릭 이벤트
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, FeedDetailActivity::class.java)
            intent.putExtra("feed_id", item.id)
            context.startActivity(intent)
        }
        
        //해시태그 연결
        holder.binding.hashtagContainer.removeAllViews()
        for(tag in item.hashtags){
            val textView = TextView(holder.itemView.context).apply{
                text = "#$tag"
                setTextColor(Color.parseColor("#E53935"))
                setTextSize(TypedValue.COMPLEX_UNIT_SP,12f)
                setPadding(0,0,16,0)
            }
            holder.binding.hashtagContainer.addView(textView)
        }
    }



    override fun getItemCount(): Int = items.size
}
