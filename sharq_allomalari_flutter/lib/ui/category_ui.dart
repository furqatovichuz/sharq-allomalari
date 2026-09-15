import 'package:flutter/material.dart';

import '../models/scholar.dart';
import '../theme/app_theme.dart';

/// Faoliyat sohasi (ScholarCategory) bo'yicha rang va belgi (ikon)
/// resurslarini bir joydan boshqarish uchun yordamchi obyekt. Bu UI
/// elementlari (avatar, nishonchalar, filtr chip'lari) bir xil vizual
/// uslubda bo'lishini ta'minlaydi.
class CategoryUi {
  CategoryUi._();

  static Color color(ScholarCategory category) {
    switch (category) {
      case ScholarCategory.astronomy:
        return AppColors.fieldAstronomy;
      case ScholarCategory.mathematics:
        return AppColors.fieldMathematics;
      case ScholarCategory.medicine:
        return AppColors.fieldMedicine;
      case ScholarCategory.history:
        return AppColors.fieldHistory;
      case ScholarCategory.state:
        return AppColors.fieldState;
    }
  }

  static String iconAsset(ScholarCategory category) {
    switch (category) {
      case ScholarCategory.astronomy:
        return 'assets/icons/ic_astronomy.svg';
      case ScholarCategory.mathematics:
        return 'assets/icons/ic_mathematics.svg';
      case ScholarCategory.medicine:
        return 'assets/icons/ic_medicine.svg';
      case ScholarCategory.history:
        return 'assets/icons/ic_history.svg';
      case ScholarCategory.state:
        return 'assets/icons/ic_state.svg';
    }
  }
}
