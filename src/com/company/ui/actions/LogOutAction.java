package com.company.ui.actions;

import com.company.dao.config.AppSecurity;
import com.company.ui.ServiceLocator;

import java.io.IOException;

public class LogOutAction implements Action {
    private AppSecurity appSecurity;

    public LogOutAction(AppSecurity appSecurity) {
        this.appSecurity = appSecurity;
    }

    @Override
    public String getName() {
        return "logOut";
    }

    @Override
    public String getDescription() {
        return "log out system";
    }

    @Override
    public void execute() throws IOException {
        appSecurity.logOut();
    }
}
