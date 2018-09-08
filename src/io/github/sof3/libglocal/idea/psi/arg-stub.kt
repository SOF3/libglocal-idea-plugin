package io.github.sof3.libglocal.idea.psi

import com.intellij.psi.stubs.*
import com.intellij.psi.util.PsiTreeUtil
import io.github.sof3.libglocal.idea.LibglocalLanguage
import io.github.sof3.libglocal.idea.libglocal.ValueField
import io.github.sof3.libglocal.idea.libglocal.deserializeField
import io.github.sof3.libglocal.idea.libglocal.serializeField
import io.github.sof3.libglocal.idea.libglocal.valueFieldFromModifier
import io.github.sof3.libglocal.idea.parser.StubKeys
import io.github.sof3.libglocal.idea.psi.impl.LgcArgModifierImpl

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

interface LgcArgStub : StubElement<LgcArgModifier> {
	val parent: String
	val field: ValueField
}

class LgcArgStubImpl(parentStub: StubElement<*>,
                     override val parent: String,
                     override val field: ValueField) : StubBase<LgcArgModifier>(parentStub, LgcArgStubElementType), LgcArgStub {
	constructor(parentStub: StubElement<*>, e: LgcArgModifier) : this(parentStub,
			(PsiTreeUtil.findFirstParent(e) { it is LgcMessage } as LgcMessage).fullName,
			valueFieldFromModifier(e)
	)
}

object LgcArgStubElementType : IStubElementType<LgcArgStub, LgcArgModifier>("ARG_STUB", LibglocalLanguage) {
	override fun createPsi(stub: LgcArgStub) = LgcArgModifierImpl(stub, this)

	override fun createStub(psi: LgcArgModifier, parentStub: StubElement<*>) = LgcArgStubImpl(parentStub, psi)

	override fun getExternalId() = "libglocal.stub.arg"

	override fun serialize(stub: LgcArgStub, output: StubOutputStream) {
		output.writeName(stub.parent)
		serializeField(stub.field, output)
	}

	override fun deserialize(input: StubInputStream, parent: StubElement<*>) =
			LgcArgStubImpl(parent, input.readNameString()!!, deserializeField(input))

	override fun indexStub(stub: LgcArgStub, sink: IndexSink) {
		sink.occurrence(StubKeys.ARG_PARENT, stub.parent)
		sink.occurrence(StubKeys.ARG_CANONICAL, stub.parent + "\$" + stub.field.name)
	}
}
