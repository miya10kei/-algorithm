package com.miya10kei.algorithms


fun <T> Array<in T>.linearSearch(key: T): Boolean {
  this.forEach {
    if (it == key) {
      return true
    }
  }
  return false
}
