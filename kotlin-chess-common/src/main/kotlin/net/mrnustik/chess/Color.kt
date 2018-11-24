package net.mrnustik.chess

enum class Color {
    WHITE,
    BLACK,
    NONE;

    fun getOpositeColor() : Color {
        return when(this) {
            Color.WHITE -> Color.BLACK
            Color.BLACK -> Color.WHITE
            Color.NONE -> Color.NONE
        }
    }
}