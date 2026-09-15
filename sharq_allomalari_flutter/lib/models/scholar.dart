/// Allomaning asosiy faoliyat yo'nalishi bo'yicha toifasi.
/// Bu toifa ro'yxatdagi rang belgisi va filtr chip'lari uchun ishlatiladi.
enum ScholarCategory {
  astronomy('Astronomiya'),
  mathematics('Matematika'),
  medicine('Tibbiyot'),
  history('Tarix va adabiyot'),
  state('Davlat arbobi');

  const ScholarCategory(this.displayName);

  final String displayName;
}

/// Sharq allomasi haqida to'liq ma'lumotni ifodalovchi model.
class Scholar {
  const Scholar({
    required this.id,
    required this.fullName,
    required this.shortName,
    required this.years,
    required this.birthPlace,
    required this.categories,
    required this.academy,
    required this.honorTitle,
    required this.shortBio,
    required this.biography,
    required this.works,
    required this.achievements,
    required this.quote,
    required this.initials,
    required this.portraitRes,
  });

  /// Ro'yxatdagi va navigatsiyadagi noyob identifikator.
  final int id;

  /// Olimning to'liq ismi.
  final String fullName;

  /// Ro'yxat va sarlavhalarda ko'rsatiladigan qisqa nom.
  final String shortName;

  /// Yashagan yillari (masalan, "973-1048").
  final String years;

  /// Tug'ilgan joyi.
  final String birthPlace;

  /// Faoliyat sohalari (bir nechta bo'lishi mumkin).
  final List<ScholarCategory> categories;

  /// Tegishli ilmiy maktab yoki akademiya.
  final String academy;

  /// Sharqda berilgan faxriy unvoni (agar mavjud bo'lsa).
  final String? honorTitle;

  /// Ro'yxatda ko'rsatiladigan qisqa tavsif.
  final String shortBio;

  /// To'liq tarjimai hol matni (bir nechta paragraf).
  final String biography;

  /// Asosiy ilmiy asarlari ro'yxati.
  final List<String> works;

  /// Asosiy ilmiy yutuqlari va kashfiyotlari ro'yxati.
  final List<String> achievements;

  /// Olimga tegishli yoki olim haqidagi mashhur iqtibos.
  final String? quote;

  /// Avatar uchun ishlatiladigan bosh harflar.
  final String initials;

  /// Olimning stilize qilingan portret-avatar SVG asset yo'li.
  final String portraitRes;

  ScholarCategory get primaryCategory => categories.first;
}
