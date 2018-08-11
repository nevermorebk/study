package com.homedirect.study.service.impl;

import com.homedirect.study.util.ScanUtils;

import static com.homedirect.study.common.ConfigConstant.YES;

public class AbstracService {

    protected boolean confirm() {
        System.out.println("Do you want to Continue? (Y/N):");
        String yes = ScanUtils.getScanner();
        return YES.equalsIgnoreCase(yes);
    }
}
