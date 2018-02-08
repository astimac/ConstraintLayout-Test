package com.astimac.constraintlayouttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var constraintLayout: ConstraintLayout
    private val constraintSet = ConstraintSet()
    private val constraintSetOriginal = ConstraintSet()
    private var selected: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        constraintLayout = findViewById(R.id.constraint_layout)
        constraintSet.clone(constraintLayout)
        constraintSetOriginal.clone(constraintLayout)
    }

    fun onViewClick(v : View) {
        if (selected == -1 || selected != v.id) {
            animateView(v.id)
        } else {
            animateOriginal()
        }
    }

    fun animateView(viewId: Int) {
        when (viewId) {
            R.id.imageView9 -> {
                constraintSet.setGuidelinePercent(R.id.centerHorizontalGuideline, 0.90f)
                constraintSet.setGuidelinePercent(R.id.centerVerticalGuideline, 0.85f)
                setVisibility(R.id.button9, View.VISIBLE)
                setVisibility(R.id.button10, View.GONE)
                setVisibility(R.id.button11, View.GONE)
                setVisibility(R.id.button12, View.GONE)
                selected = R.id.imageView9
            }
            R.id.imageView10 -> {
                constraintSet.setGuidelinePercent(R.id.centerHorizontalGuideline, 0.90f)
                constraintSet.setGuidelinePercent(R.id.centerVerticalGuideline, 0.15f)
                setVisibility(R.id.button9, View.GONE)
                setVisibility(R.id.button10, View.VISIBLE)
                setVisibility(R.id.button11, View.GONE)
                setVisibility(R.id.button12, View.GONE)
                selected = R.id.imageView10
            }
            R.id.imageView11 -> {
                constraintSet.setGuidelinePercent(R.id.centerVerticalGuideline, 0.85f)
                constraintSet.setGuidelinePercent(R.id.centerHorizontalGuideline, 0.10f)
                setVisibility(R.id.button9, View.GONE)
                setVisibility(R.id.button10, View.GONE)
                setVisibility(R.id.button11, View.VISIBLE)
                setVisibility(R.id.button12, View.GONE)
                selected = R.id.imageView11
            }
            R.id.imageView12 -> {
                constraintSet.setGuidelinePercent(R.id.centerVerticalGuideline, 0.15f)
                constraintSet.setGuidelinePercent(R.id.centerHorizontalGuideline, 0.10f)
                setVisibility(R.id.button9, View.GONE)
                setVisibility(R.id.button10, View.GONE)
                setVisibility(R.id.button11, View.GONE)
                setVisibility(R.id.button12, View.VISIBLE)
                selected = R.id.imageView12
            }
            else -> return
        }

        val transition = MyTransition()
        TransitionManager.beginDelayedTransition(constraintLayout, transition)
        constraintSet.applyTo(constraintLayout)
    }

    fun animateOriginal() {
        val transition = MyTransition()
        TransitionManager.beginDelayedTransition(constraintLayout, transition)
        constraintSetOriginal.applyTo(constraintLayout)
        selected = -1
    }

    fun setVisibility(id: Int, visibility: Int) {
        constraintSet.setVisibility(id, visibility)
    }
}
