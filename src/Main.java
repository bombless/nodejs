import generated.progBaseListener;
import generated.progParser;
import org.antlr.v4.runtime.*;

import java.io.IOException;

import generated.progLexer;

public class Main {
    public static void main(String[] args) throws IOException {
        CharStream stream = CharStreams.fromFileName("source.txt");
        progLexer lexer = new progLexer(stream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        progParser parser = new progParser(tokenStream);
        for (progParser.LineContext line: parser.prog().line()) {
            line.exitRule(new progBaseListener() {
                @Override
                public void exitNpmCommand(progParser.NpmCommandContext ctx) {
                    parseNpmCommand(ctx);
                }
            });
            progParser.NpmCommandContext npmCommand = line.npmCommand();
            if (null != npmCommand) {
                parseNpmCommand(npmCommand);
            } else {
                parseJavascript(line);
            }

        }
    }

    private static void parseNpmCommand(progParser.NpmCommandContext npmCommand) {
        System.out.println("执行npm命令");
        for (progParser.FragContext frag: npmCommand.frag()) {
            String text = frag.EXPR().getSymbol().getText();
            System.out.println(text);
        }
    }

    private static void parseJavascript(progParser.LineContext line) {
        for (progParser.FragContext frag: line.frag()) {
            String text = frag.EXPR().getSymbol().getText();
            System.out.println(text);
        }
    }
}
