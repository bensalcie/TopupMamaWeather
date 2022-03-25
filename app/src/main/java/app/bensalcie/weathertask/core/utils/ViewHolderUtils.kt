package app.bensalcie.weathertask.core.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding



fun getBindingRow(parent: ViewGroup, @LayoutRes resId: Int): ViewDataBinding {
    return DataBindingUtil.inflate(LayoutInflater.from(parent.context), resId, parent, false)
}

