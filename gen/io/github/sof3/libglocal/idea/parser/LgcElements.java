// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.parser;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.github.sof3.libglocal.idea.psi.impl.*;

public interface LgcElements {

  IElementType ARGS_ENTRY = new LgcElementType("ARGS_ENTRY");
  IElementType ARGS_SUPPLIER = new LgcElementType("ARGS_SUPPLIER");
  IElementType ARGS_VALUE = new LgcElementType("ARGS_VALUE");
  IElementType ARGS_VALUE_STRING = new LgcElementType("ARGS_VALUE_STRING");
  IElementType ARG_DEFAULT = new LgcElementType("ARG_DEFAULT");
  IElementType ARG_MODIFIER = StubTypeFactory.argModifier("ARG_MODIFIER");
  IElementType ARG_NAME = new LgcElementType("ARG_NAME");
  IElementType ARG_REF = new LgcElementType("ARG_REF");
  IElementType ARG_TYPE = new LgcElementType("ARG_TYPE");
  IElementType AUTHOR = new LgcElementType("AUTHOR");
  IElementType AUTHOR_NAME = new LgcElementType("AUTHOR_NAME");
  IElementType DELIM_CONSTRAINT = new LgcElementType("DELIM_CONSTRAINT");
  IElementType DOC_CONSTRAINT = new LgcElementType("DOC_CONSTRAINT");
  IElementType DOC_CONTENT = new LgcElementType("DOC_CONTENT");
  IElementType DOC_MODIFIER = new LgcElementType("DOC_MODIFIER");
  IElementType FIELD_CONSTRAINT = new LgcElementType("FIELD_CONSTRAINT");
  IElementType FLAG = new LgcElementType("FLAG");
  IElementType ID = new LgcElementType("ID");
  IElementType LANG = new LgcElementType("LANG");
  IElementType LANG_ID = new LgcElementType("LANG_ID");
  IElementType LANG_NAME = new LgcElementType("LANG_NAME");
  IElementType LITERAL = new LgcElementType("LITERAL");
  IElementType LITERAL_STATIC = new LgcElementType("LITERAL_STATIC");
  IElementType MESSAGE = StubTypeFactory.message("MESSAGE");
  IElementType MESSAGES = new LgcElementType("MESSAGES");
  IElementType MESSAGE_GROUP = new LgcElementType("MESSAGE_GROUP");
  IElementType MESSAGE_ID = new LgcElementType("MESSAGE_ID");
  IElementType MESSAGE_REF = new LgcElementType("MESSAGE_REF");
  IElementType REQUIRE = new LgcElementType("REQUIRE");
  IElementType REQUIRE_TARGET = new LgcElementType("REQUIRE_TARGET");
  IElementType SPAN = new LgcElementType("SPAN");
  IElementType VERSION = new LgcElementType("VERSION");
  IElementType VERSION_MODIFIER = new LgcElementType("VERSION_MODIFIER");
  IElementType VERSION_VALUE = new LgcElementType("VERSION_VALUE");

  IElementType K_AUTHOR = new LgcTokenType("K_AUTHOR");
  IElementType K_BASE_LANG = new LgcTokenType("K_BASE_LANG");
  IElementType K_LANG = new LgcTokenType("K_LANG");
  IElementType K_MESSAGES = new LgcTokenType("K_MESSAGES");
  IElementType K_REQUIRE = new LgcTokenType("K_REQUIRE");
  IElementType K_VERSION = new LgcTokenType("K_VERSION");
  IElementType T_ARG_REF_START = new LgcTokenType("${");
  IElementType T_CLOSE_BRACE = new LgcTokenType("}");
  IElementType T_COMMENT = new LgcTokenType("comment");
  IElementType T_CONT_CONCAT = new LgcTokenType("T_CONT_CONCAT");
  IElementType T_CONT_NEWLINE = new LgcTokenType("T_CONT_NEWLINE");
  IElementType T_CONT_SPACE = new LgcTokenType("T_CONT_SPACE");
  IElementType T_DYNAMIC = new LgcTokenType("$");
  IElementType T_EMPTY_LINE = new LgcTokenType("empty line");
  IElementType T_EOL = new LgcTokenType("newline");
  IElementType T_EQUALS = new LgcTokenType("=");
  IElementType T_FLAG = new LgcTokenType("identifier flag");
  IElementType T_IDENTIFIER = new LgcTokenType("identifier");
  IElementType T_INDENT_DEDENT = new LgcTokenType("decrease indent");
  IElementType T_INDENT_INDENT = new LgcTokenType("increase indent");
  IElementType T_INDENT_INHERIT = new LgcTokenType("indent");
  IElementType T_INDENT_INVALID = new LgcTokenType("invalid indent");
  IElementType T_INSTRUCTION = new LgcTokenType("#");
  IElementType T_LITERAL_ESCAPE = new LgcTokenType("T_LITERAL_ESCAPE");
  IElementType T_LITERAL_INVALID_ESCAPE = new LgcTokenType("invalid literal escape");
  IElementType T_LITERAL_STRING = new LgcTokenType("T_LITERAL_STRING");
  IElementType T_MESSAGE_REF_START = new LgcTokenType("#{");
  IElementType T_MODIFIER_ARG = new LgcTokenType("T_MODIFIER_ARG");
  IElementType T_MODIFIER_DOC = new LgcTokenType("*");
  IElementType T_MODIFIER_VERSION = new LgcTokenType("~");
  IElementType T_NUMBER = new LgcTokenType("number");
  IElementType T_OPEN_BRACE = new LgcTokenType("{");
  IElementType T_SPAN_START = new LgcTokenType("%{");
  IElementType T_SPAN_TYPE = new LgcTokenType("span type");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ARGS_ENTRY) {
        return new LgcArgsEntryImpl(node);
      }
      else if (type == ARGS_SUPPLIER) {
        return new LgcArgsSupplierImpl(node);
      }
      else if (type == ARGS_VALUE) {
        return new LgcArgsValueImpl(node);
      }
      else if (type == ARGS_VALUE_STRING) {
        return new LgcArgsValueStringImpl(node);
      }
      else if (type == ARG_DEFAULT) {
        return new LgcArgDefaultImpl(node);
      }
      else if (type == ARG_MODIFIER) {
        return new LgcArgModifierImpl(node);
      }
      else if (type == ARG_NAME) {
        return new LgcArgNameImpl(node);
      }
      else if (type == ARG_REF) {
        return new LgcArgRefImpl(node);
      }
      else if (type == ARG_TYPE) {
        return new LgcArgTypeImpl(node);
      }
      else if (type == AUTHOR) {
        return new LgcAuthorImpl(node);
      }
      else if (type == AUTHOR_NAME) {
        return new LgcAuthorNameImpl(node);
      }
      else if (type == DELIM_CONSTRAINT) {
        return new LgcDelimConstraintImpl(node);
      }
      else if (type == DOC_CONSTRAINT) {
        return new LgcDocConstraintImpl(node);
      }
      else if (type == DOC_CONTENT) {
        return new LgcDocContentImpl(node);
      }
      else if (type == DOC_MODIFIER) {
        return new LgcDocModifierImpl(node);
      }
      else if (type == FIELD_CONSTRAINT) {
        return new LgcFieldConstraintImpl(node);
      }
      else if (type == FLAG) {
        return new LgcFlagImpl(node);
      }
      else if (type == ID) {
        return new LgcIdImpl(node);
      }
      else if (type == LANG) {
        return new LgcLangImpl(node);
      }
      else if (type == LANG_ID) {
        return new LgcLangIdImpl(node);
      }
      else if (type == LANG_NAME) {
        return new LgcLangNameImpl(node);
      }
      else if (type == LITERAL) {
        return new LgcLiteralImpl(node);
      }
      else if (type == LITERAL_STATIC) {
        return new LgcLiteralStaticImpl(node);
      }
      else if (type == MESSAGE) {
        return new LgcMessageImpl(node);
      }
      else if (type == MESSAGES) {
        return new LgcMessagesImpl(node);
      }
      else if (type == MESSAGE_GROUP) {
        return new LgcMessageGroupImpl(node);
      }
      else if (type == MESSAGE_ID) {
        return new LgcMessageIdImpl(node);
      }
      else if (type == MESSAGE_REF) {
        return new LgcMessageRefImpl(node);
      }
      else if (type == REQUIRE) {
        return new LgcRequireImpl(node);
      }
      else if (type == REQUIRE_TARGET) {
        return new LgcRequireTargetImpl(node);
      }
      else if (type == SPAN) {
        return new LgcSpanImpl(node);
      }
      else if (type == VERSION) {
        return new LgcVersionImpl(node);
      }
      else if (type == VERSION_MODIFIER) {
        return new LgcVersionModifierImpl(node);
      }
      else if (type == VERSION_VALUE) {
        return new LgcVersionValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
