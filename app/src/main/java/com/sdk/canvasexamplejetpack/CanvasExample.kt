package com.sdk.canvasexamplejetpack

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CanvasExample() {
    PieChart(
        points = listOf(30f, 50f, 60f, 150f),
        colors = listOf(Color.Blue, Color.Red, Color.Green, Color.Yellow)
    )
}

@Preview(showBackground = true, widthDp = 350, heightDp = 780)
@Composable
fun CanvasPreview() {
    CanvasExample()
}

@Composable
fun PieChart(
    points: List<Float>,
    colors: List<Color>
) {
    var totalSum = 0f
    for (element in points) {
        totalSum += element
    }
    val percentageWeight = points.map {
        it * 100 / totalSum
    }
    val percentageAngle = percentageWeight.map {
        it * 360 / 100
    }
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        var startAngle = 270f
        drawArc(
            color = colors[0],
            startAngle = startAngle,
            sweepAngle = percentageAngle[0],
            useCenter = true,
            size = Size(size.width, size.width)
        )
        startAngle += percentageAngle[0]
        drawArc(
            color = colors[1],
            startAngle = startAngle,
            sweepAngle = percentageAngle[1],
            useCenter = true,
            size = Size(size.width, size.width)
        )
        startAngle += percentageAngle[1]
        drawArc(
            color = colors[2],
            startAngle = startAngle,
            sweepAngle = percentageAngle[2],
            useCenter = true,
            size = Size(size.width, size.width)
        )
        startAngle += percentageAngle[2]
        drawArc(
            color = colors[3],
            startAngle = startAngle,
            sweepAngle = percentageAngle[3],
            useCenter = true,
            size = Size(size.width, size.width)
        )
    }
}

@Composable
fun Arc() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        drawArc(
            color = Color.Blue,
            startAngle = 270f,
            sweepAngle = 90f,
            useCenter = true,
            size = Size(size.width, size.height)
        )
    }
}

@Composable
fun Circle() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        drawCircle(
            color = Color.Green,
            radius = 200f
        )
        drawCircle(
            color = Color.Blue,
            radius = 100f,
            center = Offset(100f, 100f)
        )
        drawCircle(
            radius = 300f,
            center = Offset(300f, 300f),
            brush = Brush.radialGradient(
                colors = listOf(Color.Magenta, Color.Red, Color.Blue),
                radius = 300f,
                center = Offset(300f, 300f)
            )
        )
    }
}

@Composable
fun Rectangle() {
    val w = 500f
    val h = 500f
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        drawRect(
            color = Color.Red,
            size = Size(w, h),
            topLeft = Offset(x = center.x - w / 2, y = center.y - h / 2),
            style = Stroke(6f, cap = StrokeCap.Round)
        )
    }
}