package com.example.departmentservice.departmentCodeGenerator;


import lombok.extern.log4j.Log4j2;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j2
public class DepartmentIDGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object o) throws HibernateException {
        String prefix = "APS-";
        String suffix = "";
        Connection connection = session.connection();
        log.info("Connection is established");
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select count(department_id) as code from department_table");
            if (rs.next()) {
                int id = rs.getInt(1);
                suffix = String.valueOf(id);
                log.info("Suffix is {}", suffix);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        log.info("generated id is {}", (prefix + suffix));
        return prefix + suffix;
    }
}
