package com.vicon.viconbackend.features.contest.service

import com.vicon.viconbackend.domain.contest.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.TestConstructor
import java.math.BigDecimal
import java.time.LocalDateTime

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@Rollback(false)
class ContestServiceTest(
    val contestRepository: ContestRepository
) {

    @Test
    fun `컨테스트를 저장하고 불러올수있다`() {
        val contest = Contest(
            type = ContestType.STANDARD,
            category = "기업 홍보",
            title = "강서구 사회적기업 홍보",
            name = "도라지 정과",
            text = "강서구에 있는 도라지 정과 업체입니다.\n" +
                    "\n" +
                    "저희 제품의 장점은 haccp 인증 받은 제품이며 모두 진공 포장상태의 6개월 이상의 보관 기간과 정성을 다한 포장으로 선물용으로 제격인 제품입니다.\n" +
                    "\n" +
                    "스타트업 기업이기에 홍보비용에 한계가 있어 유튜브 영상을 통해 제품 및 기업 홍보를 함께 하고자 합니다.\n" +
                    "\n" +
                    "저희 회사가 소수의 인원이 함께 하고 있으나 한분한분이 모두 정성을 다해 제품생산에 땀을 흘리고 계십니다.\n" +
                    "\n" +
                    "이분들과 함께 좋은 영상 제작을 희망하며, 좋은 아이디어로 재미있는 영상 제작이 가능하신분들은 언제나 환영합니다.\n" +
                    "\n" +
                    "많이 참여해 주시기 바랍니다~",
            contentsStyle = ContentsStyle.REVIEW,
            reward = BigDecimal(1000000),
            isPaidAds = false,
            adsPrice = "300000원",
            isBurdenFee = true,
            recruitDeadLineDate = LocalDateTime.of(2021, 9, 30, 0, 0, 0),
            contentsCompletedDate = LocalDateTime.of(2021, 10, 30, 0, 0, 0),
            cashReceiptType = CashReceiptType.DEDUCTION,
            cashReceiptIssuanceType = '1',
            cashReceiptsNumber = "123123123",
            isIssuedTaxInvoice = false,
            taxInvoiceNumber = "789789879",
            isConfirmed = false,
            isPaidReward = false,
            isCompletedContents = false,

            totalPaymentPrice = BigDecimal(561000),
            orderNumber = "20210731112721_2_25"
        )

        val savedContest = contestRepository.save(contest)

        assertEquals(1, savedContest.id)
    }
}