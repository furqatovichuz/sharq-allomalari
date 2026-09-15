package uz.edu.sharqallomalari.ui

import uz.edu.sharqallomalari.R
import uz.edu.sharqallomalari.model.ScholarCategory
import uz.edu.sharqallomalari.model.ScholarCategory.ASTRONOMY
import uz.edu.sharqallomalari.model.ScholarCategory.HISTORY
import uz.edu.sharqallomalari.model.ScholarCategory.MATHEMATICS
import uz.edu.sharqallomalari.model.ScholarCategory.MEDICINE
import uz.edu.sharqallomalari.model.ScholarCategory.STATE

/**
 * Faoliyat sohasi (ScholarCategory) bo'yicha rang va belgi (ikon) resurslarini
 * bir joydan boshqarish uchun yordamchi obyekt. Bu UI elementlari (avatar,
 * nishonchalar, filtr chip'lari) bir xil vizual uslubda bo'lishini ta'minlaydi.
 */
object CategoryUi {

    fun colorRes(category: ScholarCategory): Int = when (category) {
        ASTRONOMY -> R.color.field_astronomy
        MATHEMATICS -> R.color.field_mathematics
        MEDICINE -> R.color.field_medicine
        HISTORY -> R.color.field_history
        STATE -> R.color.field_state
    }

    fun iconRes(category: ScholarCategory): Int = when (category) {
        ASTRONOMY -> R.drawable.ic_astronomy
        MATHEMATICS -> R.drawable.ic_mathematics
        MEDICINE -> R.drawable.ic_medicine
        HISTORY -> R.drawable.ic_history
        STATE -> R.drawable.ic_state
    }
}
