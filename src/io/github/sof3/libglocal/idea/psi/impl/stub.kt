package io.github.sof3.libglocal.idea.psi.impl

import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.*
import io.github.sof3.libglocal.idea.LibglocalLanguage
import io.github.sof3.libglocal.idea.MessageVisibility
import io.github.sof3.libglocal.idea.psi.LibglocalBlockMessage
import io.github.sof3.libglocal.idea.psi.MessageStub

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

object MessageStubElementType :
		IStubElementType<MessageStub, LibglocalBlockMessage>("LIBGLOCAL_MESSAGE", LibglocalLanguage) {
	override fun createPsi(stub: MessageStub): LibglocalBlockMessage {
		return LibglocalBlockMessageImpl(stub, this)
	}

	override fun createStub(psi: LibglocalBlockMessage, parent: StubElement<PsiElement?>): MessageStub {
		// this is where the AST is read into stub values
		return MessageStubImpl(parent, psi.fullName, psi.visibility)
	}

	override fun getExternalId(): String {
		return "libglocal.stub.message";
	}

	override fun serialize(stub: MessageStub, stream: StubOutputStream) {
		stream.writeName(stub.fullName)
		stream.writeName(stub.visibility.name)
	}

	override fun deserialize(stream: StubInputStream, parent: StubElement<PsiElement?>): MessageStub {
		return MessageStubImpl(parent,
				stream.readNameString()!!,
				MessageVisibility.valueOf(stream.readNameString()!!))
	}

	override fun indexStub(stub: MessageStub, sink: IndexSink) {

	}
}

class MessageStubImpl(
		parent: StubElement<PsiElement?>,
		override val fullName: String,
		override val visibility: MessageVisibility
) : StubBase<LibglocalBlockMessage>(parent, MessageStubElementType),
		MessageStub {
}
