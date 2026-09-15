import 'package:flutter/material.dart';

import '../data/observatory_repository.dart';
import 'observatory_detail_screen.dart';
import '../widgets/observatory_card.dart';

/// Bog'dod, Xorazm, Samarqand, Toshkent va Maydanak rasadxonalari
/// ro'yxatini ko'rsatuvchi ekran (`ObservatoriesActivity` ekvivalenti).
class ObservatoriesScreen extends StatelessWidget {
  const ObservatoriesScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final observatories = ObservatoryRepository.observatories;
    return Scaffold(
      appBar: AppBar(title: const Text('Rasadxonalar')),
      body: ListView.builder(
        padding: const EdgeInsets.symmetric(vertical: 8),
        itemCount: observatories.length,
        itemBuilder: (context, index) {
          final observatory = observatories[index];
          return ObservatoryCard(
            observatory: observatory,
            onTap: () => Navigator.of(context).push(
              MaterialPageRoute(
                builder: (_) =>
                    ObservatoryDetailScreen(observatoryId: observatory.id),
              ),
            ),
          );
        },
      ),
    );
  }
}
