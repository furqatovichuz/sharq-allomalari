import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

import '../models/scholar.dart';
import '../theme/app_theme.dart';
import '../ui/category_ui.dart';
import 'svg_icon.dart';

/// `item_scholar.xml` ning Flutter ekvivalenti — asosiy va saralanganlar
/// ro'yxatlaridagi alloma kartochkasi.
class ScholarCard extends StatelessWidget {
  const ScholarCard({
    super.key,
    required this.scholar,
    required this.isFavorite,
    required this.onTap,
    required this.onFavoriteToggle,
  });

  final Scholar scholar;
  final bool isFavorite;
  final VoidCallback onTap;
  final VoidCallback onFavoriteToggle;

  @override
  Widget build(BuildContext context) {
    return Card(
      margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 6),
      child: InkWell(
        borderRadius: BorderRadius.circular(AppSpacing.cardCornerRadius),
        onTap: onTap,
        child: Padding(
          padding: const EdgeInsets.all(14),
          child: Row(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              ClipRRect(
                borderRadius: BorderRadius.circular(30),
                child: Container(
                  width: 60,
                  height: 60,
                  color: CategoryUi.color(scholar.primaryCategory),
                  child: SvgPicture.asset(
                    scholar.portraitRes,
                    fit: BoxFit.cover,
                  ),
                ),
              ),
              const SizedBox(width: 14),
              Expanded(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Row(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Expanded(
                          child: Text(
                            scholar.shortName,
                            maxLines: 2,
                            overflow: TextOverflow.ellipsis,
                            style: AppTheme.sectionTitle.copyWith(fontSize: 16),
                          ),
                        ),
                        SizedBox(
                          width: 32,
                          height: 32,
                          child: IconButton(
                            padding: EdgeInsets.zero,
                            onPressed: onFavoriteToggle,
                            icon: SvgIcon(
                              isFavorite
                                  ? 'assets/icons/ic_star_filled.svg'
                                  : 'assets/icons/ic_star_outline.svg',
                              size: 22,
                              color: AppColors.accent,
                            ),
                          ),
                        ),
                      ],
                    ),
                    const SizedBox(height: 2),
                    Text(
                      '${scholar.years} • ${scholar.birthPlace}',
                      maxLines: 1,
                      overflow: TextOverflow.ellipsis,
                      style: const TextStyle(
                        fontSize: 13,
                        color: AppColors.textSecondary,
                      ),
                    ),
                    const SizedBox(height: 4),
                    Text(
                      scholar.shortBio,
                      maxLines: 2,
                      overflow: TextOverflow.ellipsis,
                      style: const TextStyle(
                        fontSize: 13,
                        height: 1.2,
                        color: AppColors.textPrimary,
                      ),
                    ),
                    const SizedBox(height: 8),
                    Container(
                      padding: const EdgeInsets.symmetric(
                        horizontal: 10,
                        vertical: 3,
                      ),
                      decoration: BoxDecoration(
                        color: CategoryUi.color(scholar.primaryCategory),
                        borderRadius: BorderRadius.circular(10),
                      ),
                      child: Text(
                        scholar.primaryCategory.displayName,
                        style: const TextStyle(
                          fontSize: 11,
                          color: Colors.white,
                        ),
                      ),
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
