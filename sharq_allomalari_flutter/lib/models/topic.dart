/// "Mavzular" bo'limidagi o'quv mavzusi modeli. Har bir mavzu Fayzullayeva
/// Saodat Dilshodovnaning "Vostochnaya astronomiya" o'quv qo'llanmasidagi
/// tegishli bobning to'liq matnini o'z ichiga oladi.
class Topic {
  const Topic({
    required this.id,
    required this.title,
    required this.keywords,
    required this.paragraphs,
    required this.controlQuestions,
  });

  /// Mavzu tartib raqami (1-9).
  final int id;

  /// Mavzu sarlavhasi.
  final String title;

  /// Tayanch tushunchalar (kalit so'zlar) ro'yxati.
  final List<String> keywords;

  /// Mavzu matnining paragraflari (tartib bo'yicha).
  final List<String> paragraphs;

  /// Mavzu oxiridagi nazorat savollari.
  final List<String> controlQuestions;
}
