package com.kristellar.shadow_trace.backend.helpers;

import java.security.Principal;

public class Helper {
    public static String getEmailOfLoggedInUser(Principal principal){
        String name = principal.getName();
        return name;
    }
}
