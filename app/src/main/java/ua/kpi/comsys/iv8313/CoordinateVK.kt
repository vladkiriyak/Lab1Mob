package ua.kpi.comsys.iv8313

import kotlin.math.abs
import kotlin.math.sign

@ExperimentalUnsignedTypes
class CoordinateVK() {

    var direction: Direction = Direction.EAST
    var degrees: Int = 0
    var minutes: UInt = 0u
    var seconds: UInt = 0u


    constructor(direction: Direction, degrees: Int, minutes: UInt, seconds: UInt): this() {

        this.direction = direction
        this.degrees = degrees
        this.minutes = minutes
        this.seconds = seconds
    }

    fun getDec(): Double {
        return sign(this.degrees.toDouble()) * (abs(this.degrees) +
                (this.minutes.toDouble() / 60.0) + (this.seconds.toDouble() / 3600.0))
    }


    fun getStr(): String {
        return "${this.degrees}°${this.minutes}'${this.seconds}''${this.direction}"

    }

    fun getDecStr(): String {
        return "${this.getDec()}" + "${this.direction}"
    }

    fun getAverageBtwThis(other: CoordinateVK): CoordinateVK? {
        if (this.direction != other.direction) {
            return null
        } else {
            return CoordinateVK(
                    this.direction,
                    (this.degrees + other.degrees) / 2,
                    (this.minutes + other.minutes) / 2u,
                    (this.seconds + other.seconds) / 2u

            )
        }

    }

    fun getAverage(first: CoordinateVK, other: CoordinateVK): CoordinateVK? {
        if (first.direction != other.direction) {
            return null
        } else {
            return CoordinateVK(
                    this.direction,
                    (first.degrees + other.degrees) / 2,
                    (first.minutes + other.minutes) / 2u,
                    (first.seconds + other.seconds) / 2u

            )
        }

    }

}