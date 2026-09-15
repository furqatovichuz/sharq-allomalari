import 'package:flutter/material.dart';

import '../models/glossary_term.dart';
import '../theme/app_theme.dart';

/// `item_glossary_term.xml` ning Flutter ekvivalenti.
class GlossaryItem extends StatelessWidget {
  const GlossaryItem({super.key, required this.term});

  final GlossaryTerm term;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 12),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(term.term, style: AppTheme.sectionTitle.copyWith(fontSize: 15)),
          const SizedBox(height: 4),
          Text(
            term.definition,
            style: const TextStyle(
              fontSize: 13,
              height: 1.15,
              color: AppColors.textPrimary,
            ),
          ),
          const SizedBox(height: 12),
          const Divider(height: 1, color: AppColors.divider),
        ],
      ),
    );
  }
}
