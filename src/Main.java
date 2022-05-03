import generated.lineBaseListener;
import generated.lineParser;
import org.antlr.v4.runtime.*;

import java.io.IOException;

import generated.lineLexer;

public class Main {
    public static void main(String[] args) throws IOException {
        CharStream stream = CharStreams.fromFileName("source.txt");
        lineLexer lexer = new lineLexer(stream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        lineParser parser = new lineParser(tokenStream);
        for (lineParser.LineContext line: parser.prog().line()) {
            line.exitRule(new lineBaseListener() {
                @Override
                public void exitNpmCommand(lineParser.NpmCommandContext ctx) {
                    parseNpmCommand(ctx);
                }
            });
            lineParser.NpmCommandContext npmCommand = line.npmCommand();
            if (null != npmCommand) {
                parseNpmCommand(npmCommand);
            } else {
                parseJavascript(line);
            }

        }
    }

    private static void parseNpmCommand(lineParser.NpmCommandContext npmCommand) {
        System.out.println("执行npm命令");
        for (lineParser.FragContext frag: npmCommand.frag()) {
            String text = frag.EXPR().getSymbol().getText();
            System.out.println(text);
        }
    }

    private static void parseJavascript(lineParser.LineContext line) {
        for (lineParser.FragContext frag: line.frag()) {
            String text = frag.EXPR().getSymbol().getText();
            System.out.println(text);
        }
    }
}
