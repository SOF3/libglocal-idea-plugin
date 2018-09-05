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
    if (t == AUTHOR_BLOCK) {
      r = author_block(b, 0);
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
    else if (t == CONSTRAINT_DELIM) {
      r = constraint_delim(b, 0);
    }
    else if (t == CONSTRAINT_DOC) {
      r = constraint_doc(b, 0);
    }
    else if (t == CONSTRAINT_FIELD) {
      r = constraint_field(b, 0);
    }
    else if (t == ELEMENT_ARG_DEFAULT) {
      r = element_arg_default(b, 0);
    }
    else if (t == ELEMENT_ARG_NAME) {
      r = element_arg_name(b, 0);
    }
    else if (t == ELEMENT_ARG_REF) {
      r = element_arg_ref(b, 0);
    }
    else if (t == ELEMENT_ARG_TYPE) {
      r = element_arg_type(b, 0);
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
    else if (t == ELEMENT_LANG_ID) {
      r = element_lang_id(b, 0);
    }
    else if (t == ELEMENT_LANG_NAME) {
      r = element_lang_name(b, 0);
    }
    else if (t == ELEMENT_LITERAL) {
      r = element_literal(b, 0);
    }
    else if (t == ELEMENT_LITERAL_STATIC) {
      r = element_literal_static(b, 0);
    }
    else if (t == ELEMENT_MESSAGE_ID) {
      r = element_message_id(b, 0);
    }
    else if (t == ELEMENT_MESSAGE_REF) {
      r = element_message_ref(b, 0);
    }
    else if (t == ELEMENT_REQUIRE_TARGET) {
      r = element_require_target(b, 0);
    }
    else if (t == ELEMENT_SPAN) {
      r = element_span(b, 0);
    }
    else if (t == ELEMENT_VERSION_VALUE) {
      r = element_version_value(b, 0);
    }
    else if (t == LANG_BLOCK) {
      r = lang_block(b, 0);
    }
    else if (t == MODIFIER_ARG) {
      r = modifier_arg(b, 0);
    }
    else if (t == MODIFIER_DOC) {
      r = modifier_doc(b, 0);
    }
    else if (t == MODIFIER_VERSION) {
      r = modifier_version(b, 0);
    }
    else if (t == REQUIRE_BLOCK) {
      r = require_block(b, 0);
    }
    else if (t == VERSION_BLOCK) {
      r = version_block(b, 0);
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
  // constraint_field | constraint_delim | constraint_doc
  static boolean arg_constraints(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_constraints")) return false;
    boolean r;
    r = constraint_field(b, l + 1);
    if (!r) r = constraint_delim(b, l + 1);
    if (!r) r = constraint_doc(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // T_MODIFIER_ARG element_arg_name [element_arg_type [element_arg_default]] line_delim
  static boolean arg_template(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_template")) return false;
    if (!nextTokenIs(b, T_MODIFIER_ARG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_MODIFIER_ARG);
    r = r && element_arg_name(b, l + 1);
    r = r && arg_template_2(b, l + 1);
    r = r && line_delim(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [element_arg_type [element_arg_default]]
  private static boolean arg_template_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_template_2")) return false;
    arg_template_2_0(b, l + 1);
    return true;
  }

  // element_arg_type [element_arg_default]
  private static boolean arg_template_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_template_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = element_arg_type(b, l + 1);
    r = r && arg_template_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [element_arg_default]
  private static boolean arg_template_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_template_2_0_1")) return false;
    element_arg_default(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // K_AUTHOR element_literal_static line_delim
  public static boolean author_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "author_block")) return false;
    if (!nextTokenIs(b, K_AUTHOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_AUTHOR);
    r = r && element_literal_static(b, l + 1);
    r = r && line_delim(b, l + 1);
    exit_section_(b, m, AUTHOR_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // element_message_id element_literal line_delim
  // 	[T_INDENT_INDENT message_modifiers* pseudo_dedent]
  public static boolean block_message(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_message")) return false;
    if (!nextTokenIs(b, "<block message>", T_FLAG, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_MESSAGE, "<block message>");
    r = element_message_id(b, l + 1);
    r = r && element_literal(b, l + 1);
    r = r && line_delim(b, l + 1);
    r = r && block_message_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [T_INDENT_INDENT message_modifiers* pseudo_dedent]
  private static boolean block_message_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_message_3")) return false;
    block_message_3_0(b, l + 1);
    return true;
  }

  // T_INDENT_INDENT message_modifiers* pseudo_dedent
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

  // message_modifiers*
  private static boolean block_message_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_message_3_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!message_modifiers(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_message_3_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // element_message_id line_delim [T_INDENT_INDENT (block_message_group | block_message)* pseudo_dedent]
  public static boolean block_message_group(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_message_group")) return false;
    if (!nextTokenIs(b, "<block message group>", T_FLAG, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_MESSAGE_GROUP, "<block message group>");
    r = element_message_id(b, l + 1);
    r = r && line_delim(b, l + 1);
    r = r && block_message_group_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // K_MESSAGES element_message_id line_delim [T_INDENT_INDENT (block_message_group | block_message)* pseudo_dedent]
  public static boolean block_messages(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_messages")) return false;
    if (!nextTokenIs(b, K_MESSAGES)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_MESSAGES);
    r = r && element_message_id(b, l + 1);
    r = r && line_delim(b, l + 1);
    r = r && block_messages_3(b, l + 1);
    exit_section_(b, m, BLOCK_MESSAGES, r);
    return r;
  }

  // [T_INDENT_INDENT (block_message_group | block_message)* pseudo_dedent]
  private static boolean block_messages_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_messages_3")) return false;
    block_messages_3_0(b, l + 1);
    return true;
  }

  // T_INDENT_INDENT (block_message_group | block_message)* pseudo_dedent
  private static boolean block_messages_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_messages_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_INDENT_INDENT);
    r = r && block_messages_3_0_1(b, l + 1);
    r = r && pseudo_dedent(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (block_message_group | block_message)*
  private static boolean block_messages_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_messages_3_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!block_messages_3_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_messages_3_0_1", c)) break;
    }
    return true;
  }

  // block_message_group | block_message
  private static boolean block_messages_3_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_messages_3_0_1_0")) return false;
    boolean r;
    r = block_message_group(b, l + 1);
    if (!r) r = block_message(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // T_INSTRUCTION "delim" T_IDENTIFIER line_delim
  public static boolean constraint_delim(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constraint_delim")) return false;
    if (!nextTokenIs(b, T_INSTRUCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_INSTRUCTION);
    r = r && consumeToken(b, "delim");
    r = r && consumeToken(b, T_IDENTIFIER);
    r = r && line_delim(b, l + 1);
    exit_section_(b, m, CONSTRAINT_DELIM, r);
    return r;
  }

  /* ********************************************************** */
  // T_MODIFIER_DOC element_literal_static line_delim
  public static boolean constraint_doc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constraint_doc")) return false;
    if (!nextTokenIs(b, T_MODIFIER_DOC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_MODIFIER_DOC);
    r = r && element_literal_static(b, l + 1);
    r = r && line_delim(b, l + 1);
    exit_section_(b, m, CONSTRAINT_DOC, r);
    return r;
  }

  /* ********************************************************** */
  // arg_template [T_INDENT_INDENT arg_constraints* pseudo_dedent]
  public static boolean constraint_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constraint_field")) return false;
    if (!nextTokenIs(b, T_MODIFIER_ARG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = arg_template(b, l + 1);
    r = r && constraint_field_1(b, l + 1);
    exit_section_(b, m, CONSTRAINT_FIELD, r);
    return r;
  }

  // [T_INDENT_INDENT arg_constraints* pseudo_dedent]
  private static boolean constraint_field_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constraint_field_1")) return false;
    constraint_field_1_0(b, l + 1);
    return true;
  }

  // T_INDENT_INDENT arg_constraints* pseudo_dedent
  private static boolean constraint_field_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constraint_field_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_INDENT_INDENT);
    r = r && constraint_field_1_0_1(b, l + 1);
    r = r && pseudo_dedent(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // arg_constraints*
  private static boolean constraint_field_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constraint_field_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arg_constraints(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "constraint_field_1_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // element_literal
  public static boolean element_arg_default(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_arg_default")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELEMENT_ARG_DEFAULT, "<element arg default>");
    r = element_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_IDENTIFIER
  public static boolean element_arg_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_arg_name")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IDENTIFIER);
    exit_section_(b, m, ELEMENT_ARG_NAME, r);
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
  // T_FLAG* T_IDENTIFIER
  public static boolean element_arg_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_arg_type")) return false;
    if (!nextTokenIs(b, "<element arg type>", T_FLAG, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELEMENT_ARG_TYPE, "<element arg type>");
    r = element_arg_type_0(b, l + 1);
    r = r && consumeToken(b, T_IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // T_FLAG*
  private static boolean element_arg_type_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_arg_type_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, T_FLAG)) break;
      if (!empty_element_parsed_guard_(b, "element_arg_type_0", c)) break;
    }
    return true;
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
  // T_IDENTIFIER
  public static boolean element_lang_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_lang_id")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IDENTIFIER);
    exit_section_(b, m, ELEMENT_LANG_ID, r);
    return r;
  }

  /* ********************************************************** */
  // element_literal_static
  public static boolean element_lang_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_lang_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELEMENT_LANG_NAME, "<element lang name>");
    r = element_literal_static(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // T_FLAG* T_IDENTIFIER
  public static boolean element_message_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_message_id")) return false;
    if (!nextTokenIs(b, "<element message id>", T_FLAG, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELEMENT_MESSAGE_ID, "<element message id>");
    r = element_message_id_0(b, l + 1);
    r = r && consumeToken(b, T_IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // T_FLAG*
  private static boolean element_message_id_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_message_id_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, T_FLAG)) break;
      if (!empty_element_parsed_guard_(b, "element_message_id_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // T_MESSAGE_REF_START T_DYNAMIC? T_IDENTIFIER element_args_supplier T_CLOSE_BRACE
  public static boolean element_message_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_message_ref")) return false;
    if (!nextTokenIs(b, T_MESSAGE_REF_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_MESSAGE_REF_START);
    r = r && element_message_ref_1(b, l + 1);
    r = r && consumeToken(b, T_IDENTIFIER);
    r = r && element_args_supplier(b, l + 1);
    r = r && consumeToken(b, T_CLOSE_BRACE);
    exit_section_(b, m, ELEMENT_MESSAGE_REF, r);
    return r;
  }

  // T_DYNAMIC?
  private static boolean element_message_ref_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_message_ref_1")) return false;
    consumeToken(b, T_DYNAMIC);
    return true;
  }

  /* ********************************************************** */
  // T_IDENTIFIER
  public static boolean element_require_target(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_require_target")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IDENTIFIER);
    exit_section_(b, m, ELEMENT_REQUIRE_TARGET, r);
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
  // T_IDENTIFIER
  public static boolean element_version_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_version_value")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IDENTIFIER);
    exit_section_(b, m, ELEMENT_VERSION_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // (K_BASE_LANG | K_LANG) element_lang_id element_lang_name line_delim
  public static boolean lang_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lang_block")) return false;
    if (!nextTokenIs(b, "<lang block>", K_BASE_LANG, K_LANG)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LANG_BLOCK, "<lang block>");
    r = lang_block_0(b, l + 1);
    r = r && element_lang_id(b, l + 1);
    r = r && element_lang_name(b, l + 1);
    r = r && line_delim(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // K_BASE_LANG | K_LANG
  private static boolean lang_block_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lang_block_0")) return false;
    boolean r;
    r = consumeToken(b, K_BASE_LANG);
    if (!r) r = consumeToken(b, K_LANG);
    return r;
  }

  /* ********************************************************** */
  // (lang_block | author_block | version_block | require_block)+ block_messages
  static boolean libglocal_file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "libglocal_file")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = libglocal_file_0(b, l + 1);
    r = r && block_messages(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (lang_block | author_block | version_block | require_block)+
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

  // lang_block | author_block | version_block | require_block
  private static boolean libglocal_file_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "libglocal_file_0_0")) return false;
    boolean r;
    r = lang_block(b, l + 1);
    if (!r) r = author_block(b, l + 1);
    if (!r) r = version_block(b, l + 1);
    if (!r) r = require_block(b, l + 1);
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
  // modifier_arg | modifier_doc | modifier_version
  static boolean message_modifiers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "message_modifiers")) return false;
    boolean r;
    r = modifier_arg(b, l + 1);
    if (!r) r = modifier_doc(b, l + 1);
    if (!r) r = modifier_version(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // arg_template [T_INDENT_INDENT arg_constraints* pseudo_dedent]
  public static boolean modifier_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_arg")) return false;
    if (!nextTokenIs(b, T_MODIFIER_ARG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = arg_template(b, l + 1);
    r = r && modifier_arg_1(b, l + 1);
    exit_section_(b, m, MODIFIER_ARG, r);
    return r;
  }

  // [T_INDENT_INDENT arg_constraints* pseudo_dedent]
  private static boolean modifier_arg_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_arg_1")) return false;
    modifier_arg_1_0(b, l + 1);
    return true;
  }

  // T_INDENT_INDENT arg_constraints* pseudo_dedent
  private static boolean modifier_arg_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_arg_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_INDENT_INDENT);
    r = r && modifier_arg_1_0_1(b, l + 1);
    r = r && pseudo_dedent(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // arg_constraints*
  private static boolean modifier_arg_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_arg_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arg_constraints(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "modifier_arg_1_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // T_MODIFIER_DOC element_literal_static? line_delim
  public static boolean modifier_doc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_doc")) return false;
    if (!nextTokenIs(b, T_MODIFIER_DOC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_MODIFIER_DOC);
    r = r && modifier_doc_1(b, l + 1);
    r = r && line_delim(b, l + 1);
    exit_section_(b, m, MODIFIER_DOC, r);
    return r;
  }

  // element_literal_static?
  private static boolean modifier_doc_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_doc_1")) return false;
    element_literal_static(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // T_MODIFIER_VERSION T_IDENTIFIER line_delim
  public static boolean modifier_version(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_version")) return false;
    if (!nextTokenIs(b, T_MODIFIER_VERSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_MODIFIER_VERSION, T_IDENTIFIER);
    r = r && line_delim(b, l + 1);
    exit_section_(b, m, MODIFIER_VERSION, r);
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
  // K_REQUIRE element_require_target line_delim
  public static boolean require_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "require_block")) return false;
    if (!nextTokenIs(b, K_REQUIRE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_REQUIRE);
    r = r && element_require_target(b, l + 1);
    r = r && line_delim(b, l + 1);
    exit_section_(b, m, REQUIRE_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // K_VERSION element_version_value line_delim
  public static boolean version_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "version_block")) return false;
    if (!nextTokenIs(b, K_VERSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_VERSION);
    r = r && element_version_value(b, l + 1);
    r = r && line_delim(b, l + 1);
    exit_section_(b, m, VERSION_BLOCK, r);
    return r;
  }

}
