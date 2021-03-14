package ua.kpi.comsys.iv8313

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    @ExperimentalUnsignedTypes
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cor = CoordinateVK()
        Log.d("test", cor.getStr())
        Log.d("test", cor.getDecStr())
        Log.d("test", cor.getAverageBtwThis(CoordinateVK())!!.getStr())
        Log.d("test", cor.getAverage(
                CoordinateVK(Direction.EAST, 10, 20u, 30u),
                CoordinateVK())!!.getStr())

        setContentView(R.layout.activity_main)
    }
}