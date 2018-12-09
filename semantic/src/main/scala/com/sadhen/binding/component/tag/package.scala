package com.sadhen.binding.component

import com.sadhen.binding.component.datadisplay.TableBuilder
import com.sadhen.binding.component.dataentry._
import com.sadhen.binding.component.feedback.ProgressBuilder
import com.sadhen.binding.component.navigation.PaginationBuilder
import com.sadhen.binding.component.general.{ButtonBuilder, IconBuilder}
import com.thoughtworks.binding.dom

/**
  * Ref:
  *   - [[https://github.com/ThoughtWorksInc/Binding.scala/issues/4]]
  */
package object tag {
  // General
  implicit final class Icon(x: dom.Runtime.TagsAndTags2.type) {
    def Icon = new IconBuilder
  }

  implicit final class Button(x: dom.Runtime.TagsAndTags2.type) {
    def Button = new ButtonBuilder
  }

  // Navigation
  implicit final class Pagination(x: dom.Runtime.TagsAndTags2.type) {
    def Pagination = new PaginationBuilder
  }

  // Data Entry
  implicit final class Rate(x: dom.Runtime.TagsAndTags2.type) {
    def Rate = new RateBuilder
  }

  implicit final class AutoComplete(x: dom.Runtime.TagsAndTags2.type) {
    def AutoComplete = new AutoCompleteBuilder
  }

  implicit final class InputNumber(x: dom.Runtime.TagsAndTags2.type) {
    def InputNumber = new InputNumberBuilder
  }

  // Data Display
  implicit final class Table(x: dom.Runtime.TagsAndTags2.type) {
    def Table = new TableBuilder
  }

  // Feedback
  implicit final class Progress(x: dom.Runtime.TagsAndTags2.type) {
    def Progress = new ProgressBuilder
  }

}
