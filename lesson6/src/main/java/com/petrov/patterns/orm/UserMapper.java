package com.petrov.patterns.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserMapper {

    private final Connection conn;

    private final PreparedStatement selectUser;

    private final PreparedStatement insertUser;

    private final PreparedStatement deleteUser;

    private final PreparedStatement updateUser;

    private final Map<Long, User> identityMap = new HashMap<>();

    public UserMapper(Connection conn) {
        this.conn = conn;
        try {
            this.insertUser = conn.prepareStatement("insert into users.users (id, login, password) values (?, ?, ?);");
            this.deleteUser = conn.prepareStatement("delete from users.users where id = ?;");
            this.updateUser = conn.prepareStatement("update users.users set login=?, password=? where id = ?;");
            this.selectUser = conn.prepareStatement("select id, login, password from users.users where id = ?;");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public Optional<User> findById(long id) {
        User user = identityMap.get(id);
        if (user != null) {
            return Optional.of(user);
        }
        try {
            selectUser.setLong(1, id);
            ResultSet rs = selectUser.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
                identityMap.put(id, user);
                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return Optional.empty();
    }

    public void deleteUser(User user) {
        if (identityMap.get(user.getId()) != null) {
            identityMap.remove(user.getId());
        }
        try {
            deleteUser.setLong(1, user.getId());
            deleteUser.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertUser(User user) {
        identityMap.putIfAbsent(user.getId(), user);
        try {
            insertUser.setLong(1, user.getId());
            insertUser.setString(2, user.getLogin());
            insertUser.setString(3, user.getPassword());
            insertUser.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        if (identityMap.get(user.getId()) != null) {
            identityMap.get(user.getId()).setLogin(user.getLogin());
            identityMap.get(user.getId()).setPassword(user.getPassword());
        }
        try {
            updateUser.setLong(3, user.getId());
            updateUser.setString(1, user.getLogin());
            updateUser.setString(2, user.getPassword());
            updateUser.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
