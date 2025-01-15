package com.rafdev.myapplication.utils

import android.animation.ValueAnimator
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.ProgressBar
import androidx.core.animation.doOnEnd

object AnimUtils {

    fun slideInFromLeft(container: View, screenWidth: Int, onEnd: () -> Unit = {}) {
        val animator = ValueAnimator.ofFloat(-screenWidth.toFloat(), 0f).apply {
            duration = 700
            interpolator = DecelerateInterpolator()
            addUpdateListener { valueAnimator ->
                val value = valueAnimator.animatedValue as Float
                container.translationX = value
            }
            doOnEnd {
                container.translationX = 0f
                onEnd()
            }
        }
        container.visibility = View.VISIBLE
        animator.start()
    }

    fun slideInFromRight(container: View, screenWidth: Int, onEnd: () -> Unit = {}) {
        val animator = ValueAnimator.ofFloat(screenWidth.toFloat(), 0f).apply {
            duration = 700
            interpolator = DecelerateInterpolator()
            addUpdateListener { valueAnimator ->
                val value = valueAnimator.animatedValue as Float
                container.translationX = value
            }
            doOnEnd {
                container.translationX = 0f
                onEnd()
            }
        }
        container.visibility = View.VISIBLE
        animator.start()
    }

    fun animateProgressBar(progressBar: ProgressBar, duration: Long = 4000) {
        progressBar.visibility = View.VISIBLE
        progressBar.progress = 0

        val animator = ValueAnimator.ofInt(0, 100).apply {
            this.duration = duration
            interpolator = LinearInterpolator()
            addUpdateListener { valueAnimator ->
                val progress = valueAnimator.animatedValue as Int
                progressBar.progress = progress
            }
        }
        animator.start()
    }
}