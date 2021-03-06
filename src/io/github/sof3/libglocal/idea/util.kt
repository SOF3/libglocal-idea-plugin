package io.github.sof3.libglocal.idea

import kotlin.reflect.KClass

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

fun <R, T: Throwable> catchNull(c: KClass<T>, f: () -> R): R? {
	try{
		return f()
	}catch(e: Throwable){
		if(c.isInstance(e)){
			return null
		}
		throw e;
	}
}
