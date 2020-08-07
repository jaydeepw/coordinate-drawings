package com.github.jaydeepw.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import android.util.AttributeSet
import android.view.View

class CoordinateView : View {

    private var coordinates: List<Point>? = null
    private var colors = listOf(
        "#FF0000",
        "#00FF00",
        "#0000FF"
    )

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        drawCoordinates(canvas, coordinates)
    }

    fun setCoordinates(coordinates: List<Point>) {
        this.coordinates = coordinates
        invalidate()
    }

    private fun drawCoordinates(
        canvas: Canvas?,
        list: List<Point>?
    ) {

        if (list == null) {
            return
        }

        val radius = 15
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        for (point in list) {
            paint.color = Color.parseColor(colors.random())
            canvas?.drawCircle(point.x.toFloat(), point.y.toFloat(), radius.toFloat(), paint)
        }
    }

}