package com.company.ui.actions;

import com.company.model.User;

import java.io.IOException;

public interface AuthAction {
    String getName();
    String getDescription();
    User execute() throws IOException;
}
