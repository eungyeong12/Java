import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InstantiationException,
            IllegalAccessException, FileNotFoundException {
        Connection conn_db = null;
        Connection conn_db_shoppingmall = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        int result;
        final String tbl_member_file = "tbl_member.txt";
        final String tbl_product_file = "tbl_product.txt";
        final String tbl_order_file = "tbl_order.txt";
        final String tbl_cart_file = "tbl_cart.txt";
        final String MySQL_JDBC_driver = "com.mysql.cj.jdbc.Driver";
        final String url_DB = "jdbc:mysql://localhost:3306/";
        final String url_DB_Shoppingmall = "jdbc:mysql://localhost:3306/DB_shoppingmall";
        final String db_shoppingmall_name = "DB_SHOPPINGMALL";
        final String user_name = "root";
        final String passwd = "Dmsruddhrrhrehd78!";
        String sql = null;
        try {
            System.out.println("Loading MySQL's JDBC driver...");
            Class.forName(MySQL_JDBC_driver); // load MySQL's JDBC driver
            System.out.println("Loading MySQL's JDBC driver successfully !!");
            System.out.flush();
            conn_db_shoppingmall = DriverManager.getConnection(url_DB_Shoppingmall, user_name, passwd);
            if (conn_db_shoppingmall != null) {
                System.out.printf("Database (%s) is already existing !!\n", db_shoppingmall_name);
                System.out.printf("Connected to %s\n", url_DB_Shoppingmall);
            }
            else {
                conn_db = DriverManager.getConnection(url_DB, user_name, passwd);
                sql = "CREATE DATABASE " + db_shoppingmall_name;
                result = stmt.executeUpdate(sql);
                System.out.printf("Database (DB_ACADEMIC) created successfully ....\n");
                String url_academicDB = "jdbc:mysql://localhost:3306/" + db_shoppingmall_name;
                conn_db_shoppingmall = DriverManager.getConnection(url_academicDB, user_name, passwd);
                System.out.printf("Connected to %s\n", url_academicDB);
            }
            String tbl_member_name = "tbl_member";
            String tbl_product_name = "tbl_product";
            String tbl_order_name = "tbl_order";
            String tbl_cart_name = "tbl_cart";
            if (tableExistsSQL(conn_db_shoppingmall, tbl_member_name)) {
                System.out.printf("Table (%s) is already existing in Database (%s)\n",
                        tbl_member_name, db_shoppingmall_name);
            } else {
                System.out.printf("Table (%s) is not existing in Database (%s)\n",
                        tbl_member_name, db_shoppingmall_name);
                stmt = conn_db_shoppingmall.createStatement();
                sql = "CREATE TABLE " + tbl_member_name +
                        "(name VARCHAR(45) NOT NULL, " +
                        "contact_point VARCHAR(45) NOT NULL, " +
                        "address VARCHAR(45) NOT NULL, " +
                        "PRIMARY KEY (name)" +
                        ");";
                result = stmt.executeUpdate(sql);
                System.out.printf("Table (%s) is created in Database (%s)\n",
                        tbl_member_name, db_shoppingmall_name);
            }

            if (tableExistsSQL(conn_db_shoppingmall, tbl_product_name)) {
                System.out.printf("Table (%s) is already existing in Database (%s)\n",
                        tbl_product_name, db_shoppingmall_name);
            } else {
                System.out.printf("Table (%s) is not existing in Database (%s)\n",
                        tbl_product_name, db_shoppingmall_name);
                stmt = conn_db_shoppingmall.createStatement();
                sql = "CREATE TABLE " + tbl_product_name +
                        "(product_name VARCHAR(45) NOT NULL, " +
                        "price INT NOT NULL , " +
                        "manufacturer VARCHAR(45) NOT NULL, "  +
                        "PRIMARY KEY (product_name)" +
                        ");";
                result = stmt.executeUpdate(sql);
                System.out.printf("Table (%s) is created in Database (%s)\n",
                        tbl_product_name, db_shoppingmall_name);
            }

            if (tableExistsSQL(conn_db_shoppingmall, tbl_order_name)) {
                System.out.printf("Table (%s) is already existing in Database (%s)\n",
                        tbl_order_name, db_shoppingmall_name);
            } else {
                System.out.printf("Table (%s) is not existing in Database (%s)\n",
                        tbl_order_name, db_shoppingmall_name);
                stmt = conn_db_shoppingmall.createStatement();
                sql = "CREATE TABLE " + tbl_order_name +
                        "(order_number INT NOT NULL , " +
                        "purchaser VARCHAR(45) NOT NULL , " +
                        "item VARCHAR(45) NOT NULL, " + "total_price INT NOT NULL " +
                        "PRIMARY KEY (order_number)," +
                        "INDEX item_idx (item ASC) VISIBLE," +
                        "INDEX purchaser_idx (purchaser ASC) VISIBLE," +
                        "CONSTRAINT item FOREIGN KEY (item) REFERENCES db_shoppingmall.tbl_product (product_name) ON DELETE NO ACTION ON UPDATE NO ACTION, " +
                        "CONSTRAINT purchaser FOREIGN KEY (purchaser) REFERENCES db_shoppingmall.tbl_member (name) ON DELETE NO ACTION ON UPDATE NO ACTION" +
                        ");";
                result = stmt.executeUpdate(sql);
                System.out.printf("Table (%s) is created in Database (%s)\n",
                        tbl_order_name, db_shoppingmall_name);
            }

            if (tableExistsSQL(conn_db_shoppingmall, tbl_cart_name)) {
                System.out.printf("Table (%s) is already existing in Database (%s)\n",
                        tbl_cart_name, db_shoppingmall_name);
            } else {
                System.out.printf("Table (%s) is not existing in Database (%s)\n",
                        tbl_cart_name, db_shoppingmall_name);
                stmt = conn_db_shoppingmall.createStatement();
                sql = "CREATE TABLE " + tbl_cart_name+
                        "(customer VARCHAR(45) NOT NULL, " +
                        "product VARCHAR(45) NULL, " +
                        "PRIMARY KEY (customer), " +
                        "INDEX product_idx (product ASC) VISIBLE, " +
                        "CONSTRAINT customer FOREIGN KEY (customer) REFERENCES db_shoppingmall.tbl_member (name) ON DELETE NO ACTION ON UPDATE NO ACTION, " +
                        "CONSTRAINT product FOREIGN KEY (product) REFERENCES db_shoppingmall.tbl_product (product_name) ON DELETE NO ACTION ON UPDATE NO ACTION " +
                        ");";
                result = stmt.executeUpdate(sql);
                System.out.printf("Table (%s) is created in Database (%s)\n",
                        tbl_cart_name, db_shoppingmall_name);
            }

            fget_and_insert_STData_tbl_member(tbl_member_file, conn_db_shoppingmall, tbl_member_name);
            fget_and_insert_STData_tbl_product(tbl_product_file, conn_db_shoppingmall, tbl_product_name);
            fget_and_insert_STData_tbl_order(tbl_order_file, conn_db_shoppingmall, tbl_order_name);
            fget_and_insert_STData_tbl_cart(tbl_cart_file, conn_db_shoppingmall, tbl_cart_name);
            printStudentTable_tbl_member(conn_db_shoppingmall, tbl_member_name);
            printStudentTable_tbl_product(conn_db_shoppingmall, tbl_product_name);
            printStudentTable_tbl_order(conn_db_shoppingmall, tbl_order_name);
            printStudentTable_tbl_cart(conn_db_shoppingmall, tbl_cart_name);
            if (conn_db_shoppingmall != null)
                conn_db_shoppingmall.close();
            if (conn_db != null)
                conn_db.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Error in loading MySQL's JDBC driver (ClassNotFoundException) !!, error message = " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error in connection to MySQL DB !!, error message =" + e.getMessage());
        }
    }
    static boolean tableExistsSQL(Connection connection, String tableName)
            throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT count(*) "
                        + "FROM information_schema.tables " + "WHERE table_name = ?"
                        + "LIMIT 1;");
        preparedStatement.setString(1, tableName);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1) != 0;
    }
    static void fget_and_insert_STData_tbl_member(String fname, Connection conn_stDB, String tbl_name) throws FileNotFoundException, SQLException {
        Scanner fin = new Scanner(new File(fname));
        while (fin.hasNext()) {
            String name = fin.next();
            String contact_point = fin.next();
            String address = fin.next();
            Statement stmt = conn_stDB.createStatement();
            ResultSet resultSet = null;
            String sql = "INSERT INTO " + tbl_name
                    + " (name, contact_point, address) "
                    + " VALUES (\'%s\', \'%s\', \'%s\')".formatted(name, contact_point, address)
                    + ";";
            System.out.printf("SQL_statement = %s\n", sql);
            boolean result = stmt.execute(sql);
            System.out.printf("Inserted Student(%5s, %15s, %7s,)\n", name, contact_point, address);
        }
        fin.close();
    }

    static void fget_and_insert_STData_tbl_product(String fname, Connection conn_stDB, String tbl_name) throws FileNotFoundException, SQLException {
        Scanner fin = new Scanner(new File(fname));
        while (fin.hasNext()) {
            String product_name = fin.next();
            int price = fin.nextInt();
            String manufacturer = fin.next();
            Statement stmt = conn_stDB.createStatement();
            ResultSet resultSet = null;
            String sql = "INSERT INTO " + tbl_name
                    + " (product_name, price, manufacturer) "
                    + " VALUES (\'%s\', %d, \'%s\')".formatted(product_name, price, manufacturer)
                    + ";";
            System.out.printf("SQL_statement = %s\n", sql);
            boolean result = stmt.execute(sql);
            System.out.printf("Inserted Student(%7s, %8d, %8s,)\n", product_name, price, manufacturer);
        }
        fin.close();
    }
    static void fget_and_insert_STData_tbl_order(String fname, Connection conn_stDB, String tbl_name) throws FileNotFoundException, SQLException {
        Scanner fin = new Scanner(new File(fname));
        while (fin.hasNext()) {
            int order_number = fin.nextInt();
            String purchaser = fin.next();
            String item = fin.next();
            int total_price = fin.nextInt();
            Statement stmt = conn_stDB.createStatement();
            ResultSet resultSet = null;
            String sql = "INSERT INTO " + tbl_name
                    + " (order_number, purchaser, item, total_price) "
                    + " VALUES (%d, \'%s\', \'%s\', %d)".formatted(order_number, purchaser, item, total_price)
                    + ";";
            System.out.printf("SQL_statement = %s\n", sql);
            boolean result = stmt.execute(sql);
            System.out.printf("Inserted Student(%5d, %5s, %7s, %8d,)\n", order_number, purchaser, item, total_price);
        }
        fin.close();
    }

    static void fget_and_insert_STData_tbl_cart(String fname, Connection conn_stDB, String tbl_name) throws FileNotFoundException, SQLException {
        Scanner fin = new Scanner(new File(fname));
        while (fin.hasNext()) {
            String customer = fin.next();
            String product = fin.next();
            Statement stmt = conn_stDB.createStatement();
            ResultSet resultSet = null;
            String sql = "INSERT INTO " + tbl_name
                    + " (customer, product) "
                    + " VALUES (\'%s\', \'%s\')".formatted(customer, product)
                    + ";";
            System.out.printf("SQL_statement = %s\n", sql);
            boolean result = stmt.execute(sql);
            System.out.printf("Inserted Student(%5s, %6s,)\n", customer, product);
        }
        fin.close();
    }

    static void printStudentTable_tbl_member(Connection conn_stDB, String tbl_name) throws SQLException {
        Statement stmt = conn_stDB.createStatement();
        ResultSet resultSet = null;
        String sql = "SELECT * FROM " + tbl_name + ";";
        resultSet = stmt.executeQuery(sql);
        printStudentRecords_tbl_member(resultSet, "name", "contact point", "address"); }
    static void printStudentRecords_tbl_member(ResultSet srs, String col1, String col2,
                                    String col3) throws SQLException{
        String name = null;
        String contact_point = null;
        String address = null;
        System.out.printf("%6s %16s %9s\n", col1, col2, col3);
        while (srs.next()) {
            if (col1 != "") {
                name = new String(srs.getString("name"));
            }
            if (col2 != "") {
                contact_point = new String(srs.getString("contact_point"));
            }
            if (col3 != "") {
                address = new String(srs.getString("address"));
            }
            System.out.printf("%5s %15s %5s\n", name, contact_point, address);
        }
    }

    static void printStudentTable_tbl_product(Connection conn_stDB, String tbl_name) throws SQLException {
        Statement stmt = conn_stDB.createStatement();
        ResultSet resultSet = null;
        String sql = "SELECT * FROM " + tbl_name + ";";
        resultSet = stmt.executeQuery(sql);
        printStudentRecords_tbl_product(resultSet, "product_name", "price", "manufacturer"); }
    static void printStudentRecords_tbl_product(ResultSet srs, String col1, String col2,
                                               String col3) throws SQLException{
        String product_name = null;
        String price = null;
        String manufacturer = null;
        System.out.printf("%5s %7s %16s\n", col1, col2, col3);
        while (srs.next()) {
            if (col1 != "") {
                product_name = new String(srs.getString("product_name"));
            }
            if (col2 != "") {
                price = new String(srs.getString("price"));
            }
            if (col3 != "") {
                manufacturer = new String(srs.getString("manufacturer"));
            }
            System.out.printf("%7s %10s %10s\n", product_name, price, manufacturer);
        }
    }

    static void printStudentTable_tbl_order(Connection conn_stDB, String tbl_name) throws SQLException {
        Statement stmt = conn_stDB.createStatement();
        ResultSet resultSet = null;
        String sql = "SELECT * FROM " + tbl_name + ";";
        resultSet = stmt.executeQuery(sql);
        printStudentRecords_tbl_order(resultSet, "order_number", "purchaser", "item", "total_price"); }
    static void printStudentRecords_tbl_order(ResultSet srs, String col1, String col2,
                                                String col3, String col4) throws SQLException{
        String order_number = null;
        String purchaser = null;
        String item = null;
        String total_price = null;
        System.out.printf("%6s %10s %5s %14s\n", col1, col2, col3, col4);
        while (srs.next()) {
            if (col1 != "") {
                order_number = new String(srs.getString("order_number"));
            }
            if (col2 != "") {
                purchaser = new String(srs.getString("purchaser"));
            }
            if (col3 != "") {
                item = new String(srs.getString("item"));
            }
            if (col4 != "") {
                total_price = new String(srs.getString("total_price"));
            }
            System.out.printf("%6s %11s %7s %10s\n", order_number, purchaser, item, total_price);
        }
    }

    static void printStudentTable_tbl_cart(Connection conn_stDB, String tbl_name) throws SQLException {
        Statement stmt = conn_stDB.createStatement();
        ResultSet resultSet = null;
        String sql = "SELECT * FROM " + tbl_name + ";";
        resultSet = stmt.executeQuery(sql);
        printStudentRecords_tbl_cart(resultSet, "customer", "product"); }
    static void printStudentRecords_tbl_cart(ResultSet srs, String col1, String col2) throws SQLException{
        String customer = null;
        String product = null;
        System.out.printf("%4s %10s\n", col1, col2);
        while (srs.next()) {
            if (col1 != "") {
                customer = new String(srs.getString("customer"));
            }
            if (col2 != "") {
                product = new String(srs.getString("product"));
            }
            System.out.printf("%5s %8s\n", customer, product);
        }
    }

}

