package cz.speedygonzales.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnmappableCharacterException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class SubtitleConversionUtils {

    public static void main(String[] args) throws IOException {

        SubtitleConversionUtils app = new SubtitleConversionUtils();
        app.doConversion();

    }

    private Map<String, String> conversionMap = new HashMap<>();

    public SubtitleConversionUtils() {
        fillConversionMap();
    }

    private void fillConversionMap() {
        conversionMap.put("ì", "ě");
        conversionMap.put("Ø", "Ř");
        conversionMap.put("è", "č");
        conversionMap.put("\u009D", "ť");
        conversionMap.put("ø", "ř");
    }

    private void doConversion() throws IOException {

        List<String> fileContent = readFile("/Users/vondracek/tmp/x.srt");

        List<String> convertSubtitles = convertSubtitles(fileContent);

        Files.write(Paths.get("/Users/vondracek/tmp/x_conv.srt"), convertSubtitles, Charset.forName("Windows-1252"));


    }

    private List<String> convertSubtitles(List<String> fileContent) {
        return fileContent.stream().map(this::convertLine).collect(Collectors.toList());
    }

    private String convertLine(String line) {
        for (Map.Entry<String, String> entry: conversionMap.entrySet()) {
            line = line.replaceAll(entry.getKey(), entry.getKey());
        }

        return line;
    }

    private List<String> readFile(String s) throws IOException {
        List<String> strings = new ArrayList<>();

        try {
           strings  = Files.readAllLines(Paths.get(s));

        } catch (IOException e) {

        }
        return strings;

    }

}
