package works.cermati.arief.presentation.list

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main2.*
import works.cermati.arief.AriefApplication
import works.cermati.arief.R
import works.cermati.arief.presentation.list.adapter.UserAdapter
import works.cermati.arief.presentation.list.model.UsersModelItem

class ListUsersActivity : AppCompatActivity(), UsersContract.View {

    private val presenter by lazy { AriefApplication.ariefComponent.provideUsersPresenter() }
    private fun getListAdapter(): UserAdapter? = rv_users.adapter as? UserAdapter
    private var originalList = listOf<UsersModelItem>()
    private var filteredList = mutableListOf<UsersModelItem>()
    private var shouldLoadMore = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        presenter.attach(this)
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }

    override fun initViews() {

        edit_text_search.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) = Unit

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val keyword = p0.toString()
                if (keyword.isBlank()){
                    getListAdapter()?.setData(originalList.toMutableList())
                    shouldLoadMore = true
                }else{
                    shouldLoadMore = false
                    filteredList = originalList.toMutableList()
                    filteredList
                            .filter { it.login.contains(keyword, ignoreCase = true) }
                            .toMutableList()
                            .let { if(it.size > 0 ) getListAdapter()?.setData(it) }

                }
            }

        })


        rv_users.apply {
            layoutManager = LinearLayoutManager(this@ListUsersActivity)
            adapter = UserAdapter()
            addOnScrollListener(object: RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val lastItemId = getListAdapter()?.getAllData()?.last()?.id ?: 0
                    val lastItemPosition = (layoutManager as? LinearLayoutManager)?.findLastCompletelyVisibleItemPosition() ?: 0
                    val lastItem = getListAdapter()?.getAllData()?.get(lastItemPosition)?.id ?: 0
                    if (lastItemId == lastItem && shouldLoadMore){
                        presenter.fetchUsersData(lastItemId)
                    }
                }
            })
        }.also { presenter.fetchUsersData(0) }
    }

    override fun showListData(it: MutableList<UsersModelItem>?) {
        runOnUiThread { it?.let {
            if(getListAdapter()?.itemCount == 0) {
                getListAdapter()?.setData(it)
            }else{
                getListAdapter()?.addAllData(it)
            }
            originalList = getListAdapter()?.getAllData().orEmpty()
        } }
    }

    override fun onError(it: Throwable?) {
    }

    override fun hideLoading() {
    }

    override fun showLoading() {
    }


}
