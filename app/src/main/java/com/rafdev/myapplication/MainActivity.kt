package com.rafdev.myapplication

import android.animation.ValueAnimator
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rafdev.myapplication.utils.AnimUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPlay = findViewById<Button>(R.id.btn_play)
        val container =  findViewById<FrameLayout>(R.id.container)
        val progressBtn = findViewById<ProgressBar>(R.id.progress_bar)
        val btnCancel = findViewById<Button>(R.id.btn_cancel)

        btnPlay.setOnClickListener {
            val screenWidth = resources.displayMetrics.widthPixels
            AnimUtils.slideInFromLeft(container, screenWidth) {
                AnimUtils.animateProgressBar(progressBtn)
            }
        }

    }

//    private fun showButtonWithValueAnimator(container: View, progressBar: ProgressBar) {
//        val screenWidth = resources.displayMetrics.widthPixels
//
//        val animator = ValueAnimator.ofFloat(screenWidth.toFloat(), 0f).apply {
//            duration = 700
//            interpolator = DecelerateInterpolator()
//            addUpdateListener { valueAnimator ->
//                val value = valueAnimator.animatedValue as Float
//                container.translationX = value
//            }
//            doOnEnd {
//                container.translationX = 0f
//                animateBackgroundExpansion(progressBar)
//            }
//        }
//        container.visibility = View.VISIBLE
//        animator.start()
//    }
//
//    private fun animateBackgroundExpansion( progressBar: ProgressBar) {
//        progressBar.visibility = View.VISIBLE
//        progressBar.progress = 0
//
//        val animator = ValueAnimator.ofInt(0, 100).apply {
//            duration = 4000
//            interpolator = LinearInterpolator()
//            addUpdateListener { valueAnimator ->
//                val progress = valueAnimator.animatedValue as Int
//                progressBar.progress = progress
//            }
//        }
//
//        animator.start()
//    }

}