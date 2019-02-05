package com.company.ui.actions;

import java.io.IOException;

public interface Action {
    String getName();
    String getDescription();
    void execute() throws IOException;
}
