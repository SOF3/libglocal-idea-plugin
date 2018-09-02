// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static io.github.sof3.libglocal.idea.psi.LibglocalElements.*;
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
    if (t == BLOCK_AUTHOR) {
      r = block_author(b, 0);
    }
    else if (t == BLOCK_CONSTRAINT) {
      r = block_constraint(b, 0);
    }
    else if (t == BLOCK_LANG) {
      r = block_lang(b, 0);
    }
    else if (t == BLOCK_MESSAGE) {
      r = block_message(b, 0);
    }
    else if (t == BLOCK_MESSAGE_GROUP) {
      r = block_message_group(b, 0);
    }
    else if (t == BLOCK_MESSAGES) {
      r = block_messages(b, 0);
    }
    else if (t == BLOCK_MODIFIER) {
      r = block_modifier(b, 0);
    }
    else if (t == BLOCK_VERSION) {
      r = block_version(b, 0);
    }
    else if (t == ELEMENT_ARG_REF) {
      r = element_arg_ref(b, 0);
    }
    else if (t == ELEMENT_ARGS_ENTRY) {
      r = element_args_entry(b, 0);
    }
    else if (t == ELEMENT_ARGS_SUPPLIER) {
      r = element_args_supplier(b, 0);
    }
    else if (t == ELEMENT_ARGS_VALUE) {
      r = element_args_value(b, 0);
    }
    else if (t == ELEMENT_ARGS_VALUE_STRING) {
      r = element_args_value_string(b, 0);
    }
    else if (t == ELEMENT_LITERAL) {
      r = element_literal(b, 0);
    }
    else if (t == ELEMENT_LITERAL_STATIC) {
      r = element_literal_static(b, 0);
    }
    else if (t == ELEMENT_MESSAGE_REF) {
      r = element_message_ref(b, 0);
    }
    else if (t == ELEMENT_MODIFIER_ARG) {
      r = element_modifier_arg(b, 0);
    }
    else if (t == ELEMENT_MODIFIER_DOC) {
      r = element_modifier_doc(b, 0);
    }
    else if (t == ELEMENT_MODIFIER_VERSION) {
      r = element_modifier_version(b, 0);
    }
    else if (t == ELEMENT_SPAN) {
      r = element_span(b, 0);
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
  // K_AUTHOR element_literal_static line_delim
  public static boolean block_author(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_author")) return false;
    if (!nextTokenIs(b, K_AUTHOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_AUTHOR);
    r = r && element_literal_static(b, l + 1);
    r = r && line_delim(b, l + 1);
    exit_section_(b, m, BLOCK_AUTHOR, r);
    return r;
  }

  /* ********************************************************** */
  // T_IDENTIFIER [element_literal_static] line_delim
  public static boolean block_constraint(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_constraint")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IDENTIFIER);
    r = r && block_constraint_1(b, l + 1);
    r = r && line_delim(b, l + 1);
    exit_section_(b, m, BLOCK_CONSTRAINT, r);
    return r;
  }

  // [element_literal_static]
  private static boolean block_constraint_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_constraint_1")) return false;
    element_literal_static(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (K_BASE_LANG | K_LANG) T_IDENTIFIER element_literal_static line_delim
  public static boolean block_lang(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_lang")) return false;
    if (!nextTokenIs(b, "<block lang>", K_BASE_LANG, K_LANG)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_LANG, "<block lang>");
    r = block_lang_0(b, l + 1);
    r = r && consumeToken(b, T_IDENTIFIER);
    r = r && element_literal_static(b, l + 1);
    r = r && line_delim(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // K_BASE_LANG | K_LANG
  private static boolean block_lang_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_lang_0")) return false;
    boolean r;
    r = consumeToken(b, K_BASE_LANG);
    if (!r) r = consumeToken(b, K_LANG);
    return r;
  }

  /* ********************************************************** */
  // T_IDENTIFIER element_literal line_delim [T_INDENT_INDENT (block_modifier)* pseudo_dedent]
  public static boolean block_message(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_message")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IDENTIFIER);
    r = r && element_literal(b, l + 1);
    r = r && line_delim(b, l + 1);
    r = r && block_message_3(b, l + 1);
    exit_section_(b, m, BLOCK_MESSAGE, r);
    return r;
  }

  // [T_INDENT_INDENT (block_modifier)* pseudo_dedent]
  private static boolean block_message_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_message_3")) return false;
    block_message_3_0(b, l + 1);
    return true;
  }

  // T_INDENT_INDENT (block_modifier)* pseudo_dedent
  private static boolean block_message_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_message_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_INDENT_INDENT);
    r = r && block_message_3_0_1(b, l + 1);
    r = r && pseudo_dedent(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (block_modifier)*
  private static boolean block_message_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_message_3_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!block_message_3_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_message_3_0_1", c)) break;
    }
    return true;
  }

  // (block_modifier)
  private static boolean block_message_3_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_message_3_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = block_modifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_IDENTIFIER line_delim [T_INDENT_INDENT (block_message_group | block_message)* pseudo_dedent]
  public static boolean block_message_group(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_message_group")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IDENTIFIER);
    r = r && line_delim(b, l + 1);
    r = r && block_message_group_2(b, l + 1);
    exit_section_(b, m, BLOCK_MESSAGE_GROUP, r);
    return r;
  }

  // [T_INDENT_INDENT (block_message_group | block_message)* pseudo_dedent]
  private static boolean block_message_group_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_message_group_2")) return false;
    block_message_group_2_0(b, l + 1);
    return true;
  }

  // T_INDENT_INDENT (block_message_group | block_message)* pseudo_dedent
  private static boolean block_message_group_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_message_group_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_INDENT_INDENT);
    r = r && block_message_group_2_0_1(b, l + 1);
    r = r && pseudo_dedent(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (block_message_group | block_message)*
  private static boolean block_message_group_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_message_group_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!block_message_group_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_message_group_2_0_1", c)) break;
    }
    return true;
  }

  // block_message_group | block_message
  private static boolean block_message_group_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_message_group_2_0_1_0")) return false;
    boolean r;
    r = block_message_group(b, l + 1);
    if (!r) r = block_message(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // K_MESSAGES line_delim [T_INDENT_INDENT (block_message_group | block_message)* pseudo_dedent]
  public static boolean block_messages(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_messages")) return false;
    if (!nextTokenIs(b, K_MESSAGES)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_MESSAGES);
    r = r && line_delim(b, l + 1);
    r = r && block_messages_2(b, l + 1);
    exit_section_(b, m, BLOCK_MESSAGES, r);
    return r;
  }

  // [T_INDENT_INDENT (block_message_group | block_message)* pseudo_dedent]
  private static boolean block_messages_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_messages_2")) return false;
    block_messages_2_0(b, l + 1);
    return true;
  }

  // T_INDENT_INDENT (block_message_group | block_message)* pseudo_dedent
  private static boolean block_messages_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_messages_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_INDENT_INDENT);
    r = r && block_messages_2_0_1(b, l + 1);
    r = r && pseudo_dedent(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (block_message_group | block_message)*
  private static boolean block_messages_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_messages_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!block_messages_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_messages_2_0_1", c)) break;
    }
    return true;
  }

  // block_message_group | block_message
  private static boolean block_messages_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_messages_2_0_1_0")) return false;
    boolean r;
    r = block_message_group(b, l + 1);
    if (!r) r = block_message(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // modifier_content line_delim [T_INDENT_INDENT (block_constraint)* pseudo_dedent]
  public static boolean block_modifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_modifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_MODIFIER, "<block modifier>");
    r = modifier_content(b, l + 1);
    r = r && line_delim(b, l + 1);
    r = r && block_modifier_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [T_INDENT_INDENT (block_constraint)* pseudo_dedent]
  private static boolean block_modifier_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_modifier_2")) return false;
    block_modifier_2_0(b, l + 1);
    return true;
  }

  // T_INDENT_INDENT (block_constraint)* pseudo_dedent
  private static boolean block_modifier_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_modifier_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_INDENT_INDENT);
    r = r && block_modifier_2_0_1(b, l + 1);
    r = r && pseudo_dedent(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (block_constraint)*
  private static boolean block_modifier_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_modifier_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!block_modifier_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_modifier_2_0_1", c)) break;
    }
    return true;
  }

  // (block_constraint)
  private static boolean block_modifier_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_modifier_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = block_constraint(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_VERSION T_IDENTIFIER line_delim
  public static boolean block_version(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_version")) return false;
    if (!nextTokenIs(b, K_VERSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_VERSION, T_IDENTIFIER);
    r = r && line_delim(b, l + 1);
    exit_section_(b, m, BLOCK_VERSION, r);
    return r;
  }

  /* ********************************************************** */
  // T_ARG_REF_START T_IDENTIFIER T_CLOSE_BRACE
  public static boolean element_arg_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_arg_ref")) return false;
    if (!nextTokenIs(b, T_ARG_REF_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_ARG_REF_START, T_IDENTIFIER, T_CLOSE_BRACE);
    exit_section_(b, m, ELEMENT_ARG_REF, r);
    return r;
  }

  /* ********************************************************** */
  // T_IDENTIFIER T_EQUALS element_args_value
  public static boolean element_args_entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_args_entry")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_IDENTIFIER, T_EQUALS);
    r = r && element_args_value(b, l + 1);
    exit_section_(b, m, ELEMENT_ARGS_ENTRY, r);
    return r;
  }

  /* ********************************************************** */
  // element_args_entry*
  public static boolean element_args_supplier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_args_supplier")) return false;
    Marker m = enter_section_(b, l, _NONE_, ELEMENT_ARGS_SUPPLIER, "<element args supplier>");
    while (true) {
      int c = current_position_(b);
      if (!element_args_entry(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "element_args_supplier", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // T_NUMBER | T_IDENTIFIER | element_args_value_string
  public static boolean element_args_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_args_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELEMENT_ARGS_VALUE, "<element args value>");
    r = consumeToken(b, T_NUMBER);
    if (!r) r = consumeToken(b, T_IDENTIFIER);
    if (!r) r = element_args_value_string(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_OPEN_BRACE element_literal T_CLOSE_BRACE
  public static boolean element_args_value_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_args_value_string")) return false;
    if (!nextTokenIs(b, T_OPEN_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_OPEN_BRACE);
    r = r && element_literal(b, l + 1);
    r = r && consumeToken(b, T_CLOSE_BRACE);
    exit_section_(b, m, ELEMENT_ARGS_VALUE_STRING, r);
    return r;
  }

  /* ********************************************************** */
  // (literal_token)+
  public static boolean element_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELEMENT_LITERAL, "<element literal>");
    r = element_literal_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!element_literal_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "element_literal", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (literal_token)
  private static boolean element_literal_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_literal_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = literal_token(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (literal_token_static)+
  public static boolean element_literal_static(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_literal_static")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELEMENT_LITERAL_STATIC, "<element literal static>");
    r = element_literal_static_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!element_literal_static_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "element_literal_static", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (literal_token_static)
  private static boolean element_literal_static_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_literal_static_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = literal_token_static(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_MESSAGE_REF_START T_IDENTIFIER element_args_supplier T_CLOSE_BRACE
  public static boolean element_message_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_message_ref")) return false;
    if (!nextTokenIs(b, T_MESSAGE_REF_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_MESSAGE_REF_START, T_IDENTIFIER);
    r = r && element_args_supplier(b, l + 1);
    r = r && consumeToken(b, T_CLOSE_BRACE);
    exit_section_(b, m, ELEMENT_MESSAGE_REF, r);
    return r;
  }

  /* ********************************************************** */
  // T_MODIFIER_ARG T_IDENTIFIER [T_IDENTIFIER]
  public static boolean element_modifier_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_modifier_arg")) return false;
    if (!nextTokenIs(b, T_MODIFIER_ARG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_MODIFIER_ARG, T_IDENTIFIER);
    r = r && element_modifier_arg_2(b, l + 1);
    exit_section_(b, m, ELEMENT_MODIFIER_ARG, r);
    return r;
  }

  // [T_IDENTIFIER]
  private static boolean element_modifier_arg_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_modifier_arg_2")) return false;
    consumeToken(b, T_IDENTIFIER);
    return true;
  }

  /* ********************************************************** */
  // T_MODIFIER_DOC element_literal_static
  public static boolean element_modifier_doc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_modifier_doc")) return false;
    if (!nextTokenIs(b, T_MODIFIER_DOC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_MODIFIER_DOC);
    r = r && element_literal_static(b, l + 1);
    exit_section_(b, m, ELEMENT_MODIFIER_DOC, r);
    return r;
  }

  /* ********************************************************** */
  // T_MODIFIER_VERSION T_IDENTIFIER
  public static boolean element_modifier_version(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_modifier_version")) return false;
    if (!nextTokenIs(b, T_MODIFIER_VERSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_MODIFIER_VERSION, T_IDENTIFIER);
    exit_section_(b, m, ELEMENT_MODIFIER_VERSION, r);
    return r;
  }

  /* ********************************************************** */
  // T_SPAN_START T_SPAN_TYPE element_literal T_CLOSE_BRACE
  public static boolean element_span(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_span")) return false;
    if (!nextTokenIs(b, T_SPAN_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_SPAN_START, T_SPAN_TYPE);
    r = r && element_literal(b, l + 1);
    r = r && consumeToken(b, T_CLOSE_BRACE);
    exit_section_(b, m, ELEMENT_SPAN, r);
    return r;
  }

  /* ********************************************************** */
  // (block_lang | block_author | block_version)+ block_messages
  static boolean libglocal_file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "libglocal_file")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = libglocal_file_0(b, l + 1);
    r = r && block_messages(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (block_lang | block_author | block_version)+
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

  // block_lang | block_author | block_version
  private static boolean libglocal_file_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "libglocal_file_0_0")) return false;
    boolean r;
    r = block_lang(b, l + 1);
    if (!r) r = block_author(b, l + 1);
    if (!r) r = block_version(b, l + 1);
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
  // literal_token_static | element_arg_ref | element_message_ref | element_span
  static boolean literal_token(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_token")) return false;
    boolean r;
    r = literal_token_static(b, l + 1);
    if (!r) r = element_arg_ref(b, l + 1);
    if (!r) r = element_message_ref(b, l + 1);
    if (!r) r = element_span(b, l + 1);
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
  // element_modifier_arg | element_modifier_doc | element_modifier_version
  static boolean modifier_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_content")) return false;
    boolean r;
    r = element_modifier_arg(b, l + 1);
    if (!r) r = element_modifier_doc(b, l + 1);
    if (!r) r = element_modifier_version(b, l + 1);
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

}
