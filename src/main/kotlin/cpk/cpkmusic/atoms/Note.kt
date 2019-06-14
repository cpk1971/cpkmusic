package cpk.cpkmusic.atoms

data class Note(val pitch: Pitch, val duration: Duration) {
    operator fun plus(y: Double): Note {
        return Note(pitch + y, duration)
    }

    operator fun plus(y: Int): Note {
        return Note(pitch + y, duration)
    }

    operator fun minus(y: Double): Note {
        return Note(pitch - y, duration)
    }

    operator fun minus(y: Int): Note {
        return Note(pitch - y, duration)
    }

    operator fun times(y: Double): Note {
        return Note(pitch, duration * y)
    }

    operator fun div(y: Double): Note {
        return Note(pitch, duration / y)
    }
}