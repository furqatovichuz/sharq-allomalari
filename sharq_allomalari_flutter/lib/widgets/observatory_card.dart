import 'package:flutter/material.dart';

import '../models/observatory.dart';
import '../theme/app_theme.dart';

/// `item_observatory.xml` ning Flutter ekvivalenti.
class ObservatoryCard extends StatelessWidget {
  const ObservatoryCard({
    super.key,
    required this.observatory,
    required this.onTap,
  });

  final Observatory observatory;
  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    final color = Color(
      int.parse(observatory.colorHex.substring(1), radix: 16) | 0xFF000000,
    );
    return Card(
      margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 6),
      clipBehavior: Clip.antiAlias,
      child: InkWell(
        onTap: onTap,
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Container(height: 6, color: color),
            Padding(
              padding: const EdgeInsets.all(16),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    observatory.name,
                    style: AppTheme.sectionTitle.copyWith(fontSize: 16),
                  ),
                  const SizedBox(height: 2),
                  Text(
                    '${observatory.location} • ${observatory.period}',
                    style: const TextStyle(
                      fontSize: 13,
                      color: AppColors.textSecondary,
                    ),
                  ),
                  const SizedBox(height: 8),
                  Text(
                    observatory.shortDesc,
                    style: const TextStyle(
                      fontSize: 13,
                      height: 1.15,
                      color: AppColors.textPrimary,
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
