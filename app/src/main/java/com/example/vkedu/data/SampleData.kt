package com.example.vkedu.data

import com.example.vkedu.R

val appsList = listOf(
    App(
        id = 1,
        name = "СберБанк Онлайн — с Салютом",
        description = "Больше чем банк",
        category = Category.FINANCE,
        iconRes = R.drawable.ic_baseline_account_balance_24
    ),
    App(
        id = 2,
        name = "Яндекс.Браузер — с Алисой",
        description = "Быстрый и безопасный браузер",
        category = Category.INSTRUMENTS,
        iconRes = R.drawable.ic_baseline_browser_24
    ),
    App(
        id = 3,
        name = "Почта Mail.ru",
        description = "Почтовый клиент для любых ящиков",
        category = Category.INSTRUMENTS,
        iconRes = R.drawable.ic_baseline_email_24
    ),
    App(
        id = 4,
        name = "Яндекс Навигатор",
        description = "Парковки и заправки - по пути",
        category = Category.TRANSPORT,
        iconRes = R.drawable.ic_baseline_navigator_24
    ),
    App(
        id = 5,
        name = "Мой МТС",
        description = "Мой МТС — центр экосистемы МТС",
        category = Category.INSTRUMENTS,
        iconRes = R.drawable.ic_baseline_phone_android_24
    ),
    App(
        id = 6,
        name = "Яндекс — с Алисой",
        description = "Яндекс — поиск всегда под рукой",
        category = Category.INSTRUMENTS,
        iconRes = R.drawable.ic_baseline_search_24
    )
)