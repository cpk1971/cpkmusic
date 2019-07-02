package cpk.cpkmusic.atoms.note

enum class Articulation {
    /** No particular articulation */
    NEUTRAL,
    /** Play the note slightly shorter than notated, perhaps half the value, or use a high decay value */
    STACCATO,
    /** Play the note markedly shorter, use an extremely high decay value */
    SPICCATO,
    /** Play the note either louder or with a markedly higher attack value */
    ACCENT,
    /** Play the note significantly louder or with an extremely higher attack value */
    MARCATO,
    /** Play the note slightly longer, or with a high sustain value */
    TENUTO,
    /** A combination of TENUTO and STACCATO. Generally, both higher sustain and decay */
    PORTATO,
    /** Play the note markedly longer, or with a significantly higher sustain value */
    FERMATO
}