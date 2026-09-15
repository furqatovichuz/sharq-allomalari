import 'package:flutter/material.dart';

import '../data/glossary_repository.dart';
import '../widgets/glossary_item.dart';

/// Astronomiya va Sharq ilmiy merosiga oid asosiy atamalar ro'yxatini
/// ko'rsatuvchi ekran (`GlossaryActivity` ekvivalenti).
class GlossaryScreen extends StatelessWidget {
  const GlossaryScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final terms = GlossaryRepository.terms;
    return Scaffold(
      appBar: AppBar(title: const Text("Atamalar lug'ati")),
      body: ListView.builder(
        padding: const EdgeInsets.symmetric(vertical: 8),
        itemCount: terms.length,
        itemBuilder: (context, index) => GlossaryItem(term: terms[index]),
      ),
    );
  }
}
