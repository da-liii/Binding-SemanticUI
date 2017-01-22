package com.sadhen.binding.component

import com.sadhen.binding.component.impl.PaginationBuilder
import com.thoughtworks.binding.dom

/**
  * Created by rendong on 17/1/23.
  */
package object tag {
  implicit final class Pagination(x: dom.Runtime.TagsAndTags2.type) {
    def Pagination = PaginationBuilder()
  }
}
