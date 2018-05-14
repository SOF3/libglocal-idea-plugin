// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.github.sof3.libglocal.idea.psi.impl.*;

public interface LibglocalTokens {

  IElementType ARG_DEFAULT = new LibglocalElementType("ARG_DEFAULT");
  IElementType ARG_MODIFIER = new LibglocalElementType("ARG_MODIFIER");
  IElementType ARG_REF = new LibglocalElementType("ARG_REF");
  IElementType ARG_VALUE = new LibglocalElementType("ARG_VALUE");
  IElementType COMMENT = new LibglocalElementType("COMMENT");
  IElementType DOC_MODIFIER = new LibglocalElementType("DOC_MODIFIER");
  IElementType EMPTY_LINE = new LibglocalElementType("EMPTY_LINE");
  IElementType ENTRY_MODIFIER = new LibglocalElementType("ENTRY_MODIFIER");
  IElementType LANG_AUTHOR = new LibglocalElementType("LANG_AUTHOR");
  IElementType LANG_TYPE = new LibglocalElementType("LANG_TYPE");
  IElementType LANG_VERSION = new LibglocalElementType("LANG_VERSION");
  IElementType MESSAGE_ENTRY = new LibglocalElementType("MESSAGE_ENTRY");
  IElementType MESSAGE_HEADER = new LibglocalElementType("MESSAGE_HEADER");
  IElementType MESSAGE_REF = new LibglocalElementType("MESSAGE_REF");
  IElementType MESSAGE_REF_ARG = new LibglocalElementType("MESSAGE_REF_ARG");
  IElementType MESSAGE_REF_ARGS = new LibglocalElementType("MESSAGE_REF_ARGS");
  IElementType MESSAGE_VALUE = new LibglocalElementType("MESSAGE_VALUE");
  IElementType SINCE_MODIFIER = new LibglocalElementType("SINCE_MODIFIER");
  IElementType SPAN = new LibglocalElementType("SPAN");
  IElementType STRING_LITERAL = new LibglocalElementType("STRING_LITERAL");
  IElementType TERMINATOR = new LibglocalElementType("TERMINATOR");
  IElementType UPDATED_MODIFIER = new LibglocalElementType("UPDATED_MODIFIER");

  IElementType ARGS_SEPARATOR = new LibglocalTokenType("ARGS_SEPARATOR");
  IElementType ARG_EQUALS = new LibglocalTokenType("ARG_EQUALS");
  IElementType ARG_KEYWORD = new LibglocalTokenType("ARG_KEYWORD");
  IElementType ARG_NAME = new LibglocalTokenType("ARG_NAME");
  IElementType ARG_TYPE = new LibglocalTokenType("ARG_TYPE");
  IElementType ARG_TYPE_MODIFIER = new LibglocalTokenType("ARG_TYPE_MODIFIER");
  IElementType AUTHOR_KEYWORD = new LibglocalTokenType("AUTHOR_KEYWORD");
  IElementType AUTHOR_NAME = new LibglocalTokenType("AUTHOR_NAME");
  IElementType AUTHOR_SEPARATOR = new LibglocalTokenType("AUTHOR_SEPARATOR");
  IElementType BASE_KEYWORD = new LibglocalTokenType("BASE_KEYWORD");
  IElementType BLOCK_COMMENT = new LibglocalTokenType("BLOCK_COMMENT");
  IElementType CLOSE_PAREN = new LibglocalTokenType("CLOSE_PAREN");
  IElementType CLOSE_QUOTE = new LibglocalTokenType("CLOSE_QUOTE");
  IElementType DOC_KEYWORD = new LibglocalTokenType("DOC_KEYWORD");
  IElementType DOC_VALUE = new LibglocalTokenType("DOC_VALUE");
  IElementType DOLLAR_CLOSE = new LibglocalTokenType("DOLLAR_CLOSE");
  IElementType DOLLAR_OPEN = new LibglocalTokenType("DOLLAR_OPEN");
  IElementType EOL = new LibglocalTokenType("EOL");
  IElementType ESCAPE = new LibglocalTokenType("ESCAPE");
  IElementType HASH_CLOSE = new LibglocalTokenType("HASH_CLOSE");
  IElementType HASH_OPEN = new LibglocalTokenType("HASH_OPEN");
  IElementType INDENT = new LibglocalTokenType("INDENT");
  IElementType LANG_KEYWORD = new LibglocalTokenType("LANG_KEYWORD");
  IElementType LANG_LOCAL = new LibglocalTokenType("LANG_LOCAL");
  IElementType LANG_NAME = new LibglocalTokenType("LANG_NAME");
  IElementType LINE_COMMENT = new LibglocalTokenType("LINE_COMMENT");
  IElementType LITERAL = new LibglocalTokenType("LITERAL");
  IElementType MESSAGES_KEYWORD = new LibglocalTokenType("MESSAGES_KEYWORD");
  IElementType MESSAGE_ID = new LibglocalTokenType("MESSAGE_ID");
  IElementType NUMBER_LITERAL = new LibglocalTokenType("NUMBER_LITERAL");
  IElementType OPEN_PAREN = new LibglocalTokenType("OPEN_PAREN");
  IElementType OPEN_QUOTE = new LibglocalTokenType("OPEN_QUOTE");
  IElementType PERCENT_CLOSE = new LibglocalTokenType("PERCENT_CLOSE");
  IElementType PERCENT_OPEN = new LibglocalTokenType("PERCENT_OPEN");
  IElementType SINCE_KEYWORD = new LibglocalTokenType("SINCE_KEYWORD");
  IElementType SPAN_NAME = new LibglocalTokenType("SPAN_NAME");
  IElementType SPAN_STYLE = new LibglocalTokenType("SPAN_STYLE");
  IElementType UPDATED_KEYWORD = new LibglocalTokenType("UPDATED_KEYWORD");
  IElementType VERSION_KEYWORD = new LibglocalTokenType("VERSION_KEYWORD");
  IElementType VERSION_VALUE = new LibglocalTokenType("VERSION_VALUE");
  IElementType WHITE_SPACE = new LibglocalTokenType("WHITE_SPACE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ARG_DEFAULT) {
        return new LibglocalArgDefaultImpl(node);
      }
      else if (type == ARG_MODIFIER) {
        return new LibglocalArgModifierImpl(node);
      }
      else if (type == ARG_REF) {
        return new LibglocalArgRefImpl(node);
      }
      else if (type == ARG_VALUE) {
        return new LibglocalArgValueImpl(node);
      }
      else if (type == COMMENT) {
        return new LibglocalCommentImpl(node);
      }
      else if (type == DOC_MODIFIER) {
        return new LibglocalDocModifierImpl(node);
      }
      else if (type == EMPTY_LINE) {
        return new LibglocalEmptyLineImpl(node);
      }
      else if (type == ENTRY_MODIFIER) {
        return new LibglocalEntryModifierImpl(node);
      }
      else if (type == LANG_AUTHOR) {
        return new LibglocalLangAuthorImpl(node);
      }
      else if (type == LANG_TYPE) {
        return new LibglocalLangTypeImpl(node);
      }
      else if (type == LANG_VERSION) {
        return new LibglocalLangVersionImpl(node);
      }
      else if (type == MESSAGE_ENTRY) {
        return new LibglocalMessageEntryImpl(node);
      }
      else if (type == MESSAGE_HEADER) {
        return new LibglocalMessageHeaderImpl(node);
      }
      else if (type == MESSAGE_REF) {
        return new LibglocalMessageRefImpl(node);
      }
      else if (type == MESSAGE_REF_ARG) {
        return new LibglocalMessageRefArgImpl(node);
      }
      else if (type == MESSAGE_REF_ARGS) {
        return new LibglocalMessageRefArgsImpl(node);
      }
      else if (type == MESSAGE_VALUE) {
        return new LibglocalMessageValueImpl(node);
      }
      else if (type == SINCE_MODIFIER) {
        return new LibglocalSinceModifierImpl(node);
      }
      else if (type == SPAN) {
        return new LibglocalSpanImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new LibglocalStringLiteralImpl(node);
      }
      else if (type == TERMINATOR) {
        return new LibglocalTerminatorImpl(node);
      }
      else if (type == UPDATED_MODIFIER) {
        return new LibglocalUpdatedModifierImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
