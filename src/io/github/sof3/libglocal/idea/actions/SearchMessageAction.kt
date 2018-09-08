package io.github.sof3.libglocal.idea.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex
import com.intellij.ui.components.JBTextField
import io.github.sof3.libglocal.idea.psi.LibglocalBlockMessage
import io.github.sof3.libglocal.idea.psi.StubKeys
import javax.swing.JComponent

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
class SearchMessageAction : AnAction("Search message", "for debugging", null) {
	override fun actionPerformed(e: AnActionEvent) {

		val project = e.project
		if (project == null) {
			println("e.project is null")
			return
		}
		val dialog = object : DialogWrapper(project) {
			var field: JBTextField? = null

			init {
				init()
				title = "Search message"
			}

			override fun createCenterPanel(): JComponent? {
				field = JBTextField("")
				field!!.setSize(100, 100)
				return field
			}
		}
		dialog.show()
		if (dialog.exitCode != DialogWrapper.OK_EXIT_CODE) return

		val id = dialog.field!!.text ?: ""
		println("Searching for [$id]")

		val elements = StubIndex.getElements(StubKeys.MESSAGE, id, project, GlobalSearchScope.allScope(project), LibglocalBlockMessage::class.java)
		for (element in elements) {
			println(element)
		}
	}
}
