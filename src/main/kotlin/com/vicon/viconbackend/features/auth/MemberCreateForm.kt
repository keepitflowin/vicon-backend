package com.vicon.viconbackend.features.auth

data class MemberCreateForm(
    val mem_id: String = "",
    val mem_pw: String = "",
    val mem_pw2: String = "",

    val mem_hp1: String? = "",
    val mem_hp2: String? = "",
    val mem_hp3: String? = "",

    val mem_email1: String? = "",
    val mem_email2: String? = "",

    val mem_company: String? = "",
    val mem_service: String? = "",
    val mem_website: String? = "",
    val mem_business_type: String? = "",

    val mem_ch_url: String? = "",
    val mem_ch_category: String = "",
    val mem_ch_subscriber: String? = "",
    val channelType: List<String> = mutableListOf(),

    val mem_sba : Boolean? = false,
)