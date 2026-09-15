import 'package:flutter/material.dart';

import '../data/favorites_manager.dart';
import '../data/scholar_repository.dart';
import '../models/scholar.dart';
import '../theme/app_theme.dart';
import '../widgets/scholar_card.dart';
import '../widgets/svg_icon.dart';
import 'detail_screen.dart';

/// Foydalanuvchi yulduzcha bilan belgilagan (saralangan) allomalar
/// ro'yxatini ko'rsatuvchi ekran (`FavoritesActivity` ekvivalenti).
class FavoritesScreen extends StatefulWidget {
  const FavoritesScreen({super.key});

  @override
  State<FavoritesScreen> createState() => _FavoritesScreenState();
}

class _FavoritesScreenState extends State<FavoritesScreen> {
  final _favoritesManager = FavoritesManager();
  Set<int> _favoriteIds = {};
  bool _loaded = false;

  @override
  void initState() {
    super.initState();
    _load();
  }

  Future<void> _load() async {
    final ids = await _favoritesManager.getFavoriteIds();
    if (!mounted) return;
    setState(() {
      _favoriteIds = ids;
      _loaded = true;
    });
  }

  Future<void> _toggleFavorite(Scholar scholar) async {
    await _favoritesManager.toggleFavorite(scholar.id);
    _load();
  }

  Future<void> _openDetail(Scholar scholar) async {
    await Navigator.of(context).push(
      MaterialPageRoute(builder: (_) => DetailScreen(scholarId: scholar.id)),
    );
    _load();
  }

  @override
  Widget build(BuildContext context) {
    final favorites = ScholarRepository.scholars
        .where((s) => _favoriteIds.contains(s.id))
        .toList();

    return Scaffold(
      appBar: AppBar(title: const Text('Saralangan allomalar')),
      body: !_loaded
          ? const SizedBox.shrink()
          : favorites.isEmpty
          ? Padding(
              padding: const EdgeInsets.all(40),
              child: Center(
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    const SvgIcon(
                      'assets/icons/ic_star_outline.svg',
                      size: 64,
                      color: AppColors.outline,
                    ),
                    const SizedBox(height: 16),
                    const Text(
                      "Saralanganlar ro'yxati bo'sh",
                      textAlign: TextAlign.center,
                      style: TextStyle(
                        fontFamily: AppTheme.serifFontFamily,
                        fontWeight: FontWeight.bold,
                        fontSize: 16,
                        color: AppColors.textPrimary,
                      ),
                    ),
                    const SizedBox(height: 8),
                    const Text(
                      "Olim profilidagi yulduzcha belgisini bosib, uni saralanganlarga qo'shing.",
                      textAlign: TextAlign.center,
                      style: TextStyle(
                        fontSize: 13,
                        color: AppColors.textSecondary,
                      ),
                    ),
                  ],
                ),
              ),
            )
          : ListView.builder(
              padding: const EdgeInsets.symmetric(vertical: 8),
              itemCount: favorites.length,
              itemBuilder: (context, index) {
                final scholar = favorites[index];
                return ScholarCard(
                  scholar: scholar,
                  isFavorite: true,
                  onTap: () => _openDetail(scholar),
                  onFavoriteToggle: () => _toggleFavorite(scholar),
                );
              },
            ),
    );
  }
}
