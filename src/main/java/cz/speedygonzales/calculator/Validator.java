package cz.speedygonzales.calculator;

import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Validator {

    private String inputFilePath;

    @Getter
    private List<String> data;

    public Validator(String inputFilePath) throws ValidationException {
        this.inputFilePath = inputFilePath;
        validate();
    }

    private void validate() throws ValidationException {

        if(inputFilePath == null || inputFilePath.isEmpty()) {
            throw new ValidationException("Specify input file.");
        }



        try {
            Path inputFilePath = Paths.get(this.inputFilePath);
            if(!Files.exists(inputFilePath) || Files.isRegularFile(inputFilePath) || Files.size(inputFilePath) == 0) {
                throw new ValidationException("Input file can't be read or is empty.");
            }

            data = Files.readAllLines(inputFilePath);
        } catch (IOException e) {
            new ValidationException("Unable to read input data lines.");
        }
    }
}
