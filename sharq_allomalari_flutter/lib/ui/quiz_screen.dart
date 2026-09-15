import 'dart:math';

import 'package:flutter/material.dart';

import '../data/quiz_repository.dart';
import '../models/quiz_question.dart';
import '../theme/app_theme.dart';

/// Astronomiya bo'yicha 120 savoldan iborat testni o'tkazish ekrani.
/// Har bir savolda 4 variantdan biri tanlanadi, javobdan keyin
/// to'g'ri/noto'g'ri rang bilan belgilanadi va tushuntirish ko'rsatiladi
/// (`QuizActivity` ekvivalenti).
class QuizScreen extends StatefulWidget {
  const QuizScreen({super.key});

  @override
  State<QuizScreen> createState() => _QuizScreenState();
}

class _QuizScreenState extends State<QuizScreen> {
  late List<QuizQuestion> _questions;
  int _currentIndex = 0;
  int _correctCount = 0;
  bool _answered = false;
  int? _selectedIndex;

  @override
  void initState() {
    super.initState();
    _questions = List.of(QuizRepository.questions)..shuffle(Random());
  }

  void _restart() {
    setState(() {
      _questions = List.of(QuizRepository.questions)..shuffle(Random());
      _currentIndex = 0;
      _correctCount = 0;
      _answered = false;
      _selectedIndex = null;
    });
  }

  void _selectOption(int index) {
    if (_answered) return;
    final question = _questions[_currentIndex];
    final isCorrect = index == question.correctIndex;
    setState(() {
      _answered = true;
      _selectedIndex = index;
      if (isCorrect) _correctCount++;
    });
  }

  void _next() {
    if (_currentIndex == _questions.length - 1) {
      _showResultDialog();
    } else {
      setState(() {
        _currentIndex++;
        _answered = false;
        _selectedIndex = null;
      });
    }
  }

  void _showResultDialog() {
    final percent = (_correctCount * 100) / _questions.length;
    final title = percent >= 80
        ? 'Ajoyib natija!'
        : percent >= 50
        ? 'Yaxshi natija!'
        : 'Yana mashq qiling';

    showDialog<void>(
      context: context,
      barrierDismissible: false,
      builder: (context) => AlertDialog(
        contentPadding: const EdgeInsets.all(32),
        content: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Container(
              width: 120,
              height: 120,
              alignment: Alignment.center,
              decoration: const BoxDecoration(
                color: AppColors.primary,
                shape: BoxShape.circle,
              ),
              child: Text(
                '${percent.round()}%',
                style: const TextStyle(fontSize: 40, color: Colors.white),
              ),
            ),
            const SizedBox(height: 24),
            Text(
              title,
              style: const TextStyle(
                fontFamily: AppTheme.serifFontFamily,
                fontWeight: FontWeight.bold,
                fontSize: 22,
                color: AppColors.textPrimary,
              ),
            ),
            const SizedBox(height: 8),
            Text(
              '${_questions.length} savoldan $_correctCount tasiga to\'g\'ri javob berdingiz',
              textAlign: TextAlign.center,
              style: const TextStyle(
                fontSize: 15,
                color: AppColors.textSecondary,
              ),
            ),
            const SizedBox(height: 32),
            SizedBox(
              width: double.infinity,
              height: 52,
              child: ElevatedButton(
                style: ElevatedButton.styleFrom(
                  backgroundColor: AppColors.primary,
                  foregroundColor: Colors.white,
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(14),
                  ),
                ),
                onPressed: () {
                  Navigator.of(context).pop();
                  _restart();
                },
                child: const Text('Qaytadan boshlash'),
              ),
            ),
            const SizedBox(height: 10),
            SizedBox(
              width: double.infinity,
              height: 52,
              child: OutlinedButton(
                style: OutlinedButton.styleFrom(
                  side: const BorderSide(color: AppColors.outline),
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(14),
                  ),
                ),
                onPressed: () {
                  Navigator.of(context).pop();
                  Navigator.of(context).pop();
                },
                child: const Text('Yopish'),
              ),
            ),
          ],
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    final question = _questions[_currentIndex];
    final isLast = _currentIndex == _questions.length - 1;

    return Scaffold(
      appBar: AppBar(title: const Text('Bilimlarni sinash')),
      body: Column(
        children: [
          Padding(
            padding: const EdgeInsets.all(16),
            child: Row(
              children: [
                Expanded(
                  child: Text(
                    'Savol ${_currentIndex + 1} / ${_questions.length}',
                    style: const TextStyle(
                      fontSize: 13,
                      color: AppColors.textSecondary,
                    ),
                  ),
                ),
                Text(
                  "To'g'ri: $_correctCount",
                  style: const TextStyle(
                    fontSize: 13,
                    fontWeight: FontWeight.bold,
                    color: AppColors.accentDark,
                  ),
                ),
              ],
            ),
          ),
          Padding(
            padding: const EdgeInsets.symmetric(horizontal: 16),
            child: ClipRRect(
              borderRadius: BorderRadius.circular(3),
              child: LinearProgressIndicator(
                value: _currentIndex / _questions.length,
                minHeight: 6,
                backgroundColor: AppColors.outline.withValues(alpha: 0.3),
                valueColor: const AlwaysStoppedAnimation(AppColors.accent),
              ),
            ),
          ),
          Expanded(
            child: ListView(
              padding: const EdgeInsets.all(20),
              children: [
                Card(
                  child: Padding(
                    padding: const EdgeInsets.all(20),
                    child: Text(
                      question.question,
                      style: const TextStyle(
                        fontFamily: AppTheme.serifFontFamily,
                        fontWeight: FontWeight.bold,
                        fontSize: 18,
                        height: 1.25,
                        color: AppColors.textPrimary,
                      ),
                    ),
                  ),
                ),
                const SizedBox(height: 16),
                for (var i = 0; i < question.options.length; i++)
                  Padding(
                    padding: const EdgeInsets.only(bottom: 12),
                    child: _OptionButton(
                      text: question.options[i],
                      state: !_answered
                          ? _OptionState.neutral
                          : i == question.correctIndex
                          ? _OptionState.correct
                          : i == _selectedIndex
                          ? _OptionState.wrong
                          : _OptionState.neutral,
                      onTap: () => _selectOption(i),
                    ),
                  ),
                if (_answered)
                  Container(
                    margin: const EdgeInsets.only(top: 4),
                    padding: const EdgeInsets.all(14),
                    decoration: BoxDecoration(
                      color: AppColors.surface,
                      borderRadius: BorderRadius.circular(16),
                      border: Border.all(color: AppColors.outline),
                    ),
                    child: Text(
                      "To'g'ri javob: ${question.options[question.correctIndex]}",
                      style: const TextStyle(
                        fontSize: 13,
                        color: AppColors.textSecondary,
                      ),
                    ),
                  ),
              ],
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(16),
            child: SizedBox(
              width: double.infinity,
              height: 52,
              child: ElevatedButton(
                style: ElevatedButton.styleFrom(
                  backgroundColor: AppColors.primary,
                  foregroundColor: Colors.white,
                  disabledBackgroundColor: AppColors.outline,
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(14),
                  ),
                ),
                onPressed: _answered ? _next : null,
                child: Text(isLast ? 'Yakunlash' : 'Keyingisi'),
              ),
            ),
          ),
        ],
      ),
    );
  }
}

enum _OptionState { neutral, correct, wrong }

class _OptionButton extends StatelessWidget {
  const _OptionButton({
    required this.text,
    required this.state,
    required this.onTap,
  });

  final String text;
  final _OptionState state;
  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    final Color borderColor = switch (state) {
      _OptionState.correct => AppColors.fieldMedicine,
      _OptionState.wrong => AppColors.fieldHistory,
      _OptionState.neutral => AppColors.outline,
    };
    final double borderWidth = state == _OptionState.neutral ? 2 : 3;

    return SizedBox(
      width: double.infinity,
      child: OutlinedButton(
        onPressed: onTap,
        style: OutlinedButton.styleFrom(
          padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 14),
          alignment: Alignment.centerLeft,
          backgroundColor: AppColors.surface,
          foregroundColor: AppColors.textPrimary,
          side: BorderSide(color: borderColor, width: borderWidth),
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(28),
          ),
        ),
        child: Text(text, style: const TextStyle(fontSize: 14)),
      ),
    );
  }
}
