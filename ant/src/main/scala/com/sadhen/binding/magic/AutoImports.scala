package com.sadhen.binding.magic

import org.scalajs.dom.raw._

/**
  * This object contains implicit views imported automatically for @dom methods.
  */
object AutoImports {

  implicit final class DataOps @inline()(node: Element) {

    import scala.language.dynamics

    object data extends Dynamic {

      final def selectDynamic(attributeName: String): String = {
        node.getAttribute(attributeName)
      }

      final def updateDynamic(attributeName: String)(attributeValue: String): Unit = {
        node.setAttribute(attributeName, attributeValue)
      }

    }

  }

  implicit final class OptionOps @inline()(node: Element) {

    import scala.language.dynamics

    object option extends Dynamic {

      final def selectDynamic(attributeName: String): Option[String] = {
        if (node.hasAttribute(attributeName)) {
          Some(node.getAttribute(attributeName))
        } else {
          None
        }
      }

      final def updateDynamic(attributeName: String)(attributeValue: Option[String]): Unit = {
        attributeValue.fold(node.removeAttribute(attributeName))(node.setAttribute(attributeName, _))
      }

    }

  }

  implicit final class ClassOps @inline()(node: HTMLElement) {
    @inline def `class` = node.className

    @inline def class_=(value: String) = node.className = value
  }

  implicit final class ForOps @inline()(node: HTMLLabelElement) {
    @inline def `for` = node.htmlFor

    @inline def for_=(value: String) = node.htmlFor = value
  }

  /**
    * @param node HTMLDialogElement or HTMLDetailElement
    */
  implicit final class OpenOps @inline()(node: Element { var open: Boolean }) {
    @inline def open = node.getAttribute("open")
    @inline def open_=(value: String) = node.setAttribute("open", value)
  }

  implicit final class MultipleOps @inline()(node: Element { var multiple: Boolean }) {
    @inline def multiple = node.getAttribute("multiple")
    @inline def multiple_=(value: String) = node.setAttribute("multiple", value)
  }

  implicit final class FormNoValidateOps @inline()(node: Element { var formNoValidate: Boolean }) {
    @inline def formNoValidate = node.getAttribute("formNoValidate")
    @inline def formNoValidate_=(value: String) = node.setAttribute("formNoValidate", value)
  }

  implicit final class NoValidateOps @inline()(node: HTMLFormElement) {
    @inline def noValidate = node.getAttribute("noValidate")
    @inline def noValidate_=(value: String) = node.setAttribute("noValidate", value)
  }

  implicit final class ControlsOps @inline()(node: HTMLMediaElement) {
    @inline def controls = node.getAttribute("controls")
    @inline def controls_=(value: String) = node.setAttribute("controls", value)
  }

  implicit final class LoopOps @inline()(node: HTMLMediaElement) {
    @inline def loop = node.getAttribute("loop")
    @inline def loop_=(value: String) = node.setAttribute("loop", value)
  }

  implicit final class SelectedOps @inline()(node: Element { var selected: Boolean }) {
    @inline def selected = node.getAttribute("selected")
    @inline def selected_=(value: String) = node.setAttribute("selected", value)
  }

  implicit final class MutedOps @inline()(node: HTMLMediaElement) {
    @inline def muted = node.getAttribute("muted")
    @inline def muted_=(value: String) = node.setAttribute("muted", value)
  }

  implicit final class SpellcheckOps @inline()(node: HTMLElement) {
    @inline def spellcheck = node.getAttribute("spellcheck")
    @inline def spellcheck_=(value: String) = node.setAttribute("spellcheck", value)
  }

  implicit final class DraggableOps @inline()(node: HTMLElement) {
    @inline def draggable = node.getAttribute("draggable")
    @inline def draggable_=(value: String) = node.setAttribute("draggable", value)
  }

  implicit final class AutoplayOps @inline()(node: HTMLMediaElement) {
    @inline def autoplay = node.getAttribute("autoplay")
    @inline def autoplay_=(value: String) = node.setAttribute("autoplay", value)
  }

  implicit final class RequiredOps @inline()(node: Element { var required: Boolean }) {
    @inline def required = node.getAttribute("required")
    @inline def required_=(value: String) = node.setAttribute("required", value)
  }

  implicit final class AutofocusOps @inline()(node: Element { var autofocus: Boolean }) {
    @inline def autofocus = node.getAttribute("autofocus")
    @inline def autofocus_=(value: String) = node.setAttribute("autofocus", value)
  }

  implicit final class CheckedOps @inline()(node: Element { var checked: Boolean }) {
    @inline def checked = node.getAttribute("checked")
    @inline def checked_=(value: String) = node.setAttribute("checked", value)
  }

  implicit final class DisabledOps @inline()(node: Element { var disabled: Boolean }) {
    @inline def disabled = node.getAttribute("disabled")
    @inline def disabled_=(value: String) = node.setAttribute("disabled", value)
  }

  implicit final class ReadOnlyOps @inline()(node: Element { var readOnly: Boolean }) {
    @inline def readOnly = node.getAttribute("readOnly")
    @inline def readOnly_=(value: String) = node.setAttribute("readOnly", value)
  }
  implicit final class DefaultOps @inline()(node: HTMLTrackElement) {
    @inline def default = node.getAttribute("default")
    @inline def default_=(value: String) = node.setAttribute("default", value)
  }

  implicit final class PlaysInlineOps @inline()(node: HTMLVideoElement) {
    @inline def playsInline = node.getAttribute("playsInline")
    @inline def playsInline_=(value: String) = node.setAttribute("playsInline", value)
  }

  implicit final class TypeMustMatchOps @inline()(node: HTMLObjectElement) {
    @inline def typeMustMatch = node.getAttribute("typeMustMatch")
    @inline def typeMustMatch_=(value: String) = node.setAttribute("typeMustMatch", value)
  }

  implicit final class TranslateOps @inline()(node: HTMLElement) {
    @inline def translate = node.getAttribute("translate")
    @inline def translate_=(value: String) = node.setAttribute("translate", value)
  }

  implicit final class HiddenOps @inline()(node: HTMLElement) {
    @inline def hidden = node.getAttribute("hidden")
    @inline def hidden_=(value: String) = node.setAttribute("hidden", value)
  }

  implicit final class ReversedOps @inline()(node: HTMLOListElement) {
    @inline def reversed = node.getAttribute("reversed")
    @inline def reversed_=(value: String) = node.setAttribute("reversed", value)
  }

  implicit final class IsMapOps @inline()(node: HTMLImageElement) {
    @inline def isMap = node.getAttribute("isMap")
    @inline def isMap_=(value: String) = node.setAttribute("isMap", value)
  }

  implicit final class AllowFullscreenOps @inline()(node: HTMLIFrameElement) {
    @inline def allowFullscreen = node.getAttribute("allowFullscreen")
    @inline def allowFullscreen_=(value: String) = node.setAttribute("allowFullscreen", value)
  }

  implicit final class AllowPaymentRequestOps @inline()(node: HTMLIFrameElement) {
    @inline def allowPaymentRequest = node.getAttribute("allowPaymentRequest")
    @inline def allowPaymentRequest_=(value: String) = node.setAttribute("allowPaymentRequest", value)
  }

  implicit final class AllowUserMediaOps @inline()(node: HTMLIFrameElement) {
    @inline def allowUserMedia = node.getAttribute("allowUserMedia")
    @inline def allowUserMedia_=(value: String) = node.setAttribute("allowUserMedia", value)
  }
  implicit final class NoShadeOps @inline()(node: HTMLHRElement) {
    @inline def noShade = node.getAttribute("noShade")
    @inline def noShade_=(value: String) = node.setAttribute("noShade", value)
  }
  implicit final class NoWrapOps @inline()(node: HTMLTableCellElement) {
    @inline def noWrap = node.getAttribute("noWrap")
    @inline def noWrap_=(value: String) = node.setAttribute("noWrap", value)
  }
  implicit final class DeclareOps @inline()(node: HTMLObjectElement) {
    @inline def declare = node.getAttribute("declare")
    @inline def declare_=(value: String) = node.setAttribute("declare", value)
  }

  implicit final class TrueSpeedOps @inline()(node: HTMLMarqueeElement) {
    @inline def trueSpeed = node.getAttribute("trueSpeed")
    @inline def trueSpeed_=(value: String) = node.setAttribute("trueSpeed", value)
  }

  implicit final class NoResizeOps @inline()(node: HTMLFrameElement) {
    @inline def noResize = node.getAttribute("noResize")
    @inline def noResize_=(value: String) = node.setAttribute("noResize", value)
  }

  implicit final class NoHrefOps @inline()(node: HTMLAreaElement) {
    @inline def noHref = node.getAttribute("noHref")
    @inline def noHref_=(value: String) = node.setAttribute("noHref", value)
  }

  implicit final class CompactOps @inline()(node: Element { var compact: Boolean }) {
    @inline def compact = node.getAttribute("compact")
    @inline def compact_=(value: String) = node.setAttribute("compact", value)
  }
  implicit final class AsyncOps @inline()(node: HTMLScriptElement) {
    @inline def async = node.getAttribute("async")
    @inline def async_=(value: String) = node.setAttribute("async", value)
  }

  implicit final class DeferOps @inline()(node: HTMLScriptElement) {
    @inline def defer = node.getAttribute("defer")
    @inline def defer_=(value: String) = node.setAttribute("defer", value)
  }

  implicit final class NoModuleOps @inline()(node: HTMLScriptElement) {
    @inline def noModule = node.getAttribute("noModule")
    @inline def noModule_=(value: String) = node.setAttribute("noModule", value)
  }

  @inline def workaroundUnusedImport() = ()
}

