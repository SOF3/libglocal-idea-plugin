package io.github.sof3.libglocal.idea;

import java.io.Reader;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import io.github.sof3.libglocal.idea.util.StringStack;

%%
%public
%class LibglocalLexer
%implements FlexLexer, LibglocalTokens
%unicode
%function advance
%type IElementType
%ignorecase

%{
//	private StringStack indentStack = new StringStack();
	private int stateBeforeBlockComment = -1;

	public LibglocalLexer(){
		this((Reader) null);
	}
%}

%state S_LANG_UNNAMED
%state S_LANG_NAMED
%state S_AUTHORS
%state S_VERSION
%state S_TREE_SOL
%state S_TREE_MESSAGE
%state S_TREE_REF_ARG
%state S_TREE_REF_MESSAGE
%state S_TREE_REF_MESSAGE_ARGS
%state S_TREE_REF_MESSAGE_START_ARG
%state S_TREE_REF_MESSAGE_EQUAL_ARG
%state S_TREE_REF_MESSAGE_END_ARG
%state S_TREE_REF_MESSAGE_END_ARG_STRING_LITERAL
%state S_TREE_REF_MESSAGE_NEXT_ARG
%state S_TREE_REF_SPAN_START
%state S_TREE_REF_SPAN_STYLED
%state S_TREE_REF_SPAN_SPACE
%state S_TREE_REF_SPAN_VALUE
%state S_TREE_ARG
%state S_TREE_ARG_NAMED
%state S_TREE_ARG_UNTYPED
%state S_TREE_ARG_TYPED
%state S_TREE_ARG_DEFAULT
%state S_TREE_ARG_POST_DEFAULT
%state S_TREE_ARG_DEFAULT_STRING_LITERAL
%state S_TREE_DOC
%state S_TREE_VERSION
%state S_C_STYLE_COMMENT

WHITE_SPACE=[ \t]
EOL={WHITE_SPACE}*(\r|\n|\r\n)
IDENTIFIER=[\w.-]+
LINE_COMMENT={WHITE_SPACE}*\/\/[^\r\n]*

%%

{LINE_COMMENT} { return LINE_COMMENT; }
{WHITE_SPACE}*\/\* { stateBeforeBlockComment = yystate(); yybegin(S_C_STYLE_COMMENT); return BLOCK_COMMENT; }

<S_C_STYLE_COMMENT> {
	"*/" { yybegin(stateBeforeBlockComment); return BLOCK_COMMENT; }
	[^] { return BLOCK_COMMENT; }
}

<YYINITIAL> {
	"base"{WHITE_SPACE}* { return BASE_KEYWORD; }
	"lang"{WHITE_SPACE}* { yybegin(S_LANG_UNNAMED); return LANG_KEYWORD; }
	"messages" { yybegin(S_TREE_SOL); return MESSAGES_KEYWORD; }
	"author"{WHITE_SPACE}+ { yybegin(S_AUTHORS); return AUTHOR_KEYWORD; }
	"version"{WHITE_SPACE}+ { yybegin(S_VERSION); return VERSION_KEYWORD; }
	{WHITE_SPACE}*{EOL} { return EOL; }
	{WHITE_SPACE}+ { return WHITE_SPACE; }
}

<S_LANG_UNNAMED> {
	{WHITE_SPACE}+ { return WHITE_SPACE; }
	\w+ { yybegin(S_LANG_NAMED); return LANG_NAME; }
	{EOL} { yybegin(YYINITIAL); return EOL; }
}
<S_LANG_NAMED> {
	[^\r\n\/]+(\/[^\r\n\/]+)* { return LANG_LOCAL; }
	{EOL} { yybegin(YYINITIAL); return EOL; }
}

<S_AUTHORS> {
	{WHITE_SPACE}+ { return WHITE_SPACE; }
	[^\r\n,\/]+ { return AUTHOR_NAME; }
	"," { return AUTHOR_SEPARATOR; }
	{EOL} { yybegin(YYINITIAL); return EOL; }
}
<S_VERSION> {
	{WHITE_SPACE}+ { return WHITE_SPACE; }
	{EOL} { yybegin(YYINITIAL); return EOL; }
	{IDENTIFIER} { return VERSION_VALUE; }
}

<S_TREE_SOL> {
	{WHITE_SPACE}+ { return INDENT; }
	"arg"{WHITE_SPACE}+ { yybegin(S_TREE_ARG); return ARG_KEYWORD; }
	"doc"{WHITE_SPACE}+ { yybegin(S_TREE_DOC); return DOC_KEYWORD; }
	"since"{WHITE_SPACE}+ { yybegin(S_TREE_VERSION); return SINCE_KEYWORD; }
	"updated"{WHITE_SPACE}+ { yybegin(S_TREE_VERSION); return UPDATED_KEYWORD; }
	{IDENTIFIER} { yybegin(S_TREE_MESSAGE); return MESSAGE_ID; }
	{EOL} { return EOL; }
}
<S_TREE_MESSAGE> {
	{EOL} { yybegin(S_TREE_SOL); return EOL; }
	[^\r\n\\#\$%\}/]+ { return LITERAL; }
	\/ { return LITERAL; } // the comment would have already been captured if it is one
	\\[#\$%n\/\}] { return ESCAPE; }
	"}" { return PERCENT_CLOSE; }
	"${" { yybegin(S_TREE_REF_ARG); return DOLLAR_OPEN; }
	"#{" { yybegin(S_TREE_REF_MESSAGE); return HASH_OPEN; }
	"%{" { yybegin(S_TREE_REF_SPAN_START); return PERCENT_OPEN; }
}
<S_TREE_REF_ARG> {
	{IDENTIFIER} { return ARG_NAME; }
	"}" { yybegin(S_TREE_MESSAGE); return DOLLAR_CLOSE; }
}
<S_TREE_REF_MESSAGE> {
	{IDENTIFIER} { yybegin(S_TREE_REF_MESSAGE_ARGS); return MESSAGE_ID; }
}
<S_TREE_REF_MESSAGE_ARGS> {
	"(" { yybegin(S_TREE_REF_MESSAGE_START_ARG); return OPEN_PAREN; }
	"}" { yybegin(S_TREE_MESSAGE); return HASH_CLOSE; }
}
<S_TREE_REF_MESSAGE_START_ARG> {
	{IDENTIFIER} { yybegin(S_TREE_REF_MESSAGE_EQUAL_ARG); return ARG_NAME; }
	")" { yybegin(S_TREE_REF_MESSAGE_ARGS); return CLOSE_PAREN; }
}
<S_TREE_REF_MESSAGE_EQUAL_ARG> {
	{WHITE_SPACE}*"="{WHITE_SPACE}* { yybegin(S_TREE_REF_MESSAGE_END_ARG); return ARG_EQUALS; }

}
<S_TREE_REF_MESSAGE_END_ARG> {
	-?[0-9]+(\.[0-9]+)? { yybegin(S_TREE_REF_MESSAGE_NEXT_ARG); return NUMBER_LITERAL; }
	{IDENTIFIER} { yybegin(S_TREE_REF_MESSAGE_NEXT_ARG); return ARG_NAME; }
	"\"" { yybegin(S_TREE_REF_MESSAGE_END_ARG_STRING_LITERAL); return OPEN_QUOTE; }
}
<S_TREE_REF_MESSAGE_END_ARG_STRING_LITERAL> {
	[^\\\"\r\n]+ { return LITERAL; }
	\\\" { return ESCAPE; }
	"\"" { yybegin(S_TREE_REF_MESSAGE_NEXT_ARG); return CLOSE_QUOTE; }
}
<S_TREE_REF_MESSAGE_NEXT_ARG> {
	"," { yybegin(S_TREE_REF_MESSAGE_START_ARG); return ARGS_SEPARATOR; }
	")" { yybegin(S_TREE_REF_MESSAGE_ARGS); return CLOSE_PAREN; }
}
<S_TREE_REF_SPAN_START> {
	{WHITE_SPACE}+ { return WHITE_SPACE; }
	hl[1-4]|[bius] { yybegin(S_TREE_REF_SPAN_SPACE); return SPAN_NAME; }
	"info" | "success" | "notice" | "warn" | "error" { yybegin(S_TREE_REF_SPAN_STYLED); return SPAN_STYLE; }
}
<S_TREE_REF_SPAN_STYLED> {
	{WHITE_SPACE}+ { return WHITE_SPACE; }
	"}" { yybegin(S_TREE_MESSAGE); return PERCENT_CLOSE; }
}
<S_TREE_REF_SPAN_SPACE> {
	{WHITE_SPACE}+ { yybegin(S_TREE_MESSAGE); return WHITE_SPACE; }
}

<S_TREE_ARG> {
	{IDENTIFIER} { yybegin(S_TREE_ARG_NAMED); return ARG_NAME; }
}
<S_TREE_ARG_NAMED> {
	{WHITE_SPACE}+ { yybegin(S_TREE_ARG_UNTYPED); return WHITE_SPACE; }
	{EOL} { yybegin(S_TREE_SOL); return EOL; }
}
<S_TREE_ARG_UNTYPED> {
	{IDENTIFIER}: { return ARG_TYPE_MODIFIER; }
	{IDENTIFIER} { yybegin(S_TREE_ARG_TYPED); return ARG_TYPE; }
}
<S_TREE_ARG_TYPED> {
	{EOL} { yybegin(S_TREE_SOL); return EOL; }
	{WHITE_SPACE}+ { return WHITE_SPACE; }
	"=" { yybegin(S_TREE_ARG_DEFAULT); return ARG_EQUALS; }
}
<S_TREE_ARG_DEFAULT> {
	-?[0-9]+(\.[0-9]+)? { yybegin(S_TREE_SOL); return NUMBER_LITERAL; }
	{IDENTIFIER} { yybegin(S_TREE_SOL); return ARG_NAME; }
	"\"" { yybegin(S_TREE_ARG_DEFAULT_STRING_LITERAL); return OPEN_QUOTE; }
}
<S_TREE_ARG_DEFAULT_STRING_LITERAL> {
	[^\\\"\r\n] { return LITERAL; }
	\\\" { return ESCAPE; }
	"\"" { yybegin(S_TREE_SOL); return CLOSE_QUOTE; }
}
<S_TREE_ARG_POST_DEFAULT> {
	{EOL} { return EOL; }
}
<S_TREE_DOC> {
	{EOL} { yybegin(S_TREE_SOL); return EOL; }
	[^\r\n]+ { return DOC_VALUE; }
}
<S_TREE_VERSION> {
	{EOL} { yybegin(S_TREE_SOL); return EOL; }
	{IDENTIFIER} { return VERSION_VALUE; }
}

[^] { return TokenType.BAD_CHARACTER; }
