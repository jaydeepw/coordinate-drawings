package com.github.jaydeepw.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import android.util.AttributeSet
import android.util.Log
import android.view.View

class CoordinateView : View {

    private var canvas: Canvas? = null
    private var coordinates: List<Point>? = null

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        this.canvas = canvas

        drawCoordinates(coordinates)
    }

    fun setCoordinates(coordinates: List<Point>) {
        this.coordinates = coordinates
        invalidate()
    }

    fun drawCoordinates(
        list: List<Point>?
    ) {

        if (list == null) {
            return
        }

        val radius = 10
        val paint = Paint()
        paint.color = Color.parseColor("#FF0000")
        for (point in list) {
            canvas?.drawCircle(point.x.toFloat(), point.y.toFloat(), radius.toFloat(), paint)
        }

        Log.i("CustomView", "canvas $canvas")
    }

}