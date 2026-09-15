package uz.edu.sharqallomalari.model

/**
 * Rasadxona (observatoriya) haqida ma'lumotni ifodalovchi model.
 *
 * @param id            Noyob identifikator
 * @param name           Rasadxonaning nomi
 * @param location       Joylashgan joyi (shahar, mamlakat)
 * @param period         Faoliyat yuritgan davri
 * @param shortDesc      Ro'yxatda ko'rsatiladigan qisqa tavsif
 * @param description    To'liq tavsif (bir necha paragraf)
 * @param keyFacts       Asosiy faktlar/raqamlar ro'yxati
 * @param scholars        Bu yerda faoliyat yuritgan asosiy olimlar (matn ko'rinishida)
 * @param colorHex       Kartochka uchun rang (HEX)
 */
data class Observatory(
    val id: Int,
    val name: String,
    val location: String,
    val period: String,
    val shortDesc: String,
    val description: String,
    val keyFacts: List<String>,
    val scholars: String,
    val colorHex: String
)
