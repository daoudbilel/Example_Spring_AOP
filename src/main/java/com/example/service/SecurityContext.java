package com.example.service;

public class SecurityContext {

    private static String username = "";
    private static String password = "";
    private static String[] roles = {"USER", "ADMIN"};

    public static void authenticate(String u, String p, String[] r) {
        if (u.equals("root") && p.equals("1234")) {
            u = username;
            p = password;
            r = roles;
        } else {
            throw new RuntimeException("Access Denied");
        }
    }

    public static boolean hasRole(String r) {
        for (String role : roles) {
            if (role.equals(r))
                return true;
        }
        return false;
    }


}
