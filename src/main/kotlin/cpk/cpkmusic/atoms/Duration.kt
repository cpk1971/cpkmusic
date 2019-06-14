package cpk.cpkmusic.atoms

import java.lang.IllegalArgumentException


/**
 *  Represents mensural duration.
 *
 *  A value of 1.0 means a duration of an entire measure.
 *  0.5 corresponds to a half note, and so on.
 *
 *  <a href="https://en.wikipedia.org/wiki/Mensural_notation">Reference</a>
 */
data class Duration(val value: Double) {
    /** <a href="https://en.wikipedia.org/wiki/Dotted_note">"Dots"</a> a duration,
     * which extends the duration by one-half. */
    fun dotted(times: Int = 1): Duration = (1..times).fold(this) { r, _ -> r * 1.5 }

    /**
     * Creates a <a href="https://en.wikipedia.org/wiki/Tuplet">tuplet</a> of n degrees.
     *
     * An odd degree represents (n-1)/n times the duration.
     * An even degree reprents 3/(2n) times the duration.
     *
     */
    fun tuplet(degree: Int): Duration {
        if (degree < 2) {
            throw IllegalArgumentException("a tuplet must be of at least degree 2")
        }
        // even degree
        if (degree % 2 == 0) {
            return this * 3.0 / (2.0 * degree.toDouble())
        } else { // odd degree
            val asDouble = degree.toDouble()
            return this * (asDouble - 1.0) / asDouble
        }
    }

    /** Shorthand for tuplet(3) */
    fun triplet(): Duration {
        return tuplet(3)
    }

    operator fun plus(y: Duration): Duration {
        return Duration(value + y.value)
    }

    operator fun plus(y: Double): Duration {
        return Duration(value + y)
    }

    operator fun div(y: Double): Duration {
        return Duration(value / y)
    }

    operator fun times(y: Double): Duration {
        return Duration(value * y)
    }

    companion object {
        val Maxima = Duration(8.0)
        val Longa = Duration(4.0)
        val Breve = Duration(2.0)
        val SemiBreve = Duration(1.0)
        val Minim = Duration(1.0 / 2.0)
        val Crotchet = Duration(1.0 / 4.0)
        val Quaver = Duration(1.0 / 8.0)
        val SemiQuaver = Duration(1.0 / 16.0)
        val DemiSemiQuaver = Duration(1.0 / 32.0)
        val HemiDemiSemiQuaver = Duration(1.0 / 64.0)
        val SemiHemiDemiSemiQuaver = Duration(1.0 / 128.0)
        val DemiSemiHemiDemiSemiQuaver = Duration(1.0 / 256.0)

        val Whole = SemiBreve
        val Half = Minim
        val Quarter = Crotchet
        val Eighth = Quaver
        val Sixteenth = SemiQuaver
        val ThirtySecond = DemiSemiQuaver
        val SixtyFourth = HemiDemiSemiQuaver
        val HundredTwentyEighth = SemiHemiDemiSemiQuaver
        val TwoHundredFiftySixth = DemiSemiHemiDemiSemiQuaver
    }
}