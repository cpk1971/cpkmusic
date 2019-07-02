package cpk.cpkmusic.atoms

import cpk.cpkmusic.exceptions.InterpretationException
import kotlin.math.pow

/**
 * Represents a chromatic pitch, corresponding to MIDI note value, with octaves of 12 semitones
   with the following relations:

   <pre>
   f(x) / f(x-12) = 2
   f(x) / f(x-1) == 2.pow(1/12)
   </pre>

   with 69.0 corresponding to SFP A4, and 440 Hz

   References:
   <a href="https://en.wikipedia.org/wiki/Scientific_pitch_notation">Scientific pitch notation</a>
   <a href="https://en.wikipedia.org/wiki/A440_(pitch_standard)">A440</a>

 */
data class Pitch(val value: Double) {

    /** Corresponding midi value */
    val midi: Int
        get() = value.toInt()

    /** Corresponding SPN octave */
    val octave: Int
        get() = midi / 12 - 1

    /** How many semitones above C in this octave? */
    val offsetFromC: Int
        get() = midi % 12

    /** Frequency of this pitch in Hertz */
    val frequency: Double
        get() = 440.0 * 2.0.pow((value - 69.0) / 12.0)

    /** True if a rest */
    val isRest: Boolean
        get() = value < 0.0 && value.isInfinite()

    operator fun plus(y: Int): Pitch {
        return Pitch(value + y)
    }

    operator fun plus(y: Double): Pitch {
        return Pitch(value + y)
    }

    operator fun minus(y: Int): Pitch {
        return Pitch(value - y)
    }

    operator fun minus(y: Double): Pitch {
        return Pitch(value - y)
    }

    fun addOctave(count: Int): Pitch {
        return Pitch(value + count * 12)
    }

    fun parse(pitchSpec: String): Pitch {
        throw NotImplementedError("derp")
        /*
        
        if (pitchSpec.isEmpty()) {
            throw InterpretationException("empty string");
        }
        val root = pitchSpec.get(0).toLowerCase()
        if (! "abcdefg".contains(root)) {
            throw InterpretationException("not a note from a-g");
        }
        // for now we'll just support # and b
        // val accident = pitchSpec.get(1) in

         */
    }

    companion object {
        /** -Inf represents a rest */
        val Rest = Pitch(value = Double.NEGATIVE_INFINITY)
    }
}