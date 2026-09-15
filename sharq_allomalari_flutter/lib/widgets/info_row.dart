import 'package:flutter/material.dart';

import '../theme/app_theme.dart';
import 'svg_icon.dart';

/// `item_work.xml` / `item_achievement.xml` / `item_topic_question.xml`
/// uslubidagi ikon + matn qatori.
class InfoRow extends StatelessWidget {
  const InfoRow({
    super.key,
    required this.iconAsset,
    required this.text,
    this.iconColor = AppColors.fieldMathematics,
  });

  final String iconAsset;
  final String text;
  final Color iconColor;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 8),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Padding(
            padding: const EdgeInsets.only(top: 2),
            child: SvgIcon(iconAsset, size: 18, color: iconColor),
          ),
          const SizedBox(width: 12),
          Expanded(
            child: Text(
              text,
              style: const TextStyle(
                fontSize: 14,
                height: 1.3,
                color: AppColors.textPrimary,
              ),
            ),
          ),
        ],
      ),
    );
  }
}

/// Nazorat savoli qatori (`item_topic_question.xml`): "1." + matn.
class IndexedTextRow extends StatelessWidget {
  const IndexedTextRow({super.key, required this.index, required this.text});

  final int index;
  final String text;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 6),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          SizedBox(
            width: 24,
            child: Text(
              '$index.',
              style: const TextStyle(
                fontSize: 14,
                fontWeight: FontWeight.bold,
                color: AppColors.accentDark,
              ),
            ),
          ),
          Expanded(
            child: Text(
              text,
              style: const TextStyle(
                fontSize: 14,
                height: 1.3,
                color: AppColors.textPrimary,
              ),
            ),
          ),
        ],
      ),
    );
  }
}
