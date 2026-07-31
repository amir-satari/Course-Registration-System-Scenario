package ir.maktabsharif.repository;

import ir.maktabsharif.model.BaseModel;

import java.util.Optional;

//• Add (save)
//• Update
//• Delete
//• Find By ID
public interface GenericRepository <T extends BaseModel<ID>,ID extends Number>{

    ID save(T t);

    Boolean update(T t);

    void delete(ID id);

    Optional<T> findByID(ID id);

}
