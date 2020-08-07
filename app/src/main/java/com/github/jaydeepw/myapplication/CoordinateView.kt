package com.github.jaydeepw.myapplication

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import java.util.*

class CoordinateView : View {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private fun getRandomCoordinates(): List<Point> {
        val list = mutableListOf<Point>()
        val startPoint = Point(5, 5)
        for (i in 1..29) {
            val x = startPoint.x * Random().nextInt(10) * i
            val y = startPoint.y * Random().nextInt(10) * i
            val point = Point(x, y)
            list.add(point)
        }
        return list
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val list = getRandomCoordinates()
        drawCoordinates(canvas, list)
    }

    private fun drawCoordinates(
        canvas: Canvas?,
        list: List<Point>
    ) {
        val radius = 10
        val paint = Paint()
        paint.color = Color.parseColor("#FF0000")
        for (point in list) {
            canvas?.drawCircle(point.x.toFloat(), point.y.toFloat(), radius.toFloat(), paint)
        }
    }

}