package com.fiap.appemail.user.data

import com.fiap.appemail.R


data class MailItem(
    val profileId: Int,
    val senderName: String,
    val mailSubject: String,
    val mailContent: String,
    val mailDate: String,

    )

val mailsList = listOf(
    MailItem(
        profileId = R.drawable.google_logo,
        senderName = "Google",
        mailSubject = "Job offer",
        mailContent = "god's sake end this",
        mailDate = "24 Aug",
    ),
    MailItem(
        profileId = R.drawable.facebook_logo,
        senderName = "Facebook",
        mailSubject = "Android dev role",
        mailContent = "I can't no more...",
        mailDate = "21 feb",
    ),
    )