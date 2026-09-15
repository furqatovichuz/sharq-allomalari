package uz.edu.sharqallomalari.data

import uz.edu.sharqallomalari.model.GlossaryTerm

/**
 * Astronomiya atamalari lug'ati. Fayzullayeva Saodat Dilshodovnaning
 * "Vostochnaya astronomiya" o'quv qo'llanmasidagi Glossariy bo'limi
 * asosida o'zbek tiliga tarjima qilingan.
 */
object GlossaryRepository {

    val terms: List<GlossaryTerm> = listOf(
        GlossaryTerm("Albedo", "Osmon jismlarining yorug'likni aks ettirish qobiliyatini ifodalovchi miqdor. Masalan, Yer uchun albedo 45% ga teng."),
        GlossaryTerm("Apeks", "Harakat yo'nalishi tomon yo'naltirilgan osmon sferasidagi nuqta."),
        GlossaryTerm("Asteroid", "Lotincha so'z, \"yulduzga o'xshash\" degan ma'noni bildiradi. Asteroidlar — buzilgan sayyoralarning qoldiqlari bo'lib, ular \"kichik sayyoralar\" deb ham ataladi. Asteroidlarning asosiy qismi (98%) Mars va Yupiter orbitalari orasida joylashgan. Hozirgi vaqtda 30 000 dan ortiq kichik sayyora aniqlangan. Ular orasida Beruniy, Ulug'bek, Ibn Sino, Xorazmiy, shuningdek O'zbekiston, Samarqand va Maydanak nomi bilan atalgan asteroidlar bor."),
        GlossaryTerm("Astrograf", "Osmon yoritqichlarini (yulduzlarni) suratga olish uchun mo'ljallangan maxsus teleskop."),
        GlossaryTerm("Astronomik rasadxona", "Osmon yoritqichlarini muntazam kuzatish va astronomiya sohasida tadqiqotlar olib borish uchun mo'ljallangan ilmiy-tadqiqot muassasasi."),
        GlossaryTerm("Astronomiya", "Lotincha so'z, \"yulduzlar haqidagi qonun\" degan ma'noni bildiradi. U yulduzlar, sayyoralar, kometalar, asteroidlar va meteorlarning kelib chiqishi, tuzilishi, harakati va rivojlanishini o'rganadi. Astronomiya fani qadimgi Misr, Xitoy va Bobilda paydo bo'lgan."),
        GlossaryTerm("Astrospektrograf", "Osmon jismlarining nurlanish spektrini qayd etish uchun asbob."),
        GlossaryTerm("Astrofotometr", "Osmon jismlaridan keladigan yorug'lik oqimini o'lchash uchun asbob. Uning asosiy elementi — fotoelement."),
        GlossaryTerm("Atmosfera", "Yerni o'rab turgan havo qobig'i, ya'ni gaz qobig'i bo'lib, uning umumiy massasi 5,15·10¹⁸ kg ni tashkil etadi. Tarkibi: 78,09% azot, 20,95% kislorod, 0,97% argon va boshqa inert gazlar. Atmosfera quyidagi qatlamlarga bo'linadi: troposfera, stratosfera, mezosfera, termosfera va ekzosfera."),
        GlossaryTerm("Maunder kapalaklari", "Quyosh dog'larining shimoliy va janubiy yarim sharlardagi geliografik kengliklarining vaqt davomida o'zgarishini ko'rsatuvchi diagramma."),
        GlossaryTerm("Biosfera", "Lotincha so'z, \"hayot sferasi\" degan ma'noni bildiradi. Biosfera — Yerning hayot mavjud bo'lgan qobig'i. Bu atamani birinchi marta avstriyalik olim E. Zyuss kiritgan, keyinroq uni rus olimi V.I. Vernadskiy rivojlantirgan. Biosferaga atmosferaning troposferasi, Yerning litosferasi va gidrosferasi kiradi."),
        GlossaryTerm("Galaktika", "Lotincha so'z, \"sutli\" degan ma'noni bildiradi. O'rganilgan Koinot qismida (Metagalaktikada) taxminan 10¹¹ ta galaktika mavjud bo'lib, ular guruhlarga birlashadi. Yer sayyorasi Quyosh sistemasiga, Quyosh sistemasi — Somon yo'li galaktikasiga, u esa o'z navbatida — Mahalliy galaktikalar guruhiga kiradi."),
        GlossaryTerm("Gamma-astronomiya", "Osmon jismlarining gamma-nurlanishini o'rganuvchi umumiy astronomiyaning bo'limi."),
        GlossaryTerm("Gidrosfera", "Lotincha so'z, \"suv qobig'i\" degan ma'noni bildiradi, ya'ni Yerning suv bilan qoplangan qismi. Gidrosfera Yer yuzasining 70,2% ini egallaydi. Agar Yerning umumiy maydoni 519 million km² bo'lsa, gidrosferaning maydoni 361 million km² ga teng."),
        GlossaryTerm("Ufq", "Yer yuzasining ko'rinadigan qismi yoki inson kuzata oladigan fazo. Ufq aylana shaklida bo'lib, uning markazida kuzatuvchi joylashgan. U balandlikka bog'liq: balandlik ortishi bilan ufq kengayadi. Shuning uchun rasadxonalar tog'larda quriladi."),
        GlossaryTerm("Yulduz to'plamlari", "Bizning Galaktikamizda uchraydigan, bir-biri bilan bog'langan (tortishish kuchi bilan bog'langan), soni bir necha yuzdan bir necha minggacha bo'lgan yulduzlar tizimi."),
        GlossaryTerm("Kometa", "Lotincha so'z, \"sochli\" degan ma'noni bildiradi. Bu siyrak gazdan iborat yirik osmon jismi. Kometalar Quyosh atrofida kuchli cho'zilgan (ekssentrik) orbitalar bo'ylab harakatlanadi. Ular ikki turga bo'linadi: davriy va nodavriy. Davriy kometalar Quyoshga bir necha marta qaytib keladi, nodavriy kometalar esa faqat bir marta kuzatiladi, chunki Quyoshga yaqinlashganda butunlay parchalanib ketishi mumkin. Kometa yadro, koma (qobiq), bosh va dumdan iborat."),
        GlossaryTerm("Kosmonavtika", "Lotincha so'z, \"kema boshqarish san'ati\" degan ma'noni bildiradi. Bu kosmik parvozlar va raketa texnikasi haqidagi fan. Nazariy kosmonavtikaning asoschisi Keldish, amaliy kosmonavtikaning asoschisi esa Korolyov hisoblanadi."),
        GlossaryTerm("Kulminatsiya", "Osmon jismining ufqqa nisbatan eng yuqori yoki eng past nuqtadagi holati."),
        GlossaryTerm("Litosfera", "Lotincha so'z, \"qattiq (tosh) qobiq\" degan ma'noni bildiradi. Bu Yerning qalinligi taxminan 33 km bo'lgan, asosan kislorod va kremniydan iborat yuqori qatlami."),
        GlossaryTerm("Oy", "Yerning yagona tabiiy yo'ldoshi. O'lchami jihatidan Yerdan taxminan 4 marta kichik va 81 marta yengil. Atmosferaga ega emas. Oy Quyoshga nisbatan Yer atrofida 29,53 sutkada (sinodik davr) aylanib chiqadi va shu vaqt ichida o'z o'qi atrofida bir marta aylanadi, shuning uchun Oydagi sutka va yil bir-biriga to'g'ri keladi. Yulduzlarga nisbatan Oy 27,32 sutkada (siderik davr) aylanib chiqadi. Yer va Oy orasidagi o'rtacha masofa 384 400 km ni tashkil etadi."),
        GlossaryTerm("Magma", "Lotincha so'z, \"quyuq massa\" (yoki \"quyuq modda\") degan ma'noni bildiradi. Yer markaziga yaqinlashgan sari harorat ortib boradi, va markazda u Quyosh fotosferasi haroratiga teng bo'ladi. Shunday yuqori haroratlar natijasida magma deb ataluvchi erigan moddalar majmuasi hosil bo'ladi. Magmatik qatlam doimiy ravishda Avacha vulqoni (Rossiya) ostida mavjud."),
        GlossaryTerm("Manyovr", "Harakat yo'nalishini turli usullar bilan o'zgartirish."),
        GlossaryTerm("Mantiya", "Lotincha so'z, \"yopinchiq\" yoki \"qobiq\" degan ma'noni bildiradi. Litosfera va Yerning tashqi yadrosi orasida joylashgan. Mantiya qalinligi taxminan 2900 km, zichligi — (2700–5700) kg/m³."),
        GlossaryTerm("Mahorat", "Bilim va hayotiy tajriba asosida amaliy harakatlarni (jumladan, o'qitishni) minimal vaqt va kuch sarflab bajarish."),
        GlossaryTerm("Mezosfera", "Lotincha so'z, \"o'rta qatlam\" degan ma'noni bildiradi. Yer atmosferasida 55–85 km balandlikda joylashgan. Unda butun atmosfera massasining taxminan 0,3% i to'plangan."),
        GlossaryTerm("Meteorit yog'ini", "Yerning parchalangan kometa qoldiqlari bilan to'qnashishi natijasida yuzaga keladi. Bu tabiiy meteorit yog'ini deb ataladi. Sun'iy meteorit yog'inlari antropogen ta'sir natijasida hosil bo'ladi."),
        GlossaryTerm("Multimedia vositalari", "Turli turdagi ma'lumotlarni (matn, tasvirlar, sxemalar, jadvallar, diagrammalar va boshqalar) raqamli ko'rinishda yaratish, saqlash, qayta ishlash va taqdim etish uchun kompyuter vositalari."),
        GlossaryTerm("Ko'nikma", "Insonning bilim, oddiy tajriba va malakalar asosida vazifani muvaffaqiyatli bajarish qobiliyati."),
        GlossaryTerm("Malaka", "Bilimlar ko'nikma bosqichini bosib o'tib, barqaror faoliyat shakliga aylanib, mahoratga aylanadigan daraja."),
        GlossaryTerm("Sayyora", "Lotincha so'z, \"sayoqi\" degan ma'noni bildiradi. Quyosh sistemasida 8 ta sayyora bor: Merkuriy, Venera, Yer, Mars, Yupiter, Saturn, Uran, Neptun. Sayyoralar taxminan 5 milliard yil oldin hosil bo'lgan."),
        GlossaryTerm("Nurlanish oqimi", "Vaqt birligi davomida berilgan yuzadan (masalan, ko'z qorachig'i yoki teleskop kirish teshigidan) o'tadigan nur energiyasi miqdori."),
        GlossaryTerm("Kasbga yo'naltirish", "Jamiyat ehtiyojlariga muvofiq kasb tanlashda ma'lumot berish va yordam ko'rsatishga qaratilgan tizim."),
        GlossaryTerm("Pulsarlar", "Qat'iy davriy elektromagnit nurlanish manbalari."),
        GlossaryTerm("Radioastronomiya", "Osmon jismlarining radiodiapazondagi nurlanishini o'rganuvchi umumiy astronomiyaning bo'limi."),
        GlossaryTerm("Radionurlanish", "Osmon obyektlaridan uzluksiz radiochastotalar diapazonida keladigan radiosignallar oqimi."),
        GlossaryTerm("Radioteleskop", "Osmon jismlarini radioto'lqinlar diapazonida o'rganish uchun mo'ljallangan astronomik asbob."),
        GlossaryTerm("Sochilgan yulduz to'plamlari", "Soni bir necha o'ndan bir necha minggacha bo'lgan yulduzlar to'plami."),
        GlossaryTerm("Rentgen astronomiyasi", "Osmon jismlarining rentgen nurlanishini o'rganuvchi astronomiyaning bo'limi."),
        GlossaryTerm("Refraktsiya", "Osmon jismlaridan keladigan yorug'lik nurlarining atmosfera qatlamlarida sinishi hodisasi."),
        GlossaryTerm("Saros", "Yunoncha \"saros\" — \"takrorlanish\" so'zidan; quyosh va oy tutilishlarining bir xil ketma-ketlikda takrorlanish davri. Tutilishlar Quyosh Oy orbitasining tugunlariga (Oy orbitasi bilan Quyoshning ko'rinma yillik yo'lining kesishish nuqtalariga) yaqin bo'lganda, yangi oy yoki to'lin oy paytida yuz beradi. Saros davomiyligi taxminan 18 yil 11 sutka 7 soat 42 minutni tashkil etadi. Bir saros davomida taxminan 41 quyosh va 29 oy tutilishi yuz beradi."),
        GlossaryTerm("Seyfert galaktikalari", "Ularni birinchi marta kuzatgan astronom Seyfert nomi bilan atalgan spiral galaktikalar."),
        GlossaryTerm("Sekstant", "Yulduzning ufqdan balandligini yoki ufq va yulduz orasidagi burchakni o'lchash uchun asbob; u 60° lik yoydan iborat."),
        GlossaryTerm("Quyosh shamoli", "Quyoshdan chiqadigan siyrak korpuskulyar zarrachalar oqimi."),
        GlossaryTerm("Spektral tahlil", "Nurlanish spektri bo'yicha nurlanish manbaining kimyoviy tarkibi, harorati, magnit maydoni, harakat tezligi (nur tezligi) va boshqa fizik xususiyatlarini aniqlash usuli."),
        GlossaryTerm("Fotokatod", "Fotoelementning yorug'likka sezgir qatlami.")
    )
}
