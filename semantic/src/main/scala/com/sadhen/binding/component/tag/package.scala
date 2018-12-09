package com.sadhen.binding.component

import com.sadhen.binding.component.datadisplay.TableBuilder
import com.sadhen.binding.component.dataentry._
import com.sadhen.binding.component.feedback.ProgressBuilder
import com.sadhen.binding.component.navigation.PaginationBuilder
import com.sadhen.binding.component.general.{ButtonBuilder, IconBuilder}
import com.sadhen.binding.magic.ant

/**
  * Ref:
  *   - [[https://github.com/ThoughtWorksInc/Binding.scala/issues/4]]
  */
package object tag {
  // General
  implicit final class Icon(x: ant.Runtime.TagsAndTags2.type) {
    def Icon = new IconBuilder
  }

  implicit final class Button(x: ant.Runtime.TagsAndTags2.type) {
    def Button = new ButtonBuilder
  }

  // Navigation
  implicit final class Pagination(x: ant.Runtime.TagsAndTags2.type) {
    def Pagination = new PaginationBuilder
  }

  // Data Entry
  implicit final class Rate(x: ant.Runtime.TagsAndTags2.type) {
    def Rate = new RateBuilder
  }

  implicit final class AutoComplete(x: ant.Runtime.TagsAndTags2.type) {
    def AutoComplete = new AutoCompleteBuilder
  }

  implicit final class InputNumber(x: ant.Runtime.TagsAndTags2.type) {
    def InputNumber = new InputNumberBuilder
  }

  // Data Display
  implicit final class Table(x: ant.Runtime.TagsAndTags2.type) {
    def Table = new TableBuilder
  }

  // Feedback
  implicit final class Progress(x: ant.Runtime.TagsAndTags2.type) {
    def Progress = new ProgressBuilder
  }

}
