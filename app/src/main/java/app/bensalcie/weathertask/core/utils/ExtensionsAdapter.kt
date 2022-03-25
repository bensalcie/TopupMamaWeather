package app.bensalcie.weathertask.core.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import app.bensalcie.weathertask.R
import app.bensalcie.weathertask.core.utils.AppConstants.WEATHER_API_IMAGE_ENDPOINT




@BindingAdapter("app:bindString")
fun setBindString(textView: TextView, txtString: String?) {
    if (txtString != null)  textView.text = txtString
}

@BindingAdapter("app:bindTemp")
fun setBindTemp(textView: TextView, Temp: Double?) {
    if (Temp != null)  textView.text = Temp.toInt().toString()
}

@BindingAdapter("app:bindImgUrl")
fun setBindImage(image: ImageView, imageUrl: String?) {

    val iconCode = imageUrl?.replace("n", "d")
    val margeLink = "$WEATHER_API_IMAGE_ENDPOINT$iconCode@4x.png"

    image.load(margeLink) {
        placeholder(R.drawable.place_holder)
        crossfade(true)
        crossfade(400)
        transformations(RoundedCornersTransformation(10f))

    }
}










