package dev.kaichun.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//this class is to pull data from database
//Spring Data MongoDB提供了一个@Repository注解来标识MongoDB数据访问层的Repository类。
//这些Repository类用于在Spring应用程序中执行与MongoDB数据库的交互操作，如保存、更新、删除和查询数据。\
//@Repository注解告诉Spring框架将这些类作为组件进行管理，并在需要时将它们注入到其他组件中，从而方便地访问MongoDB数据库。通过在Repository接口中定义方法签名

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
//    look up by imdbId avoid exploring ObjectId and revise the method in MovieService class.
    Optional<Movie> findMovieByImdbId(String imdbid);

}
