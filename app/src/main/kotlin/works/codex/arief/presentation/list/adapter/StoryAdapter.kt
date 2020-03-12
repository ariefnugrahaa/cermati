package works.codex.arief.presentation.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_story.view.*
import works.codex.arief.R
import works.codex.arief.common.base.adapter.BaseAdapter
import works.codex.arief.presentation.list.model.ListViewModel

class StoryAdapter(private val onClickListener: (position: Int, id: Int?) -> Unit) : BaseAdapter<ItemViewHolder, ListViewModel>() {

    init {
        setHasStableIds(true)
    }

    private var data: MutableList<ListViewModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_story, parent, false)
        return ItemViewHolder(view, onClickListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun addAllData(data: MutableList<ListViewModel>) {
        this.data.addAll(data)
        this.notifyDataSetChanged()
    }

    override fun addData(data: ListViewModel) {
        this.data.add(data)
        this.notifyDataSetChanged()
    }

    override fun getDataAt(position: Int): ListViewModel {
        return data[position]
    }

    override fun getAllData(): MutableList<ListViewModel> {
        return data
    }

    override fun setData(data: MutableList<ListViewModel>) {
        this.data = data
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}

class ItemViewHolder(viewItem: View, private val onClickListener: (position: Int, id: Int?) -> Unit) : RecyclerView.ViewHolder(viewItem) {
    fun bindData(data: ListViewModel) {
        itemView.textview_item.text = data.title
        itemView.container_adapter.setOnClickListener {
            onClickListener(adapterPosition, data.id)
        }
    }
}
