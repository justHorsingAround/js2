package com.codecool.Services;


import com.codecool.Model.Poem;
import com.codecool.Services.Exceptions.IdIsNullException;
import com.codecool.Services.Exceptions.NoPoemFoundException;

import java.util.List;

public interface IPoemService {
    public List<Poem> fetchPoem() throws NoPoemFoundException;
    public void setId(int id);
    public int getId() throws IdIsNullException;

}
