/*
 * Copyright 2018 Florian Steitz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.fsteitz.jsoup.extension

import org.jsoup.nodes.Element
import java.util.Optional

/**
 * @author Florian Steitz (florian@fsteitz.com)
 */
val filterByTagName = { element: Element, tagName: String -> element.tagName() == tagName }

/**
 *
 */
fun Element.firstChild(tagName: String): Optional<Element> {
  return firstChild { filterByTagName(it, tagName) }
}

/**
 *
 */
fun Element.firstChild(predicate: (Element) -> Boolean): Optional<Element> {
  return Optional.ofNullable(children(predicate).firstOrNull())
}

/**
 *
 */
fun Element.children(tagName: String): Collection<Element> {
  return children { filterByTagName(it, tagName) }
}

/**
 *
 */
fun Element.children(predicate: (Element) -> Boolean): Collection<Element> {
  return children().filter(predicate)
}

/**
 *
 */
fun Element.selectFirst(cssQuery: String): Optional<Element> {
  return Optional.ofNullable(select(cssQuery).firstOrNull())
}