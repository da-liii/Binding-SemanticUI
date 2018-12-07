package com.sadhen.binding.component

import com.sadhen.binding.component.datadisplay.TableBuilder
import com.sadhen.binding.component.dataentry._
import com.sadhen.binding.component.navigation.PaginationBuilder
import com.sadhen.binding.component.general.IconBuilder
import com.thoughtworks.binding.dom

/**
  * Created by rendong on 17/1/23.
  */
package object tag {
  // General
  implicit final class Icon(x: dom.Runtime.TagsAndTags2.type) {
    def Icon = IconBuilder()
  }

  // Navigation
  implicit final class Pagination(x: dom.Runtime.TagsAndTags2.type) {
    def Pagination = PaginationBuilder()
  }

  // Data Entry
  implicit final class Rate(x: dom.Runtime.TagsAndTags2.type) {
    def Rate = RateBuilder()
  }

  implicit final class AutoComplete(x: dom.Runtime.TagsAndTags2.type) {
    def AutoComplete = AutoCompleteBuilder()
  }

  implicit final class InputNumber(x: dom.Runtime.TagsAndTags2.type) {
    def InputNumber = InputNumberBuilder()
  }

  // Data Display
  implicit final class Table(x: dom.Runtime.TagsAndTags2.type) {
    def Table = TableBuilder()
  }

}
