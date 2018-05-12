package io.github.sof3.libglocal.idea;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class LibglocalFileTypeFactory extends FileTypeFactory{
	@Override
	public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer){
		fileTypeConsumer.consume(LibglocalFileType.getInstance(), "lang");
	}
}
