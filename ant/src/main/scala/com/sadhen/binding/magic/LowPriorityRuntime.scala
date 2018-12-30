package com.sadhen.binding.magic

trait LowPriorityRuntime {
  @inline
  final def notEqual[A, B](left: A, right: B, dummy: Unit = ()) = left != right
}
