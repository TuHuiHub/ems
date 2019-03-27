package wo.bsys.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import wo.bsys.po.User;

/**
 * 实体User基于spring-data的DAO接口.
 * @author 
 */
public interface UserRepository extends PagingAndSortingRepository<User, java.lang.String>{
	
	Page<User> findAllByloginNameLike(java.lang.String searchContent, Pageable pageInput);

	int deleteByIdIn(String[] id);

	User findByLoginName(String user);
}
