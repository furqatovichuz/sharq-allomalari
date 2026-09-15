import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:share_plus/share_plus.dart';

import '../data/favorites_manager.dart';
import '../data/scholar_repository.dart';
import '../models/scholar.dart';
import '../theme/app_theme.dart';
import '../widgets/info_row.dart';
import '../widgets/svg_icon.dart';
import 'category_ui.dart';

/// Tanlangan allomaning to'liq profili: tarjimai holi, asosiy asarlari,
/// ilmiy yutuqlari va (mavjud bo'lsa) mashhur iqtibosi (`DetailActivity`
/// ekvivalenti).
class DetailScreen extends StatefulWidget {
  const DetailScreen({super.key, required this.scholarId});

  final int scholarId;

  @override
  State<DetailScreen> createState() => _DetailScreenState();
}

class _DetailScreenState extends State<DetailScreen> {
  final _favoritesManager = FavoritesManager();
  bool _isFavorite = false;

  Scholar? get _scholar => ScholarRepository.getById(widget.scholarId);

  @override
  void initState() {
    super.initState();
    _loadFavorite();
  }

  Future<void> _loadFavorite() async {
    final fav = await _favoritesManager.isFavorite(widget.scholarId);
    if (!mounted) return;
    setState(() => _isFavorite = fav);
  }

  Future<void> _toggleFavorite() async {
    final nowFavorite = await _favoritesManager.toggleFavorite(
      widget.scholarId,
    );
    if (!mounted) return;
    setState(() => _isFavorite = nowFavorite);
  }

  void _share(Scholar scholar) {
    final text =
        '${scholar.fullName} (${scholar.years})\n\n${scholar.shortBio}\n\nManba: "Sharq Allomalari" ilovasi';
    SharePlus.instance.share(ShareParams(text: text));
  }

  @override
  Widget build(BuildContext context) {
    final scholar = _scholar;
    if (scholar == null) {
      return const Scaffold(body: SizedBox.shrink());
    }

    final categoryColor = CategoryUi.color(scholar.primaryCategory);

    return Scaffold(
      body: CustomScrollView(
        slivers: [
          SliverAppBar(
            pinned: true,
            expandedHeight: 270,
            backgroundColor: AppColors.primary,
            iconTheme: const IconThemeData(color: AppColors.textOnPrimary),
            actions: [
              IconButton(
                onPressed: _toggleFavorite,
                icon: SvgIcon(
                  _isFavorite
                      ? 'assets/icons/ic_star_filled.svg'
                      : 'assets/icons/ic_star_outline.svg',
                  color: AppColors.accent,
                ),
              ),
              IconButton(
                onPressed: () => _share(scholar),
                icon: const SvgIcon(
                  'assets/icons/ic_share.svg',
                  color: AppColors.textOnPrimary,
                ),
              ),
            ],
            flexibleSpace: FlexibleSpaceBar(
              background: Container(
                decoration: const BoxDecoration(
                  gradient: LinearGradient(
                    begin: Alignment(-0.7, -0.7),
                    end: Alignment(0.7, 0.7),
                    colors: [
                      AppColors.primaryLight,
                      AppColors.primary,
                      AppColors.primaryDark,
                    ],
                  ),
                ),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Container(
                      width: 92,
                      height: 92,
                      margin: const EdgeInsets.only(top: 36),
                      decoration: BoxDecoration(
                        shape: BoxShape.circle,
                        color: categoryColor,
                        border: Border.all(color: AppColors.accent, width: 2),
                        boxShadow: const [
                          BoxShadow(color: Colors.black26, blurRadius: 8),
                        ],
                      ),
                      clipBehavior: Clip.antiAlias,
                      child: SvgPicture.asset(
                        scholar.portraitRes,
                        fit: BoxFit.cover,
                      ),
                    ),
                    const SizedBox(height: 12),
                    Padding(
                      padding: const EdgeInsets.symmetric(horizontal: 32),
                      child: Text(
                        scholar.shortName,
                        textAlign: TextAlign.center,
                        maxLines: 2,
                        overflow: TextOverflow.ellipsis,
                        style: const TextStyle(
                          fontFamily: AppTheme.serifFontFamily,
                          fontWeight: FontWeight.bold,
                          fontSize: 20,
                          color: AppColors.textOnPrimary,
                        ),
                      ),
                    ),
                    const SizedBox(height: 4),
                    Padding(
                      padding: const EdgeInsets.only(bottom: 16),
                      child: Text(
                        scholar.years,
                        style: const TextStyle(
                          fontSize: 13,
                          color: AppColors.accentLight,
                        ),
                      ),
                    ),
                  ],
                ),
              ),
            ),
          ),
          SliverPadding(
            padding: const EdgeInsets.fromLTRB(20, 18, 20, 32),
            sliver: SliverList.list(
              children: [
                if (scholar.honorTitle != null)
                  Padding(
                    padding: const EdgeInsets.only(bottom: 16),
                    child: Text(
                      '“${scholar.honorTitle}”',
                      textAlign: TextAlign.center,
                      style: const TextStyle(
                        fontFamily: AppTheme.serifFontFamily,
                        fontStyle: FontStyle.italic,
                        fontSize: 14,
                        color: AppColors.accentDark,
                      ),
                    ),
                  ),
                Container(
                  margin: const EdgeInsets.only(bottom: 20),
                  padding: const EdgeInsets.all(16),
                  decoration: BoxDecoration(
                    color: AppColors.surface,
                    borderRadius: BorderRadius.circular(16),
                    border: Border.all(color: AppColors.divider),
                  ),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      _InfoLine(
                        icon: 'assets/icons/ic_location.svg',
                        text: scholar.birthPlace,
                      ),
                      const Padding(
                        padding: EdgeInsets.symmetric(vertical: 10),
                        child: Divider(height: 1, color: AppColors.divider),
                      ),
                      _InfoLine(
                        icon: 'assets/icons/ic_school.svg',
                        text: scholar.academy,
                      ),
                      const Padding(
                        padding: EdgeInsets.symmetric(vertical: 10),
                        child: Divider(height: 1, color: AppColors.divider),
                      ),
                      Row(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          const Padding(
                            padding: EdgeInsets.only(top: 2),
                            child: SvgIcon(
                              'assets/icons/ic_astronomy.svg',
                              size: 20,
                              color: AppColors.primary,
                            ),
                          ),
                          const SizedBox(width: 8),
                          Expanded(
                            child: Wrap(
                              spacing: 6,
                              runSpacing: 6,
                              children: [
                                for (final category in scholar.categories)
                                  Container(
                                    padding: const EdgeInsets.symmetric(
                                      horizontal: 10,
                                      vertical: 4,
                                    ),
                                    decoration: BoxDecoration(
                                      color: CategoryUi.color(category),
                                      borderRadius: BorderRadius.circular(16),
                                    ),
                                    child: Text(
                                      category.displayName,
                                      style: const TextStyle(
                                        fontSize: 12,
                                        color: Colors.white,
                                      ),
                                    ),
                                  ),
                              ],
                            ),
                          ),
                        ],
                      ),
                    ],
                  ),
                ),
                const SectionHeading('Hayoti va faoliyati'),
                const SizedBox(height: 8),
                Padding(
                  padding: const EdgeInsets.only(bottom: 20),
                  child: Text(
                    scholar.biography,
                    style: const TextStyle(
                      fontSize: 15,
                      height: 1.3,
                      color: AppColors.textPrimary,
                    ),
                  ),
                ),
                const SectionHeading('Asosiy asarlari'),
                const SizedBox(height: 8),
                Container(
                  margin: const EdgeInsets.only(bottom: 20),
                  padding: const EdgeInsets.all(16),
                  decoration: BoxDecoration(
                    color: AppColors.surface,
                    borderRadius: BorderRadius.circular(16),
                    border: Border.all(color: AppColors.divider),
                  ),
                  child: Column(
                    children: [
                      for (final work in scholar.works)
                        InfoRow(
                          iconAsset: 'assets/icons/ic_book.svg',
                          text: work,
                          iconColor: AppColors.fieldMathematics,
                        ),
                    ],
                  ),
                ),
                const SectionHeading('Ilmiy yutuqlari'),
                const SizedBox(height: 8),
                Container(
                  margin: const EdgeInsets.only(bottom: 20),
                  padding: const EdgeInsets.all(16),
                  decoration: BoxDecoration(
                    color: AppColors.surface,
                    borderRadius: BorderRadius.circular(16),
                    border: Border.all(color: AppColors.divider),
                  ),
                  child: Column(
                    children: [
                      for (final achievement in scholar.achievements)
                        InfoRow(
                          iconAsset: 'assets/icons/ic_award.svg',
                          text: achievement,
                          iconColor: AppColors.accentDark,
                        ),
                    ],
                  ),
                ),
                if (scholar.quote != null)
                  Container(
                    padding: const EdgeInsets.all(16),
                    decoration: BoxDecoration(
                      color: AppColors.surface,
                      borderRadius: BorderRadius.circular(16),
                      border: Border.all(color: AppColors.outline),
                    ),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        const SvgIcon(
                          'assets/icons/ic_quote.svg',
                          size: 22,
                          color: AppColors.accent,
                        ),
                        const SizedBox(height: 8),
                        Text(
                          '“${scholar.quote}”',
                          style: const TextStyle(
                            fontFamily: AppTheme.serifFontFamily,
                            fontStyle: FontStyle.italic,
                            fontSize: 14,
                            height: 1.25,
                            color: AppColors.textPrimary,
                          ),
                        ),
                        const SizedBox(height: 8),
                        const Text(
                          "Olim so'zlaridan",
                          style: TextStyle(
                            fontSize: 12,
                            color: AppColors.textSecondary,
                          ),
                        ),
                      ],
                    ),
                  ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}

class _InfoLine extends StatelessWidget {
  const _InfoLine({required this.icon, required this.text});

  final String icon;
  final String text;

  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        SvgIcon(icon, size: 20, color: AppColors.primary),
        const SizedBox(width: 12),
        Expanded(
          child: Text(
            text,
            style: const TextStyle(fontSize: 14, color: AppColors.textPrimary),
          ),
        ),
      ],
    );
  }
}

class SectionHeading extends StatelessWidget {
  const SectionHeading(this.text, {super.key});

  final String text;

  @override
  Widget build(BuildContext context) {
    return Text(text, style: AppTheme.sectionTitle);
  }
}
