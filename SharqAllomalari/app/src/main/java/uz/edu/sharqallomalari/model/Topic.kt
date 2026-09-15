package uz.edu.sharqallomalari.model

/**
 * "Mavzular" bo'limidagi o'quv mavzusi modeli. Har bir mavzu Fayzullayeva Saodat
 * Dilshodovnaning "Vostochnaya astronomiya" o'quv qo'llanmasidagi tegishli
 * bobning to'liq matnini o'z ichiga oladi.
 *
 * @param id            Mavzu tartib raqami (1–9)
 * @param title         Mavzu sarlavhasi
 * @param keywords       Tayanch tushunchalar (kalit so'zlar) ro'yxati
 * @param paragraphs     Mavzu matnining paragraflari (tartib bo'yicha)
 * @param controlQuestions  Mavzu oxiridagi nazorat savollari
 */
data class Topic(
    val id: Int,
    val title: String,
    val keywords: List<String>,
    val paragraphs: List<String>,
    val controlQuestions: List<String>
)
