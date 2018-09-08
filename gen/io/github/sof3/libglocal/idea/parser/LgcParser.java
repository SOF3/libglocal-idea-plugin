// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static io.github.sof3.libglocal.idea.parser.LgcElements.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class LgcParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ARG_DEFAULT) {
      r = arg_default(b, 0);
    }
    else if (t == ARG_MODIFIER) {
      r = arg_modifier(b, 0);
    }
    else if (t == ARG_NAME) {
      r = arg_name(b, 0);
    }
    else if (t == ARG_REF) {
      r = arg_ref(b, 0);
    }
    else if (t == ARG_TYPE) {
      r = arg_type(b, 0);
    }
    else if (t == ARG_TYPE_FLAG) {
      r = arg_type_flag(b, 0);
    }
    else if (t == ARGS_ENTRY) {
      r = args_entry(b, 0);
    }
    else if (t == ARGS_SUPPLIER) {
      r = args_supplier(b, 0);
    }
    else if (t == ARGS_VALUE) {
      r = args_value(b, 0);
    }
    else if (t == ARGS_VALUE_STRING) {
      r = args_value_string(b, 0);
    }
    else if (t == AUTHOR) {
      r = author(b, 0);
    }
    else if (t == AUTHOR_NAME) {
      r = author_name(b, 0);
    }
    else if (t == DELIM_CONSTRAINT) {
      r = delim_constraint(b, 0);
    }
    else if (t == DOC_CONSTRAINT) {
      r = doc_constraint(b, 0);
    }
    else if (t == DOC_CONTENT) {
      r = doc_content(b, 0);
    }
    else if (t == DOC_MODIFIER) {
      r = doc_modifier(b, 0);
    }
    else if (t == FIELD_CONSTRAINT) {
      r = field_constraint(b, 0);
    }
    else if (t == ID) {
      r = id(b, 0);
    }
    else if (t == LANG) {
      r = lang(b, 0);
    }
    else if (t == LANG_ID) {
      r = lang_id(b, 0);
    }
    else if (t == LANG_NAME) {
      r = lang_name(b, 0);
    }
    else if (t == LITERAL) {
      r = literal(b, 0);
    }
    else if (t == LITERAL_STATIC) {
      r = literal_static(b, 0);
    }
    else if (t == MESSAGE) {
      r = message(b, 0);
    }
    else if (t == MESSAGE_FLAG) {
      r = message_flag(b, 0);
    }
    else if (t == MESSAGE_GROUP) {
      r = message_group(b, 0);
    }
    else if (t == MESSAGE_ID) {
      r = message_id(b, 0);
    }
    else if (t == MESSAGE_REF) {
      r = message_ref(b, 0);
    }
    else if (t == MESSAGES) {
      r = messages(b, 0);
    }
    else if (t == REQUIRE) {
      r = require(b, 0);
    }
    else if (t == REQUIRE_TARGET) {
      r = require_target(b, 0);
    }
    else if (t == SPAN) {
      r = span(b, 0);
    }
    else if (t == VERSION) {
      r = version(b, 0);
    }
    else if (t == VERSION_MODIFIER) {
      r = version_modifier(b, 0);
    }
    else if (t == VERSION_VALUE) {
      r = version_value(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return libglocal_file(b, l + 1);
  }

  /* ********************************************************** */
  // field_constraint | delim_constraint | doc_constraint
  static boolean arg_constraints(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_constraints")) return false;
    boolean r;
    r = field_constraint(b, l + 1);
    if (!r) r = delim_constraint(b, l + 1);
    if (!r) r = doc_constraint(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // literal
  public static boolean arg_default(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_default")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARG_DEFAULT, "<arg default>");
    r = literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_MODIFIER_ARG arg_template [T_INDENT_INDENT arg_constraints* pseudo_dedent]
  public static boolean arg_modifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_modifier")) return false;
    if (!nextTokenIs(b, T_MODIFIER_ARG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_MODIFIER_ARG);
    r = r && arg_template(b, l + 1);
    r = r && arg_modifier_2(b, l + 1);
    exit_section_(b, m, ARG_MODIFIER, r);
    return r;
  }

  // [T_INDENT_INDENT arg_constraints* pseudo_dedent]
  private static boolean arg_modifier_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_modifier_2")) return false;
    arg_modifier_2_0(b, l + 1);
    return true;
  }

  // T_INDENT_INDENT arg_constraints* pseudo_dedent
  private static boolean arg_modifier_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_modifier_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_INDENT_INDENT);
    r = r && arg_modifier_2_0_1(b, l + 1);
    r = r && pseudo_dedent(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // arg_constraints*
  private static boolean arg_modifier_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_modifier_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arg_constraints(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arg_modifier_2_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // T_IDENTIFIER
  public static boolean arg_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_name")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IDENTIFIER);
    exit_section_(b, m, ARG_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // T_ARG_REF_START T_IDENTIFIER T_CLOSE_BRACE
  public static boolean arg_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_ref")) return false;
    if (!nextTokenIs(b, T_ARG_REF_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_ARG_REF_START, T_IDENTIFIER, T_CLOSE_BRACE);
    exit_section_(b, m, ARG_REF, r);
    return r;
  }

  /* ********************************************************** */
  // arg_name [arg_type [arg_default]] line_delim
  static boolean arg_template(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_template")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = arg_name(b, l + 1);
    r = r && arg_template_1(b, l + 1);
    r = r && line_delim(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [arg_type [arg_default]]
  private static boolean arg_template_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_template_1")) return false;
    arg_template_1_0(b, l + 1);
    return true;
  }

  // arg_type [arg_default]
  private static boolean arg_template_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_template_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = arg_type(b, l + 1);
    r = r && arg_template_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [arg_default]
  private static boolean arg_template_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_template_1_0_1")) return false;
    arg_default(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // arg_type_flag id
  public static boolean arg_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_type")) return false;
    if (!nextTokenIs(b, "<arg type>", T_FLAG_LIST, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARG_TYPE, "<arg type>");
    r = arg_type_flag(b, l + 1);
    r = r && id(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_FLAG_LIST*
  public static boolean arg_type_flag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_type_flag")) return false;
    Marker m = enter_section_(b, l, _NONE_, ARG_TYPE_FLAG, "<arg type flag>");
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, T_FLAG_LIST)) break;
      if (!empty_element_parsed_guard_(b, "arg_type_flag", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // T_IDENTIFIER T_EQUALS args_value
  public static boolean args_entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_entry")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_IDENTIFIER, T_EQUALS);
    r = r && args_value(b, l + 1);
    exit_section_(b, m, ARGS_ENTRY, r);
    return r;
  }

  /* ********************************************************** */
  // args_entry*
  public static boolean args_supplier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_supplier")) return false;
    Marker m = enter_section_(b, l, _NONE_, ARGS_SUPPLIER, "<args supplier>");
    while (true) {
      int c = current_position_(b);
      if (!args_entry(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "args_supplier", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // T_NUMBER | T_IDENTIFIER | args_value_string
  public static boolean args_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGS_VALUE, "<args value>");
    r = consumeToken(b, T_NUMBER);
    if (!r) r = consumeToken(b, T_IDENTIFIER);
    if (!r) r = args_value_string(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_OPEN_BRACE literal T_CLOSE_BRACE
  public static boolean args_value_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_value_string")) return false;
    if (!nextTokenIs(b, T_OPEN_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_OPEN_BRACE);
    r = r && literal(b, l + 1);
    r = r && consumeToken(b, T_CLOSE_BRACE);
    exit_section_(b, m, ARGS_VALUE_STRING, r);
    return r;
  }

  /* ********************************************************** */
  // K_AUTHOR author_name line_delim
  public static boolean author(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "author")) return false;
    if (!nextTokenIs(b, K_AUTHOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_AUTHOR);
    r = r && author_name(b, l + 1);
    r = r && line_delim(b, l + 1);
    exit_section_(b, m, AUTHOR, r);
    return r;
  }

  /* ********************************************************** */
  // literal_static
  public static boolean author_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "author_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, AUTHOR_NAME, "<author name>");
    r = literal_static(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_INSTRUCTION "delim" T_IDENTIFIER line_delim
  public static boolean delim_constraint(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "delim_constraint")) return false;
    if (!nextTokenIs(b, T_INSTRUCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_INSTRUCTION);
    r = r && consumeToken(b, "delim");
    r = r && consumeToken(b, T_IDENTIFIER);
    r = r && line_delim(b, l + 1);
    exit_section_(b, m, DELIM_CONSTRAINT, r);
    return r;
  }

  /* ********************************************************** */
  // T_MODIFIER_DOC literal_static line_delim
  public static boolean doc_constraint(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_constraint")) return false;
    if (!nextTokenIs(b, T_MODIFIER_DOC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_MODIFIER_DOC);
    r = r && literal_static(b, l + 1);
    r = r && line_delim(b, l + 1);
    exit_section_(b, m, DOC_CONSTRAINT, r);
    return r;
  }

  /* ********************************************************** */
  // literal_static
  public static boolean doc_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_content")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DOC_CONTENT, "<doc content>");
    r = literal_static(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_MODIFIER_DOC doc_content? line_delim
  public static boolean doc_modifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_modifier")) return false;
    if (!nextTokenIs(b, T_MODIFIER_DOC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_MODIFIER_DOC);
    r = r && doc_modifier_1(b, l + 1);
    r = r && line_delim(b, l + 1);
    exit_section_(b, m, DOC_MODIFIER, r);
    return r;
  }

  // doc_content?
  private static boolean doc_modifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_modifier_1")) return false;
    doc_content(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // T_MODIFIER_ARG arg_template [T_INDENT_INDENT arg_constraints* pseudo_dedent]
  public static boolean field_constraint(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_constraint")) return false;
    if (!nextTokenIs(b, T_MODIFIER_ARG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_MODIFIER_ARG);
    r = r && arg_template(b, l + 1);
    r = r && field_constraint_2(b, l + 1);
    exit_section_(b, m, FIELD_CONSTRAINT, r);
    return r;
  }

  // [T_INDENT_INDENT arg_constraints* pseudo_dedent]
  private static boolean field_constraint_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_constraint_2")) return false;
    field_constraint_2_0(b, l + 1);
    return true;
  }

  // T_INDENT_INDENT arg_constraints* pseudo_dedent
  private static boolean field_constraint_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_constraint_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_INDENT_INDENT);
    r = r && field_constraint_2_0_1(b, l + 1);
    r = r && pseudo_dedent(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // arg_constraints*
  private static boolean field_constraint_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_constraint_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arg_constraints(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "field_constraint_2_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // T_IDENTIFIER
  public static boolean id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IDENTIFIER);
    exit_section_(b, m, ID, r);
    return r;
  }

  /* ********************************************************** */
  // (K_BASE_LANG | K_LANG) lang_id lang_name line_delim
  public static boolean lang(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lang")) return false;
    if (!nextTokenIs(b, "<lang>", K_BASE_LANG, K_LANG)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LANG, "<lang>");
    r = lang_0(b, l + 1);
    r = r && lang_id(b, l + 1);
    r = r && lang_name(b, l + 1);
    r = r && line_delim(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // K_BASE_LANG | K_LANG
  private static boolean lang_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lang_0")) return false;
    boolean r;
    r = consumeToken(b, K_BASE_LANG);
    if (!r) r = consumeToken(b, K_LANG);
    return r;
  }

  /* ********************************************************** */
  // T_IDENTIFIER
  public static boolean lang_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lang_id")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IDENTIFIER);
    exit_section_(b, m, LANG_ID, r);
    return r;
  }

  /* ********************************************************** */
  // literal_static
  public static boolean lang_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lang_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LANG_NAME, "<lang name>");
    r = literal_static(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (lang | author | version | require)+ messages
  static boolean libglocal_file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "libglocal_file")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = libglocal_file_0(b, l + 1);
    r = r && messages(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (lang | author | version | require)+
  private static boolean libglocal_file_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "libglocal_file_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = libglocal_file_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!libglocal_file_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "libglocal_file_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // lang | author | version | require
  private static boolean libglocal_file_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "libglocal_file_0_0")) return false;
    boolean r;
    r = lang(b, l + 1);
    if (!r) r = author(b, l + 1);
    if (!r) r = version(b, l + 1);
    if (!r) r = require(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // T_EOL | <<eof>>
  static boolean line_delim(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_delim")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_EOL);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (literal_token)+
  public static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
    r = literal_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!literal_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "literal", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (literal_token)
  private static boolean literal_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = literal_token(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (literal_token_static)+
  public static boolean literal_static(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_static")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_STATIC, "<literal static>");
    r = literal_static_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!literal_static_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "literal_static", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (literal_token_static)
  private static boolean literal_static_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_static_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = literal_token_static(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // literal_token_static | arg_ref | message_ref | span
  static boolean literal_token(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_token")) return false;
    boolean r;
    r = literal_token_static(b, l + 1);
    if (!r) r = arg_ref(b, l + 1);
    if (!r) r = message_ref(b, l + 1);
    if (!r) r = span(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // T_LITERAL_STRING | T_LITERAL_ESCAPE | T_CONT_NEWLINE | T_CONT_SPACE | T_CONT_CONCAT
  static boolean literal_token_static(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_token_static")) return false;
    boolean r;
    r = consumeToken(b, T_LITERAL_STRING);
    if (!r) r = consumeToken(b, T_LITERAL_ESCAPE);
    if (!r) r = consumeToken(b, T_CONT_NEWLINE);
    if (!r) r = consumeToken(b, T_CONT_SPACE);
    if (!r) r = consumeToken(b, T_CONT_CONCAT);
    return r;
  }

  /* ********************************************************** */
  // message_id literal line_delim
  // 	[T_INDENT_INDENT message_modifiers* pseudo_dedent]
  public static boolean message(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "message")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MESSAGE, "<message>");
    r = message_id(b, l + 1);
    r = r && literal(b, l + 1);
    r = r && line_delim(b, l + 1);
    r = r && message_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [T_INDENT_INDENT message_modifiers* pseudo_dedent]
  private static boolean message_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "message_3")) return false;
    message_3_0(b, l + 1);
    return true;
  }

  // T_INDENT_INDENT message_modifiers* pseudo_dedent
  private static boolean message_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "message_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_INDENT_INDENT);
    r = r && message_3_0_1(b, l + 1);
    r = r && pseudo_dedent(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // message_modifiers*
  private static boolean message_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "message_3_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!message_modifiers(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "message_3_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // T_FLAG_PUBLIC | T_FLAG_LIB | T_FLAG_LOCAL
  public static boolean message_flag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "message_flag")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MESSAGE_FLAG, "<message flag>");
    r = consumeToken(b, T_FLAG_PUBLIC);
    if (!r) r = consumeToken(b, T_FLAG_LIB);
    if (!r) r = consumeToken(b, T_FLAG_LOCAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // message_id line_delim [T_INDENT_INDENT (message_group | message)* pseudo_dedent]
  public static boolean message_group(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "message_group")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MESSAGE_GROUP, "<message group>");
    r = message_id(b, l + 1);
    r = r && line_delim(b, l + 1);
    r = r && message_group_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [T_INDENT_INDENT (message_group | message)* pseudo_dedent]
  private static boolean message_group_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "message_group_2")) return false;
    message_group_2_0(b, l + 1);
    return true;
  }

  // T_INDENT_INDENT (message_group | message)* pseudo_dedent
  private static boolean message_group_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "message_group_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_INDENT_INDENT);
    r = r && message_group_2_0_1(b, l + 1);
    r = r && pseudo_dedent(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (message_group | message)*
  private static boolean message_group_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "message_group_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!message_group_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "message_group_2_0_1", c)) break;
    }
    return true;
  }

  // message_group | message
  private static boolean message_group_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "message_group_2_0_1_0")) return false;
    boolean r;
    r = message_group(b, l + 1);
    if (!r) r = message(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // message_flag? id
  public static boolean message_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "message_id")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MESSAGE_ID, "<message id>");
    r = message_id_0(b, l + 1);
    r = r && id(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // message_flag?
  private static boolean message_id_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "message_id_0")) return false;
    message_flag(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // arg_modifier | doc_modifier | version_modifier
  static boolean message_modifiers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "message_modifiers")) return false;
    boolean r;
    r = arg_modifier(b, l + 1);
    if (!r) r = doc_modifier(b, l + 1);
    if (!r) r = version_modifier(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // T_MESSAGE_REF_START T_DYNAMIC? T_IDENTIFIER args_supplier T_CLOSE_BRACE
  public static boolean message_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "message_ref")) return false;
    if (!nextTokenIs(b, T_MESSAGE_REF_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_MESSAGE_REF_START);
    r = r && message_ref_1(b, l + 1);
    r = r && consumeToken(b, T_IDENTIFIER);
    r = r && args_supplier(b, l + 1);
    r = r && consumeToken(b, T_CLOSE_BRACE);
    exit_section_(b, m, MESSAGE_REF, r);
    return r;
  }

  // T_DYNAMIC?
  private static boolean message_ref_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "message_ref_1")) return false;
    consumeToken(b, T_DYNAMIC);
    return true;
  }

  /* ********************************************************** */
  // K_MESSAGES message_id line_delim [T_INDENT_INDENT (message_group | message)* pseudo_dedent]
  public static boolean messages(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "messages")) return false;
    if (!nextTokenIs(b, K_MESSAGES)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_MESSAGES);
    r = r && message_id(b, l + 1);
    r = r && line_delim(b, l + 1);
    r = r && messages_3(b, l + 1);
    exit_section_(b, m, MESSAGES, r);
    return r;
  }

  // [T_INDENT_INDENT (message_group | message)* pseudo_dedent]
  private static boolean messages_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "messages_3")) return false;
    messages_3_0(b, l + 1);
    return true;
  }

  // T_INDENT_INDENT (message_group | message)* pseudo_dedent
  private static boolean messages_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "messages_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_INDENT_INDENT);
    r = r && messages_3_0_1(b, l + 1);
    r = r && pseudo_dedent(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (message_group | message)*
  private static boolean messages_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "messages_3_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!messages_3_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "messages_3_0_1", c)) break;
    }
    return true;
  }

  // message_group | message
  private static boolean messages_3_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "messages_3_0_1_0")) return false;
    boolean r;
    r = message_group(b, l + 1);
    if (!r) r = message(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // T_INDENT_DEDENT | <<eof>>
  static boolean pseudo_dedent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pseudo_dedent")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_INDENT_DEDENT);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_REQUIRE require_target line_delim
  public static boolean require(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "require")) return false;
    if (!nextTokenIs(b, K_REQUIRE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_REQUIRE);
    r = r && require_target(b, l + 1);
    r = r && line_delim(b, l + 1);
    exit_section_(b, m, REQUIRE, r);
    return r;
  }

  /* ********************************************************** */
  // T_IDENTIFIER
  public static boolean require_target(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "require_target")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IDENTIFIER);
    exit_section_(b, m, REQUIRE_TARGET, r);
    return r;
  }

  /* ********************************************************** */
  // T_SPAN_START T_SPAN_TYPE literal T_CLOSE_BRACE
  public static boolean span(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "span")) return false;
    if (!nextTokenIs(b, T_SPAN_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_SPAN_START, T_SPAN_TYPE);
    r = r && literal(b, l + 1);
    r = r && consumeToken(b, T_CLOSE_BRACE);
    exit_section_(b, m, SPAN, r);
    return r;
  }

  /* ********************************************************** */
  // K_VERSION version_value line_delim
  public static boolean version(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "version")) return false;
    if (!nextTokenIs(b, K_VERSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_VERSION);
    r = r && version_value(b, l + 1);
    r = r && line_delim(b, l + 1);
    exit_section_(b, m, VERSION, r);
    return r;
  }

  /* ********************************************************** */
  // T_MODIFIER_VERSION T_IDENTIFIER line_delim
  public static boolean version_modifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "version_modifier")) return false;
    if (!nextTokenIs(b, T_MODIFIER_VERSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_MODIFIER_VERSION, T_IDENTIFIER);
    r = r && line_delim(b, l + 1);
    exit_section_(b, m, VERSION_MODIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // T_IDENTIFIER
  public static boolean version_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "version_value")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IDENTIFIER);
    exit_section_(b, m, VERSION_VALUE, r);
    return r;
  }

}
