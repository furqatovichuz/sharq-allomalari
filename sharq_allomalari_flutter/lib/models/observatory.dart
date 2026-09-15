/// Rasadxona (observatoriya) haqida ma'lumotni ifodalovchi model.
class Observatory {
  const Observatory({
    required this.id,
    required this.name,
    required this.location,
    required this.period,
    required this.shortDesc,
    required this.description,
    required this.keyFacts,
    required this.scholars,
    required this.colorHex,
  });

  /// Noyob identifikator.
  final int id;

  /// Rasadxonaning nomi.
  final String name;

  /// Joylashgan joyi (shahar, mamlakat).
  final String location;

  /// Faoliyat yuritgan davri.
  final String period;

  /// Ro'yxatda ko'rsatiladigan qisqa tavsif.
  final String shortDesc;

  /// To'liq tavsif (bir necha paragraf).
  final String description;

  /// Asosiy faktlar/raqamlar ro'yxati.
  final List<String> keyFacts;

  /// Bu yerda faoliyat yuritgan asosiy olimlar (matn ko'rinishida).
  final String scholars;

  /// Kartochka uchun rang (HEX).
  final String colorHex;
}
