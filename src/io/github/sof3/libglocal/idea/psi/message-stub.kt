package io.github.sof3.libglocal.idea.psi

import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.*
import io.github.sof3.libglocal.idea.LibglocalLanguage
import io.github.sof3.libglocal.idea.libglocal.MessageVisibility
import io.github.sof3.libglocal.idea.parser.StubKeys
import io.github.sof3.libglocal.idea.psi.impl.LgcMessageImpl

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

interface LgcMessageStub : StubElement<LgcMessage> {
	val module: String
	val lang: String
	val fullName: String
	val visibility: MessageVisibility
}

class LgcMessageStubImpl(
		parent: StubElement<PsiElement?>,
		override val module: String,
		override val lang: String,
		override val fullName: String,
		override val visibility: MessageVisibility
) :
		StubBase<LgcMessage>(parent, LgcMessageStubElementType), LgcMessageStub {

	constructor(parent: StubElement<PsiElement?>, e: LgcMessage) : this(parent,
			e.file.messages!!.messageId.text!!,
			e.file.lang!!.langId.text!!,
			e.fullName,
			e.visibility
	)
}

object LgcMessageStubElementType :
		IStubElementType<LgcMessageStub, LgcMessage>("MESSAGE_STUB", LibglocalLanguage) {
	override fun createPsi(stub: LgcMessageStub) = LgcMessageImpl(stub, this)

	override fun createStub(psi: LgcMessage, parentStub: StubElement<PsiElement?>) = LgcMessageStubImpl(parentStub, psi)

	override fun getExternalId() = "libglocal.stub.message"

	override fun serialize(stub: LgcMessageStub, output: StubOutputStream) {
		output.writeName(stub.module)
		output.writeName(stub.lang)
		output.writeName(stub.fullName)
		output.writeName(stub.visibility.name)
	}

	override fun deserialize(input: StubInputStream, parentStub: StubElement<PsiElement?>)= LgcMessageStubImpl(
			parentStub,
			input.readNameString()!!,
			input.readNameString()!!,
			input.readNameString()!!,
			MessageVisibility.valueOf(input.readNameString()!!)
	)

	override fun indexStub(stub: LgcMessageStub, sink: IndexSink) {
		sink.occurrence(StubKeys.MESSAGE_MODULE, stub.module)
		sink.occurrence(StubKeys.MESSAGE_CANONICAL, stub.fullName)
	}
}
