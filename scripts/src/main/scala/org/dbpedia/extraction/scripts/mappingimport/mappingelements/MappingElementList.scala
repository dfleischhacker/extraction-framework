package org.dbpedia.extraction.scripts.mappingimport.mappingelements

import scala.language.implicitConversions

/**
 * Utility class providing a mkString equivalent for getting the mapping syntax of {@code MappingElement} lists.
 *
 * @author Daniel Fleischhacker <daniel@informatik.uni-mannheim.de>
 */
class MappingElementList(val elements: List[MappingElement]) {
  def mkMappingString(start: String, sep: String, end: String): String = {
    val sb = new StringBuilder()
    var first = true

    sb.append(start)
    for (x <- elements) {
      if (first) {
        sb.append(x.getMappingSyntax())
        first = false
      }
      else {
        sb.append(sep)
        sb.append(x.getMappingSyntax())
      }
    }

    sb.append(end)

    sb.toString()
  }

  def mkMappingString(sep: String): String = {
    mkMappingString("", sep, "")
  }
}

object MappingElementList {
  implicit def wrapMappingElementList(elements: List[MappingElement]) = new MappingElementList(elements)
}