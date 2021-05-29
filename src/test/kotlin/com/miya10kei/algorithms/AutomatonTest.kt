package com.miya10kei.algorithms

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class AutomatonTest {
  private lateinit var automaton: Automaton

  @BeforeEach
  fun setup() {
    val q0 = State(name = "q0", default = true, accepted = false)
    val q1 = State(name = "q1", default = false, accepted = false)
    val q2 = State(name = "q2", default = false, accepted = false)
    val q3 = State(name = "q3", default = false, accepted = true)

    val transitionQ0 = { s: Char ->
      when (s) {
        'A' -> q1
        'B' -> q2
        else -> throw IllegalArgumentException()
      }
    }
    val transitionQ1 = { s: Char ->
      when (s) {
        'A' -> q1
        'B' -> q3
        else -> throw IllegalArgumentException()
      }
    }
    val transitionQ2 = { s: Char ->
      when (s) {
        'A' -> q3
        'B' -> q2
        else -> throw IllegalArgumentException()
      }
    }
    val transitionQ3 = { s: Char ->
      when (s) {
        'A' -> q3
        'B' -> q3
        else -> throw IllegalArgumentException()
      }
    }

    val transitions = mapOf(q0 to transitionQ0, q1 to transitionQ1, q2 to transitionQ2, q3 to transitionQ3)
    this.automaton = Automaton(transitions)
  }

  @ValueSource(strings = ["AAB", "ABB", "ABA", "BBA", "BAA", "BAB"])
  @ParameterizedTest
  fun Expect_Accepted(input: String) {
    // when
    input.forEach { automaton.transit(it) }
    // then
    assertThat(automaton.isAccepted).isTrue
  }

  @ValueSource(strings = ["AAA", "BBB"])
  @ParameterizedTest
  fun Expect_NotAccepted(input: String) {
    // when
    input.forEach { automaton.transit(it) }
    // then
    assertThat(automaton.isAccepted).isFalse
  }
}
