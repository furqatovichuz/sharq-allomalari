package uz.edu.sharqallomalari.model

/**
 * Test savoli modeli — 4 variantli (A/B/C/D) test bank uchun.
 *
 * @param id            Savol raqami
 * @param question      Savol matni
 * @param options       4 ta javob varianti (tartibda: A, B, C, D)
 * @param correctIndex  To'g'ri javobning options ro'yxatidagi indeksi (0–3)
 */
data class QuizQuestion(
    val id: Int,
    val question: String,
    val options: List<String>,
    val correctIndex: Int
)
