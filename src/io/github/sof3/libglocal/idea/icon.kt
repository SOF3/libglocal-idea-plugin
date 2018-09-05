package io.github.sof3.libglocal.idea

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

/*
 * libglocal-idea-plugin
 *
 * Copyright 2018 SOFe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

object Icons {
	val LIBGLOCAL = icon("libglocal")
	val MODULE = icon("module")
	val GROUP = icon("group")
	val MESSAGE = icon("message")
	val ARG = icon("arg")
}

data class IconGroup(val px13: Icon, val px16: Icon)

private fun icon(name: String) = IconGroup(
		IconLoader.getIcon("/icons/$name-13px.png"),
		IconLoader.getIcon("/icons/$name-16px.png")
)
