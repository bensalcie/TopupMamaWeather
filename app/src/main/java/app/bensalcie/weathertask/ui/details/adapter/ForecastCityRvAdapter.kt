package app.bensalcie.weathertask.ui.details.adapter

import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncListDiffer
import app.bensalcie.weathertask.R
import app.bensalcie.weathertask.core.base.adapter.BaseAdapter
import app.bensalcie.weathertask.core.base.adapter.BaseViewHolder
import app.bensalcie.weathertask.core.base.adapter.DiffCallBack
import app.bensalcie.weathertask.core.utils.getBindingRow
import app.bensalcie.weathertask.databinding.ItemRvForcastBinding
import app.bensalcie.weathertask.db.ForecastRow


class ForecastCityRvAdapter: BaseAdapter<ForecastRow>() {

    private var mDiffer = AsyncListDiffer(this, DiffCallBack<ForecastRow>())

    override fun setDataList(dataList: List<ForecastRow>) {
        mDiffer.submitList(dataList)
    }

    override fun addDataList(dataList: List<ForecastRow>) {
        mDiffer.currentList.addAll(dataList)
    }

    override fun clearDataList() {
        mDiffer.currentList.clear()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ForecastRow> {
        return ViewHolderForecastCity(getBindingRow(parent, R.layout.item_rv_forcast) as ItemRvForcastBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ForecastRow>, position: Int) {
        val model = mDiffer.currentList[position]
        holder.apply {
            bind(model)
            itemView.apply {
                animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.ver_anim)
            }
        }
    }

    override fun getItemCount(): Int = mDiffer.currentList.size


}

class ViewHolderForecastCity (binding: ItemRvForcastBinding): BaseViewHolder<ForecastRow>(binding)  {

    override var itemRowBinding: ViewDataBinding = binding

    override fun bind(result: ForecastRow) {
        itemRowBinding.setVariable(app.bensalcie.weathertask.BR.model , result)
        itemRowBinding.executePendingBindings()
    }
}
