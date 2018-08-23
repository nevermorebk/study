package com.homedirect.study.services.impl;

import com.homedirect.study.util.ScanUtils;

import static com.homedirect.study.commom.ConfigConstant.*;

public class AbstracService {

    protected boolean confirm() {
        System.out.println("Do you want to Continue? (Y/N):");
        String yes = ScanUtils.enterString();
        return YES.equalsIgnoreCase(yes);
    }
}
