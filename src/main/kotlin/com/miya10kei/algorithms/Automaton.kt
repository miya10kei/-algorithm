package com.miya10kei.algorithms

class State(
  val name: String,
  val default: Boolean,
  val accepted: Boolean
)

class Automaton(
  private val transitions: Map<State, (input: Char) -> State>
) {
  private var currentState: State =
    transitions.keys.find { it.default } ?: throw IllegalArgumentException("Not find default State!")

  val currentStateName
    get() = this.currentState.name

  val isAccepted
    get() = this.currentState.accepted

  fun transit(input: Char) {
    this.currentState = this.transitions[this.currentState]?.invoke(input) ?: throw IllegalArgumentException()
  }
}
