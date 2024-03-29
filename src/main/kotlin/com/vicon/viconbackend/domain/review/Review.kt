package com.vicon.viconbackend.domain.review

import com.vicon.viconbackend.domain.common.Auditable
import com.vicon.viconbackend.domain.contest.Contest
import com.vicon.viconbackend.domain.member.Member
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne

@Entity
data class Review(
    var title: String? = "",

    @Column(name = "content", columnDefinition = "text")
    var content: String? = "",

    var youtubeUrl: String? = "",
    var star: String? = "",

    @ManyToOne(fetch = FetchType.LAZY)
    var contest: Contest? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    var member: Member? = null

) : Auditable<Long>()