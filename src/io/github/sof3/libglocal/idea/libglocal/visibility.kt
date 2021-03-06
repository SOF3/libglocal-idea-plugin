package io.github.sof3.libglocal.idea.libglocal

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

enum class MessageVisibility(val explicit: Boolean = true) {
	PUBLIC(explicit = false),
	LIB,
	LOCAL;

	val lowName = name.toLowerCase()
	val syntax = if (explicit) "$lowName:" else ""

	companion object {
		val DEFAULT = PUBLIC
	}
}
