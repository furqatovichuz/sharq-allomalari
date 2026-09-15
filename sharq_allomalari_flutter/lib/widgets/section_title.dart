import 'package:flutter/material.dart';

import '../theme/app_theme.dart';

/// XML'dagi `@style/SectionTitle` uslubining Flutter ekvivalenti —
/// bo'lim sarlavhalari uchun serif, qalin, primary rangdagi matn.
class SectionTitle extends StatelessWidget {
  const SectionTitle(this.text, {super.key, this.fontSize});

  final String text;
  final double? fontSize;

  @override
  Widget build(BuildContext context) {
    return Text(
      text,
      style: AppTheme.sectionTitle.copyWith(fontSize: fontSize),
    );
  }
}
