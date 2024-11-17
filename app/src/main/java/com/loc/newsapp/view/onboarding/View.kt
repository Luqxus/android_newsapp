package com.loc.newsapp.view.onboarding

import androidx.annotation.DrawableRes
import com.loc.newsapp.R


data class View (
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val views = listOf(
    View(
        title = "Stay Informed, Stay Ahead",
        description = "Get the latest news, updates, and trending stories—tailored just for you. Our app brings the world to your fingertips. Stay connected, stay ahead with personalized, real-time news.",
        image = R.drawable.onboarding1
    ),

    View(
        title = "News That Matters to You",
        description = "Choose your interests and let us bring the stories that matter most. From global headlines to local happenings, curate your own personalized news experience.",
        image = R.drawable.onboarding2
    ),

    View(
        title = "Real-Time Updates, Anytime",
        description = "Receive breaking news alerts and follow live updates as they unfold. Be the first to know with notifications for the topics you care about most. Stay informed, wherever you are.",
        image = R.drawable.onboarding3
    ),
)