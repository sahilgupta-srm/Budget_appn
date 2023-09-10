package com.example.budget_tracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.budget_tracker.Db.Expense
import com.example.budget_tracker.databinding.ExpenseListBinding

class List_adapter: RecyclerView.Adapter<MyViewHolder>() {
    private  val expenseList=ArrayList<Expense>()

    fun setList(expense: List<Expense>){
        expenseList.clear()
        expenseList.addAll(expense)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val binding: ExpenseListBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.expense_list,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return expenseList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(expenseList[position])
    }
}

class MyViewHolder(val binding:ExpenseListBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(expense: Expense) {
            binding.textView.text=expense.value.toString()
            binding.textView2.text=expense.a

    }

}