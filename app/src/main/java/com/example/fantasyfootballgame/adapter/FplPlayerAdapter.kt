package com.example.fantasyfootballgame.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fantasyfootballgame.R
import com.example.fantasyfootballgame.model.BoostrapStatic.FplPlayer

class FplPlayerAdapter : RecyclerView.Adapter<FplPlayerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val playerNameTextView: TextView = itemView.findViewById(R.id.text_player_web_name)
        val playerXGoalsTextView: TextView = itemView.findViewById(R.id.text_player_expected_goals)
        val playerXAssistsTextView: TextView = itemView.findViewById(R.id.text_player_expected_assists)
//        val playerTransferInTextView: TextView = itemView.findViewById(R.id.image_player_avatar)
    }

    private val differCallBack = object : DiffUtil.ItemCallback<FplPlayer>() {
        override fun areItemsTheSame(oldItem: FplPlayer, newItem: FplPlayer): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FplPlayer, newItem: FplPlayer): Boolean {
            return oldItem == newItem
        }
    }

    private val listDiffer = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FplPlayerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_player, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FplPlayerAdapter.ViewHolder, position: Int) {
        val playerData = listDiffer.currentList[position]
        holder.apply {
            playerNameTextView.text = "Name = ${playerData.firstName} ${playerData.secondName}"
            playerXGoalsTextView.text = "xGoals = ${playerData.expectedGoals}"
            playerXAssistsTextView.text = "xAssists = ${playerData.expectedAssists}"
//            playerTransferInTextView.text = "Transfers In = ${playerData.transfersIn.toString()}"
        }
    }

    override fun getItemCount(): Int {
        return listDiffer.currentList.size
    }

    fun setPlayersList(newList: List<FplPlayer>){
        listDiffer.submitList(newList)
        notifyItemRangeChanged(0, newList.size-1)
    }
}
