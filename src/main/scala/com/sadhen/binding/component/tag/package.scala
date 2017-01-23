package com.sadhen.binding.component

import com.sadhen.binding.component.dataentry.{AutoCompleteBuilder, InputNumberBuilder}
import com.sadhen.binding.component.navigation.PaginationBuilder
import com.thoughtworks.binding.dom

/**
  * Created by rendong on 17/1/23.
  */
package object tag {
  // navigation
  implicit final class Pagination(x: dom.Runtime.TagsAndTags2.type) {
    def Pagination = PaginationBuilder()
  }

  // dataentry
  implicit final class AutoComplete(x: dom.Runtime.TagsAndTags2.type) {
    def AutoComplete = AutoCompleteBuilder()
  }

  implicit final class InputNumber(x: dom.Runtime.TagsAndTags2.type) {
    def InputNumber = InputNumberBuilder()
  }
}
