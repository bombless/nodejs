import generated.lineParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;

import generated.lineLexer;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

public class Main {
    public static void main(String[] args) throws IOException {
        CharStream stream = CharStreams.fromFileName("source.txt");
        lineLexer lexer = new lineLexer(stream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        lineParser parser = new lineParser(tokenStream);
        for (lineParser.LineContext line: parser.prog().line()) {
            for (lineParser.FragContext frag: line.frag()) {
                String text = frag.EXPR().getSymbol().getText();
                System.out.println(text);
            }
        }
    }
}
