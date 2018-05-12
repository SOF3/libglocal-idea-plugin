package io.github.sof3.libglocal.idea;

import java.io.Reader;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;

%%
%public
%class LibglocalLexer
%implements FlexLexer, LibglocalTokens
%unicode
%function advance
%type IElementType
%ignorecase

%{
	private StringStack indentStack = new StringStack();

	public LibglocalLexer(){
		this((Reader) null);
	}
%}

%state S_LANG_UNNAMED
%state S_LANG_NAMED
%state S_MESSAGES
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

WHITE_SPACE=[ \t]
EOL={WHITE_SPACE}*(\r|\n|\r\n)
IDENTIFIER=[\w.-]+
COMMENT={WHITE_SPACE}*\/\/[^\r\n]*

%%

<YYINITIAL> {
	"base" { return BASE_KEYWORD; }
	"lang" { yybegin(S_LANG_UNNAMED); return LANG_KEYWORD; }
	{WHITE_SPACE}*{EOL} { return EOL; }
	{WHITE_SPACE}+ { return WHITE_SPACE; }
}

<S_LANG_UNNAMED> {
	{WHITE_SPACE}+ { return WHITE_SPACE; }
	\w+ { yybegin(S_LANG_NAMED); return LANG_NAME; }
	{EOL} { yybegin(S_MESSAGES); return EOL; }
}
<S_LANG_NAMED> {
	[^\r\n]+ { return LANG_LOCAL; }
	{EOL} { yybegin(S_MESSAGES); return EOL; }
}

<S_MESSAGES> {
	"messages" { yybegin(S_TREE_SOL); return MESSAGES_KEYWORD; }
	{WHITE_SPACE}*{EOL} { return EOL; }
}

<S_TREE_SOL> {
	{COMMENT} { return COMMENT; }
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
	[^\r\n\\#\$%\}]+ { return LITERAL; }
	\\[#\$%n] { return ESCAPE; }
	"}" { return CLOSE_BRACE; }
	"${" { yybegin(S_TREE_REF_ARG); return DOLLAR_OPEN; }
	"#{" { yybegin(S_TREE_REF_MESSAGE); return HASH_OPEN; }
	"%{" { yybegin(S_TREE_REF_SPAN_START); return PERCENT_OPEN; }
}
<S_TREE_REF_ARG> {
	{IDENTIFIER} { return ARG_NAME; }
	"}" { yybegin(S_TREE_MESSAGE); return CLOSE_BRACE; }
}
<S_TREE_REF_MESSAGE> {
	{IDENTIFIER} { yybegin(S_TREE_REF_MESSAGE_ARGS); return MESSAGE_ID; }
}
<S_TREE_REF_MESSAGE_ARGS> {
	"(" { yybegin(S_TREE_REF_MESSAGE_START_ARG); return OPEN_PAREN; }
	"}" { yybegin(S_TREE_MESSAGE); return CLOSE_BRACE; }
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
	[^\\\"\r\n] { return LITERAL; }
	\\\" { return ESCAPE; }
	"\"" { yybegin(S_TREE_REF_MESSAGE_NEXT_ARG); return CLOSE_QUOTE; }
}
<S_TREE_REF_MESSAGE_NEXT_ARG> {
	"," { yybegin(S_TREE_REF_MESSAGE_START_ARG); return ARGS_SEPARATOR; }
	")" { yybegin(S_TREE_REF_MESSAGE_ARGS); return CLOSE_PAREN; }
}
<S_TREE_REF_SPAN_START> {
	hl[1-4]|[bius] { yybegin(S_TREE_REF_SPAN_SPACE); return SPAN_NAME; }
}
<S_TREE_REF_SPAN_SPACE> {
	{WHITE_SPACE}+ { yybegin(S_TREE_MESSAGE); return WHITE_SPACE; }
}
<S_TREE_ARG> {
	{IDENTIFIER} { yybegin(S_TREE_ARG_NAMED); return ARG_NAME; }
}
<S_TREE_ARG_NAMED> {
	{WHITE_SPACE}+ { yybegin(S_TREE_ARG_UNTYPED); return WHITE_SPACE; }
}
<S_TREE_ARG_UNTYPED> {
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
	[^] { return DOC_VALUE; }
}
<S_TREE_VERSION> {
	{EOL} { yybegin(S_TREE_SOL); return EOL; }
	{IDENTIFIER} { return VERSION_VALUE; }
}

[^] { throw new RuntimeException("Unexpected value '" + yytext() + "' at state " + yystate()); }
