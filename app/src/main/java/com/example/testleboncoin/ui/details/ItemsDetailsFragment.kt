package com.example.testleboncoin.ui.details


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.testleboncoin.R
import com.example.testleboncoin.data.model.ItemsData
import com.example.testleboncoin.databinding.FragmentItemDetailsBinding

class ItemsDetailsFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(data: ItemsData) = ItemsDetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable("item_data_row", data)
            }
        }
    }

    private var item: ItemsData? = null
    private lateinit var mViewDataBinding: FragmentItemDetailsBinding


    override fun onAttach(context: Context) {
        super.onAttach(context)
        item =  arguments?.getParcelable("item_data_row")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mViewDataBinding  = DataBindingUtil.inflate(inflater,
            R.layout.fragment_item_details, container, false)
        val mRootView = mViewDataBinding.root
        mViewDataBinding.lifecycleOwner = this
        return mRootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        enableBackButton()
        mViewDataBinding.item = item
    }

    private fun enableBackButton() {
        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as? AppCompatActivity)?.supportActionBar?.setHomeButtonEnabled(true)
    }

}