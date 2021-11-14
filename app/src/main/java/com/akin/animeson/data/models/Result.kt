package com.akin.animeson.data.models

data class Result(
    val Bolumler: List<String>,
    val DiziAdi: String,
    val DownloadUrl: String,
    val KapakVideo: List<String>,
    val Konu: String,
    val Like: Int,
    val ResimUrl: String,
    val Statu: String,
    val Tur: String,
    val Unlike: Int,
    val animeKapakList: List<String>,
    val createdAt: String,
    val date: Date,
    val eklendimi: Int,
    val fansub: List<String>,
    val gunlukIzlenme: Int,
    val myAnime: Int,
    val objectId: String,
    val tiklenmeSayisi: Int,
    val updatedAt: String
)