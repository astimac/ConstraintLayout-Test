package com.astimac.constraintlayouttest

import android.transition.ChangeBounds
import android.transition.Fade
import android.transition.TransitionSet
import android.view.animation.OvershootInterpolator

/**
 * Created by astimac on 08.02.18..
 */
class MyTransition : TransitionSet() {
    init {
        duration = 300
        ordering = ORDERING_TOGETHER

        val changeBounds = ChangeBounds()
        changeBounds.interpolator = OvershootInterpolator()

        val fadeOut = Fade(Fade.OUT)
        fadeOut.duration = 10

        val fadeIn = Fade(Fade.IN)
        fadeIn.startDelay = 200
        fadeIn.duration = 100

        addTransition(TransitionSet()
                //.addTransition(fadeOut)
                .addTransition(changeBounds)
                .addTransition(fadeIn)
        )
    }
}