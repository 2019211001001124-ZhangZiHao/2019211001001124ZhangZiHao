package com.ZhangZihao.dao;

public class toSQLs {

    String SQLString;

    toSQLs(){
        SQLString = "";
    }
    toSQLs(String SQLString){
        this.SQLString = SQLString;
    }

    public static String SQLs(String s)
    {
        if(s==null)
            return null;
        return "\'"+s+ "\'";
    }

    @Override
    public String toString(){
        if(SQLString==null)
            return null;
        return "\'"+SQLString+ "\'";
    }

}
