package edu.tju.scs.tinynetbackend.common;

public class RecordInfo {
    private String name;
    private String owner;
    private Runtime runtime;
    private Process process;

    public Runtime getRuntime() {

        return runtime;
    }

    public void setRuntime(Runtime runtime) {
        this.runtime = runtime;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public  RecordInfo(String name, String owner)
    {
        this.name=name;
        this.owner=owner;
        runtime=null;
        process=null;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
