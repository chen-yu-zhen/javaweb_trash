package dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author cyz
 * @create 2020-10-17 10:54
 */
public abstract class BaseDao {
    //使用dbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update用来执行update,insert,delete语句
     * @return -1表示执行失败，其他表示操作行数
     */
    public int update(String sql,Object ... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.update(conn,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return -1;
    }

    /**
     * 查询一个返回javaBean的sql语句
     * @param type 返回对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数值
     * @return
     */
    public <T>T queryForOne(Class<T> type,String sql,Object ... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /**
     * 返回查询多个javaBean的sql语句
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T>List<T> queryForList(Class<T> type,String sql,Object ... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql,Object ... args){
        Connection conn  = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }
}
