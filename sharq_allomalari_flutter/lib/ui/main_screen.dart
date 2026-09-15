import 'package:flutter/material.dart';

import '../data/favorites_manager.dart';
import '../data/scholar_repository.dart';
import '../models/scholar.dart';
import '../theme/app_theme.dart';
import '../widgets/scholar_card.dart';
import '../widgets/svg_icon.dart';
import 'about_screen.dart';
import 'detail_screen.dart';
import 'favorites_screen.dart';
import 'glossary_screen.dart';
import 'observatories_screen.dart';
import 'quiz_screen.dart';
import 'topics_screen.dart';

/// Ilovaning asosiy ekrani: barcha allomalar ro'yxati, qidiruv maydoni
/// va soha bo'yicha filtr chip'lari (`MainActivity` ekvivalenti).
class MainScreen extends StatefulWidget {
  const MainScreen({super.key});

  @override
  State<MainScreen> createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  final _favoritesManager = FavoritesManager();
  final _searchController = TextEditingController();

  ScholarCategory? _selectedCategory;
  String _query = '';
  Set<int> _favoriteIds = {};

  @override
  void initState() {
    super.initState();
    _refreshFavorites();
    _searchController.addListener(() {
      setState(() => _query = _searchController.text);
    });
  }

  Future<void> _refreshFavorites() async {
    final ids = await _favoritesManager.getFavoriteIds();
    if (!mounted) return;
    setState(() => _favoriteIds = ids);
  }

  Future<void> _toggleFavorite(Scholar scholar) async {
    await _favoritesManager.toggleFavorite(scholar.id);
    await _refreshFavorites();
  }

  List<Scholar> get _filtered {
    final byCategory = ScholarRepository.getByCategory(_selectedCategory);
    if (_query.trim().isEmpty) return byCategory;
    final q = _query.trim().toLowerCase();
    return byCategory
        .where(
          (s) =>
              s.fullName.toLowerCase().contains(q) ||
              s.shortName.toLowerCase().contains(q) ||
              s.academy.toLowerCase().contains(q) ||
              s.categories.any((c) => c.displayName.toLowerCase().contains(q)),
        )
        .toList();
  }

  Future<void> _openDetail(Scholar scholar) async {
    await Navigator.of(context).push(
      MaterialPageRoute(builder: (_) => DetailScreen(scholarId: scholar.id)),
    );
    _refreshFavorites();
  }

  @override
  void dispose() {
    _searchController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final results = _filtered;

    return Scaffold(
      body: CustomScrollView(
        slivers: [
          SliverAppBar(
            backgroundColor: AppColors.primary,
            pinned: true,
            expandedHeight: 168,
            title: const Text('Sharq Allomalari'),
            actions: [
              IconButton(
                icon: const SvgIcon(
                  'assets/icons/ic_star_filled.svg',
                  color: AppColors.textOnPrimary,
                ),
                tooltip: 'Saralanganlar',
                onPressed: () async {
                  await Navigator.of(context).push(
                    MaterialPageRoute(builder: (_) => const FavoritesScreen()),
                  );
                  _refreshFavorites();
                },
              ),
              PopupMenuButton<VoidCallback>(
                icon: const SvgIcon(
                  'assets/icons/ic_info.svg',
                  color: AppColors.textOnPrimary,
                ),
                onSelected: (action) => action(),
                itemBuilder: (context) => [
                  PopupMenuItem(
                    value: () => Navigator.of(context).push(
                      MaterialPageRoute(
                        builder: (_) => const ObservatoriesScreen(),
                      ),
                    ),
                    child: const Text('Rasadxonalar'),
                  ),
                  PopupMenuItem(
                    value: () => Navigator.of(context).push(
                      MaterialPageRoute(builder: (_) => const TopicsScreen()),
                    ),
                    child: const Text('Mavzular'),
                  ),
                  PopupMenuItem(
                    value: () => Navigator.of(context).push(
                      MaterialPageRoute(builder: (_) => const QuizScreen()),
                    ),
                    child: const Text('Test'),
                  ),
                  PopupMenuItem(
                    value: () => Navigator.of(context).push(
                      MaterialPageRoute(builder: (_) => const GlossaryScreen()),
                    ),
                    child: const Text("Lug'at"),
                  ),
                  PopupMenuItem(
                    value: () => Navigator.of(context).push(
                      MaterialPageRoute(builder: (_) => const AboutScreen()),
                    ),
                    child: const Text('Ilova haqida'),
                  ),
                ],
              ),
            ],
            flexibleSpace: FlexibleSpaceBar(
              background: Container(
                color: AppColors.primary,
                padding: const EdgeInsets.fromLTRB(20, 56, 20, 18),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  mainAxisAlignment: MainAxisAlignment.end,
                  children: [
                    const Text(
                      "Buyuk allomalar va ularning ilmiy merosi",
                      style: TextStyle(
                        fontFamily: AppTheme.serifFontFamily,
                        fontStyle: FontStyle.italic,
                        fontSize: 14,
                        color: AppColors.accentLight,
                      ),
                    ),
                    const SizedBox(height: 14),
                    Container(
                      height: 48,
                      padding: const EdgeInsets.symmetric(horizontal: 14),
                      decoration: BoxDecoration(
                        color: AppColors.surface,
                        borderRadius: BorderRadius.circular(16),
                        border: Border.all(color: AppColors.outline),
                      ),
                      child: Row(
                        children: [
                          const SvgIcon(
                            'assets/icons/ic_search.svg',
                            size: 20,
                            color: AppColors.textSecondary,
                          ),
                          const SizedBox(width: 10),
                          Expanded(
                            child: TextField(
                              controller: _searchController,
                              style: const TextStyle(
                                color: AppColors.textPrimary,
                                fontSize: 15,
                              ),
                              decoration: const InputDecoration(
                                border: InputBorder.none,
                                isCollapsed: true,
                                hintText: "Olim ismini qidirish…",
                                hintStyle: TextStyle(
                                  color: AppColors.textSecondary,
                                ),
                              ),
                            ),
                          ),
                          if (_query.isNotEmpty)
                            GestureDetector(
                              onTap: () => _searchController.clear(),
                              child: const SvgIcon(
                                'assets/icons/ic_close.svg',
                                size: 22,
                                color: AppColors.textSecondary,
                              ),
                            ),
                        ],
                      ),
                    ),
                  ],
                ),
              ),
            ),
          ),
          SliverToBoxAdapter(
            child: SizedBox(
              height: 48,
              child: ListView(
                scrollDirection: Axis.horizontal,
                padding: const EdgeInsets.only(
                  left: 16,
                  top: 14,
                  bottom: 6,
                  right: 8,
                ),
                children: [
                  _FilterChip(
                    label: 'Barchasi',
                    selected: _selectedCategory == null,
                    onTap: () => setState(() => _selectedCategory = null),
                  ),
                  for (final category in ScholarCategory.values)
                    Padding(
                      padding: const EdgeInsets.only(left: 8),
                      child: _FilterChip(
                        label: category.displayName,
                        selected: _selectedCategory == category,
                        onTap: () =>
                            setState(() => _selectedCategory = category),
                      ),
                    ),
                ],
              ),
            ),
          ),
          SliverToBoxAdapter(
            child: Padding(
              padding: const EdgeInsets.only(left: 20, top: 6, bottom: 4),
              child: Text(
                'Jami ${results.length} alloma',
                style: const TextStyle(
                  fontSize: 12,
                  color: AppColors.textSecondary,
                ),
              ),
            ),
          ),
          if (results.isEmpty)
            SliverToBoxAdapter(
              child: Padding(
                padding: const EdgeInsets.all(40),
                child: Column(
                  children: [
                    const SvgIcon(
                      'assets/icons/ic_search.svg',
                      size: 56,
                      color: AppColors.outline,
                    ),
                    const SizedBox(height: 12),
                    const Text(
                      'Hech narsa topilmadi',
                      style: TextStyle(
                        color: AppColors.textSecondary,
                        fontSize: 14,
                      ),
                    ),
                  ],
                ),
              ),
            )
          else
            SliverPadding(
              padding: const EdgeInsets.only(bottom: 24),
              sliver: SliverList.builder(
                itemCount: results.length,
                itemBuilder: (context, index) {
                  final scholar = results[index];
                  return ScholarCard(
                    scholar: scholar,
                    isFavorite: _favoriteIds.contains(scholar.id),
                    onTap: () => _openDetail(scholar),
                    onFavoriteToggle: () => _toggleFavorite(scholar),
                  );
                },
              ),
            ),
        ],
      ),
    );
  }
}

class _FilterChip extends StatelessWidget {
  const _FilterChip({
    required this.label,
    required this.selected,
    required this.onTap,
  });

  final String label;
  final bool selected;
  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    return ChoiceChip(
      label: Text(label),
      selected: selected,
      onSelected: (_) => onTap(),
      backgroundColor: AppColors.surface,
      selectedColor: AppColors.primary,
      labelStyle: TextStyle(
        color: selected ? AppColors.textOnPrimary : AppColors.textPrimary,
        fontSize: 13,
      ),
      side: BorderSide(color: selected ? AppColors.primary : AppColors.outline),
      shape: const StadiumBorder(),
    );
  }
}
