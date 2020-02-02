package eu.kanade.tachiyomi.widget.preference

import android.content.Context
import androidx.preference.Preference
import androidx.preference.PreferenceViewHolder
import android.util.AttributeSet
import eu.kanade.tachiyomi.R
import eu.kanade.tachiyomi.data.preference.PreferencesHelper
import eu.kanade.tachiyomi.data.preference.getOrDefault
import eu.kanade.tachiyomi.util.gone
import eu.kanade.tachiyomi.util.visible
import kotlinx.android.synthetic.main.preference_update_text.view.*
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.api.get

class ExtensionPreference @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    Preference(context, attrs) {

    init {
        widgetLayoutResource = R.layout.preference_update_text
    }

    override fun onBindViewHolder(holder: PreferenceViewHolder) {
        super.onBindViewHolder(holder)

        val extUpdateText = holder.itemView.textView

        val updates = Injekt.get<PreferencesHelper>().extensionUpdatesCount().getOrDefault()
        if (updates > 0) {
            extUpdateText.text = context.resources.getQuantityString(R.plurals
                .extensions_updates_available, updates, updates)
            extUpdateText.visible()
        }
        else {
            extUpdateText.text = null
            extUpdateText.gone()
        }
    }

    override public fun notifyChanged() {
        super.notifyChanged()
    }

}
