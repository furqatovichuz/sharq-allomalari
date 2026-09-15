import 'package:shared_preferences/shared_preferences.dart';

/// Foydalanuvchi saralagan (yulduzcha bilan belgilangan) allomalar
/// identifikatorlarini `SharedPreferences` yordamida saqlaydigan sinf.
class FavoritesManager {
  static const _prefsKey = 'favorite_scholar_ids';

  Future<Set<int>> getFavoriteIds() async {
    final prefs = await SharedPreferences.getInstance();
    final stored = prefs.getStringList(_prefsKey) ?? const [];
    return stored.map(int.parse).toSet();
  }

  Future<bool> isFavorite(int scholarId) async {
    final ids = await getFavoriteIds();
    return ids.contains(scholarId);
  }

  /// Holatni almashtiradi va yangi holatni qaytaradi (endi saralanganmi).
  Future<bool> toggleFavorite(int scholarId) async {
    final ids = await getFavoriteIds();
    final nowFavorite = !ids.contains(scholarId);
    if (nowFavorite) {
      ids.add(scholarId);
    } else {
      ids.remove(scholarId);
    }
    final prefs = await SharedPreferences.getInstance();
    await prefs.setStringList(_prefsKey, ids.map((e) => e.toString()).toList());
    return nowFavorite;
  }
}
