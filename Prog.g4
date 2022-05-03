grammar Prog;

prog:	(line NEWLINE)* ;
NEWLINE: '\n';
line: npmCommand | frag+;
npmCommand: NPM npmAction frag;
npmAction: npmActionInstall;
npmActionInstall: I;
frag: EXPR;
NPM: '\u55ef\u5c41\u7231\u6155';
I: '\u7231';
EXPR: NOT_WHITE_SPACE+;
NOT_WHITE_SPACE: ~[ \t\r\n];
WHITE_SPACE: [ \t\r] -> skip;
