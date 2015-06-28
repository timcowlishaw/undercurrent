import xml.{NodeSeq,XML}
import org.fusesource.scalate._
package com.undercurrentapp.web {
  class TemplateRenderer(rootPath : String) {
    val engine = new TemplateEngine
    val extension = ".mustache"
    def render(templateName : String, parameters : Map[String, String] = Map.empty) : NodeSeq = {
      val templatePath = rootPath + templateName + extension;
      XML.loadString(engine.layout(templatePath, parameters))
    }
  }
}
