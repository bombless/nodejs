grammar line;

prog:	(line NEWLINE)* ;
NEWLINE: [\u000A];
line: frag+;
frag: EXPR WHITE_SPACE*;
EXPR: NOT_WHITE_SPACE+;
NOT_WHITE_SPACE: ~[ \u0009\u000D\u000A];
WHITE_SPACE: [ \u0009\u000D];


