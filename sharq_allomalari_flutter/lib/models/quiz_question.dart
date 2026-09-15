/// Test savoli modeli — 4 variantli (A/B/C/D) test bank uchun.
class QuizQuestion {
  const QuizQuestion(this.id, this.question, this.options, this.correctIndex);

  /// Savol raqami.
  final int id;

  /// Savol matni.
  final String question;

  /// 4 ta javob varianti (tartibda: A, B, C, D).
  final List<String> options;

  /// To'g'ri javobning options ro'yxatidagi indeksi (0-3).
  final int correctIndex;
}
