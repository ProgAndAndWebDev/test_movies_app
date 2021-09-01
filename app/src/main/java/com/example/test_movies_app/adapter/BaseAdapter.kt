package com.example.test_movies_app.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.test_movies_app.BR
import com.example.test_movies_app.moviesModel.Result


abstract class BaseAdapter<T>(var items: List<T>?,
                              private var listener: BaseInteractionListener)
    : RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {

    fun setItem(newItems: List<T>?) {
             items = newItems
    }

    fun getItem() = items

    override fun getItemCount(): Int = items!!.size

    abstract val layoutId: Int

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ItemViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                layoutId , parent,false) )
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder, position: Int) {
        val currentItem = items?.get(position)
        when(holder){
            is ItemViewHolder  -> {
                holder.binding.setVariable(BR.itemXML, currentItem)
                holder.binding.setVariable(BR.listener, listener)
            }
            else -> {
               Log.i("rrrrrr" , "xxx"+ currentItem.toString())
            }

        }
    }

    abstract class BaseViewHolder(binding: ViewDataBinding)
        : RecyclerView.ViewHolder(binding.root)

    open class ItemViewHolder(val binding: ViewDataBinding)
        : BaseViewHolder(binding)

}


interface BaseInteractionListener

interface MovieInteractionListener: BaseInteractionListener{
    fun onClickMovie(movie: Result)
}


