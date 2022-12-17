package tdtu.edu.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import tdtu.edu.demo.entity.User;

public interface PagingAndSortingUserRepo extends PagingAndSortingRepository<User, Integer>{

}
