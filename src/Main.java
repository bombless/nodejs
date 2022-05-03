import generated.ProgBaseListener;
import generated.ProgParser;
import generated.ProgLexer;
import org.antlr.v4.runtime.*;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        CharStream stream = CharStreams.fromFileName("source.txt");
        ProgLexer lexer = new ProgLexer(stream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        ProgParser parser = new ProgParser(tokenStream);
        for (ProgParser.LineContext line: parser.prog().line()) {
            line.exitRule(new ProgBaseListener() {
                @Override
                public void exitNpmCommand(ProgParser.NpmCommandContext ctx) {
                    parseNpmCommand(ctx);
                }
            });
            ProgParser.NpmCommandContext npmCommand = line.npmCommand();
            if (null != npmCommand) {
                parseNpmCommand(npmCommand);
            } else {
                parseJavascript(line);
            }

        }
    }

    private static void parseNpmCommand(ProgParser.NpmCommandContext npmCommand) {
        System.out.println("执行npm命令");
        for (ProgParser.FragContext frag: npmCommand.frag()) {
            String text = frag.EXPR().getSymbol().getText();
            System.out.println(text);
        }
    }

    private static void parseJavascript(ProgParser.LineContext line) {
        for (ProgParser.FragContext frag: line.frag()) {
            String text = frag.EXPR().getSymbol().getText();
            System.out.println(text);
        }
    }
}
