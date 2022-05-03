import generated.ProgBaseListener;
import generated.ProgParser;
import generated.ProgLexer;
import org.antlr.v4.runtime.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Main {
    private static Map<String, String> packageNaming = new HashMap<String, String>() {{
        put("抠", "cors");
    }};
    public static void main(String[] args) throws IOException, IllegalAccessException {
        CharStream stream = CharStreams.fromFileName("source.txt");
        ProgLexer lexer = new ProgLexer(stream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        ProgParser parser = new ProgParser(tokenStream);
        for (ProgParser.LineContext line: parser.prog().line()) {
            ProgParser.NpmCommandContext npmCommand = line.npmCommand();
            if (null != npmCommand) {
                parseNpmCommand(npmCommand);
            } else {
                parseJavascript(line);
            }

        }
    }

    private static void parseNpmCommand(ProgParser.NpmCommandContext npmCommand) throws IllegalAccessException {
        System.out.println("执行npm命令");
        ProgParser.NpmActionContext action = npmCommand.npmAction();
        if (null == action.npmActionInstall()) {
            throw new IllegalAccessException("暂不支持npm命令" + action.getText());
        }
        String packageNameAlias = npmCommand.frag().getText();
        if (!packageNaming.containsKey(packageNameAlias)) {
            throw new IllegalAccessException("未知的npm包" + packageNameAlias);
        }
        System.out.println("npm安装" + packageNaming.get(packageNameAlias));
    }

    private static void parseJavascript(ProgParser.LineContext line) {
        for (ProgParser.FragContext frag: line.frag()) {
            String text = frag.EXPR().getSymbol().getText();
            System.out.println(text);
        }
    }
}
