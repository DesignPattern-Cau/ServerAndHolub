/*  (c) 2004 Allen I. Holub. All rights reserved.
 *
 *  This code may be used freely by yourself with the following
 *  restrictions:
 *
 *  o Your splash screen, about box, or equivalent, must include
 *    Allen Holub's name, copyright, and URL. For example:
 *
 *      This program contains Allen Holub's SQL package.<br>
 *      (c) 2005 Allen I. Holub. All Rights Reserved.<br>
 *              http://www.holub.com<br>
 *
 *    If your program does not run interactively, then the foregoing
 *    notice must appear in your documentation.
 *
 *  o You may not redistribute (or mirror) the source code.
 *
 *  o You must report any bugs that you find to me. Use the form at
 *    http://www.holub.com/company/contact.html or send email to
 *    allen@Holub.com.
 *
 *  o The software is supplied <em>as is</em>. Neither Allen Holub nor
 *    Holub Associates are responsible for any bugs (or any problems
 *    caused by bugs, including lost productivity or data)
 *    in any of this code.
 */
package holub.database.jdbc.adapters;
import java.sql.*;

/***
 * @include /etc/license.txt
 */

public class ResultSetMetaDataAdapter implements ResultSetMetaData
{
public ResultSetMetaDataAdapter(){}
public String getCatalogName(int column) throws SQLException{throw new SQLException("ResultSetMetaData.getCatalogName(int column) not supported");}
public String getColumnClassName(int column) throws SQLException{throw new SQLException("ResultSetMetaData.getColumnClassName(int column) not supported");}
public int getColumnCount()throws SQLException{throw new SQLException("ResultSetMetaData.getColumnCount() not supported");}
public int getColumnDisplaySize(int column)throws SQLException{throw new SQLException("ResultSetMetaData.getColumnDisplaySize(int column) not supported");}
public String getColumnLabel(int column)throws SQLException{throw new SQLException("ResultSetMetaData.getColumnLabel(int column) not supported");}
public String getColumnName(int column)throws SQLException{throw new SQLException("ResultSetMetaData.getColumnName(int column) not supported");}
public int getColumnType(int column)throws SQLException{throw new SQLException("ResultSetMetaData.getColumnType(int column) not supported");}
public String getColumnTypeName(int column)throws SQLException{throw new SQLException("ResultSetMetaData.getColumnTypeName(int column) not supported");}
public int getPrecision(int column)throws SQLException{throw new SQLException("ResultSetMetaData.getPrecision(int column) not supported");}
public int getScale(int column) throws SQLException{throw new SQLException("ResultSetMetaData.getScale(int column) not supported");}
public String getSchemaName(int column)throws SQLException{throw new SQLException("ResultSetMetaData.getSchemaName(int column) not supported");}
public String getTableName(int column)throws SQLException{throw new SQLException("ResultSetMetaData.getTableName(int column) not supported");}
public boolean isAutoIncrement(int column)throws SQLException{throw new SQLException("ResultSetMetaData.isAutoIncrement(int column) not supported");}
public boolean isCaseSensitive(int column)throws SQLException{throw new SQLException("ResultSetMetaData.isCaseSensitive(int column) not supported");}
public boolean isCurrency(int column)throws SQLException{throw new SQLException("ResultSetMetaData.isCurrency(int column) not supported");}
public boolean isDefinitelyWritable(int column)throws SQLException{throw new SQLException("ResultSetMetaData.isDefinitelyWritable(int column) not supported");}
public int isNullable(int column)throws SQLException{throw new SQLException("ResultSetMetaData.isNullable(int column) not supported");}
public boolean isReadOnly(int column)throws SQLException{throw new SQLException("ResultSetMetaData.isReadOnly(int column) not supported");}
public boolean isSearchable(int column)throws SQLException{throw new SQLException("ResultSetMetaData.isSearchable(int column) not supported");}
public boolean isSigned(int column)throws SQLException{throw new SQLException("ResultSetMetaData.isSigned(int column) not supported");}
public boolean isWritable(int column) throws SQLException{throw new SQLException("ResultSetMetaData.isWritable(int column) not supported");}
@Override
public <T> T unwrap(Class<T> iface) throws SQLException {
	// TODO Auto-generated method stub
	return null;
}
@Override
public boolean isWrapperFor(Class<?> iface) throws SQLException {
	// TODO Auto-generated method stub
	return false;
}
}
