# Sharq Allomalari

O'rta asrlarda Bog'dod, Xorazm va Samarqand ilmiy maktablarida ijod etgan buyuk Sharq allomalari, ular faoliyat yuritgan rasadxonalar, astronomiya bo'yicha bilim sinovi va atamalar lug'atini o'z ichiga olgan ma'lumotnoma mobil ilova.

Ma'lumotlar manbasi: Fayzullayeva Saodat Dilshodovna, "Vostochnaya astronomiya" o'quv qo'llanmasi (Navoiy, 2026). Bog'dod akademiyasi bo'limi qo'llanmaning 3-mavzu faylida to'liq matn bilan keltirilgan.

## Ilova bo'limlari

1. **Allomalar** — 13 nafar olim (Al-Xorazmiy, Abu Rayhon Beruniy, Abu Ali ibn Sino, Mirzo Ulug'bek, Ali Qushchi va boshqalar) haqida to'liq profil: tarjimai hol, asarlari, yutuqlari, iqtibos, stilize qilingan portret-avatar, qidiruv va soha bo'yicha filtr, saralanganlar.
2. **Rasadxonalar** — Bog'dod "Bayt al-Hikma", Xorazm Ma'mun akademiyasi, Samarqand rasadxonasi, Toshkent rasadxonasi, Maydanak astrofizika rasadxonasi haqida tarix, asosiy faktlar va u yerda faoliyat yuritgan olimlar.
3. **Mavzular** — o'quv qo'llanmasidagi 9 ta mavzuning to'liq matni (Kirish, Platon maktabi, Bog'dod akademiyasi, Xorazm akademiyasi, Samarqand astronomik maktabi, Toshkent rasadxonasi, Ulug'bek rasadxonasi, Maydanak rasadxonasi, O'zbekistonda astronomik tadqiqotlar), har biri tayanch tushunchalar va nazorat savollari bilan.
4. **Test** — 120 savoldan iborat bilim sinovi (4 variantli, har safar aralashtirilgan tartibda), natija foizi va qayta urinish imkoni.
5. **Lug'at** — 46 ta astronomik atama va ta'rifi.

## Texnologiyalar

- Kotlin
- XML Layout (klassik View tizimi, Jetpack Compose emas)
- View Binding
- Material Components 3
- RecyclerView, SharedPreferences (saralanganlar uchun)
- minSdk 24, targetSdk / compileSdk 34

## Android Studio'da ochish

1. Android Studio'ni oching → **Open** → ushbu papkani (`SharqAllomalari`) tanlang.
2. Birinchi marta ochilganda Gradle avtomatik ravishda `gradlew`, `gradlew.bat` va `gradle-wrapper.jar` fayllarini yaratadi — bunga internet aloqasi kerak bo'ladi, chunki Gradle 8.7 distributivi va barcha bog'liqliklar (Material, AndroidX va h.k.) yuklab olinishi kerak.
3. Gradle sinxronizatsiyasi tugagach, **Run ▶** tugmasini bosib ilovani emulator yoki real qurilmada ishga tushiring.

## Ilova tuzilishi

```
app/src/main/java/uz/edu/sharqallomalari/
├── model/
│   ├── Scholar.kt              — Alloma ma'lumotlari modeli
│   ├── Observatory.kt          — Rasadxona modeli
│   ├── Topic.kt                — Mavzu modeli
│   ├── QuizQuestion.kt         — Test savoli modeli
│   └── GlossaryTerm.kt         — Lug'at atamasi modeli
├── data/
│   ├── ScholarRepository.kt    — 13 ta allomaning to'liq matni
│   ├── ObservatoryRepository.kt — 5 ta rasadxona ma'lumotlari
│   ├── TopicRepository.kt      — 9 ta mavzuning to'liq matni
│   ├── QuizRepository.kt       — 120 ta test savoli
│   ├── GlossaryRepository.kt   — 46 ta atama lug'ati
│   └── FavoritesManager.kt     — Saralanganlarni saqlash
├── adapter/
│   ├── ScholarAdapter.kt
│   ├── ObservatoryAdapter.kt
│   ├── TopicAdapter.kt
│   └── GlossaryAdapter.kt
└── ui/
    ├── SplashActivity.kt
    ├── MainActivity.kt          — Ro'yxat, qidiruv, filtrlar, bo'limlar menyusi
    ├── DetailActivity.kt        — Alloma profili
    ├── FavoritesActivity.kt
    ├── AboutActivity.kt
    ├── ObservatoriesActivity.kt
    ├── ObservatoryDetailActivity.kt
    ├── TopicsActivity.kt        — Mavzular ro'yxati
    ├── TopicDetailActivity.kt   — Mavzu to'liq matni
    ├── QuizActivity.kt          — Interaktiv test mantiqi
    ├── GlossaryActivity.kt
    └── CategoryUi.kt
```

## Eslatma

Allomalarning portret-avatarlari stilize qilingan vektor chizmalar (fotosurat emas), chunki ilova offlayn muhitda, tarmoqdan rasm yuklab olish imkoniyati bo'lmagan holda tayyorlangan. Test savollarining ba'zi raqamli javoblari (asbob diametri, masofa va h.k.) original hujjatda javob kaliti berilmagani sababli umumiy ilmiy bilim asosida belgilangan.
