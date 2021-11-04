package edu.neu.khoury.madsea.majianqing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class todoListAdapter(mainActivity: UpdateandDelete) : ListAdapter<UserEntity, todoListAdapter.WordViewHolder>(WordsComparator()) {
    private var updateandDelete: UpdateandDelete = mainActivity
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = getItem(position)
        holder.bindView(current.itemDataText)
        holder.bindCheck(current.done)
        holder.isDeleted.setOnClickListener{
            updateandDelete.onItemDelete(current)
            notifyDataSetChanged()
        }
        holder.editStuff.setOnClickListener{
            updateandDelete.onItemEdit(current)
            notifyDataSetChanged()
        }
        holder.checkItemView.setOnClickListener{
            updateandDelete.modifyItem(current)
            notifyDataSetChanged()
        }
    }

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val wordItemView: TextView = itemView.findViewById(R.id.item_textView)
        val checkItemView: CheckBox = itemView.findViewById(R.id.checkbox)
        val isDeleted: ImageButton = itemView.findViewById(R.id.close)
        val editStuff: ImageButton = itemView.findViewById(R.id.edit)
        private var updateandDelete: UpdateandDelete = itemView.context as UpdateandDelete

        fun bindView(text: String?) {
            wordItemView.text = text
        }
        fun bindCheck(done: Boolean) {
            checkItemView.isChecked = done
        }


        companion object {
            fun create(parent: ViewGroup): WordViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return WordViewHolder(view)
            }
        }
    }

    class WordsComparator : DiffUtil.ItemCallback<UserEntity>() {
        override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
            return oldItem.done == newItem.done && oldItem.reminder == newItem.reminder &&
                    oldItem.deadline == newItem.deadline && oldItem.itemDataText == newItem.itemDataText
                    && oldItem.moreDetails == newItem.moreDetails && oldItem.tags == newItem.tags &&
                    oldItem.timeToRemind == newItem.timeToRemind
        }
    }
}