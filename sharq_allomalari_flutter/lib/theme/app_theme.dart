import 'package:flutter/material.dart';

/// `colors.xml` / `dimens.xml` / `themes.xml` dagi dizayn tizimining
/// to'g'ridan-to'g'ri Flutter ekvivalenti.
class AppColors {
  AppColors._();

  // Asosiy palitra
  static const primary = Color(0xFF1B2A4A);
  static const primaryDark = Color(0xFF101A30);
  static const primaryLight = Color(0xFF324875);
  static const accent = Color(0xFFD4AF37);
  static const accentLight = Color(0xFFF0D78C);
  static const accentDark = Color(0xFFA9841E);

  // Fon va sirt ranglari
  static const background = Color(0xFFF7F3EA);
  static const surface = Color(0xFFFFFFFF);
  static const surfaceAlt = Color(0xFFF1E9D8);

  // Matn ranglari
  static const textPrimary = Color(0xFF1B2128);
  static const textSecondary = Color(0xFF5B6472);
  static const textOnPrimary = Color(0xFFFFFFFF);
  static const textOnAccent = Color(0xFF1B2128);

  // Chegara va ajratuvchilar
  static const divider = Color(0xFFE3DCC8);
  static const outline = Color(0xFFD8CFB8);

  // Sohalar bo'yicha ranglar
  static const fieldAstronomy = Color(0xFF2E5C8A);
  static const fieldMathematics = Color(0xFF6A4C93);
  static const fieldMedicine = Color(0xFF2E7D5B);
  static const fieldHistory = Color(0xFFA05A2C);
  static const fieldState = Color(0xFF8C2F39);

  // Umumiy
  static const starGold = Color(0xFFFFD66B);
  static const statusBar = Color(0xFF101A30);
}

class AppSpacing {
  AppSpacing._();

  static const xs = 4.0;
  static const s = 8.0;
  static const m = 16.0;
  static const l = 24.0;
  static const xl = 32.0;

  static const cardCornerRadius = 18.0;
  static const cardElevation = 3.0;

  static const avatarSizeList = 64.0;
  static const avatarSizeDetail = 120.0;
}

class AppTheme {
  AppTheme._();

  static const serifFontFamily = 'serif';

  static ThemeData get light {
    final base = ThemeData(
      useMaterial3: true,
      colorScheme: ColorScheme.fromSeed(
        seedColor: AppColors.primary,
        primary: AppColors.primary,
        secondary: AppColors.accent,
        onPrimary: AppColors.textOnPrimary,
        onSecondary: AppColors.textOnAccent,
        surface: AppColors.surface,
        onSurface: AppColors.textPrimary,
        brightness: Brightness.light,
      ),
      scaffoldBackgroundColor: AppColors.background,
      fontFamily: null,
    );

    return base.copyWith(
      appBarTheme: const AppBarTheme(
        backgroundColor: AppColors.primary,
        foregroundColor: AppColors.textOnPrimary,
        elevation: 0,
        centerTitle: false,
        titleTextStyle: TextStyle(
          fontFamily: serifFontFamily,
          fontWeight: FontWeight.bold,
          fontSize: 20,
          color: AppColors.textOnPrimary,
        ),
      ),
      cardTheme: const CardThemeData(
        color: AppColors.surface,
        elevation: AppSpacing.cardElevation,
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.all(
            Radius.circular(AppSpacing.cardCornerRadius),
          ),
        ),
        margin: EdgeInsets.zero,
      ),
      dividerColor: AppColors.divider,
      textTheme: base.textTheme.apply(
        bodyColor: AppColors.textPrimary,
        displayColor: AppColors.textPrimary,
      ),
    );
  }

  static const TextStyle headlineSerif = TextStyle(
    fontFamily: serifFontFamily,
    fontWeight: FontWeight.bold,
    fontSize: 24,
    color: AppColors.textPrimary,
  );

  static const TextStyle sectionTitle = TextStyle(
    fontFamily: serifFontFamily,
    fontWeight: FontWeight.bold,
    fontSize: 16,
    color: AppColors.primary,
    letterSpacing: 0.3,
  );
}
