import 'package:flutter/material.dart';

import '../theme/app_theme.dart';
import '../ui/about_screen.dart';
import '../ui/favorites_screen.dart';
import '../ui/glossary_screen.dart';
import '../ui/observatories_screen.dart';
import '../ui/quiz_screen.dart';
import '../ui/topics_screen.dart';
import 'svg_icon.dart';

/// Bosh sahifadagi alohida "Saralanganlar" va "Ilova haqida" tugmalari
/// o'rniga ishlatiladigan, ochilganda bo'limlari birma-bir suzib kiruvchi
/// animatsiyali hamburger menyu.
class AppMenuDrawer extends StatefulWidget {
  const AppMenuDrawer({
    super.key,
    required this.favoritesCount,
    required this.onFavoritesReturn,
  });

  final int favoritesCount;
  final VoidCallback onFavoritesReturn;

  @override
  State<AppMenuDrawer> createState() => _AppMenuDrawerState();
}

class _AppMenuDrawerState extends State<AppMenuDrawer>
    with SingleTickerProviderStateMixin {
  late final AnimationController _controller;

  @override
  void initState() {
    super.initState();
    _controller = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 500),
    )..forward();
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  Animation<double> _entrance(int index, int total) {
    final start = (index / (total + 1)).clamp(0.0, 1.0);
    final end = (start + 2 / (total + 1)).clamp(0.0, 1.0);
    return CurvedAnimation(
      parent: _controller,
      curve: Interval(start, end, curve: Curves.easeOutCubic),
    );
  }

  Future<void> _navigate(Widget screen, {bool isFavorites = false}) async {
    final navigator = Navigator.of(context);
    navigator.pop();
    await Future.delayed(const Duration(milliseconds: 180));
    await navigator.push(MaterialPageRoute(builder: (_) => screen));
    if (isFavorites) widget.onFavoritesReturn();
  }

  @override
  Widget build(BuildContext context) {
    final items = <_MenuItemData>[
      _MenuItemData(
        icon: 'assets/icons/ic_star_filled.svg',
        label: 'Saralanganlar',
        badge: widget.favoritesCount > 0 ? '${widget.favoritesCount}' : null,
        onTap: () => _navigate(const FavoritesScreen(), isFavorites: true),
      ),
      _MenuItemData(
        icon: 'assets/icons/ic_location.svg',
        label: 'Rasadxonalar',
        onTap: () => _navigate(const ObservatoriesScreen()),
      ),
      _MenuItemData(
        icon: 'assets/icons/ic_book.svg',
        label: 'Mavzular',
        onTap: () => _navigate(const TopicsScreen()),
      ),
      _MenuItemData(
        icon: 'assets/icons/ic_school.svg',
        label: 'Test',
        onTap: () => _navigate(const QuizScreen()),
      ),
      _MenuItemData(
        icon: 'assets/icons/ic_quote.svg',
        label: "Lug'at",
        onTap: () => _navigate(const GlossaryScreen()),
      ),
      _MenuItemData(
        icon: 'assets/icons/ic_info.svg',
        label: 'Ilova haqida',
        onTap: () => _navigate(const AboutScreen()),
      ),
    ];

    return Drawer(
      backgroundColor: AppColors.surface,
      width: 300,
      child: SafeArea(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            _DrawerHeader(controller: _controller),
            const SizedBox(height: 8),
            Expanded(
              child: ListView.builder(
                padding: const EdgeInsets.symmetric(vertical: 8),
                itemCount: items.length,
                itemBuilder: (context, index) {
                  final item = items[index];
                  final animation = _entrance(index, items.length);
                  return AnimatedBuilder(
                    animation: animation,
                    builder: (context, child) => Opacity(
                      opacity: animation.value,
                      child: Transform.translate(
                        offset: Offset((1 - animation.value) * 48, 0),
                        child: child,
                      ),
                    ),
                    child: _MenuTile(item: item),
                  );
                },
              ),
            ),
            const Padding(
              padding: EdgeInsets.symmetric(vertical: 16),
              child: Text(
                'Sharq Allomalari · v1.0',
                textAlign: TextAlign.center,
                style: TextStyle(fontSize: 11, color: AppColors.textSecondary),
              ),
            ),
          ],
        ),
      ),
    );
  }
}

class _DrawerHeader extends StatelessWidget {
  const _DrawerHeader({required this.controller});

  final AnimationController controller;

  @override
  Widget build(BuildContext context) {
    final scale = CurvedAnimation(
      parent: controller,
      curve: const Interval(0, 0.6, curve: Curves.easeOutBack),
    );
    return Container(
      padding: const EdgeInsets.fromLTRB(24, 28, 24, 24),
      decoration: const BoxDecoration(
        gradient: LinearGradient(
          begin: Alignment.topLeft,
          end: Alignment.bottomRight,
          colors: [AppColors.primary, AppColors.primaryDark],
        ),
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          ScaleTransition(
            scale: scale,
            child: Container(
              width: 64,
              height: 64,
              padding: const EdgeInsets.all(8),
              decoration: BoxDecoration(
                color: AppColors.surface,
                shape: BoxShape.circle,
                border: Border.all(color: AppColors.accent, width: 1.5),
              ),
              child: Image.asset('assets/images/Logo.png'),
            ),
          ),
          const SizedBox(height: 14),
          const Text(
            'Sharq Allomalari',
            style: TextStyle(
              fontFamily: AppTheme.serifFontFamily,
              fontWeight: FontWeight.bold,
              fontSize: 19,
              color: AppColors.textOnPrimary,
            ),
          ),
          const SizedBox(height: 4),
          const Text(
            "Buyuk allomalar va ularning ilmiy merosi",
            style: TextStyle(
              fontFamily: AppTheme.serifFontFamily,
              fontStyle: FontStyle.italic,
              fontSize: 12,
              color: AppColors.accentLight,
            ),
          ),
        ],
      ),
    );
  }
}

class _MenuItemData {
  const _MenuItemData({
    required this.icon,
    required this.label,
    required this.onTap,
    this.badge,
  });

  final String icon;
  final String label;
  final VoidCallback onTap;
  final String? badge;
}

class _MenuTile extends StatelessWidget {
  const _MenuTile({required this.item});

  final _MenuItemData item;

  @override
  Widget build(BuildContext context) {
    return Material(
      color: Colors.transparent,
      child: InkWell(
        onTap: item.onTap,
        child: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 13),
          child: Row(
            children: [
              Container(
                width: 38,
                height: 38,
                alignment: Alignment.center,
                decoration: BoxDecoration(
                  color: AppColors.surfaceAlt,
                  borderRadius: BorderRadius.circular(12),
                ),
                child: SvgIcon(
                  item.icon,
                  size: 19,
                  color: AppColors.primary,
                ),
              ),
              const SizedBox(width: 14),
              Expanded(
                child: Text(
                  item.label,
                  style: const TextStyle(
                    fontSize: 15,
                    fontWeight: FontWeight.w500,
                    color: AppColors.textPrimary,
                  ),
                ),
              ),
              if (item.badge != null)
                Container(
                  padding: const EdgeInsets.symmetric(
                    horizontal: 8,
                    vertical: 3,
                  ),
                  decoration: BoxDecoration(
                    color: AppColors.accent,
                    borderRadius: BorderRadius.circular(20),
                  ),
                  child: Text(
                    item.badge!,
                    style: const TextStyle(
                      fontSize: 11,
                      fontWeight: FontWeight.bold,
                      color: AppColors.textOnAccent,
                    ),
                  ),
                ),
            ],
          ),
        ),
      ),
    );
  }
}
