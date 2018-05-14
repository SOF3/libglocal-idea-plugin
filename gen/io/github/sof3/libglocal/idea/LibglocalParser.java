// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static io.github.sof3.libglocal.idea.LibglocalTokens.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class LibglocalParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ARG_DEFAULT) {
      r = argDefault(b, 0);
    }
    else if (t == ARG_MODIFIER) {
      r = argModifier(b, 0);
    }
    else if (t == ARG_REF) {
      r = argRef(b, 0);
    }
    else if (t == ARG_VALUE) {
      r = argValue(b, 0);
    }
    else if (t == COMMENT) {
      r = comment(b, 0);
    }
    else if (t == DOC_MODIFIER) {
      r = docModifier(b, 0);
    }
    else if (t == EMPTY_LINE) {
      r = emptyLine(b, 0);
    }
    else if (t == ENTRY_MODIFIER) {
      r = entryModifier(b, 0);
    }
    else if (t == LANG_AUTHOR) {
      r = langAuthor(b, 0);
    }
    else if (t == LANG_TYPE) {
      r = langType(b, 0);
    }
    else if (t == LANG_VERSION) {
      r = langVersion(b, 0);
    }
    else if (t == MESSAGE_ENTRY) {
      r = messageEntry(b, 0);
    }
    else if (t == MESSAGE_HEADER) {
      r = messageHeader(b, 0);
    }
    else if (t == MESSAGE_REF) {
      r = messageRef(b, 0);
    }
    else if (t == MESSAGE_REF_ARG) {
      r = messageRefArg(b, 0);
    }
    else if (t == MESSAGE_REF_ARGS) {
      r = messageRefArgs(b, 0);
    }
    else if (t == MESSAGE_VALUE) {
      r = messageValue(b, 0);
    }
    else if (t == SINCE_MODIFIER) {
      r = sinceModifier(b, 0);
    }
    else if (t == SPAN) {
      r = span(b, 0);
    }
    else if (t == STRING_LITERAL) {
      r = stringLiteral(b, 0);
    }
    else if (t == TERMINATOR) {
      r = terminator(b, 0);
    }
    else if (t == UPDATED_MODIFIER) {
      r = updatedModifier(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // ARG_EQUALS argValue
  public static boolean argDefault(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argDefault")) return false;
    if (!nextTokenIs(b, ARG_EQUALS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARG_EQUALS);
    r = r && argValue(b, l + 1);
    exit_section_(b, m, ARG_DEFAULT, r);
    return r;
  }

  /* ********************************************************** */
  // ARG_KEYWORD ARG_NAME (WHITE_SPACE ARG_TYPE_MODIFIER? ARG_TYPE argDefault?)?
  public static boolean argModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argModifier")) return false;
    if (!nextTokenIs(b, ARG_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ARG_KEYWORD, ARG_NAME);
    r = r && argModifier_2(b, l + 1);
    exit_section_(b, m, ARG_MODIFIER, r);
    return r;
  }

  // (WHITE_SPACE ARG_TYPE_MODIFIER? ARG_TYPE argDefault?)?
  private static boolean argModifier_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argModifier_2")) return false;
    argModifier_2_0(b, l + 1);
    return true;
  }

  // WHITE_SPACE ARG_TYPE_MODIFIER? ARG_TYPE argDefault?
  private static boolean argModifier_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argModifier_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHITE_SPACE);
    r = r && argModifier_2_0_1(b, l + 1);
    r = r && consumeToken(b, ARG_TYPE);
    r = r && argModifier_2_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ARG_TYPE_MODIFIER?
  private static boolean argModifier_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argModifier_2_0_1")) return false;
    consumeToken(b, ARG_TYPE_MODIFIER);
    return true;
  }

  // argDefault?
  private static boolean argModifier_2_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argModifier_2_0_3")) return false;
    argDefault(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // DOLLAR_OPEN ARG_NAME DOLLAR_CLOSE
  public static boolean argRef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argRef")) return false;
    if (!nextTokenIs(b, DOLLAR_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOLLAR_OPEN, ARG_NAME, DOLLAR_CLOSE);
    exit_section_(b, m, ARG_REF, r);
    return r;
  }

  /* ********************************************************** */
  // stringLiteral | NUMBER_LITERAL | ARG_NAME
  public static boolean argValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARG_VALUE, "<arg value>");
    r = stringLiteral(b, l + 1);
    if (!r) r = consumeToken(b, NUMBER_LITERAL);
    if (!r) r = consumeToken(b, ARG_NAME);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LINE_COMMENT | BLOCK_COMMENT
  public static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    if (!nextTokenIs(b, "<comment>", BLOCK_COMMENT, LINE_COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMENT, "<comment>");
    r = consumeToken(b, LINE_COMMENT);
    if (!r) r = consumeToken(b, BLOCK_COMMENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOC_KEYWORD DOC_VALUE
  public static boolean docModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "docModifier")) return false;
    if (!nextTokenIs(b, DOC_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOC_KEYWORD, DOC_VALUE);
    exit_section_(b, m, DOC_MODIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // (WHITE_SPACE | INDENT)? terminator
  public static boolean emptyLine(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "emptyLine")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EMPTY_LINE, "<empty line>");
    r = emptyLine_0(b, l + 1);
    r = r && terminator(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (WHITE_SPACE | INDENT)?
  private static boolean emptyLine_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "emptyLine_0")) return false;
    emptyLine_0_0(b, l + 1);
    return true;
  }

  // WHITE_SPACE | INDENT
  private static boolean emptyLine_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "emptyLine_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHITE_SPACE);
    if (!r) r = consumeToken(b, INDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INDENT (argModifier | docModifier | sinceModifier | updatedModifier)
  public static boolean entryModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entryModifier")) return false;
    if (!nextTokenIs(b, INDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDENT);
    r = r && entryModifier_1(b, l + 1);
    exit_section_(b, m, ENTRY_MODIFIER, r);
    return r;
  }

  // argModifier | docModifier | sinceModifier | updatedModifier
  private static boolean entryModifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entryModifier_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = argModifier(b, l + 1);
    if (!r) r = docModifier(b, l + 1);
    if (!r) r = sinceModifier(b, l + 1);
    if (!r) r = updatedModifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // AUTHOR_KEYWORD AUTHOR_NAME (AUTHOR_SEPARATOR WHITE_SPACE? AUTHOR_NAME WHITE_SPACE?)*
  public static boolean langAuthor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "langAuthor")) return false;
    if (!nextTokenIs(b, AUTHOR_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, AUTHOR_KEYWORD, AUTHOR_NAME);
    r = r && langAuthor_2(b, l + 1);
    exit_section_(b, m, LANG_AUTHOR, r);
    return r;
  }

  // (AUTHOR_SEPARATOR WHITE_SPACE? AUTHOR_NAME WHITE_SPACE?)*
  private static boolean langAuthor_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "langAuthor_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!langAuthor_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "langAuthor_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // AUTHOR_SEPARATOR WHITE_SPACE? AUTHOR_NAME WHITE_SPACE?
  private static boolean langAuthor_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "langAuthor_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AUTHOR_SEPARATOR);
    r = r && langAuthor_2_0_1(b, l + 1);
    r = r && consumeToken(b, AUTHOR_NAME);
    r = r && langAuthor_2_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITE_SPACE?
  private static boolean langAuthor_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "langAuthor_2_0_1")) return false;
    consumeToken(b, WHITE_SPACE);
    return true;
  }

  // WHITE_SPACE?
  private static boolean langAuthor_2_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "langAuthor_2_0_3")) return false;
    consumeToken(b, WHITE_SPACE);
    return true;
  }

  /* ********************************************************** */
  // (BASE_KEYWORD WHITE_SPACE?)? LANG_KEYWORD LANG_NAME (WHITE_SPACE | LANG_LOCAL)?
  public static boolean langType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "langType")) return false;
    if (!nextTokenIs(b, "<lang type>", BASE_KEYWORD, LANG_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LANG_TYPE, "<lang type>");
    r = langType_0(b, l + 1);
    r = r && consumeTokens(b, 0, LANG_KEYWORD, LANG_NAME);
    r = r && langType_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (BASE_KEYWORD WHITE_SPACE?)?
  private static boolean langType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "langType_0")) return false;
    langType_0_0(b, l + 1);
    return true;
  }

  // BASE_KEYWORD WHITE_SPACE?
  private static boolean langType_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "langType_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BASE_KEYWORD);
    r = r && langType_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITE_SPACE?
  private static boolean langType_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "langType_0_0_1")) return false;
    consumeToken(b, WHITE_SPACE);
    return true;
  }

  // (WHITE_SPACE | LANG_LOCAL)?
  private static boolean langType_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "langType_3")) return false;
    langType_3_0(b, l + 1);
    return true;
  }

  // WHITE_SPACE | LANG_LOCAL
  private static boolean langType_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "langType_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHITE_SPACE);
    if (!r) r = consumeToken(b, LANG_LOCAL);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // VERSION_KEYWORD VERSION_VALUE
  public static boolean langVersion(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "langVersion")) return false;
    if (!nextTokenIs(b, VERSION_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, VERSION_KEYWORD, VERSION_VALUE);
    exit_section_(b, m, LANG_VERSION, r);
    return r;
  }

  /* ********************************************************** */
  // INDENT MESSAGE_ID WHITE_SPACE? messageValue?
  public static boolean messageEntry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "messageEntry")) return false;
    if (!nextTokenIs(b, INDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, INDENT, MESSAGE_ID);
    r = r && messageEntry_2(b, l + 1);
    r = r && messageEntry_3(b, l + 1);
    exit_section_(b, m, MESSAGE_ENTRY, r);
    return r;
  }

  // WHITE_SPACE?
  private static boolean messageEntry_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "messageEntry_2")) return false;
    consumeToken(b, WHITE_SPACE);
    return true;
  }

  // messageValue?
  private static boolean messageEntry_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "messageEntry_3")) return false;
    messageValue(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // MESSAGES_KEYWORD
  public static boolean messageHeader(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "messageHeader")) return false;
    if (!nextTokenIs(b, MESSAGES_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MESSAGES_KEYWORD);
    exit_section_(b, m, MESSAGE_HEADER, r);
    return r;
  }

  /* ********************************************************** */
  // HASH_OPEN MESSAGE_ID messageRefArgs? HASH_CLOSE
  public static boolean messageRef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "messageRef")) return false;
    if (!nextTokenIs(b, HASH_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, HASH_OPEN, MESSAGE_ID);
    r = r && messageRef_2(b, l + 1);
    r = r && consumeToken(b, HASH_CLOSE);
    exit_section_(b, m, MESSAGE_REF, r);
    return r;
  }

  // messageRefArgs?
  private static boolean messageRef_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "messageRef_2")) return false;
    messageRefArgs(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ARG_NAME ARG_EQUALS argValue
  public static boolean messageRefArg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "messageRefArg")) return false;
    if (!nextTokenIs(b, ARG_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ARG_NAME, ARG_EQUALS);
    r = r && argValue(b, l + 1);
    exit_section_(b, m, MESSAGE_REF_ARG, r);
    return r;
  }

  /* ********************************************************** */
  // OPEN_PAREN messageRefArg (ARGS_SEPARATOR messageRefArg)* CLOSE_PAREN
  public static boolean messageRefArgs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "messageRefArgs")) return false;
    if (!nextTokenIs(b, OPEN_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_PAREN);
    r = r && messageRefArg(b, l + 1);
    r = r && messageRefArgs_2(b, l + 1);
    r = r && consumeToken(b, CLOSE_PAREN);
    exit_section_(b, m, MESSAGE_REF_ARGS, r);
    return r;
  }

  // (ARGS_SEPARATOR messageRefArg)*
  private static boolean messageRefArgs_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "messageRefArgs_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!messageRefArgs_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "messageRefArgs_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ARGS_SEPARATOR messageRefArg
  private static boolean messageRefArgs_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "messageRefArgs_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARGS_SEPARATOR);
    r = r && messageRefArg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (LITERAL | ESCAPE | argRef | span | messageRef)+
  public static boolean messageValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "messageValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MESSAGE_VALUE, "<message value>");
    r = messageValue_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!messageValue_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "messageValue", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LITERAL | ESCAPE | argRef | span | messageRef
  private static boolean messageValue_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "messageValue_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LITERAL);
    if (!r) r = consumeToken(b, ESCAPE);
    if (!r) r = argRef(b, l + 1);
    if (!r) r = span(b, l + 1);
    if (!r) r = messageRef(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (comment | emptyLine | (langType | langVersion | langAuthor | messageHeader | messageEntry | entryModifier) terminator)*
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    int c = current_position_(b);
    while (true) {
      if (!root_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // comment | emptyLine | (langType | langVersion | langAuthor | messageHeader | messageEntry | entryModifier) terminator
  private static boolean root_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comment(b, l + 1);
    if (!r) r = emptyLine(b, l + 1);
    if (!r) r = root_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (langType | langVersion | langAuthor | messageHeader | messageEntry | entryModifier) terminator
  private static boolean root_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = root_0_2_0(b, l + 1);
    r = r && terminator(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // langType | langVersion | langAuthor | messageHeader | messageEntry | entryModifier
  private static boolean root_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = langType(b, l + 1);
    if (!r) r = langVersion(b, l + 1);
    if (!r) r = langAuthor(b, l + 1);
    if (!r) r = messageHeader(b, l + 1);
    if (!r) r = messageEntry(b, l + 1);
    if (!r) r = entryModifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SINCE_KEYWORD VERSION_VALUE
  public static boolean sinceModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sinceModifier")) return false;
    if (!nextTokenIs(b, SINCE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SINCE_KEYWORD, VERSION_VALUE);
    exit_section_(b, m, SINCE_MODIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // PERCENT_OPEN WHITE_SPACE? (SPAN_NAME WHITE_SPACE messageValue | SPAN_STYLE WHITE_SPACE*) PERCENT_CLOSE
  public static boolean span(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "span")) return false;
    if (!nextTokenIs(b, PERCENT_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PERCENT_OPEN);
    r = r && span_1(b, l + 1);
    r = r && span_2(b, l + 1);
    r = r && consumeToken(b, PERCENT_CLOSE);
    exit_section_(b, m, SPAN, r);
    return r;
  }

  // WHITE_SPACE?
  private static boolean span_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "span_1")) return false;
    consumeToken(b, WHITE_SPACE);
    return true;
  }

  // SPAN_NAME WHITE_SPACE messageValue | SPAN_STYLE WHITE_SPACE*
  private static boolean span_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "span_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = span_2_0(b, l + 1);
    if (!r) r = span_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SPAN_NAME WHITE_SPACE messageValue
  private static boolean span_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "span_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SPAN_NAME, WHITE_SPACE);
    r = r && messageValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SPAN_STYLE WHITE_SPACE*
  private static boolean span_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "span_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SPAN_STYLE);
    r = r && span_2_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITE_SPACE*
  private static boolean span_2_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "span_2_1_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "span_2_1_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // OPEN_QUOTE (LITERAL | ESCAPE) CLOSE_QUOTE
  public static boolean stringLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringLiteral")) return false;
    if (!nextTokenIs(b, OPEN_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_QUOTE);
    r = r && stringLiteral_1(b, l + 1);
    r = r && consumeToken(b, CLOSE_QUOTE);
    exit_section_(b, m, STRING_LITERAL, r);
    return r;
  }

  // LITERAL | ESCAPE
  private static boolean stringLiteral_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringLiteral_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LITERAL);
    if (!r) r = consumeToken(b, ESCAPE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<eof>> | EOL
  public static boolean terminator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "terminator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TERMINATOR, "<terminator>");
    r = eof(b, l + 1);
    if (!r) r = consumeToken(b, EOL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // UPDATED_KEYWORD VERSION_VALUE
  public static boolean updatedModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "updatedModifier")) return false;
    if (!nextTokenIs(b, UPDATED_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, UPDATED_KEYWORD, VERSION_VALUE);
    exit_section_(b, m, UPDATED_MODIFIER, r);
    return r;
  }

}
