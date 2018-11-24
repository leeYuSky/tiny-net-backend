package edu.tju.scs.tinynetbackend.domain;

public class RecordWithBLOBs extends Record {
    private String input;

    private String output;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input == null ? null : input.trim();
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output == null ? null : output.trim();
    }
}