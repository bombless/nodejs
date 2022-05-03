grammar prog;

prog:	(line NEWLINE)* ;
NEWLINE: '\n';
line: npmCommand | frag+;
npmCommand: NPM WHITE_SPACE* frag+;
NPM: '\u55ef\u5c41\u7231\u6155';
frag: EXPR WHITE_SPACE*;
EXPR: NOT_WHITE_SPACE+;
NOT_WHITE_SPACE: ~[ \t\r\n];
WHITE_SPACE: [ \t\r] -> skip;


