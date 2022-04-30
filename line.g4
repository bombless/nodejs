grammar line;

prog:	(line NEWLINE)* ;
NEWLINE: [\u000D];
line: frag+;
frag: expr WHITE_SPACE*;
expr: NOT_WHITE_SPACE+;
NOT_WHITE_SPACE: ~[ \u0009\u000A];
WHITE_SPACE: [ \u0009\u000A];

