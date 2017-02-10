package app.controller;

import java.io.Serializable;

public class Option implements Serializable {

    private String option;

    public Option() {};

    public Option(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
