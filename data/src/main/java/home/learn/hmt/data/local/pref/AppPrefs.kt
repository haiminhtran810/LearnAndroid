package home.learn.hmt.data.local.pref

import android.content.Context
import com.google.gson.Gson

class AppPrefs constructor(mContext: Context, val gson: Gson) : PrefHelper {
    companion object {
        private const val FIRST_RUN = "first_run"
    }

    private var sharedPreferences = mContext.getSharedPreferences(mContext.packageName, Context.MODE_PRIVATE)

    override fun clear() {
        sharedPreferences?.edit()?.clear()?.apply()
    }
}