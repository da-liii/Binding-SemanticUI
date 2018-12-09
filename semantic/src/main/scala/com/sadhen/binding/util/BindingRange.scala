package com.sadhen.binding.util

import com.thoughtworks.binding.Binding.{BindingSeq, Constants, Var}
import com.sadhen.binding.magic.ant

object BindingRange {
  def apply(end: Int): Constants[Int] = {
    Constants(Range(0, end): _*)
  }
}
