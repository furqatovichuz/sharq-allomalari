package uz.edu.sharqallomalari.data

import android.content.Context

/**
 * Foydalanuvchi saralagan (yulduzcha bilan belgilangan) allomalar
 * identifikatorlarini SharedPreferences yordamida saqlaydigan sinf.
 */
class FavoritesManager(context: Context) {

    private val prefs = context.applicationContext
        .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun isFavorite(scholarId: Int): Boolean =
        getFavoriteIds().contains(scholarId)

    fun toggleFavorite(scholarId: Int): Boolean {
        val current = getFavoriteIds().toMutableSet()
        val nowFavorite: Boolean
        if (current.contains(scholarId)) {
            current.remove(scholarId)
            nowFavorite = false
        } else {
            current.add(scholarId)
            nowFavorite = true
        }
        saveFavoriteIds(current)
        return nowFavorite
    }

    fun getFavoriteIds(): Set<Int> =
        prefs.getStringSet(KEY_FAVORITES, emptySet())
            ?.mapNotNull { it.toIntOrNull() }
            ?.toSet()
            ?: emptySet()

    private fun saveFavoriteIds(ids: Set<Int>) {
        prefs.edit()
            .putStringSet(KEY_FAVORITES, ids.map { it.toString() }.toSet())
            .apply()
    }

    companion object {
        private const val PREFS_NAME = "sharq_allomalari_prefs"
        private const val KEY_FAVORITES = "favorite_scholar_ids"
    }
}
