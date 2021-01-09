package com.adam.calcite;

import org.apache.calcite.rel.type.DynamicRecordType;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.SqlNodeList;
import org.apache.calcite.sql.SqlSelect;
import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.sql.type.SqlTypeName;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SqlParseException {
        System.out.println( "Hello World!" );
        final String sql = "select foo, bar, day1 from (select foo,bar,day1 from tb2 where f=1 union all select foo,bar,day1 from tb3) tb0 where day1>='2020-03-10' and day1<'2020-03-18' group by foo, bar";
        SqlParser parser = SqlParser.create(sql);
        final SqlNode sqlNode = parser.parseStmt();

        SqlTypeName sqlTypeName ;

        SqlSelect selectNode = (SqlSelect) parser.parseQuery(sql);
        SqlNodeList list = selectNode.getSelectList();
        SqlNode fromTable = selectNode.getFrom();
        SqlNode where = selectNode.getWhere();
        System.out.println("Column:" + list.get(0).toString().toLowerCase() + " Table: " + fromTable.toString().toLowerCase());
    }
}
