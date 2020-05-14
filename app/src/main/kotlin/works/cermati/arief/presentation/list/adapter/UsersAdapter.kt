package works.cermati.arief.presentation.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_users.view.*
import works.cermati.arief.R
import works.cermati.arief.presentation.list.model.UsersModelItem
import kotlin.coroutines.coroutineContext

class UserAdapter():works.cermati.arief.common.base.adapter.BaseAdapter<RecyclerView.ViewHolder, UsersModelItem>() {

    private var data: MutableList<UsersModelItem> = mutableListOf()

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UserViewHolder(layoutInflater.inflate(R.layout.item_users, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as UserViewHolder)
        holder.bindData(data[position])

    }

    override fun addAllData(data: MutableList<UsersModelItem>) {
        this.data.addAll(data)
        this.notifyDataSetChanged()
    }

    override fun addData(data: UsersModelItem) {
        this.data.add(data)
        this.notifyDataSetChanged()
    }

    override fun getDataAt(position: Int): UsersModelItem  = data[position]

    override fun getAllData(): MutableList<UsersModelItem> = data

    override fun setData(data: MutableList<UsersModelItem>) {
        this.data = data
        this.notifyDataSetChanged()
    }
}

class UserViewHolder(viewItem: View):RecyclerView.ViewHolder(viewItem){

    fun bindData(data: UsersModelItem) {
        itemView.textview_users.text = data.login
        Glide.with(itemView.context).load(data.avatarUrl).into(itemView.imageview_users)
    }
}
