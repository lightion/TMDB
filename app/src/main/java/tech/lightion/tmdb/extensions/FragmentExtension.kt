package tech.lightion.tmdb.extensions

import android.view.View
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment

/**
 * A Fragment extension to delay the enter transition used for the shared element animation
 */
fun Fragment.waitForTransition(targetView : View) {
    postponeEnterTransition()
    targetView.doOnPreDraw { startPostponedEnterTransition() }
}