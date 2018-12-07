package com.sadhen.binding

import io.udash.wrappers.jquery.JQuery

import scala.language.implicitConversions
import scala.scalajs.js

/**
  * Created by rendong on 17/1/2.
  */
object SemanticUI {
  @js.native
  trait SemanticJQuery extends JQuery {
    def dropdown(params: js.Any*): SemanticJQuery = js.native
    def search(params: js.Any*): SemanticJQuery = js.native
    def modal(params: js.Any*): SemanticJQuery = js.native
  }

  implicit def jq2semantic(jq: JQuery): SemanticJQuery = jq.asInstanceOf[SemanticJQuery]
}
