import 'package:flutter/material.dart';

import '../data/topic_repository.dart';
import '../theme/app_theme.dart';
import '../widgets/info_row.dart';
import 'detail_screen.dart';

/// Tanlangan mavzuning to'liq matnini, tayanch tushunchalarini va
/// nazorat savollarini ko'rsatuvchi ekran (`TopicDetailActivity`
/// ekvivalenti).
class TopicDetailScreen extends StatelessWidget {
  const TopicDetailScreen({super.key, required this.topicId});

  final int topicId;

  @override
  Widget build(BuildContext context) {
    final topic = TopicRepository.getById(topicId);
    if (topic == null) {
      return const Scaffold(body: SizedBox.shrink());
    }

    return Scaffold(
      appBar: AppBar(title: Text('${topic.id}-MAVZU')),
      body: ListView(
        padding: const EdgeInsets.all(20),
        children: [
          Text(topic.title, style: AppTheme.headlineSerif),
          const SizedBox(height: 14),
          Container(
            padding: const EdgeInsets.all(14),
            decoration: BoxDecoration(
              color: AppColors.surface,
              borderRadius: BorderRadius.circular(14),
              border: Border.all(color: AppColors.divider),
            ),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                const SectionHeading('Tayanch tushunchalar'),
                const SizedBox(height: 4),
                Text(
                  topic.keywords.join(', '),
                  style: const TextStyle(
                    fontSize: 13,
                    fontStyle: FontStyle.italic,
                    height: 1.2,
                    color: AppColors.textSecondary,
                  ),
                ),
              ],
            ),
          ),
          const SizedBox(height: 18),
          Text(
            topic.paragraphs.join('\n\n'),
            style: const TextStyle(
              fontSize: 14,
              height: 1.35,
              color: AppColors.textPrimary,
            ),
          ),
          const SizedBox(height: 22),
          const SectionHeading('Nazorat savollari'),
          const SizedBox(height: 8),
          for (var i = 0; i < topic.controlQuestions.length; i++)
            IndexedTextRow(index: i + 1, text: topic.controlQuestions[i]),
        ],
      ),
    );
  }
}
