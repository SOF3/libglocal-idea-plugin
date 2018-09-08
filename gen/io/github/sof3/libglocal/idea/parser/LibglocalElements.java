// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.parser;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.github.sof3.libglocal.idea.psi.impl.*;

public interface LibglocalElements {

  IElementType AUTHOR_BLOCK = new LibglocalElementType("AUTHOR_BLOCK");
  IElementType BLOCK_MESSAGE = new LibglocalElementType("BLOCK_MESSAGE");
  IElementType BLOCK_MESSAGES = new LibglocalElementType("BLOCK_MESSAGES");
  IElementType BLOCK_MESSAGE_GROUP = new LibglocalElementType("BLOCK_MESSAGE_GROUP");
  IElementType CONSTRAINT_DELIM = new LibglocalElementType("CONSTRAINT_DELIM");
  IElementType CONSTRAINT_DOC = new LibglocalElementType("CONSTRAINT_DOC");
  IElementType CONSTRAINT_FIELD = new LibglocalElementType("CONSTRAINT_FIELD");
  IElementType ELEMENT_ARGS_ENTRY = new LibglocalElementType("ELEMENT_ARGS_ENTRY");
  IElementType ELEMENT_ARGS_SUPPLIER = new LibglocalElementType("ELEMENT_ARGS_SUPPLIER");
  IElementType ELEMENT_ARGS_VALUE = new LibglocalElementType("ELEMENT_ARGS_VALUE");
  IElementType ELEMENT_ARGS_VALUE_STRING = new LibglocalElementType("ELEMENT_ARGS_VALUE_STRING");
  IElementType ELEMENT_ARG_DEFAULT = new LibglocalElementType("ELEMENT_ARG_DEFAULT");
  IElementType ELEMENT_ARG_NAME = new LibglocalElementType("ELEMENT_ARG_NAME");
  IElementType ELEMENT_ARG_REF = new LibglocalElementType("ELEMENT_ARG_REF");
  IElementType ELEMENT_ARG_TYPE = new LibglocalElementType("ELEMENT_ARG_TYPE");
  IElementType ELEMENT_LANG_ID = new LibglocalElementType("ELEMENT_LANG_ID");
  IElementType ELEMENT_LANG_NAME = new LibglocalElementType("ELEMENT_LANG_NAME");
  IElementType ELEMENT_LITERAL = new LibglocalElementType("ELEMENT_LITERAL");
  IElementType ELEMENT_LITERAL_STATIC = new LibglocalElementType("ELEMENT_LITERAL_STATIC");
  IElementType ELEMENT_MESSAGE_ID = new LibglocalElementType("ELEMENT_MESSAGE_ID");
  IElementType ELEMENT_MESSAGE_REF = new LibglocalElementType("ELEMENT_MESSAGE_REF");
  IElementType ELEMENT_REQUIRE_TARGET = new LibglocalElementType("ELEMENT_REQUIRE_TARGET");
  IElementType ELEMENT_SPAN = new LibglocalElementType("ELEMENT_SPAN");
  IElementType ELEMENT_VERSION_VALUE = new LibglocalElementType("ELEMENT_VERSION_VALUE");
  IElementType LANG_BLOCK = new LibglocalElementType("LANG_BLOCK");
  IElementType MODIFIER_ARG = new LibglocalElementType("MODIFIER_ARG");
  IElementType MODIFIER_DOC = new LibglocalElementType("MODIFIER_DOC");
  IElementType MODIFIER_VERSION = new LibglocalElementType("MODIFIER_VERSION");
  IElementType REQUIRE_BLOCK = new LibglocalElementType("REQUIRE_BLOCK");
  IElementType VERSION_BLOCK = new LibglocalElementType("VERSION_BLOCK");

  IElementType K_AUTHOR = new LibglocalTokenType("K_AUTHOR");
  IElementType K_BASE_LANG = new LibglocalTokenType("K_BASE_LANG");
  IElementType K_LANG = new LibglocalTokenType("K_LANG");
  IElementType K_MESSAGES = new LibglocalTokenType("K_MESSAGES");
  IElementType K_REQUIRE = new LibglocalTokenType("K_REQUIRE");
  IElementType K_VERSION = new LibglocalTokenType("K_VERSION");
  IElementType T_ARG_REF_START = new LibglocalTokenType("${");
  IElementType T_CLOSE_BRACE = new LibglocalTokenType("}");
  IElementType T_COMMENT = new LibglocalTokenType("comment");
  IElementType T_CONT_CONCAT = new LibglocalTokenType("T_CONT_CONCAT");
  IElementType T_CONT_NEWLINE = new LibglocalTokenType("T_CONT_NEWLINE");
  IElementType T_CONT_SPACE = new LibglocalTokenType("T_CONT_SPACE");
  IElementType T_DYNAMIC = new LibglocalTokenType("$");
  IElementType T_EMPTY_LINE = new LibglocalTokenType("empty line");
  IElementType T_EOL = new LibglocalTokenType("newline");
  IElementType T_EQUALS = new LibglocalTokenType("=");
  IElementType T_FLAG = new LibglocalTokenType("identifier flag");
  IElementType T_IDENTIFIER = new LibglocalTokenType("identifier");
  IElementType T_INDENT_DEDENT = new LibglocalTokenType("decrease indent");
  IElementType T_INDENT_INDENT = new LibglocalTokenType("increase indent");
  IElementType T_INDENT_INHERIT = new LibglocalTokenType("indent");
  IElementType T_INDENT_INVALID = new LibglocalTokenType("invalid indent");
  IElementType T_INSTRUCTION = new LibglocalTokenType("#");
  IElementType T_LITERAL_ESCAPE = new LibglocalTokenType("T_LITERAL_ESCAPE");
  IElementType T_LITERAL_INVALID_ESCAPE = new LibglocalTokenType("invalid literal escape");
  IElementType T_LITERAL_STRING = new LibglocalTokenType("T_LITERAL_STRING");
  IElementType T_MESSAGE_REF_START = new LibglocalTokenType("#{");
  IElementType T_MODIFIER_ARG = new LibglocalTokenType("T_MODIFIER_ARG");
  IElementType T_MODIFIER_DOC = new LibglocalTokenType("*");
  IElementType T_MODIFIER_VERSION = new LibglocalTokenType("~");
  IElementType T_NUMBER = new LibglocalTokenType("number");
  IElementType T_OPEN_BRACE = new LibglocalTokenType("{");
  IElementType T_SPAN_START = new LibglocalTokenType("%{");
  IElementType T_SPAN_TYPE = new LibglocalTokenType("span type");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == AUTHOR_BLOCK) {
        return new LibglocalAuthorBlockImpl(node);
      }
      else if (type == BLOCK_MESSAGE) {
        return new LibglocalBlockMessageImpl(node);
      }
      else if (type == BLOCK_MESSAGES) {
        return new LibglocalBlockMessagesImpl(node);
      }
      else if (type == BLOCK_MESSAGE_GROUP) {
        return new LibglocalBlockMessageGroupImpl(node);
      }
      else if (type == CONSTRAINT_DELIM) {
        return new LibglocalConstraintDelimImpl(node);
      }
      else if (type == CONSTRAINT_DOC) {
        return new LibglocalConstraintDocImpl(node);
      }
      else if (type == CONSTRAINT_FIELD) {
        return new LibglocalConstraintFieldImpl(node);
      }
      else if (type == ELEMENT_ARGS_ENTRY) {
        return new LibglocalElementArgsEntryImpl(node);
      }
      else if (type == ELEMENT_ARGS_SUPPLIER) {
        return new LibglocalElementArgsSupplierImpl(node);
      }
      else if (type == ELEMENT_ARGS_VALUE) {
        return new LibglocalElementArgsValueImpl(node);
      }
      else if (type == ELEMENT_ARGS_VALUE_STRING) {
        return new LibglocalElementArgsValueStringImpl(node);
      }
      else if (type == ELEMENT_ARG_DEFAULT) {
        return new LibglocalElementArgDefaultImpl(node);
      }
      else if (type == ELEMENT_ARG_NAME) {
        return new LibglocalElementArgNameImpl(node);
      }
      else if (type == ELEMENT_ARG_REF) {
        return new LibglocalElementArgRefImpl(node);
      }
      else if (type == ELEMENT_ARG_TYPE) {
        return new LibglocalElementArgTypeImpl(node);
      }
      else if (type == ELEMENT_LANG_ID) {
        return new LibglocalElementLangIdImpl(node);
      }
      else if (type == ELEMENT_LANG_NAME) {
        return new LibglocalElementLangNameImpl(node);
      }
      else if (type == ELEMENT_LITERAL) {
        return new LibglocalElementLiteralImpl(node);
      }
      else if (type == ELEMENT_LITERAL_STATIC) {
        return new LibglocalElementLiteralStaticImpl(node);
      }
      else if (type == ELEMENT_MESSAGE_ID) {
        return new LibglocalElementMessageIdImpl(node);
      }
      else if (type == ELEMENT_MESSAGE_REF) {
        return new LibglocalElementMessageRefImpl(node);
      }
      else if (type == ELEMENT_REQUIRE_TARGET) {
        return new LibglocalElementRequireTargetImpl(node);
      }
      else if (type == ELEMENT_SPAN) {
        return new LibglocalElementSpanImpl(node);
      }
      else if (type == ELEMENT_VERSION_VALUE) {
        return new LibglocalElementVersionValueImpl(node);
      }
      else if (type == LANG_BLOCK) {
        return new LibglocalLangBlockImpl(node);
      }
      else if (type == MODIFIER_ARG) {
        return new LibglocalModifierArgImpl(node);
      }
      else if (type == MODIFIER_DOC) {
        return new LibglocalModifierDocImpl(node);
      }
      else if (type == MODIFIER_VERSION) {
        return new LibglocalModifierVersionImpl(node);
      }
      else if (type == REQUIRE_BLOCK) {
        return new LibglocalRequireBlockImpl(node);
      }
      else if (type == VERSION_BLOCK) {
        return new LibglocalVersionBlockImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
