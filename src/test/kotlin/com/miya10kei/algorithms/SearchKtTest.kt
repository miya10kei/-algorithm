package com.miya10kei.algorithms

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.random.Random

internal class SearchKtTest {
  companion object {
    private const val SIZE = 10_000_000
  }

  @Nested
  inner class LinearSearchTest {
    @Test
    fun Expect_ReturnTrue__When_GivenExistedValue() {
      // given
      val array = Array(SIZE) { Random.nextInt(0, Int.MAX_VALUE) }.apply {
        this[Random.nextInt(0, SIZE - 1)] = 100
      }
      // when
      val actual = array.linearSearch(100)
      // then
      assertThat(actual).isTrue
    }

    @Test
    fun Expect_ReturnFalse__When_GivenNotExistedValue() {
      // given
      val array = Array(SIZE) { Random.nextInt(0, Int.MAX_VALUE - 1) }
      // when
      val actual = array.linearSearch(Int.MAX_VALUE)
      // then
      assertThat(actual).isFalse
    }
  }
}
