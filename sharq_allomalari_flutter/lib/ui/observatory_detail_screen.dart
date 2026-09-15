import 'package:flutter/material.dart';

import '../data/observatory_repository.dart';
import '../theme/app_theme.dart';
import '../widgets/info_row.dart';
import 'detail_screen.dart';

/// Tanlangan rasadxonaning to'liq tavsifi, asosiy faktlari va u yerda
/// faoliyat yuritgan olimlar haqida ma'lumot ko'rsatadigan ekran
/// (`ObservatoryDetailActivity` ekvivalenti).
class ObservatoryDetailScreen extends StatelessWidget {
  const ObservatoryDetailScreen({super.key, required this.observatoryId});

  final int observatoryId;

  @override
  Widget build(BuildContext context) {
    final observatory = ObservatoryRepository.getById(observatoryId);
    if (observatory == null) {
      return const Scaffold(body: SizedBox.shrink());
    }

    final color = Color(
      int.parse(observatory.colorHex.substring(1), radix: 16) | 0xFF000000,
    );

    return Scaffold(
      appBar: AppBar(title: Text(observatory.name)),
      body: ListView(
        padding: const EdgeInsets.all(20),
        children: [
          Container(
            height: 80,
            decoration: BoxDecoration(
              color: color,
              borderRadius: BorderRadius.circular(16),
            ),
          ),
          const SizedBox(height: 16),
          Text(observatory.name, style: AppTheme.headlineSerif),
          const SizedBox(height: 4),
          Text(
            observatory.location,
            style: const TextStyle(
              fontSize: 14,
              color: AppColors.textSecondary,
            ),
          ),
          const SizedBox(height: 2),
          Text(
            observatory.period,
            style: const TextStyle(
              fontSize: 13,
              fontStyle: FontStyle.italic,
              color: AppColors.accentDark,
            ),
          ),
          const SizedBox(height: 16),
          Text(
            observatory.description,
            style: const TextStyle(
              fontSize: 14,
              height: 1.3,
              color: AppColors.textPrimary,
            ),
          ),
          const SizedBox(height: 20),
          const SectionHeading('Asosiy faktlar'),
          const SizedBox(height: 8),
          for (final fact in observatory.keyFacts)
            InfoRow(
              iconAsset: 'assets/icons/ic_award.svg',
              text: fact,
              iconColor: AppColors.accentDark,
            ),
          const SizedBox(height: 20),
          const SectionHeading('Faoliyat yuritgan olimlar'),
          const SizedBox(height: 8),
          Text(
            observatory.scholars,
            style: const TextStyle(
              fontSize: 14,
              height: 1.25,
              color: AppColors.textPrimary,
            ),
          ),
        ],
      ),
    );
  }
}
