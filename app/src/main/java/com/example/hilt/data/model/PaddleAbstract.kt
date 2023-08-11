package com.example.hilt.data.model

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.view.MotionEvent
import com.example.hilt.ui.main.interfaces.PaddleAbstractOperation

abstract class PaddleAbstract(private val side: Side, x: Float, y: Float, difficulty: Difficulty):PaddleAbstractOperation {
    var paddleX = x
        internal set
    var paddleY = y

    var height: Float = 500f
    val width: Float = 50f

    init {
        paddleY -= height / 2f
        height = when (difficulty) {
            Difficulty.EASY, Difficulty.MEDIUM -> 500f
            Difficulty.HARD -> 300f
        }
    }

   override fun updatePosition(newPos: Float) {
        paddleY = newPos
    }

   override fun draw(canvas: Canvas) {
        val rect: RectF = when (side) {
            Side.A -> {
                RectF(paddleX, paddleY, paddleX + width, paddleY + height)
            }
            Side.B -> {
                RectF(paddleX - width, paddleY, paddleX + width, paddleY + height)
            }
        }
        canvas.drawRect(
            rect,
            Paint().also {
                it.setARGB(255, 21, 37, 69)
            }
        )
    }

    abstract fun movePaddle(event: MotionEvent, index: Int, height: Int)

}

enum class Side {
    A,
    B
}

