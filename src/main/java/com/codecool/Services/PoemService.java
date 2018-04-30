package com.codecool.Services;

import com.codecool.Dao.IPoemDao;
import com.codecool.Dao.PoemDao;
import com.codecool.Model.Poem;
import com.codecool.Services.Exceptions.IdIsNullException;
import com.codecool.Services.Exceptions.NoPoemFoundException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PoemService implements IPoemService {
    private IPoemDao poemDao;
    private Integer id = null;

    public PoemService(Connection connection) {
        poemDao = new PoemDao(connection);
    }

    public int getId() throws IdIsNullException {
        if(id != null){
            return id;
        }
        else {
            throw new IdIsNullException("Id must be set at first with the setId(int id) method");
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Poem> fetchPoem() throws NoPoemFoundException {
        System.out.println("in fetchPoem");
        List<Poem> poems;
        try {
            if (id == null){
                poems = poemDao.findAllPoems();
            }
            else {
                poems = poemDao.findPoemsTitleByUserId(id);
            }

            if (poems.size() == 0){
                throw new NoPoemFoundException("No poem found");
            }
            else {
                System.out.println("poems" + poems);
                return poems;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        throw new NoPoemFoundException("An unknown error has occured");
    }

}
