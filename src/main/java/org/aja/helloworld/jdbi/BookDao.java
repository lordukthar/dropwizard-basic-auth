package org.aja.helloworld.jdbi;

import org.aja.helloworld.model.Book;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Here I am using both Bind and BindBean to show how. I also include the mapper within this
 * class because is is never used outsude of here.
 *
 */
@RegisterMapper(BookDao.Mapper.class)
public interface BookDao {

    @SqlUpdate("insert into BOOK (TITLE, PUBLISHED, BOOK_ID) values " +
            "(:title, :published, :id)")
    void insert(@BindBean Book book);

    @SqlUpdate("update BOOK set TITLE = :title, PUBLISHED = :published where BOOK_ID = :id")
    void update(@BindBean Book book);

    @SqlUpdate("delete from BOOK where BOOK_ID = :bookId")
    void delete(@Bind("bookId") Integer bookId);

    @SqlQuery("select * from BOOK where BOOK_ID = :bookId")
    Book read(@Bind("bookId") Integer bookId);

    @SqlQuery("select * from BOOK")
    List<Book> readAll();

    class Mapper implements ResultSetMapper<Book> {

    public Book map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Book(
                r.getString("TITLE"),
                r.getString("PUBLISHED"),
                r.getInt("BOOK_ID"));
    }
}}


