import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

import '../theme/app_theme.dart';
import 'detail_screen.dart';

/// Ilova, uning maqsadi va foydalanilgan ilmiy manba haqida qisqacha
/// ma'lumot beruvchi statik ekran (`AboutActivity` ekvivalenti).
class AboutScreen extends StatelessWidget {
  const AboutScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Ilova haqida')),
      body: ListView(
        padding: const EdgeInsets.all(20),
        children: [
          Container(
            width: 84,
            height: 84,
            margin: const EdgeInsets.only(bottom: 16),
            alignment: Alignment.center,
            decoration: const BoxDecoration(
              color: AppColors.primary,
              shape: BoxShape.circle,
            ),
            child: SvgPicture.asset(
              'assets/icons/ic_splash_logo.svg',
              width: 48,
              height: 48,
            ),
          ),
          const Text(
            'Sharq Allomalari',
            textAlign: TextAlign.center,
            style: TextStyle(
              fontFamily: AppTheme.serifFontFamily,
              fontWeight: FontWeight.bold,
              fontSize: 22,
              color: AppColors.primary,
            ),
          ),
          const SizedBox(height: 2),
          const Text(
            'Versiya 1.0',
            textAlign: TextAlign.center,
            style: TextStyle(fontSize: 12, color: AppColors.textSecondary),
          ),
          const SizedBox(height: 4),
          const Padding(
            padding: EdgeInsets.only(bottom: 24),
            child: Text(
              "O'rta asr Sharq astronomlari va olimlari",
              textAlign: TextAlign.center,
              style: TextStyle(
                fontFamily: AppTheme.serifFontFamily,
                fontStyle: FontStyle.italic,
                fontSize: 13,
                color: AppColors.accentDark,
              ),
            ),
          ),
          const SectionHeading('Ilova haqida'),
          const SizedBox(height: 8),
          const Padding(
            padding: EdgeInsets.only(bottom: 20),
            child: Text(
              '"Sharq Allomalari" ilovasi — O\'rta asrlarda Sharq mintaqasida, xususan '
              "Movarounnahr va Xorazmda yashab ijod etgan buyuk astronomlar, matematiklar "
              "va mutafakkirlarning ilmiy merosini o'rganish uchun mo'ljallangan ma'lumotnoma ilovadir.",
              style: TextStyle(
                fontSize: 14,
                height: 1.3,
                color: AppColors.textPrimary,
              ),
            ),
          ),
          const SectionHeading('Ilmiy markazlar'),
          const SizedBox(height: 8),
          Container(
            margin: const EdgeInsets.only(bottom: 20),
            padding: const EdgeInsets.all(16),
            decoration: BoxDecoration(
              color: AppColors.surface,
              borderRadius: BorderRadius.circular(16),
              border: Border.all(color: AppColors.divider),
            ),
            child: const Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Padding(
                  padding: EdgeInsets.only(bottom: 8),
                  child: Text(
                    '• Bog\'dod "Bayt al-Hikma" (Donishmandlik uyi) — IX asr',
                    style: TextStyle(
                      fontSize: 14,
                      color: AppColors.textPrimary,
                    ),
                  ),
                ),
                Padding(
                  padding: EdgeInsets.only(bottom: 8),
                  child: Text(
                    "• Xorazm Ma'mun akademiyasi — 1004–1017",
                    style: TextStyle(
                      fontSize: 14,
                      color: AppColors.textPrimary,
                    ),
                  ),
                ),
                Text(
                  '• Samarqand rasadxonasi — 1428–1449',
                  style: TextStyle(fontSize: 14, color: AppColors.textPrimary),
                ),
              ],
            ),
          ),
          const SectionHeading('Foydalanilgan manba'),
          const SizedBox(height: 8),
          const Text(
            'Fayzullayeva Saodat Dilshodovna "Vostochnaya astronomiya" — o\'quv '
            "qo'llanmasi (Navoiy, 2026) asosida tayyorlandi.",
            style: TextStyle(
              fontFamily: AppTheme.serifFontFamily,
              fontStyle: FontStyle.italic,
              fontSize: 13,
              height: 1.25,
              color: AppColors.textSecondary,
            ),
          ),
        ],
      ),
    );
  }
}
