package com.sadhen.binding.util

import com.thoughtworks.binding.Binding.{BindingSeq, Constants, Var}
import com.thoughtworks.binding.dom

object BindingRange {
  def apply(end: Int): Constants[Int] = {
    Constants(Range(0, end): _*)
  }
}
