package uz.edu.sharqallomalari.model

/**
 * Lug'at (glossariy) atamasi modeli.
 *
 * @param term         Atama nomi
 * @param definition   Atamaning ta'rifi
 */
data class GlossaryTerm(
    val term: String,
    val definition: String
)
