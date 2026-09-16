import 'package:flutter/material.dart';

import '../data/favorites_manager.dart';
import '../data/scholar_repository.dart';
import '../models/scholar.dart';
import '../theme/app_theme.dart';
import '../widgets/app_menu_drawer.dart';
import '../widgets/scholar_card.dart';
import '../widgets/svg_icon.dart';
import 'detail_screen.dart';

/// Ilovaning asosiy ekrani: barcha allomalar ro'yxati, qidiruv maydoni
/// va soha bo'yicha filtr chip'lari (`MainActivity` ekvivalenti).
class MainScreen extends StatefulWidget {
  const MainScreen({super.key});

  @override
  State<MainScreen> createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen>
    with SingleTickerProviderStateMixin {
  final _favoritesManager = FavoritesManager();
  final _searchController = TextEditingController();
  final _scaffoldKey = GlobalKey<ScaffoldState>();
  late final AnimationController _menuIconController;

  ScholarCategory? _selectedCategory;
  String _query = '';
  Set<int> _favoriteIds = {};

  @override
  void initState() {
    super.initState();
    _menuIconController = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 320),
    );
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
    _menuIconController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final results = _filtered;

    return Scaffold(
      key: _scaffoldKey,
      endDrawer: AppMenuDrawer(
        favoritesCount: _favoriteIds.length,
        onFavoritesReturn: _refreshFavorites,
      ),
      onEndDrawerChanged: (isOpen) {
        if (isOpen) {
          _menuIconController.forward();
        } else {
          _menuIconController.reverse();
        }
      },
      body: CustomScrollView(
        slivers: [
          SliverAppBar(
            backgroundColor: AppColors.primary,
            pinned: true,
            expandedHeight: 168,
            title: Row(
              mainAxisSize: MainAxisSize.min,
              children: [
                Image.asset('assets/images/Logo.png', width: 28, height: 28),
                const SizedBox(width: 8),
                const Text('Sharq Allomalari'),
              ],
            ),
            actions: [
              IconButton(
                tooltip: 'Menyu',
                icon: AnimatedIcon(
                  icon: AnimatedIcons.menu_close,
                  progress: _menuIconController,
                  color: AppColors.textOnPrimary,
                ),
                onPressed: () => _scaffoldKey.currentState?.openEndDrawer(),
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
