package uz.edu.sharqallomalari.data

import uz.edu.sharqallomalari.R
import uz.edu.sharqallomalari.model.Scholar
import uz.edu.sharqallomalari.model.ScholarCategory
import uz.edu.sharqallomalari.model.ScholarCategory.ASTRONOMY
import uz.edu.sharqallomalari.model.ScholarCategory.HISTORY
import uz.edu.sharqallomalari.model.ScholarCategory.MATHEMATICS
import uz.edu.sharqallomalari.model.ScholarCategory.MEDICINE
import uz.edu.sharqallomalari.model.ScholarCategory.STATE

/**
 * Ilovaning markaziy ma'lumotlar bazasi.
 *
 * Bu yerda IX—XV asrlarda Bog'dod, Xorazm va Samarqand ilmiy maktablarida
 * faoliyat yuritgan Sharq allomalari haqida tarjimai hol, asosiy asarlar
 * va ilmiy yutuqlar saqlanadi. Ma'lumotlar Fayzullayeva Saodat Dilshodovnaning
 * "Vostochnaya astronomiya" o'quv qo'llanmasi asosida tayyorlangan.
 */
object ScholarRepository {

    val scholars: List<Scholar> = listOf(

        // 1 ---------------------------------------------------------------
        Scholar(
            id = 1,
            fullName = "Muhammad ibn Muso al-Xorazmiy",
            shortName = "Al-Xorazmiy",
            years = "taxm. 783–850",
            birthPlace = "Xorazm",
            categories = listOf(MATHEMATICS, ASTRONOMY),
            academy = "Bog'dod \"Bayt al-Hikma\" (Donishmandlik uyi)",
            honorTitle = "Algebra faninng asoschisi",
            shortBio = "Algebra fanining asoschisi, Bog'dodda xalifa Ma'mun saroyidagi " +
                "\"Donishmandlik uyi\" kutubxonasi mudiri va mashhur \"Ziy\" muallifi.",
            biography = """
                Muhammad ibn Muso al-Xorazmiyning hayoti haqida juda kam ma'lumot saqlanib qolgan. Tug'ilgan yili uning asarlaridagi parchalar asosida taxminan 783-yil deb belgilanadi, ilmiy faoliyatining izlari 847-yildan keyin uzilib qoladi, shu sababli vafoti taxminan 850-yilga to'g'ri keladi deb hisoblanadi.

                Abbosiylar sulolasi davrida poytaxt Bog'dodga ko'chirilgach, shahar tez orada Sharqning yetakchi ilm-fan markaziga aylandi. Al-Xorazmiy xalifa Ma'mun (813–833), undan keyin al-Mu'tasim va al-Vosiq saroylarida ijod qildi. Xalifa Ma'mun tashabbusi bilan tashkil etilgan "Bayt al-Hikma" o'nlab olimlarni, tarjimonlarni va kotiblarni birlashtirgan ilmiy markazga aylandi, bu yerda yunon olimlarining ko'plab asarlari arab tiliga o'girildi. Al-Xorazmiy ushbu akademiyaning yirik kutubxonasiga rahbarlik qildi.

                Xind olimlari yuborgan "Katta Sindhind" risolasi al-Xorazmiy ijodiga katta ta'sir ko'rsatdi. Shu asos va o'z kuzatishlariga tayanib, u 820-yillarda o'zining mashhur astronomik jadvallar to'plamini — "Ziy"ni yaratdi. Bu asar ikki asrdan ko'proq vaqt davomida turli rasadxonalarda foydalanildi va keyinchalik Yevropaga tarjima qilinib, lotin ilmiy tilida "algorism" so'zining paydo bo'lishiga sabab bo'ldi.
            """.trimIndent(),
            works = listOf(
                "\"Ziy\" — 37 bobdan va 116 jadvaldan iborat astronomik jadvallar to'plami",
                "\"Al-jabr va al-muqobala haqida qisqacha kitob\" — algebra fanining nazariy asosi",
                "\"Asturlob bilan ishlash kitobi\" (\"Kitab al-amal bi-l-asturlab\")"
            ),
            achievements = listOf(
                "\"Ziy\"ning birinchi besh bobi hijriy, yazdigard va boshqa kalendarlarni o'zaro solishtirish jadvallariga bag'ishlangan",
                "Oy orbitasining ekliptikaga og'maligini 4,5° deb qabul qilgan (hind astronomlari an'anasiga muvofiq)",
                "Oy tugunlarining kunlik siljishini 3°20′ deb aniqlagan (zamonaviy qiymat — 3°18′, xato — taxminan 0,02′)",
                "Quyoshning ekliptika bo'ylab kunlik siljishini 0°59′08″ deb hisoblagan (zamonaviy ma'lumotlardan farqi — taxminan 1 yoy soniyasi)",
                "Quyosh balandligi orqali geografik kenglikni aniqlash usulini batafsil bayon qilgan",
                "\"Sinus-kvadrant\" deb nomlangan astronomik asbobning tuzilishi va undan foydalanish tartibini birinchi marta yozma bayon etgan"
            ),
            quote = "Aylanani arablar \"falak\" deb ataydilar va uni o'n ikki belgiga bo'ladilar; har bir belgi 30 gradusga, gradus 60 daqiqaga, daqiqa 60 soniyaga bo'linadi — shu tarzda bo'linishni istalgancha davom ettirish mumkin.",
            initials = "MX",
            portraitRes = R.drawable.portrait_scholar_01
        ),

        // 2 ---------------------------------------------------------------
        Scholar(
            id = 2,
            fullName = "Abu Rayhon Muhammad ibn Ahmad al-Beruniy",
            shortName = "Abu Rayhon Beruniy",
            years = "973–1048",
            birthPlace = "Kiyot shahri (hozirgi Beruniy), Xorazm",
            categories = listOf(ASTRONOMY, MATHEMATICS, HISTORY),
            academy = "Xorazm Ma'mun akademiyasi",
            honorTitle = "Qomusiy olim",
            shortBio = "Tarixchi, geograf, matematik, astronom va faylasuf — 156 asar muallifi, " +
                "Xorazm Ma'mun akademiyasining yetakchi rahbari.",
            biography = """
                Abu Rayhon Beruniy 973-yil 4-sentyabrda qadimgi Xorazm poytaxti Kiyot shahrida tug'ilgan. Yoshligida u keng va chuqur ta'lim oldi, allaqachon 990-yillarda Habash al-Hosibning astronomik jadvallaridan foydalanib mustaqil kuzatuvlar olib borgan. Ustozlaridan biri — o'z davrining "Ptolomeyi" deb ulug'langan Abu Nasr ibn Iroq edi.

                21–22 yoshida Beruniy bir nechta astronomik asboblar yasab, Xorazm vohasidagi shaharlarning geografik koordinatalarini aniqlashga kirishdi, quyosh va oy tutilishlarini kuzatdi, ekliptikaning og'ish burchagini o'lchadi. 995-yilda Kiyot Gurganj amiri tomonidan bosib olingach, olim vatanini tark etishga majbur bo'ldi va Rey, so'ng Jurjon shaharlarida faoliyat yuritdi. Aynan Jurjon hukmdori saroyida u o'zining mashhur "Osor al-boqiya" (Xronologiya) asarini yozib tugatdi.

                1004-yilga kelib Beruniy Gurganjga qaytdi, bu yerda Xorazmshoh Ma'mun saroyida ajoyib olimlar to'plami — keyinchalik "Ma'mun akademiyasi" nomini olgan ilmiy davra shakllandi. 1017-yilda Mahmud G'aznaviy Xorazmni bosib olgach, Beruniy boshqa olimlar qatori G'aznaga ko'chirildi, biroq bu yerda ham ilmiy faoliyatini to'xtatmadi: Hindistonga sayohat qilib, "Hindiston" asarini, so'ngra hukmdor Mas'udga bag'ishlangan o'n bir kitobdan iborat "Qonuni Mas'udiy"ni yaratdi.

                Umrining so'nggi yillarigacha — 1048-yilda vafot etgunga qadar — Beruniy mineralogiya, farmakognoziya va boshqa sohalarda yangi asarlar ustida ishlashni davom ettirdi. Uning merosi nafaqat Markaziy Osiyo, balki butun dunyo fani uchun bebaho boylik hisoblanadi.
            """.trimIndent(),
            works = listOf(
                "\"Osor al-boqiya\" (\"Xronologiya\") — xalqlarning kalendar tizimlari haqida",
                "\"Hindiston\" — Hind olimlarining fan va falsafadagi yutuqlari tahlili",
                "\"Geodeziya\" — aholi punktlari orasidagi masofalarni aniqlash usullari",
                "\"Qonuni Mas'udiy\" — 11 kitobdan iborat astronomiya qomusi",
                "\"Mineralogiya\" va \"Farmakognoziya\" — umrining so'nggi yillaridagi asarlar"
            ),
            achievements = listOf(
                "156 ilmiy asar yozgan, ulardan taxminan 30 tasi bizgacha yetib kelgan",
                "Yevropalik olimlardan deyarli olti asr oldin Yerning o'z o'qi atrofida aylanishi g'oyasini ilmiy asoslagan",
                "Yer radiusini o'lchab, natijasi zamonaviy ma'lumotlarga juda yaqin chiqqan",
                "O'ziga xos asboblar yordamida Yer shaklini — globusni — aniqlagan",
                "Xristofor Kolumbdan besh asr oldin noma'lum yirik qit'a (Amerika) mavjudligini bashorat qilgan",
                "Geografik tadqiqotlarida yetti iqlim mintaqasidagi mamlakat, dengiz va orollarning aniq koordinatalarini ko'rsatgan"
            ),
            quote = "Ilm sohalarini, Beruniy e'tibor bermagan jihatlarini sanab o'tish, uning qiziqish doirasidagi mavzularni aytishdan ancha osonroq edi.",
            initials = "AB",
            portraitRes = R.drawable.portrait_scholar_02
        ),

        // 3 ---------------------------------------------------------------
        Scholar(
            id = 3,
            fullName = "Abu Ali al-Husayn ibn Abdulloh ibn Sino",
            shortName = "Abu Ali ibn Sino",
            years = "980–1037",
            birthPlace = "Afshona qishlog'i, Buxoro yaqinida",
            categories = listOf(MEDICINE, ASTRONOMY, MATHEMATICS),
            academy = "Xorazm Ma'mun akademiyasi",
            honorTitle = "Shayx ar-Rais (Donolar ustozi)",
            shortBio = "Tabib, faylasuf, astronom va shoir — asrlar davomida Sharq va G'arbda " +
                "tibbiyot asosi bo'lib xizmat qilgan \"Tib qonunlari\" muallifi.",
            biography = """
                Abu Ali ibn Sino 980-yilda Buxoro yaqinidagi Afshona qishlog'ida tug'ilgan. Otasi Abdulloh Balxdan bo'lib, Somoniylar saroyida xizmat qilgan. Yosh Ibn Sino Buxoroda Abu Abdulloh Notiliy, Ismoil Zohid va Abu Mansur Qamariy kabi ustozlardan mantiq, matematika, huquq va tibbiyotni o'rgandi, 17 yoshida allaqachon mohir tabib sifatida tanildi.

                U arab, fors va yunon tillarini mukammal bilgan, Buxoro amiri saroy kutubxonasidagi noyob qo'lyozmalarni o'qib, Arastu, Yevklid, Ptolomey, Galen, Gippokrat va Pifagor kabi mutafakkirlarning ta'limotini chuqur o'zlashtirgan. Shu davrda u Beruniy bilan xat orqali fizika, astronomiya va mexanika masalalarida ilmiy munozaralar olib borgan.

                999-yilda Buxoroning Qoraxoniylar tomonidan bosib olinishi, so'ng 1003-yilda Somoniylar davlatining qulashi Ibn Sinoni vatandan chiqishga majbur qildi. U Gurganjga keldi, bu yerda Ma'mun akademiyasi olimlari bilan yaqindan tanishdi va Beruniyga akademiya ishlarini yo'lga qo'yishda ko'maklashdi. Aynan shu yerda u o'zining mashhur "Tib qonunlari" asarining birinchi ikki kitobini yozib tugatdi.

                Mahmud G'aznaviy ta'qibidan qochib, Ibn Sino Xuroson va Eron shaharlarida — Nishopur, Jurjon, Hamadon, Isfahonda — sarson hayot kechirdi, ammo ilmiy ijodini to'xtatmadi. "Tib qonunlari"ning qolgan qismlari, "Shifo kitobi", "Najot kitobi" va "Adolat kitobi" aynan shu davrda yaratildi. Olim 1037-yilda Hamadonda 57 yoshida vafot etdi, qabri hozirgacha ziyoratgoh sifatida saqlanmoqda.
            """.trimIndent(),
            works = listOf(
                "\"Tib qonunlari\" (\"al-Qonun fit-tibb\") — Sharq va G'arbda asrlar davomida asosiy tibbiyot darsligi",
                "\"Shifo kitobi\" — falsafa va tabiiy fanlar qomusi",
                "\"Najot kitobi\" va \"Adolat kitobi\"",
                "\"Yurak uchun dorilar\" — XIX asrgacha sharq tabiblari uchun muhim qo'llanma"
            ),
            achievements = listOf(
                "Turli sohalarda 450 ga yaqin asar yozgan, ulardan 242 tasi bizgacha yetib kelgan",
                "\"Tib qonunlari\"da 800 dan ortiq dori vositasining tarkibi, xususiyati va qo'llanilishini tasvirlagan",
                "Kasalliklarning oldini olish, ekologik muhitning sog'liqqa ta'siri haqida hozirgi kunda ham dolzarb fikrlarni bildirgan",
                "Suv va havo orqali tarqaladigan ko'zga ko'rinmas mikroblar kasalliklarning asosiy sababi bo'lishi mumkinligini aytib, bu katta ilmiy kashfiyot bo'lgan",
                "Geologiya, mineralogiya va biologiya sohalarida tog'larning paydo bo'lishi, yer yuzasining o'zgarishi va zilzilalar sababi haqida fikrlar bildirgan"
            ),
            quote = "Bu fan shunday insonlarni tarbiyalashi kerakki, ular faqat o'zlari uchun emas, balki jamiyatga va uning manfaatlariga xizmat qilishga intiladi; insonda mehnatsevarlik, yuksak ma'naviyat va halollik ustun bo'lishi lozim.",
            initials = "IS",
            portraitRes = R.drawable.portrait_scholar_03
        ),

        // 4 ---------------------------------------------------------------
        Scholar(
            id = 4,
            fullName = "Abu Nasr Mansur ibn Iroq",
            shortName = "Abu Nasr ibn Iroq",
            years = "taxm. 960 – 1036",
            birthPlace = "Kiyot, Xorazm",
            categories = listOf(MATHEMATICS, ASTRONOMY),
            academy = "Xorazm Ma'mun akademiyasi",
            honorTitle = "Botlimus soniy (Ikkinchi Ptolomey)",
            shortBio = "Beruniyning ustozi, sferik trigonometriyaning asoschilaridan biri, " +
                "\"Ikkinchi Ptolomey\" unvoniga sazovor bo'lgan olim.",
            biography = """
                Abu Nasr ibn Iroq Xorazmshohlar poytaxti Kiyot shahrida tug'ilgan va shu yerdagi madrasalarda ta'lim olgan. Yoshligidanoq tabiiy fanlarga katta qiziqish bildirib, fors, yunon va lotin tillarini, shu tillardagi qo'lyozmalarni chuqur o'rgangan. Uning e'tibori ayniqsa qadimgi yunon olimlari — Yevklid, Ptolomey, Menelay, Arximed, shuningdek Al-Xorazmiy va Al-Forobiy asarlariga qaratilgan edi.

                Bu bilimlar tufayli u Ofrigiylar saroyida tanilgan olim darajasiga yetdi. Ibn Iroq ilmiy izlanishlarni o'qituvchilik bilan birga olib bordi, o'zining bir qator asarlarini iqtidorli shogirdi — Abu Rayhon Beruniyga bag'ishladi. 996-yildan 1017-yilgacha Gurganjda, Ma'mun saroyida ijod qilib, Beruniy, Ibn Sino, Abu Sahl Masihiy kabi olimlar bilan birgalikda matematika va astronomiya bo'yicha noyob asarlar yaratdi.

                1017-yilda Mahmud G'aznaviy Xorazmni bosib olganidan so'ng, Ibn Iroq G'aznaga ko'chirilgan, biroq u yerdagi faoliyati haqida ma'lumotlar bizgacha yetib kelmagan. Olim 1036-yilda G'aznada vafot etgan.
            """.trimIndent(),
            works = listOf(
                "\"Al-Majistiy ash-Shohiy\" (999–1010, Xorazmshoh Ma'mun II ga bag'ishlangan)",
                "\"Asturlob haqida risola\"",
                "\"Sfera Menelay\" sharhi",
                "Geometriya bo'yicha savol-javoblar risolasi"
            ),
            achievements = listOf(
                "Tekis va sferik uchburchaklar uchun sinuslar teoremasini birinchi bo'lib isbotlagan",
                "Arifmetika va geometriyaning kelib chiqishi, samoviy jismlarning harakat tezligi haqida ilg'or fikrlar bildirgan",
                "O'z davridayoq \"Botlimus soniy\" (\"Ikkinchi Ptolomey\") faxriy unvoniga sazovor bo'lgan",
                "Tekislik va sferik trigonometriyaning jahon matematikasidagi asoschilaridan biri sifatida tan olingan"
            ),
            quote = "Matematika aqlni rivojlantiradi va tasavvurni mustahkamlaydi; bu fan tugallanmagan mulohazalarni tushunishga o'rgatadi, chunki uning dastlabki qoidalari ma'lum, isbotlari sodda va ziddiyatlari kamdir.",
            initials = "AI",
            portraitRes = R.drawable.portrait_scholar_04
        ),

        // 5 ---------------------------------------------------------------
        Scholar(
            id = 5,
            fullName = "Abu Mahmud Hamid ibn Xidr al-Xujandiy",
            shortName = "Abu Mahmud Xo'jandiy",
            years = "taxm. 940–1000",
            birthPlace = "Xo'jand",
            categories = listOf(ASTRONOMY),
            academy = "Xorazm Ma'mun akademiyasi",
            honorTitle = "\"Asr nodir hodisasi\" (Beruniy ta'rifi)",
            shortBio = "Sekstant asbobining ixtirochisi, Beruniyning yaqin do'sti va astronomiya " +
                "asboblari ustasi.",
            biography = """
                Abu Mahmud Xo'jandiy X asr o'rtalarida o'z davrining yirik ilm-fan, hunarmandchilik va savdo markazi bo'lgan Xo'jand shahrida tug'ilgan. Yoshlik yillarini shu yerda o'tkazib, dastlabki va madrasa ta'limini oldi, matematika, astronomiya, geometriya va tibbiyotni chuqur o'rgandi. Keyinchalik Marv va Gurganj madrasalarida ham bilim oshirgan.

                Olim Rey shahriga kelganida u allaqachon Sharqda taniqli astronom edi. Rey hukmdori Faxruddavla (976–997) uni saroyiga taklif qildi. Shu yerda Xo'jandiy Tabarak tog'ida rasadxona qurilishiga bevosita rahbarlik qildi va radiusi 43 metr bo'lgan ulkan sekstantni o'zi yasadi. Bu asbob yordamida Quyoshning balandligi va yulduzlarning muvozanati kuzatildi.

                Aynan shu rasadxonada 996-yilda 22 yoshli Beruniy bilan tanishib, ular do'stlashdilar va birgalikda Rey, so'ngra Gurganjda astronomik kuzatuvlar olib bordilar. Beruniy ustozidan asturlob yasash sirlarini va astronomiyadagi ko'plab yangiliklarni o'rgangan. Keyinchalik Xo'jandiy shogirdi taklifiga ko'ra Gurganjga kelib, Ma'mun akademiyasida 1017-yilgacha ilmiy faoliyatini davom ettirdi, so'ng yana Reyga qaytib, shu yerda umrining oxirigacha yashadi.
            """.trimIndent(),
            works = listOf(
                "\"Astronomik qonunlar\"",
                "\"Mamlakat tuzilishi va joylashishini aniqlash kitobi\"",
                "\"Umumiy astronomik asboblardan foydalanish qoidalari\""
            ),
            achievements = listOf(
                "Rey shahrida radiusi 43 metr bo'lgan ulkan sekstant — \"Fahriy sekstant\"ni yaratgan",
                "Ushbu konstruksiya keyinchalik Marog'a, Samarqand va Jaypur rasadxonalarida ham qo'llanilgan",
                "Ekliptikaning og'ish burchagini yuqori aniqlik bilan o'lchagan",
                "Samarqand rasadxonasi quruvchisi Jamshid Koshiy o'z asarida Xo'jandiy sekstantiga yuksak baho bergan"
            ),
            quote = "Xo'jandiyning ilmiy kashfiyotlari va yutuqlari — bu asrning nodir hodisasidir.",
            initials = "AX",
            portraitRes = R.drawable.portrait_scholar_05
        ),

        // 6 ---------------------------------------------------------------
        Scholar(
            id = 6,
            fullName = "Abu Sahl Iso ibn Yahyo al-Masihiy",
            shortName = "Abu Sahl Masihiy",
            years = "970–1010",
            birthPlace = "Jurjon (Kaspiy dengizining janubi-sharqi)",
            categories = listOf(MEDICINE, ASTRONOMY),
            academy = "Xorazm Ma'mun akademiyasi",
            honorTitle = "Akademiya ilmiy kotibi",
            shortBio = "Tabib-olim, Ibn Sino va Beruniyning yaqin ustozi, Ma'mun akademiyasining " +
                "ilmiy kotibi sifatida faoliyat yuritgan.",
            biography = """
                Abu Sahl Masihiy 970-yilda Kaspiy dengizining janubi-sharqiy sohilidagi Jurjon shahrida tug'ilgan. U Bog'dod, Eron va Xuroson madrasalarida ta'lim olib, Sharqda taniqli olim darajasiga yetdi. Bir muddat Jurjon hukmdori Qobus ibn Vushmag'ir saroyida xizmat qilgan, 995–997-yillarda esa Xorazmga, Gurganj shahriga ko'chib o'tdi.

                1004-yildan boshlab, o'n olti yil davomida Masihiy Ma'mun akademiyasida Beruniy, Ibn Sino, Abul Hayr al-Hammor va boshqa olimlar bilan birga ishladi, akademiyaning ilmiy kotibi vazifasini bajardi. U astronomiya, matematika, tabiatshunoslik, falsafa va mantiq bo'yicha asarlar yozgan, ammo eng katta shuhratga tibbiyot sohasida erishgan.

                Masihiy Beruniy va Ibn Sino uchun tibbiyot bo'yicha ustoz bo'lib xizmat qilgan; Ibn Sino "Tib qonunlari" asarini yozishda ustozining maslahatlaridan foydalangan. 1017-yilda Mahmud G'aznaviy bosqinidan oldin Masihiy shogirdi Ibn Sino bilan birga Xurosonga yo'l oldi, biroq safar davomida og'ir kasallikka chalindi va 1010-yilda qirq yoshida vafot etdi.
            """.trimIndent(),
            works = listOf(
                "Tibbiyot, falsafa va mantiq bo'yicha bir qator risolalar (asosiy qismi bizgacha yetib kelmagan)",
                "Astronomiya va tabiatshunoslikka oid asarlar"
            ),
            achievements = listOf(
                "O'n olti yil davomida Ma'mun akademiyasining ilmiy kotibi bo'lib xizmat qilgan",
                "Ibn Sino va Beruniyga tibbiyot sohasida ustozlik qilgan",
                "Ibn Sinoning \"Tib qonunlari\" asarida uning maslahatlari va ishlanmalaridan foydalanilgan"
            ),
            quote = null,
            initials = "AM",
            portraitRes = R.drawable.portrait_scholar_06
        ),

        // 7 ---------------------------------------------------------------
        Scholar(
            id = 7,
            fullName = "Abu Mansur Abdulmalik ibn Muhammad as-Saolibiy",
            shortName = "Abu Mansur as-Saolibiy",
            years = "961–1038",
            birthPlace = "Nishopur",
            categories = listOf(HISTORY),
            academy = "Xorazm Ma'mun akademiyasi",
            honorTitle = "Olim, shoir va tarixchi",
            shortBio = "51 asar muallifi, X–XI asr Sharq olimlari va adiblari haqida bebaho " +
                "ma'lumotlar to'plagan tarixchi-adib.",
            biography = """
                Abu Mansur as-Saolibiy 961-yilda Nishopur shahrida tug'ildi. Yoshligidan tarix, adabiyot, mantiq va arab tilini chuqur o'rgangan. Og'ir turmush sharoitida yashagan olim tirikchilik uchun charmgarlik (mo'ynadan buyumlar tikish) kasbi bilan ham shug'ullangan.

                As-Saolibiy ko'p shaharlarda — Marv, G'azna, Buxoro va Xorazmda bo'lib, o'z davrining yetuk olimlari bilan suhbatlashgan, ulardan saboq olgan. Umrining so'nggi yillarini Gurganjdagi Ma'mun akademiyasida o'tkazib, bu yerda olimlar orasida katta hurmatga sazovor bo'ldi.

                Uning eng mashhur asari "Yatimat ad-dahr" (Davrning yagona durdonasi) X–XI asrlarda Markaziy Osiyo xalqlari madaniyatini o'rganish uchun nodir manba hisoblanadi. Bu asarda Beruniy bilan zamondosh bo'lgan o'nlab Xorazm olimlari, adiblari va davlat arboblari haqida qimmatli ma'lumotlar berilgan. As-Saolibiyning asarlari keyinchalik arab, fransuz, lotin, rus va o'zbek tillariga tarjima qilingan.
            """.trimIndent(),
            works = listOf(
                "\"Yatimat ad-dahr fi mahosin ahl al-asr\" (\"Davrning yagona durdonasi\")",
                "\"Kitab al-g'urur\" (\"Bilimlar kitobi\")",
                "\"Lato'if al-maorif\" (\"Bilimlar latifalari\")",
                "\"G'urar axbor muluk al-furs va siyaruhum\" (Fors hukmdorlari haqida, 4 jilddan iborat)"
            ),
            achievements = listOf(
                "51 ilmiy va adabiy asar yozgan",
                "O'z asarlarida Xorazm, Xuroson va Movarounnahrda yashagan 124 dan ortiq olim, adib va davlat arbobi haqida ma'lumot bergan",
                "\"Yatimat ad-dahr\" asari 1883 va 1947-yillarda arab tilida Bayrut va Qohirada nashr etilgan",
                "Asarlari Yevropa va Rossiya sharqshunoslari tomonidan yuqori baholangan"
            ),
            quote = null,
            initials = "AS",
            portraitRes = R.drawable.portrait_scholar_07
        ),

        // 8 ---------------------------------------------------------------
        Scholar(
            id = 8,
            fullName = "Abul Xayr ibn al-Xammor",
            shortName = "Abul Xayr ibn al-Xammor",
            years = "942–1032",
            birthPlace = "Bog'dod",
            categories = listOf(MEDICINE),
            academy = "Xorazm Ma'mun akademiyasi",
            honorTitle = "Ikkinchi Suqrot",
            shortBio = "Tibbiyot, mantiq va falsafa bo'yicha o'z davrining yetuk olimi, " +
                "Sharqda \"Ikkinchi Suqrot\" nomi bilan tanilgan.",
            biography = """
                Abul Xayr ibn al-Xammor 942-yilda Abbosiylar xalifaligi poytaxti Bog'dodda tug'ilgan. Shu yerda yetuk ustozlardan tibbiyot, mantiq va falsafani o'rgangan, o'z davrining taniqli olimlaridan biriga aylangan. Uning iqtidori, ayniqsa, tibbiyot sohasida yaqqol namoyon bo'lgan, shu sababli Sharqda unga "Ikkinchi Suqrot" faxriy nomi berilgan.

                Xorazmshoh Ma'munning taklifiga ko'ra, Ibn al-Xammor Gurganjga ko'chib o'tdi va 1017-yilgacha Ma'mun akademiyasida Beruniy va boshqa olimlar bilan hamkorlikda faoliyat yuritdi. Shu yili Mahmud G'aznaviy bosqinidan so'ng u ham boshqa olimlar qatori G'aznaga olib ketildi va shu yerda toqqa yaqin yoshda vafot etdi.

                Olim arab, fors, suriy va yunon tillarini mukammal bilgan, ko'plab kitoblarni yunon va suriy tillaridan arab tiliga tarjima qilgan. Uning tibbiyotga oid o'ndan ortiq asaridan faqat bir nechtasi bizgacha yetib kelgan.
            """.trimIndent(),
            works = listOf(
                "\"Tabiblarni sinash haqida kitob\" (Xorazmshoh Ma'munga bag'ishlangan)",
                "\"Inson xarakteri va a'zolari tuzilishi haqida kitob\"",
                "\"Homiladorlik haqida kitob\"",
                "\"Keksalarni davolash haqida kitob\""
            ),
            achievements = listOf(
                "Sharqda \"Ikkinchi Suqrot\" faxriy unvoniga sazovor bo'lgan",
                "Suriy va yunon tillaridagi ko'plab kitoblarni arab tiliga tarjima qilgan",
                "Ibn Sino \"Tib qonunlari\" asarini yozishda uning asarlaridan birinchi manba sifatida foydalangan"
            ),
            quote = null,
            initials = "AH",
            portraitRes = R.drawable.portrait_scholar_08
        ),

        // 9 ---------------------------------------------------------------
        Scholar(
            id = 9,
            fullName = "Mirzo Ulug'bek Muhammad Tarag'ay",
            shortName = "Mirzo Ulug'bek",
            years = "1394–1449",
            birthPlace = "Movarounnahr, Amir Temur sulolasi",
            categories = listOf(ASTRONOMY, STATE, MATHEMATICS),
            academy = "Samarqand rasadxonasi",
            honorTitle = "Ko'ragon",
            shortBio = "Amir Temurning nabirasi, Samarqand hukmdori va dunyodagi eng yirik " +
                "o'rta asr rasadxonalaridan birining quruvchisi.",
            biography = """
                Mirzo Ulug'bek 1394-yilda tug'ilgan, Amir Temurning nabirasi sifatida bobosi tomonidan katta mehr va e'tibor bilan tarbiyalangan. 1409-yilda otasi Shohruh Mirzo Movarounnahr boshqaruvini unga topshirdi, va 1409–1449-yillar Ulug'bek Samarqandda hukmronlik qilgan davr bo'ldi.

                Davlat ishlarini boshqarish bilan birga, Ulug'bek diniy va dunyoviy ilmlarda ham yuksak darajaga erishdi. Uning rahbarligida mamlakatda savdo, hunarmandchilik va dehqonchilik rivojlandi, Buyuk ipak yo'li orqali xalqaro savdo faollashdi, Samarqand, Buxoro, Shahrisabz va boshqa shaharlarda ko'plab madrasa, masjid, maqbara va karvonsaroylar qurildi. 1428-yilda Ulug'bek pul islohotini o'tkazib, mamlakat moliya tizimini mustahkamladi.

                1428–1429-yillarda Ulug'bek Samarqandda dunyodagi eng yirik o'rta asr rasadxonalaridan birini qurdirdi. Loyihaga ko'ra bu uch qavatli, g'orga o'xshash chuqurlikka ega dumaloq bino bo'lib, ichida diametri 46,4 metr, balandligi 30 metrdan ortiq marmar kvadrant (sekstant) joylashtirilgan edi. Bu yerda Ulug'bek, Qozizoda Rumiy, Jamshid Koshiy va Ali Qushchi kabi olimlar birgalikda ishlagan.

                1440-yillar oxiriga kelib mamlakatda ichki nizolar kuchaydi. 1449-yilda Ulug'bek o'z o'g'li Abdullatif bilan to'qnashuvda mag'lubiyatga uchradi va fojiali halok bo'ldi, akademiyasi tarqatib yuborildi. Shunga qaramay, uning ilmiy merosi — "Ziji Ko'ragoniy" — jahon astronomiyasi tarixida abadiy o'rin egalladi.
            """.trimIndent(),
            works = listOf(
                "\"Ziji Ko'ragoniy\" (\"Yangi Ko'ragoniy jadvallari\") — 430 betdan iborat, 1018 yulduz katalogini o'z ichiga olgan asar"
            ),
            achievements = listOf(
                "1428–1429-yillarda Samarqandda radiusi 40,2 metr bo'lgan ulkan sekstant (marmar kvadrant)li rasadxona qurdirgan",
                "Yulduz yilining davomiyligini 365 kun 6 soat 10 daqiqa 8 soniya deb aniqlagan",
                "1018 yulduzning koordinatalarini yangidan, yuqori aniqlik bilan kuzatib, katalog tuzgan — bu Gipparx davridan keyin shunday ishni amalga oshirgan ikkinchi astronom bo'lgan",
                "Yulduz jadvali 1648-yilda Oksford universiteti professori Jon Grivs tomonidan Yevropada birinchi marta nashr etilgan",
                "Nemis astronomi I.G. Medler 1830-yilda Oy xaritasidagi bir kraterga \"Ulug'bek\" nomini bergan"
            ),
            quote = "Samarqand rasadxonasida tuzilgan yangi yulduz katalogi o'zidan oldingi, hatto Tixo Brage davrigacha bo'lgan jadvallardan ham mukammalroq edi.",
            initials = "MU",
            portraitRes = R.drawable.portrait_scholar_09
        ),

        // 10 --------------------------------------------------------------
        Scholar(
            id = 10,
            fullName = "Salohiddin Muso ibn Muhammad Qozizoda ar-Rumiy",
            shortName = "Qozizoda Rumiy",
            years = "1360-yillar – taxm. 1437",
            birthPlace = "Bursa shahri, Rum (Kichik Osiyo)",
            categories = listOf(MATHEMATICS, ASTRONOMY),
            academy = "Samarqand rasadxonasi",
            honorTitle = "Zamonasining Platoni",
            shortBio = "Samarqand rasadxonasining birinchi rahbari, Ulug'bekning ustozi va " +
                "\"Zamonasining Platoni\" deb ulug'langan olim.",
            biography = """
                Qozizoda Rumiy 1360-yillarda Kichik Osiyodagi Bursa shahrida qozi oilasida tug'ilgan. Vatanida astronomiya va matematikadan yetarli bilim olgach, Xurosonda bo'lib, Movarounnahr — xususan Samarqandda matematika fanining yuksak rivojlanganligi haqida eshitib, shu yerga yo'l oldi. Manbalarga ko'ra, u XIV asrning so'nggi o'n yilligida Samarqandga yetib kelgan.

                Samarqandda Rumiy Temur saroyining astronomi mavlono Ahmaddan tahsil olib, bilimini yanada chuqurlashtirdi. 1405–1406-yillarda u allaqachon sayyoralar holatini ifodalovchi 200 jadval tuzgan taniqli olim edi. 1420-yillarga kelib Rumiy Ulug'bek madrasasining matematika va astronomiya bo'limiga rahbarlik qildi, 1430-yillar boshida esa kelajakda Alisher Navoiyning ustozi bo'lgan yosh Abdurahmon Jomiy uning ma'ruzalarini tinglagan.

                Ulug'bek rasadxonasi qurilishi boshlanganida, Rumiy loyihaning birinchi rahbari bo'ldi va "Ziji Ko'ragoniy"ning yozilishida ham faol ishtirok etdi. Asarning kirish qismida unga "dunyoviy ilmlarda tengsiz, charchamas tadqiqotchi" sifatida ta'rif berilgan. Rumiy rasadxona ishlari yakunlanmasidan vafot etdi; manbalarda uning o'limi 1430-yillarga to'g'ri keladi deb ko'rsatiladi. Ulug'bek ustoziga katta hurmat ko'rsatib, uning qabri ustiga go'zal gumbazli maqbara qurdirgan.
            """.trimIndent(),
            works = listOf(
                "\"Shar al-Chag'miniy\" (Chag'miniyning \"Al-Mulaxxas fi-l-hay'a\" asariga sharh)",
                "\"Al-Majistiyga sharh\"",
                "\"Sinus-kvadrant haqida risola\"",
                "\"Astronomiya va geometriya haqida risola\", \"Arifmetika haqida risola\""
            ),
            achievements = listOf(
                "Samarqand rasadxonasining birinchi rahbari bo'lgan",
                "1405–1406-yillarda sayyoralar holatini aks ettiruvchi 200 jadval tuzgan",
                "Ulug'bek madrasasining matematika va astronomiya bo'limiga boshchilik qilgan",
                "Asarlari hozirgacha Istanbul, Berlin, London, Tehron va Sankt-Peterburg kutubxonalarida saqlanmoqda"
            ),
            quote = "Mavlono Rumiy — dunyoviy ilmlarda tengsiz, obro'-e'tiborli, charchamas tadqiqotchi, xalq va din homiysi edi.",
            initials = "QR",
            portraitRes = R.drawable.portrait_scholar_10
        ),

        // 11 --------------------------------------------------------------
        Scholar(
            id = 11,
            fullName = "G'iyosiddin Jamshid ibn Mas'ud al-Koshiy",
            shortName = "G'iyosiddin Jamshid Koshiy",
            years = "taxm. 1380 – taxm. 1437",
            birthPlace = "Koshon shahri, Eron",
            categories = listOf(MATHEMATICS, ASTRONOMY),
            academy = "Samarqand rasadxonasi",
            honorTitle = "Ikkinchi Ptolomey",
            shortBio = "Samarqand rasadxonasi qurilishiga rahbarlik qilgan, bir gradusning " +
                "sinusini hisoblash usulini ixtiro qilgan buyuk matematik.",
            biography = """
                G'iyosiddin Jamshid Koshiy Eronning Koshon shahrida tug'ilgan; bu hudud 1387-yilda Amir Temur tomonidan zabt etilgan edi. Koshonda yaxshi ta'lim olgach, u Iroqning ko'plab shaharlarida bo'lib, Samarqandga kelishidan oldin allaqachon matematika va astronomiyada salmoqli bilimga ega edi. 1408, 1409 va 1410-yillardagi oy tutilishlarini kuzatib, ularning batafsil tasvirini Shohruxga (Ulug'bekning otasi) bag'ishlangan, 1414-yilda yozilgan "Ziji Xoqoniy" asarida keltirgan.

                Samarqandga kelgach, Koshiy Ulug'bek rasadxonasi qurilishida ikkinchi rahbar va asosiy loyihachilardan biri bo'ldi. Qozizoda Rumiy uni "zamonamizning nodir insoni" deb ta'riflagan va uning geometriya va algebra teoremalariga asoslanib bir gradusning sinus qiymatini aniq hisoblash usulini ixtiro qilganini alohida ta'kidlagan — bu masalani undan oldin ko'plab olimlar hal qila olmagan edi.

                Tarixchi Mirxond uni "ikkinchi Ptolomey, astronomiya fanining tayanchi" deb atagan, Davlatshoh Samarqandiy esa Ulug'bek davridagi olimlar orasida koinot va matematika ilmida Koshiyga teng keladigan kishi bo'lmaganini yozgan. Koshiyning o'limi sanasi haqida manbalarda turlicha fikrlar bor — ba'zi tadqiqotchilar 1429-yilni, boshqalari taxminan 1437–1440-yillarni ko'rsatadi.
            """.trimIndent(),
            works = listOf(
                "\"Arifmetika kaliti\"",
                "\"Bir gradusning sinusini aniqlash haqida risola\"",
                "\"Ziji Xoqoniy\" (Ilxoniy zijini takomillashtirish)",
                "\"Astronomiya haqida risola\" va \"Astronomiya ilmining qisqacha bayoni\""
            ),
            achievements = listOf(
                "Geometriya va algebra teoremalariga asoslanib, bir gradusning sinus qiymatini hisoblash usulini ixtiro qilgan",
                "Samarqand rasadxonasi qurilishiga bevosita rahbarlik qilgan",
                "1408–1410-yillardagi oy tutilishlari haqida aniq kuzatuv ma'lumotlarini qoldirgan — bu ma'lumotlar keyinchalik nemis astronomi T. Oppolserning \"Tutilishlar kanoni\" (1887) asarida tasdiqlangan",
                "19 ga yaqin astronomiya va matematika risolasi muallifi"
            ),
            quote = "Mening qadrli birodarim, davrimizning nodir kishisi, geometriya va algebra qonunlariga tayanib, bir gradus sinusini aniq hisoblash yo'lini topdi.",
            initials = "GK",
            portraitRes = R.drawable.portrait_scholar_11
        ),

        // 12 --------------------------------------------------------------
        Scholar(
            id = 12,
            fullName = "Alauddin Ali ibn Muhammad al-Qushchi",
            shortName = "Ali Qushchi",
            years = "1402–1474",
            birthPlace = "Samarqand",
            categories = listOf(ASTRONOMY, MATHEMATICS),
            academy = "Samarqand rasadxonasi",
            honorTitle = "Zamonasining Ptolomeyi",
            shortBio = "Ulug'bek rasadxonasining so'nggi rahbari, \"Ziji Ulug'bek\"ka sharh " +
                "yozgan va Samarqand ilmiy maktabi merosini Istanbulga olib borgan olim.",
            biography = """
                Alauddin Ali ibn Muhammad al-Qushchi taxminan 1402-yilda Samarqandda tug'ilgan va yoshligidan Mirzo Ulug'bek homiyligida tarbiyalangan. "Qushchi" (lochinchi) laqabi uning saroyda qush — lochin boqish bilan shug'ullangan davriga borib taqaladi. Ulug'bek unga "o'g'lim" deb murojaat qilgan va uning astronomiyaga bo'lgan qiziqishini uyg'otishda muhim rol o'ynagan.

                Astronomiyaga bo'lgan chuqur qiziqishi tufayli Ali Qushchi rasadxonada ishlay boshladi va vaqt o'tishi bilan Ulug'bekning nafaqat ilmiy hamkasbi, balki yaqin do'sti ham bo'ldi. Qarmanada qo'shimcha ta'lim olgach, u Ulug'bekning ishonchli shogirdi va yordamchisiga aylandi, astronomik kuzatuvlardagi mahorati va chuqur bilimi uchun "Zamonasining Ptolomeyi" unvoniga sazovor bo'ldi.

                Qozizoda Rumiy va Jamshid Koshiy vafotidan so'ng, Ulug'bek rasadxona rahbarligini Ali Qushchiga topshirdi. Ulug'bek vafotidan keyin ham (1449-yildan keyin) u Samarqandda ilmiy faoliyatini davom ettirdi, jumladan Temuriy hukmdor Abdussaid Mirzoga o'zining "Shah at-Tajrid al-kalom" asarini bag'ishladi. Ma'lumotlarga ko'ra, u 1471-yilgacha Samarqandda ishlagan, so'ngra Tabrizga, keyin 1473-yil fevralda Istanbulga ko'chib o'tdi va u yerda Usmonli ilmiy hayotiga katta hissa qo'shdi. Olim 1474-yilda Istanbulda vafot etgan va Abu Ayub Ansoriy maqbarasi yonida dafn etilgan.
            """.trimIndent(),
            works = listOf(
                "\"Ziji Ulug'bekka sharh\"",
                "\"Astronomiya ilmi haqida risola\"",
                "\"Geometrik masalalar va astronomiya\"",
                "Sulton Mehmed II ga bag'ishlangan arifmetika va geometriya risolalari",
                "\"Xitoynoma\" (tarixiy asar)"
            ),
            achievements = listOf(
                "Qozizoda Rumiy va Jamshid Koshiy vafotidan so'ng Samarqand rasadxonasiga rahbarlik qilgan",
                "Rasadxona faoliyatini Ulug'bek vafotidan keyin ham, taxminan 1471-yilgacha davom ettirgan",
                "Samarqand ilmiy maktabi an'analarini Tabriz va Istanbulga olib borgan, Usmonli ilm-fanining rivojlanishiga hissa qo'shgan",
                "\"Zamonasining Ptolomeyi\" faxriy unvoniga sazovor bo'lgan"
            ),
            quote = "Ilm-fan maydonida qilich kabi o'tkir bo'lgan Ali ibn Muhammad al-Qushchining shuhrati tez orada bizning davlatimiz va dunyoning boshqa qismlariga ham tarqaladi.",
            initials = "AQ",
            portraitRes = R.drawable.portrait_scholar_12
        ),

        // 13 --------------------------------------------------------------
        Scholar(
            id = 13,
            fullName = "Nizomiddin Abdal Ali ibn Muhammad al-Birjandiy",
            shortName = "Nizomiddin al-Birjandiy",
            years = "XV–XVI asr",
            birthPlace = "Birjand, Xuroson",
            categories = listOf(ASTRONOMY, HISTORY),
            academy = "Samarqand rasadxonasi maktabi (Mo'inuddin Koshiyning shogirdi)",
            honorTitle = null,
            shortBio = "\"Ziji Ulug'bek\"ka batafsil sharh yozgan, Samarqand astronomiya " +
                "maktabi merosini keyingi avlodlarga yetkazgan olim-huquqshunos.",
            biography = """
                Nizomiddin al-Birjandiy Samarqand rasadxonasi an'analarini davom ettirgan olimlar avlodiga mansub. Tarixchi Abdurazzoq Samarqandiyning yozishicha, Koshondan Samarqandga taklif etilgan yana bir astronom Mo'inuddin bo'lgan, uning o'g'li Mansur ham astronom bo'lib yetishgan. Al-Birjandiy aynan shu Mansurning shogirdi edi.

                Al-Birjandiy Chag'miniyning "Al-Mulaxxas" asariga Qozizoda Rumiy tomonidan boshlangan sharhni yakunlagan va shu bilan birga "Ziji Ulug'bek"ka, Al-Majistiy (Almagest)ga va Nosiruddin Tusiyning asarlariga ham keng qamrovli sharhlar yozgan. Uning sharhlarida Samarqand rasadxonasining asbob-uskunalari, ulardagi o'lchov usullari va olingan astronomik kattaliklar batafsil tahlil etilgan — bu ma'lumotlar keyingi tadqiqotchilar uchun asosiy manbalardan biriga aylangan.

                Umrining so'nggi yillarini Isfahon shahrida, shoh Tahmasp II saroyida maslahatchi sifatida o'tkazgan. Al-Birjandiy o'z davrida astronomiya bilan bir qatorda huquqshunoslik (fiqh) sohasida ham obro'li olim sifatida tanilgan.
            """.trimIndent(),
            works = listOf(
                "\"Astronomiya haqida risola\"",
                "\"Kalendar haqida yigirma bob\"",
                "\"Al-Majistiyga sharh\"",
                "\"Ziji Ulug'bekka sharh\"",
                "\"Masofa va iqlimni o'lchash usullari haqida risola\""
            ),
            achievements = listOf(
                "\"Ziji Ulug'bek\"ka eng batafsil sharhlardan birini yozgan",
                "Samarqand rasadxonasidagi \"Faxriy sekstant\" asbobining ishlash tartibini batafsil tasvirlab qoldirgan",
                "Ekliptikaning og'ish burchagi bo'yicha turli davr olimlarining natijalarini qiyosiy tahlil qilgan",
                "Isfahon saroyida shoh maslahatchisi sifatida xizmat qilgan"
            ),
            quote = "Faxriy sekstant yordamida yoy soniyalarigacha o'lchov olish mumkin; Samarqand astronomlari ekliptikaning og'ishini ushbu asbob bilan, Quyoshning zenitdan uzoqlashishi orqali aniqlaganlar.",
            initials = "NB",
            portraitRes = R.drawable.portrait_scholar_13
        )
    )

    fun getById(id: Int): Scholar? = scholars.find { it.id == id }

    fun getByCategory(category: ScholarCategory?): List<Scholar> =
        if (category == null) scholars
        else scholars.filter { category in it.categories }

    fun search(query: String): List<Scholar> {
        if (query.isBlank()) return scholars
        val q = query.trim().lowercase()
        return scholars.filter {
            it.fullName.lowercase().contains(q) ||
                it.shortName.lowercase().contains(q) ||
                it.academy.lowercase().contains(q) ||
                it.categories.any { c -> c.displayName.lowercase().contains(q) }
        }
    }
}
