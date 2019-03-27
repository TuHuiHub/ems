package wo.bsys.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import wo.bsys.po.Role;

/**
 * 实体Role基于spring-data的DAO接口.
 * @author 
 */
public interface RoleRepository extends PagingAndSortingRepository<Role, java.lang.String>{
	
	Page<Role> findAllBynameLike(java.lang.String searchContent, Pageable pageInput);

	int deleteByIdIn(String[] id);
}
