package com.github.jhonnymertz.Calibre.wrapper.configurations;

import com.github.jhonnymertz.Calibre.wrapper.params.Param;
import com.github.jhonnymertz.Calibre.wrapper.params.Params;

import java.util.ArrayList;
import java.util.List;

public class XvfbConfig {

    private String command;
    private final Params params = new Params();

    public XvfbConfig() {
        this("xvfb-run");
    }

    public XvfbConfig(String command) {
        setCommand(command);
    }

    public void addParams(Param param, Param... params) {
        this.params.add(param, params);
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public List<String> getCommandLine() {
        List<String> commandLine = new ArrayList<String>();

        commandLine.add(getCommand());
        commandLine.addAll(params.getParamsAsStringList());

        return commandLine;
    }

}
