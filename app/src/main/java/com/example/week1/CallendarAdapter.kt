package com.example.week1

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week1.databinding.CallenderItemBinding


class CallendarAdapter(
    val context: CallendarFragment,
    private val items: ArrayList<Schedule>,
) : RecyclerView.Adapter<CallendarAdapter.ViewHolder>() {

    var tmp = context
    override fun getItemCount(): Int = items.size
    private lateinit var itemClickListener : OnItemClickListener
    var viewtype = 0

    fun setviewtype(num : Int){
        this.viewtype = num
    }

    override fun onBindViewHolder(holder: CallendarAdapter.ViewHolder, position: Int) {

        val item = items[position]
        val listener = View.OnClickListener { it ->
//            Toast.makeText(it.context, "Clicked -> Name : ${item.name}, Number : ${item.number}", Toast.LENGTH_SHORT).show()
        }
        holder.apply {
            bind(listener, item, viewtype)
//            itemView.tag = item
        }
        holder.itemView.setOnClickListener{
            if(viewtype == 1)
                itemClickListener.onClick(it, position)
        }
    }

    interface OnItemClickListener{
        fun onClick(v:View, position:Int)
    }

    fun setItemClickListener(OnItemClickListener : OnItemClickListener){
        this.itemClickListener = OnItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallendarAdapter.ViewHolder {
        val binding = CallenderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CallendarAdapter.ViewHolder(binding)
    }

    // 각 항목에 필요한 기능을 구현
    class ViewHolder(var binding : CallenderItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: View.OnClickListener, item: Schedule, viewtype: Int) {
            binding.content.text = item.content
            if(viewtype == 1) {
                binding.image.setImageResource(R.drawable.icon_bin)
                var params = binding.image.layoutParams

                params.height = (20 * Resources.getSystem().displayMetrics.density).toInt()
                params.width = (20 * Resources.getSystem().displayMetrics.density).toInt()

                binding.image.layoutParams = params
            }
            else{
                var params = binding.image.layoutParams
                params.height = (10 * Resources.getSystem().displayMetrics.density).toInt()
                params.width = (10 * Resources.getSystem().displayMetrics.density).toInt()
                binding.image.layoutParams = params
            }
        }
    }
}

