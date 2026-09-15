package uz.edu.sharqallomalari.model

/**
 * Allomaning asosiy faoliyat yo'nalishi bo'yicha toifasi.
 * Bu toifa ro'yxatdagi rang belgisi va filtr chip'lari uchun ishlatiladi.
 */
enum class ScholarCategory(val displayName: String) {
    ASTRONOMY("Astronomiya"),
    MATHEMATICS("Matematika"),
    MEDICINE("Tibbiyot"),
    HISTORY("Tarix va adabiyot"),
    STATE("Davlat arbobi")
}

/**
 * Sharq allomasi haqida to'liq ma'lumotni ifodalovchi model.
 *
 * @param id            Ro'yxatdagi va navigatsiyadagi noyob identifikator
 * @param fullName      Olimning to'liq ismi
 * @param shortName     Ro'yxat va sarlavhalarda ko'rsatiladigan qisqa nom
 * @param years         Yashagan yillari (masalan, "973–1048")
 * @param birthPlace    Tug'ilgan joyi
 * @param categories    Faoliyat sohalari (bir nechta bo'lishi mumkin)
 * @param academy       Tegishli ilmiy maktab yoki akademiya
 * @param honorTitle    Sharqda berilgan faxriy unvoni (agar mavjud bo'lsa)
 * @param shortBio      Ro'yxatda ko'rsatiladigan qisqa tavsif
 * @param biography     To'liq tarjimai hol matni (bir nechta paragraf)
 * @param works         Asosiy ilmiy asarlari ro'yxati
 * @param achievements  Asosiy ilmiy yutuqlari va kashfiyotlari ro'yxati
 * @param quote         Olimga tegishli yoki olim haqidagi mashhur iqtibos
 * @param initials      Avatar uchun ishlatiladigan bosh harflar
 * @param portraitRes   Olimning stilize qilingan portret-avatar drawable resursi
 */
data class Scholar(
    val id: Int,
    val fullName: String,
    val shortName: String,
    val years: String,
    val birthPlace: String,
    val categories: List<ScholarCategory>,
    val academy: String,
    val honorTitle: String?,
    val shortBio: String,
    val biography: String,
    val works: List<String>,
    val achievements: List<String>,
    val quote: String?,
    val initials: String,
    val portraitRes: Int
) {
    val primaryCategory: ScholarCategory
        get() = categories.first()
}
