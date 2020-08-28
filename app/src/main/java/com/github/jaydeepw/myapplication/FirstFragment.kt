package com.github.jaydeepw.myapplication

import android.graphics.Point
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_first.*
import java.util.*


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        drawRandomCoordinates()

        buttonRefresh.setOnClickListener {
            drawRandomCoordinates()
            drawRandomLines()
        }
    }

    private fun drawRandomCoordinates() {
        val list = getRandomCoordinates()
        coordinatesView.setCoordinates(list)
    }

    private fun drawRandomLines() {
        val xPoints = getRandomCoordinates()
        val yPoints = getRandomCoordinates()
        val list = mutableListOf<Pair<Point, Point>>()
        for (i in 5..25) {
            val pointX = xPoints[i]
            val pointY = yPoints[i]
            val pair = Pair(pointX, pointY)
            list.add(pair)
        }
        coordinatesView.setLines(list)
    }

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

}