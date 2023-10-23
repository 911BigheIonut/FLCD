package code;

import code.SymbolTable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class Scanner {
    private String program;
    private final List<String> tokens;
    private final List<String> reservedWords;
    private SymbolTable symbolTable;
    private List<KeyValue<String, KeyValue<Integer, Integer>>> PIF;
    private int index = 0;
    private int currentLine = 1;

    public Scanner() {
        this.symbolTable = new SymbolTable(47);
        this.PIF = new ArrayList<>();
        this.reservedWords = new ArrayList<>();
        this.tokens = new ArrayList<>();
//        try {
//           // readTokens();
//            System.out.println("smth");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void setProgram(String program) {
        this.program = program;
    }



    private void skipSpaces() {
        while (index < program.length() && Character.isWhitespace(program.charAt(index))) {
            if (program.charAt(index) == '\n') {
                currentLine++;
            }
            index++;
        }
    }

    private void skipComments() {
        while (index < program.length() && program.charAt(index) == '#') {
            while (index < program.length() && program.charAt(index) != '\n') {
                index++;
            }
        }
    }




}