package com.example.aptea.ui.list

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aptea.R
import com.example.aptea.data.model.ItemsData
import com.example.aptea.databinding.FragmentItemsBinding
import com.example.aptea.ui.MainActivity
import com.example.aptea.ui.details.ItemsDetailsFragment
import com.example.aptea.utils.replaceFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class ItemsFragment : Fragment(), ItemsClickListener {

    private val itemsViewModel: ItemsViewModel by viewModel()
    private lateinit var itemsAdapter: ItemsAdapter
    private lateinit var mViewDataBinding: FragmentItemsBinding
    var state: Parcelable? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mViewDataBinding  = DataBindingUtil.inflate(inflater,
            R.layout.fragment_items, container, false)
        val mRootView = mViewDataBinding.root
        mViewDataBinding.lifecycleOwner = this
        return mRootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setView()
        removeBackButton()
        mViewDataBinding.viewModel = itemsViewModel
        itemsViewModel.getAllItems()
        itemsViewModel.itemsList.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty() && it != null) {
                itemsAdapter.setItems(it)
            }
        })

    }

    private fun removeBackButton() {
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as? AppCompatActivity)?.supportActionBar?.setHomeButtonEnabled(false)
    }

    private fun setView() {
        itemsAdapter = ItemsAdapter(context, this)
        mViewDataBinding.rvItems.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mViewDataBinding.rvItems.adapter = itemsAdapter
        mViewDataBinding.rvItems.isNestedScrollingEnabled = false
    }

     override fun onPause() {
        super.onPause()
        state = mViewDataBinding.rvItems.getLayoutManager()?.onSaveInstanceState()
    }

     override fun onResume() {
        super.onResume()
         mViewDataBinding.rvItems.getLayoutManager()?.onRestoreInstanceState(state)
    }
    override fun onItemClick(item : ItemsData) {
        (activity as MainActivity).replaceFragment(
            ItemsDetailsFragment.newInstance(item),
            R.id.fragment_container, "itemsdetails")
    }
}