import 'package:flutter/material.dart';

import '../data/topic_repository.dart';
import '../widgets/topic_card.dart';
import 'topic_detail_screen.dart';

/// O'quv qo'llanmasidagi 9 ta mavzuning ro'yxatini ko'rsatuvchi ekran
/// (`TopicsActivity` ekvivalenti).
class TopicsScreen extends StatelessWidget {
  const TopicsScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final topics = TopicRepository.topics;
    return Scaffold(
      appBar: AppBar(title: const Text('Mavzular')),
      body: ListView.builder(
        padding: const EdgeInsets.symmetric(vertical: 8),
        itemCount: topics.length,
        itemBuilder: (context, index) {
          final topic = topics[index];
          return TopicCard(
            topic: topic,
            onTap: () => Navigator.of(context).push(
              MaterialPageRoute(
                builder: (_) => TopicDetailScreen(topicId: topic.id),
              ),
            ),
          );
        },
      ),
    );
  }
}
