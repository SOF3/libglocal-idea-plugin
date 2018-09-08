package io.github.sof3.libglocal.idea.libglocal

import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import io.github.sof3.libglocal.idea.catchNull
import io.github.sof3.libglocal.idea.psi.LgcArgModifier

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

enum class ValueKind {
	UNKNOWN,
	BOOL,
	INT,
	FLOAT,
	OBJECT,
	LIST;
}

open class ValueType(
		val kind: ValueKind,
		val listLevels: Int,
		val fields: List<ValueField> = emptyList()
) {

	companion object {
		val UNKNOWN = ValueType(ValueKind.UNKNOWN, 0)
	}
}

class ValueField(
		val name: String,
		kind: ValueKind, listLevels: Int, fields: List<ValueField> = emptyList()) :
		ValueType(kind, listLevels, fields) {

	companion object {
		fun unknown(name: String) = ValueField(name, ValueKind.UNKNOWN, 0)
	}
}

fun valueFieldFromModifier(arg: LgcArgModifier): ValueField? {
	val argType = arg.argType
	val kind = catchNull(IllegalArgumentException::class) {
		ValueKind.valueOf(argType?.id?.text?.toUpperCase() ?: "string")
	} ?: return null
	val listLevels = argType?.flagList?.count { it.text.toLowerCase() == "list:" } ?: 0

	val type = ValueField(arg.argName.text, kind, listLevels)

	for (field in arg.fieldConstraintList) {

	}

	return type
}

fun serializeField(field: ValueField, output: StubOutputStream) {
	output.writeName(field.name)
	output.writeName(field.kind.name)
	output.writeVarInt(field.listLevels)
	output.writeVarInt(field.fields.size)
	for (child in field.fields) {
		serializeField(child, output)
	}
}

fun deserializeField(input: StubInputStream): ValueField {
	val name = input.readNameString()!!
	val kind = ValueKind.valueOf(input.readNameString()!!)
	val listLevels = input.readVarInt()

	val fields = MutableList(input.readVarInt()) { deserializeField(input) }

	return ValueField(name, kind, listLevels, fields)
}
